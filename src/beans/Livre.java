package beans;

/**
 *
 * @author a
 */

public class Livre {
    private int id;
    private String titre;
    private String auteur;
    private String categorie;
    private boolean disponible;

    public Livre(int id, String titre, String auteur, String categorie, boolean disponible) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.disponible = disponible;
    }
    
    public Livre(String titre, String auteur, String categorie, boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.disponible = disponible;
    }
    public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitre() {
		return titre;
	}
	public void setTitre(String titre) {
		this.titre = titre;
	}
	public String getAuteur() {
		return auteur;
	}
	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}
	public String getCategorie() {
		return categorie;
	}
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	public boolean isDisponible() {
	    return disponible;
	}
	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
}