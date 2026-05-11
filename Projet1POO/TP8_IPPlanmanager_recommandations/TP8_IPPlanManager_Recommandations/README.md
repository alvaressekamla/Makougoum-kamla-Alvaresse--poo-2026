# TP8 - Moteur de recommandations

## Auteur
KEMENE TAKO James Nelson


## Objectif

Ajouter un moteur de recommandations capable d'analyser un plan VLAN et de proposer des conseils techniques intelligents.


## Notions étudiées

Interfaces Java, polymorphisme, règles métier, moteur de recommandations, séparation des responsabilités, extensibilité logicielle.


## Scénarios testés

### Scénario principal
- ETUDIANTS : 500 hôtes  
- WIFI_INVITES : 200 hôtes  
- ENSEIGNANTS : 120 hôtes  
- LABORATOIRES : 60 hôtes  
- SERVEURS : 30 hôtes  

### Scénario supplémentaire
- ADMINISTRATION : 50 hôtes  
- WIFI_INVITES : 120 hôtes  
- SERVEURS : 20 hôtes  
- CAMERAS : 80 hôtes  
- VOIP : 60 hôtes  


## Recommandations obtenues

- Isolation du VLAN WiFi invité des réseaux internes  
- Protection du VLAN Serveurs avec ACL  
- Sécurisation du VLAN Administration  
- Détection des VLANs de grande taille  
- Alerte sur la faible marge d’adresses disponibles  


## Difficultés rencontrées

- Compréhension du moteur de règles  
- Mise en place du polymorphisme  
- Gestion des interfaces Java  
- Calcul et répartition VLSM  
- Organisation des VLANs et tests multi-scénarios  


## Réponses aux questions

### 1. Quel est le rôle d’un moteur de recommandations dans un outil IPAM ?
Il analyse automatiquement les réseaux et propose des conseils pour améliorer la sécurité, la performance et l’organisation du plan d’adressage.


### 2. Pourquoi utilise-t-on une interface pour les règles de recommandation ?
Pour définir un contrat commun. Toutes les règles doivent implémenter la même méthode, ce qui permet de les utiliser de manière uniforme dans le moteur.


### 3. Quelle est la différence entre une classe concrète et une interface ?
Une classe concrète contient une implémentation complète, tandis qu’une interface définit فقط les méthodes sans les implémenter.


### 4. Pourquoi la méthode analyser() peut-elle retourner null ?
Parce qu’une règle peut ne pas s’appliquer à un VLAN. Dans ce cas, aucune recommandation n’est générée.


### 5. Pourquoi le moteur de recommandations illustre-t-il le polymorphisme ?
Parce qu’il manipule des objets via une interface commune, mais chaque classe de règle exécute sa propre logique.


### 6. Pourquoi est-il préférable de créer une classe par règle au lieu de mettre tous les tests dans Main ?
Pour améliorer la lisibilité, la maintenance et permettre d’ajouter facilement de nouvelles règles sans modifier le code principal.


### 7. Pourquoi un VLAN WiFi invité doit-il être isolé des réseaux internes ?
Pour des raisons de sécurité, afin d’empêcher les utilisateurs invités d’accéder aux ressources sensibles du réseau interne.


### 8. Pourquoi les VLANs de grande taille doivent-ils être surveillés ?
Parce qu’ils peuvent générer beaucoup de trafic broadcast, réduire les performances et augmenter les risques de congestion réseau.

