Réponses aux questions du README (TP9)
1. Qu'est-ce que la persistance des données ?
La persistance signifie que les données produites par l'application sont enregistrées 
sur un support durable (comme un fichier texte, CSV ou une base de données) afin
 qu'elles ne disparaissent pas à l'arrêt du programme.  

2. Pourquoi une application professionnelle doit-elle sauvegarder ses résultats ?
Dans une application réelle, un administrateur doit pouvoir conserver son travail 
(comme un plan d'adressage), le relire plus tard, l'exploiter dans un rapport ou le
 partager avec une équipe sans avoir à tout recalculer à chaque fois.  


3. Quelle est la différence entre un fichier CSV et un rapport texte ?

Le fichier CSV est un format structuré (utilisant souvent le point-virgule comme séparateur) 
destiné à être lu par d'autres programmes ou tableurs comme Excel.  



Le rapport texte est un document formaté et plus lisible, destiné à être lu directement par
 un humain (administrateur ou enseignant).  

4. Pourquoi a-t-on créé un package repository ?
Le package repository regroupe les classes chargées de l'accès aux données 
(lecture et écriture dans les fichiers). Cela permet d'isoler la logique de stockage 
du reste de l'application.  


5. Pourquoi a-t-on créé un package service ?
Le package service contient les classes qui réalisent les traitements et la logique 
métier de l'application (calculs, génération de rapports, etc.).  


6. Pourquoi ne faut-il pas écrire tout le code dans la classe Main ?
Écrire tout dans la classe Main rend le code difficile à lire, à tester et à maintenir.
 La séparation des responsabilités dans différentes classes et packages rend le projet
 plus propre et professionnel.  


7. Pourquoi le fichier besoins.csv rend-il l'application plus flexible ?
Cela permet de modifier les données d'entrée (ajouter ou changer des besoins réseau)
 sans avoir à modifier ou à recompiler le code source Java de l'application.  

8. Pourquoi la séparation en packages améliore-t-elle la maintenabilité du projet ?
Elle permet de ne pas mélanger les fonctionnalités. Si on veut modifier la façon dont
 on sauvegarde les données, on sait qu'il faut intervenir uniquement dans le package repository,
 sans risquer de casser la logique de calcul située dans service.  


