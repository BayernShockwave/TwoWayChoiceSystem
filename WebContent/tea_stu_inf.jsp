<%@ page language="java" import="java.util.*,dao.TeacherDao,user.Teacher,dao.StudentDao,user.Student" contentType="text/html; charset=utf-8"
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
<h1 align="center">欢迎!!!您可查看选择您全部的学生信息!!!</h1>
<center>
<table width=50% border=1>
<%
TeacherDao dao=new TeacherDao();
List<Teacher> tlist=dao.tnoTeachers(userid);
String tcho1="";
String tcho2="";
String tcho3="";
String tcho4="";
String tcho5="";
String tcho6="";
String tcho7="";
String tcho8="";
String tcho9="";
String tcho10="";
for(Teacher tea:tlist) {
	tcho1=tea.getChoose1();
	tcho2=tea.getChoose2();
	tcho3=tea.getChoose3();
	tcho4=tea.getChoose4();
	tcho5=tea.getChoose5();
	tcho6=tea.getChoose6();
	tcho7=tea.getChoose7();
	tcho8=tea.getChoose8();
	tcho9=tea.getChoose9();
	tcho10=tea.getChoose10();
}
StudentDao dao2=new StudentDao();
List<Student> slist1=dao2.snoStudents(tcho1);
List<Student> slist2=dao2.snoStudents(tcho2);
List<Student> slist3=dao2.snoStudents(tcho3);
List<Student> slist4=dao2.snoStudents(tcho4);
List<Student> slist5=dao2.snoStudents(tcho5);
List<Student> slist6=dao2.snoStudents(tcho6);
List<Student> slist7=dao2.snoStudents(tcho7);
List<Student> slist8=dao2.snoStudents(tcho8);
List<Student> slist9=dao2.snoStudents(tcho9);
List<Student> slist10=dao2.snoStudents(tcho10);
out.println("<tr>"+"<td>"+"学生编号"+"</td>"+
		"<td>"+"学生姓名"+"</td>"+
		"<td>"+"所属学院"+"</td>"+
		"<td>"+"报考专业"+"</td>"+"</tr>");
for(Student stu1:slist1) {
	out.println("<tr>");
	out.println("<td>"+stu1.getUserid()+"</td>");
	out.println("<td>"+stu1.getName()+"</td>");
	out.println("<td>"+stu1.getCollege()+"</td>");
	out.println("<td>"+stu1.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu2:slist2) {
	out.println("<tr>");
	out.println("<td>"+stu2.getUserid()+"</td>");
	out.println("<td>"+stu2.getName()+"</td>");
	out.println("<td>"+stu2.getCollege()+"</td>");
	out.println("<td>"+stu2.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu3:slist3) {
	out.println("<tr>");
	out.println("<td>"+stu3.getUserid()+"</td>");
	out.println("<td>"+stu3.getName()+"</td>");
	out.println("<td>"+stu3.getCollege()+"</td>");
	out.println("<td>"+stu3.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu4:slist4) {
	out.println("<tr>");
	out.println("<td>"+stu4.getUserid()+"</td>");
	out.println("<td>"+stu4.getName()+"</td>");
	out.println("<td>"+stu4.getCollege()+"</td>");
	out.println("<td>"+stu4.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu5:slist5) {
	out.println("<tr>");
	out.println("<td>"+stu5.getUserid()+"</td>");
	out.println("<td>"+stu5.getName()+"</td>");
	out.println("<td>"+stu5.getCollege()+"</td>");
	out.println("<td>"+stu5.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu6:slist6) {
	out.println("<tr>");
	out.println("<td>"+stu6.getUserid()+"</td>");
	out.println("<td>"+stu6.getName()+"</td>");
	out.println("<td>"+stu6.getCollege()+"</td>");
	out.println("<td>"+stu6.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu7:slist7) {
	out.println("<tr>");
	out.println("<td>"+stu7.getUserid()+"</td>");
	out.println("<td>"+stu7.getName()+"</td>");
	out.println("<td>"+stu7.getCollege()+"</td>");
	out.println("<td>"+stu7.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu8:slist8) {
	out.println("<tr>");
	out.println("<td>"+stu8.getUserid()+"</td>");
	out.println("<td>"+stu8.getName()+"</td>");
	out.println("<td>"+stu8.getCollege()+"</td>");
	out.println("<td>"+stu8.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu9:slist9) {
	out.println("<tr>");
	out.println("<td>"+stu9.getUserid()+"</td>");
	out.println("<td>"+stu9.getName()+"</td>");
	out.println("<td>"+stu9.getCollege()+"</td>");
	out.println("<td>"+stu9.getDiscipline()+"</td>");
	out.println("</tr>"); 
}
for(Student stu10:slist10) {
	out.println("<tr>");
	out.println("<td>"+stu10.getUserid()+"</td>");
	out.println("<td>"+stu10.getName()+"</td>");
	out.println("<td>"+stu10.getCollege()+"</td>");
	out.println("<td>"+stu10.getDiscipline()+"</td>");
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