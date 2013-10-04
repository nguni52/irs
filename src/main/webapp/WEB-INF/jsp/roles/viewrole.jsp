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
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/user.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>
                ${role.description}
                <a id="edit"><img src="<c:url value='/resources/images/edit.png' />" /></a>
                <a id="delete"><img src="<c:url value='/resources/images/delete.png' />" /></a>
            </h1>
        </header>
        <section class="entry viewinvestor">
            <c:if test="${not empty message}">
                <div id="message"><spring:message code="${message}" /></div>
            </c:if>
            
            <input type="hidden" value="${role.roleId}" id="roleid" />
            <input type="hidden" value="<%=request.getContextPath()%>" id="contextpath" />
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>

