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
<%@ include file="/WEB-INF/jsp/inc/datatables.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/user.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>
                Users
                <a href="<%= request.getContextPath()%>/admin/user/adduser/">
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
                    <c:when test="${not empty users}">
                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="users">
                        <thead>
                            <tr role="row">
                                <th>Asset Manager</th>
                                <th>Operations</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="user" items="${users}">
                                <tr>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/admin/user/viewuser/${user.userID}">${user.username}</a>
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/admin/user/edituser/${user.userID}">Edit</a>&nbsp;&nbsp;
                                        <a href="<%=request.getContextPath()%>/admin/user/deleteuser/${user.userID}">Delete</a><br />
                                    </td>    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    There are no users.
                </c:otherwise>
            </c:choose>
            </p>            
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>

