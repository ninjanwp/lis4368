package crud.data;

import crud.business.Customer;
import java.sql.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Data access class for the Customer business object
 * Provides CRUD operations for the customer table
 */
public class CustomerDB {
    
    // Database connection settings
    private static final String URL = "jdbc:mysql://localhost:3306/np22i";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    
    /**
     * Insert a new customer into the database
     * @param customer The customer to insert
     * @return The ID of the inserted customer, or -1 if insert failed
     */
    public static int insert(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            // Establish connection
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // Prepare SQL statement - do not include customer_id as it's auto-increment
            String query = "INSERT INTO customer (first_name, last_name, street, city, state, zip, " +
                          "phone, email, balance, total_sales, notes) " +
                          "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            
            // Enable retrieval of the auto-generated key
            statement = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            
            // Set parameter values
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getStreet());
            statement.setString(4, customer.getCity());
            statement.setString(5, customer.getState());
            statement.setString(6, String.valueOf(customer.getZip())); // Convert to string for the CHAR field
            statement.setLong(7, customer.getPhone());
            statement.setString(8, customer.getEmail());
            statement.setBigDecimal(9, customer.getBalance());
            statement.setBigDecimal(10, customer.getTotalSales());
            statement.setString(11, customer.getNotes());
            
            // Execute the insert
            int rowsAffected = statement.executeUpdate();
            
            // Get the auto-generated key (customer_id)
            if (rowsAffected > 0) {
                resultSet = statement.getGeneratedKeys();
                if (resultSet.next()) {
                    return resultSet.getInt(1); // Return the customer_id
                }
            }
            
            return -1; // Insert failed
            
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return -1;
        } finally {
            // Close all resources
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database resources: " + e.getMessage());
            }
        }
    }
    
    /**
     * Select a customer by ID
     * @param customerId The ID of the customer to retrieve
     * @return The Customer object, or null if not found
     */
    public static Customer selectCustomer(int customerId) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "SELECT * FROM customer WHERE customer_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, customerId);
            resultSet = statement.executeQuery();
            
            if (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setStreet(resultSet.getString("street"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setZip(Integer.parseInt(resultSet.getString("zip")));
                customer.setPhone(resultSet.getLong("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setBalance(resultSet.getBigDecimal("balance"));
                customer.setTotalSales(resultSet.getBigDecimal("total_sales"));
                customer.setNotes(resultSet.getString("notes"));
                return customer;
            }
            return null;
            
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return null;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database resources: " + e.getMessage());
            }
        }
    }
    
    /**
     * Select all customers from the database
     * @return A list of all customers
     */
    public static List<Customer> selectCustomers() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<Customer> customers = new ArrayList<>();
        
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM customer");
            
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setFirstName(resultSet.getString("first_name"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setStreet(resultSet.getString("street"));
                customer.setCity(resultSet.getString("city"));
                customer.setState(resultSet.getString("state"));
                customer.setZip(Integer.parseInt(resultSet.getString("zip")));
                customer.setPhone(resultSet.getLong("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setBalance(resultSet.getBigDecimal("balance"));
                customer.setTotalSales(resultSet.getBigDecimal("total_sales"));
                customer.setNotes(resultSet.getString("notes"));
                customers.add(customer);
            }
            return customers;
            
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return customers;
        } finally {
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database resources: " + e.getMessage());
            }
        }
    }
    
    /**
     * Update an existing customer in the database
     * @param customer The customer with updated values
     * @return true if successful, false otherwise
     */
    public static boolean update(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "UPDATE customer SET first_name = ?, last_name = ?, street = ?, " +
                          "city = ?, state = ?, zip = ?, phone = ?, email = ?, " +
                          "balance = ?, total_sales = ?, notes = ? " +
                          "WHERE customer_id = ?";
            
            statement = connection.prepareStatement(query);
            statement.setString(1, customer.getFirstName());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getStreet());
            statement.setString(4, customer.getCity());
            statement.setString(5, customer.getState());
            statement.setString(6, String.valueOf(customer.getZip()));
            statement.setLong(7, customer.getPhone());
            statement.setString(8, customer.getEmail());
            statement.setBigDecimal(9, customer.getBalance());
            statement.setBigDecimal(10, customer.getTotalSales());
            statement.setString(11, customer.getNotes());
            statement.setInt(12, customer.getCustomerId());
            
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database resources: " + e.getMessage());
            }
        }
    }
    
    /**
     * Delete a customer from the database
     * @param customer The customer to delete
     * @return true if successful, false otherwise
     */
    public static boolean delete(Customer customer) {
        Connection connection = null;
        PreparedStatement statement = null;
        
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String query = "DELETE FROM customer WHERE customer_id = ?";
            statement = connection.prepareStatement(query);
            statement.setInt(1, customer.getCustomerId());
            
            int rowsAffected = statement.executeUpdate();
            return rowsAffected > 0;
            
        } catch (SQLException e) {
            System.err.println("SQL Error: " + e.getMessage());
            e.printStackTrace();
            return false;
        } finally {
            try {
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.err.println("Error closing database resources: " + e.getMessage());
            }
        }
    }
}