package beans;

import java.util.Date;

public class EmpruntLivre {
    private int id;
    private int livreId;
    private int etudiantId;
    private Date dateEmprunt;
    private Date dateRetour;

    public EmpruntLivre(int id, int livreId, int etudiantId, Date dateEmprunt, Date dateRetour) {
        this.id = id;
        this.livreId = livreId;
        this.etudiantId = etudiantId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public EmpruntLivre(int livreId, int etudiantId, Date dateEmprunt, Date dateRetour) {
        this.livreId = livreId;
        this.etudiantId = etudiantId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLivreId() {
        return livreId;
    }

    public void setLivreId(int livreId) {
        this.livreId = livreId;
    }

    public int getEtudiantId() {
        return etudiantId;
    }

    public void setEtudiantId(int etudiantId) {
        this.etudiantId = etudiantId;
    }

    public Date getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(Date dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public Date getDateRetour() {
        return dateRetour;
    }

   public void setDateRetour(Date dateRetour) {
        this.dateRetour = dateRetour;
    }
}