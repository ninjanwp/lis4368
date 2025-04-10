<%@ page contentType="text/html" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>LIS4368 - View Customers</title>
    <%@ include file="/css/include_css.jsp" %>
</head>
<body>
    <%@ include file="/global/nav_global.jsp" %>

    <div class="container">
        <div class="starter-template">
            <div class="page-header">
                <%@ include file="/global/header.jsp" %>
            </div>

            <h2>Customer List</h2>
            
            <!-- Display message if available -->
            <c:if test="${not empty message}">
                <div class="alert ${message.startsWith('Error') ? 'alert-danger' : 'alert-success'}" role="alert">
                    <c:out value="${message}" />
                </div>
            </c:if>

            <c:choose>
                <c:when test="${empty customers}">
                    <div class="alert alert-info">No customers found in the database.</div>
                    
                    <form method="post" class="form-horizontal" 
                          action="${pageContext.request.contextPath}/viewCustomers">
                        <input type="hidden" name="action" value="refresh">
                        <input type="submit" value="Refresh List" class="btn btn-primary">
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="table-responsive">
                        <table class="table table-striped table-hover table-bordered">
                            <thead>
                                <tr>
                                    <th>ID</th>
                                    <th>Name</th>
                                    <th>Email</th>
                                    <th>Phone</th>
                                    <th>Address</th>
                                    <th>Balance</th>
                                    <th>Sales</th>
                                    <th>Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="customer" items="${customers}">
                                    <tr>
                                        <td><c:out value="${customer.customerId}"/></td>
                                        <td><c:out value="${customer.firstName} ${customer.lastName}"/></td>
                                        <td><c:out value="${customer.email}"/></td>
                                        <td>
                                            <fmt:formatNumber type="number" pattern="(###) ###-####" 
                                                            value="${customer.phone}" var="formattedPhone" />
                                            <c:out value="${formattedPhone}" />
                                        </td>
                                        <td>
                                            <c:out value="${customer.street}, ${customer.city}, ${customer.state} ${customer.zip}"/>
                                        </td>
                                        <td><fmt:formatNumber type="currency" value="${customer.balance}"/></td>
                                        <td><fmt:formatNumber type="currency" value="${customer.totalSales}"/></td>
                                        <td>
                                            <form method="post" action="${pageContext.request.contextPath}/customerAdmin">
                                                <input type="hidden" name="modify_customer" value="${customer.customerId}">
                                                <input type="submit" value="Edit" class="btn btn-sm btn-primary">
                                            </form>
                                            <form method="post" action="${pageContext.request.contextPath}/customerAdmin"
                                                  onsubmit="return confirm('Are you sure you want to delete this customer?');">
                                                <input type="hidden" name="delete_customer" value="${customer.customerId}">
                                                <input type="submit" value="Delete" class="btn btn-sm btn-danger">
                                            </form>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </c:otherwise>
            </c:choose>

            <div class="row">
                <div class="col-xs-12">
                    <form method="post" class="form-horizontal" 
                          action="${pageContext.request.contextPath}/customerAdmin">
                        <input type="hidden" name="action" value="join">
                        <input type="submit" value="Add New Customer" class="btn btn-success">
                    </form>
                </div>
            </div>

            <%@ include file="/global/footer.jsp" %>
        </div> <!-- end starter-template -->
    </div> <!-- end container -->
</body>
</html>
