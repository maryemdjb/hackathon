# Ready Wheels

Une nouvelle façon de circuler - Assurer le transport des citoyens qui veulent circuler en évitant la foule dans un context Covid-19 en proposant un prêt de vélos entre particuliers.

## Fonctionnalités
1. S'inscrire et se connecter en utilisant JSON Web Token (**JWT**)
2. Avoir accès à un annuaire de vélos
3. Déposer son vélo tout en précisant ses caractéristiques (marque, prix, état, photo, etc)
4. Louer un vélo en indiquant la date de début et de fin de sa réservation
5. Notifier le propriétaire du vélo par un E-mail
6. Service de paiement via Stripe (prêt en Backend) 

**Fonctionnalités à venir :**

1. S'il y a un dépassement de la durée de réservation, l'utilisateur sera pénalisé (frais de paiement)
2. Notification par SMS
3. Intégration de l'API Google Maps
4. Rating

## Guide de Démarrage

Ces instructions vous permettront d'obtenir une copie du projet sur votre ordinateur à des fins de test. Il faut installer :

* PostgreSQL
* Sprign Boot
* Angular CLI

### Usage Back-end
Il faut avoir une base de données **rentbike** et modifier, par suite, ces coordonnées dans le fichier **application.properties**:

```bash
spring.datasource.username=username
spring.datasource.password=password
```
### Usage Front-end
Il faut ouvrir une fenêtre de terminal / console et entrer les commandes suivantes:

```bash
cd PATH_TO_ProjectDirectory
npm install
ng serve
```

## Tester l'application
Ouvrez votre navigateur sur http://localhost:4200/

## Les membres de l'équipe
* Kawther Bjaoui
* Cyrine Ben Othmen
* Maryem Djebbi
* Youssef Gouicem Lakhal

##
Copyright © All rights reserved | Made by Bug Busters