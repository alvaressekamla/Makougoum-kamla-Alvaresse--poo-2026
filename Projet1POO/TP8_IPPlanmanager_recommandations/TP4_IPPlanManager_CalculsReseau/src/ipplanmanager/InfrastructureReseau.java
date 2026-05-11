package ipplanmanager;

import java.util.ArrayList;

public class InfrastructureReseau {

    private String                 nom;
    private ArrayList<SousReseau> listeSousReseaux;

    public InfrastructureReseau(String nom) {
        this.nom              = nom;
        this.listeSousReseaux = new ArrayList<>();
    }

    public void ajouterSousReseau(SousReseau sr) {
        listeSousReseaux.add(sr);
    }

    public void afficher() {
        System.out.println("==============================");
        System.out.println("Infrastructure : " + nom);
        System.out.println("==============================");
        for (SousReseau sr : listeSousReseaux) {
            sr.afficher();
        }
    }
}