package services;

import beans.Livre;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LivreService implements IDao<Livre> {
    private Connexion connexion;

    public LivreService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Livre o) {
        String req = "insert into livre (titre, auteur, categorie, disponible) values (?, ?, ?, ?)";
        try {
        	PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getTitre());
            ps.setString(2, o.getAuteur());
            ps.setString(3, o.getCategorie());
            ps.setBoolean(4, o.isDisponible());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean delete(Livre o) {
        String req = "delete from livre where id = ?";
        try {
        	PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public boolean update(Livre o) {
        String req = "update livre SET titre = ?, auteur = ?, categorie = ?, disponible = ? where id = ?";
        try {
        	PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setString(1, o.getTitre());
            ps.setString(2, o.getAuteur());
            ps.setString(3, o.getCategorie());
            ps.setBoolean(4, o.isDisponible());
            ps.setInt(5, o.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

    @Override
    public Livre findById(int id) {
        String req = "select * from livre where id = ?";
        try {
        	PreparedStatement ps = connexion.getCn().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"),
                                 rs.getString("categorie"), rs.getBoolean("disponible"));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return null;
    }

    @Override
    public List<Livre> findAll() {
        List<Livre> livres = new ArrayList<>();
        String req = "SELECT * FROM livre";
        try {
        	PreparedStatement ps = connexion.getCn().prepareStatement(req); 
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                livres.add(new Livre(rs.getInt("id"), rs.getString("titre"), rs.getString("auteur"),
                                     rs.getString("categorie"), rs.getBoolean("disponible")));
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return livres;
    }
}