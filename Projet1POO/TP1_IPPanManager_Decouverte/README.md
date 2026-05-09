# TP1 - IPPlan-Manager 
## Objectif du TP 
Ce TP permet de découvrir les premières classes Java du projet IPPlan
Manager. 
## Classes créées - AdresseIP 
- ReseauIP - InterfaceReseau - Equipement - Main 
## Travail réalisé 
creation d'un deuxieme reseau
ReseauIP ALVARESSE = new ReseauIP( "192.168.56.0", 24, "Réseau d'Alvaresse" ); 
ALVARESSE.afficher();nous avons cree l'objet switch qui va permettre deconnecter divers postes,
// Adresse ip du switch
AdresseIP ipSwitch =new AdresseIP("192.168.56.1");
//interface du switch
InterfaceReseau interfaceSwitch= new InterfaceReseau("eth0", ipSwitch);
// equipement switch
Equipement Switch = new Equipement("R1_EDGE", "switch", interfaceSwitch);
Switch.afficher(); 
NOUS AVONS CREE UN POINT D'ACCES WIFI
// Adresse ip du point d'access
AdresseIP ipaccesspoint =new AdresseIP("192.168.56.2");
//Interface du point d'access
InterfaceReseau interfaceaccesspoint= new InterfaceReseau("fastethernet", ipaccesspoint);
accesspoint.afficher(); 
NOUS AVONS CREE UNE INTERFACE SANS ADRESSE Ip
InterfaceReseau interfaceSansIP = new InterfaceReseau("eth1", 
null); 
## Réponses aux questions 
1.l'adresse ip a ete representee par une classe au lieu de la stocker simplement 
dans une variable string, car plus tard,l'adresse ip pouras clculer son masque,
et verifier si elle est valide ce qui est impossible si on utilise un simple 
string
2.la classe est le plan de construction,elle definit la structure et le compor-
tement alorsque l'objet est l'instance concrete cree a partir du plan,il a des 
valeurs precises pour ses attributs
3.le constructeur a pour role d'initialiser les attributs de l'objet avec des 
valeurs de depart.
4.la classe interfaceReseau contient un objet de type AdresseIP parceque en pro-
grammation,on represente ce lien en faisant de la classe adresseIP un attribut 
de la classe interfaceReseau.cela permet d'acceder directement aux informations 
et aux methodes de l'ip depuis l'interface
5.la classe equipement contient un objet de type interfaceReseau parcequ'un equi
pement physique possede une carte reseau
6.Actuellement, la classe Equipement ne possede qu'une seule interface
7.cette version n'est pas encore suffisante pour produire automatiquement un 
plan d'adressage ip car nos classessont purement passives.Elles stockent et affi
chent des informations,mais elles ne savent pas calculer la premiere/derniere 
adresse d'un reseau,le nombre d'hotes disponibles,ou verifier si les deux adres
ses sont dans le meme reseau.
 

