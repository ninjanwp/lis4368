<%@ page contentType="text/html" pageEncoding="utf-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %> <%@ taglib prefix="fmt"
uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8" />
    <title>LIS4368 - JSP Forms</title>
    <%@ include file="/css/include_css.jsp" %>
  </head>
  <body>
    <%@ include file="/global/nav_global.jsp" %>

    <div class="container">
      <div class="starter-template">
        <div class="page-header"><%@ include file="/global/header.jsp" %></div>

        <h3>Thanks for joining our customer list!</h3>

        <!-- Display message (success or error) -->
        <c:if test="${not empty message}">
          <div
            class="alert ${message.startsWith('Error') ? 'alert-danger' : 'alert-success'}"
            role="alert"
          >
            <c:out value="${message}" />
          </div>
        </c:if>

        <p>Here is the information that you entered:</p>

        <div class="col-xs-12 col-sm-offset-4 text-left">
          <!-- Display the data from 'customer' object -->
          <p>
            <label>First Name:</label>
            <c:out value="${customer.firstName}" />
          </p>
          <p>
            <label>Last Name:</label>
            <c:out value="${customer.lastName}" />
          </p>
          <p>
            <label>Email:</label>
            <c:out value="${customer.email}" />
          </p>
          <p>
            <label>Street:</label>
            <c:out value="${customer.street}" />
          </p>
          <p>
            <label>City:</label>
            <c:out value="${customer.city}" />
          </p>
          <p>
            <label>State:</label>
            <c:out value="${customer.state}" />
          </p>
          <p>
            <label>ZIP:</label>
            <c:out value="${customer.zip}" />
          </p>
          <p>
            <label>Phone:</label>
            <fmt:formatNumber
              type="number"
              pattern="(###) ###-####"
              value="${customer.phone}"
              var="formattedPhone"
            />
            <c:out value="${formattedPhone}" />
          </p>
          <p>
            <label>Balance:</label>
            <fmt:formatNumber type="currency" value="${customer.balance}" />
          </p>
          <p>
            <label>Total Sales:</label>
            <fmt:formatNumber type="currency" value="${customer.totalSales}" />
          </p>
          <p>
            <label>Notes:</label>
            <c:out value="${customer.notes}" />
          </p>

          <p>To enter another record click Return.</p>
          <form
            method="post"
            class="form-horizontal"
            action="${pageContext.request.contextPath}/customerAdmin"
          >
            <input type="hidden" name="action" value="join" />
            <input type="submit" value="Return" />
          </form>
        </div>

        <%@ include file="/global/footer.jsp" %>
      </div>
      <!-- end starter-template -->
    </div>
    <!-- end container -->
  </body>
</html>
