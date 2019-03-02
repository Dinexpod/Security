<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 28.02.2019
  Time: 15:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/loginStyle.css"/>

    <title>createProject</title>
</head>

<button type="button" name="back" onclick="history.back()">back</button>

<div id="login">

<body>
<h1>
    Enter Project's details
</h1>

<form method="POST"
      action="${pageContext.request.contextPath}/project/addProject" modelattribute="developer">

    <span class="fontawesome-user"></span>
    <input  name="projectCost" type="text" id="projectCost" placeholder="projectCost">

    <span class="fontawesome-user"></span>
    <input  name="projectName" type="text" id="projectName" placeholder="projectName">

    <span class="fontawesome-user"></span>
    <input  name="projectType" type="text" id="projectType" placeholder="projectType">

    <input type="submit" value="Submit"/>
</form>

</body>
</div>
</html>
