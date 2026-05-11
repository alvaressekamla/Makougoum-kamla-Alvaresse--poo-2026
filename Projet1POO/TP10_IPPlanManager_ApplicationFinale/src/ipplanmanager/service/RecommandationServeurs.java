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
public class RecommandationServeurs implements RegleRecommandation {

    @Override
    public Recommandation analyser(VLAN vlan) {
        if (vlan.getNom().toUpperCase().contains("SERVEUR")) {
            return new Recommandation(  "Protection du VLAN Serveurs", "ELEVEE", "Le VLAN " + vlan.getNom() + " doit etre protege par des ACL et surveille en priorite" ); 
        } 
return null;
    }
}
