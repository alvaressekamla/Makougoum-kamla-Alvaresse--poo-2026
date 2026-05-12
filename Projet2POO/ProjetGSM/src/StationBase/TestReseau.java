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
 * Classe TestReseau
 * Teste toutes les classes du mini-projet Réseau GSM.
 * Couvre : création, ajout, suppression, recherche, exceptions, héritage, polymorphisme.
 */
public class TestReseau {

    public static void main(String[] args) {

        System.out.println("");
        System.out.println("║       TESTS - MINI PROJET RÉSEAU GSM           ║");
        System.out.println("\n");

        // ── TEST 1 : Création du réseau ───────────────────────────────────
        System.out.println("TEST 1 : Création du Réseau ");
        Reseau reseau = new Reseau("Orange-CM", 890.0, 935.0, "TDMA",
                                   50.0, 150.0, 30, 10);
        reseau.afficherInfos();

        // ── TEST 2 : Création des BTS ─────────────────────────────────────
        System.out.println("\n TEST 2 : Création des BTS");
        BTS bts1 = new BTS(1, "Bafoussam Centre", 30.0, "urbain", 5.0, 40.0, 3);
        BTS bts2 = new BTS(2, "Bafoussam Ouest",  25.0, "rural",  8.0, 20.0, 2);
        BTS bts3 = new BTS(3, "Douala Port",      35.0, "urbain", 4.0, 50.0, 2);

        bts1.afficherInfos();
        bts2.afficherInfos();

        // ── TEST 3 : Ajout de BTS au réseau ──────────────────────────────
        System.out.println("\n TEST 3 : Ajout de BTS au réseau ");
        try {
            reseau.ajouterBTS(bts1);
            reseau.ajouterBTS(bts2);
            reseau.ajouterBTS(bts3);
            System.out.println("Toutes les BTS ajoutées avec succès.");
        } catch (ReseauException e) {
            System.out.println("ERREUR : " + e.getMessage());
        }

        // ── TEST 4 : Création des MS ──────────────────────────────────────
        System.out.println("\n TEST 4 : Création des MS ");
        MS ms1 = new MS("Kamga", "Jean", "pass123", "677001001", "237001", "smartphone");
        MS ms2 = new MS("Nkoa",  "Marie","azerty",  "677002002", "237002", "tablet");
        MS ms3 = new MS("Fopa",  "Paul", "1234",    "677003003", "237003", "smartphone");

        // Héritage : création d'un Smartphone
        Smartphone sm = new Smartphone("Tchoua", "Alice", "secur3!",
                                       "677004004", "237004", "Android 14", 108);

        ms1.afficherInfos();
        sm.afficherInfos();   // Polymorphisme : méthode surchargée

        // ── TEST 5 : Ajout de MS dans BTS ────────────────────────────────
        System.out.println("\n TEST 5 : Attachement MS aux BTS ");
        try {
            bts1.ajouterMS(ms1);
            bts1.ajouterMS(ms2);
            bts1.ajouterMS(ms3);
            bts2.ajouterMS(sm);
            System.out.println("MS attachés avec succès.");
        } catch (ReseauException e) {
            System.out.println("ERREUR : " + e.getMessage());
        }

        // ── TEST 6 : Saturation de BTS (Exception attendue) ───────────────
        System.out.println("\n TEST 6 : Test Saturation BTS ");
        MS msExtra = new MS("Extra", "User", "pwd", "677005005", "237005", "tablet");
        try {
            bts1.ajouterMS(msExtra);  // bts1 est pleine (max=3)
        } catch (ReseauException e) {
            System.out.println("Exception gérée correctement : " + e.getMessage());
        }
        System.out.println("BTS1 saturée ? " + bts1.estSature());

        // ── TEST 7 : Recherche de MS dans BTS ────────────────────────────
        System.out.println("\n TEST 7 : Recherche de MS ");
        MS trouve = bts1.rechercherMS("677002002");
        if (trouve != null) {
            System.out.println("MS trouvé : " + trouve);
        } else {
            System.out.println("MS non trouvé.");
        }
        MS notFound = bts1.rechercherMS("000000000");
        System.out.println("Recherche inexistant : " + (notFound == null ? "null (correct)" : notFound));

        // ── TEST 8 : Appels entre MS ──────────────────────────────────────
        System.out.println("\nTEST 8 : Appels entre MS ");
        ms1.appeler(ms2);
        ms1.appeler(sm);
        ms2.afficherAppelsRecus();
        sm.afficherAppelsRecus();

        // ── TEST 9 : Attachement avec mot de passe ────────────────────────
        System.out.println("\n TEST 9 : Vérification attachement ");
        try {
            boolean ok = ms1.peutSattacherA(bts2, "pass123");
            System.out.println("ms1 peut s'attacher à bts2 : " + ok);
        } catch (ReseauException e) {
            System.out.println("ERREUR : " + e.getMessage());
        }
        // Mauvais mot de passe
        try {
            ms1.peutSattacherA(bts2, "mauvais_mdp");
        } catch (ReseauException e) {
            System.out.println("Exception mdp incorrect : " + e.getMessage());
        }

        // ── TEST 10 : Suppression de MS dans BTS ─────────────────────────
        System.out.println("\nTEST 10 : Suppression de MS ");
        try {
            bts1.supprimerMS("677002002");
            System.out.println("Après suppression BTS1 : " + bts1.getNbUtilisateurs() + " MS restant(s).");
        } catch (ReseauException e) {
            System.out.println("ERREUR : " + e.getMessage());
        }
        // Suppression inexistant
        try {
            bts1.supprimerMS("000000000");
        } catch (ReseauException e) {
            System.out.println("Exception suppression : " + e.getMessage());
        }

        // ── TEST 11 : Calculs réseau ──────────────────────────────────────
        System.out.println("\nTEST 11 : Calculs réseau ");
        System.out.println("Nb BTS urbaines   : " + reseau.calculerNbBTS("urbain"));
        System.out.println("Nb BTS rurales    : " + reseau.calculerNbBTS("rural"));
        System.out.println("Total abonnés     : " + reseau.calculerNbAbonnes());

        // ── TEST 12 : Localisation d'un utilisateur ───────────────────────
        System.out.println("\nTEST 12 : Localisation utilisateur ");
        BTS loc = reseau.rechercherLocalisationUtilisateur("677001001");
        if (loc != null) {
            System.out.println("ms1 (677001001) localisé dans : " + loc);
        }
        BTS locNull = reseau.rechercherLocalisationUtilisateur("999999999");
        System.out.println("Localisation inconnue : " + (locNull == null ? "null (correct)" : locNull));

        // ── TEST 13 : Performances réseau ─────────────────────────────────
        System.out.println("\n TEST 13 : Performances réseau");
        reseau.afficherPerformances();

        // ── TEST 14 : Suppression BTS ─────────────────────────────────────
        System.out.println("\n TEST 14 : Suppression BTS ");
        try {
            reseau.supprimerBTS(3);
            System.out.println("Après suppression : " + reseau.getNbBTS() + " BTS restante(s).");
        } catch (ReseauException e) {
            System.out.println("ERREUR : " + e.getMessage());
        }
        try {
            reseau.supprimerBTS(99); // BTS inexistante
        } catch (ReseauException e) {
            System.out.println("Exception BTS inexistante : " + e.getMessage());
        }

        // ── TEST 15 : Affichage complet réseau ────────────────────────────
        System.out.println("\nTEST 15 : État final du réseau ");
        reseau.afficherInfos();

        System.out.println("\n");
        System.out.println("║        TOUS LES TESTS TERMINÉS AVEC SUCCES     ║");
        System.out.println("");
    }
}
   
    

