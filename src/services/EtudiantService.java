package services;

import beans.Etudiant;
import connexion.Connexion;
import dao.IDao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;

public class EtudiantService implements IDao<Etudiant> {

	private Connexion connexion;

	public EtudiantService() {
		connexion = Connexion.getInstance();
	}

	@Override
	public boolean create(Etudiant o) {
		String req = "insert into Etudiant (nom, prenom, email) values (?, ?, ?)";
		try {
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getEmail());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean delete(Etudiant o) {
		String req = "delete from Etudiant where id = ?";
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
	public boolean update(Etudiant o) {
		String req = "update etudiant set nom = ?, prenom = ?, email = ? where id  = ?";
		try {
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ps.setString(1, o.getNom());
			ps.setString(2, o.getPrenom());
			ps.setString(3, o.getEmail());
			ps.setInt(4, o.getId());
			ps.executeUpdate();
			return true;
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public Etudiant findById(int id) {
		String req = "select * from Etudiant where id  = ?";
		try {
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next())
				return new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email"));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Etudiant> findAll() {
		List<Etudiant> etudiants = new ArrayList<>();
		String req = "select * from Etudiant";
		try {
			PreparedStatement ps = connexion.getCn().prepareStatement(req);
			ResultSet rs = ps.executeQuery();
			while (rs.next())
				etudiants.add(new Etudiant(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"),
						rs.getString("email")));
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return etudiants;
	}

}
