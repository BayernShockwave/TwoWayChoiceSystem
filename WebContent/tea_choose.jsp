<%@ page language="java" import="java.util.*,dao.StudentDao,user.Student,dao.TeacherDao,user.Teacher" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生选择</title>
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
<h1 align="center">欢迎!!!请选择心仪的学生!!!</h1>
<center>
<table width=50% border=1>
<%
TeacherDao dao=new TeacherDao();
List<Teacher> tlist=dao.tnoTeachers(userid);
out.println("<tr>"+"<td>"+"第一备选"+"</td>"+
		"<td>"+"第二备选"+"</td>"+
		"<td>"+"第三备选"+"</td>"+
		"<td>"+"第四备选"+"</td>"+
		"<td>"+"第五备选"+"</td>"+
		"<td>"+"第六备选"+"</td>"+
		"<td>"+"第七备选"+"</td>"+
		"<td>"+"第八备选"+"</td>"+
		"<td>"+"第九备选"+"</td>"+
		"<td>"+"第十备选"+"</td>"+"</tr>");
for(Teacher tea:tlist) {
	out.println("<tr>");
	out.println("<td>"+tea.getChoose1()+"<a href=tea_choose_rs.jsp?stuuserid1="+tea.getChoose1()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose2()+"<a href=tea_choose_rs.jsp?stuuserid2="+tea.getChoose2()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose3()+"<a href=tea_choose_rs.jsp?stuuserid3="+tea.getChoose3()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose4()+"<a href=tea_choose_rs.jsp?stuuserid4="+tea.getChoose4()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose5()+"<a href=tea_choose_rs.jsp?stuuserid5="+tea.getChoose5()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose6()+"<a href=tea_choose_rs.jsp?stuuserid6="+tea.getChoose6()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose7()+"<a href=tea_choose_rs.jsp?stuuserid7="+tea.getChoose7()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose8()+"<a href=tea_choose_rs.jsp?stuuserid8="+tea.getChoose8()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose9()+"<a href=tea_choose_rs.jsp?stuuserid9="+tea.getChoose9()+">选择</a>"+"</td>");
	out.println("<td>"+tea.getChoose10()+"<a href=tea_choose_rs.jsp?stuuserid10="+tea.getChoose10()+">选择</a>"+"</td>");
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