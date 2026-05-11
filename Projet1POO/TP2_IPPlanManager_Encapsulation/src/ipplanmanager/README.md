# TP2 - Encapsulation

## Objectif
Introduction de l'encapsulation et des validations dans le projet IPPlan-Manager.

## Notions étudiées
- private
- getters
- setters
- validation
- this

## Tests réalisés
- Création d'adresses IP valides et invalides (null, vide)
- Création de réseaux avec masques CIDR invalides (négatif, supérieur à 32)
- Création d'interfaces sans nom
- Création d'équipements sans nom et sans type
- Création d'un équipement sans interface
- Test de la méthode estAdresseLocale()
- Modification de valeurs avec les setters (valides et invalides)
- Activation et désactivation d'interfaces

## Difficultés rencontrées
- Comprendre la différence entre modifier un attribut directement
  et passer par un setter avec validation
- Utiliser correctement le mot-clé this pour distinguer
  l'attribut de la classe et le paramètre du setter

## Réponses aux questions

1. *Pourquoi utilise-t-on private dans les classes ?*
   Pour empêcher toute modification directe des attributs depuis
   l'extérieur de la classe et protéger les données.

2. *Quelle différence entre un attribut public et privé ?*
   Un attribut public est accessible et modifiable depuis n'importe
   quelle partie du programme. Un attribut privé n'est accessible
   que depuis l'intérieur de sa propre classe.

3. *Pourquoi utilise-t-on des getters et setters ?*
   Pour contrôler l'accès en lecture (getter) et en écriture (setter)
   aux attributs privés, et y ajouter des validations.

4. *Pourquoi les validations sont-elles importantes dans un logiciel réseau ?*
   Une donnée invalide comme un masque incorrect ou une adresse IP vide
   peut provoquer des pannes, des conflits réseau ou des comportements
   imprévisibles dans une vraie infrastructure.

5. *Quel est le rôle du mot-clé this ?*
   Il désigne l'objet courant. Il permet de distinguer l'attribut
   de la classe du paramètre portant le même nom dans un setter.

6. *Pourquoi le constructeur appelle-t-il les setters ?*
   Pour réutiliser la validation déjà écrite dans les setters
   et éviter de dupliquer le code de vérification.

7. *Pourquoi la validation du masque CIDR est-elle importante ?*
   Un masque CIDR doit être compris entre 0 et 32. Une valeur
   en dehors de cette plage produirait une configuration réseau
   totalement incorrecte et inutilisable.

8. *Pourquoi l'encapsulation améliore-t-elle la sécurité logicielle ?*
   Elle empêche les modifications non contrôlées des données,
   garantit que les objets sont toujours dans un état cohérent
   et réduit les risques d'erreurs ou de comportements inattendus.
