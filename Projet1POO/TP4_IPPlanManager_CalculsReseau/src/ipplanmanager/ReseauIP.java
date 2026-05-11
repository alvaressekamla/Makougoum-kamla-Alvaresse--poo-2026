package ipplanmanager;

public class ReseauIP {

    private String adresseReseau;
    private int    masqueCidr;
    private String description;

    public ReseauIP(String adresseReseau, int masqueCidr, String description) {
        this.adresseReseau = adresseReseau;
        this.masqueCidr    = masqueCidr;
        this.description   = description;
    }

    // Getters
    public String getAdresseReseau() { return adresseReseau; }
    public int    getMasqueCidr()    { return masqueCidr; }
    public String getDescription()   { return description; }

    // Affichage enrichi avec calculs automatiques
    public void afficher() {
        System.out.println("Reseau : " + adresseReseau + "/" + masqueCidr);
        System.out.println("Description : " + description);
        System.out.println("Classe reseau : "
                + CalculateurReseau.obtenirClasseReseau(adresseReseau));
        System.out.println("Masque decimal : "
                + CalculateurReseau.obtenirMasqueDecimal(masqueCidr));
        System.out.println("Capacite maximale : "
                + CalculateurReseau.calculerNombreHotes(masqueCidr)
                + " hotes");
        System.out.println("Reseau prive : "
                + CalculateurReseau.estReseauPrive(adresseReseau));
        System.out.println("----------------------------");
    }
}