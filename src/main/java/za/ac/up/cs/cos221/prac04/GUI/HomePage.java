/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.up.cs.cos221.prac04.GUI;

import DataObjects.Film;
import DataObjects.Staff;
import DataObjects.StoreGenreCount;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import za.ac.up.cs.cos221.prac04.DBManager;

/**
 *
 * @author User
 */
public class HomePage extends javax.swing.JFrame {

    /**
     * Creates new form HomePage
     */
    public HomePage() throws SQLException {
        initComponents();
        refreshStaffTbl();
        refreshFilmTbl();
        refreshStoreGenreCountTbl();

    }

    private void clearFilter() {
        StaffTbl.setRowSorter(null);

    }

    private void refreshStaffTbl() throws SQLException {
        String staffCol[] = {"First Name", "Last Name", "Address", "Address2", "District", "City", "Postal Code", "Phone", "Store", "Active"};
        for (int i = 0; i < staffCol.length; i++) {
            filterComboBox.addItem(staffCol[i]);
        }
        DefaultTableModel staffTableModel = new DefaultTableModel(staffCol, 0);
        StaffTbl.setModel(staffTableModel);
        ArrayList<Staff> staff = DBManager.implement.populateStaff();
        for (int i = 0; i < staff.size(); i++) {
            Object[] temp = {staff.get(i).getFirstName(), staff.get(i).getLastName(), staff.get(i).getAddress(), staff.get(i).getAddress2(),
                staff.get(i).getDistrict(), staff.get(i).getCity(), staff.get(i).getPostalCode(), staff.get(i).getPhone(),
                staff.get(i).getStore(), staff.get(i).getActive()};
            staffTableModel.addRow(temp);
        }
    }

    public void refreshFilmTbl() throws SQLException {

        String filmCol[] = {"Title", "Description", "Release Year", "Length", "Rating"};

        DefaultTableModel filmTableModel = new DefaultTableModel(filmCol, 0);

        FilmsTbl.setModel(filmTableModel);

        ArrayList<Film> films = DBManager.implement.populateFilms();

        for (int i = 0; i < films.size(); i++) {
            Object[] temp = {films.get(i).getTitle(), films.get(i).getDescription(), films.get(i).getReleaseYear(), films.get(i).getLength(), films.get(i).getRating()};
            filmTableModel.addRow(temp);
        }
    }
    
    public void refreshStoreGenreCountTbl() throws SQLException {

        String storeGenreCountCol[] = {"Store Name", "Genre", "Number in stock"};

        DefaultTableModel storeGenreCountModel = new DefaultTableModel(storeGenreCountCol, 0);

        storeGenreCountTbl.setModel(storeGenreCountModel);

        ArrayList<StoreGenreCount> storeGenreCount = DBManager.implement.populateStoreGenreCount();

        for (int i = 0; i < storeGenreCount.size(); i++) {
            Object[] temp = {storeGenreCount.get(i).getStore(), storeGenreCount.get(i).getGenre(), storeGenreCount.get(i).getNumber()};
            storeGenreCountModel.addRow(temp);
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

        jTabbedPane2 = new javax.swing.JTabbedPane();
        StaffTab = new javax.swing.JPanel();
        StaffPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        StaffTbl = new javax.swing.JTable();
        filterFld = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        filterComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        FilterBtn = new javax.swing.JButton();
        clearFilterBtn = new javax.swing.JButton();
        FilmsTab = new javax.swing.JPanel();
        FilmsPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        FilmsTbl = new javax.swing.JTable();
        addFilmBtn = new javax.swing.JButton();
        InventoryTab = new javax.swing.JPanel();
        InventoryPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        storeGenreCountTbl = new javax.swing.JTable();
        ClientsTab = new javax.swing.JPanel();
        ClientsPanel = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(400, 500));

        jTabbedPane2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

        StaffPanel.setBackground(new java.awt.Color(255, 51, 51));

        jScrollPane1.setViewportView(StaffTbl);

        filterFld.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                filterFldActionPerformed(evt);
            }
        });

        jLabel1.setText("Filter by");

        jLabel2.setText("like");

        FilterBtn.setText("Filter");
        FilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FilterBtnActionPerformed(evt);
            }
        });

        clearFilterBtn.setText("Clear Filter");
        clearFilterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearFilterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout StaffPanelLayout = new javax.swing.GroupLayout(StaffPanel);
        StaffPanel.setLayout(StaffPanelLayout);
        StaffPanelLayout.setHorizontalGroup(
            StaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(StaffPanelLayout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(filterFld, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(FilterBtn)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(clearFilterBtn)
                .addContainerGap(323, Short.MAX_VALUE))
        );
        StaffPanelLayout.setVerticalGroup(
            StaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(StaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(filterFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(FilterBtn)
                    .addComponent(clearFilterBtn))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout StaffTabLayout = new javax.swing.GroupLayout(StaffTab);
        StaffTab.setLayout(StaffTabLayout);
        StaffTabLayout.setHorizontalGroup(
            StaffTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(StaffTabLayout.createSequentialGroup()
                .addComponent(StaffPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        StaffTabLayout.setVerticalGroup(
            StaffTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(StaffPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Staff", StaffTab);

        FilmsPanel.setBackground(new java.awt.Color(255, 153, 51));

        jScrollPane2.setViewportView(FilmsTbl);

        addFilmBtn.setText("Add Film");
        addFilmBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFilmBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FilmsPanelLayout = new javax.swing.GroupLayout(FilmsPanel);
        FilmsPanel.setLayout(FilmsPanelLayout);
        FilmsPanelLayout.setHorizontalGroup(
            FilmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilmsPanelLayout.createSequentialGroup()
                .addContainerGap(745, Short.MAX_VALUE)
                .addComponent(addFilmBtn)
                .addGap(66, 66, 66))
            .addGroup(FilmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FilmsPanelLayout.createSequentialGroup()
                    .addGap(16, 16, 16)
                    .addComponent(jScrollPane2)
                    .addGap(17, 17, 17)))
        );
        FilmsPanelLayout.setVerticalGroup(
            FilmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilmsPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(addFilmBtn)
                .addContainerGap(336, Short.MAX_VALUE))
            .addGroup(FilmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(FilmsPanelLayout.createSequentialGroup()
                    .addGap(63, 63, 63)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(40, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout FilmsTabLayout = new javax.swing.GroupLayout(FilmsTab);
        FilmsTab.setLayout(FilmsTabLayout);
        FilmsTabLayout.setHorizontalGroup(
            FilmsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FilmsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        FilmsTabLayout.setVerticalGroup(
            FilmsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(FilmsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Films", FilmsTab);

        InventoryPanel.setBackground(new java.awt.Color(255, 255, 51));

        storeGenreCountTbl.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane3.setViewportView(storeGenreCountTbl);

        javax.swing.GroupLayout InventoryPanelLayout = new javax.swing.GroupLayout(InventoryPanel);
        InventoryPanel.setLayout(InventoryPanelLayout);
        InventoryPanelLayout.setHorizontalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(InventoryPanelLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 836, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );
        InventoryPanelLayout.setVerticalGroup(
            InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryPanelLayout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 284, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout InventoryTabLayout = new javax.swing.GroupLayout(InventoryTab);
        InventoryTab.setLayout(InventoryTabLayout);
        InventoryTabLayout.setHorizontalGroup(
            InventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InventoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        InventoryTabLayout.setVerticalGroup(
            InventoryTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(InventoryPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Inventory", InventoryTab);

        ClientsPanel.setBackground(new java.awt.Color(0, 204, 0));

        javax.swing.GroupLayout ClientsPanelLayout = new javax.swing.GroupLayout(ClientsPanel);
        ClientsPanel.setLayout(ClientsPanelLayout);
        ClientsPanelLayout.setHorizontalGroup(
            ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 889, Short.MAX_VALUE)
        );
        ClientsPanelLayout.setVerticalGroup(
            ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 381, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout ClientsTabLayout = new javax.swing.GroupLayout(ClientsTab);
        ClientsTab.setLayout(ClientsTabLayout);
        ClientsTabLayout.setHorizontalGroup(
            ClientsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ClientsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        ClientsTabLayout.setVerticalGroup(
            ClientsTabLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ClientsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Clients", ClientsTab);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 889, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addComponent(jTabbedPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 412, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void filterFldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_filterFldActionPerformed
            // TODO add your handling code here:
        }//GEN-LAST:event_filterFldActionPerformed

        private void FilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FilterBtnActionPerformed
            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(((DefaultTableModel) StaffTbl.getModel()));
            sorter.setRowFilter(RowFilter.regexFilter(filterFld.getText(), filterComboBox.getSelectedIndex()));

            StaffTbl.setRowSorter(sorter);
        }//GEN-LAST:event_FilterBtnActionPerformed

        private void clearFilterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearFilterBtnActionPerformed
            clearFilter();
        }//GEN-LAST:event_clearFilterBtnActionPerformed

    private void addFilmBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFilmBtnActionPerformed
        AddFilm newPane = new AddFilm(this);
        newPane.pack();
        newPane.setLocationRelativeTo(null);
        newPane.setSize(950, 500);
        newPane.setVisible(true);
    }//GEN-LAST:event_addFilmBtnActionPerformed

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
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomePage.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new HomePage().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel ClientsPanel;
    private javax.swing.JPanel ClientsTab;
    private javax.swing.JPanel FilmsPanel;
    private javax.swing.JPanel FilmsTab;
    private javax.swing.JTable FilmsTbl;
    private javax.swing.JButton FilterBtn;
    private javax.swing.JPanel InventoryPanel;
    private javax.swing.JPanel InventoryTab;
    private javax.swing.JPanel StaffPanel;
    private javax.swing.JPanel StaffTab;
    private javax.swing.JTable StaffTbl;
    private javax.swing.JButton addFilmBtn;
    private javax.swing.JButton clearFilterBtn;
    private javax.swing.JComboBox<String> filterComboBox;
    private javax.swing.JTextField filterFld;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable storeGenreCountTbl;
    // End of variables declaration//GEN-END:variables
}
