<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%--
  Created by IntelliJ IDEA.
  User: Dinexpod
  Date: 31.01.2019
  Time: 18:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link type="text/css" rel="stylesheet" media="screen"
          href="${pageContext.request.contextPath}/resources/styles/style.css"/>
    <title>developer</title>
</head>
<body>
<button type="button" name="back" onclick="history.back()">back</button>
<h1>
    this is developers
</h1>

<table>
    <th>Id</th>
    <th>Name</th>
    <th>Info</th>
    <th>Update</th>
    <th>Delete</th>
    <%--@elvariable id="developers" type="java.util.List"--%>
    <c:forEach items="${developers}" var="developer">
        <tr>

            <td>${developer.developerId}</td>
            <td>${developer.developerName}</td>
            <td>
                <a href="${pageContext.request.contextPath}/developer/${developer.developerId}/">
                    <button type="submit" name="info" value="info">info</button>
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/developer/update/${developer.developerId}/">
                    <button type="submit" name="update" value="update">update</button>
                </a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/developer/delete/{developerId}">
                    <form method="POST"
                          action="${pageContext.request.contextPath}/developer/delete/${developer.developerId}">
                            <%--<button type="submit" name="delete" value="delete">delete</button>--%>
                        <input type="submit" value="delete">
                    </form>
                </a>
            </td>
        </tr>
    </c:forEach>
</table>

<%--<script>--%>
<%--//delete--%>
<%--$(".deleteForm").submit(function (event) {--%>
<%--event.preventDefault();--%>
<%--var form = $(this);--%>
<%--var id = form.find('button[name="delete"]').val();--%>
<%--var url = '/developer/' + id;--%>
<%--var line = form.parent('td').parent('tr');--%>
<%--$.ajax({--%>
<%--type: 'DELETE',--%>
<%--url: url,--%>
<%--contentType: 'application/x-www-form-urlencoded',--%>
<%--data: "id=" + id,--%>
<%--success: function () {--%>
<%--line.remove();--%>
<%--},--%>
<%--error: function (xhr, status, error) {--%>
<%--alert(error);--%>
<%--}--%>
<%--});--%>
<%--});--%>
<%--</script>--%>

</body>
</html>
