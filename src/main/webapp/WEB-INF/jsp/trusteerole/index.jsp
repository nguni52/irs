<%-- 
    Document   : index
    Created on : 02 Dec 2012, 8:06:37 PM
    Author     : lutendo
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/breadcrumbs.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/trusteerole.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>
                Trustee Roles
                <a href="<%= request.getContextPath()%>/admin/trusteerole/addtrusteerole/"><img src="<c:url value='/resources/images/add.png' />" /></a>
            </h1>
        </header>
        <section class="entry">
            <c:if test="${not empty message}">
                <div id="message"><spring:message code="${message}" /></div>
            </c:if>
            <p>
                <c:choose>
                    <c:when test="${not empty assetmanagers}">
                        <c:forEach var="trusteerole" items="${trusteeroles}">
                            <a href="<%=request.getContextPath()%>/admin/trusteerole/viewtrusteerole/${trusteerole.trusteeRoleID}">${trusteerole.trusteeRoleDescription} </a>
                            <a href="<%=request.getContextPath()%>/admin/trusteerole/edittrusteerole/${trusteerole.trusteeRoleID}">Edit</a>
                            <a href="<%=request.getContextPath()%>/admin/trusteerole/deletetrusteerole/${trusteerole.trusteeRoleID}">Delete</a><br />
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        There are no Trustee Roles.
                    </c:otherwise>
                </c:choose>
            </p>
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>