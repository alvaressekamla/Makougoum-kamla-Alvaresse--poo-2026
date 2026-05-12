/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MAKOUGOUM KAMLA ALVARESSE
 */
import java.util.ArrayList;

   public class BTS {
       
    // Les Attributs (Caractéristiques de l'antenne)
    private int numero;
    private String emplacement;
    private String milieu; // Urbain ou Rural
    private int nbMaxUtilisateurs;
   //
   private ArrayList<MS> listeAbonnes; // Tableau pour attacher les MS 

    // Le Constructeur (La "commande" pour installer une nouvelle BTS)
    public BTS(int numero, String emplacement, String milieu, int nbMax) {
        this.numero = numero;
        this.emplacement = emplacement;
        this.milieu = milieu;
        this.nbMaxUtilisateurs = nbMax;
        this.listeAbonnes = new ArrayList<>(); // On prépare la liste vide
    }

    // LA COMMANDE : Ajouter un utilisateur (MS) 
    public void ajouterMS(MS mobile) {
        if (listeAbonnes.size() < nbMaxUtilisateurs) {
            listeAbonnes.add(mobile);
            System.out.println("Succès : Le mobile " + mobile.getMsisdn() + " est connecté à la BTS " + numero);
        } else {
            System.out.println("Alerte : La cellule de la BTS " + numero + " est saturée !");
        }
    }

    // LA COMMANDE : Afficher l'état de la BTS 
    public void afficherEtat() {
        System.out.println("BTS n°" + numero + " située à " + emplacement);
        System.out.println("Type de milieu : " + milieu);
        System.out.println("Nombre d'abonnés : " + listeAbonnes.size() + "/" + nbMaxUtilisateurs);
    }
}