/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.up.cs.cos221.prac04;

import DataObjects.City;
import DataObjects.Country;
import DataObjects.Film;
import DataObjects.Language;
import DataObjects.Staff;
import DataObjects.Store;
import DataObjects.Client;
import DataObjects.ClientAddress;
import DataObjects.StoreGenreCount;
import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
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
		private static String bindAddress = "192.168.8.102:3306";
		private static final String host = System.getenv("SAKILA_DB_HOST");
		private static final String port = System.getenv("SAKILA_DB_PORT");
		private static final String db_name = System.getenv("SAKILA_DB_NAME");
		private static final String protocol = System.getenv("SAKILA_DB_PROTO");
		private static final String username = System.getenv("SAKILA_DB_USERNAME");
		private static final String password = System.getenv("SAKILA_DB_PASSWORD");

		public static void setLocal(boolean local) {
			if (local) {
				bindAddress = "192.168.8.102:3306/"+db_name;
			} else {
				bindAddress = host+":"+port+"/"+db_name;
				
			}
		}

		public static boolean testConnection() {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con = DriverManager.getConnection(protocol + bindAddress, username, password);
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
				con = DriverManager.getConnection(protocol + bindAddress, username, password);
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

		public static int insertAddress(String address, String address2, String district, int cityId, String postalCode, String phone) throws SQLException {
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				PreparedStatement state = con.prepareStatement("INSERT INTO `u18059288_u21465772_sakila`.`address` "
					+ "(`address`, `address2`, `district`, `city_id`, `postal_code`, `phone`) "
					+ "VALUES (?,?,?,?,?,?);",Statement.RETURN_GENERATED_KEYS);

				state.setString(1, address);
				state.setString(2, address2);
				state.setString(3, district);
				state.setInt(4, cityId);
				state.setString(5, postalCode);
				state.setString(6, phone);

				state.executeUpdate();
				res = state.getGeneratedKeys();
				while (res.next()) {
					int idColVar = res.getInt(1);
					// Get automatically generated key
					// value
					System.out.println("automatically generated key value = " + idColVar);
					return idColVar;
				}
				return 0;
			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
				return 0;
			}
		}

		public static boolean insertFilm(String title, String description, int releaseYear, int languageID, int originalLanguageID,
										 int rentalDuration, double rentalRate, int length, double replacementCost, String rating, String features) throws SQLException {
			ArrayList<Film> info = new ArrayList<>();
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

				state.executeUpdate();
				return true;
			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}
		}

		public static ArrayList<Language> populateLanguages() throws SQLException {
			ArrayList<Language> info = new ArrayList<>();
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				Statement state = con.createStatement();
				res = state.executeQuery("SELECT language_id,name FROM u18059288_u21465772_sakila.language;");

			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
			while (res.next()) {

				Language temp = new Language(res.getInt(1), res.getString(2));

				info.add(temp);

			}
			return info;
		}

		public static ArrayList<StoreGenreCount> populateStoreGenreCount() throws SQLException {
			ArrayList<StoreGenreCount> info = new ArrayList<>();
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				Statement state = con.createStatement();
				res = state.executeQuery("select \n"
						+ "CONCAT(city.city, _utf8mb4',', country.country) AS Store, category.name, count(*) as NUM \n"
						+ "from inventory inner join film_category on inventory.film_id=film_category.film_id \n"
						+ "inner join store on inventory.store_id=store.store_id inner join address on store.address_id = address.address_id \n"
						+ "inner join city on address.city_id = city.city_id inner join country on city.country_id = country.country_id \n"
						+ "inner join category on film_category.category_id = category.category_id  \n"
						+ "group by film_category.category_id, store.store_id\n"
						+ "Order by Store");

			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
			while (res.next()) {

				StoreGenreCount temp = new StoreGenreCount(res.getString(1), res.getString(2), res.getInt(3));

				info.add(temp);

			}
			return info;
		}

		public static ArrayList<Country> populateCountries() throws SQLException {
			ArrayList<Country> info = new ArrayList<>();
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				Statement state = con.createStatement();
				res = state.executeQuery("SELECT country_id,country FROM u18059288_u21465772_sakila.country;");

			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
			while (res.next()) {

				Country temp = new Country(res.getInt(1), res.getString(2));

				info.add(temp);

			}
			return info;
		}

		public static ArrayList<City> populateCountryCities(int countryId) throws SQLException {
			ArrayList<City> info = new ArrayList<>();
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				PreparedStatement state = con.prepareStatement("SELECT * FROM u18059288_u21465772_sakila.city where country_id=?;");
				state.setInt(1, countryId);
				res = state.executeQuery();

			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
			while (res.next()) {

				City temp = new City(res.getInt(1), res.getString(2), res.getInt(3));

				info.add(temp);

			}
			return info;
		}

		public static ArrayList<Client> populateClient() throws SQLException {
			ArrayList<Client> info = new ArrayList<>();
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				Statement state = con.createStatement();
				res = state.executeQuery("select customer.customer_id, customer.first_name, customer.last_name, customer.email, \n"
						+ "address.phone, address.address, city.city, country.country, customer.store_id, customer.active \n"
						+ "from customer inner join address on customer.address_id=address.address_id \n"
						+ "inner join city on address.city_id=city.city_id \n"
						+ "inner join country on city.country_id=country.country_id \n"
						+ "order by customer.store_id");
			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
			while (res.next()) {
				Client temp = new Client(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getString(5),
						res.getString(6), res.getString(7), res.getString(8), res.getInt(9), res.getBoolean(10));
				info.add(temp);
			}
			return info;
		}

		public static boolean insertClient(int store_id, String firstName, String lastName, String email, int addressId, int active) throws SQLException {

			if (con == null) {
				getConnection();
			}
			try {
				PreparedStatement state = con.prepareStatement("INSERT INTO `u18059288_u21465772_sakila`.`customer` "
						+ "( `store_id`, `first_name`, `last_name`, `email`, `address_id`, `active`, `create_date`) "
						+ "VALUES (?,?,?,?,?,?,?)");

				state.setInt(1, store_id);
				state.setString(2, firstName);
				state.setString(3, lastName);
				state.setString(4, email);
				state.setInt(5, addressId);
				state.setInt(6, active);
				java.util.Date now = new java.util.Date();
				java.sql.Date curr= new java.sql.Date(now.getDate());
				state.setDate(7, curr);
				state.executeUpdate();
				return true;
			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}
		}
		public static boolean removeClient(int customer_ID) throws SQLException {
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				PreparedStatement address = con.prepareStatement("SELECT customer.address_id FROM customer WHERE customer.customer_id=?");
				address.setInt(1, customer_ID);
				res = address.executeQuery();
				PreparedStatement state = con.prepareStatement("DELETE FROM customer WHERE customer_id=?");
				state.setInt(1, customer_ID);
				state.executeUpdate();
				state = con.prepareStatement("DELETE FROM address WHERE address.address_id=?");
				res.next();
				state.setInt(1, res.getInt(1));
				state.executeUpdate();
				return true;
			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}
		}
		public static ArrayList<Store> populateStore() throws SQLException{
			ArrayList<Store> info = new ArrayList<>();
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try{
				Statement state = con.createStatement();
				res = state.executeQuery("select CONCAT(city.city, _utf8mb4',', country.country) AS Store,store_id from store \n"
						+"inner join address on store.address_id=address.address_id \n"
						+"inner join city on address.city_id=city.city_id \n"
						+"inner join country on city.country_id=country.country_id");
			}catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
			while(res.next()){
				Store temp = new Store(res.getString(1),res.getInt(2));
				info.add(temp);
			}
			return info;
		}
		
		public static boolean updateAddress(int address_id, String add1, String add2, String district, String phone, String postalCode,int city_id) throws SQLException{
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				
				PreparedStatement state = con.prepareStatement("update address set address=?, address2=?, district=?, \n"
						+"phone=?, city_id=? ,postal_code=? where address.address_id=?");
				state.setString(1, add1);
				state.setString(2, add2);
				state.setString(3, district);
				state.setString(4, phone);
				state.setInt(5, city_id);
				state.setInt(6, address_id);
				state.setString(7, postalCode);
				state.executeUpdate();
				return true;
			}
			catch (SQLException ex){
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}

		}
		
		public static boolean upadateClient(int customer_id,int store_id, String firstName, String lastName, String email, int active) throws SQLException{
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				
				PreparedStatement state = con.prepareStatement("update customer set first_name=?, last_name=?, email=?, \n"
						+" active=?, store_id=? where customer_id=?");
				state.setString(1, firstName);
				state.setString(2, lastName);
				state.setString(3, email);
				state.setInt(4, active);
				state.setInt(5, store_id);
				state.setInt(6, customer_id);
				state.executeUpdate();
				return true;
			}
			catch (SQLException ex){
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
				return false;
			}
		}
		
		public static ClientAddress getClient(int id) throws SQLException {
			ArrayList<Client> info = new ArrayList<>();
			ResultSet res = null;
			if (con == null) {
				getConnection();
			}
			try {
				PreparedStatement state = con.prepareStatement("select customer.customer_id, customer.first_name, customer.last_name, customer.email,address.address_id,\n" +
"						address.phone, address.address,address.postal_code, city.city_id, country.country_id, customer.store_id, customer.active,address.district\n" +
"						from customer inner join address on customer.address_id=address.address_id\n" +
"						inner join city on address.city_id=city.city_id \n" +
"						inner join country on city.country_id=country.country_id \n" +
"						where customer_id=?\n" +
"						order by customer.store_id");
				state.setInt(1, id);
				res = state.executeQuery();
			} catch (SQLException ex) {
				Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
			}
			while (res.next()) {
				ClientAddress temp=new ClientAddress(res.getInt(1), res.getString(2), res.getString(3), res.getString(4), res.getInt(5), 
					res.getString(6), res.getString(7), res.getString(8), res.getInt(9), res.getInt(10), res.getInt(11), res.getInt(12),res.getString(13));
					
				return temp;
			}
			return null;
		}

	}
}
