package ipplanmanager;

public class SousReseau {

    private String nom;
    private ReseauIP reseau;

    public SousReseau(String nom, ReseauIP reseau) {
        this.nom = (nom == null || nom.isEmpty()) ? "Sous-reseau" : nom;
        this.reseau = reseau;
    }

    public void afficher() {
        System.out.println("Sous-réseau : " + nom);
        if (reseau != null) reseau.afficher();
    }
}