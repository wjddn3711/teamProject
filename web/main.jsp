<%--
  Created by IntelliJ IDEA.
  User: jungwoo
  Date: 2021/12/18
  Time: 1:46 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="v" items="${datas}">
    <li>${v.product_name}</li>
</c:forEach>
</body>
</html>
