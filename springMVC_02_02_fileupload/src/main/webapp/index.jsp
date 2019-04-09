<%--
  Created by IntelliJ IDEA.
  User: 1456466514
  Date: 2019/4/9
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script src="js/jquery.js"></script>
    <script>
        $(function () {
            alert("jQuery导入成功")
            $("#a").click(function () {
                alert("success");
            })
        })
    </script>
</head>
<body>
    <a href="user/test">test</a>
    <br/>
    <a id="a">testAjax</a>
    <br/><!--传统方式文件上传-->
    <form action="user/fileupload1" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传">
    </form>
    <br/><!--springMVC文件上传-->
    <form action="user/fileupload2" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传">
    </form>
    <br/>
    <!--跨服务器springMVC文件上传-->
    <form action="user/fileupload3" method="post" enctype="multipart/form-data">
        选择文件：<input type="file" name="upload"/><br/>
        <input type="submit" value="上传">
    </form>
    <br/>
</body>
</html>
