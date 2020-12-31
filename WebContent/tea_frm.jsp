<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>导师界面</title>
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
border-bottom:0px solid #000000;padding:0px;width: 100%;height: 100px;line-height: 100px;
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
String userid=(String)session.getAttribute("userid");
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
<li><%out.println("<a href=\"tea_tea_inf.jsp?userid="+userid+"\">查看个人信息</a><br/>");%></li>
<li><%out.println("<a href=\"tea_change_pwd.jsp?userid="+userid+"\">修改密码</a><br/>");%></li>
<li><%out.println("<a href=\"tea_stu_inf.jsp?userid="+userid+"\">查看学生信息</a><br/>");%></li>
<li><%out.println("<a href=\"tea_choose.jsp?userid="+userid+"\">选择学生</a><br/>");%></li>
<li><a href="login_frm.jsp">退出登录</a></li>
</ul>
</div>
<div id="mainmenu">
<%out.println(str);%><br>
<br>
请选择您的操作!!!<br>
<br>
具体操作如下:<br>
您可以在此查看个人的全部信息<br>
您可以在此修改您的个人密码<br>
您可以在此查看全部选择您的学生的信息<br>
您可以在此选择您心仪的学生<br>
<br>
注意事项如下:<br>
您可以不选满上限!!!
</div>
</div>
<div id="foot">网站版权声明:@20171403陈靖秋</div>
</div>
</body>
</html>