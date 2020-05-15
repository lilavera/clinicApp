<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <title>Clinic</title>


    <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css" type="text/css">
  <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">

  </head>
<jsp:include page="navbar.jsp"/>

<body class="">

<div>
<div>
<div class="py-5">
  <div class="container">
    <div class="row mb-5">


      <div class="col-md-7 bg-primary" style="">

        <h2 class="text-light" >Clinic information</h2>
        <p class="text-light">Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
      </div>
      <div class="col-md-5 align-self-center bg-primary" style="">
        <img class="img-fluid d-block w-100 img-thumbnail border border-light bg-dark" src="/images/clinic.jpg" alt="img" ></div>
    </div>
     </div>

<jsp:include page="footer.jsp"/>

</body>

</html>