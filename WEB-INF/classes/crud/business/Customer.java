package crud.business;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Customer model (business) class
 * 
 * Matches database table 'customer':
 *  customer_id INT auto_increment
 *  first_name  VARCHAR(50)
 *  last_name   VARCHAR(50)
 *  street      VARCHAR(255)
 *  city        VARCHAR(100)
 *  state       CHAR(2)
 *  zip         CHAR(9)  (but storing as int per assignment instructions)
 *  phone       BIGINT UNSIGNED (storing as long)
 *  email       VARCHAR(100)
 *  balance     DECIMAL(10,2)
 *  total_sales DECIMAL(10,2)
 *  notes       TEXT
 */
public class Customer implements Serializable {

    private int customerId;       // DB: customer_id
    private String firstName;     // DB: first_name
    private String lastName;      // DB: last_name
    private String street;        // DB: street
    private String city;          // DB: city
    private String state;         // DB: state (char(2))
    private int zip;              // DB: zip (char(9)), but as int per assignment
    private long phone;           // DB: phone (bigint)
    private String email;         // DB: email
    private BigDecimal balance;   // DB: balance (decimal(10,2))
    private BigDecimal totalSales; // DB: total_sales (decimal(10,2))
    private String notes;         // DB: notes

    // Default constructor
    public Customer() {
        this.customerId = 0;
        this.firstName = "";
        this.lastName = "";
        this.street = "";
        this.city = "";
        this.state = "";
        this.zip = 0;
        this.phone = 0L;
        this.email = "";
        this.balance = new BigDecimal("0.00");
        this.totalSales = new BigDecimal("0.00");
        this.notes = "";
    }

    // Convenience constructor (omitting customerId auto_increment)
    public Customer(String firstName, String lastName, String street,
                    String city, String state, int zip, long phone,
                    String email, BigDecimal balance, BigDecimal totalSales,
                    String notes) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.balance = (balance == null) ? new BigDecimal("0.00") : balance;
        this.totalSales = (totalSales == null) ? new BigDecimal("0.00") : totalSales;
        this.notes = (notes == null) ? "" : notes;
    }

    // GETTERS AND SETTERS

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public long getPhone() {
        return phone;
    }

    public void setPhone(long phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = (balance == null) ? new BigDecimal("0.00") : balance;
    }

    public BigDecimal getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(BigDecimal totalSales) {
        this.totalSales = (totalSales == null) ? new BigDecimal("0.00") : totalSales;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = (notes == null) ? "" : notes;
    }
}
