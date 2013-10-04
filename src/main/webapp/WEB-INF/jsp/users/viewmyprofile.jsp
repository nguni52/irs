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
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/profile.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>
                ${current_person.firstname}  ${current_person.surname} (${current_user.username})
                <a id="edit"><img src="<c:url value='/resources/images/edit.png' />" /></a>
                
            </h1>
        </header>
        <section class="entry viewinvestor">
            <c:if test="${not empty message}">
                <div id="message"><spring:message code="${message}" /></div>
            </c:if>
            <c:if test="${not empty current_person}">
            <form method="POST" name="viewmyprofile" action="<%=request.getContextPath()%>/user/viewmyprofile/${current_user.userID}" >
                    <fieldset>                            
                        <label>username:</label>${current_user.username}<br />       
                        <label>First Name:</label>${current_person.firstname}<br /> 
                        <label>Last Name:</label>${current_person.surname}<br /> 
                        <label>Identity Number:</label>${current_person.identityNumber}<br />
                        <label>Gender:</label>${current_person.gender}<br />
                        <label>Job Title:</label>${current_person.jobTitle}<br/>
                        <label>Email Address:</label>${current_person.emailAddress}<br />
                        <label>Work Number:</label>${current_person.workNumber}<br />
                        <label>Mobile Number:</label>${current_person.mobileNumber}<br /><br />  
                    </fieldset>
                </c:if>                        
            </form>
            <input type="hidden" value="${current_user.userID}" id="userid" />
            <input type="hidden" value="<%=request.getContextPath()%>" id="contextpath" />
        </section><!-- /.entry -->
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>

