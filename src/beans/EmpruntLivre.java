package beans;

import java.util.Date;

public class EmpruntLivre {
    private EStatut statut;
    private Date dateEmprunt;
    private Date dateRetour;
    private Livre livre;
    private Etudiant etudiant;

    public EmpruntLivre(EStatut statut, Date dateEmprunt, Date dateRetour,Livre livre, Etudiant etudiant ) {
        this.statut = statut;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.livre = livre;
        this.etudiant = etudiant;
    }
    public EStatut getStatut() {
        return statut;
    }

    public void setStatut(EStatut statut) {
        this.statut = statut;
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

    public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre Livre) {
        this.livre = Livre;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }
    public int getLivreId() {
    return livre != null ? livre.getId() : -1; // Retourne -1 si le livre est null
    }
    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}