<%--
  Created by IntelliJ IDEA.
  User: administered
  Date: 2022/3/17
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%--
        c:if ：完成逻辑判断，替代Java if else
    --%>
    <c:if test="${status==1}">
        <h1>true</h1>
    </c:if>
    <c:if test="${status==0}">
        <h1>false</h1>
    </c:if>
</body>
</html>
