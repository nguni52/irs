<%-- 
    Document   : editassetmanager
    Created on : 16 Apr 2013, 7:55:56 PM
    Author     : nguni52
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/breadcrumbs.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/role.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>Roles</h1>
        </header>

        <h1>Edit Role</h1>
        <form id="editrole" method="POST" name="editrole" action="<%=request.getContextPath()%>/admin/role/editrole/${role.roleId}" >
            <section class="entry">
                <fieldset>                    
                    <label>Description:</label><input type="text" name="role_description" id="role_description" value="${role.description}" class="required" minlength="2" /><br />
                    
                </fieldset>
                <label>&nbsp;</label><input type="submit" value="Update Role">                
            </section><!-- /.entry -->
        </form>
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
