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
            <h1>Users</h1>
        </header>

        <h1>Edit User</h1>
        <form id="edituser" method="POST" name="edituser" action="<%=request.getContextPath()%>/admin/user/edituser/${edit_user.userID}" >
            <section class="entry">
                <fieldset>
                    <legend>User Details</legend>
                    <label>username:</label><input type="text" name="username" id="username" value="${edit_user.username}" disabled="true" class="required" minlength="1" maxlength="20" /><br />
                    <label>Password:</label><input type="password" name="password" id="password" minlength="8" maxlength="45" /><br />    
                    <label>Retype Password:</label> <input type="password" id="retypepword" equalTo="#password" /><br />
                    <label>Role:</label>
                    <select name="roleid">
                        <c:forEach items="${roleList}" var="role">
                            <option value="${role.roleId}">${role.description}</option>
                        </c:forEach>
                    </select><br />
                    <label>Title:</label>
                    <select name="titleid">
                        <c:forEach items="${titleList}" var="title">
                            <option value="${title.titleId}">${title.title}</option>
                        </c:forEach>
                    </select><br />
                    <label>First Name:</label><input type="text" name="firstname" id="firstname" value="${edit_person.firstname}" class="required" minlength="1" maxlength="45" /><br />
                    <label>Last Name:</label><input type="text" name="surname" id="surname" value="${edit_person.surname}" class="required" minlength="1" maxlength="45" /><br />
                    <label>Identity Number:</label><input type="text" name="identitynumber" id="identitynumber" value="${edit_person.identityNumber}" class="required" minlength="1" maxlength="13" /><br />
                    <label>Gender:</label>
                    <select name="gender" id="gender">
                        <option>Male</option>
                        <option>Female</option>
                    </select><br />
                    <label>Job Title:</label><input type="text" name="jobtitle" id="jobtitle" value="${edit_person.jobTitle}" class="required" minlength="1" maxlength="99" /><br/>
                    <label>Email Address:</label><input type="email" name="personemailaddress" id="personemailaddress" value="${edit_person.emailAddress}" class="required" minlength="6" maxlength="45" /><br />
                    <label>Work Number:</label><input type="text" name="worknumber" id="worknumber" value="${edit_person.workNumber}" class="number" class="required" minlength="7" maxlength="15" /><br />
                    <label>Mobile Number:</label><input type="text" name="mobilenumber" id="mobilenumber" value="${edit_person.mobileNumber}" class="number" class="required" minlength="7" maxlength="15" /><br /><br />      
                </fieldset>
                
                <input type="button" value="Cancel"/>
                <%--<a href="<c:url value='/admin/user/cancel'/>"></a>--%>
                <input type="submit" value="<spring:message code="${update}" />">                
            </section><!-- /.entry -->
        </form>
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
