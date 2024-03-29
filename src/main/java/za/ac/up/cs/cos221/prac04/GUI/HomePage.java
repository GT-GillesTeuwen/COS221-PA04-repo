/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.up.cs.cos221.prac04.GUI;

import DataObjects.Client;
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
		refreshClientTbl();

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

	public void refreshClientTbl() throws SQLException {

		String clientCol[] = {"ID", "First Name", "Surname", "Email", "Phone", "Address", "City", "Country", "store", "active"};

		DefaultTableModel clientModel = new DefaultTableModel(clientCol, 0);

		clientTbl.setModel(clientModel);

		ArrayList<Client> clients = DBManager.implement.populateClient();

		for (int i = 0; i < clients.size(); i++) {
			Object[] temp = {clients.get(i).getCustomer_id(), clients.get(i).getFirstname(), clients.get(i).getSurname(), clients.get(i).getEmail(), clients.get(i).getPhone(), clients.get(i).getAddress(), clients.get(i).getCity(), clients.get(i).getCountry(), clients.get(i).getStore_id(), clients.get(i).isActive()};
			clientModel.addRow(temp);
		}
		System.out.println("yes");
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                clientPopupMenu = new javax.swing.JPopupMenu();
                Update = new javax.swing.JMenuItem();
                Delete = new javax.swing.JMenuItem();
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
                jButton1 = new javax.swing.JButton();
                jScrollPane4 = new javax.swing.JScrollPane();
                clientTbl = new javax.swing.JTable();
                up = new javax.swing.JButton();
                del = new javax.swing.JButton();

                Update.setText("Update");
                Update.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                UpdateActionPerformed(evt);
                        }
                });
                clientPopupMenu.add(Update);
                Update.getAccessibleContext().setAccessibleName("hi");

                Delete.setText("Delete");
                Delete.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                DeleteActionPerformed(evt);
                        }
                });
                clientPopupMenu.add(Delete);

                setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
                setPreferredSize(new java.awt.Dimension(400, 500));

                jTabbedPane2.setBackground(new java.awt.Color(26, 32, 40));
                jTabbedPane2.setForeground(new java.awt.Color(255, 255, 255));
                jTabbedPane2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N

                StaffPanel.setBackground(new java.awt.Color(49, 66, 82));

                StaffTbl.setBackground(new java.awt.Color(26, 32, 40));
                StaffTbl.setForeground(new java.awt.Color(255, 255, 255));
                jScrollPane1.setViewportView(StaffTbl);

                filterFld.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                filterFldActionPerformed(evt);
                        }
                });

                jLabel1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("Filter by");

                jLabel2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                jLabel2.setText("like");

                FilterBtn.setBackground(new java.awt.Color(206, 120, 1));
                FilterBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                FilterBtn.setForeground(new java.awt.Color(255, 255, 255));
                FilterBtn.setText("Filter");
                FilterBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                FilterBtnActionPerformed(evt);
                        }
                });

                clearFilterBtn.setBackground(new java.awt.Color(206, 120, 1));
                clearFilterBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                clearFilterBtn.setForeground(new java.awt.Color(255, 255, 255));
                clearFilterBtn.setText("Clear Filter");
                clearFilterBtn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                clearFilterBtnActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout StaffPanelLayout = new javax.swing.GroupLayout(StaffPanel);
                StaffPanel.setLayout(StaffPanelLayout);
                StaffPanelLayout.setHorizontalGroup(
                        StaffPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(StaffPanelLayout.createSequentialGroup()
                                .addGap(127, 127, 127)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(filterFld, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(FilterBtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(clearFilterBtn)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(StaffPanelLayout.createSequentialGroup()
                                .addContainerGap(21, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 912, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(16, 16, 16))
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
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
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

                FilmsPanel.setBackground(new java.awt.Color(49, 66, 82));

                FilmsTbl.setBackground(new java.awt.Color(26, 32, 40));
                FilmsTbl.setForeground(new java.awt.Color(255, 255, 255));
                jScrollPane2.setViewportView(FilmsTbl);

                addFilmBtn.setBackground(new java.awt.Color(206, 120, 1));
                addFilmBtn.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                addFilmBtn.setForeground(new java.awt.Color(255, 255, 255));
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
                                .addContainerGap(840, Short.MAX_VALUE)
                                .addComponent(addFilmBtn)
                                .addGap(30, 30, 30))
                        .addGroup(FilmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(FilmsPanelLayout.createSequentialGroup()
                                        .addGap(16, 16, 16)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 923, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(16, Short.MAX_VALUE)))
                );
                FilmsPanelLayout.setVerticalGroup(
                        FilmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(FilmsPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(addFilmBtn)
                                .addContainerGap(413, Short.MAX_VALUE))
                        .addGroup(FilmsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(FilmsPanelLayout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap(31, Short.MAX_VALUE)))
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

                InventoryPanel.setBackground(new java.awt.Color(49, 66, 82));

                storeGenreCountTbl.setBackground(new java.awt.Color(26, 32, 40));
                storeGenreCountTbl.setForeground(new java.awt.Color(255, 255, 255));
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
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 915, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(18, Short.MAX_VALUE))
                );
                InventoryPanelLayout.setVerticalGroup(
                        InventoryPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, InventoryPanelLayout.createSequentialGroup()
                                .addContainerGap(74, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
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

                ClientsPanel.setBackground(new java.awt.Color(49, 66, 82));

                jButton1.setBackground(new java.awt.Color(206, 120, 1));
                jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                jButton1.setForeground(new java.awt.Color(255, 255, 255));
                jButton1.setText("Add Client");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                clientTbl.setBackground(new java.awt.Color(26, 32, 40));
                clientTbl.setForeground(new java.awt.Color(255, 255, 255));
                clientTbl.setModel(new javax.swing.table.DefaultTableModel(
                        new Object [][] {
                                {},
                                {},
                                {},
                                {}
                        },
                        new String [] {

                        }
                ));
                clientTbl.addMouseListener(new java.awt.event.MouseAdapter() {
                        public void mouseClicked(java.awt.event.MouseEvent evt) {
                                clientTblMouseClicked(evt);
                        }
                        public void mousePressed(java.awt.event.MouseEvent evt) {
                                clientTblMousePressed(evt);
                        }
                        public void mouseReleased(java.awt.event.MouseEvent evt) {
                                clientTblMouseReleased(evt);
                        }
                });
                jScrollPane4.setViewportView(clientTbl);

                up.setBackground(new java.awt.Color(206, 120, 1));
                up.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                up.setForeground(new java.awt.Color(255, 255, 255));
                up.setText("Update");
                up.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                upActionPerformed(evt);
                        }
                });

                del.setBackground(new java.awt.Color(206, 120, 1));
                del.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                del.setForeground(new java.awt.Color(255, 255, 255));
                del.setText("Delete");
                del.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                delActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout ClientsPanelLayout = new javax.swing.GroupLayout(ClientsPanel);
                ClientsPanel.setLayout(ClientsPanelLayout);
                ClientsPanelLayout.setHorizontalGroup(
                        ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ClientsPanelLayout.createSequentialGroup()
                                .addContainerGap(16, Short.MAX_VALUE)
                                .addGroup(ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 906, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(ClientsPanelLayout.createSequentialGroup()
                                                .addComponent(del)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(up)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton1)))
                                .addGap(33, 33, 33))
                );
                ClientsPanelLayout.setVerticalGroup(
                        ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(ClientsPanelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(ClientsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(up)
                                        .addComponent(del))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(28, Short.MAX_VALUE))
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
                        .addComponent(jTabbedPane2, javax.swing.GroupLayout.Alignment.TRAILING)
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jTabbedPane2)
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

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
		ClientPane newPane = new ClientPane(this);
		newPane.pack();
		newPane.setLocationRelativeTo(null);
		newPane.setSize(750, 500);
		newPane.setVisible(true);
        }//GEN-LAST:event_jButton1ActionPerformed

        private void clientTblMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTblMouseClicked

        }//GEN-LAST:event_clientTblMouseClicked

        private void clientTblMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTblMousePressed
		if (evt.isPopupTrigger()) {
		}
        }//GEN-LAST:event_clientTblMousePressed

        private void clientTblMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clientTblMouseReleased
		if (evt.isPopupTrigger()) {
			clientPopupMenu.show(evt.getComponent(), evt.getX(), evt.getY());
		}
        }//GEN-LAST:event_clientTblMouseReleased

        private void UpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UpdateActionPerformed
		int row = clientTbl.getSelectedRow();
		String value = clientTbl.getModel().getValueAt(row, 0).toString();
		System.out.println(value);
		try {
			ClientPane cp = new ClientPane(this, Integer.parseInt(value));
			cp.pack();
			cp.setLocationRelativeTo(null);
			cp.setSize(750, 500);
			cp.setVisible(true);
		} catch (SQLException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		}
        }//GEN-LAST:event_UpdateActionPerformed

        private void DeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteActionPerformed
		try {
			int row = clientTbl.getSelectedRow();
			String value = clientTbl.getModel().getValueAt(row, 0).toString();
			DBManager.implement.removeClient(Integer.parseInt(value));
			refreshClientTbl();
		} catch (SQLException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		}
        }//GEN-LAST:event_DeleteActionPerformed

        private void upActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_upActionPerformed
                int row = clientTbl.getSelectedRow();
		String value = clientTbl.getModel().getValueAt(row, 0).toString();
		System.out.println(value);
		try {
			ClientPane cp = new ClientPane(this, Integer.parseInt(value));
			cp.pack();
			cp.setLocationRelativeTo(null);
			cp.setSize(750, 500);
			cp.setVisible(true);
		} catch (SQLException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		}
		
        }//GEN-LAST:event_upActionPerformed

        private void delActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delActionPerformed
               try {
			int row = clientTbl.getSelectedRow();
			String value = clientTbl.getModel().getValueAt(row, 0).toString();
			DBManager.implement.removeClient(Integer.parseInt(value));
			refreshClientTbl();
		} catch (SQLException ex) {
			Logger.getLogger(HomePage.class.getName()).log(Level.SEVERE, null, ex);
		}
	       
        }//GEN-LAST:event_delActionPerformed

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
        private javax.swing.JMenuItem Delete;
        private javax.swing.JPanel FilmsPanel;
        private javax.swing.JPanel FilmsTab;
        private javax.swing.JTable FilmsTbl;
        private javax.swing.JButton FilterBtn;
        private javax.swing.JPanel InventoryPanel;
        private javax.swing.JPanel InventoryTab;
        private javax.swing.JPanel StaffPanel;
        private javax.swing.JPanel StaffTab;
        private javax.swing.JTable StaffTbl;
        private javax.swing.JMenuItem Update;
        private javax.swing.JButton addFilmBtn;
        private javax.swing.JButton clearFilterBtn;
        private javax.swing.JPopupMenu clientPopupMenu;
        private javax.swing.JTable clientTbl;
        private javax.swing.JButton del;
        private javax.swing.JComboBox<String> filterComboBox;
        private javax.swing.JTextField filterFld;
        private javax.swing.JButton jButton1;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JScrollPane jScrollPane2;
        private javax.swing.JScrollPane jScrollPane3;
        private javax.swing.JScrollPane jScrollPane4;
        private javax.swing.JTabbedPane jTabbedPane2;
        private javax.swing.JTable storeGenreCountTbl;
        private javax.swing.JButton up;
        // End of variables declaration//GEN-END:variables

}
