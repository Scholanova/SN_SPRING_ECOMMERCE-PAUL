# SN_SPRING_ECOMMERCE
Pratiquer l'écriture d'un code testé unitairement avec Spring

## Pour commencer
Choisissez votre IDE favoris et un outil de build que vous maîtrisez. JE ne pourrais vous aider que sur IntelliJ et Gradle.
* Clonez le projet sur un répertoire de travail sur votre machine.
* Assurez-vous que le projet puisse être buildé sur votre machine.
* Créer un repository pour votre code sur le github Scholanova. Le nom de votre repo doit contenir vos initiales et le mot clé "ecommerce". Poussez votre code sur ce repository

## Ce que vous devez faire ?
Le projet est divisé en plusieurs parties. Certaines sont complètes et fonctionnent, certaines doivent être complétées, d'autres doivent être créées.

## Comment votre travail sera évalué ?
Votre note finale dépendra de:
- Votre capacité à corriger, construire et faire trourner un programme qui fonctionne
- Votre capacité à écrire du code correspondant à des test dans une approche TDD
- Votre capacité à écrire des tests unitaires
- Votre capacité à écrire du code lisible

Ce que vous devez faire:
#### Product:
Rien de particulier. Cette partie ne vous servira pas à grand chose.
Je vous recommande simplement de la lire la documentation sur CrudRepository, PagingAndSortingRepository, EnableSpringDataWebSupport, MockMvc.
#### Cart:
Les tests on été écrits pour l'objet Cart, le code de la classe Cart a également été écrit.
Les tests ont été écrits pour la classe CartService.
* **Retirez les annotations @Disabled dans les tests de CartService. Vous devez écrire le code correspondant dans la classe CartServiceImpl.** 
#### Order:
Les signatures des Tests de la classe Order ont été écrites. 
* **Retirez les annotations @Disabled dans les tests. Vous devez écrire le contenu des tests.**
* **Vous devez écrire le code qui correspond aux tests dans la classe Order.**
* **Les tests doivent passer.**

Attention, les méthodes commençant par le mot clé "get" ont un comportement particulier avec JPA. Regardez ce qui est fait dans Cart.

* **Ajoutez un controller OrderController qui permette de faire des opérations CRUD sur les Orders.**
* **Le controller doit également permettre de faire le "checkout" et le "close" d'une Order.**
* **Testez que l'objet Order renvoyé par le controller continne un champ "totalPrice" qui soit correcte.**

Pour savoir comment tester unitairement un controller, regardez les tests de la partie Cart. 

Attention à ne pas mettre de logique métier dans le controller. 
A Priori, il n'y a pas besoin de classe Service dans ce module. Vous êtes libre d'en créer une si vous le souhaitez. Toutefois, les classes ajoutées devront être testées.
Inspirez-vous des modules précédents pour vous aider
#### CartExceptions :
* **Vous devez créer ce module entièrement.**
 
Pour vous aider, voici quelques pistes: HttpStatusException, ControllerAdvice

**Attention, Il s'agit de tests unitaires uniquement !** Cela signifie que l'execution des tests de doit pas nécessite rle lancement de l'application (On ne doit pas voir le logo Spring dans les logs)

1) Ce module devra être testé unitairement.
Lors de l'appel au contrôler CartController, Si la classe Cart renvoie une exception de type IllegalArgumentException, alors le controller devra renvoyer une erreur ayant ce format :
Status HTTP : 400
Corps de la réponse : {"message": "invalid request 'message' "}
Le message <message> devra contenir des informations permettant de comprendre pourquoi il y a eu une erreur

2) Lors de l'appel au contrôler CartController, Si la classe Cart renvoie une exception de type IllegalArgumentException, alors le controller devra renvoyer une erreur ayant ce format :
Status HTTP : 404
Corps de la réponse : {"message": " 'message' not found"}
Le message <message> devra contenir des informations permettant de comprendre qu'est-ce qui n'a pas été trouvé

#### Bonus
**Les bonus ne seront pris en compte si et seulement si tous les points précédents ont été faits**
* Appliquer la même stratégie de gestion des exceptions au module Order
* Ajouter les tests unitaires du controller CartController
