<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<nav class="navbar navbar-expand-md navbar-dark bg-primary">
    <div class="container">
        <a class="navbar-brand" href="/">
            <i class="fa d-inline fa-lg fa-stop-circle"></i>
            <b> e-CLinic</b>
        </a>
        <button class="navbar-toggler navbar-toggler-right border-0" type="button" data-toggle="collapse"
                data-target="#navbar10">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbar10">
            <ul class="navbar-nav ml-auto">
                <sec:authorize access="!isAuthenticated()">
                    <li class="nav-item"><a class="nav-link" href="/login">Login</a></li>
                    <li class="nav-item"><a class="nav-link" href="/registration">Sign Up</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item"><a class="nav-link" href="/add-doctor">Add doctor</a></li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
<%--                    <sec:authorize access="!hasRole('ROLE_ADMIN')">--%>
                        <li class="nav-item" style=""><a class="nav-link" href="/add-visit">Add visit</a></li>
<%--                    </sec:authorize>--%>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item" style=""><a class="nav-link" href="/add-shift">Add shift for doctor</a></li>
                </sec:authorize>
                <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <li class="nav-item" style=""><a class="nav-link" href="/admin">Manage patients</a></li>
                    <li class="nav-item" style=""><a class="nav-link" href="/admin-manage-doctor">Manage doctors</a>
                    </li>
                </sec:authorize>
                <sec:authorize access="isAuthenticated()">
                    <li class="nav-item"><a class="nav-link" href="/logout">Logout</a></li>
                </sec:authorize>
            </ul>
        </div>
    </div>
</nav>