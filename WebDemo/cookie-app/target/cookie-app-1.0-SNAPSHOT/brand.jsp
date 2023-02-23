<%--
  Created by IntelliJ IDEA.
  User: administered
  Date: 2022/3/17
  Time: 15:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<h1>${user.username}，欢迎你</h1>
<input type="button" value="新增" id="add"><br>
<hr>
<table border="1" cellspacing="0" width="800">
    <tr>
        <th>序号</th>
        <th>品牌名称</th>
        <th>企业名称</th>
        <th>排序</th>
        <th>品牌介绍</th>
        <th>状态</th>
        <th>操作</th>

    </tr>


    <c:forEach items="${brands}" var="brand" varStatus="status">
        <tr align="center">
<%--                <td>${brand.id}</td>--%>
            <td>${status.count}</td>
            <td>${brand.brandName}</td>
            <td>${brand.companyName}</td>
            <td>${brand.ordered}</td>
            <td>${brand.description}</td>
            <c:if test="${brand.status == 1}">
                <td>启用</td>
            </c:if>
            <c:if test="${brand.status != 1}">
                <td>禁用</td>
            </c:if>

            <td><a href="/jsp-app/selectByIdServlet?id=${brand.id}">修改&nbsp;</a>
                <a href="/jsp-app/deleteServlet?id=${brand.id}">删除</a></td>
        </tr>

    </c:forEach>


</table>
<script>
    document.getElementById("add").onclick=function () {
        location.href="/jsp-app/addBrand.jsp";
    }
</script>
</body>
</html>
