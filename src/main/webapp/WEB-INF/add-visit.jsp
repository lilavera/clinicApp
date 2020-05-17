<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.verkhogliadoval.entity.Doctor" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Add visit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
</head>
<body>
<%@include file="navbar.jsp" %>
<form:form method="POST" action="/add-visit" modelAttribute="visitForm">
    <div class="py-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>Add visit</h3>
                </div>
            </div>
            <div class="form-group row">
                <label for="visit-date" class="col-2 col-form-label">Date</label>
                <div class="col-10">
                    <form:input path="visitDate" type="date" name="visitDateTime" id="visit-date"
                                class="form-control"></form:input>
                    <form:errors path="visitDate"></form:errors>
                        ${visitError}
                </div>
            </div>
            <div class="form-group row">
                <label for="visit-time" class="col-2 col-form-label">Time:</label>
                <div class="col-10">
                    <form:input class="form-control" path="visitTime" type="time" name="visit-time" id="visit-time"
                                step="900"
                                min="08:00:00" max="17:45:00"></form:input>
                    <form:errors path="visitTime"></form:errors>
                        ${visitError}
                </div>
            </div>
            <div class="form-group row">
                <label for="specialization-list" class="col-2 col-form-label">Specialization:</label>
                <div class="col-10">
                    <form:select path="specialization.specializationId" id="specialization-list"
                                 name="specialization-list"
                                 class="form-control" onchange="test()" title="">
                        <option selected="selected">-- Specialization --</option>
                        <c:forEach items="${specializations}" var="specialization">
                            <option value=${specialization.specializationId}>${specialization.specializationName}</option>
                        </c:forEach>
                    </form:select>
                </div>
            </div>
            <div class="form-group row">
                <label for="doctor-list" class="col-2 col-form-label">Doctor:</label>
                <div class="col-10">
                    <form:select name="doctor-list" id="doctor-list" class="form-control" type="hidden"
                                 path="doctor.doctorId">
                        <option selected="selected">-- Doctor --</option>
                    </form:select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary" name="add-doctor-button" id="submit" value="save">
                Add visit
            </button>
        </div>
    </div>
</form:form>
<script type="text/javascript">
    function test() {
        var e = document.getElementById("specialization-list");
        var specialist = e.options[e.selectedIndex].text;
        var doctors = document.getElementById("doctor-list");
        var i;
        for (i = doctors.options.length - 1; i >= 0; i--) {
            doctors.remove(i);
        }
        <c:forEach var="doctor" items="${doctor}">
        if (specialist === "${doctor.getSpecialization().getSpecializationName()}") {
            var option = document.createElement("option");
            option.text = "${doctor.getFullName()}";
            option.value = "${doctor.doctorId}";
            doctors.add(option);
        }
        </c:forEach>
    }

    $(document).ready(function () {
        var date = new Date();

        var day = date.getDate();
        var month = date.getMonth() + 1;
        var year = date.getFullYear();

        if (month < 10) month = "0" + month;
        if (day < 10) day = "0" + day;

        var today = year + "-" + month + "-" + day;
        $("#visit-date").attr("value", today);
    });

</script>
<jsp:include page="footer.jsp"/>
</body>
</html>
