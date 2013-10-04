<%-- 
    Document   : addinvestor
    Created on : 05 Jun 2013, 1:09:14 PM
    Author     : bmqolweni, nguni52
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="/WEB-INF/jsp/inc/includes.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/header.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/navigation.jsp" %>
<%@ include file="/WEB-INF/jsp/inc/breadcrumbs.jsp" %>
<script type="text/javascript" src="<%= request.getContextPath()%>/resources/js/investor.js"></script>
<section id="main">
    <article class="type-page">
        <header>
            <h1>
                <h1>Add an Investor</h1>
            </h1>
        </header>
        <form method="POST" id="addinvestor" name="addinvestor" action="<%=request.getContextPath()%>/admin/investor/addinvestor" >
            <fieldset>
                <legend>Investor Details</legend>
                <label>Investor Name:</label><input type="text" name="description" id="description" class="required" minlength="1" maxlength="45" /><br />
                <label>Contact Number:</label><input type="text" name="contactnumber" id="contactnumber" class="number" class="required" minlength="7" maxlength="15" /><br />
                <label>Email Address:</label><input type="email" name="investoremailaddress" id="investoremailaddress" class="required" minlength="6" maxlength="45" /><br />
            </fieldset>

            <ul class="collapsibleList">
                <li>      
                    <label for="mylist-node1">Contact Person Details</label>
                    <input type="checkbox" id="mylist-node1" />
                    <fieldset>
                        <label>Title:</label>
                        <select name="titleid">
                            <c:forEach items="${titleList}" var="title">
                                <option value="${title.titleId}">${title.title}</option>
                            </c:forEach>
                        </select><br />
                        <label>First Name:</label><input type="text" name="firstname" id="firstname" minlength="2" maxlength="45" /><br />
                        <label>Last Name:</label><input type="text" name="surname" id="surname" minlength="2" maxlength="45" /><br />
                        <label>Identity Number:</label><input type="text" name="identitynumber" id="identitynumber" minlength="2" maxlength="13" /><br />
                        <label>Gender:</label>
                        <select name="gender" id="gender">
                            <option>Male</option>
                            <option>Female</option>
                        </select><br />
                        <label>Job Title:</label><input type="text" name="jobtitle" id="jobtitle" minlength="1" maxlength="99" /><br />
                        <label>Email Address:</label><input type="email" name="personemailaddress" id="personemailaddress" minlength="6" maxlength="45" /><br />
                        <label>Work Number:</label><input type="text" name="worknumber" id="worknumber" class="number" minlength="7" maxlength="15" /><br />
                        <label>Mobile Number:</label><input type="text" name="mobilenumber" id="mobilenumber" class="number" minlength="7" maxlength="15" /><br />
                    </fieldset>
                </li>

                <li>
                    <label for="mylist-node2">Physical Address Details</label>
                    <input type="checkbox" id="mylist-node2" />
                    <fieldset>
                        <label>Street Number:</label><input type="text" name="streetnumber" id="streetnumber" class="number" minlength="1" maxlength="11" /><br />
                        <label>Street Name:</label><input type="text" name="streetname" id="streetname" minlength="2" maxlength="45" /><br />
                        <label>Unit Number:</label><input type="text" name="unitnumber" id="unitnumber" class="number" minlength="1" maxlength="11" /><br />
                        <label>Complex Name:</label><input type="text" name="complexname" id="complexname" minlength="2" maxlength="45" /><br />
                        <label>Suburb:</label><input type="text" name="physicaladdresssuburb" id="physicaladdresssuburb" minlength="2" maxlength="45" /><br />
                        <label>City:</label><input type="text" name="city" id="city" minlength="2" maxlength="45" /><br />
                        <label>Code:</label><input type="text" name="physicaladdresscode" id="physicaladdresscode" class="number" minlength="1" maxlength="11" /><br />
                        <label>Status:</label><input type="text" name="physicaladdressstatus" id="physicaladdressstatus" minlength="1" /><br />
                    </fieldset>
                </li>

                <li>
                    <label for="mylist-node3">Postal Address Details</label>
                    <input type="checkbox" id="mylist-node3" />
                    <fieldset>
                        <label>Number:</label><input type="text" name="postaladdressnumber" id="postaladdressnumber" class="number" minlength="1" maxlength="11" /><br />
                        <label>Suburb:</label><input type="text" name="postaladdresssuburb" id="postaladdresssuburb" minlength="2" maxlength="45" /><br />
                        <label>Code:</label><input type="text" name="postaladdresscode" id="postaladdresscode" class="number" minlength="1" maxlength="11" /><br />
                        <label>Status:</label><input type="text" name="postaladdressstatus" id="postaladdressstatus" minlength="1" /><br />
                    </fieldset>
                </li>
            </ul>
            <label>&nbsp;</label><input type="submit" value="Add Investor">
        </form>
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>