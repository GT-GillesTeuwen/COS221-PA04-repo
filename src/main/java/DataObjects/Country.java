/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataObjects;

/**
 *
 * @author User
 */
public class Country {
	int id;
	String country;

	public Country(int id, String country) {
		this.id = id;
		this.country = country;
	}

	public int getId() {
		return id;
	}

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return country;
	}
	
	
}
