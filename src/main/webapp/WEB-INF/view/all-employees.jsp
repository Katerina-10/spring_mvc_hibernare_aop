<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<body>
<h2> all-employees </h2>

<br>

<table>

    <tr>
        <th>Name</th>
        <th>Surname</th>
        <th>Department</th>
        <th>Salary</th>
        <th>Operations</th>
    </tr>

    <c:forEach var="emp" items="${allEmps}">
        <c:url var="updateButtonLink" value="/updateInfo">
            <c:param name="empId" value="${emp.id}">
            </c:param>
        </c:url>

        <c:url var="deleteButtonLink" value="/deleteEmpl">
            <c:param name="empId" value="${emp.id}">
            </c:param>
        </c:url>
        <tr>
            <td>${emp.name}</td>
            <td>${emp.surname}</td>
            <td>${emp.department}</td>
            <td>${emp.salary}</td>
            <td>
                <input type="button" value="update" onclick="window.location.href='${updateButtonLink}'"/>
                <input type="button" value="delete" onclick="window.location.href='${deleteButtonLink}'"/>
            </td>
        </tr>
    </c:forEach>

</table>

<br>
<input type="button" value="add" onclick="window.location.href= 'addNewEmployee' "/>

</body>
</html>
