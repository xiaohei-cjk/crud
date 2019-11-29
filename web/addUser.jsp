<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加用户</title>
</head>
<link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.css">
<script src="/static/js/jquery-3.3.1.js"></script>
<script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<body>
<div class="container">
    <div class="container-fluid">
        <form action="/sys/user/addUser" method="post" class="">
            <label>账号：</label><input type="text" name="account" value=""><br><br>
            <label>姓名：</label><input type="text" name="name" value=""><br><br>
            <label>年龄：</label><input type="text" name="age" value=""><br><br>
            <label>性别：</label><input type="radio" name="sex" value="1">男
            <input type="radio" name="sex" value="0">女<br><br>
            <label>出生日期：</label><input type="text" name="birthday" value=""><br><br>
            <input type="submit" value="保存">
        </form>
    </div>
</div>
</body>
</html>
