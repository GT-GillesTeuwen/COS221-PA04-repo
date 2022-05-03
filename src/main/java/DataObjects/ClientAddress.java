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
public class ClientAddress {
	private int clientId;
	private String firstName;
	private String lastName;
	private String email;
	private int addressId;
	private String phone;
	private String streetNumber;
	private String street;
	private String postalCode;
	private int cityId;
	private int countryId;
	private int storeId;
	private int active;
	private String district;

	public ClientAddress(int clientId, String firstName, String lastName, String email, int addressId, String phone, String address, String postalCode, int cityId, int countryId, int storeId, int active,String district) {
		String[] s=address.split(" ");
		this.streetNumber=s[0];
		for (int i = 1; i < s.length; i++) {
			this.street+=s[i]+" ";
		}
		this.street=this.street.substring(4, this.street.length()-1);
		
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.addressId = addressId;
		this.phone = phone;
		this.postalCode = postalCode;
		this.cityId = cityId;
		this.countryId = countryId;
		this.storeId = storeId;
		this.active = active;
		this.district=district;
	}

	public int getClientId() {
		return clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmail() {
		return email;
	}

	public int getAddressId() {
		return addressId;
	}

	public String getPhone() {
		return phone;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public String getStreet() {
		return street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public int getCityId() {
		return cityId;
	}

	public int getCountryId() {
		return countryId;
	}

	public int getStoreId() {
		return storeId;
	}

	public int getActive() {
		return active;
	}

	public String getDistrict() {
		return district;
	}
	
	
	
	
}
