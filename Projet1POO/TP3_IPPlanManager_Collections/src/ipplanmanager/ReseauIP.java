package ipplanmanager;

public class ReseauIP {

    private String adresseReseau;
    private int masque;
    private String description;

    public ReseauIP(String adresseReseau, int masque, String description) {
        this.adresseReseau = adresseReseau;
        this.masque = (masque >= 0 && masque <= 32) ? masque : 24;
        this.description = (description == null) ? "reseau" : description;
    }

    public String getAdresseReseau() {
        return adresseReseau;
    }

    public int getMasque() {
        return masque;
    }

    public String getDescription() {
        return description;
    }

    public void afficher() {
        System.out.println("Réseau : " + adresseReseau + "/" + masque);
        System.out.println("Description : " + description);
    }
}