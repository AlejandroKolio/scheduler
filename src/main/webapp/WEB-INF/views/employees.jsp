<%--
  Created by IntelliJ IDEA.
  User: alexander.shakhov
  Date: 17.05.2018
  Time: 14:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>

<head>
    <title>List Customers</title>
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
          crossorigin="anonymous">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>
</head>

<body>
<%--<div id="wrapper">
    <div id="header">
        <h3>CRM - Customer Relationship Manager</h3>
        <link type="text/css"
              rel="stylesheet"
              href="${pageContext.request.contextPath}/assets/css/bootstrap.min.css"/>
    </div>
</div>--%>

<div class="container bg-dark">
    <div class="row justify-content-md-center">
        <div class="pos-f-t">
            <h3 class="col-md-auto text-lg-center text-light">Customer Relationship Manager
                <span class="badge badge-primary">CRUD</span>
                <span class="badge badge-secondary">Hibernate</span> +
                <span class="badge badge-success">Spring Framework</span>
            </h3>
        </div>
    </div>
</div>


<div class="container">
    <div class="row justify-content-md-center bg-light">
        <div class="col">
            <table class="table table-hover table-striped table-bordered">
                <thead>
                <tr>
                    <div class="col col-lg-2">
                        <th scope="row">#</th>
                    </div>
                    <div class="col-md-auto">
                        <th scope="col">First Name</th>
                    </div>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Company</th>
                    <th scope="col">Profile</th>
                </tr>
                </thead>
                <tbody>
                <c:forEach var="employee" items="${employees}">
                    <tr>
                        <th scope="row">${employee.id}</th>
                        <td>${employee.firstName}</td>
                        <td>${employee.lastName}</td>
                        <td>${employee.email}</td>
                        <td>${employee.company}</td>
                        <td>${employee.employeeProfile}</td>
                    </tr>
                </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>


<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
        integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
        crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
        integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
        crossorigin="anonymous"></script>
</body>

</html>









