## Réponses aux questions
1. Pourquoi est-il nécessaire de valider un plan d'adressage après sa génération ?
La génération automatique peut parfois produire des résultats techniquement corrects
 mais pratiquement irréalisables ou erronés (mauvaise adresse de départ, chevauchement). 
La validation permet de garantir que le plan est 100% fiable, sans erreurs de configuration
 qui pourraient causer des pannes réelles sur les équipements réseau.

2. Qu'est-ce qu'un chevauchement (overlap) de réseaux et pourquoi est-ce un problème ?
Un chevauchement se produit lorsque deux sous-réseaux utilisent tout ou partie de la même 

plage d'adresses IP. C'est un problème majeur car cela crée des conflits de routage : le réseau
 ne peut pas savoir vers quelle destination envoyer les paquets, ce qui rend la communication 
impossible pour les machines concernées.

3. Quel est l'intérêt de créer des exceptions personnalisées (ex: ConflitVlanException) ?
Les exceptions personnalisées permettent de rendre le code plus explicite et plus facile à
 déboguer. Au lieu d'avoir une erreur générique, le programme lève une exception précise 
qui indique exactement la nature du problème métier (un conflit d'ID de VLAN ou une erreur d'IP), 
facilitant ainsi le traitement spécifique de chaque erreur.

4. Quelle est la différence entre le mot-clé throw et le bloc try/catch ?

throw est utilisé pour "lancer" ou signaler une erreur lorsqu'une condition invalide est détectée.

try/catch est utilisé pour "attraper" et gérer une erreur qui a été lancée, afin d'éviter
 que le programme ne s'arrête brutalement et de proposer une solution (comme afficher un message d'alerte).

5. Pourquoi la détection des conflits de VLAN est-elle importante ?
Chaque VLAN doit posséder un identifiant unique (Tag) sur une infrastructure. Si deux 
VLANs différents partagent le même ID, le commutateur (switch) ne pourra pas les distinguer, 
ce qui entraînera une fusion accidentelle de flux de données qui devraient être isolés pour 
des raisons de sécurité.

6. Quel est le rôle de la classe ValidateurPlanAdressage ?
Cette classe agit comme une unité de contrôle qualité. Elle parcourt l'ensemble de 
l'infrastructure générée (sous-réseaux et VLANs) pour vérifier le respect des règles 
d'ingénierie réseau. Elle sépare la logique de construction de la logique de vérification.

7. Pourquoi vaut-il mieux arrêter l'exécution d'un plan erroné plutôt que de le laisser s'afficher ?
En ingénierie réseau, un plan erroné est dangereux. Si un administrateur configure ses 
routeurs avec un plan contenant des chevauchements, il risque de bloquer tout le réseau de 
l'entreprise. Il est donc plus professionnel d'empêcher l'affichage d'un résultat faux pour 
forcer l'utilisateur à corriger ses paramètres de départ.

8. En quoi ce TP transforme-t-il IPPlan-Manager en un outil "intelligent" ?
Grâce à la détection d'erreurs, l'application ne se contente plus de faire des calculs
 mathématiques ; elle devient capable d'analyser la cohérence d'une architecture globale. 
Elle apporte une expertise en conseillant l'utilisateur et en garantissant la viabilité 
technique des solutions proposées.

Ce TP a un readme avec des questions aide moi à répondre

Voici les réponses aux questions de compréhension de votre TP8 : Moteur de recommandations 
intelligentes, basées sur l'ajout d'une couche d'intelligence et de conseil à votre application
 IPPlan-Manager.