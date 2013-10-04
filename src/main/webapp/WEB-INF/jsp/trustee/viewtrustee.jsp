<%-- 
    Document   : viewtrustee
    Created on : Dec 8, 2012, 12:07:07 PM
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
        <form:form modelAttribute="trustee">
            <label>Client ID:</label><form:input path="client_id" disabled="true"/><br />
            <label>First Name:</label><form:input path="firstname" disabled="true"/><br />
            <label>Last Name:</label><form:input path="surname" disabled="true"/><br />
            <label>Cell:</label><form:input path="cell" disabled="true"/><br />
            <label>Tel:</label><form:input path="tel" disabled="true"/><br />
            <label>Trustee Role ID:</label><form:input path="trustee_role_id" disabled="true"/><br />
            <label>Status:</label><form:input path="status" disabled="true"/><br />            
        </form:form>
    </body>
</html>
