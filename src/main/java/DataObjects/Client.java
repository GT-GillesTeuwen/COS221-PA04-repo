package DataObjects;
import java.sql.Timestamp;

public class Client {
    private int customer_id;
    private int store_id;
    private String firstname;
    private String surname;
    private String email;
    private String phone;
    private String address;
    private String city;
    private String country;
    private boolean active;

    public Client(int customer_id, String firstname, String surname, String email, String phone, String address, String city, String country, int store_id, boolean active){
        this.customer_id = customer_id;
        this.firstname = firstname;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.city = city;
        this.country = country;
        this.store_id = store_id;
        this.active = active;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public int getStore_id() {
        return store_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public boolean isActive() {
        return active;
    }

    public String getPhone() {
        return phone;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}
