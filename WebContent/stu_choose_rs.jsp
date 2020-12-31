<%@ page language="java" import="java.util.*,dao.StudentDao,user.Student,dao.TeacherDao,user.Teacher" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>导师选择</title>
<h4 align="center">选择结果反馈!!!</h4>
<%
request.setCharacterEncoding("utf-8");
String teauserid=request.getParameter("userid");//此userid是来自上层界面选择导师超链接传递的值
String stuuserid=(String)session.getAttribute("userid");//此userid是来自学生用户登录时存放在session中的值
String type=request.getParameter("type");
//out.println(teauserid);
//out.println(stuuserid);
//out.println(type);
StudentDao dao1=new StudentDao();
List<Student> slist=dao1.snoStudents(stuuserid);
String scho1="";
String scho2="";
String scho3="";
String col="";
for(Student stu:slist) {
	col=stu.getCollege();
	scho1=stu.getChoose1();
	scho2=stu.getChoose2();
	scho3=stu.getChoose3();
}
//out.println(scho1);
TeacherDao dao2=new TeacherDao();
List<Teacher> tlist=dao2.tnoTeachers(teauserid);
String tcho="";
String tleft="";
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
	tcho=tea.getChoose();
	tleft=tea.getLeft();
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
//out.println(tcho);
//out.println(tleft);
int t=Integer.parseInt(tleft);
if(t==0) {
	out.println("该导师已达到选人上限!!!");
	out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
}
else if(t>0&&!scho1.equals("")&&type.equals("first")) {
	out.println("您已拥有第一志愿!!!不可重复选择!!!");
	out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
}
else if(t>0&&!scho2.equals("")&&type.equals("second")) {
	out.println("您已拥有第二志愿!!!不可重复选择!!!");
	out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
}
else if(t>0&&!scho3.equals("")&&type.equals("third")) {
	out.println("您已拥有第三志愿!!!不可重复选择!!!");
	out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
}
else if(t>0&&scho1.equals("")||scho2.equals("")||scho3.equals("")) {
	boolean exist=false;
	if(!scho1.equals(teauserid)&&!scho2.equals(teauserid)&&!scho3.equals(teauserid)&&t>0) {//这里如果直接用scho1!=teauserid的话则下面的out.println语句执行不了
		exist=true;
	}
	if(!exist) {
		out.println("您已选择该导师!!!不可重复选择!!!");
		out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
	}
	if(exist) {
		int a=0;
		if(type.equals("first")) {
			a=StudentDao.chooseTea1(teauserid,stuuserid);
		}
		if(type.equals("second")) {
			a=StudentDao.chooseTea2(teauserid,stuuserid);
		}
		if(type.equals("third")) {
			a=StudentDao.chooseTea3(teauserid,stuuserid);
		}
		int b=0;
		int tcho_1=Integer.parseInt(tcho);
		tcho_1++;
		tcho=Integer.toString(tcho_1);
		b=TeacherDao.bechoosedcho(tcho,teauserid);
		int c=0;
		int tleft_1=Integer.parseInt(tleft);
		tleft_1--;
		tleft=Integer.toString(tleft_1);
		c=TeacherDao.bechoosedleft(tleft,teauserid);
		int d=0;
		if(tcho1.equals("")) {
			d=TeacherDao.bechoosed1(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&tcho2.equals("")) {
			d=TeacherDao.bechoosed2(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&!tcho2.equals("")&&tcho3.equals("")) {
			d=TeacherDao.bechoosed3(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&!tcho2.equals("")&&!tcho3.equals("")&&tcho4.equals("")) {
			d=TeacherDao.bechoosed4(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&!tcho2.equals("")&&!tcho3.equals("")&&!tcho4.equals("")&&tcho5.equals("")) {
			d=TeacherDao.bechoosed5(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&!tcho2.equals("")&&!tcho3.equals("")&&!tcho4.equals("")&&!tcho5.equals("")&&tcho6.equals("")) {
			d=TeacherDao.bechoosed6(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&!tcho2.equals("")&&!tcho3.equals("")&&!tcho4.equals("")&&!tcho5.equals("")&&!tcho6.equals("")&&tcho7.equals("")) {
			d=TeacherDao.bechoosed7(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&!tcho2.equals("")&&!tcho3.equals("")&&!tcho4.equals("")&&!tcho5.equals("")&&!tcho6.equals("")&&!tcho7.equals("")&&tcho8.equals("")) {
			d=TeacherDao.bechoosed8(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&!tcho2.equals("")&&!tcho3.equals("")&&!tcho4.equals("")&&!tcho5.equals("")&&!tcho6.equals("")&&!tcho7.equals("")&&!tcho8.equals("")&&tcho9.equals("")) {
			d=TeacherDao.bechoosed9(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
		else if(!tcho1.equals("")&&!tcho2.equals("")&&!tcho3.equals("")&&!tcho4.equals("")&&!tcho5.equals("")&&!tcho6.equals("")&&!tcho7.equals("")&&!tcho8.equals("")&&!tcho9.equals("")&&tcho10.equals("")) {
			d=TeacherDao.bechoosed10(stuuserid,teauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose.jsp?college="+col+"\">返回</a>");
		}
	}
}
//System.out.println(tcho);
//System.out.println(tleft);
%>
</head>
<body>
</body>
</html>