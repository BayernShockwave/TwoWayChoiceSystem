<%@ page language="java" import="java.util.*,dao.StudentDao,user.Student,dao.TeacherDao,user.Teacher" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>修改志愿</title>
<h4 align="center">修改结果反馈!!!</h4>
<%
request.setCharacterEncoding("utf-8");
String newteauserid=request.getParameter("newuserid");
String oldteauserid=request.getParameter("olduserid");//由old修改为new
String stuuserid=(String)session.getAttribute("userid");
//out.println("new"+newteauserid);
//out.println("old"+oldteauserid);
//out.println("stu"+stuuserid);
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
TeacherDao dao2=new TeacherDao();
List<Teacher> tlist0=dao2.tnoTeachers(oldteauserid);
String tcho_old="";
String tleft_old="";
String tcho1_old="";
String tcho2_old="";
String tcho3_old="";
for(Teacher tea:tlist0) {
	tcho_old=tea.getChoose();
	tleft_old=tea.getLeft();
	tcho1_old=tea.getChoose1();
	tcho2_old=tea.getChoose2();
	tcho3_old=tea.getChoose3();
}
int t_old=Integer.parseInt(tleft_old);
List<Teacher> tlist=dao2.tnoTeachers(newteauserid);
String tcho_new="";
String tleft_new="";
String tcho1_new="";
String tcho2_new="";
String tcho3_new="";
for(Teacher tea:tlist) {
	tcho_new=tea.getChoose();
	tleft_new=tea.getLeft();
	tcho1_new=tea.getChoose1();
	tcho2_new=tea.getChoose2();
	tcho3_new=tea.getChoose3();
}
int t_new=Integer.parseInt(tleft_new);
if(t_new==0) {
	out.println("该导师已达到选人上限!!!");
	out.println("<a href=\"stu_choose1_edit.jsp?college="+col+"&teauserid="+oldteauserid+"\">返回</a>");
}
if(t_new>0) {
	boolean exist=false;
	if(!scho1.equals(newteauserid)&&!scho2.equals(newteauserid)&&!scho3.equals(newteauserid)&&t_new>0) {
		exist=true;
	}
	if(!exist) {
		out.println("您已选择该导师!!!不可重复选择!!!");
		out.println("<a href=\"stu_choose1_edit.jsp?college="+col+"&teauserid="+oldteauserid+"\">返回</a>");
	}
	if(exist) {
		int a=0;
		if(scho1.equals(oldteauserid)) {
			a=StudentDao.editTea1(newteauserid,stuuserid);
		}
		if(scho2.equals(oldteauserid)) {
			a=StudentDao.editTea2(newteauserid,stuuserid);
		}
		if(scho3.equals(oldteauserid)) {
			a=StudentDao.editTea3(newteauserid,stuuserid);
		}
		int m=0;
		int tchom=Integer.parseInt(tcho_old);
		tchom--;
		tcho_old=Integer.toString(tchom);
		m=TeacherDao.bechoosedcho(tcho_old,oldteauserid);
		int b=0;
		int tchob=Integer.parseInt(tcho_new);
		tchob++;
		tcho_new=Integer.toString(tchob);
		b=TeacherDao.bechoosedcho(tcho_new,newteauserid);
		int n=0;
		int tleftn=Integer.parseInt(tleft_old);
		tleftn++;
		tleft_old=Integer.toString(tleftn);
		n=TeacherDao.bechoosedleft(tleft_old,oldteauserid);
		int c=0;
		int tleftc=Integer.parseInt(tleft_new);
		tleftc--;
		tleft_new=Integer.toString(tleftc);
		c=TeacherDao.bechoosedleft(tleft_new,newteauserid);
		int d=0;
		if(tcho1_old.equals(stuuserid)) {
			d=TeacherDao.bechoosed1("",oldteauserid);
		}
		if(!tcho1_old.equals(stuuserid)&&tcho2_old.equals(stuuserid)) {
			d=TeacherDao.bechoosed2("",oldteauserid);
		}
		if(!tcho1_old.equals(stuuserid)&&!tcho2_old.equals(stuuserid)&&tcho3_old.equals(stuuserid)) {
			d=TeacherDao.bechoosed3("",oldteauserid);
		}
		int e=0;
		if(tcho1_new.equals("")) {
			e=TeacherDao.bechoosed1(stuuserid,newteauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose1_edit.jsp?college="+col+"&teauserid="+oldteauserid+"\">返回</a>");
		}
		else if(!tcho1_new.equals("")&&tcho2_new.equals("")) {
			e=TeacherDao.bechoosed2(stuuserid,newteauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose2_edit.jsp?college="+col+"&teauserid="+oldteauserid+"\">返回</a>");
		}
		else if(!tcho1_new.equals("")&&!tcho2_new.equals("")&&tcho3_new.equals("")) {
			e=TeacherDao.bechoosed3(stuuserid,newteauserid);
			out.println("您已成功选择该导师!!!请继续选择其他志愿!!!");
			out.println("<a href=\"stu_choose_inf.jsp\">查看分配情况</a>");
			out.println("<a href=\"stu_choose3_edit.jsp?college="+col+"&teauserid="+oldteauserid+"\">返回</a>");
		}
	}
}
%>
</head>
<body>
</body>
</html>