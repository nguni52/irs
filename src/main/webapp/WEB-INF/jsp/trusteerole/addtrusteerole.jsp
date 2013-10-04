<%-- 
    Document   : addtrusteerole
    Created on : Jun 26, 2013, 5:29:27 PM
    Author     : lutendo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/trusteerole.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>
                <h1>Add a Trustee Role</h1>
            </h1>
        </header>
        <form id="addtrusteerole" method="POST" name="addtrusteerole" action="<%=request.getContextPath()%>/admin/trusteerole/addtrusteerole" >
            <fieldset>
                <legend>Trustee Role Details</legend>
                <label>Description:</label><input type="text" name="description" id="description" class="required" minlength="6" /><br />  
            </fieldset>
            
            <label>&nbsp;</label><input type="submit" value="Add Trustee Role">

        </form>
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>