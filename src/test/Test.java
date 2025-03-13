/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.List;
import services.EmpruntService;
import services.LivreService;
import services.EtudiantService;
import beans.Livre;
import beans.Etudiant;
import beans.EmpruntLivre;
import java.text.ParseException;
import java.text.SimpleDateFormat;
/**
 *
 * @author hp
 */
public class Test {
    public static void main(String[] args) throws ParseException {
        LivreService ls = new LivreService();
        EtudiantService es = new EtudiantService();
        EmpruntService empruntService = new EmpruntService();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        // 📚 Création des livres
        System.out.println("Ajout de livres...");
        ls.create(new Livre(0, "Le Petit Prince", "Antoine de Saint-Exupéry", "Conte philosophique", true));
        ls.create(new Livre(0, "1984", "George Orwell", "Science-fiction", true));

        // 🎓 Création des étudiants
        System.out.println("Ajout d'étudiants...");
        es.create(new Etudiant("Ouaday", "Sara", "S.ouaday@gmail.com"));
        es.create(new Etudiant("Saab", "Hajar", "H.saab@gmail.com"));

        // 🔄 Récupération des livres et étudiants depuis la BD
        List<Livre> livres = ls.findAll();
        List<Etudiant> etudiants = es.findAll();

        if (livres.isEmpty() || etudiants.isEmpty()) {
            System.out.println("Erreur : Aucun livre ou étudiant en base !");
            return;
        }

        // 📚 Sélection d’un livre et étudiant pour le test
        Livre livre = livres.get(0); // Prend le premier livre
        Etudiant etudiant = etudiants.get(0); // Prend le premier étudiant

        // 🛠 Mise à jour du livre
        System.out.println("Mise à jour du livre : " + livre.getTitre());
        livre.setTitre("Nineteen Eighty-Four");
        ls.update(livre);

        // 🗑 Suppression d’un étudiant
        Etudiant etudiantASupprimer = es.findById(etudiants.get(1).getId()); // Prend le deuxième étudiant
        if (etudiantASupprimer != null) {
            System.out.println("Suppression de l'étudiant: " + etudiantASupprimer.getNom());
            es.delete(etudiantASupprimer);
        }

        // 📅 Gestion des emprunts
        System.out.println("\nTest des emprunts...");
        EmpruntLivre emprunt = new EmpruntLivre(livre.getId(), etudiant.getId(), sdf.parse("15-03-2025"), null);
        empruntService.create(emprunt);
        System.out.println("Emprunt enregistré pour le livre : " + livre.getTitre());

        // 🕒 Mise à jour de l'emprunt (ajout de la date de retour)
        emprunt.setDateRetour(sdf.parse("30-03-2025"));
        empruntService.update(emprunt);
        System.out.println("Date de retour mise à jour : " + sdf.format(emprunt.getDateRetour()));

        // 📋 Affichage des emprunts
        System.out.println("Liste des emprunts en base:");
        for (EmpruntLivre e : empruntService.findAll()) {
            String dateRetour = e.getDateRetour() != null ? sdf.format(e.getDateRetour()) : "Non retourné";
            System.out.println(e.getId() + " - Livre: " + e.getLivreId() + 
                               " - Étudiant: " + e.getEtudiantId() + 
                               " - Date d'emprunt: " + sdf.format(e.getDateEmprunt()) + 
                               " - Date de retour: " + dateRetour);
        }

        System.out.println("\n✅ Tests terminés avec succès !");
    }
}


