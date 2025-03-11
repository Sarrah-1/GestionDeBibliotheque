/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import beans.Livre;
import beans.Etudiant;
import beans.EmpruntLivre;
import services.LivreService;
import services.EtudiantService;
import services.EmpruntService; 

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
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        /*
        ls.create(new Livre("Le Petit Prince", "Sara", "12222"));
        ls.create(new Livre("1984", "hAJAR", "111111"));
        
        // Suppression d'un livre
        ls.delete(ls.findById(1));
        
        // Mise à jour d'un livre
        Livre livre = ls.findById(2);
        livre.setTitre("Nineteen Eighty-Four");
        livre.setAuteur("George Orwell");
        ls.update(livre);
        */

        /*
        es.create(new Etudiant("Ouaday", "Sara", "S.ouaday@gmail.com"));
        es.create(new Etudiant("Saab", "Hajar", "H.saab@gmail.com"));
        
        es.delete(es.findById(1));
        
        Etudiant etudiant = es.findById(2);
        etudiant.setNom("Amal");
        etudiant.setPrenom("Raji");
        etudiant.setEmail("amal@gmail.com");
        es.update(etudiant);
        */

        /*
        EmpruntService empruntService = new EmpruntService();
        Emprunt emprunt = new Emprunt(livre, etudiant, sdf.parse("15-03-2025")); // Assurez-vous que le livre et l'étudiant existent
        empruntService.create(emprunt);
        
        emprunt.setDateRetour(sdf.parse("30-03-2025"));
        empruntService.update(emprunt);
        */
        
        System.out.println("Teste exécutés avec succès !");
    }
}