/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.up.cs.cos221.prac04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author User
 */
public class DBManager {  
	
	
	
	public static class implement {

		private static Connection con;
		private static boolean hasData = false;
		private static String bindAddress ="192.168.8.102:3306";

		
		public static void setLocal(boolean local){
			if (local) {
				bindAddress = "192.168.8.102:3306";
			}else{
				bindAddress = "41.157.47.27:3306";
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
		
		

	}
}
