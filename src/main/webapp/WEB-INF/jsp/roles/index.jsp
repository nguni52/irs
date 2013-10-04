<%-- 
    Document   : viewusers
    Created on : Nov 22, 2012, 8:27:45 PM
    Author     : Kenneth.Maposa
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
            <h1>
                Roles
                <a href="<%= request.getContextPath()%>/admin/role/addrole/">
                    <img src="<c:url value='/resources/images/add.png' />" />
                </a>
            </h1>
        </header>
        <section class="entry">
            <c:if test="${not empty message}">
                <div id="message"><spring:message code="${message}" /></div>
            </c:if>
            <p>
                <c:choose>
                    <c:when test="${not empty roleList}">
                        <c:forEach var="role" items="${roleList}">
                            <a href="<%=request.getContextPath()%>/admin/role/viewrole/${role.roleId}">${role.description}</a>
                            <a href="<%=request.getContextPath()%>/admin/role/editrole/${role.roleId}">Edit</a>
                            <a href="<%=request.getContextPath()%>/admin/role/deleterole/${role.roleId}">Delete</a><br />
                        </c:forEach>
                    </c:when>
                    <c:otherwise>
                        There are no roles.
                    </c:otherwise>
                </c:choose>
            </p>            
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>

