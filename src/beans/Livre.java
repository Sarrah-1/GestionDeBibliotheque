package beans;

/**
 *
 * @author a
 */
public class Livre {

    private int id;
    private String titre;
    private String auteur;
    private ECategorie categorie;
    private boolean disponible;
    

    public Livre(int id, String titre, String auteur,  ECategorie categorie, boolean disponible) {
        this.id = id;
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.disponible = disponible;
    }

    public Livre(String titre, String auteur,  ECategorie categorie, boolean disponible) {
        this.titre = titre;
        this.auteur = auteur;
        this.categorie = categorie;
        this.disponible = disponible;
    }

    public Livre(String titre, String auteur, ECategorie categorie, String disponible) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public ECategorie getCategorie() {
        return categorie;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return titre ;
    }

}
