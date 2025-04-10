package crud.admin;

import crud.business.Customer;
import crud.data.CustomerDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/customerAdmin")
public class CustomerServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    // Regex patterns matching your client-side rules:
    private static final String NAME_REGEX = "^[a-zA-Z\\-]+$";
    private static final String STREET_REGEX = "^[a-zA-Z0-9,\\-\\. ]+$";
    private static final String CITY_REGEX = "^[a-zA-Z0-9\\- ]+$";
    private static final String STATE_REGEX = "^[a-zA-Z]{2}$";
    private static final String ZIP_REGEX = "^[0-9]{5,9}$";
    private static final String PHONE_REGEX = "^[0-9]{10}$";
    private static final String EMAIL_REGEX = "^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$";
    // For balance and total sales: up to 6 characters, only one optional decimal point.
    private static final String MONEY_REGEX = "^(?!.*\\..*\\.)[0-9.]{1,6}$";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Retrieve parameters (using names from your client-side form)
        String cus_fname = request.getParameter("cus_fname");
        String cus_lname = request.getParameter("cus_lname");
        String cus_street = request.getParameter("cus_street");
        String cus_city = request.getParameter("cus_city");
        String cus_state = request.getParameter("cus_state");
        String cus_zip = request.getParameter("cus_zip");
        String cus_phone = request.getParameter("cus_phone");
        String cus_email = request.getParameter("cus_email");
        String cus_balance = request.getParameter("cus_balance");
        String cus_total_sales = request.getParameter("cus_total_sales");
        String cus_notes = request.getParameter("cus_notes");

        // Collect errors in a map: key is the field name
        Map<String, String> errors = new HashMap<>();

        // Validate first name
        if (cus_fname == null || cus_fname.trim().isEmpty()) {
            errors.put("cus_fname", "First name is required.");
        } else if (cus_fname.length() > 15) {
            errors.put("cus_fname", "First name must be <= 15 characters.");
        } else if (!cus_fname.matches(NAME_REGEX)) {
            errors.put("cus_fname", "First name can only contain letters and hyphens.");
        }

        // Validate last name
        if (cus_lname == null || cus_lname.trim().isEmpty()) {
            errors.put("cus_lname", "Last name is required.");
        } else if (cus_lname.length() > 30) {
            errors.put("cus_lname", "Last name must be <= 30 characters.");
        } else if (!cus_lname.matches(NAME_REGEX)) {
            errors.put("cus_lname", "Last name can only contain letters and hyphens.");
        }

        // Validate street
        if (cus_street == null || cus_street.trim().isEmpty()) {
            errors.put("cus_street", "Street is required.");
        } else if (cus_street.length() > 30) {
            errors.put("cus_street", "Street must be <= 30 characters.");
        } else if (!cus_street.matches(STREET_REGEX)) {
            errors.put("cus_street", "Street can contain letters, numbers, commas, hyphens, periods, and spaces only.");
        }

        // Validate city
        if (cus_city == null || cus_city.trim().isEmpty()) {
            errors.put("cus_city", "City is required.");
        } else if (cus_city.length() > 30) {
            errors.put("cus_city", "City must be <= 30 characters.");
        } else if (!cus_city.matches(CITY_REGEX)) {
            errors.put("cus_city", "City can contain letters, numbers, hyphens, and spaces.");
        }

        // Validate state
        if (cus_state == null || cus_state.trim().isEmpty()) {
            errors.put("cus_state", "State is required.");
        } else if (cus_state.length() != 2) {
            errors.put("cus_state", "State must be exactly 2 letters.");
        } else if (!cus_state.matches(STATE_REGEX)) {
            errors.put("cus_state", "State can only contain letters.");
        }

        // Validate ZIP
        if (cus_zip == null || cus_zip.trim().isEmpty()) {
            errors.put("cus_zip", "Zip code is required.");
        } else if (cus_zip.length() < 5 || cus_zip.length() > 9) {
            errors.put("cus_zip", "Zip must be 5-9 characters.");
        } else if (!cus_zip.matches(ZIP_REGEX)) {
            errors.put("cus_zip", "Zip can only contain digits.");
        }

        // Validate phone
        if (cus_phone == null || cus_phone.trim().isEmpty()) {
            errors.put("cus_phone", "Phone is required.");
        } else if (cus_phone.length() != 10) {
            errors.put("cus_phone", "Phone must be exactly 10 digits.");
        } else if (!cus_phone.matches(PHONE_REGEX)) {
            errors.put("cus_phone", "Phone can only contain digits.");
        }

        // Validate email
        if (cus_email == null || cus_email.trim().isEmpty()) {
            errors.put("cus_email", "Email address is required.");
        } else if (cus_email.length() > 100) {
            errors.put("cus_email", "Email must be <= 100 characters.");
        } else if (!cus_email.matches(EMAIL_REGEX)) {
            errors.put("cus_email", "Must include a valid email address.");
        }

        // Validate balance
        if (cus_balance == null || cus_balance.trim().isEmpty()) {
            errors.put("cus_balance", "Balance is required.");
        } else if (cus_balance.length() > 6) {
            errors.put("cus_balance", "Balance can be up to 6 characters.");
        } else if (!cus_balance.matches(MONEY_REGEX)) {
            errors.put("cus_balance", "Balance must contain only positive digits and at most one decimal point.");
        } else {
            try {
                BigDecimal balance = new BigDecimal(cus_balance);
                if (balance.compareTo(BigDecimal.ZERO) < 0) {
                    errors.put("cus_balance", "Balance cannot be negative.");
                }
            } catch (NumberFormatException e) {
                errors.put("cus_balance", "Balance must be a valid decimal number.");
            }
        }

        // Validate total sales
        if (cus_total_sales == null || cus_total_sales.trim().isEmpty()) {
            errors.put("cus_total_sales", "Total Sales is required.");
        } else if (cus_total_sales.length() > 6) {
            errors.put("cus_total_sales", "Total Sales can be up to 6 characters.");
        } else if (!cus_total_sales.matches(MONEY_REGEX)) {
            errors.put("cus_total_sales", "Total Sales must contain only positive digits and at most one decimal point.");
        } else {
            try {
                BigDecimal totalSales = new BigDecimal(cus_total_sales);
                if (totalSales.compareTo(BigDecimal.ZERO) < 0) {
                    errors.put("cus_total_sales", "Total Sales cannot be negative.");
                }
            } catch (NumberFormatException e) {
                errors.put("cus_total_sales", "Total Sales must be a valid decimal number.");
            }
        }

        // Notes is optional – just check length if provided.
        if (cus_notes != null && cus_notes.length() > 255) {
            errors.put("cus_notes", "Notes must be <= 255 characters.");
        }

        // If there are errors, set the error map and original values in request scope and forward back to the form.
        if (!errors.isEmpty()) {
            request.setAttribute("errors", errors);
            // Set original field values so the form can re-populate:
            request.setAttribute("cus_fname", cus_fname);
            request.setAttribute("cus_lname", cus_lname);
            request.setAttribute("cus_street", cus_street);
            request.setAttribute("cus_city", cus_city);
            request.setAttribute("cus_state", cus_state);
            request.setAttribute("cus_zip", cus_zip);
            request.setAttribute("cus_phone", cus_phone);
            request.setAttribute("cus_email", cus_email);
            request.setAttribute("cus_balance", cus_balance);
            request.setAttribute("cus_total_sales", cus_total_sales);
            request.setAttribute("cus_notes", cus_notes);
            getServletContext().getRequestDispatcher("/customerform.jsp").forward(request, response);
            return;
        }

        // If no errors, create a Customer object.
        Customer customer = new Customer();
        customer.setFirstName(cus_fname);
        customer.setLastName(cus_lname);
        customer.setStreet(cus_street);
        customer.setCity(cus_city);
        customer.setState(cus_state);
        customer.setZip(Integer.parseInt(cus_zip));
        customer.setPhone(Long.parseLong(cus_phone));
        customer.setEmail(cus_email);
        customer.setBalance(new BigDecimal(cus_balance));
        customer.setTotalSales(new BigDecimal(cus_total_sales));
        customer.setNotes(cus_notes == null ? "" : cus_notes);

        // Insert the customer into the database
        int customerId = CustomerDB.insert(customer);
        
        if (customerId > 0) {
            // Set the generated ID in the customer object
            customer.setCustomerId(customerId);
            
            // Set success message
            request.setAttribute("message", "Customer successfully added to database!");
        } else {
            // Set error message
            request.setAttribute("message", "Error: Failed to add customer to database. Please try again.");
        }

        // Set the customer object in request scope and forward to thanks.jsp.
        request.setAttribute("customer", customer);
        getServletContext().getRequestDispatcher("/thanks.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
