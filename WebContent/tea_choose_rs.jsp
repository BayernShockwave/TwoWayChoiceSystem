<%@ page language="java" import="java.util.*,dao.TeacherDao,user.Teacher" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>学生选择</title>
<h4 align="center">选择结果反馈!!!</h4>
<%
request.setCharacterEncoding("utf-8");
String stuuserid1=request.getParameter("stuuserid1");
String stuuserid2=request.getParameter("stuuserid2");
String stuuserid3=request.getParameter("stuuserid3");
String stuuserid4=request.getParameter("stuuserid4");
String stuuserid5=request.getParameter("stuuserid5");
String stuuserid6=request.getParameter("stuuserid6");
String stuuserid7=request.getParameter("stuuserid7");
String stuuserid8=request.getParameter("stuuserid8");
String stuuserid9=request.getParameter("stuuserid9");
String stuuserid10=request.getParameter("stuuserid10");
String teauserid=(String)session.getAttribute("userid");
//out.println(stuuserid1);
//out.println(stuuserid2);
//out.println(stuuserid3);
//out.println(teauserid);
TeacherDao dao=new TeacherDao();
List<Teacher> tlist=dao.tnoTeachers(teauserid);
int a=0;
String str="";
String twan1="";
String twan2="";
String twan3="";
String twan4="";
String twan5="";
String twan6="";
String twan7="";
String twan8="";
String twan9="";
String twan10="";
for(Teacher tea:tlist) {
	twan1=tea.getWant1();
	twan2=tea.getWant2();
	twan3=tea.getWant3();
	twan4=tea.getWant4();
	twan5=tea.getWant5();
	twan6=tea.getWant6();
	twan7=tea.getWant7();
	twan8=tea.getWant8();
	twan9=tea.getWant9();
	twan10=tea.getWant10();
}
if(twan1.equals("")) {
	if(stuuserid1!=null) {//既不能使用stuuserid1.equals(""),也不能使用"".equals(stuuserid)
		a=TeacherDao.wanted1(stuuserid1,teauserid);
		str="已成功设置第一选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted1(stuuserid2,teauserid);
		str="已成功设置第一选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted1(stuuserid3,teauserid);
		str="已成功设置第一选择!!!";
	}
}
else if(!twan1.equals("")&&twan2.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted2(stuuserid1,teauserid);
		str="已成功设置第二选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted2(stuuserid2,teauserid);
		str="已成功设置第二选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted2(stuuserid3,teauserid);
		str="已成功设置第二选择!!!";
	}
}
else if(!twan1.equals("")&&!twan2.equals("")&&twan3.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted3(stuuserid1,teauserid);
		str="已成功设置第三选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted3(stuuserid2,teauserid);
		str="已成功设置第三选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted3(stuuserid3,teauserid);
		str="已成功设置第三选择!!!";
	}
}
else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&twan4.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted4(stuuserid1,teauserid);
		str="已成功设置第四选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted4(stuuserid2,teauserid);
		str="已成功设置第四选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted4(stuuserid3,teauserid);
		str="已成功设置第四选择!!!";
	}
}
else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&twan5.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted5(stuuserid1,teauserid);
		str="已成功设置第五选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted5(stuuserid2,teauserid);
		str="已成功设置第五选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted5(stuuserid3,teauserid);
		str="已成功设置第五选择!!!";
	}
}
else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&twan6.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted6(stuuserid1,teauserid);
		str="已成功设置第六选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted6(stuuserid2,teauserid);
		str="已成功设置第六选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted6(stuuserid3,teauserid);
		str="已成功设置第六选择!!!";
	}
}
else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&twan7.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted7(stuuserid1,teauserid);
		str="已成功设置第七选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted7(stuuserid2,teauserid);
		str="已成功设置第七选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted7(stuuserid3,teauserid);
		str="已成功设置第七选择!!!";
	}
}
else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&!twan7.equals("")&&twan8.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted8(stuuserid1,teauserid);
		str="已成功设置第八选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted8(stuuserid2,teauserid);
		str="已成功设置第八选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted8(stuuserid3,teauserid);
		str="已成功设置第八选择!!!";
	}
}
else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&!twan7.equals("")&&!twan8.equals("")&&twan9.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted9(stuuserid1,teauserid);
		str="已成功设置第九选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted9(stuuserid2,teauserid);
		str="已成功设置第九选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted9(stuuserid3,teauserid);
		str="已成功设置第九选择!!!";
	}
}
else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&!twan7.equals("")&&!twan8.equals("")&&!twan9.equals("")&&twan10.equals("")) {
	if(stuuserid1!=null) {
		a=TeacherDao.wanted10(stuuserid1,teauserid);
		str="已成功设置第十选择!!!";
	}
	if(stuuserid2!=null) {
		a=TeacherDao.wanted10(stuuserid2,teauserid);
		str="已成功设置第十选择!!!";
	}
	if(stuuserid3!=null) {
		a=TeacherDao.wanted10(stuuserid3,teauserid);
		str="已成功设置第十选择!!!";
	}
}
out.println(str);
out.println("<a href=\"tea_choose.jsp?userid="+teauserid+"\">返回</a>");
%>
</head>
<body>
</body>
</html>