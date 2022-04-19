/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.up.cs.cos221.prac04;

import DataObjects.Film;
import DataObjects.Staff;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

        public static ArrayList<Film> populateFilms() throws SQLException {
            ArrayList<Film> info = new ArrayList<>();
            ResultSet res = null;
            if (con == null) {
                getConnection();
            }
            try {
                Statement state = con.createStatement();
                res = state.executeQuery("SELECT * FROM u18059288_u21465772_sakila.film;");

            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (res.next()) {

                Film temp = new Film(res.getString(2), res.getString(3), res.getString(4), res.getInt(9), res.getString(11));

                info.add(temp);

            }
            return info;
        }

        public static boolean insertFilm(String title, String description, int releaseYear, int languageID, int originalLanguageID, 
                int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String features) throws SQLException {
            ArrayList<Film> info = new ArrayList<>();
            ResultSet res = null;
            if (con == null) {
                getConnection();
            }
            try {
                PreparedStatement state = con.prepareStatement("INSERT INTO \n"
                        + "u18059288_u21465772_sakila.film\n"
                        + "(title,description,release_year,language_id,original_language_id,rental_duration,rental_rate,length,replacement_cost,rating,special_features)\n"
                        + "VALUES\n"
                        + "(?,?,?,?,?,?,?,?,?,?,?)");

                state.setString(1, title);
                state.setString(2, description);
                state.setInt(3, releaseYear);
                state.setInt(4, languageID);
                state.setInt(5, originalLanguageID);
                state.setInt(6, rentalDuration);
                state.setDouble(7, rentalRate);
                state.setInt(8, length);
                state.setDouble(9, replacementCost);
                state.setString(10, rating);
                state.setString(11, features);

                res = state.executeQuery();
                return true;
            } catch (SQLException ex) {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
        }

    }
}
