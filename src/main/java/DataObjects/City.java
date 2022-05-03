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
public class City {
	int cityId;
	String city;
	int countryId;

	public City(int cityId, String city, int countryId) {
		this.cityId = cityId;
		this.city = city;
		this.countryId = countryId;
	}

	public int getCityId() {
		return cityId;
	}

	public String getCity() {
		return city;
	}

	public int getCountryId() {
		return countryId;
	}

	@Override
	public String toString() {
		return city;
	}
	
	
}
