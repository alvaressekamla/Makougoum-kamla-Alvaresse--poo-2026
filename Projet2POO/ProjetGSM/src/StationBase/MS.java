/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationBase;

/**
 *
 * @author MAKOUGOUM KAMLA ALVARESSE
 */

    /**
 * Classe MS (Mobile Station)
 * Représente un utilisateur final du réseau GSM.
 * Un MS peut être un smartphone, tablet ou autre.
 * Implémente Affichable pour afficher ses caractéristiques.
 */
public class MS implements Affichable {

    // ─── Attributs ───────────────────────────────────────────────
    private String nom;
    private String prenom;
    private String motDePasse;
    private String numeroTelephone;   // MSISDN
    private String numeroCarte;       // IMSI
    private String typeAppareil;      // smartphone, tablet, autre...
    private String[] appelsRecus;
    private int nbAppels;

    // ─── Constructeur ────────────────────────────────────────────
    public MS(String nom, String prenom, String motDePasse,
              String numeroTelephone, String numeroCarte, String typeAppareil) {
        this.nom             = nom;
        this.prenom          = prenom;
        this.motDePasse      = motDePasse;
        this.numeroTelephone = numeroTelephone;
        this.numeroCarte     = numeroCarte;
        this.typeAppareil    = typeAppareil;
        this.appelsRecus     = new String[100];
        this.nbAppels        = 0;
    }

    // ─── Getters / Setters ───────────────────────────────────────
    public String getNom()              { return nom; }
    public String getPrenom()           { return prenom; }
    public String getNumeroTelephone()  { return numeroTelephone; }
    public String getNumeroCarte()      { return numeroCarte; }
    public String getTypeAppareil()     { return typeAppareil; }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }

    // ─── Méthodes ────────────────────────────────────────────────

    /**
     * Affiche les caractéristiques de l'utilisateur.
     */
    @Override
    public void afficherInfos() {
        System.out.println("=== Informations MS ===");
        System.out.println("Nom          : " + nom);
        System.out.println("Prénom       : " + prenom);
        System.out.println("MSISDN       : " + numeroTelephone);
        System.out.println("IMSI         : " + numeroCarte);
        System.out.println("Type appareil: " + typeAppareil);
        System.out.println("Appels reçus : " + nbAppels);
        System.out.println("=======================");
    }

    /**
     * Vérifie si l'utilisateur peut s'attacher à un BTS
     * (BTS non saturé et mot de passe correct).
     */
    public boolean peutSattacherA(BTS bts, String mdp) throws ReseauException {
        if (!this.motDePasse.equals(mdp)) {
            throw new ReseauException("Mot de passe incorrect pour " + nom + " " + prenom);
        }
        if (bts.estSature()) {
            throw new ReseauException("BTS " + bts.getNumero() + " est saturé, attachement impossible.");
        }
        return true;
    }

    /**
     * Appelle un autre utilisateur et enregistre le numéro appelé.
     */
    public void appeler(MS destinataire) {
        System.out.println(nom + " " + prenom + " appelle " +
                destinataire.getNom() + " " + destinataire.getPrenom() +
                " (" + destinataire.getNumeroTelephone() + ")");
        destinataire.recevoirAppel(this.numeroTelephone);
    }

    /**
     * Reçoit un appel entrant et l'enregistre dans le tableau.
     */
    public void recevoirAppel(String numeroAppelant) {
        if (nbAppels < appelsRecus.length) {
            appelsRecus[nbAppels++] = numeroAppelant;
            System.out.println("[" + nom + "] Appel reçu de : " + numeroAppelant);
        } else {
            System.out.println("[" + nom + "] Boîte vocale pleine, appel manqué de : " + numeroAppelant);
        }
    }

    /**
     * Affiche les informations des appels reçus.
     */
    public void afficherAppelsRecus() {
        System.out.println("--- Appels reçus par " + nom + " " + prenom + " ---");
        if (nbAppels == 0) {
            System.out.println("Aucun appel reçu.");
        } else {
            for (int i = 0; i < nbAppels; i++) {
                System.out.println("  [" + (i + 1) + "] " + appelsRecus[i]);
            }
        }
    }

    @Override
    public String toString() {
        return nom + " " + prenom + " | MSISDN: " + numeroTelephone + " | IMSI: " + numeroCarte;
    }
}


