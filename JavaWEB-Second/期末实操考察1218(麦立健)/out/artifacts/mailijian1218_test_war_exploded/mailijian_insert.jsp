<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<%@ page import="javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<html>
<title>Insert 操作</title>
</head>
<body>
<table>
    <form action="/mailijian1218/insert">
        <tr><td><button type="submit">添加</button></td></tr>
    </form>
</table>
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
<%--<sql:update dataSource="${snapshot}" var="result">--%>
<%--    INSERT INTO users VALUES (null, 'lis', '123', 'liss@qq.com', '1990-09-09');--%>
<%--</sql:update>--%>
<sql:query dataSource="${snapshot}" var="result">
    SELECT * from users;
</sql:query>
<h1>JSP 后端开发 - 用户表</h1>
<table border="1" width="100%">
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
