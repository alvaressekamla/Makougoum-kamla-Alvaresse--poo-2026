/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MAKOUGOUM KAMLA ALVARESSE
 */
import java.util.ArrayList;
        
public class Reseau {
 // 1. ATTRIBUTS (Caractéristiques demandées par l'énoncé) [cite: 17]
    
    private String nom;
    private String bandeUplink;
    private String bandeDownlink;
    private String typeAcces; // Exemple: TDMA/FDMA
    private double debitMax;
    
    // Le tableau pour stocker toutes les BTS du réseau 
    private ArrayList<BTS> listeBTS;

    // 2. CONSTRUCTEUR [cite: 29]
    public Reseau(String nom, String uplink, String downlink, String acces) {
        this.nom = nom;
        this.bandeUplink = uplink;
        this.bandeDownlink = downlink;
        this.typeAcces = acces;
        this.listeBTS = new ArrayList<>(); // On initialise la liste vide
    }

    // 3. LES MÉTHODES (Les actions du réseau) [cite: 19]

    // Ajouter une BTS au réseau
    public void ajouterBTS(BTS nouvelleBTS) {
        listeBTS.add(nouvelleBTS);
        System.out.println("BTS ajoutée au réseau " + nom);
    }

    // Calculer le nombre total de BTS
    public int calculerNombreBTS() {
        return listeBTS.size();
    }

    // Afficher les performances et informations du réseau [cite: 19]
    public void afficherPerformances() {
        System.out.println("===== PERFORMANCES RÉSEAU " + nom + " =====");
        System.out.println("Accès : " + typeAcces);
        System.out.println("Fréquences : UL " + bandeUplink + " / DL " + bandeDownlink);
        System.out.println("Nombre total de stations (BTS) : " + calculerNombreBTS());
        System.out.println("===========================================");
    }
}
