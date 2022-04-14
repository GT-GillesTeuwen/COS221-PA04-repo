/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.up.cs.cos221.prac04;

import DataObjects.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author User
 */
public class DBManager {

	public static class implement {

		private static Connection con;
		private static boolean hasData = false;
		private static String bindAddress = "192.168.8.102:3306";

		public static void setLocal(boolean local) {
			if (local) {
				bindAddress = "192.168.8.102:3306/u18059288_u21465772_sakila";
			} else {
				bindAddress = "41.157.47.27:3306/u18059288_u21465772_sakila";
			}
		}

		public static boolean testConnection(String username, String password) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://" + bindAddress, username, password);
				System.out.println("Connected to Server");
			} catch (ClassNotFoundException ex) {

				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
				con = null;
				return false;
			} catch (SQLException ex) {
				//bindAddress=JOptionPane.showInputDialog("The default database address is unavailable\n Please enter another address");
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
				con = null;
				return false;
			}
			con = null;
			return true;
		}

		public static void getConnection() throws SQLException {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection("jdbc:mysql://" + bindAddress, "COS221_PA4", "P@$SW0RD_&");
				System.out.println("Connected to Server");
			} catch (ClassNotFoundException ex) {

				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		public static ArrayList<Staff> populateStaff() throws SQLException {
			ArrayList<Staff> info = new ArrayList<>();
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				Statement state = con.createStatement();
				res = state.executeQuery("select staff.first_name, staff.last_name, address.address, address.address2, address.district, city.city, address.postal_code, address.phone,store.store_id,active from staff inner join address on staff.address_id=address.address_id inner join city on address.city_id=address.city_id inner join store on staff.store_id =store.store_id where city.city_id =address.city_id;");

			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
			while (res.next()) {

				Staff temp = new Staff(res.getString("first_name"), res.getString("last_name"), res.getString("address"),
					res.getString("address2"), res.getString("district"), res.getString("city"), res.getString("postal_code"),
					res.getString("phone"), res.getInt("store_id"), res.getBoolean("active"));

				info.add(temp);

			}
			return info;
		}

	}
}
