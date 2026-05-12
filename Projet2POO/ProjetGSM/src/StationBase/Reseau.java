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
 * Classe Reseau (Reseau GSM)
 * Gère la transmission entre MS et le réseau 4G.
 * Contient un tableau de BTS.
 * Implémente Affichable.
 */
public class Reseau implements Affichable {

    // ─── Attributs ───────────────────────────────────────────────
    private String nom;
    private double bandeFrequenceUplink;   // MHz
    private double bandeFrequenceDownlink; // MHz
    private String typeAcces;             // TDMA, FDMA, CDMA...
    private double debitMaxUplink;        // Mbps
    private double debitMaxDownlink;      // Mbps
    private int    maxDelai;              // ms
    private BTS[]  tableauBTS;
    private int    nbBTS;

    // ─── Constructeur ────────────────────────────────────────────
    public Reseau(String nom, double bandeFréquenceUplink, double bandeFréquenceDownlink,
                  String typeAcces, double debitMaxUplink, double debitMaxDownlink,
                  int maxDelai, int capaciteMax) {
        this.nom                    = nom;
        this.bandeFrequenceUplink   = bandeFréquenceUplink;
        this.bandeFrequenceDownlink = bandeFréquenceDownlink;
        this.typeAcces              = typeAcces;
        this.debitMaxUplink         = debitMaxUplink;
        this.debitMaxDownlink       = debitMaxDownlink;
        this.maxDelai               = maxDelai;
        this.tableauBTS             = new BTS[capaciteMax];
        this.nbBTS                  = 0;
    }

    // ─── Getters ─────────────────────────────────────────────────
    public String getNom()          { return nom; }
    public int    getNbBTS()        { return nbBTS; }
    public double getDebitUplink()  { return debitMaxUplink; }
    public double getDebitDownlink(){ return debitMaxDownlink; }

    // ─── Méthodes CRUD BTS ───────────────────────────────────────

    /**
     * Ajoute une BTS au réseau.
     */
    public void ajouterBTS(BTS bts) throws ReseauException {
        if (nbBTS >= tableauBTS.length) {
            throw new ReseauException("Réseau " + nom + " : capacité maximale de BTS atteinte.");
        }
        tableauBTS[nbBTS++] = bts;
        System.out.println("[Réseau " + nom + "] BTS " + bts.getNumero() + " ajoutée.");
    }

    /**
     * Supprime une BTS par son numéro.
     */
    public boolean supprimerBTS(int numeroBTS) throws ReseauException {
        for (int i = 0; i < nbBTS; i++) {
            if (tableauBTS[i].getNumero() == numeroBTS) {
                System.out.println("[Réseau " + nom + "] BTS " + numeroBTS + " supprimée.");
                for (int j = i; j < nbBTS - 1; j++) {
                    tableauBTS[j] = tableauBTS[j + 1];
                }
                tableauBTS[--nbBTS] = null;
                return true;
            }
        }
        throw new ReseauException("BTS " + numeroBTS + " introuvable dans le réseau " + nom);
    }

    /**
     * Recherche une BTS par son numéro.
     */
    public BTS rechercherBTS(int numeroBTS) {
        for (int i = 0; i < nbBTS; i++) {
            if (tableauBTS[i].getNumero() == numeroBTS) {
                return tableauBTS[i];
            }
        }
        return null;
    }

    // ─── Méthodes de calcul ──────────────────────────────────────

    /**
     * Calcule le nombre de BTS selon un critère de type de milieu.
     */
    public int calculerNbBTS(String typeMilieu) {
        int count = 0;
        for (int i = 0; i < nbBTS; i++) {
            if (tableauBTS[i].getTypeMilieu().equalsIgnoreCase(typeMilieu)) {
                count++;
            }
        }
        return count;
    }

    /**
     * Calcule le nombre total d'abonnés inscrits dans tout le réseau.
     */
    public int calculerNbAbonnes() {
        int total = 0;
        for (int i = 0; i < nbBTS; i++) {
            total += tableauBTS[i].getNbUtilisateurs();
        }
        return total;
    }

    /**
     * Recherche la BTS où est localisé un MS (par numéro de téléphone).
     */
    public BTS rechercherLocalisationUtilisateur(String numeroTelephone) {
        for (int i = 0; i < nbBTS; i++) {
            if (tableauBTS[i].rechercherMS(numeroTelephone) != null) {
                return tableauBTS[i];
            }
        }
        return null;
    }

    /**
     * Affiche les performances du réseau.
     */
    public void afficherPerformances() {
        System.out.println("=== Performances du réseau : " + nom + " ===");
        System.out.println("Debit max Uplink   : " + debitMaxUplink + " Mbps");
        System.out.println("Debit max Downlink : " + debitMaxDownlink + " Mbps");
        System.out.println("Delai max          : " + maxDelai + " ms");
        System.out.println("Nombre de BTS      : " + nbBTS);
        System.out.println("Total abonnes      : " + calculerNbAbonnes());
        int satureCount = 0;
        for (int i = 0; i < nbBTS; i++) {
            if (tableauBTS[i].estSature()) satureCount++;
        }
        System.out.println("BTS saturées       : " + satureCount + " / " + nbBTS);
        System.out.println("");
    }

    /**
     * Affiche toutes les informations du réseau et de ses BTS.
     */
    @Override
    public void afficherInfos() {
        System.out.println("");
        System.out.println("║  RESEAU : " + nom);
        System.out.println("");
        System.out.println("  Frequence Uplink   : " + bandeFrequenceUplink + " MHz");
        System.out.println("  Frequence Downlink : " + bandeFrequenceDownlink + " MHz");
        System.out.println("  Type d'acces       : " + typeAcces);
        System.out.println("  Débit max UL       : " + debitMaxUplink + " Mbps");
        System.out.println("  Debit max DL       : " + debitMaxDownlink + " Mbps");
        System.out.println("  Delai max          : " + maxDelai + " ms");
        System.out.println("  Nombre de BTS      : " + nbBTS);
        System.out.println("");
        System.out.println("  Liste des BTS :");
        for (int i = 0; i < nbBTS; i++) {
            System.out.println("    " + tableauBTS[i]);
        }
        System.out.println("");
    }

    @Override
    public String toString() {
        return "Reseau[" + nom + "] | BTS: " + nbBTS + " | Abonnes: " + calculerNbAbonnes();
    }
}

