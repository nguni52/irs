<%-- 
    Document   : addassetmanager
    Created on : Apr 10, 2013, 7:38:28 PM
    Author     : Kenneth.Maposa
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/breadcrumbs.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/roles.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>Roles</h1>
        </header>
        <section class="entry">
            <h1>Add a Role</h1>
            <form id="addrole" method="POST" name="addrole" action="<%=request.getContextPath()%>/admin/role/addrole">

                <fieldset>                    
                    <label>Description:</label><input type="text" name="role_description" id="role_description" class="required" minlength="2" /><br />                        
                </fieldset>
                <label>&nbsp;</label><input type="submit" value="Add Role">

            </form>
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>