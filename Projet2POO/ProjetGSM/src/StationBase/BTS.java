/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationBase;

/**
 *
 * @author MAKOUGOUM
 */

 /**
 * Classe BTS (Base Transceiver Station)
 * Contrôle une cellule du réseau GSM.
 * Une BTS peut gérer plusieurs cellules (plusieurs MS).
 * Implémente Affichable.
 */
public class BTS implements Affichable {

    // ─── Attributs ───────────────────────────────────────────────
    private int    numero;
    private String emplacement;
    private double hauteur;           // en mètres
    private String typeMilieu;        // "urbain" ou "rural"
    private double rayonCouverture;   // en km
    private double puissanceEmission; // en Watts
    private int    nbMaxUtilisateurs;
    private MS[]   utilisateurs;
    private int    nbUtilisateurs;

    // ─── Constructeur ────────────────────────────────────────────
    public BTS(int numero, String emplacement, double hauteur,
               String typeMilieu, double rayonCouverture,
               double puissanceEmission, int nbMaxUtilisateurs) {
        this.numero             = numero;
        this.emplacement        = emplacement;
        this.hauteur            = hauteur;
        this.typeMilieu         = typeMilieu;
        this.rayonCouverture    = rayonCouverture;
        this.puissanceEmission  = puissanceEmission;
        this.nbMaxUtilisateurs  = nbMaxUtilisateurs;
        this.utilisateurs       = new MS[nbMaxUtilisateurs];
        this.nbUtilisateurs     = 0;
    }

    // ─── Getters ─────────────────────────────────────────────────
    public int    getNumero()             { return numero; }
    public String getEmplacement()        { return emplacement; }
    public double getHauteur()            { return hauteur; }
    public String getTypeMilieu()         { return typeMilieu; }
    public double getRayonCouverture()    { return rayonCouverture; }
    public double getPuissanceEmission()  { return puissanceEmission; }
    public int    getNbMaxUtilisateurs()  { return nbMaxUtilisateurs; }
    public int    getNbUtilisateurs()     { return nbUtilisateurs; }

    // ─── Méthodes ────────────────────────────────────────────────

    /**
     * Vérifie si la BTS est saturée (nombre max d'utilisateurs atteint).
     */
    public boolean estSature() {
        return nbUtilisateurs >= nbMaxUtilisateurs;
    }

    /**
     * Ajoute un MS à cette BTS.
     */
    public boolean ajouterMS(MS ms) throws ReseauException {
        if (estSature()) {
            throw new ReseauException("BTS " + numero + " saturée, impossible d'ajouter " + ms.getNom());
        }
        // Vérifier si déjà attaché
        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroTelephone().equals(ms.getNumeroTelephone())) {
                throw new ReseauException("MS " + ms.getNom() + " déjà attaché à la BTS " + numero);
            }
        }
        utilisateurs[nbUtilisateurs++] = ms;
        System.out.println("[BTS " + numero + "] MS " + ms.getNom() + " " + ms.getPrenom() + " attaché.");
        return true;
    }

    /**
     * Supprime un MS de cette BTS selon son numéro de téléphone.
     */
    public boolean supprimerMS(String numeroTelephone) throws ReseauException {
        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroTelephone().equals(numeroTelephone)) {
                System.out.println("[BTS " + numero + "] MS " + utilisateurs[i].getNom() + " détaché.");
                // Décaler le tableau
                for (int j = i; j < nbUtilisateurs - 1; j++) {
                    utilisateurs[j] = utilisateurs[j + 1];
                }
                utilisateurs[--nbUtilisateurs] = null;
                return true;
            }
        }
        throw new ReseauException("MS avec numéro " + numeroTelephone + " non trouvé dans BTS " + numero);
    }

    /**
     * Recherche un MS par son numéro de téléphone.
     */
    public MS rechercherMS(String numeroTelephone) {
        for (int i = 0; i < nbUtilisateurs; i++) {
            if (utilisateurs[i].getNumeroTelephone().equals(numeroTelephone)) {
                return utilisateurs[i];
            }
        }
        return null;
    }

    /**
     * Affiche toutes les informations de la BTS et ses MS.
     */
    @Override
    public void afficherInfos() {
        System.out.println("=== BTS N° " + numero + " ===");
        System.out.println("Emplacement       : " + emplacement);
        System.out.println("Hauteur           : " + hauteur + " m");
        System.out.println("Type de milieu    : " + typeMilieu);
        System.out.println("Rayon couverture  : " + rayonCouverture + " km");
        System.out.println("Puissance émission: " + puissanceEmission + " W");
        System.out.println("Utilisateurs      : " + nbUtilisateurs + " / " + nbMaxUtilisateurs);
        System.out.println("État cellule      : " + (estSature() ? "SATURÉE" : "Disponible"));
        System.out.println("--- MS attachés ---");
        if (nbUtilisateurs == 0) {
            System.out.println("  Aucun MS attaché.");
        } else {
            for (int i = 0; i < nbUtilisateurs; i++) {
                System.out.println("  " + (i + 1) + ". " + utilisateurs[i]);
            }
        }
        System.out.println("========================");
    }

    @Override
    public String toString() {
        return "BTS[" + numero + "] @" + emplacement + " (" + typeMilieu + ") | " +
               nbUtilisateurs + "/" + nbMaxUtilisateurs + " MS";
    }
}
   

