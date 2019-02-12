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

    <title>login</title>
</head>

<div id="login">

<body>

<h1>LOGIN</h1>

<form method="POST"
      action="${pageContext.request.contextPath}/login">

    <span>${message}</span>
    <input name="username" type="text" class="form-control" placeholder="Username"
           autofocus="true"/>
    <input name="password" type="password" class="form-control" placeholder="Password"/>
    <span>${error}</span>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>

    <input type="submit" value="Login">
</form>

</body>

</div>

</html>
