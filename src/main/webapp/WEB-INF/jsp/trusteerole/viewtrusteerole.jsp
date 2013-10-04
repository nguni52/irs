<%-- 
    Document   : viewtrusteerole
    Created on : Dec 9, 2012, 12:39:56 PM
    Author     : lutendo
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/trusteerole.js"></script>

<section id="main">
    <article class="type-page">
        <header>
            <h1>
                ${trusteerole.trusteeRoleDescription} 
                <a id="edit"><img src="<c:url value='/resources/images/edit.png' />" /></a>
                <a id="delete"><img src="<c:url value='/resources/images/delete.png' />" /></a>
            </h1>
        </header>

        <section class="entry viewtrusteerole">
            <input type="hidden" value="${trusteerole.trusteeRoleID}" id="trusteeroleid" />
            <input type="hidden" value="<%=request.getContextPath()%>" id="contextpath" />
        </section>
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
