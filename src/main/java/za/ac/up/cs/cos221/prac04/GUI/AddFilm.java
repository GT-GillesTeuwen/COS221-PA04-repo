/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package za.ac.up.cs.cos221.prac04.GUI;

import DataObjects.Language;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import za.ac.up.cs.cos221.prac04.DBManager;

/**
 *
 * @author gteuw
 */
public class AddFilm extends javax.swing.JFrame {

    /**
     * Creates new form AddFilm
     */
    private HomePage hp;
    public AddFilm(HomePage hp) {
        this.hp=hp;
        initComponents();
        try {
            ArrayList<Language> allLanguages=DBManager.implement.populateLanguages();
            for (int i = 0; i < allLanguages.size(); i++) {
                languageComboBox.addItem(allLanguages.get(i));
                originalLanguageComboBox.addItem(allLanguages.get(i));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(AddFilm.class.getName()).log(Level.SEVERE, null, ex);
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

                titleFld = new javax.swing.JTextField();
                titleLbl = new javax.swing.JLabel();
                jScrollPane1 = new javax.swing.JScrollPane();
                descriptionArea = new javax.swing.JTextArea();
                descriptionLbl = new javax.swing.JLabel();
                releaseYearLbl = new javax.swing.JLabel();
                languageComboBox = new javax.swing.JComboBox<>();
                languageLbl = new javax.swing.JLabel();
                orginalLanguageLbl = new javax.swing.JLabel();
                originalLanguageComboBox = new javax.swing.JComboBox<>();
                rentalDurationLbl = new javax.swing.JLabel();
                rentalDurationSpinner = new javax.swing.JSpinner();
                rentalRateLbl = new javax.swing.JLabel();
                rentalRateSpinner = new javax.swing.JSpinner();
                lengthLbl = new javax.swing.JLabel();
                lengthSpinner = new javax.swing.JSpinner();
                ratingLbl = new javax.swing.JLabel();
                ratingComboBox = new javax.swing.JComboBox<>();
                jLabel10 = new javax.swing.JLabel();
                trailerCheckBox = new javax.swing.JCheckBox();
                commentariesCheckBox = new javax.swing.JCheckBox();
                deltedScenesCheckBox = new javax.swing.JCheckBox();
                behindTheScenesCheckBox = new javax.swing.JCheckBox();
                replacementCostLbl = new javax.swing.JLabel();
                replacementCostSpinner = new javax.swing.JSpinner();
                addFilmBtn = new javax.swing.JButton();
                addFilmBtn1 = new javax.swing.JButton();
                releaseYearChooser = new com.toedter.calendar.JYearChooser();

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setPreferredSize(new java.awt.Dimension(400, 370));

                titleFld.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

                titleLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                titleLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                titleLbl.setText("Title");
                titleLbl.setFocusable(false);
                titleLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                descriptionArea.setColumns(20);
                descriptionArea.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                descriptionArea.setLineWrap(true);
                descriptionArea.setRows(3);
                descriptionArea.setWrapStyleWord(true);
                jScrollPane1.setViewportView(descriptionArea);

                descriptionLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                descriptionLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                descriptionLbl.setText("Description");
                descriptionLbl.setFocusable(false);
                descriptionLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                releaseYearLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                releaseYearLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                releaseYearLbl.setText("Release Year");
                releaseYearLbl.setFocusable(false);
                releaseYearLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                languageComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

                languageLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                languageLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                languageLbl.setText("Language");
                languageLbl.setFocusable(false);
                languageLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                orginalLanguageLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                orginalLanguageLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                orginalLanguageLbl.setText("Original Language");
                orginalLanguageLbl.setFocusable(false);
                orginalLanguageLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                originalLanguageComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

                rentalDurationLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                rentalDurationLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                rentalDurationLbl.setText("Rental Duration");
                rentalDurationLbl.setFocusable(false);
                rentalDurationLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                rentalDurationSpinner.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                rentalDurationSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

                rentalRateLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                rentalRateLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                rentalRateLbl.setText("Rental Rate");
                rentalRateLbl.setFocusable(false);
                rentalRateLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                rentalRateSpinner.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                rentalRateSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

                lengthLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                lengthLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                lengthLbl.setText("Length");
                lengthLbl.setFocusable(false);
                lengthLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                lengthSpinner.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                lengthSpinner.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

                ratingLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                ratingLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                ratingLbl.setText("Rating");
                ratingLbl.setFocusable(false);
                ratingLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                ratingComboBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                ratingComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "G", "PG", "PG-13", "R", "NC-17" }));

                jLabel10.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                jLabel10.setText("Special Features");
                jLabel10.setFocusable(false);
                jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                trailerCheckBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                trailerCheckBox.setText("Trailers");
                trailerCheckBox.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                trailerCheckBoxActionPerformed(evt);
                        }
                });

                commentariesCheckBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                commentariesCheckBox.setText("Commentaries");

                deltedScenesCheckBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                deltedScenesCheckBox.setText("Delted Scenes");

                behindTheScenesCheckBox.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                behindTheScenesCheckBox.setText("Behind the Scenes");

                replacementCostLbl.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                replacementCostLbl.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
                replacementCostLbl.setText("Replacement Cost");
                replacementCostLbl.setFocusable(false);
                replacementCostLbl.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);

                replacementCostSpinner.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                replacementCostSpinner.setModel(new javax.swing.SpinnerNumberModel(0.0d, 0.0d, null, 1.0d));

                addFilmBtn.setText("Add & Close");
                addFilmBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addFilmBtnActionPerformed(evt);
                        }
                });

                addFilmBtn1.setText("Add & Close");
                addFilmBtn1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                addFilmBtn1ActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(titleLbl, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                        .addComponent(releaseYearLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(descriptionLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(languageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(orginalLanguageLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(lengthLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(ratingLbl, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(titleFld, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addGap(40, 40, 40)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                                .addComponent(rentalDurationLbl)
                                                                                .addComponent(replacementCostLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                                .addComponent(rentalRateLbl, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                                .addComponent(languageComboBox, 0, 100, Short.MAX_VALUE)
                                                                                .addComponent(releaseYearChooser, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(trailerCheckBox)
                                                                                .addComponent(jLabel10)
                                                                                .addComponent(deltedScenesCheckBox))))
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(ratingComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(lengthSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(originalLanguageComboBox, javax.swing.GroupLayout.Alignment.LEADING, 0, 100, Short.MAX_VALUE)))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(commentariesCheckBox)
                                                        .addComponent(behindTheScenesCheckBox)
                                                        .addComponent(replacementCostSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                                .addComponent(rentalDurationSpinner, javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(rentalRateSpinner, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(445, 445, 445)
                                                .addComponent(addFilmBtn1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(addFilmBtn)))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(36, 36, 36)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(titleFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(titleLbl))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(descriptionLbl)
                                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rentalDurationSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(rentalDurationLbl))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(rentalRateLbl)
                                                        .addComponent(rentalRateSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(replacementCostLbl)
                                                        .addComponent(replacementCostSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(releaseYearLbl)
                                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(releaseYearChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(1, 1, 1)))
                                .addGap(19, 19, 19)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(languageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(languageLbl)
                                        .addComponent(trailerCheckBox)
                                        .addComponent(commentariesCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(orginalLanguageLbl)
                                        .addComponent(originalLanguageComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deltedScenesCheckBox)
                                        .addComponent(behindTheScenesCheckBox))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lengthLbl)
                                        .addComponent(lengthSpinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(ratingLbl)
                                        .addComponent(ratingComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(addFilmBtn)
                                        .addComponent(addFilmBtn1))
                                .addContainerGap(11, Short.MAX_VALUE))
                );

                pack();
        }// </editor-fold>//GEN-END:initComponents

    private void trailerCheckBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_trailerCheckBoxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_trailerCheckBoxActionPerformed

    private void addFilmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFilmBtnActionPerformed
        try {
            String features="";
            if (trailerCheckBox.isSelected()) {
                features+="Trailers,";
            }
            if (commentariesCheckBox.isSelected()) {
                features+="Commentaries,";
            }
            if (deltedScenesCheckBox.isSelected()) {
                features+="Deleted Scenes,";
            }
            if (behindTheScenesCheckBox.isSelected()) {
                features+="Behind the Scenes,";
            }
            if (features.length()>0) {
                features=features.substring(0, features.length()-1);
            }
            
            DBManager.implement.insertFilm(titleFld.getText(), descriptionArea.getText(), releaseYearChooser.getYear(), ((Language)languageComboBox.getSelectedItem()).getId(), ((Language)originalLanguageComboBox.getSelectedItem()).getId(), (int)rentalDurationSpinner.getValue(), (double)rentalRateSpinner.getValue(), (int)lengthSpinner.getValue(), (double)replacementCostSpinner.getValue(), ratingComboBox.getSelectedItem().toString(), features);
            hp.refreshFilmTbl();
            this.dispose();
        } catch (SQLException ex) {
            Logger.getLogger(AddFilm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_addFilmBtnActionPerformed

    private void addFilmBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFilmBtn1ActionPerformed
        this.dispose();
    }//GEN-LAST:event_addFilmBtn1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddFilm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddFilm(null).setVisible(true);
            }
        });
    }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton addFilmBtn;
        private javax.swing.JButton addFilmBtn1;
        private javax.swing.JCheckBox behindTheScenesCheckBox;
        private javax.swing.JCheckBox commentariesCheckBox;
        private javax.swing.JCheckBox deltedScenesCheckBox;
        private javax.swing.JTextArea descriptionArea;
        private javax.swing.JLabel descriptionLbl;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JComboBox<Language> languageComboBox;
        private javax.swing.JLabel languageLbl;
        private javax.swing.JLabel lengthLbl;
        private javax.swing.JSpinner lengthSpinner;
        private javax.swing.JLabel orginalLanguageLbl;
        private javax.swing.JComboBox<Language> originalLanguageComboBox;
        private javax.swing.JComboBox<String> ratingComboBox;
        private javax.swing.JLabel ratingLbl;
        private com.toedter.calendar.JYearChooser releaseYearChooser;
        private javax.swing.JLabel releaseYearLbl;
        private javax.swing.JLabel rentalDurationLbl;
        private javax.swing.JSpinner rentalDurationSpinner;
        private javax.swing.JLabel rentalRateLbl;
        private javax.swing.JSpinner rentalRateSpinner;
        private javax.swing.JLabel replacementCostLbl;
        private javax.swing.JSpinner replacementCostSpinner;
        private javax.swing.JTextField titleFld;
        private javax.swing.JLabel titleLbl;
        private javax.swing.JCheckBox trailerCheckBox;
        // End of variables declaration//GEN-END:variables
}
