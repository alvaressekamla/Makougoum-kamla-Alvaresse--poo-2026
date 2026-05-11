package ipplanmanager;

public class SousReseau {

    private String   nom;
    private ReseauIP reseau;

    public SousReseau(String nom, ReseauIP reseau) {
        this.nom    = nom;
        this.reseau = reseau;
    }

    public String   getNom()    { return nom; }
    public ReseauIP getReseau() { return reseau; }

    public void afficher() {
        System.out.println("== Sous-reseau : " + nom + " ==");
        reseau.afficher();
    }
}