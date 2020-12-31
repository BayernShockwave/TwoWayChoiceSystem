<%@ page language="java" import="java.util.*,dao.TeacherDao,user.Teacher" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>个人信息</title>
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
float:left;width:1123px;height: 500px;font-size: 15px;font-weight: bolder;text-align: center;background-color: #00FFFF;
border-right:1px solid #000000;border-top:1px solid #000000;border-bottom:1px solid #000000;
}
#foot {
clear: both;width: 100%;height: 20px;background-color: #7FFFD4;text-align: center;color: #FFFFFF;
}
</style>
<%
request.setCharacterEncoding("utf-8");
String userid=(String)session.getAttribute("userid");
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
<h1 align="center">欢迎!!!您可查看您的个人信息!!!</h1>
<center>
<table width=50% border=1>
<%
TeacherDao dao=new TeacherDao();
List<Teacher> tlist=dao.tnoTeachers(userid);
out.println("<tr>"+"<td>"+"导师编号"+"</td>"+
		"<td>"+"导师姓名"+"</td>"+
		"<td>"+"个人密码"+"</td>"+
		"<td>"+"所属学院"+"</td>"+
		"<td>"+"所在专业"+"</td>"+
		"<td>"+"第一选择"+"</td>"+
		"<td>"+"第二选择"+"</td>"+
		"<td>"+"第三选择"+"</td>"+
		"<td>"+"第四选择"+"</td>"+
		"<td>"+"第五选择"+"</td>"+
		"<td>"+"第六选择"+"</td>"+
		"<td>"+"第七选择"+"</td>"+
		"<td>"+"第八选择"+"</td>"+
		"<td>"+"第九选择"+"</td>"+
		"<td>"+"第十选择"+"</td>"+
		"</tr>");
for(Teacher tea:tlist) {
	out.println("<tr>");
	out.println("<td>"+tea.getUserid()+"</td>");
	out.println("<td>"+tea.getName()+"</td>");
	out.println("<td>"+tea.getPassword()+"</td>");
	out.println("<td>"+tea.getCollege()+"</td>");
	out.println("<td>"+tea.getDiscipline()+"</td>");
	out.println("<td>"+tea.getWant1()+"</td>");
	out.println("<td>"+tea.getWant2()+"</td>");
	out.println("<td>"+tea.getWant3()+"</td>");
	out.println("<td>"+tea.getWant4()+"</td>");
	out.println("<td>"+tea.getWant5()+"</td>");
	out.println("<td>"+tea.getWant6()+"</td>");
	out.println("<td>"+tea.getWant7()+"</td>");
	out.println("<td>"+tea.getWant8()+"</td>");
	out.println("<td>"+tea.getWant9()+"</td>");
	out.println("<td>"+tea.getWant10()+"</td>");
	out.println("</tr>"); 
}
%>
</table>
</center>
</div>
</div>
<div id="foot">网站版权声明:@20171403陈靖秋</div>
</div>
</body>
</html>