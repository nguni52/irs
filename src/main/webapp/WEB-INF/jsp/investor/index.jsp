<%-- 
    Document   : viewivestors
    Created on : 16 Jun 2013, 10:14:50 PM
    Author     : bmqolweni
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/breadcrumbs.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/datatables.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/investor.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>
                Investors
                <a href="<%= request.getContextPath()%>/admin/investor/addinvestor/"><img src="<c:url value='/resources/images/add.png' />" /></a>
            </h1>
        </header>
        <section class="entry">
            <c:if test="${not empty message}">
                <div id="message"><spring:message code="${message}" /></div>
            </c:if>
            <p>
                <c:choose>
                    <c:when test="${not empty investors}">
                    <table cellpadding="0" cellspacing="0" border="0" class="display" id="investors">
                        <thead>
                            <tr role="row">
                                <th>Asset Manager</th>
                                <th>Operations</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="investor" items="${investors}">
                                <tr>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/admin/investor/viewinvestor/${investor.investorID}">${investor.investorDescription} </a>
                                    </td>
                                    <td>
                                        <a href="<%=request.getContextPath()%>/admin/investor/editinvestor/${investor.investorID}">Edit</a>&nbsp;&nbsp;
                                        <a href="<%=request.getContextPath()%>/admin/investor/deleteinvestor/${investor.investorID}">Delete</a><br />
                                    </td>    
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    There are no investors.
                </c:otherwise>
            </c:choose>

            </p>
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>