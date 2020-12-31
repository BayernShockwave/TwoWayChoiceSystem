<%@ page language="java" import="java.util.*,dao.StudentDao,user.Student" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生信息</title>
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
float:left;width:1123px;height: 500px;font-size: 15px;font-weight: bolder;text-align: center;background-color: #00FFFF;
border-right:1px solid #000000;border-top:1px solid #000000;border-bottom:1px solid #000000;
}
#foot {
clear: both;width: 100%;height: 20px;background-color: #7FFFD4;text-align: center;color: #FFFFFF;
}
</style>
<%
request.setCharacterEncoding("utf-8");
String college=(String)session.getAttribute("college");
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
<h1 align="center">欢迎!!!您可以查看或修改全部学生的信息!!!</h1>
<table align="center" border="1" style="text-align":center;width:75%;">
<thead>
<tr>
<th width="16%">学生号</th>
<th width="16%">学生密码</th>
<th width="16%">学生姓名</th>
<th width="16%">学生所在学院</th>
<th width="16%">学生所属专业</th>
<th width="10%">删除</th>
<th width="10%">修改</th>
</tr>
</thead>
<tbody>
<%
List<Student> slist=(List<Student>)session.getAttribute("slist");
for(Student stu:slist) {
	out.println("<tr>");
	out.println("<td>"+stu.getUserid()+"</td>");
	out.println("<td>"+stu.getPassword()+"</td>");
	out.println("<td>"+stu.getName()+"</td>");
	out.println("<td>"+stu.getCollege()+"</td>");
	out.println("<td>"+stu.getDiscipline()+"</td>");
	out.println("<td>"+"<a href='check.action?userid="+stu.getUserid()+"&type=cadelstu'>删除</a>"+"</td>");
	out.println("<td>"+"<a href='check.action?userid="+stu.getUserid()+"&type=caeditstu'>修改</a>"+"</td>");
	out.println("</tr>");
	session.setAttribute("college",stu.getCollege());
}
%>
</tbody>
</table>
</div>
</div>
<div id="foot">网站版权声明:@20171403陈靖秋</div>
</div>
</body>
</html>