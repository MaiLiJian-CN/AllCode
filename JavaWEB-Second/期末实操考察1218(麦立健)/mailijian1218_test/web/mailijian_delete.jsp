<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<html>
<title>DELECT 操作</title>
</head>
<body>
<form action="/mailijian1218/delete">
    要删除的id：<input type="text" name="id">
    <button type="submit">提交</button>
</form>

<!--
JDBC 驱动名及数据库 URL
数据库的用户名与密码，需要根据自己的设置
useUnicode=true&characterEncoding=utf-8 防止中文乱码
 -->
<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver"
                   url="jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf-8&useSSL=false"
                   user="root"  password="123456"/>
<!--
插入数据
 -->
<%--<sql:update dataSource="${snapshot}" var="count">--%>
<%--    DELETE FROM users WHERE Id in(select id from ( select id from users order by id desc limit 1) as tmp)--%>
<%--&lt;%&ndash;    <sql:param value="${SiteId}" />&ndash;%&gt;--%>
<%--</sql:update>--%>
<sql:query dataSource="${snapshot}" var="result">
    SELECT * from users;
</sql:query>
<h1>JSP 后端开发 - 用户表 删除最后一行</h1>
<table border="1" width="100%" id="optionlist">
    <tr>
        <th>id</th>
        <th>name</th>
        <th>email</th>
        <th>birthday</th>
    </tr>
    <c:forEach var="row" items="${result.rows}">
        <tr>
            <td><c:out value="${row.id}"/></td>
            <td><c:out value="${row.name}"/></td>
            <td><c:out value="${row.email}"/></td>
            <td><c:out value="${row.birthday}"/></td>
        </tr>
    </c:forEach>
</table>

</body>
</html>
