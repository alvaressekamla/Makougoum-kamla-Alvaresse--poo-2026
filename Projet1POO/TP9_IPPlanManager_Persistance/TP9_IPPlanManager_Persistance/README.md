# TP9 - Persistance et organisation professionnelle

#REALISER PAR : KEMENE TAKO JAMES NELSON

## Objectif

Ce TP a pour objectif d’ajouter la persistance des données dans l’application IPPlan-Manager.

L’application doit désormais :

- Lire les besoins réseau depuis un fichier CSV
- Générer automatiquement un plan VLSM
- Créer les VLANs
- Produire des recommandations techniques
- Sauvegarder les résultats dans des fichiers
- Générer un rapport technique lisible
- Organiser le projet avec une architecture professionnelle


## Notions étudiées

Les notions étudiées dans ce TP sont :

- Persistance des données
- Lecture de fichiers CSV
- Écriture de fichiers texte
- Utilisation de FileWriter
- Utilisation de BufferedReader
- Architecture en packages
- Séparation des responsabilités
- Repository
- Service
- Génération de rapports
- Sauvegarde automatique


## Organisation du projet

Le projet est organisé en plusieurs packages :

### ipplanmanager.model

Contient les classes métier :

- BesoinReseau
- ResultatVLSM
- VLAN
- Recommandation

### ipplanmanager.service

Contient les traitements :

- CalculateurReseau
- MoteurVLSM
- GestionnaireVLAN
- MoteurRecommandation
- RapportService
- RecommandationWifiInvite
- RecommandationServeurs
- RecommandationGrandVLAN

### ipplanmanager.repository

Contient les classes de lecture/écriture des fichiers :

- BesoinRepository
- FichierPlanRepository

### ipplanmanager.exception

Contient les exceptions personnalisées :

- AdresseIPInvalideException
- ConflitVLANException
- ChevauchementReseauException

### ipplanmanager.main

Contient :

- Main.java


## Fichiers d'entrée

### besoins.csv

Contient le scénario principal :

- ETUDIANTS
- WIFI_INVITES
- ENSEIGNANTS
- LABORATOIRES
- SERVEURS

### besoins_pme.csv

Contient le scénario PME :

- ADMINISTRATION
- COMPTABILITE
- WIFI_INVITES
- SERVEURS
- VOIP
-KEMENE_TAKO


## Fichiers générés

Après exécution, les fichiers suivants sont générés automatiquement :

- plan_adressage.csv
- vlans.csv
- recommandations.txt
- rapport_complet.txt
- rapport_pme.txt

Tous les fichiers sont enregistrés dans le dossier :

exports/


## Fonctionnement de l'application

L’application réalise les opérations suivantes :

1. Lecture des besoins depuis un fichier CSV
2. Génération automatique du plan VLSM
3. Création des VLANs
4. Analyse des VLANs
5. Génération des recommandations
6. Sauvegarde des résultats
7. Génération du rapport final


## Scénarios testés

### Scénario Université

Utilisation du fichier :

exports/besoins.csv

Résultat :

- Génération correcte du plan VLSM
- Création des VLANs
- Génération des recommandations
- Création du rapport complet

### Scénario PME

Utilisation du fichier :

exports/besoins_pme.csv

Résultat :

- Génération correcte du plan réseau PME
- Création des VLANs PME
- Génération des recommandations PME
- Création du rapport_pme.txt


## Difficultés rencontrées

Les principales difficultés rencontrées pendant ce TP ont été :

- Réorganisation du projet en packages
- Gestion des imports Java
- Lecture des fichiers CSV
- Gestion des chemins des fichiers
- Génération automatique des fichiers
- Gestion des exceptions
- Séparation des responsabilités


## Réponses aux questions

### 1. Qu’est-ce que la persistance des données ?

La persistance des données consiste à conserver les informations même après l’arrêt du programme.


### 2. Pourquoi une application professionnelle doit-elle sauvegarder ses résultats ?

Une application professionnelle doit sauvegarder ses résultats afin de conserver les données, produire des rapports, partager les informations et éviter la perte des données.


### 3. Quelle est la différence entre un fichier CSV et un rapport texte ?

Le fichier CSV est destiné aux traitements automatiques et à l’importation dans des logiciels comme Excel.

Le rapport texte est destiné à la lecture humaine.


### 4. Pourquoi a-t-on créé un package repository ?

Le package repository permet de séparer la gestion des fichiers et l’accès aux données du reste de l’application.


### 5. Pourquoi a-t-on créé un package service ?

Le package service contient les traitements métier et évite de mélanger les calculs avec les données.


### 6. Pourquoi ne faut-il pas écrire tout le code dans la classe Main ?

Écrire tout le code dans Main rend l’application difficile à maintenir, difficile à comprendre et peu professionnelle.


### 7. Pourquoi le fichier besoins.csv rend-il l’application plus flexible ?

Le fichier besoins.csv permet de modifier les besoins sans changer le code Java.


### 8. Pourquoi la séparation en packages améliore-t-elle la maintenabilité du projet ?

La séparation en packages organise le projet par responsabilité et facilite la maintenance, les corrections et les évolutions futures.

