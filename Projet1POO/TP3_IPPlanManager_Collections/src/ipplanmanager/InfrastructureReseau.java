package ipplanmanager;

import java.util.ArrayList;

public class InfrastructureReseau {

    private String nom;
    private ArrayList<Equipement> equipements;
    private ArrayList<SousReseau> sousReseaux;

    public InfrastructureReseau(String nom) {
        this.nom = nom;
        this.equipements = new ArrayList<>();
        this.sousReseaux = new ArrayList<>();
    }

    public void ajouterEquipement(Equipement e) {
        if (e != null) equipements.add(e);
    }

    public void ajouterSousReseau(SousReseau s) {
        if (s != null) sousReseaux.add(s);
    }

    public void rechercherEquipement(String nom) {
        for (Equipement e : equipements) {
            if (e.getNom().equalsIgnoreCase(nom)) {
                System.out.println("✔ Trouvé : " + nom);
                e.afficher();
                return;
            }
        }
        System.out.println("❌ Equipement introuvable : " + nom);
    }

    public void afficher() {

        System.out.println("\n===== INFRASTRUCTURE : " + nom + " =====\n");

        System.out.println(">>> SOUS-RÉSEAUX");
        for (SousReseau s : sousReseaux) {
            s.afficher();
            System.out.println();
        }

        System.out.println(">>> ÉQUIPEMENTS");
        for (Equipement e : equipements) {
            e.afficher();
            System.out.println();
        }
    }
}