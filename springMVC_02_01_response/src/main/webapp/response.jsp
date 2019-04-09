<%--
  Created by IntelliJ IDEA.
  User: 1456466514
  Date: 2019/4/8
  Time: 8:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script>
        alert("init")
        $(function () {
            alert("jQuery导入成功")
            $("#btn").click(function () {
                // alert("success");
                $.ajax({
                    url:"user/testAjax",//请求地址
                    contentType:"application/json;charset=UTF-8",//请求参数类型，及编码形式
                    data:'{"username":"hehe","password":"123","age":"30"}',//请求参数
                    dataType:"json",//返回值类型
                    type:"post",//请求方式
                    success:function (data) {//请求成功后的回调函数
                        alert(data);
                        alert(data.username);
                        alert(data.password);
                        alert(data.age)
                    }
                })
            })
        })
    </script>
</head>
<body>
    <a href="user/testString">testString</a><br>
    <a href="user/testVoid">testVoid</a><br>
    <a href="user/testModelAndView">testModelAndView</a><br>
    <a href="user/testForwardOrRedirect">testForwardOrRedirect</a><br>
    <button id="btn">按钮</button>
</body>
</html>
