package services;

import beans.EmpruntLivre;
import connexion.Connexion;
import dao.IDao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpruntService implements IDao<EmpruntLivre> {
	private Connexion connexion;

	public EmpruntService() {
		connexion = Connexion.getInstance();
	}

	@Override
	public boolean create(EmpruntLivre o) {
		String req = "insert into emprunt_livre (livre_id, etudiant_id, date_emprunt, date_retour) values (?, ?, ?, ?)";
		try {
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ps.setInt(1, o.getLivreId());
			ps.setInt(2, o.getEtudiantId());
		        ps.setDate(3, new java.sql.Date(o.getDateEmprunt().getTime()));
                        ps.setDate(4, new java.sql.Date(o.getDateRetour().getTime()));   
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(EmpruntLivre o) {
		String req = "delete from emprunt_livre where id = ?";
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
	public boolean update(EmpruntLivre o) {
		String req = "update emprunt_livre SET livre_id = ?, etudiant_id = ?, date_emprunt = ?, date_retour = ? where id = ?";
		try {
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ps.setInt(1, o.getLivreId());
			ps.setInt(2, o.getEtudiantId());
			ps.setDate(3, new java.sql.Date(o.getDateEmprunt().getTime()));
                        ps.setDate(4, new java.sql.Date(o.getDateRetour().getTime()));
			ps.setInt(5, o.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public EmpruntLivre findById(int id) {
		String req = "select * from emprunt_livre where id = ?";
		try {
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new EmpruntLivre(rs.getInt("id"), rs.getInt("livre_id"), rs.getInt("etudiant_id"),
                        rs.getDate("date_emprunt"), rs.getDate("date_retour"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

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
                        emprunts.add(new EmpruntLivre(rs.getInt("id"), rs.getInt("livre_id"), rs.getInt("etudiant_id"),
                           rs.getDate("date_emprunt"), rs.getDate("date_retour"))); // Récupérer Date sans conversion
                        }
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return emprunts;
	}
}