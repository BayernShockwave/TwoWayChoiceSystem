package control;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ColAdminDao;
import dao.StudentDao;
import dao.SysOpenDao;
import dao.TeacherDao;
import dao.UniAdminDao;
import user.Student;
import user.Sysopen;
import user.Teacher;
@WebServlet("/add_rs")
public class AddServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String addtype=request.getParameter("addtype");
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String name=request.getParameter("name");
		String college=request.getParameter("college");
		String discipline=request.getParameter("discipline");
		String max=request.getParameter("max");
		//out.println(addtype);
		//out.println(userid);
		//out.println(password);
		//out.println(name);
		//out.println(college);
		//out.println(discipline);
		//out.println(max);
		String choose="0";
		String left=max;
		StudentDao dao=new StudentDao();
		List<Student> slist=dao.allStudents();
		TeacherDao dao2=new TeacherDao();
		List<Teacher> tlist=dao2.allTeachers();
		SysOpenDao dao3=new SysOpenDao();
		String str="";
		int a=0;
		for(Student stu:slist) {
			if("caaddstu".equals(addtype)) {
				if(userid.equals(stu.getUserid())) {
					str="该学生号已存在!!!";
					break;
				}
				else {
					a=ColAdminDao.addcolstu(userid,password,name,college,discipline);
					str="添加成功!!!";
				}
			}
		}
		for(Teacher tea:tlist) {
			if("caaddtea".equals(addtype)) {
				if(userid.equals(tea.getUserid())) {
					str="该导师号已存在!!!";
					break;
				}
				else {
					a=ColAdminDao.addcoltea(userid,password,name,college,discipline,max,choose,left);
					str="添加成功!!!";
				}
			}
		}
		out.println(str+"<br/>");
		if("caaddstu".equals(addtype)) {
			out.println("<a href=\"ca_addstu.jsp?college="+college+"\">返回</a>");
		}
		if("caaddtea".equals(addtype)) {
			out.println("<a href=\"ca_addtea.jsp?college="+college+"\">返回</a>");
		}
		if("uaaddca".equals(addtype)) {
			a=UniAdminDao.addcoladm(userid,password,name,college);
			out.println("添加成功!!!");
			out.println("<a href=\"ua_addca.jsp\">返回</a>");
		}
		if("time".equals(addtype)) {
			String year=request.getParameter("year");
			String month=request.getParameter("month");
			String day=request.getParameter("day");
			String hour=request.getParameter("hour");
			String minute=request.getParameter("minute");
			String second=request.getParameter("second");
			String year2=request.getParameter("year2");
			String month2=request.getParameter("month2");
			String day2=request.getParameter("day2");
			String hour2=request.getParameter("hour2");
			String minute2=request.getParameter("minute2");
			String second2=request.getParameter("second2");
			String begin=year+"-"+month+"-"+day+" "+hour+":"+minute+":"+second;
			String end=year2+"-"+month2+"-"+day2+" "+hour2+":"+minute2+":"+second2;
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			Date sysbegin=null;
			Date sysend=null;
			try {
				sysbegin=sdf.parse(begin);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				sysend=sdf.parse(end);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dao3.changeTime(sdf.format(sysbegin),sdf.format(sysend));
			out.println("设置成功!!!");
			out.println("<a href=\"ua_frm.jsp\">返回</a>");
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}