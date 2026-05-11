# TP4 - Calculs réseau

##Realiser par : KEMENE TAKO JAMES NELSON

## Objectif
Introduction des calculs automatiques réseau dans IPPlan-Manager.

## Notions étudiées
Méthodes statiques, calculs réseau, CIDR, logique algorithmique,
classes utilitaires.

## Tests réalisés
- 3 réseaux principaux : /8, /16, /24
- 4 réseaux supplémentaires : /25, /26, /27, /28
- Tests directs de calculerNombreHotes() pour chaque CIDR
- Tests de estReseauPrive() sur adresses privées et publiques

## Difficultés rencontrées
- Comprendre Math.pow() avec le cast en int
- La méthode split("\\.") nécessite d'échapper le point en Java

## Réponses aux questions

1. **Pourquoi une classe utilitaire ?**
   Pour regrouper des traitements techniques qui ne représentent pas
   un objet réel. Cela évite les répétitions et centralise les calculs.

2. **Rôle du mot-clé static ?**
   Une méthode static appartient à la classe et non à un objet.
   On peut l'appeler sans créer d'instance : CalculateurReseau.methode().

3. **Pourquoi les calculs réseau sont-ils importants dans un outil IPAM ?**
   Pour éviter les erreurs humaines, accélérer les déploiements et
   optimiser l'utilisation des adresses IP disponibles.

4. **Utilité du CIDR ?**
   Le CIDR (ex: /24) exprime en un seul nombre le masque réseau,
   permettant de définir précisément la taille d'un sous-réseau.

5. **Pourquoi le nombre d'hôtes dépend du masque ?**
   Le masque détermine combien de bits sont réservés aux hôtes.
   Plus le CIDR est petit, plus il y a de bits hôtes, donc plus d'adresses.

6. **Pourquoi certaines adresses IP sont-elles privées ?**
   L'IANA a réservé des plages (10.x, 172.16-31.x, 192.168.x) pour
   les réseaux internes afin de préserver les adresses publiques.

7. **Pourquoi séparer logique métier et logique de calcul ?**
   Pour que chaque classe ait une responsabilité unique, le code est
   plus lisible, maintenable et réutilisable (principe SRP en POO).

8. **Pourquoi automatiser les calculs dans un outil de planification ?**
   Pour éliminer les erreurs, gagner du temps et aider les techniciens
   moins expérimentés à configurer correctement les réseaux.
