<%--
  Created by IntelliJ IDEA.
  User: HUAWEI
  Date: 2020/7/21
  Time: 18:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery-3.5.1.min.js"></script>
    <script>
        $(function () {
            $("#btn").click(function () {
                $.ajax({
                  url:"user/testAjax",
                  contentType: "application/json;charset=UTF-8",
                  data: '{"username":"he","password":"123","age":"22"}',
                  dataType: "json",
                  type: "post",
                  success: function (data) {
                    alert(data)
                    alert(data.username)
                    alert(data.password)
                    alert(data.age)
                  }
                })
            })
        })
    </script>
</head>
<body>

    <a href="user/testString">testString</a>

    <br>

    <a href="user/testVoid">testVoid</a>

    <br>

    <a href="user/testModelAndView">testModelAndView</a>

    <br>

    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a>

    <br>

    <button id="btn">发送ajax的请求</button>
</body>
</html>
