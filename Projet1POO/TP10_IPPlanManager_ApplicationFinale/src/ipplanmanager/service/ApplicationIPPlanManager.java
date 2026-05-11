/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author ALVARESSE
 */
import ipplanmanager.console.ConsoleService;
import ipplanmanager.exception.AdresseIPInvalideException;
import ipplanmanager.exception.ChevauchementReseauException;
import ipplanmanager.exception.ConflitVLANException;
import ipplanmanager.model.BesoinReseau;
import ipplanmanager.model.Recommandation;
import ipplanmanager.model.ResultatVLSM;
import ipplanmanager.model.VLAN;
import ipplanmanager.repository.BesoinRepository;
import ipplanmanager.repository.FichierPlanRepository;
import java.io.IOException;
import java.util.ArrayList;

public class ApplicationIPPlanManager {

    private ConsoleService console;
    private MoteurVLSM moteurVLSM;
    private GestionnaireVLAN gestionnaireVLAN;
    private ValidateurPlanAdressage validateur;
    private MoteurRecommandation moteurRecommandation;
    private FichierPlanRepository fichierRepository;
    private RapportService rapportService;
    private BesoinRepository besoinRepository;

    public ApplicationIPPlanManager() {
        // Initialisation de tous les services
        this.console = new ConsoleService();
        this.moteurVLSM = new MoteurVLSM();
        this.gestionnaireVLAN = new GestionnaireVLAN();
        this.validateur = new ValidateurPlanAdressage();
        this.moteurRecommandation = new MoteurRecommandation();
        this.fichierRepository = new FichierPlanRepository();
        this.rapportService = new RapportService();
        this.besoinRepository = new BesoinRepository();
        
        // Ajout des règles de recommandation
        moteurRecommandation.ajouterRegle(new RecommandationWifiInvite());
        moteurRecommandation.ajouterRegle(new RecommandationServeurs());
        moteurRecommandation.ajouterRegle(new RecommandationGrandVLAN());
    }

  public void demarrer() {
    boolean continuer = true;
    
    while (continuer) {
        console.afficherMenuComplet();
        int choix = console.saisirEntier("Choix : ");
        
        if (choix == 1) {
            executerGenerationComplete();
        } else if (choix == 2) {
            executerDepuisFichier();
        } else if (choix == 3) {
            continuer = false;
            System.out.println("Au revoir !");
        } else {
            System.out.println("Choix invalide. Veuillez réessayer.");
        }
    }
}

private void executerDepuisFichier() {
    try {
        System.out.println("\n=== CHARGEMENT DEPUIS FICHIER CSV ===");
        
        String chemin = console.saisirTexte("Chemin du fichier CSV (ex: exports/besoins.csv) : ");
        String nomProjet = console.saisirTexte("Nom du projet : ");
        String adresseDepart = console.saisirTexte("Adresse réseau de départ : ");
        
        // Charger les besoins depuis le fichier
        ArrayList<BesoinReseau> besoins = besoinRepository.chargerBesoins(chemin);
        
        System.out.println("\nBesoins chargés : " + besoins.size() + " besoins trouvés");
        for (BesoinReseau b : besoins) {
            System.out.println("  - " + b.getNom() + " : " + b.getNombreHotes() + " hôtes");
        }
        
        // Générer le plan VLSM
        ArrayList<ResultatVLSM> resultats = moteurVLSM.genererPlan(adresseDepart, besoins);
        
        // Valider le plan
        validateur.verifierAdresses(resultats);
        validateur.verifierChevauchements(resultats);
        validateur.afficherValidationReussie();
        
        // Créer les VLANs
        genererVLANs(resultats);
        
        // Générer les recommandations
        ArrayList<Recommandation> recommandations = moteurRecommandation.analyserVLANs(gestionnaireVLAN.getVlans());
        
        // Afficher les résultats
        afficherResultats(resultats, recommandations);
        
        // Sauvegarder
        sauvegarderResultats(nomProjet, besoins, resultats, recommandations);
        
        System.out.println("\nTraitement terminé avec succès !");
        
    } catch (IOException e) {
        System.out.println("Erreur de fichier : " + e.getMessage());
    } catch (AdresseIPInvalideException e) {
        System.out.println("Erreur d'adresse IP : " + e.getMessage());
    } catch (ChevauchementReseauException e) {
        System.out.println("Erreur de chevauchement : " + e.getMessage());
    } catch (ConflitVLANException e) {
        System.out.println("Erreur VLAN : " + e.getMessage());
    }
}

    private void executerGenerationComplete() {
        try {
            System.out.println("\n=== NOUVELLE GENERATION ===");
            
            // Saisie du nom du projet
            String nomProjet = console.saisirTexte("Nom du projet reseau : ");
            
            // Saisie de l'adresse réseau de départ
            String adresseDepart = console.saisirTexte("Adresse reseau de depart : ");
            
            // Saisie des besoins
            ArrayList<BesoinReseau> besoins = console.saisirBesoins();
            
            // Générer le plan VLSM
            ArrayList<ResultatVLSM> resultats = moteurVLSM.genererPlan(adresseDepart, besoins);
            
            // Valider le plan (vérifier les chevauchements et adresses)
            validateur.verifierAdresses(resultats);
            validateur.verifierChevauchements(resultats);
            validateur.afficherValidationReussie();
            
            // Créer les VLANs
            genererVLANs(resultats);
            
            // Générer les recommandations
            ArrayList<Recommandation> recommandations = moteurRecommandation.analyserVLANs(gestionnaireVLAN.getVlans());
            
            // Afficher les résultats
            afficherResultats(resultats, recommandations);
            
            // Sauvegarder les résultats
            sauvegarderResultats(nomProjet, besoins, resultats, recommandations);
            
            System.out.println("\nTraitement terminé avec succes !");
            System.out.println("Fichiers generes dans le dossier exports/");
            
        } catch (AdresseIPInvalideException e) {
            System.out.println("Erreur d'adresse IP : " + e.getMessage());
        } catch (ChevauchementReseauException e) {
            System.out.println("Erreur de chevauchement : " + e.getMessage());
        } catch (ConflitVLANException e) {
            System.out.println("Erreur VLAN : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erreur de fichier : " + e.getMessage());
        }
    }

    private void genererVLANs(ArrayList<ResultatVLSM> resultats) throws ConflitVLANException {
        int numeroVLAN = 10;
        for (ResultatVLSM resultat : resultats) {
            VLAN vlan = new VLAN(numeroVLAN, resultat.getNomBesoin(), 
                                resultat, "VLAN_" + resultat.getNomBesoin());
            gestionnaireVLAN.ajouterVLAN(vlan);
            numeroVLAN += 10;
        }
        System.out.println("\n" + gestionnaireVLAN.getVlans().size() + " VLANs crees.");
    }
    
    private void afficherResultats(ArrayList<ResultatVLSM> resultats, 
                                   ArrayList<Recommandation> recommandations) {
        System.out.println("\n=== PLAN D'ADRESSAGE PROPOSE ===");
        for (ResultatVLSM resultat : resultats) {
            resultat.afficher();
        }
        
        System.out.println("\n=== RECOMMANDATIONS TECHNIQUES ===");
        if (recommandations.isEmpty()) {
            System.out.println("Aucune recommandation particulière.");
        } else {
            for (Recommandation rec : recommandations) {
                rec.afficher();
            }
        }
    }

    private void sauvegarderResultats(String nomProjet,
            ArrayList<BesoinReseau> besoins,
            ArrayList<ResultatVLSM> resultats,
            ArrayList<Recommandation> recommandations) throws IOException {
        
        // Nettoyer le nom du projet pour les noms de fichiers
        String nomFichier = nomProjet.replace(" ", "_");
        
        // Chemins des fichiers
        String cheminPlan = "exports/" + nomFichier + "_plan.csv";
        String cheminVlans = "exports/" + nomFichier + "_vlans.csv";
        String cheminRecommandations = "exports/" + nomFichier + "_recommandations.txt";
        String cheminRapport = "exports/" + nomFichier + "_rapport.txt";
        
        // Sauvegarder les fichiers
        fichierRepository.sauvegarderPlanCSV(resultats, cheminPlan);
        fichierRepository.sauvegarderVLANsCSV(gestionnaireVLAN.getVlans(), cheminVlans);
        fichierRepository.sauvegarderRecommandations(recommandations, cheminRecommandations);
        rapportService.genererRapportComplet(besoins, resultats, 
                                            gestionnaireVLAN.getVlans(), 
                                            recommandations, cheminRapport);
        
        System.out.println("\nFichiers sauvegardés :");
        System.out.println("- " + cheminPlan);
        System.out.println("- " + cheminVlans);
        System.out.println("- " + cheminRecommandations);
        System.out.println("- " + cheminRapport);
    }
}