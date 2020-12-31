<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学院级管理员界面</title>
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
<%
request.setCharacterEncoding("utf-8");
String college=(String)session.getAttribute("college");
String str=(String)session.getAttribute("str");
%>
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
<li><%out.println("<a href=\"ca_addstu.jsp?college="+college+"\">添加学生</a><br/>");%></li>
<li><%out.println("<a href=\"ca_addtea.jsp?college="+college+"\">添加老师</a><br/>");%></li>
<li><%out.println("<a href=\"ca_delstu.jsp?college="+college+"\">删除学生</a><br/>");%></li>
<li><%out.println("<a href=\"ca_deltea.jsp?college="+college+"\">删除老师</a><br/>");%></li>
<li><%out.println("<a href=\"check.action?type=cacheckstu\">查看或修改学生信息</a><br/>");%></li>
<li><%out.println("<a href=\"check.action?type=cachecktea\">查看或修改老师信息</a><br/>");%></li>
<li><%out.println("<a href=\"assign.action?type=caassign\">指定导师</a><br/>");%></li>
<li><a href="login_frm.jsp">退出登录</a></li>
</ul>
</div>
<div id="mainmenu">
<%out.println(str);%><br>
<br>
请选择您的操作!!!<br>
<br>
具体操作如下:<br>
您可以在此添加您所在学院的学生或导师<br>
您可以在此删除您所在学院的学生或导师<br>
您可以在此修改您所在学院的学生或导师的信息<br>
您可以在此为未被导师选择的学生指定导师<br>
<br>
注意事项如下:<br>
无!!!
</div>
</div>
<div id="foot">网站版权声明:@20171403陈靖秋</div>
</div>
</body>
</html>