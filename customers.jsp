<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <title>Customer List</title>
    <%@ include file="/css/include_css.jsp" %>
</head>
<body>
    <%@ include file="/global/nav_global.jsp" %>
    <div class="container">
        <h2>Customer List</h2>
        <div class="table-responsive">
            <table id="customerTable" class="table table-striped table-condensed">
                <thead>
                    <tr class="text-center">
                        <th>FName</th>
                        <th>LName</th>
                        <th>Email</th>
                        <th>Street</th>
                        <th>City</th>
                        <th>State</th>
                        <th>ZIP</th>
                        <th>Phone</th>
                        <th>Balance</th>
                        <th>Total Sales</th>
                        <th>Notes</th>
                        <th>Edit</th>
                        <th>Delete</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="user" items="${users}">
                        <tr>
                            <td><c:out value="${user.firstName}" /></td>
                            <td><c:out value="${user.lastName}" /></td>
                            <td><c:out value="${user.email}" /></td>
                            <td><c:out value="${user.street}" /></td>
                            <td><c:out value="${user.city}" /></td>
                            <td><c:out value="${user.state}" /></td>
                            <td><c:out value="${user.zip}" /></td>
                            <td><c:out value="${user.phone}" /></td>
                            <td><c:out value="${user.balance}" /></td>
                            <td><c:out value="${user.totalSales}" /></td>
                            <td><c:out value="${user.notes}" /></td>
                            <td>
                                <form action="${pageContext.request.contextPath}/customerAdmin" method="post">
                                    <input type="hidden" name="modify_customer" value="${user.id}" />
                                    <button type="submit">Edit</button>
                                </form>
                            </td>
                            <td>
                                <form action="${pageContext.request.contextPath}/customerAdmin" method="post" 
                                      onsubmit="return confirm('Do you really want to delete record?');">
                                    <input type="hidden" name="delete_customer" value="${user.id}" />
                                    <button type="submit">Delete</button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
    <%@ include file="/js/include_js.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $('#customerTable').DataTable({
                "lengthMenu": [ [10, 25, 50, -1], [10, 25, 50, "All"] ],
                "columns": [
                    null, null, null, null, null, null, null, null, null, null, null,
                    { "orderable": false },
                    { "orderable": false }
                ]
            });
        });
    </script>
</body>
</html>
