<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>导师信息</title>
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
<h4 align="center">欢迎!!!您可以修改导师的信息!!!</h4>
<form action="check.action" method="post">
<input type="hidden" name="type" value="caupdtea">
导师号:<input type="text" id="userid" name="userid" value="${sessionScope.userid}" readonly/><br/>
导师密码:<input type="text" id="password" name="password" placeholder="请输入导师密码"/><br/>
导师姓名:<input type="text" id="name" name="name" placeholder="请输入导师姓名"/><br/>
导师学院:<input type="text" id="college" name="college" value="${sessionScope.college}" readonly/><br/>
导师专业:<input type="text" id="discipline" name="discipline" placeholder="请输入导师专业"/><br/>
导师上限:<select name="max">
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select><br/>
<input type="submit" id="add" name="add" value="确认"/>
<input type="reset" id="clean" name="clean" value="清空"/>
</form>
</div>
</div>
<div id="foot">网站版权声明:@20171403陈靖秋</div>
</div>
</body>
</html>