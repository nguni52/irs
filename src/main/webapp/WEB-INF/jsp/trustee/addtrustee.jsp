<%-- 
    Document   : addtrustee
    Created on : Dec 8, 2012, 12:06:10 PM
    Author     : Kenneth.Maposa
--%>

<%@page contentType="text/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=windows-1252">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Add a Trustee</h1>
        <form:form modelAttribute="trustee">
            <label>Client ID:</label><form:input path="client_id" /><br />
            <label>First Name:</label><form:input path="firstname" /><br />
            <label>Last Name:</label><form:input path="surname" /><br />
            <label>Cell:</label><form:input path="cell" /><br />
            <label>Tel:</label><form:input path="tel" /><br />
            <label>Trustee Role ID:</label><form:input path="trustee_role_id" /><br />
            <label>Status:</label><form:input path="status" /><br />
            <label>&nbsp;</label><input type="submit" value="Add Trustee">
        </form:form>
    </body>
</html>
