<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <!--
      "Time-stamp: <Sat, 12-19-20, 17:39:11 Eastern Standard Time>"
      Example meta tags revised for Project 1, LIS4368
    -->
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <!-- Update description/author as appropriate -->
    <meta
      name="description"
      content="Project 1 for LIS4368 - Customer Management Form."
    />
    <meta name="author" content="Nicholas Pfeffer" />
    <link rel="icon" href="../global//favicon.ico" />

    <!-- Updated title -->
    <title>LIS4368 - Project 1</title>

    <!-- Include your CSS, Bootstrap, etc. -->
    <%@ include file="/css/include_css.jsp" %>
  </head>
  <body>
    <!-- Global navigation bar -->
    <%@ include file="/global/nav.jsp" %>

    <div class="container">
      <div class="starter-template">
        <div class="page-header"><%@ include file="global/header.jsp" %></div>

        <!-- BEGIN FORM -->
        <!-- action can be changed to your relevant servlet/JSP -->
        <form
          id="add_customer_form"
          method="post"
          class="form-horizontal"
          action="#"
        >
          <!-- First Name -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_fname"
              >First Name:</label
            >
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_fname"
                id="cus_fname"
                maxlength="15"
              />
            </div>
          </div>

          <!-- Last Name -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_lname"
              >Last Name:</label
            >
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_lname"
                id="cus_lname"
                maxlength="30"
              />
            </div>
          </div>

          <!-- Street -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_street"
              >Street:</label
            >
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_street"
                id="cus_street"
                maxlength="30"
              />
            </div>
          </div>

          <!-- City -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_city">City:</label>
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_city"
                id="cus_city"
                maxlength="30"
              />
            </div>
          </div>

          <!-- State -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_state">State:</label>
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_state"
                id="cus_state"
                maxlength="2"
              />
            </div>
          </div>

          <!-- Zip -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_zip">Zip:</label>
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_zip"
                id="cus_zip"
                maxlength="9"
              />
            </div>
          </div>

          <!-- Phone -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_phone">Phone:</label>
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_phone"
                id="cus_phone"
                maxlength="10"
              />
            </div>
          </div>

          <!-- Email -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_email">Email:</label>
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_email"
                id="cus_email"
                maxlength="100"
              />
            </div>
          </div>

          <!-- Balance -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_balance"
              >Balance:</label
            >
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_balance"
                id="cus_balance"
                maxlength="6"
              />
            </div>
          </div>

          <!-- Total Sales -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_total_sales"
              >Total Sales:</label
            >
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_total_sales"
                id="cus_total_sales"
                maxlength="6"
              />
            </div>
          </div>

          <!-- Notes (NOT required) -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_notes">Notes:</label>
            <div class="col-sm-4">
              <input
                type="text"
                class="form-control"
                name="cus_notes"
                id="cus_notes"
                maxlength="255"
              />
            </div>
          </div>

          <!-- Submit button -->
          <div class="form-group">
            <div class="col-sm-6 col-sm-offset-3">
              <button
                type="submit"
                class="btn btn-primary"
                name="signup"
                value="Sign up"
              >
                Submit
              </button>
            </div>
          </div>
        </form>
        <!-- END FORM -->

        <%@ include file="/global/footer.jsp" %>
      </div>
      <!-- end starter-template -->
    </div>
    <!-- end container -->

    <%@ include file="/js/include_js.jsp" %>

    <!-- jQuery Validation Script -->
    <script type="text/javascript">
      $(document).ready(function () {
        $("#add_customer_form").formValidation({
          message: "This value is not valid",
          icon: {
            valid: "fa fa-check", // check icon for valid
            invalid: "fa fa-times", // times (x) icon for invalid
            validating: "fa fa-refresh", // spinner icon while validating
          },
          fields: {
            // --------------------------
            // FIRST NAME (required)
            // --------------------------
            cus_fname: {
              validators: {
                notEmpty: {
                  message: "First name is required",
                },
                stringLength: {
                  min: 1,
                  max: 15,
                  message: "First name must be <= 15 characters",
                },
                regexp: {
                  regexp: /^[a-zA-Z\-]+$/,
                  message: "First name can only contain letters and hyphens",
                },
              },
            },
            // --------------------------
            // LAST NAME (required)
            // --------------------------
            cus_lname: {
              validators: {
                notEmpty: {
                  message: "Last name is required",
                },
                stringLength: {
                  min: 1,
                  max: 30,
                  message: "Last name must be <= 30 characters",
                },
                regexp: {
                  regexp: /^[a-zA-Z\-]+$/,
                  message: "Last name can only contain letters and hyphens",
                },
              },
            },
            // --------------------------
            // STREET (required)
            //  - letters, digits, comma, hyphen, period
            // --------------------------
            cus_street: {
              validators: {
                notEmpty: {
                  message: "Street is required",
                },
                stringLength: {
                  min: 1,
                  max: 30,
                  message: "Street must be <= 30 characters",
                },
                regexp: {
                  regexp: /^[a-zA-Z0-9,\-\. ]+$/,
                  message:
                    "Street can contain letters, numbers, commas, hyphens, periods, and spaces only",
                },
              },
            },
            // --------------------------
            // CITY (required)
            //  - letters, digits, hyphen, space
            // --------------------------
            cus_city: {
              validators: {
                notEmpty: {
                  message: "City is required",
                },
                stringLength: {
                  min: 1,
                  max: 30,
                  message: "City must be <= 30 characters",
                },
                regexp: {
                  regexp: /^[a-zA-Z0-9\- ]+$/,
                  message:
                    "City can contain letters, numbers, hyphens, and spaces",
                },
              },
            },
            // --------------------------
            // STATE (required)
            //  - exactly 2 letters
            // --------------------------
            cus_state: {
              validators: {
                notEmpty: {
                  message: "State is required",
                },
                stringLength: {
                  min: 2,
                  max: 2,
                  message: "State must be exactly 2 letters",
                },
                regexp: {
                  regexp: /^[a-zA-Z]{2}$/,
                  message: "State can only contain letters",
                },
              },
            },
            // --------------------------
            // ZIP (required)
            //  - between 5 and 9 digits
            // --------------------------
            cus_zip: {
              validators: {
                notEmpty: {
                  message: "Zip code is required",
                },
                stringLength: {
                  min: 5,
                  max: 9,
                  message: "Zip must be 5-9 characters",
                },
                regexp: {
                  regexp: /^[0-9]{5,9}$/,
                  message: "Zip can only contain digits (5-9 long)",
                },
              },
            },
            // --------------------------
            // PHONE (required)
            //  - exactly 10 digits
            // --------------------------
            cus_phone: {
              validators: {
                notEmpty: {
                  message: "Phone is required",
                },
                stringLength: {
                  min: 10,
                  max: 10,
                  message: "Phone must be exactly 10 digits",
                },
                regexp: {
                  regexp: /^[0-9]{10}$/,
                  message: "Phone can only contain digits",
                },
              },
            },
            // --------------------------
            // EMAIL (required)
            //  - provided validator from example
            // --------------------------
            cus_email: {
              validators: {
                notEmpty: {
                  message: "Email address is required",
                },
                stringLength: {
                  min: 1,
                  max: 100,
                  message: "Email must be <= 100 characters",
                },
                regexp: {
                  // typical email pattern
                  regexp: /^([a-z0-9_\.-]+)@([\da-z\.-]+)\.([a-z\.]{2,6})$/,
                  message: "Must include a valid email address",
                },
              },
            },
            // --------------------------
            // BALANCE (required)
            //  - up to 6 chars total (digits or decimal point)
            //  - must have at most one decimal point
            // --------------------------
            cus_balance: {
              validators: {
                notEmpty: {
                  message: "Balance is required",
                },
                // Because "no more than 6 digits including decimal point"
                // is a bit ambiguous, we ensure length <= 6 & at most 1 decimal
                stringLength: {
                  min: 1,
                  max: 6,
                  message: "Balance can be up to 6 characters total",
                },
                regexp: {
                  // negative look-ahead to ensure at most 1 decimal, only digits or '.'
                  regexp: /^(?!.*\..*\.)[0-9.]{1,6}$/,
                  message:
                    "Must contain only positive digits, and at most one decimal point (max length 6)",
                },
              },
            },
            // --------------------------
            // TOTAL SALES (required)
            //  - same logic as balance
            // --------------------------
            cus_total_sales: {
              validators: {
                notEmpty: {
                  message: "Total Sales is required",
                },
                stringLength: {
                  min: 1,
                  max: 6,
                  message: "Total Sales can be up to 6 characters total",
                },
                regexp: {
                  regexp: /^(?!.*\..*\.)[0-9.]{1,6}$/,
                  message:
                    "Must contain only digits and at most one decimal point (max length 6)",
                },
              },
            },
            // --------------------------
            // NOTES (NOT required)
            // --------------------------
            cus_notes: {
              validators: {
                // no notEmpty here since not required
                stringLength: {
                  max: 255,
                  message: "Notes must be <= 255 characters",
                },
                // no regexp constraints given for notes
              },
            },
          }, // end fields
        }); // end formValidation
      });
    </script>
  </body>
</html>
