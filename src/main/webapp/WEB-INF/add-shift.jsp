<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
</head>
<body>
<%@include file="navbar.jsp" %>
<form:form method="POST" action="/add-shift" modelAttribute="shiftForm">
    <form:errors path="*" class="has-error"/>
    <div class="py-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>Add shift</h3>
                </div>
            </div>
            <div class="form-group row">
                <label for="doctor-list" class="col-2 col-form-label">Doctor:</label>
                <div class="col-10">
                    <form:select class="form-control" name="doctor-list" path="doctor.doctorId">
                        <c:forEach items="${shiftDoctors}" var="doctor">
                            <option value=${doctor.doctorId}>${doctor.firstName} ${doctor.lastName} </option>
                        </c:forEach></form:select>
                    <form:errors path="doctor.doctorId"></form:errors>
                        ${timeError}
                </div>
            </div>
            <div class="form-group row">
                <label for="day-list" class="col-2 col-form-label">Day of week:</label>
                <div class="col-10">
                    <form:select path="dayOfWeek" class="form-control" id="day-list" name="day-list" onchange="test()"
                                 title="">
                        <option value="1">Monday</option>
                        <option value="2">Tuesday</option>
                        <option value="3">Wednesday</option>
                        <option value="4">Thursday</option>
                        <option value="5">Friday</option>
                    </form:select>
                    <form:errors path="dayOfWeek"></form:errors>
                        ${timeError}
                </div>
            </div>
            <div class="form-group row">
                <label for="shiftStart" class="col-2 col-form-label">Start of the shift:</label>
                <div class="col-10">
                    <form:input path="shiftStart" type="time" class="form-control" name="shiftStart" id="shift-start-time"
                                min="08:00:00" max="15:45:00" step="900"></form:input>
                    <form:errors path="shiftStart"></form:errors>
                        ${timeError}
                </div>
            </div>
            <div class="form-group row">
                <label for="shiftEnd" class="col-2 col-form-label">End of the shift:</label>
                <div class="col-10">
                    <form:input path="shiftEnd" class="form-control" type="time" name="shiftEnd" id="shift-end-time"
                                min="08:15:00" max="17:45:00" step="900"></form:input>
                    <form:errors path="shiftEnd"></form:errors>
                        ${timeError}
                </div>
            </div>
            <button type="submit" class="btn btn-primary" name="add-doctor-button" id="submit" value="save">
                Add shift
            </button>
        </div>
    </div>
</form:form>
<%@include file="footer.jsp" %>
</body>
</html>