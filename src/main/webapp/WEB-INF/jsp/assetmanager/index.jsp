<%-- 
    Document   : viewassetmanagers
    Created on : 16 Apr 2013, 8:14:50 PM
    Author     : nguni52
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/breadcrumbs.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/datatables.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/assetmanager.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>
                Asset Managers
                <a href="<%= request.getContextPath()%>/admin/assetmanager/addassetmanager/"><img src="<c:url value='/resources/images/add.png' />" /></a>
            </h1>
        </header>
        <section class="entry">
            <c:if test="${not empty message}">
                <div id="message"><spring:message code="${message}" /></div>
            </c:if>
            <p>
                <c:choose>
                    <c:when test="${not empty assetmanagers}">
                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="assetmanagers">
                        <thead>
                            <tr role="row">
                                <th>Asset Manager</th>
                                <th>Operations</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="assetmanager" items="${assetmanagers}">
                                <tr>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/admin/assetmanager/viewassetmanager/${assetmanager.assetManagerID}">${assetmanager.assetManagerDescription}</a>
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/admin/assetmanager/editassetmanager/${assetmanager.assetManagerID}">Edit</a>&nbsp;&nbsp;
                                        <a href="<%=request.getContextPath()%>/admin/assetmanager/deleteassetmanager/${assetmanager.assetManagerID}">Delete</a>
                                    </td>    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    There are no asset managers.
                </c:otherwise>
            </c:choose>
            </p>
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>