package beans;

import java.time.LocalDate;

public class EmpruntLivre {
    private int id;
    private int livreId;
    private int etudiantId;
    private LocalDate dateEmprunt;
    private LocalDate dateRetour;

    public EmpruntLivre(int id, int livreId, int etudiantId, LocalDate dateEmprunt, LocalDate dateRetour) {
        this.id = id;
        this.livreId = livreId;
        this.etudiantId = etudiantId;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
    }

    public EmpruntLivre(int livreId, int etudiantId, LocalDate dateEmprunt, LocalDate dateRetour) {
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

    public LocalDate getDateEmprunt() {
        return dateEmprunt;
    }

    public void setDateEmprunt(LocalDate dateEmprunt) {
        this.dateEmprunt = dateEmprunt;
    }

    public LocalDate getDateRetour() {
        return dateRetour;
    }

    public void setDateRetour(LocalDate dateRetour) {
        this.dateRetour = dateRetour;
    }
}