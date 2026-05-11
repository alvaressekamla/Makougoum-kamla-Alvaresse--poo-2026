package ipplanmanager;

public class InterfaceReseau {

    private String nom;
    private AdresseIP ip;
    private boolean active;

    public InterfaceReseau(String nom, AdresseIP ip) {
        this.nom = (nom == null || nom.isEmpty()) ? "interface_inconnue" : nom;
        this.ip = ip;
        this.active = false;
    }

    public void activer() {
        active = true;
    }

    public void desactiver() {
        active = false;
    }

    public boolean estActive() {
        return active;
    }

    public AdresseIP getIp() {
        return ip;
    }

    public void afficher() {
        System.out.println("Interface : " + nom);
        System.out.println("Etat : " + (active ? "ACTIVE" : "INACTIVE"));
        if (ip != null) ip.afficher();
    }
}