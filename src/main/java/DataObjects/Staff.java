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
public class Staff {
	private String firstName;
	private String lastName;
	private String address;
	private String address2;
	private String district;
	private String city;
	private String postalCode;
	private String phone;
	private int store;
	private boolean active;

	public Staff(String firstName, String lastName, String address, String address2, String district, String city, String postalCode, String phone, int store, boolean active) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.address2 = address2;
		this.district = district;
		this.city = city;
		this.postalCode = postalCode;
		this.phone = phone;
		this.store = store;
		this.active = active;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getAddress() {
		return address;
	}

	public String getAddress2() {
		return address2;
	}

	public String getDistrict() {
		return district;
	}

	public String getCity() {
		return city;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getPhone() {
		return phone;
	}

	public int getStore() {
		return store;
	}

	public boolean getActive() {
		return active;
	}
	
	
}
