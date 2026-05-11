package ipplanmanager;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== TP2 : Encapsulation =====");

        // ---- Adresses IP ----
        AdresseIP ip1 = new AdresseIP("192.168.1.1");
        AdresseIP ip2 = new AdresseIP("");        // cas invalide
        AdresseIP ip3 = new AdresseIP(null);      // cas invalide
        AdresseIP ip4 = new AdresseIP("10.0.0.1");
        AdresseIP ip5 = new AdresseIP("172.16.0.1");

        // ---- Test estAdresseLocale() ----
        System.out.println();
        System.out.println("----- Test estAdresseLocale -----");
        System.out.println(ip1.getValeur() + " est locale : " + ip1.estAdresseLocale());
        System.out.println(ip4.getValeur() + " est locale : " + ip4.estAdresseLocale());
        System.out.println(ip5.getValeur() + " est locale : " + ip5.estAdresseLocale());

        // ---- Interfaces réseau ----
        InterfaceReseau interface1 = new InterfaceReseau("eth0", ip1);
        InterfaceReseau interface2 = new InterfaceReseau("", ip2);   // nom invalide
        InterfaceReseau interface3 = new InterfaceReseau("eth1", ip4);
        InterfaceReseau interface4 = new InterfaceReseau("wlan0", ip5);

        interface1.activer();
        interface3.activer();

        // ---- Equipements ----
        equipement routeur = new equipement("R1_EDGE", "Routeur", interface1);
        equipement serveur = new equipement("", "", interface2);      // nom et type invalides
        equipement switch1 = new equipement("SW1_CORE", "Switch", interface3);
        equipement firewall = new equipement("FW1", "Firewall", interface4);
        equipement pc = new equipement("PC_Bureau", "Terminal", null); // sans interface

        // ---- Réseaux IP ----
        ReseauIP reseau1 = new ReseauIP("192.168.1.0", 24, "Réseau principal");
        ReseauIP reseau2 = new ReseauIP("", 55, "");       // tout invalide
        ReseauIP reseau3 = new ReseauIP("10.0.0.0", 8, "Réseau entreprise");
        ReseauIP reseau4 = new ReseauIP("172.16.0.0", -1, "Réseau DMZ"); // masque invalide

        // ---- Affichage réseaux ----
        System.out.println();
        System.out.println("----- Réseau 1 -----");
        reseau1.afficher();

        System.out.println();
        System.out.println("----- Réseau 2 (invalide) -----");
        reseau2.afficher();

        System.out.println();
        System.out.println("----- Réseau 3 -----");
        reseau3.afficher();

        System.out.println();
        System.out.println("----- Réseau 4 (masque invalide) -----");
        reseau4.afficher();

        // ---- Affichage équipements ----
        System.out.println();
        System.out.println("----- equipement 1 : Routeur -----");
        routeur.afficher();

        System.out.println();
        System.out.println("----- equipement 2 : Serveur (invalide) -----");
        serveur.afficher();

        System.out.println();
        System.out.println("----- equipement 3 : Switch -----");
        switch1.afficher();

        System.out.println();
        System.out.println("----- equipement 4 : Firewall -----");
        firewall.afficher();

        System.out.println();
        System.out.println("----- equipement 5 : PC (sans interface) -----");
        pc.afficher();

        // ---- Test des setters ----
        System.out.println();
        System.out.println("----- Test modification avec setters -----");

        ip1.setValeur("192.168.100.1");
        System.out.println("Nouvelle valeur ip1 : " + ip1.getValeur());

        ip2.setValeur("");   // invalide
        System.out.println("Valeur ip2 après setter invalide : " + ip2.getValeur());

        routeur.setNom("R1_UPDATED");
        System.out.println("Nouveau nom routeur : " + routeur.getNom());

        reseau1.setMasqueCidr(99);   // invalide
        System.out.println("Masque reseau1 après setter invalide : " + reseau1.getMasqueCidr());

        reseau3.setDescription("");   // invalide
        System.out.println("Description reseau3 après setter invalide : " + reseau3.getDescription());

        interface1.desactiver();
        System.out.println("Interface1 active : " + interface1.isActive());

        interface2.activer();
        System.out.println("Interface2 active : " + interface2.isActive());
    }
}