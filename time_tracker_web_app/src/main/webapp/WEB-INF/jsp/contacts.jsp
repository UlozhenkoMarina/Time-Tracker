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

    <input type="text" class="form-control pull-right" style="width:20%" id="search"
           placeholder="Type to search table...">

    <table class="table" id="mytable">
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Name</th>
            <th scope="col">Surname</th>
            <th scope="col">Number</th>
            <th scope="col">City</th>
        </tr>
        </thead>
        <tbody>

        <c:forEach items="${contacts}" var="item">
            <tr>
                <td><c:out value="${item.name}"/></td>
                <td><c:out value="${item.surname}"/></td>
                <td><c:out value="${item.mobileNumber}"/></td>
                <td><c:out value="${item.city}"/></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>

</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

<script>
    // Write on keyup event of keyword input element
    $(document).ready(function(){
        $("#search").keyup(function(){
            _this = this;

            // Show only matching TR, hide rest of them
            $.each($("#mytable tbody tr"), function() {
                if($(this).text().toLowerCase().indexOf($(_this).val().toLowerCase()) === -1)
                {
                    $(this).hide();
                }
                else
                {
                    $(this).show();
                }
            });
        });
    });
</script>

</body>
</html>