package ipplanmanager;

public class Main {

    public static void main(String[] args) {

        InfrastructureReseau infra = new InfrastructureReseau("Campus IUT");

        // Réseaux
        ReseauIP r1 = new ReseauIP("192.168.1.0", 24, "Admin");
        ReseauIP r2 = new ReseauIP("192.168.2.0", 24, "Technique");
        ReseauIP r3 = new ReseauIP("192.168.3.0", 24, "WiFi");

        infra.ajouterSousReseau(new SousReseau("ADMIN", r1));
        infra.ajouterSousReseau(new SousReseau("TECH", r2));
        infra.ajouterSousReseau(new SousReseau("WIFI", r3));

        // Equipements
        Equipement routeur = new Equipement("R1", "Routeur");
        Equipement switch1 = new Equipement("SW1", "Switch");
        Equipement serveur = new Equipement("SRV1", "Serveur");

        // Interfaces
        routeur.ajouterInterface(new InterfaceReseau("eth0", new AdresseIP("192.168.1.1")));
        routeur.ajouterInterface(new InterfaceReseau("eth1", new AdresseIP("192.168.2.1")));

        switch1.ajouterInterface(new InterfaceReseau("eth0", new AdresseIP("192.168.2.10")));

        serveur.ajouterInterface(new InterfaceReseau("eth0", new AdresseIP("192.168.3.10")));

        infra.ajouterEquipement(routeur);
        infra.ajouterEquipement(switch1);
        infra.ajouterEquipement(serveur);

        // Affichage global
        infra.afficher();

        // Recherche
        infra.rechercherEquipement("SW1");
        infra.rechercherEquipement("ServeurX");
    }
}