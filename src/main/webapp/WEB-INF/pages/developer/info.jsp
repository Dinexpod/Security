<%--@elvariable id="developer" type="mate.academy.spring.model.Developer"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Device info</title>
</head>
<body>

<button type="button" name="back" onclick="history.back()">back</button>

<h2>
    <table>
        <tr>
            <td>Id:</td>
            <td>${developer.developerId}</td>
        </tr>
        <tr>
            <td>Name:</td>
            <td>${developer.developerName}</td>
        </tr>
        <tr>
            <td>Age :</td>
            <td>${developer.developerAge}</td>
        </tr>
        <tr>
            <td>Salary :</td>
            <td>${developer.developerSalary}</td>
        </tr>
    </table>
</h2>
</body>
</html>