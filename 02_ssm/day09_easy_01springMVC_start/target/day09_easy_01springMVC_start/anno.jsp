<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2020/7/21
  Time: 14:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <%--常用注解--%>
    <a href="anno/testRequestParam?name=hehe">RequestParam</a>

    <br>

    <form action="anno/testRequestBody" method="post">
        用户姓名：<input type="text" name="username"><br>
        用户年龄：<input type="text" name="age"><br>
        <input type="submit" value="提交">
    </form>

    <br>

    <a href="anno/testPathVariable/10">testRequestParam</a>

    <br>

    <a href="anno/testRequestHeader">testRequestParam</a>

    <br>

    <a href="anno/testCookieValue">testRequestParam</a>

    <br>

    <a href="anno/testModelAttribute">testRequestParam</a>

    <br>

</body>
</html>
