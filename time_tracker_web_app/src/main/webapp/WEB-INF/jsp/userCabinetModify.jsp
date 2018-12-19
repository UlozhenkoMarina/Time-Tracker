<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Log in with your account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container">

    <form method="POST" action="${contextPath}/userCabinetModify" class="form-signin">
        <h2 class="form-heading">Change information about yourself</h2>

        <div class="form-group ${error != null ? 'has-error' : ''}">
            <form action="@{/signup" object="${registerForm}" method="POST">
                <span>${message}</span>
                <input name="email" type="text" field="*{email}" class="form-control" placeholder="Email"
                       autofocus="true"/>
                <input name="username" type="text" field="*{username}" class="form-control" placeholder="Username"
                       autofocus="true"/>
                <input name="name" type="text" field="*{name}" class="form-control" placeholder="Name"
                       autofocus="true"/>
                <input name="surname" type="text" field="*{surname}" class="form-control" placeholder="Surname"
                       autofocus="true"/>
                <input name="phone" type="text" field="*{phone}" class="form-control" placeholder="Phone"
                       autofocus="true"/>
                <input name="country" type="text" field="*{country}" class="form-control" placeholder="Country"
                       autofocus="true"/>
                <input name="city" type="text" field="*{city}" class="form-control" placeholder="City"
                       autofocus="true"/>
                <input name="password" type="password" field="*{password}" class="form-control" placeholder="Password"/>
                <span>${error}</span>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

                <button class="btn btn-lg btn-primary btn-block" type="submit">Register</button>
            </form>
        </div>

    </form>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>