/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipplanmanager;

/**
 *
 * @author USER
 */
public class Main {
    public static void main(String[] args) { 
System.out.println("===== IPPlan-Manager : TP1 ====="); 
System.out.println("Découverte des premières classes du projet"); 
System.out.println(); 
AdresseIP ipRouteur = new AdresseIP("192.168.1.1"); 
AdresseIP ipServeur = new AdresseIP("192.168.1.10"); 
AdresseIP ipClient = new AdresseIP("192.168.1.50"); 
// Adresse ip du switch
AdresseIP ipSwitch =new AdresseIP("192.168.56.1");
// Adresse ip du point d'access
AdresseIP ipaccesspoint =new AdresseIP("192.168.56.2");
//adresse ip poste client supplementaire
AdresseIP ippostesupplementaire =new AdresseIP("192.168.56.3");
//adresse ip interface inactive
AdresseIP ipinterfaceinactive =new AdresseIP("192.168.10.1");
//interface du switch
InterfaceReseau interfaceSwitch= new InterfaceReseau("eth0", ipSwitch); 
//Interface du point d'access
InterfaceReseau interfaceaccesspoint= new InterfaceReseau("fastethernet", ipaccesspoint);
// interface poste supplementaire
InterfaceReseau interfacepostesupplementaire = new InterfaceReseau("eth1", 
ippostesupplementaire); 
//interface de l'interface inactive
InterfaceReseau interfaceinactive= new InterfaceReseau("fastethernet1/2", 
ipinterfaceinactive); 
InterfaceReseau interfaceRouteur = new InterfaceReseau("eth0", 
ipRouteur); 
InterfaceReseau interfaceServeur = new InterfaceReseau("eth0", 
ipServeur); 
InterfaceReseau interfaceClient = new InterfaceReseau("wlan0", 
ipClient); 
interfaceRouteur.activer(); 
interfaceServeur.activer(); 
// equipement switch
Equipement Switch = new Equipement("R1_EDGE", "switch", interfaceSwitch);
//equipement point d'access
Equipement accesspoint= new Equipement("R1_EDGE", "accesspoint", interfaceaccesspoint);
//equipement poste suppplementaire
Equipement postesupplementaire = new Equipement("R1_EDGE", "postesupplementaire",interfacepostesupplementaire); 

Equipement routeur = new Equipement("R1_EDGE", "Routeur", 
interfaceRouteur); 
Equipement serveur = new Equipement("SRV_DNS", "Serveur", 
interfaceServeur); 
Equipement client = new Equipement("PC_ADMIN", "Poste client", 
interfaceClient); 
//creation d'un deuxieme reseau
ReseauIP ALVARESSE = new ReseauIP( "192.168.56.0", 24, "Réseau d'Alvaresse" ); 

ReseauIP reseauPrincipal = new ReseauIP( "192.168.1.0", 24, "Réseau principal du laboratoire IRT" ); 
System.out.println("----- Réseau créé -----"); 
interfaceinactive.desactiver();
ALVARESSE.afficher();
reseauPrincipal.afficher(); 
System.out.println(); 
System.out.println("----- Équipements créés -----"); 
System.out.println(); 
routeur.afficher(); 
Switch.afficher(); 
postesupplementaire.afficher(); 
accesspoint.afficher(); 
interfaceinactive.afficher();
System.out.println(); 
serveur.afficher(); 
System.out.println(); 
client.afficher(); 
} 
} 

    
