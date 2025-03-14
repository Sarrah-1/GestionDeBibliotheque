package services;

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
        String req = "insert into emprunt_livre (statut, dateEmprunt, dateRetour, etudiant_id, livre_id) values (?, ?, ?, ?, ?)";
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
        String req = "delete from emprunt_livre where livre_id = ? AND etudiant_id = ?";
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
        String req = "update emprunt_livre SET date_emprunt = ?, date_retour = ? where livre_id = ? AND etudiant_id = ?";
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

    @Override
    public EmpruntLivre findById(int id) {
        return null;
    }

    @Override
    public List<EmpruntLivre> findAll() {
        List<EmpruntLivre> emprunts = new ArrayList<>();
        String req = "select * from emprunt_livre";
        try {
            PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Livre livre = lvs.findById(rs.getInt("livre_id"));
                
                Etudiant etudiant = es.findById(rs.getInt("etudinat_id"));

                emprunts.add(new EmpruntLivre(EStatut.valueOf(rs.getString("statut").toUpperCase()), rs.getDate("date_emprunt"), rs.getDate("date_retour"), livre, etudiant
));
             
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return emprunts;
    }
}
