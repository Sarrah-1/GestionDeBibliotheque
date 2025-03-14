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
