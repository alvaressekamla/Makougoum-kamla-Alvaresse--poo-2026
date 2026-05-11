package ipplanmanager;

public class Main {

    public static void main(String[] args) {

        // === Infrastructure principale ===
        InfrastructureReseau infrastructure =
                new InfrastructureReseau("Infrastructure YFY ALVARESSE");

        // Réseaux du TP
        ReseauIP reseauAdmin = new ReseauIP("192.168.1.0", 24, "Reseau Administration");
        ReseauIP reseauTech  = new ReseauIP("172.16.0.0",  16, "Reseau Technique");
        ReseauIP reseauWifi  = new ReseauIP("10.0.0.0",    8,  "Reseau WiFi ");

        // Réseaux supplémentaires (différents CIDR)
        ReseauIP reseauVoip  = new ReseauIP("192.168.10.0",  26, "Reseau VoIP");
        ReseauIP reseauDmz   = new ReseauIP("192.168.20.128", 27, "Reseau DMZ");
        ReseauIP reseauCameras = new ReseauIP("172.16.50.0",  25, "Reseau Cameras");
        ReseauIP reseauPublic = new ReseauIP("203.0.113.0",  28, "Reseau Public (test)");

        // Création des sous-réseaux
        SousReseau admin   = new SousReseau("ADMIN",   reseauAdmin);
        SousReseau tech    = new SousReseau("TECH",    reseauTech);
        SousReseau wifi    = new SousReseau("WIFI",    reseauWifi);
        SousReseau voip    = new SousReseau("VOIP",    reseauVoip);
        SousReseau dmz     = new SousReseau("DMZ",     reseauDmz);
        SousReseau cameras = new SousReseau("CAMERAS", reseauCameras);
        SousReseau pub     = new SousReseau("PUBLIC",  reseauPublic);

        // Ajout à l'infrastructure
        infrastructure.ajouterSousReseau(admin);
        infrastructure.ajouterSousReseau(tech);
        infrastructure.ajouterSousReseau(wifi);
        infrastructure.ajouterSousReseau(voip);
        infrastructure.ajouterSousReseau(dmz);
        infrastructure.ajouterSousReseau(cameras);
        infrastructure.ajouterSousReseau(pub);

        infrastructure.afficher();

        // === Tests directs de CalculateurReseau ===
        System.out.println("\n=== TESTS DIRECTS ===");
        System.out.println("Hotes /8  : "  + CalculateurReseau.calculerNombreHotes(8));
        System.out.println("Hotes /16 : "  + CalculateurReseau.calculerNombreHotes(16));
        System.out.println("Hotes /24 : "  + CalculateurReseau.calculerNombreHotes(24));
        System.out.println("Hotes /26 : "  + CalculateurReseau.calculerNombreHotes(26));
        System.out.println("Hotes /28 : "  + CalculateurReseau.calculerNombreHotes(28));
        System.out.println("Prive 10.0.0.1     : " + CalculateurReseau.estReseauPrive("10.0.0.1"));
        System.out.println("Prive 172.20.0.1   : " + CalculateurReseau.estReseauPrive("172.20.0.1"));
        System.out.println("Prive 203.0.113.5  : " + CalculateurReseau.estReseauPrive("203.0.113.5"));
    }
}