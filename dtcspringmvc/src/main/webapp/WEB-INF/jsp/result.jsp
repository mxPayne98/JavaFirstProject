<%--
  Created by IntelliJ IDEA.
  User: bhavyamkark98
  Date: 9/6/2020
  Time: 2:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
    <title>Result</title>
</head>
<body>
<div class="container">
    <h2>Result</h2>
    Operation: ${result.transaction.operation}
    <br>
    Output: ${result.transaction.output}
    <br>
    Inputs:
    <c:forEach var="input" items="${result.transaction.inputs}">
        <br>
        <c:out value="${input}"/>
    </c:forEach>
    <br>
    <a href="/">Back</a>
</div>
</body>
</html>
