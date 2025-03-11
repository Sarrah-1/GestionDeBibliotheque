package test;

import beans.Etudiant;
import beans.Livre;
import beans.EmpruntLivre;
import services.EtudiantService;
import services.LivreService;
import services.EmpruntService;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        EtudiantService etudiantService = new EtudiantService();
        LivreService livreService = new LivreService();
        EmpruntService empruntService = new EmpruntService();

        // Tester le service des étudiants
        Etudiant etudiant1 = new Etudiant("Ouaday", "Sara", "S.ouaday@gmail.com");
        Etudiant etudiant2 = new Etudiant("Imani", "Rania", "R.imani@gmail.com");
        
        etudiantService.create(etudiant1);
        etudiantService.create(etudiant2);
        
        // Mettre à jour un étudiant
        etudiant1.setEmail("ouaday.sara@gmail.com");
        etudiantService.update(etudiant1);

        // Tester le service des livres
        Livre livre1 = new Livre("Titre Livre 1", "Auteur 1", "Catégorie 1", true);
        Livre livre2 = new Livre("Titre Livre 2", "Auteur 2", "Catégorie 2", true);
        
        livreService.create(livre1);
        livreService.create(livre2);
        
        // Mettre à jour un livre
        livre1.setTitre("Titre Livre Mis à Jour");
        livreService.update(livre1);

        // Tester le service des emprunts
        EmpruntLivre emprunt1 = new EmpruntLivre(1, 1, LocalDate.now(), LocalDate.now().plusDays(30));
        empruntService.create(emprunt1);

        // Afficher tous les emprunts
        System.out.println("Emprunts:");
        for (EmpruntLivre emprunt : empruntService.findAll()) {
            System.out.println("ID: " + emprunt.getId() + ", Livre ID: " + emprunt.getLivreId() + ", Étudiant ID: " + emprunt.getEtudiantId());
        }
    }
}