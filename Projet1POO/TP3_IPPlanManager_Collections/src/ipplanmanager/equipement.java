package ipplanmanager;

import java.util.ArrayList;

public class Equipement {

    private String nom;
    private String type;
    private ArrayList<InterfaceReseau> interfaces;

    public Equipement(String nom, String type) {
        this.nom = (nom == null || nom.isEmpty()) ? "equipement" : nom;
        this.type = (type == null || type.isEmpty()) ? "type" : type;
        this.interfaces = new ArrayList<>();
    }

    public String getNom() {
        return nom;
    }

    public String getType() {
        return type;
    }

    public void ajouterInterface(InterfaceReseau i) {
        if (i != null) interfaces.add(i);
    }

    public void afficher() {
        System.out.println("=== Equipement ===");
        System.out.println("Nom : " + nom);
        System.out.println("Type : " + type);
        System.out.println("Interfaces : " + interfaces.size());

        for (InterfaceReseau i : interfaces) {
            i.afficher();
            System.out.println();
        }
    }
}