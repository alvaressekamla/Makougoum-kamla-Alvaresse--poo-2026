/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MAKOUGOUM KAMLA ALVARESSE
 */
public class TestReseau {

    public static void main(String[] args) {
        // Création d'un exemple d'abonné
        MS monMobile = new MS("Alvaresse", "Etudiante", "Pass123", "670000000", "62401-SIM");

        // Utilisation de la méthode d'affichage
        monMobile.afficherCaracteristiques();

        // Test de la capacité de connexion
        if(monMobile.peutSattacher()) {
            System.out.println("Statut : Prêt à se connecter au réseau GSM.");
        }
    }
}   

    

