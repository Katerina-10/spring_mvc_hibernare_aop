<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>

<body>
<h2> Emploee Info</h2>
<br>

<form:form action="saveNewEmployee" modelAttribute="employeeAttribute">
    <form:hidden path="id"/>

    Name<form:input path="name"/>
    <br>
    Surname<form:input path="surname"/>
    <br>
    Department<form:input path="department"/>
    <br>
    Salary<form:input path="salary"/>
    <br><br>
    <input type="submit" value="ok"  >
</form:form>


</body>
</html>
