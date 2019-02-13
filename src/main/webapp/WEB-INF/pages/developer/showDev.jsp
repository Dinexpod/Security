<%--@elvariable id="developer" type="mate.academy.spring.model.Developer"--%>
<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 30.01.2019
  Time: 17:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShowDev</title>
</head>
<body>
<h1>

    <button type="button" name="back" onclick="history.back()">back</button>

    Developer submit!
</h1>
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
            <td>Age:</td>
            <td>${developer.developerAge}</td>
        </tr>
        <tr>
            <td>Salary:</td>
            <td>${developer.developerSalary}</td>
        </tr>
    </table>
</h2>
</body>
</html>