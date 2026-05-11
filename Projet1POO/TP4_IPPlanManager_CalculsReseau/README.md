## Réponses aux questions
1. Pourquoi a-t-on créé une classe utilitaire ?
On a créé une classe utilitaire (CalculateurReseau) car certains traitements,
comme le calcul du nombre d'hôtes ou la conversion d'un CIDR, ne représentent pas 
des objets réels (métier), mais des opérations techniques transversales. Cela permet 
de centraliser les calculs, d'éviter les répétitions de code et de faciliter la
 maintenance du projet.  


2. Quel est le rôle du mot-clé static ?
Le mot-clé static indique qu'une méthode appartient à la classe elle-même et 
non à une instance (objet) spécifique. Cela permet d'utiliser les méthodes de
 calcul directement (ex: CalculateurReseau.calculerNombreHotes(24)) sans avoir 
besoin de créer un objet avec le mot-clé new.  


3. Pourquoi les calculs réseau sont-ils importants dans un outil IPAM ?
Dans un outil de gestion d'adresses IP (IPAM), les calculs automatiques sont
 essentiels pour éviter les erreurs humaines lors de la planification. Ils 
permettent d'accélérer les déploiements, d'optimiser l'utilisation des ressources
 IP et d'aider les techniciens en fournissant des informations précises instantanément.  


4. Quelle est l'utilité du CIDR ?
Le CIDR (Classless Inter-Domain Routing) permet de définir précisément la taille
 d'un réseau en indiquant le nombre de bits réservés au masque (ex: /24). C'est 
une notation plus compacte que le masque décimal qui offre une plus grande flexibilité
 pour découper les réseaux sans être limité par les classes historiques.  


5. Pourquoi le nombre d'hôtes dépend-il du masque réseau ?
Le masque réseau détermine la séparation entre la partie "réseau" et la partie 
"hôte" de l'adresse IP. Plus le CIDR est grand, moins il reste de bits pour les
 hôtes. Le calcul repose sur la formule 2 (32−CIDR)−2. On soustrait 2 adresses 
car l'une est réservée à l'adresse de réseau et l'autre au broadcast.  


6. Pourquoi certaines adresses IP sont-elles privées ?
Certaines plages d'adresses (comme 192.168.x.x ou 10.x.x.x) sont réservées pour 
les réseaux internes d'entreprises ou de domiciles. Elles ne sont pas routables 
sur Internet, ce qui permet d'économiser l'espace d'adressage IPv4 public et de 
renforcer la sécurité des réseaux locaux.  


7. Pourquoi la séparation entre logique métier et logique de calcul améliore-t-elle le projet ?
Cette séparation (découplage) rend le code plus modulaire et professionnel. 
En isolant les algorithmes mathématiques dans une classe utilitaire, on peut 
modifier la façon dont on calcule un masque sans risquer de casser la structure
 des classes Equipement ou ReseauIP.  


8. Pourquoi les outils de planification réseau doivent-ils automatiser les calculs ?
L'automatisation garantit la fiabilité des données réseau. Elle permet de générer
 instantanément la classe, le masque décimal et la capacité maximale dès qu'un
 administrateur saisit une adresse et un CIDR, assurant ainsi une cohérence parfaite 
dans toute l'infrastructure.  

