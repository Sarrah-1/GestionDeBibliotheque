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
import beans.EStatut;
import beans.Etudiant;
import beans.EmpruntLivre;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author hp
 */
public class Test {
    //private static Object sdf;

    public static void main(String[] args) throws ParseException {
        

        EtudiantService es = new EtudiantService();

        EmpruntService ems = new EmpruntService();

        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        es.create(new Etudiant("salma", "Sara", "S.salma@gmail.com"));
        es.create(new Etudiant("imane", "Hajaar", "H.imane@gmail.com"));
        es.delete(es.findById(2));

        Etudiant e = es.findById(1);
        e.setNom("Amal");
        e.setPrenom("Raji");
        e.setEmail("amal@gmail.com");
        es.update(e);

        System.out.println("Etudiant : ");
        for (Etudiant et : es.findAll()) {
            System.out.println("   " + et.getNom());
        }
        LivreService ls = new LivreService();
        
        ls.create(new Livre(0, "Le Petit Prince", "Antoine de Saint-Exupéry", "Conte philosophique", true));
        ls.create(new Livre(0, "1984", "George Orwell", "Science-fiction", true));

        //Livre livredelete = ls.findById(2);
        Livre livre1 = ls.findById(1);
        if (livre1 != null) {
            livre1.setTitre("livre Test");
            ls.update(livre1);
        }

        System.out.println("livre : ");
        for (Livre liv : ls.findAll()) {
            System.out.println("   " + liv.getTitre());
        }
        EStatut EMPRUNT = EStatut.EMPRUNT;
        Etudiant etudiant = es.findById(1);
        Livre livre2 = ls.findById(1);

        ems.create(new EmpruntLivre(EStatut.EMPRUNT, sdf.parse("15-03-2025"), null, ls.findById(1), es.findById(1)));

        System.out.println("Emprunt enregistré pour le livre : " + ls.findById(1).getTitre());
        
    }
}
