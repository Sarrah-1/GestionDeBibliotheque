package services;

import beans.EmpruntLivre;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.List;

public class EmpruntService implements IDao<EmpruntLivre> {
    private Connexion connexion;

    public EmpruntService() {
        connexion = Connexion.getInstance();
    }

    @Override
    public boolean create(EmpruntLivre o) {
        String req = "INSERT INTO emprunt_livre (livre_id, etudiant_id, date_emprunt, date_retour) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = connexion.getCn().prepareStatement(req)) {
            ps.setInt(1, o.getLivreId());
            ps.setInt(2, o.getEtudiantId());
            ps.setDate(3, Date.valueOf(o.getDateEmprunt()));
            ps.setDate(4, Date.valueOf(o.getDateRetour()));
            ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return false;
    }

	@Override
	public boolean delete(EmpruntLivre o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(EmpruntLivre o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public EmpruntLivre findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmpruntLivre> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

    // Implémentez les autres méthodes (delete, update, findById, findAll)
}