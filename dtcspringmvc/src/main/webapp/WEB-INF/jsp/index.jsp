<%--
  Created by IntelliJ IDEA.
  User: bhavyamkark98
  Date: 9/6/2020
  Time: 2:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/styles.css"/>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#inputs").hide();
            $("#nlp").hide();
            $("#single-date").hide();
            $("#double-date").hide();
            $("#numberofx").hide();
            $('#operation').on('change', function () {
                $("#nlp").hide();
                $("#single-date").hide();
                $("#double-date").hide();
                $("#numberofx").hide();
                if (this.value == 11) {
                    $("#inputs").show();
                    $("#nlp").show();
                } else if (this.value == 1 || this.value == 2) {
                    $("#inputs").show();
                    $("#double-date").show();
                } else if (this.value == 10 || this.value == 9) {
                    $("#inputs").show();
                    $("#single-date").show();
                } else if (this.value >= 3 && this.value <= 8) {
                    $("#inputs").show();
                    $("#single-date").show();
                    $("#numberofx").show();
                }
            });
        });
    </script>
    <title>Calculator</title>
</head>
<body>
<div class="container">
    <h2>Date Time Calculator</h2>
    <p class="error">${errorMessage}</p>
    <form action="/operate" method="POST">
        <label for="operation">Choose operation:</label>
        <select name="option" id="operation">
            <option value=0></option>
            <option value=1>1. add dates</option>
            <option value=2>2. subtract dates</option>
            <option value=3>3. add n days to a specific date</option>
            <option value=4>4. subtract n days to a specific date</option>
            <option value=5>5. add n weeks to a specific date</option>
            <option value=6>6. subtract n weeks to a specific date</option>
            <option value=7>7. add n months to a specific date</option>
            <option value=8>8. subtract n months to a specific date</option>
            <option value=9>9. day of the week of a specific date</option>
            <option value=10>10. week number of a specific date</option>
            <option value=11>11. natural language command</option>
            <option value=12>12. view history</option>
        </select>
        <div id="inputs">
            <div id="nlp">
                <label for="expression">Enter natural expression:</label>
                <input type="text" id="expression" name="expression">
            </div>
            <div id="single-date">
                <label for="date0">Pick Date:</label>
                <input type="date" id="date0" name="date">
            </div>
            <div id="double-date">
                <label for="date1">Pick Date:</label>
                <input type="date" id="date1" name="date1">
                <br>
                <label for="date2">Pick Date:</label>
                <input type="date" id="date2" name="date2">
            </div>
            <div id="numberofx">
                <label for="increment">Enter value of n:</label>
                <input type="number" id="increment" name="increment">
            </div>
        </div>
        <input type="submit" value="Submit"/>

    </form>
</div>
</body>
</html>