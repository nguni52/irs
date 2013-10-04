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
                ${edit_person.firstname}  ${edit_person.surname} (${edit_user.username})
                <a id="edit"><img src="<c:url value='/resources/images/edit.png' />" /></a>
                <a id="delete"><img src="<c:url value='/resources/images/delete.png' />" /></a>
            </h1>
        </header>
        <section class="entry viewinvestor">
            <c:if test="${not empty message}">
                <div id="message"><spring:message code="${message}" /></div>
            </c:if>
            <c:if test="${not empty edit_person}">
            <form method="POST" name="viewuser" action="<%=request.getContextPath()%>/user/viewuser/${edit_user.userID}" >
                    <fieldset>                            
                        <label>username:</label>${edit_user.username}<br />       
                        <label>First Name:</label>${edit_person.firstname}<br /> 
                        <label>Last Name:</label>${edit_person.surname}<br /> 
                        <label>Identity Number:</label>${edit_person.identityNumber}<br />
                        <label>Gender:</label>${edit_person.gender}<br />
                        <label>Job Title:</label>${edit_person.jobTitle}<br/>
                        <label>Email Address:</label>${edit_person.emailAddress}<br />
                        <label>Work Number:</label>${edit_person.workNumber}<br />
                        <label>Mobile Number:</label>${edit_person.mobileNumber}<br /><br />  
                    </fieldset>
                </c:if>                        
            </form>
            <input type="hidden" value="${edit_user.userID}" id="userid" />
            <input type="hidden" value="<%=request.getContextPath()%>" id="contextpath" />
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>

