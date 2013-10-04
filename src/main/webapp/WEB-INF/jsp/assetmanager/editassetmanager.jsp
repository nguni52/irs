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
                <h1>Edit an Asset Manager</h1>
            </h1>
        </header>
        <form id="editassetmanager" method="POST" name="editassetmanager" action="<%=request.getContextPath()%>/admin/assetmanager/editassetmanager/${assetmanager.assetManagerID}" >
            <fieldset>
                <legend>Asset Manager Details</legend>
                <label>Description:</label><input type="text" name="description" id="description" value="${assetmanager.assetManagerDescription}" class="required" minlength="1" maxlength="45" /><br />
                <label>Contact Number:</label><input type="text" name="contactnumber" id="contactnumber" value="${assetmanager.contactNumber}" class="number" class="required" minlength="7" maxlength="15" /><br />
                <label>Email Address:</label><input type="email" name="assetmanageremailaddress" id="assetmanageremailaddress" value="${assetmanager.emailAddress}" class="required" minlength="6" maxlength="45" /><br />
            </fieldset>

            <ul class="collapsibleList">
                <li>      
                    <label for="mylist-node1">Contact Person Details</label>
                    <input type="checkbox" id="mylist-node1" />                    
                        <c:if test="${not empty person}">
                            <fieldset>
                                <label>Title:</label>
                                <select name="titleid">
                                    <c:forEach items="${titleList}" var="title">
                                        <option value="${title.titleId}">${title.title}</option>
                                    </c:forEach>
                                </select><br />
                                <label>First Name:</label><input type="text" name="firstname" id="firstname"  value="${person.firstname}" minlength="2" maxlength="45" /><br />
                                <label>Last Name:</label><input type="text" name="surname" id="surname"  value="${person.surname}" minlength="2" maxlength="45" /><br />
                                <label>Identity Number:</label><input type="text" name="identitynumber" id="identitynumber" value="${person.identityNumber}" minlength="2" maxlength="13" /><br />
                                <label>Gender:</label>
                                <select name="gender" id="gender">
                                    <option>Male</option>
                                    <option>Female</option>
                                </select><br />
                                <label>Job Title:</label><input type="text" name="jobtitle" id="jobtitle" value="${person.jobTitle}" minlength="1" maxlength="99" /><br />
                                <label>Email Address:</label><input type="email" name="personemailaddress" id="personemailaddress" value="${person.emailAddress}" minlength="6" maxlength="45" /><br />
                                <label>Work Number:</label><input type="text" name="worknumber" id="worknumber" value="${person.workNumber}" class="number" minlength="7" maxlength="15" /><br />
                                <label>Mobile Number:</label><input type="text" name="mobilenumber" id="mobilenumber" value="${person.mobileNumber}" class="number" minlength="7" maxlength="15" />
                            </fieldset>
                        </c:if> 

                        <c:if test="${empty person}">
                            <fieldset>                                
                                <label>Title:</label>
                                <select name="titleid">
                                    <c:forEach items="${titleList}" var="title">
                                        <option value="${title.titleId}">${title.title}</option>
                                    </c:forEach>
                                </select><br />
                                <label>First Name:</label><input type="text" name="firstname" id="firstname"  value="${person.firstname}" minlength="2" maxlength="45" /><br />
                                <label>Last Name:</label><input type="text" name="surname" id="surname"  value="${person.surname}" minlength="2" maxlength="45" /><br />
                                <label>Identity Number:</label><input type="text" name="identitynumber" id="identitynumber" value="${person.identityNumber}" minlength="2" maxlength="13" /><br />
                                <label>Gender:</label>
                                <select name="gender" id="gender">
                                    <option>Male</option>
                                    <option>Female</option>
                                </select><br />
                                <label>Job Title:</label><input type="text" name="jobtitle" id="jobtitle" minlength="1" maxlength="99" /><br />
                                <label>Email Address:</label><input type="email" name="personemailaddress" id="personemailaddress" minlength="6" maxlength="45" /><br />
                                <label>Work Number:</label><input type="text" name="worknumber" id="worknumber" class="number" minlength="7" maxlength="15" /><br />
                                <label>Mobile Number:</label><input type="text" name="mobilenumber" id="mobilenumber" class="number" minlength="7" maxlength="15" />
                            </fieldset>
                        </c:if>
                </li>

                <li>
                    <label for="mylist-node2">Physical Address Details</label>
                    <input type="checkbox" id="mylist-node2" />
                    
                        <c:if test="${not empty physicaladdress}">
                            <fieldset>
                                <label>Street Number:</label><input type="text" name="streetnumber" id="streetnumber" value="${physicaladdress.streetNumber}" class="number" minlength="1" maxlength="11" /><br />
                                <label>Street Name:</label><input type="text" name="streetname" id="streetname" value="${physicaladdress.streetName}" minlength="2" maxlength="45" /><br />
                                <label>Unit Number:</label><input type="text" name="unitnumber" id="unitnumber" value="${physicaladdress.unitNumber}" class="number" minlength="1" maxlength="11" /><br />
                                <label>Complex Name:</label><input type="text" name="complexname" id="complexname" value="${physicaladdress.complexName}" minlength="2" maxlength="45" /><br />
                                <label>Suburb:</label><input type="text" name="physicaladdresssuburb" id="physicaladdresssuburb" value="${physicaladdress.suburb}" minlength="2" maxlength="45" /><br />
                                <label>City:</label><input type="text" name="city" id="city" value="${physicaladdress.city}" minlength="2" maxlength="45" /><br />
                                <label>Code:</label><input type="text" name="physicaladdresscode" id="physicaladdresscode" value="${physicaladdress.postalCode}" class="number" minlength="1" maxlength="11" /><br />
                                <label>Status:</label><input type="text" name="physicaladdressstatus" id="physicaladdressstatus" minlength="1" /><br />
                            </fieldset>   
                        </c:if>

                        <c:if test="${empty physicaladdress}">                
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
                        </c:if>
                </li>

                <li>
                    <label for="mylist-node3">Postal Address Details</label>
                    <input type="checkbox" id="mylist-node3" />
                    
                        <c:if test="${not empty postaladdress}">
                            <fieldset>
                                <label>Number:</label><input type="text" name="postaladdressnumber" id="postaladdressnumber" value="${postaladdress.number}" class="number" minlength="1" maxlength="11" /><br />
                                <label>Suburb:</label><input type="text" name="postaladdresssuburb" id="postaladdresssuburb" value="${postaladdress.suburb}" minlength="2" maxlength="45" /><br />
                                <label>Code:</label><input type="text" name="postaladdresscode" id="postaladdresscode" value="${postaladdress.postalCode}" class="number" minlength="1" maxlength="11" /><br />
                                <label>Status:</label><input type="text" name="postaladdressstatus" id="postaladdressstatus" minlength="1" /><br />
                            </fieldset>    
                        </c:if>

                        <c:if test="${empty postaladdress}">
                            <fieldset>
                                <label>Number:</label><input type="text" name="postaladdressnumber" id="postaladdressnumber" class="number" minlength="1" maxlength="11" /><br />
                                <label>Suburb:</label><input type="text" name="postaladdresssuburb" id="postaladdresssuburb" minlength="2" maxlength="45" /><br />
                                <label>Code:</label><input type="text" name="postaladdresscode" id="postaladdresscode" class="number" minlength="1" maxlength="11" /><br />
                                <label>Status:</label><input type="text" name="postaladdressstatus" id="postaladdressstatus" minlength="1" /><br />
                            </fieldset>                    
                        </c:if>    
                </li>
            </ul>
            <label>&nbsp;</label><input type="submit" value="Update Asset Manager">
        </form>
    </article>
</section>
<%@ include file="/WEB-INF/jsp/inc/footer.jsp" %>
