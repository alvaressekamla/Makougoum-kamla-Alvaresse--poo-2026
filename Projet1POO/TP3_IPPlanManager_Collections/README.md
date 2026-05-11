# TP3 - Collections et composition

## Objectif
Introduction des collections et des relations entre objets dans le projet IPPlan Manager.

## Notions étudiées
Composition, ArrayList, collections, parcours de listes, relations entre objets.

## Tests réalisés
- Création d'une infrastructure réseau contenant 3 sous-réseaux (ADMIN, TECH, WIFI).
- Ajout de 7 équipements : routeur, switch, serveur, 2 PC, point d'accès WiFi, imprimante.
- Chaque équipement possède plusieurs interfaces réseau.
- Utilisation de la méthode rechercherEquipement() avec un nom existant et un nom inconnu.
- Vérification de l'affichage complet de l'infrastructure.

## Difficultés rencontrées
- Comprendre la différence entre un attribut simple et une collection ArrayList.
- Initialiser la liste dans le constructeur (new ArrayList<>()).
- Parcourir la collection avec la boucle for-each.

## Réponses aux questions

1. **Qu'est-ce qu'une composition en POO ?**
   La composition est une relation dans laquelle un objet contient d'autres objets.
   Par exemple, un Equipement contient une liste d'InterfaceReseau.
   Si l'équipement est supprimé, ses interfaces le sont aussi.

2. **Pourquoi utilise-t-on ArrayList dans ce TP ?**
   ArrayList permet de stocker un nombre variable d'objets sans connaître ce nombre à l'avance.
   Elle offre des méthodes pratiques : add(), size(), et le parcours avec for-each.

3. **Quelle différence entre une variable simple et une collection ?**
   Une variable simple stocke un seul objet (ex : InterfaceReseau eth0).
   Une collection (ArrayList) peut stocker plusieurs objets du même type de manière dynamique.

4. **Pourquoi un équipement possède-t-il plusieurs interfaces ?**
   Un routeur ou un switch réel possède plusieurs ports physiques (eth0, eth1, GigabitEthernet...).
   Modéliser cela avec une liste est plus fidèle à la réalité du terrain.

5. **Pourquoi une infrastructure contient-elle plusieurs sous-réseaux ?**
   Une entreprise découpe généralement son réseau en zones (administration, technique, WiFi...)
   pour des raisons de sécurité, d'organisation et de performance.

6. **Quel est le rôle de la boucle for-each ?**
   Elle permet de parcourir tous les éléments d'une collection sans gérer d'index manuellement.
   Syntaxe : for (Type element : collection) { ... }

7. **Pourquoi la classe InfrastructureReseau est-elle importante ?**
   Elle joue le rôle de conteneur central : elle regroupe équipements et sous-réseaux,
   offre des méthodes d'affichage et de recherche, et représente l'application dans son ensemble.

8. **Pourquoi les collections sont-elles indispensables en professionnel ?**
   Les applications réelles gèrent des centaines d'objets. Sans collections, il faudrait
   déclarer des centaines de variables individuelles, ce qui est impossible à maintenir.
   Les collections permettent une gestion dynamique, scalable et structurée des données.
