package ua.goit.jdbсservlets.dao;

public class CustomersDao {
    Integer id;
    String customerName;
    String country;
    String email;

    public CustomersDao() {
    }

    public CustomersDao(Integer id, String customerName, String country, String email) {
        this.id = id;
        this.customerName = customerName;
        this.country = country;
        this.email = email;
    }

    public CustomersDao(String customerName, String country, String email) {
        this.customerName = customerName;
        this.country = country;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CustomersDao{" +
                "id=" + id +
                ", customerName='" + customerName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
