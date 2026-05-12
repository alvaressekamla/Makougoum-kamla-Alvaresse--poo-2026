/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MAKOUGOUM KAMLA ALVARESSE
 */

 public class MS {
     // 1. LES ATTRIBUTS (Caractéristiques demandées dans l'énoncé) [cite: 22, 29]
    private String nom;
    private String prenom;
    private String motDePasse;
    private String msisdn; // Numéro de téléphone (ex: 677...)
    private String imsi;   // Identifiant de la carte SIM

    // 2. LE CONSTRUCTEUR (Pour créer un utilisateur avec ses données) 
    public MS(String nom, String prenom, String motDePasse, String msisdn, String imsi) {
        this.nom = nom;
        this.prenom = prenom;
        this.motDePasse = motDePasse;
        this.msisdn = msisdn;
        this.imsi = imsi;
    }

    // 3. LES GETTERS (Pour lire les informations de manière sécurisée)
    public String getNom() { return nom; }
    public String getPrenom() { return prenom; }
    public String getMsisdn() { return msisdn; }
    public String getImsi() { return imsi; }

    // 4. LES SETTERS (Pour modifier les informations, comme le mot de passe)
    public void setMotDePasse(String nouveauMdp) {
        this.motDePasse = nouveauMdp;
    }

    // 5. MÉTHODE D'AFFICHAGE (Affiche les caractéristiques de l'utilisateur) 
    public void afficherCaracteristiques() {
        System.out.println("========= PROFIL UTILISATEUR MS =========");
        System.out.println("Propriétaire : " + this.prenom + " " + this.nom);
        System.out.println("Numéro MSISDN : " + this.msisdn);
        System.out.println("Identifiant SIM (IMSI) : " + this.imsi);
        System.out.println("==========================================");
    }

    /**
     * Méthode pour vérifier si l'utilisateur peut s'attacher à une BTS.
     * Pour ce début, on vérifie simplement si les informations sont valides. 
     */
    public boolean peutSattacher() {
        return (msisdn != null && !msisdn.isEmpty() && imsi != null);
    }
}