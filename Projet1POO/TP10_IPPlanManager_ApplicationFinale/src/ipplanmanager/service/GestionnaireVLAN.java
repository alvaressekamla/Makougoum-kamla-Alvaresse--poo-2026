/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

/**
 *
 * @author ALVARESSE
 */
import ipplanmanager.exception.ConflitVLANException;
import ipplanmanager.model.VLAN;
import java.util.ArrayList;
public class GestionnaireVLAN {
    
     
    public ArrayList<VLAN> getVlans() {
        return vlans;
    }

    private ArrayList<VLAN> vlans;

    public GestionnaireVLAN() {
        vlans = new ArrayList<>();
    }

    public void ajouterVLAN(VLAN vlan) throws ConflitVLANException {

        if (vlan == null) {
            return;
        }

        for (VLAN v : vlans) {

            if (v.getId() == vlan.getId()) {

                throw new ConflitVLANException(
                        "Conflit VLAN : l'identifiant "
                        + vlan.getId()
                        + " est dejà utilise."
                );
            }
        }

        vlans.add(vlan);
    }
    public void afficherTousLesVLANs() { 
        for (VLAN vlan : vlans) { 
            vlan.afficher(); 
            System.out.println(); 
        } 
    } 
    public VLAN rechercherVLAN(int id) { 
        for (VLAN vlan : vlans) { 
            if (vlan.getId() == id) { 
                return vlan; 
            } 
        } 
        return null; 
    } 
    public int obtenirNombreVLANs() { 
        return vlans.size(); 
    }
//AJOUT D'UNE METHODE POUR LES VLANS CRITIQUES
   public void afficherVLANsCritiques() {

    for (VLAN vlan : vlans) {

        if (vlan.getReseauAssocie().getCapacite() > 100) {

            System.out.println("VLAN critique detecte :");

            System.out.println(
                    "VLAN " + vlan.getId()
                    + " - " + vlan.getNom()
                    + " - "
                    + vlan.getReseauAssocie().getCapacite()
                    + " hotes"
            );
        }
    }
}
}
