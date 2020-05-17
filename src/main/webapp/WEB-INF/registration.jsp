<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Registration</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css"
          type="text/css">
    <link rel="stylesheet" href="https://static.pingendo.com/bootstrap/bootstrap-4.3.1.css">
</head>
<body>
<form:form method="POST" modelAttribute="userForm">
    <jsp:include page="navbar.jsp"/>
    <div class="py-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="form-group row"><label for="username" class="col-2 col-form-label">Username</label>
                        <div class="col-10">
                            <form:input type="text" path="username" class="form-control" placeholder="Username"
                                        autofocus="true"></form:input>
                            <form:errors path="username"></form:errors>
                                ${usernameError}
                        </div>
                    </div>
                    <div class="form-group row"><label for="password" class="col-2 col-form-label">Password</label>
                        <div class="col-10">
                            <div>
                                <form:input type="password" path="password" class="form-control"
                                            placeholder="Password"></form:input>
                            </div>
                        </div>
                    </div>
                    <div class="form-group row"><label for="password" class="col-2 col-form-label">Confirm
                        Password</label>
                        <div class="col-10">
                            <div>
                                <form:input type="password" path="passwordConfirm" class="form-control"
                                            placeholder="Confirm your password"></form:input>
                                <form:errors path="password"></form:errors>
                                    ${passwordError}
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary">Sign up</button>
                </div>
            </div>
        </div>
    </div>
</form:form>
<jsp:include page="footer.jsp"/>
</body>
</html>