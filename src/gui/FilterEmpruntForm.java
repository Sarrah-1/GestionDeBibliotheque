/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import beans.ECategorie;
import beans.Livre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import services.EmpruntService;
import services.LivreService;
import beans.ECategorie;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.html.parser.DTDConstants;
import beans.EmpruntLivre;
import java.util.Date;
import java.util.Locale;

/**
 *
 * @author box
 */
public class FilterEmpruntForm extends javax.swing.JInternalFrame {

    private DefaultTableModel model;
    private LivreService lvs;

    /**
     * Creates new form FilterEmpruntForm
     */
    public FilterEmpruntForm() {
        initComponents();
        lvs = new LivreService();
        model = (DefaultTableModel) ListeEmpunt.getModel();
        // model = (DefaultTableModel) ListeCategorie.getModel();
        loadEcategorie();
    }

    private void loadEcategorie() {
        for (ECategorie ec : ECategorie.values()) {
            ListeCategorie.addItem(ec); // Ajoute les catégories directement
        }
    }

    public void loadEmpruntsParCategorie(ECategorie categorie) {
       // List<Livre> livres = new LivreService().rechercherLivreParCategorie(categorie);
        List<Livre> livres = lvs.rechercherLivreParCategorie(categorie);
        model.setRowCount(0);

        for (Livre livre : livres) {
            model.addRow(new Object[]{
                livre.getTitre(),
                livre.getAuteur(),
                livre.getCategorie()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btnFiltrerParCategorie = new javax.swing.JButton();
        ListeCategorie = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListeEmpunt = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 249, 244));
        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);

        jPanel1.setBackground(new java.awt.Color(255, 249, 244));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Flitrer les emprunts par Catégorie", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("Catégorie :");

        btnFiltrerParCategorie.setText("Filtrer");
        btnFiltrerParCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltrerParCategorieActionPerformed(evt);
            }
        });

        ListeCategorie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ListeCategorieActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addGap(37, 37, 37)
                .addComponent(ListeCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnFiltrerParCategorie)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(btnFiltrerParCategorie)
                    .addComponent(ListeCategorie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(59, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 249, 243));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Liste des empunts", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        ListeEmpunt.setBackground(new java.awt.Color(255, 249, 244));
        ListeEmpunt.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Titre", "Auteur", "Catégorie", "Disponibilité"
            }
        ));
        jScrollPane1.setViewportView(ListeEmpunt);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnFiltrerParCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltrerParCategorieActionPerformed

        ECategorie selectedCategory = (ECategorie) ListeCategorie.getSelectedItem();

        if (selectedCategory == null) {
            JOptionPane.showMessageDialog(this, "Veuillez sélectionner une catégorie.");
            return;
        }

        loadEmpruntsParCategorie(selectedCategory);

    }//GEN-LAST:event_btnFiltrerParCategorieActionPerformed

    private void ListeCategorieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ListeCategorieActionPerformed
      //
    }//GEN-LAST:event_ListeCategorieActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox ListeCategorie;
    private javax.swing.JTable ListeEmpunt;
    private javax.swing.JButton btnFiltrerParCategorie;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
