#  TP6 - VLAN et segmentation logique dans IPPlan-Manager

##  Objectif du TP

Ce TP a pour objectif d’enrichir le projet **IPPlan-Manager** en ajoutant la gestion 
des **VLANs**, afin de réaliser une **segmentation logique des réseaux** générés
 automatiquement par le moteur **VLSM**.

Dans une infrastructure réelle, un ingénieur réseau ne se limite pas au plan d’adressage IP,
 mais doit également organiser logiquement les services via des VLANs.

##  Notions étudiées

- VLAN (Virtual Local Area Network)
- Segmentation logique des réseaux
- VLSM (Variable Length Subnet Mask)
- Programmation Orientée Objet (POO)
- Gestion des collections (ArrayList)
- Association entre objets (VLAN ↔ Sous-réseau)


##  Architecture du projet

Le projet est structuré autour des classes utiliser suivantes :

- **BesoinReseau** → définit un besoin en hôtes
- **CalculateurReseau** → effectue les calculs IP
- **MoteurVLSM** → génère les sous-réseaux automatiquement
- **ResultatVLSM** → stocke les résultats du calcul
- **VLAN** → représente un réseau logique
- **GestionnaireVLAN** → gère l’ensemble des VLANs
- **Main** → exécute les scénarios de test


##  Scénario 1 : Réseau entreprise

###  Besoins

- TECHNIQUE → 120 hôtes  
- WIFI → 80 hôtes  
- ADMINISTRATION → 50 hôtes  

###  Résultats

- Génération automatique des sous-réseaux via VLSM  
- Création automatique des VLANs  
- Association VLAN ↔ sous-réseau  


##  Scénario 2 : Université (travail demandé)

###  Besoins

- ETUDIANTS → 500 hôtes  
- ENSEIGNANTS → 120 hôtes  
- LABORATOIRES → 60 hôtes  
- WIFI_PUBLIC → 200 hôtes  
- SERVEURS → 30 hôtes  

###  Résultats

- Génération automatique des VLANs  
- Attribution automatique des sous-réseaux  
- Organisation logique des services réseau  


##  Résultats obtenus

Le programme affiche :

- La liste complète des VLANs générés
- Le nombre total de VLANs
- Les VLANs contenant plus de 100 hôtes
- Le VLAN ayant la plus grande capacité
- La recherche d’un VLAN par ID

---

##  Exemple de sortie


===== VLANS GÉNÉRÉS =====

VLAN ID : 10
Nom : TECHNIQUE
Description : VLAN du service TECHNIQUE
TECHNIQUE -> 192.168.1.0/25 | Masque : 255.255.255.128 | Capacité : 126 hôtes

VLAN ID : 20
Nom : WIFI
Description : VLAN du service WIFI
WIFI -> 192.168.1.128/25 | Masque : 255.255.255.128 | Capacité : 126 hôtes

VLAN ID : 30
Nom : ADMINISTRATION
Description : VLAN du service ADMINISTRATION
ADMINISTRATION -> 192.168.2.0/26 | Masque : 255.255.255.192 | Capacité : 62 hôtes




##  VLANs critiques

Les VLANs critiques (capacité > 100 hôtes) sont affichés grâce à la méthode :

afficherVLANsCritiques()


Exemple :

```
VLAN critique détecté :
VLAN 10 - TECHNIQUE - 126 hôtes
```


##  Fonctionnalités implémentées

* Génération automatique des sous-réseaux (VLSM)
* Création automatique des VLANs
* Association VLAN ↔ réseau IP
* Recherche VLAN par ID
* Détection des VLANs critiques
* Identification du VLAN avec la plus grande capacité
* Analyse de la segmentation réseau



##  Difficultés rencontrées

* Compréhension du mécanisme VLSM
* Gestion des plages IP dynamiques
* Association entre VLAN et sous-réseau
* Manipulation des collections ArrayList
* Structuration orientée objet du projet



##  Conclusion

Ce TP permet de simuler une architecture réseau professionnelle complète :

* Planification automatique des adresses IP
* Segmentation logique via VLANs
* Gestion centralisée des réseaux
* Application concrète des principes de la POO

 Le projet évolue vers une véritable application d’administration réseau utilisée en entreprise.



##  Questions de compréhension

### 1. Pourquoi les VLANs sont-ils importants dans les réseaux modernes ?

Ils permettent de segmenter un réseau pour améliorer la sécurité, la performance et la gestion des flux.


### 2. Pourquoi un VLAN est-il associé à un sous-réseau ?

Parce qu’un VLAN correspond à un domaine de broadcast distinct nécessitant un réseau IP dédié.


### 3. Pourquoi la séparation logique améliore-t-elle la sécurité ?

Elle limite les communications non autorisées entre services différents.


### 4. Quel est le rôle de GestionnaireVLAN ?

Centraliser et gérer tous les VLANs du système.


### 5. Pourquoi VLAN contient ResultatVLSM ?

Pour associer directement chaque VLAN à son sous-réseau IP.


### 6. Pourquoi utiliser ArrayList ?

Pour gérer dynamiquement un nombre variable de VLANs.


### 7. Pourquoi séparer les responsabilités des classes ?

Pour respecter la POO et faciliter la maintenance du code.


### 8. Pourquoi le projet devient professionnel ?

Parce qu’il combine calcul réseau, segmentation logique et gestion métier comme en entreprise.



