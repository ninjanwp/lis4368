<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <meta
      name="description"
      content="LIS4368 - Customer Management Form"
    />
    <meta name="author" content="Your Name" />
    <title>LIS4368 - Customer Form</title>
    <%@ include file="/css/include_css.jsp" %>
  </head>
  <body>
    <%@ include file="/global/nav_global.jsp" %>
    <div class="container">
      <div class="starter-template">
        <div class="page-header">
          <%@ include file="/a4/global/header.jsp" %>
        </div>
        <!-- Begin Customer Form -->
        <form id="add_customer_form" method="post" class="form-horizontal"
              action="${pageContext.request.contextPath}/customerAdmin">
          <input type="hidden" name="action" value="add_customer" />

          <!-- First Name -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_fname">First Name:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_fname" id="cus_fname" maxlength="15"
                     class="form-control 
                     ${not empty errors.cus_fname ? 'is-invalid' : (not empty cus_fname ? 'is-valid' : '')}"
                     value="${cus_fname != null ? cus_fname : ''}" />
              <c:if test="${not empty errors.cus_fname}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_fname}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Last Name -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_lname">Last Name:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_lname" id="cus_lname" maxlength="30"
                     class="form-control 
                     ${not empty errors.cus_lname ? 'is-invalid' : (not empty cus_lname ? 'is-valid' : '')}"
                     value="${cus_lname != null ? cus_lname : ''}" />
              <c:if test="${not empty errors.cus_lname}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_lname}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Street -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_street">Street:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_street" id="cus_street" maxlength="30"
                     class="form-control 
                     ${not empty errors.cus_street ? 'is-invalid' : (not empty cus_street ? 'is-valid' : '')}"
                     value="${cus_street != null ? cus_street : ''}" />
              <c:if test="${not empty errors.cus_street}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_street}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- City -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_city">City:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_city" id="cus_city" maxlength="30"
                     class="form-control 
                     ${not empty errors.cus_city ? 'is-invalid' : (not empty cus_city ? 'is-valid' : '')}"
                     value="${cus_city != null ? cus_city : ''}" />
              <c:if test="${not empty errors.cus_city}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_city}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- State -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_state">State:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_state" id="cus_state" maxlength="2"
                     class="form-control 
                     ${not empty errors.cus_state ? 'is-invalid' : (not empty cus_state ? 'is-valid' : '')}"
                     value="${cus_state != null ? cus_state : ''}" />
              <c:if test="${not empty errors.cus_state}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_state}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Zip -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_zip">Zip:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_zip" id="cus_zip" maxlength="9"
                     class="form-control 
                     ${not empty errors.cus_zip ? 'is-invalid' : (not empty cus_zip ? 'is-valid' : '')}"
                     value="${cus_zip != null ? cus_zip : ''}" />
              <c:if test="${not empty errors.cus_zip}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_zip}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Phone -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_phone">Phone:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_phone" id="cus_phone" maxlength="10"
                     class="form-control 
                     ${not empty errors.cus_phone ? 'is-invalid' : (not empty cus_phone ? 'is-valid' : '')}"
                     value="${cus_phone != null ? cus_phone : ''}" />
              <c:if test="${not empty errors.cus_phone}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_phone}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Email -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_email">Email:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_email" id="cus_email" maxlength="100"
                     class="form-control 
                     ${not empty errors.cus_email ? 'is-invalid' : (not empty cus_email ? 'is-valid' : '')}"
                     value="${cus_email != null ? cus_email : ''}" />
              <c:if test="${not empty errors.cus_email}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_email}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Balance -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_balance">Balance:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_balance" id="cus_balance" maxlength="6"
                     class="form-control 
                     ${not empty errors.cus_balance ? 'is-invalid' : (not empty cus_balance ? 'is-valid' : '')}"
                     value="${cus_balance != null ? cus_balance : ''}" />
              <c:if test="${not empty errors.cus_balance}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_balance}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Total Sales -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_total_sales">Total Sales:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_total_sales" id="cus_total_sales" maxlength="6"
                     class="form-control 
                     ${not empty errors.cus_total_sales ? 'is-invalid' : (not empty cus_total_sales ? 'is-valid' : '')}"
                     value="${cus_total_sales != null ? cus_total_sales : ''}" />
              <c:if test="${not empty errors.cus_total_sales}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_total_sales}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Notes (optional) -->
          <div class="form-group">
            <label class="col-sm-4 control-label" for="cus_notes">Notes:</label>
            <div class="col-sm-4">
              <input type="text" name="cus_notes" id="cus_notes" maxlength="255"
                     class="form-control 
                     ${not empty errors.cus_notes ? 'is-invalid' : (not empty cus_notes ? 'is-valid' : '')}"
                     value="${cus_notes != null ? cus_notes : ''}" />
              <c:if test="${not empty errors.cus_notes}">
                <div class="invalid-feedback">
                  <c:out value="${errors.cus_notes}" />
                </div>
              </c:if>
            </div>
          </div>

          <!-- Submit Button -->
          <div class="form-group">
            <div class="col-sm-6 col-sm-offset-3">
              <button type="submit" class="btn btn-primary" name="signup" value="Sign up">
                Submit
              </button>
            </div>
          </div>
        </form>
        <%@ include file="/global/footer.jsp" %>
      </div>
    </div>
    <%@ include file="/js/include_js.jsp" %>
  </body>
</html>
