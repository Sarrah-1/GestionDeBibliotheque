/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.ECategorie;
import beans.EStatut;
import beans.EmpruntLivre;
import beans.Etudiant;
import beans.Livre;
import java.text.ParseException;
import java.util.Date;
import java.util.List;
import services.EmpruntService;
import services.EtudiantService;
import services.LivreService;

public class Test {
    //private static Object sdf;

    //public static void main(String[] args) throws ParseException {

    public static void main(String[] args) {
        EtudiantService es = new EtudiantService();
        LivreService ls = new LivreService();
        EmpruntService emps = new EmpruntService();

        if (ls.findById(1) == null) {
            ls.create(new Livre("Les Misérables", "Victor Hugo", ECategorie.ROMAN, true));
        }

        es.create(new Etudiant("ouaday ", "sara", "s.ouaday@gmail.com"));
        es.create(new Etudiant("saab", "hajar", "h.saab@gmail.com"));
        es.create(new Etudiant("roma", "mouna", "m.roma@gmail.com"));
        //LivreService ls = new LivreService();
        
        
        ls.create(new Livre(0, "Le Petit Prince", "Antoine de Saint-Exupéry", ECategorie.CONTE, true));
        ls.create(new Livre(0, "1984", "George Orwell", ECategorie.NOUVELLE, true));

        Livre livre = ls.findById(1);

        if (livre != null && livre.isDisponible()) {
            System.out.println("Livre trouvé: " + livre.getTitre() + " " + livre.getAuteur() + " " + livre.getCategorie());
        } else {
            System.out.println("Livre non trouvé ou emprunté!");
        }

        livre.setTitre("Les Misérables");
        ls.update(livre);
        System.out.println("Titre mis à jour: " + ls.findById(1).getTitre());

        List<Livre> livres = ls.findAll();
        for (Livre l : livres) {
            System.out.println("- Titre: " + l.getTitre() + "\n" + "- Auteur: " + l.getAuteur() + "\n" + "- Catégorie: " + l.getCategorie());
        }

        Date dateEmprunt = new Date();
        Date dateRetour = new Date(dateEmprunt.getTime() + (7L * 24 * 60 * 60 * 1000)); // Il faut rendre le livre dans 7 jours

        emps.create(new EmpruntLivre(EStatut.EN_COURS, dateEmprunt, dateRetour, ls.findById(1), es.findById(1)));
        emps.create(new EmpruntLivre(EStatut.EN_COURS, dateEmprunt, dateRetour, ls.findById(2), es.findById(2)));
        /*
         List<EmpruntLivre> emprunts = emps.findAll();
         for (EmpruntLivre em : emprunts) {
         System.out.println("- Emprunts: " + em.getEtudiant().getNom() + "\n" + em.getEtudiant().getPrenom() + "\n" + em.getLivre().getTitre() + "\n" + em.getDateEmprunt() + " " + em.getDateRetour());
         }
         EmpruntLivre empruntSuppr = emps.findAll().get(0);
         emps.delete(empruntSuppr);
         System.out.println("Emprunt supprimé: \n" + " -" + empruntSuppr.getEtudiant().getNom() + "\n -" + empruntSuppr.getLivre().getTitre());

         System.out.println("Liste des emprunts mise à jour: ");
         for (EmpruntLivre emp : emps.findAll()) {
         System.out.println("Emprunt: " + emp.getEtudiant().getNom() + " -> " + emp.getLivre().getTitre());
         }

         Etudiant etudiant = es.findById(1);
         if (etudiant != null) {
         System.out.println("Étudiant existant: " + etudiant.getNom());
         etudiant.setNom("Bendriouich");
         es.update(etudiant);
         System.out.println("Nom mis à jour avec succès! -> " + es.findById(1).getNom());
         }
         */
        List<Etudiant> etudiants = es.findAll();
        for (Etudiant e : etudiants) {
            System.out.println("- Nom: " + e.getNom() + "\n" + "- Prénom: " + e.getPrenom() + "\n" + "- Email: " + e.getEmail() + "\n");
        }


        livres = ls.rechercherLivreParTitre("Les Misérables");
        if (!livres.isEmpty()) {
            Livre rech = livres.get(0);
            System.out.println(rech.getTitre());
        } else {
            System.out.println("Aucun livre trouvé pour ce Titre.");
        }

        List<EmpruntLivre> empruntsFiltrés = emps.findEmpruntsByCategorie(ECategorie.ROMAN);
        if (empruntsFiltrés.isEmpty()) {
            System.out.println("Aucun emprunt trouvé pour cette catégorie");
        } else {
            System.out.println("Liste des emprunts pour la catégorie 'roman':");
            for (EmpruntLivre em : empruntsFiltrés) {
                Etudiant etudiant = em.getEtudiant();
                Livre lv = em.getLivre();          
                
                // Afficher les informations
                System.out.println("- Étudiant: " + etudiant.getNom() + " " + etudiant.getPrenom());
                System.out.println("  Livre: " + livre.getTitre() + " de " + lv.getAuteur());
                System.out.println("  Catégorie: " + lv.getCategorie());
                System.out.println("  Date d'emprunt: " + em.getDateEmprunt());
                System.out.println("  Date de retour: " + em.getDateRetour());
                System.out.println(); // Ligne vide pour séparer les emprunts
            }

        }
    }
}
