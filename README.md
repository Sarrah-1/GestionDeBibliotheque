Gestion des Bibliothèques Scolaires :

Contexte
La gestion des bibliothèques scolaires est essentielle pour assurer un accès efficace aux ressources éducatives. Une application bien conçue permet de gérer les livres, les étudiants et les emprunts de manière organisée, facilitant ainsi le suivi des ressources disponibles et des demandes des étudiants.

Objectif
L'objectif de ce projet est de développer une application qui facilite la gestion des bibliothèques scolaires en permettant :
- L'enregistrement et le suivi des livres.
- La gestion des emprunts par les étudiants.
- Un filtrage et une recherche optimisés pour les livres.
- Une visualisation graphique des emprunts par catégorie.

Fonctionnalités
- Ajouter/Supprimer un livre
- Enregistrer un emprunt
- Filtrer les emprunts par catégorie
- Rechercher un livre par titre
- Afficher un graphique du taux d’emprunt par catégorie (Pie chart)
  
Visualisation des Données
- Afficher un graphique en Pie Chart pour analyser le taux d’emprunt par catégorie.
  
CREATE TABLE Livre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    titre VARCHAR(50) NOT NULL,
    auteur VARCHAR(50) NOT NULL,
    categorie VARCHAR(100) NOT NULL,
    disponible BOOLEAN NOT NULL DEFAULT TRUE
);

CREATE TABLE Etudiant (
    id INT PRIMARY KEY AUTO_INCREMENT,
    nom VARCHAR(50) NOT NULL,
    prenom VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE
);

CREATE TABLE EmpruntLivre (
    id INT PRIMARY KEY AUTO_INCREMENT,
    livre_id INT,
    etudiant_id INT,
    date_emprunt DATE NOT NULL,
    date_retour DATE,
    FOREIGN KEY (livre_id) REFERENCES Livre(id) ON DELETE CASCADE,
    FOREIGN KEY (etudiant_id) REFERENCES Etudiant(id) ON DELETE CASCADE
);
