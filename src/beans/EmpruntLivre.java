package beans;

import java.util.Date;

public class EmpruntLivre {

    private EStatut statut;
    private Date dateEmprunt;
    private Date dateRetour;
    private Livre livre;
    private Etudiant etudiant;

    public EmpruntLivre(EStatut statut, Date dateEmprunt, Date dateRetour, Livre livre, Etudiant etudiant) {
        this.statut = statut;
        this.dateEmprunt = dateEmprunt;
        this.dateRetour = dateRetour;
        this.livre = livre;
        this.etudiant = etudiant;
    }

    public EmpruntLivre(int aInt, EStatut valueOf, java.sql.Date date, java.sql.Date date0, Livre livre, Etudiant etudiant) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EmpruntLivre(EStatut eStatut, Date parse, Object object, Livre findById, Etudiant findById0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public EmpruntLivre(EStatut eStatut, Date parse, Object object, Livre findById, Etudiant findById0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
     public Livre getLivre() {
        return livre;
    }

    public void setLivre(Livre livre) {
        this.livre = livre;
    }
}
