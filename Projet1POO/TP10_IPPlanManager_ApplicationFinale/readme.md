## Réponses aux questions
1. Quel est l'intérêt d'organiser le projet en "packages" (ex: model, service, util, exception) ?
L'organisation en packages permet de structurer le code de manière professionnelle en regroupant
les classes par responsabilité. Cela facilite la navigation dans le projet, évite les conflits 
de noms et permet une meilleure maintenance : les objets de données vont dans model, la logique 
métier dans service, les outils transversaux dans util et les erreurs spécifiques dans exception.

2. Pourquoi le TP10 est-il appelé "Projet intégrateur" ?
Il est appelé ainsi car il ne traite pas d'une nouvelle notion isolée, mais demande d'assembler 
(d'intégrer) toutes les briques logicielles développées du TP1 au TP9 (encapsulation, collections, 
VLSM, VLANs, exceptions, persistance). L'objectif est de vérifier que toutes ces fonctionnalités 
travaillent ensemble sans erreur.

3. Quel est le rôle de la classe Main ou App dans ce projet ?
La classe principale sert de "chef d'orchestre" ou de point d'entrée au programme. Son rôle est
 d'initialiser l'application, d'afficher le menu console, de récupérer les choix de l'utilisateur
 et de coordonner les appels aux différentes classes de service pour exécuter les actions demandées.

4. Pourquoi est-il important de proposer un menu à l'utilisateur plutôt que d'exécuter le code en bloc ?
Un menu rend l'application interactive, ergonomique et utilisable par un non-développeur. Cela permet à 
l'utilisateur de choisir précisément l'action qu'il souhaite effectuer (ex: charger un fichier, lancer un
 calcul VLSM ou générer un rapport) sans avoir à relancer tout le programme ou à modifier le code source.

5. En quoi la séparation des couches (Vue, Métier, Données) est-elle bénéfique pour une application ?
Cette séparation (souvent appelée architecture multicouche) permet de modifier une partie du programme 
sans impacter les autres. Par exemple, on pourrait remplacer le menu console par une interface graphique
 (Vue) ou les fichiers CSV par une base de données (Données) sans avoir à retoucher les algorithmes de calcul VLSM (Métier).

6. Pourquoi la génération d'un "Rapport Technique" final est-elle une valeur ajoutée ?
Le rapport technique est le livrable final attendu par un ingénieur ou un client. En automatisant 
sa création, IPPlan-Manager passe d'un simple exercice de programmation à un véritable outil d'ingénierie 
capable de fournir une documentation claire, structurée et immédiatement exploitable pour le déploiement réel du réseau.

7. Quel a été l'aspect le plus complexe de l'assemblage de toutes les fonctionnalités ?
L'aspect le plus complexe est généralement la gestion de la cohérence des données entre les étapes : s'assurer que
 les sous-réseaux calculés par le moteur VLSM sont correctement transmis au validateur, puis au gestionnaire de VLAN, 
tout en gérant les exceptions à chaque niveau pour éviter un crash de l'application finale.

8. Comment la Programmation Orientée Objet (POO) a-t-elle facilité la construction de ce projet complexe ?
La POO a permis de diviser un problème complexe (la planification IP globale) en petits objets autonomes et réutilisables.
 Grâce à l'encapsulation, à l'héritage et au polymorphisme, nous avons pu construire et tester chaque module séparément avant 
de les assembler, ce qui aurait été extrêmement difficile avec une programmation linéaire classique.
