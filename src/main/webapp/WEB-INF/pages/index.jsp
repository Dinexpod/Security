<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 12.02.2019
  Time: 17:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/loginStyle.css"/>

    <title>index</title>
</head>

<div id="login">

    <h1> Welcome!!! </h1>
    <h1> You are located on main page WebSite! </h1>

<body>

<a href="${pageContext.request.contextPath}/login">
    <form method="GET"
          action="${pageContext.request.contextPath}/login">
        <input type="submit" value=" Login ">
    </form>
</a>

<a href="${pageContext.request.contextPath}/developer">
    <form method="GET"
          action="${pageContext.request.contextPath}/developer">
        <input type="submit" value=" Developer page ">
    </form>
</a>

</body>

</div>

</html>
