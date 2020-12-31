<%@ page language="java" import="java.util.*,dao.SysOpenDao,user.Sysopen,java.util.Date,java.text.SimpleDateFormat" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>登录界面</title>
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
#mainmenu {
float:left;width:1123px;height: 500px;font-size: 25px;font-weight: bolder;text-align: center;background-color: #00FFFF;
border-right:1px solid #000000;border-top:1px solid #000000;border-bottom:1px solid #000000;
}
#foot {
clear: both;width: 100%;height: 20px;background-color: #7FFFD4;text-align: center;color: #FFFFFF;
}
</style>
	</head>
	<%
	SysOpenDao dao=new SysOpenDao();
	List<Sysopen> olist=dao.sysopen();
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	session.setAttribute("now",sdf.format(new Date()));
	for(Sysopen so:olist) {
		Date begin=so.getBegin();
		Date end=so.getEnd();
		session.setAttribute("b",sdf.format(begin));
		session.setAttribute("e",sdf.format(end));
	}
	%>
	<body>
	<div id="container">
	<div id="logo">
	<img src="img/logo.JPG" />
	</div>
	<div id="title">研究生导师双向选择系统</div>
	<div id="content">
	<div id="leftmenu">
	 欢迎使用本系统!<br/>
	<br/>
	<br/>
	<br/>
	请在右侧选择身份登录--><br/>
	<br/>
	<br/>
	<br/>
	请在系统开放时间内登录!<br/>
	<br/>
	<br/>
	<br/>
	系统开放时间:<br/>
	<%=session.getAttribute("b")%><br/>
	<%=session.getAttribute("e")%>
	</div>
	<div id="mainmenu">
	            <form action="login_rs" method="post">
				<h4 align="center">欢迎!!!请选择身份并登录!!!</h4>
				<h4 align="center">身份选择:<input type="radio" name="identity" value="student"/>学生
				        <input type="radio" name="identity" value="teacher"/>导师
				        <input type="radio" name="identity" value="col_adm"/>学院级管理员
				        <input type="radio" name="identity" value="uni_adm"/>校级管理员<br/></h4>
				<h4 align="center">用户名:<input type="text" id="userid" name="userid" placeholder="请输入用户名"/><br/></h4>
				<h4 align="center">密码:<input type="password" id="password" name="password" placeholder="请输入密码"/><br/></h4>
				<h4 align="center"><input type="submit" id="login" name="login" value="登录"/>
				<input type="reset" id="clean" name="clean" value="清空"/></h4>
				</form>
	</div>
	</div>
	<div id="foot">网站版权声明:@20171403陈靖秋</div>
	</div>
	</body>
</html>