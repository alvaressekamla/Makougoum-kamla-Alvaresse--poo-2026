# TP5 - Moteur VLSM

# Realiser par : KEMENE TAKO JAMES NELSON

## Objectif
Developper un moteur VLSM capable de proposer automatiquement un plan
d'adressage a partir des besoins exprimes.

## Notions etudiees

- VLSM
- Tri de collections
- Classe de service métier
- Calcul CIDR
- Conversion IP-entier
- Génération automatique de sous-réseaux

## Scenarios testes

### Scenario 1 : Entreprise standard (reseau 192.168.1.0)
- TECHNIQUE : 120 hotes
- WIFI : 80 hotes
- ADMINISTRATION : 50 hotes
- SERVEURS : 20 hotes
- DIRECTION : 10 hotes

### Scenario 2 : Petite entreprise (reseau 10.0.0.0)
- ADMIN : 25 hotes
- COMPTABILITE : 12 hotes
- WIFI_INVITES : 40 hotes
- SERVEURS : 8 hotes

### Scenario 3 : Campus (reseau 172.16.0.0)
- ETUDIANTS : 500 hotes
- PERSONNEL : 120 hotes
- LABORATOIRE : 60 hotes
- ADMINISTRATION : 40 hotes
- WIFI_PUBLIC : 200 hotes

## Resultats obtenus

Les besoins les plus grands sont traités en premier afin d’éviter le gaspillage des adresses IP.

### Scenario 1
TECHNIQUE -> 192.168.1.0/25 | Plage : 192.168.1.1 - 192.168.1.126 | Capacite : 126 hotes
WIFI -> 192.168.1.128/25 | Plage : 192.168.1.129 - 192.168.1.254 | Capacite : 126 hotes
ADMINISTRATION -> 192.168.2.0/26 | Plage : 192.168.2.1 - 192.168.2.62 | Capacite : 62 hotes
SERVEURS -> 192.168.2.64/27 | Plage : 192.168.2.65 - 192.168.2.94 | Capacite : 30 hotes
DIRECTION -> 192.168.2.96/28 | Plage : 192.168.2.97 - 192.168.2.110 | Capacite : 14 hotes

### Scenario 2
WIFI_INVITES -> 10.0.0.0/26 | Plage : 10.0.0.1 - 10.0.0.62 | Capacite : 62 hotes
ADMIN -> 10.0.0.64/27 | Plage : 10.0.0.65 - 10.0.0.94 | Capacite : 30 hotes
COMPTABILITE -> 10.0.0.96/28 | Plage : 10.0.0.97 - 10.0.0.110 | Capacite : 14 hotes
SERVEURS -> 10.0.0.112/28 | Plage : 10.0.0.113 - 10.0.0.126 | Capacite : 14 hotes

### Scenario 3
ETUDIANTS -> 172.16.0.0/23 | Plage : 172.16.0.1 - 172.16.1.254 | Capacite : 510 hotes
WIFI_PUBLIC -> 172.16.2.0/24 | Plage : 172.16.2.1 - 172.16.2.254 | Capacite : 254 hotes
PERSONNEL -> 172.16.3.0/25 | Plage : 172.16.3.1 - 172.16.3.126 | Capacite : 126 hotes
LABORATOIRE -> 172.16.3.128/26 | Plage : 172.16.3.129 - 172.16.3.190 | Capacite : 62 hotes
ADMINISTRATION -> 172.16.3.192/26 | Plage : 172.16.3.193 - 172.16.3.254 | Capacite : 62 hotes

## Difficultes rencontrees
- Comprendre la conversion d'une adresse IP en entier pour les calculs
- Gerer l'avancement de l'adresse courante apres chaque bloc
- S'assurer que le tri decroissant est effectue avant l'allocation

## Reponses aux questions

### 1. Pourquoi le VLSM permet-il d'economiser les adresses IP ?
Le VLSM attribue a chaque reseau exactement le plus petit bloc capable de
contenir ses hotes. Sans VLSM, on attribuerait le meme masque a tous les
sous-reseaux, ce qui gaspillerait des adresses dans les petits reseaux.

### 2. Pourquoi faut-il traiter les plus grands besoins en premier ?
Si on place d'abord les petits reseaux, l'espace disponible se fragmente.
Les grands blocs reqierent un alignement sur une puissance de 2 et ne
peuvent plus etre places correctement si l'espace a ete morcele.

### 3. Quelle est la difference entre un besoin reseau et un resultat VLSM ?
Un besoin (BesoinReseau) represente l'exigence : un nom et un nombre d'hotes.
Un resultat (ResultatVLSM) est ce que le moteur calcule : adresse reseau,
CIDR, masque, plage d'adresses utilisables.

### 4. Pourquoi la classe MoteurVLSM est-elle une classe de service metier ?
Elle n'est pas un simple conteneur de donnees. Elle applique une logique
algorithmique (tri, calcul CIDR, avancement d'adresse) pour transformer
des besoins en un plan d'adressage concret.

### 5. Pourquoi transforme-t-on une adresse IP en entier pour certains calculs ?
Une adresse IP est fondamentalement un nombre sur 32 bits. La convertir en
entier permet des operations arithmetiques simples, comme ajouter la taille
d'un bloc pour obtenir l'adresse de depart du reseau suivant.

### 6. Quel est le role de la methode calculerCidrPourHotes() ?
Elle determine automatiquement le plus petit CIDR dont la capacite est
superieure ou egale au nombre d'hotes demandes. Elle parcourt les CIDR
de /32 vers /0 et retourne le premier qui convient.

### 7. Pourquoi reseau et broadcast ne sont pas attribues aux machines ?
L'adresse reseau identifie le reseau lui-meme. L'adresse de broadcast sert
a envoyer un message a toutes les machines du reseau. Ces deux adresses ont
des usages reserves et ne peuvent pas etre configurees sur un hote.

### 8. Pourquoi le moteur VLSM est-il important dans IPPlan-Manager ?
C'est le premier composant qui produit une valeur metier reelle : il
transforme des besoins en un plan d'adressage exploitable. Il marque le
passage d'une application de calcul a un vrai outil de planification IP.
