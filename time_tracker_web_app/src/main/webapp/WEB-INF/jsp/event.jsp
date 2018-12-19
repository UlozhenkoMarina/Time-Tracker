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
<jsp:include page="navbar.jsp" />
<div class="container">

    <div class="form-group">
        <form action="/createEvent" object="${createForm}" method="POST">
            <input name="name" type="text" field="*{name}" class="form-control"
                   placeholder="Name"/>
            <input name="description" type="text" field="*{description}"  class="form-control"
                placeholder="Description" />
            <input name="data" type="date" field="*{date}" class="form-control" />
            <input name="priority" type="number" field="*{priority}" class="form-control">

            <button class="btn btn-lg btn-primary btn-block" type="submit">Create</button>
        </form>
    </div>

    <table class="table">
        <thead>
        <tr>
            <th scope="col">Name</th>
            <th scope="col">Priority</th>
            <th scope="col">Description</th>
            <th scope="col">Date</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${allEvents}" var="item">
            <tr>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.priority}"/></td>
                <td><c:out value="${item.description}"/></td>
                <td><c:out value="${item.date}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>