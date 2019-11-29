<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<form action="/sys/user/updateUser" method="get">
    <%--隐藏域--%>
    <input type="text" name="id" value="${user.id}" style="display:none;">
    账号：<input type="text" name="account" value="${user.account}"><br><br>
    姓名：<input type="text" name="name" value="${user.name}"><br><br>
    年龄：<input type="text" name="age" value="${user.age}"><br><br>
    性别：<input type="radio" name="sex" value="1"
              <c:if test="${user.sex==1}">checked</c:if> >男
    <input type="radio" name="sex" value="0"
           <c:if test="${user.sex==0}">checked</c:if> >女<br><br>
    出生日期：<input type="text" name="birthday" value="${user.birthday}"><br><br>
    <input type="submit" value="修改">
</form>
</body>
</html>
