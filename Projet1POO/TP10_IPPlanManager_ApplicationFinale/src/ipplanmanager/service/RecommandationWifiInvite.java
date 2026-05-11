/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager.service;

import ipplanmanager.model.Recommandation;
import ipplanmanager.model.VLAN;

/**
 *
 * @author aquil
 */
public class RecommandationWifiInvite implements RegleRecommandation {
    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getNom().toUpperCase().contains("WIFI")) {
            return new Recommandation("Isolation du WiFi", "ELEVEE", "Le VLAN " + vlan.getNom() + " doit etre isole desVLANs internes sensibles. " ); 
} 
return null;
    }
}
