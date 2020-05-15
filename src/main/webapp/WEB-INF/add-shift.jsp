<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add shift</title>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
</head>
<body>
<%@include file="navbar.jsp"%>
<div class="container-fluid">
    <div class="row">
        <div class="col-md-6 col-md-offset-3">

        </div>
    </div>
    <hr>
</div>
<form:form  method="POST" action="/add-shift" modelAttribute="shiftForm">
    <form:errors path="*" class="has-error" />
    <div class="container">
        <div class="row text-center">
            <div class="col-md-6 col-md-offset-3 col-lg-offset-5 col-lg-2">
               <h3>Add shift for the doctor</h3>
            </div>
        </div>
        <hr>
            <div class="form-group row">
                <label for="doctor-list" class="col-2 col-form-label" >Lekarz:</label>
                <div class="col-10">
<%--&lt;%&ndash;                <select name="doctor-list" id="doctor-list" class="col-lg-8">&ndash;%&gt;--%>
                   <form:select class="form-control" name="doctor-list" path="doctor.doctorId">
                       <c:forEach items="${shiftDoctors}" var="doctor">
                        <option value=${doctor.doctorId}>${doctor.firstName} ${doctor.lastName} </option>
                       </c:forEach></form:select>
    <form:errors path="doctor.doctorId"></form:errors>
        ${timeError}
            </div>
            &nbsp;
        </div>
        <div class="form-group row">
                <label for="day-list" class="col-2 col-form-label" >Dzień tygodnia:</label>
            <div class="col-10">
                <form:select path="dayOfWeek" class="form-control" id="day-list" name="day-list"  onchange="test()" title="">
                    <option value="1">Poniedziałek</option>
                    <option value="2">Wtorek</option>
                    <option value="3">Środa</option>
                    <option value="4">Czwartek</option>
                    <option value="5">Piątek</option>
                </form:select>
                <form:errors path="dayOfWeek"></form:errors>
                    ${timeError}
<%--                <form:input path="dayOfWeek" type="text" name="shiftStart" id="shift-start-time" ></form:input>--%>
            </div>
            &nbsp;
        </div>
        <div class="form-group row">
                <label for="shiftStart" class="col-2 col-form-label">Początek zmiany:</label>
            <div class="col-10">
                <form:input path="shiftStart" type="time" class="form-control" name="shiftStart" id="shift-start-time" min="08:00:00" max="15:45:00" step="900"></form:input>
                <form:errors path="shiftStart"></form:errors>
                    ${timeError}
            </div>
        </div>
        <div class="form-group row">
                <label for="shiftEnd" class="col-2 col-form-label">Koniec zmiany:</label>
            <div class="col-10">
                <form:input  path="shiftEnd" class="form-control" type="time" name="shiftEnd" id="shift-end-time"  min="08:15:00" max="17:45:00" step="900" ></form:input>
                <form:errors path="shiftEnd"></form:errors>
                    ${timeError}
                </input>
            </div>
            &nbsp;
        </div>
    </div>

    <div class="row">
        <div class="text-center col-md-12">
            <input type="submit"  class="btn btn-primary" name="add-shift-button" id="submit" value="Dodaj zmianę">
        </div>
    </div>
</form:form>

<%@include file="footer.jsp"%>

</body>
</html>
