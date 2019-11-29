<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>用户列表</title>
</head>
<link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>
<div class="container">
    <div class="container-fluid">
        <a href="/addUser.jsp" class="btn btn-success">添加</a>
        <form action="/sys/user/allUser" method="get">
            <input type="text" name="account" value="${account}">
            <input type="submit" value="查询" class="btn btn-info">
        </form>

        <table class="table table-bordered">
            <tr>
                <td>序号</td>
                <td>账号</td>
                <td>用户名</td>
                <td>年龄</td>
                <td>性别</td>
                <td>出生日期</td>
                <td>创建时间</td>
                <td>操作</td>
            </tr>
            <c:forEach items="${userList}" var="user" varStatus="status">


                <tr>
                    <td>${status.index+1}</td>
                    <td>${user.account}</td>
                    <td>${user.name}</td>
                    <td>${user.age}</td>
                    <td>
                        <c:if test="${user.sex==1}">
                        男
                        </c:if>
                        <c:if test="${user.sex==0}">
                        女
                        </c:if>
                    <td>
                        <fmt:parseDate var="birthday" value="${user.birthday}" pattern="yyyy-MM-dd"></fmt:parseDate>
                        <fmt:formatDate value="${birthday}" pattern="yyyy年MM月dd日"></fmt:formatDate>
                    </td>
                    <td>
                        <fmt:parseDate var="createTime" value="${user.createTime}"
                                       pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
                        <fmt:formatDate value="${createTime}" pattern="yyyy-MM-dd HH:mm:ss"></fmt:formatDate>
                    </td>
                    <td>
                        <a href="/sys/user/deleteUser" class="btn btn-danger">删除</a>
                        <a href="/sys/user/toUpdateUser?id=${user.id}" class="btn btn-primary">修改</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <a href="/sys/user/allUser?account=${account}&page=1" class="btn btn-info">首页</a>
        <a href="/sys/user/allUser?account=${account}&page=${(userPageBean.page-1)<=0?1:(userPageBean.page-1)}" class="btn btn-info">上一页</a>
        总条数：${userPageBean.count}
        总页数：${userPageBean.totalPage}
        当前页：${userPageBean.page}
        每页条数：${userPageBean.pageSize}
        <a href="/sys/user/allUser?account=${account}&page=${(userPageBean.page+1)>userPageBean.totalPage?userPageBean.totalPage:(userPageBean.page+1)}" class="btn btn-info">下一页</a>
        <a href="/sys/user/allUser?account=${account}&page=${userPageBean.totalPage}" class="btn btn-info">尾页</a>
    </div>
</div>
</body>
</html>
