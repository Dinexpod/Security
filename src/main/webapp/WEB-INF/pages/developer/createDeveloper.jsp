<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 30.01.2019
  Time: 17:32
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/loginStyle.css"/>
    <title>CreateDeveloper</title>
</head>
<button type="button" name="back" onclick="history.back()">back</button>
<div id="login">
<body>
<h1>
    Enter Developer's details
</h1>
<form method="POST"
      action="${pageContext.request.contextPath}/developer/addDev" modelattribute="developer">

    <span class="fontawesome-user"></span>
    <input  name="developerName" type="text" id="developerName" placeholder="developerName">

    <span class="fontawesome-user"></span>
    <input  name="developerAge" type="text" id="developerAge" placeholder="developerAge">

    <span class="fontawesome-user"></span>
    <input  name="developerSalary" type="text" id="developerSalary" placeholder="developerSalary">

    <input type="submit" value="Submit"/>
    </form>
</body>
    </div>
</html>