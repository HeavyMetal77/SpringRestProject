<%--
  Created by IntelliJ IDEA.
  User: heavy
  Date: 12.01.2020
  Time: 19:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Spring Rest Demo</title>
</head>
<body>
<h2>Spring Rest Demo</h2>
<hr>
<a href="${pageContext.request.contextPath}/test/hello">Hello</a>
<br><br>
<a href="${pageContext.request.contextPath}/api/students">List Students</a>
</body>
</html>
