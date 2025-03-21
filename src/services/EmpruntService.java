package services;

import beans.ECategorie;
import beans.EmpruntLivre;
import beans.Etudiant;
import beans.Livre;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import beans.EStatut;

public class EmpruntService implements IDao<EmpruntLivre> {

    private Connexion connexion;
    private LivreService lvs;
    private EtudiantService es;

    public EmpruntService() {
        connexion = Connexion.getInstance();
        lvs = new LivreService();
        es = new EtudiantService();

    }

    @Override
    public boolean create(EmpruntLivre o) {
        String req = "insert into empruntlivre (statut, dateEmprunt, dateRetour, etudiant_id, livre_id) values (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getStatut().ordinal());
            ps.setDate(2, new java.sql.Date(o.getDateEmprunt().getTime()));
            ps.setDate(3, o.getDateRetour() != null ? new java.sql.Date(o.getDateRetour().getTime()) : null);
            ps.setInt(4, o.getEtudiant().getId());
            ps.setInt(5, o.getLivre().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(EmpruntLivre o) {
        String req = "delete from empruntlivre where livre_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(5, o.getLivre().getId());
            ps.setInt(4, o.getEtudiant().getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(EmpruntLivre o) {
        String req = "update empruntlivre SET dateEmprunt = ?, dateRetour = ? where livre_id = ? AND etudiant_id = ?";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setDate(1, new java.sql.Date(o.getDateEmprunt().getTime()));
            ps.setDate(2, new java.sql.Date(o.getDateRetour().getTime()));
            ps.setInt(3, o.getLivre().getId());
            ps.setInt(4, o.getEtudiant().getId());

            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    public List<EmpruntLivre> findEmpruntsByCategorie(ECategorie categorie) {
        List<EmpruntLivre> empruntsTrouves = new ArrayList<>();
        String req = "SELECT * FROM empruntlivre WHERE livre_id IN (SELECT id FROM livre WHERE categorie = ?)";

        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setString(1, categorie.name());

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    EmpruntLivre emprunt = new EmpruntLivre(
                            EStatut.values()[rs.getInt("statut")],
                            rs.getDate("dateEmprunt"),
                            rs.getDate("dateRetour"),
                            lvs.findById(rs.getInt("livre_id")),
                            es.findById(rs.getInt("etudiant_id"))
                    );
                    empruntsTrouves.add(emprunt);
                }
            }
        } catch (SQLException ex) {
            System.out.println("Erreur lors de la récupération des emprunts : " + ex.getMessage());
        }

        return empruntsTrouves;
    }

    @Override
    public EmpruntLivre findById(int id) {
        return null;
    }

    @Override
    public List<EmpruntLivre> findAll() {
        List<EmpruntLivre> emprunts = new ArrayList<>();
        String req = "select * from empruntlivre";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livre livre = lvs.findById(rs.getInt("livre_id"));
                Etudiant etudiant = es.findById(rs.getInt("etudiant_id"));

                int statutIndex = rs.getInt("statut"); // On récupère l'index du statut depuis la base
                EStatut statut = null;

                try {
                    // Utilisation de l'index pour récupérer l'élément de l'énumération
                    statut = EStatut.values()[statutIndex]; // Index à partir de la base de données
                } catch (ArrayIndexOutOfBoundsException e) {
                    // Si l'index est invalide, on utilise une valeur par défaut
                    statut = EStatut.EN_RETARD; // Utiliser une valeur par défaut si nécessaire
                }

                emprunts.add(new EmpruntLivre(statut, rs.getDate("dateEmprunt"), rs.getDate("dateRetour"), livre, etudiant));

            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return emprunts;
    }
}
