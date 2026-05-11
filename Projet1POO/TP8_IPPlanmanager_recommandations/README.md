
## Réponses aux questions
1. Quelle est la différence entre une validation (TP7) et une recommandation (TP8) ?
La validation vérifie si le plan est techniquement correct et fonctionnel (absence de 
conflits d'IP ou de VLAN). La recommandation va plus loin : elle vérifie si le plan 
respecte les "bonnes pratiques" de l'ingénierie réseau. Un plan peut être valide (sans erreur) 
mais rester mal organisé ou peu sécurisé.

2. Pourquoi utilise-t-on une interface RegleRecommandation ?
L'interface permet de définir un contrat commun pour toutes les règles. Cela permet
 d'ajouter facilement de nouvelles règles de vérification (sécurité, performance, organisation) 
sans modifier le moteur de recommandation principal, rendant le code plus flexible et évolutif.

3. Qu'est-ce que le polymorphisme dans le contexte de ce TP ?
Le polymorphisme est utilisé lorsque le moteur parcourt une liste de type RegleRecommandation. 
Bien que chaque règle (sécurité, broadcast, etc.) soit différente, elles sont toutes traitées 
de la même manière par le moteur qui appelle simplement la méthode evaluer(). Le programme exécute 
alors automatiquement le code spécifique à chaque règle.

4. Pourquoi est-il déconseillé d'avoir des VLANs trop grands (plus de 500 hôtes) ?
Des VLANs trop grands augmentent le trafic de "broadcast" (diffusion). Chaque machine envoie
 régulièrement des messages à toutes les autres, ce qui sature la bande passante et consomme 
inutilement des ressources CPU sur tous les équipements du réseau, dégradant ainsi les performances
 globales.

5. Quel est l'intérêt de séparer le réseau "WiFi Invités" du réseau "Administration" ?
C'est une règle de sécurité fondamentale. Le réseau "Administration" contient des données critiques et 
des accès aux serveurs. En isolant les "Invités" dans un VLAN dédié, on empêche qu'un utilisateur externe 
puisse accéder aux ressources internes sensibles de l'entreprise.

6. Pourquoi le moteur de recommandations renvoie-t-il une liste d'objets Recommandation ?
Cela permet de structurer les conseils. Chaque objet Recommandation contient un titre, un message
 explicatif et un niveau de priorité (Info, Avertissement, Critique). C'est beaucoup plus professionnel 
et exploitable par une interface utilisateur qu'une simple chaîne de caractères.

7. En quoi l'approche par "règles" facilite-t-elle l'évolution de l'application ?
Cette approche modulaire permet d'enrichir l'expertise de l'application au fil du temps. Si de nouvelles 
normes réseau apparaissent, il suffit de créer une nouvelle classe implémentant l'interface, sans risquer 
de casser les calculs réseau ou le moteur VLSM déjà existants.

8. Pourquoi dit-on que ce TP ajoute une "couche d'intelligence" au projet ?
L'application ne se contente plus de calculer ou de valider, elle "analyse" et "conseille". Elle simule 
le rôle d'un ingénieur réseau expérimenté 