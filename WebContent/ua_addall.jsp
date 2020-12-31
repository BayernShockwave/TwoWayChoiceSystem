<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>批量导入</title>
<style type="text/css">
body {
background-color: #FFFFFF;font-family: "楷体";
}
a {
color: #000000;text-decoration: none;
}
a:hover {
color: #FF0000;
}
#container {
width: 100%;
margin: 0 auto;
text-align:center;
}
#logo {
width: 100%;height: 150px;
}
#title {
width: 100%;height: 50px;font-size: 50px;font-weight: bolder;text-align: center;background-color: #7FFFD4;
}
#content {
width: 100%;
}
#leftmenu {
float:left;width: 25%;height: 500px;font-size: 25px;font-weight: bolder;background-color: #00FFFF;border:1px solid #000000;
}
#leftmenu ul {
list-style-type: none;margin:0px;padding:0px;
}
#leftmenu li {
border-bottom:0px solid #000000;padding:0px;width: 100%;height: 63px;line-height: 60px;
}
#mainmenu {
float:left;width:1123px;height: 500px;font-size: 25px;font-weight: bolder;text-align: center;background-color: #00FFFF;
border-right:1px solid #000000;border-top:1px solid #000000;border-bottom:1px solid #000000;
}
#foot {
clear: both;width: 100%;height: 20px;background-color: #7FFFD4;text-align: center;color: #FFFFFF;
}
</style>
</head>
<body>
<div id="container">
<div id="logo">
<img src="img/logo.JPG" />
</div>
<div id="title">研究生导师双向选择系统</div>
<div id="content">
<div id="leftmenu">
<ul>
<li><%out.println("<a href=\"check.action?type=uacheckstu\">查看或修改学生信息</a><br/>");%></li>
<li><%out.println("<a href=\"check.action?type=uachecktea\">查看或修改老师信息</a><br/>");%></li>
<li><%out.println("<a href=\"assign.action?type=uaassign\">指定导师</a><br/>");%></li>
<li><%out.println("<a href=\"ua_addall.jsp\">批量导入</a><br/>");%></li>
<li><%out.println("<a href=\"check.action?type=uacheckwant\">生成志愿结果</a><br/>");%></li>
<li><%out.println("<a href=\"ua_addca.jsp\">添加学院级管理员</a><br/>");%></li>
<li><%out.println("<a href=\"ua_time.jsp\">设置系统开放时间</a><br/>");%></li>
<li><a href="login_frm.jsp">退出登录</a></li>
</ul>
</div>
<div id="mainmenu">
<h4 align="center">欢迎!!!您可以批量添加!!!</h4>
<div style="width:100%;text-align:center">
<form action="excel_rs" method="post">
<input type="hidden" name="type" value="uaaddall">
文件路径:<input type="text" id="path" name="path" placeholder="请输入保存路径"/><br/>
文件名:<input type="text" id="filename" name="filename" placeholder="请输入保存文件名(请带上文件扩展名)"/><br/>
文件形式:<select name="filetype">
<option value="xls">xls</option>
<option value="xlsx">xlsx</option>
</select><br>
添加类型:<select name="addalltype">
<option value="student">学生</option>
<option value="teacher">导师</option>
<option value="ca">学院级管理员</option>
</select><br>
<input type="submit" id="confirm" name="confirm" value="确认"/>
</form>
</div>
</div>
</div>
<div id="foot">网站版权声明:@20171403陈靖秋</div>
</div>
</body>
</html>