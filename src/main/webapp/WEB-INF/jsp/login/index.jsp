<%-- 
    Document   : index
    Created on : 14 Apr 2013, 11:22:12 AM
    Author     : nguni52
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>

<div class="content">
    <div id="login_form">
        <div id="stylized" class="myform round">
            <h1>Login</h1>
            <c:if test="${not empty error}">
                <div class="error">${error}</div>
            </c:if>
            <form name="f" action="<c:url value='j_spring_security_check'/>" method="POST">
                <table>
                    <tr>
                        <td><spring:message code="login.username" />:</td><td><input type='text' name='j_username' value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_username}"/></c:if>'/></td></tr>
                    <tr><td><spring:message code="login.password" />:</td><td><input type='password' name='j_password'></td></tr>
                    <tr><td>&nbsp;</td><td><input name="submit" type="submit" value="Login"></td></tr>
                </table>
            </form>
            </div>
        </div>
    </div>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>