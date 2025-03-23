## 📌 Gestion des Bibliothèques Scolaires

📌 Contexte

La gestion des bibliothèques scolaires est essentielle pour assurer un accès efficace aux ressources éducatives. Une application bien conçue permet de gérer les livres, les étudiants et les emprunts de manière organisée, facilitant ainsi le suivi des ressources disponibles et des demandes des étudiants.

## 📌L'Objectif
L'objectif de ce projet est de développer une application qui facilite la gestion des bibliothèques scolaires en permettant :
- ✅ L'enregistrement et le suivi des livres.
- ✅ La gestion des emprunts par les étudiants.
- ✅ Un filtrage et une recherche optimisés pour les livres.
- ✅ Une visualisation graphique des emprunts par catégorie.
  
## 📌 Fonctionnalités 
📍 Ajouter/Supprimer un livre : Gestion facile du catalogue de livres.

📍 Enregistrer un emprunt : Suivre qui emprunte quel livre et quand.

📍 Filtrer les emprunts par catégorie : Analyser les emprunts par type de livre.

📍 Rechercher un livre par titre : Trouver rapidement un livre dans la base de données.

📍 Afficher un graphique du taux d’emprunt par catégorie (Pie chart) : Visualiser les statistiques d'emprunt pour une évaluation rapide.

## 📌 Visualisation des Données

📊 Afficher un graphique en Pie Chart pour analyser le taux d’emprunt par catégorie, permettant d'identifier les livres les plus et les moins empruntés.


## 📌 Diagrammes UML
🎯 Diagramme de Classe

<img width="544" alt="Capture d’écran 2025-03-23 153507" src="https://github.com/user-attachments/assets/c8daf355-cc58-4c98-907d-5c167fd4f71e" />



📌 Diagramme de cas d'utilisation

<img width="541" alt="Capture d’écran 2025-03-23 142348" src="https://github.com/user-attachments/assets/5523be19-f596-41f1-aaea-7813b8058c72" />


## 📌 Structure de la Base de Données

🗄️ Modélisation des Tables
```sql
CREATE TABLE livre (
    id INT AUTO_INCREMENT PRIMARY KEY,
    titre VARCHAR(50) NOT NULL,
    auteur VARCHAR(50) NOT NULL,
    categorie ENUM('roman', 'nouvelle', 'autobiographie', 'policier', 'romance') NOT NULL,
    disponible TINYINT NOT NULL
);

CREATE TABLE etudiant (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(50) NOT NULL
);

CREATE TABLE empruntlivre (
    idEtudiant INT NOT NULL,
    idLivre INT NOT NULL,
    dateEmprunt DATE NOT NULL,
    dateRetour DATE NOT NULL,
    PRIMARY KEY (idEtudiant, idLivre),
    FOREIGN KEY (idEtudiant) REFERENCES etudiant(id) ON DELETE CASCADE,
    FOREIGN KEY (idLivre) REFERENCES livre(id) ON DELETE CASCADE
);  

CREATE TABLE user (
    login VARCHAR(100) NOT NULL PRIMARY KEY,
    password VARCHAR(100) NOT NULL,
    email VARCHAR(50) NOT NULL UNIQUE
);
```
## Technologies Utilisées:
-NetBeans (Java) : Pour le développement de l’application.

-MySQL: Pour la gestion de la base de données.

-SWING : Pour l'interface graphique et rendre l’application facile à utiliser.

-Bibliothèque graphique : JFreeChart

-Outils de développement :
- IDE Java : NetBeans - Conception : MagicDraw -
- Outil de gestion de base de données : phpMyAdmin
- Accès aux données : JDBC
  
## Vidéo Démonstrative


https://github.com/user-attachments/assets/ee6ed8d4-831b-45ee-b299-e68a075d0a41




