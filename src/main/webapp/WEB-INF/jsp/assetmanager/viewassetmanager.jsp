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
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/assetmanager.js"></script>

<section id="main">
    <article class="type-page">
        <header>
            <h1>
                ${assetmanager.assetManagerDescription} : ${assetmanager.contactNumber} - ${assetmanager.emailAddress}
                <a id="edit"><img src="<c:url value='/resources/images/edit.png' />" /></a>
                <a id="delete"><img src="<c:url value='/resources/images/delete.png' />" /></a>
            </h1>
        </header>

        <section class="entry viewinvestor">
            <c:if test="${not empty message}">
                <div id="message"><spring:message code="${message}" /></div>
            </c:if>
            <c:if test="${not empty person}">
                <fieldset>
                    <legend>Contact Person Details</legend>
                    <label>First Name:</label>${person.firstname}<br />
                    <label>Last Name:</label>${person.surname}<br />
                    <label>Identity Number:</label>${person.identityNumber}<br />
                    <label>Gender:</label>${person.gender}<br />
                    <label>Job Title:</label>${person.jobTitle}<br/>
                    <label>Email Address:</label>${person.emailAddress}<br />
                    <label>Work Number:</label>${person.workNumber}<br />
                    <label>Mobile Number:</label>${person.mobileNumber}<br />
                </fieldset>
            </c:if>
            <c:if test="${not empty physicaladdress}">
                <fieldset>
                    <legend>Physical Address Details</legend>
                    <label>City:</label>${physicaladdress.city}<br />
                    <label>Complex Name:</label>${physicaladdress.complexName}<br />
                    <label>Code:</label>${physicaladdress.postalCode}<br />
                    <label>Status:</label>${physicaladdress.status}<br />
                    <label>Street Number:</label>${physicaladdress.streetNumber}<br />
                    <label>Suburb:</label>${physicaladdress.suburb}<br />
                    <label>Street Name:</label>${physicaladdress.streetName}<br />
                    <label>Unit Number:</label>${physicaladdress.unitNumber}<br />
                </fieldset>
            </c:if>
            <c:if test="${not empty postaladdress}">
                <fieldset>
                    <legend>Postal Address Details</legend>
                    <label>Number:</label>${postaladdress.number}<br />
                    <label>Suburb:</label>${postaladdress.suburb}<br />
                    <label>Code:</label>${postaladdress.postalCode}<br />
                    <label>Status:</label>${postaladdress.status}<br />       
                </fieldset>
            </c:if>
            <input type="hidden" value="${assetmanager.assetManagerID}" id="assetmanagerid" />
            <input type="hidden" value="<%=request.getContextPath()%>" id="contextpath" />
        </section>
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
