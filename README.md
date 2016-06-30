# Atelier Coding Dojo : Game of life (Jeu de la vie)

Pour cette session de Coding Dojo, nous vous invitons à un atelier de découverte et de mise en pratique de la méthode TDD (Test Driven Development).
Le TDD est une méthode de développement logiciel qui consiste à écrire les tests unitaires avant d'implémenter les fonctionnalités d'un programme. Les avantages de cette approche sont multiples

- On est sûr que le code est testable et testé
- On se focalise sur l'essentiel: les tests nous indique le comportement attendu de notre programme
- On détecte les erreurs plus tôt: le coût de l'erreur est plus faible
- Le code est plus facile à maintenir et à faire évoluer: les tests nous rassurent
- Les tests aident à comprendre du code legacy: c'est une documentation vivante

C'est un cycle itératif comprenant les étapes suivantes:
- 1 On écrit un petit nombre de tests unitaires
- 2 On s'assure que les tests échouent (parce que le code n'est pas encore implémenté)
- 3 On écrit le code juste nécessaire: KISS (Keep It Simple and Stupid)
- 4 On vérifie que les tests passent tous
- 5 On refactorer le code (y compris les tests unitaires) pour l'améliorer tout en s'assurant que les tests restent au vert

Le challenge ?
--------------
Nous allons mettre en pratique ensemble cette méthode en implémentant le jeu Game of life (Le jeu de la vie). Un automate cellulaire où l'on doit calculer à chaque itération l'évolution des cellules suivant. Chaque cellule pouvant prendre 2 états distincts: "vivante" ou "morte". Les cellules sont dans une grille à deux dimensions de taille finie. Leur état évolue suivant 4 règles

	* Règle 1: Une cellule vivante avec moins de deux voisines vivantes meurt (sous-population)
	* Règle 2: Une cellule vivante avec plus de trois voisines vivantes meurt (sur-population)
	* Règle 3: Une cellule vivante avec deux ou trois voisines vivantes reste vivante sur la prochaine génération
	* Règle 4: Une cellule morte avec exactement trois voisines vivantes devient une cellule vivante

Nous devons écrire un programme qui prend en entrée une grille de cellules et calcule la grille de la nouvelle génération de cellules.

**Exemple **: on lit en entrée un fichier texte de la première génération de cellules

4 8
........
....*...
...**...
........

Et la sortie doit être la nouvelle grille avec la deuxième génération de cellules

4 8
........
...**...
...**...
........

Comment ça se passe ?
---------------------
15 minutes de présentation: petite introduction sur le TDD
60 minutes d'implémentation
15 minutes de debrief

Qui peut participer ?
---------------------
Tous les développeurs sont les bienvenus: du débutant à l'expert, en passant par le niveau intermédiaire.
Seule condition: Venir avec un ordinateur et un environnement de développement fonctionnel (JAVA, C#, JavaScript, ....)

Pour rendre la session plus interactive et favoriser l'échange, nous travaillerons en binôme :-)





