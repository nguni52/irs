<%-- 
    Document   : index
    Created on : 12 Jun 2013, 7:08:33 AM
    Author     : nguni52
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/breadcrumbs.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/user.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>Please Change your Password</h1>
        </header>
        <section class="entry">
            <form id="resetpassword" method="POST" name="resetpassword" action="<%=request.getContextPath()%>/resetpassword" >
                <fieldset>
                    <legend>You are required to change your password on first logon</legend>
                    <label>Password:</label><input type="password" name="password" id="password" class="required" minlength="8" maxlength="45" /><br /> 
                    <label>Retype Password:</label><input type="password" name="password1" id="password1" class="required" equalTo="#password" /><br />     
                    <label>&nbsp;</label><input type="submit" value="Change Password">
                </fieldset>
            </form>

        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
