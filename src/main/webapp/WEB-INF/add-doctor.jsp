<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add doctor</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">

</head>
<body>
<%@include file="navbar.jsp"%>
    <hr>
</div>
<div>
<form:form  method="POST" action="/add-doctor" modelAttribute="doctorForm">
    <div class="py-5">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h3>Add doctor</h3>

        <hr>
            <div class="form-group row"> <label for="firstname" class="col-2 col-form-label">Name</label>
                    <div class="col-10">
                <form:input type="text" class="form-control"  id="firstname" path="firstName" name="first-name-textfield" placeholder="firstName"></form:input>
                        <form:errors path="firstName"></form:errors>
                            ${doctornameError}
            </div>
        </div>
                    <div class="form-group row">
                <label for="lastName" class="col-2 col-form-label">Lastname</label>
                    <div class="col-10">
                <form:input type="text" class="form-control"  path="lastName" name="last-name-textfield" placeholder="lastName" ></form:input>
                        <form:errors path="lastName"></form:errors>
                            ${doctornameError}
            </div>
        </div>
   <div class="form-group row"><label for="specialization" class="col-2 col-form-label">Specialization</label>
     <div class="col-10">
<%--           <form:input type="text"  path="specialization.specializationName" class="form-control" name="specialization" placeholder="specialization">--%>
<%--           </form:input>--%>
    <form:select  path="specialization.specializationName" id="specialization" name="specialization" class="form-control" placeholder="specialization" title="">
        <option selected="selected">-- Specialization --</option>
        <c:forEach items="${specialization}" var="specialization">
            <option value=${specialization.specializationName}>${specialization.specializationName}</option>
        </c:forEach>
    </form:select>

         <div class="form-group row"></div>
              </div>
   </div>
 <button type="submit" class="btn btn-primary" name="add-doctor-button" id="submit" value="save">
     Add doctor</button>
       </div>
         </div>
           </form:form>
          </div>

        <%@include file="footer.jsp"%>

</body>

</html>