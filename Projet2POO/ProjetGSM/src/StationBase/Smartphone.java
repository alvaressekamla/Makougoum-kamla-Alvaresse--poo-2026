/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package StationBase;

/**
 *
 * @author MAKOUGOUM
 */
    /**
 * Classe Smartphone – sous-classe de MS (Héritage + Polymorphisme)
 * Un Smartphone possède des fonctionnalités supplémentaires :
 * système d'exploitation et capacité appareil photo.
 */
public class Smartphone extends MS {

    private String systemExploitation;
    private int megaPixels;

    public Smartphone(String nom, String prenom, String motDePasse,
                      String numeroTelephone, String numeroCarte,
                      String systemExploitation, int megaPixels) {
        super(nom, prenom, motDePasse, numeroTelephone, numeroCarte, "Smartphone");
        this.systemExploitation = systemExploitation;
        this.megaPixels         = megaPixels;
    }

    public String getSystemExploitation() { return systemExploitation; }
    public int getMegaPixels()            { return megaPixels; }

    /**
     * Surcharge polymorphique de afficherInfos().
     */
    @Override
    public void afficherInfos() {
        super.afficherInfos();
        System.out.println("  OS          : " + systemExploitation);
        System.out.println("  Caméra      : " + megaPixels + " MP");
    }
}

    

