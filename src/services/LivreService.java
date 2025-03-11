package services;

import beans.Livre;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.List;

public class LivreService implements IDao<Livre> {
    private Connexion connexion;

    public LivreService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(Livre o) {
        String req = "INSERT INTO livre (titre, auteur, categorie, disponible) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Livre o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Livre findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Livre> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

    // Implémentez les autres méthodes (delete, update, findById, findAll)
}