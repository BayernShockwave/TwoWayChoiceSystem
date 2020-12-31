package control;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ColAdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.UniAdminDao;
import user.ColAdmin;
import user.Student;
import user.Teacher;
import user.UniAdmin;
//代替原来的login_rs_jsp和其中冗长的语句,使用Servlet作为控制层C连接视图层V和模型层M
//模型层M由JavaBean实现和数据库的交互,视图层V由jsp界面实现数据的采集和用户的请求
@WebServlet("/login_rs")//使用@WebServlet代替web.xml
public class ValidateServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");//指定浏览器及utf-8码表打开服务器发出的数据
		response.setCharacterEncoding("utf-8");//设置response使用的码表,控制response以utf-8码表向浏览器写入数据
		request.setCharacterEncoding("utf-8");//同理request
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		String identity=request.getParameter("identity");
		String now=(String)session.getAttribute("now");
		String b=(String)session.getAttribute("b");
		String e=(String)session.getAttribute("e");
		StudentDao dao=new StudentDao();
		List<Student> slist=dao.allStudents();
		TeacherDao dao2=new TeacherDao();
		List<Teacher> tlist=dao2.allTeachers();
		ColAdminDao dao3=new ColAdminDao();
		List<ColAdmin> clist=dao3.allColAdmin();
		UniAdminDao dao4=new UniAdminDao();
		List<UniAdmin> ulist=dao4.allUniAdmin();
		String str="";
		String name="";
		String college="";
		int nb=now.compareTo(b);//nb>0-->now>begin
		int ne=now.compareTo(e);//ne<0-->now<end
		if(nb>0&&ne<0) {
			if(userid!=null&&password!=null&&identity!=null) {
				if("student".equals(identity)) {
					for(Student stu:slist) {
						if(stu.getUserid().equals(userid)&&stu.getPassword().equals(password)) {
							name=stu.getName();
							college=stu.getCollege();
							str="登录成功!欢迎"+name+"!";
							break;
						}
						else {
							str="登录失败!";
						}
					}
				}
				if("teacher".equals(identity)) {
					for(Teacher tea:tlist) {
						if(tea.getUserid().equals(userid)&&tea.getPassword().equals(password)) {
							name=tea.getName();
							str="登录成功!欢迎"+name+"!";
							break;
						}
						else {
							str="登录失败!";
						}
					}
				}
				if("col_adm".equals(identity)) {
					for(ColAdmin ca:clist) {
						if(ca.getUserid().equals(userid)&&ca.getPassword().equals(password)) {
							name=ca.getName();
							college=ca.getCollege();
							str="登录成功!欢迎"+name+"!";
							break;
						}
						else {
							str="登录失败!";
						}
					}
				}
				if("uni_adm".equals(identity)) {
					for(UniAdmin ua:ulist) {
						if(ua.getUserid().equals(userid)&&ua.getPassword().equals(password)) {
							name=ua.getName();
							str="登录成功!欢迎"+name+"!";
							break;
						}
						else {
							str="登录失败!";
						}
					}
				}
			}
			else {
				str="警告!!!用户名或密码或身份不能为空!!!";
				out.println(str);
			}
			if(userid!=null&&password!=null&&identity!=null) {
				for(Student stu:slist) {
					if(stu.getUserid().equals(userid)&&stu.getPassword().equals(password)&&"student".equals(identity)) {
						response.sendRedirect("stu_frm.jsp");
						session.setAttribute("userid",userid);//把userid的值存在session里
						session.setAttribute("college",college);
						session.setAttribute("str",str);
						break;
					}
				}
				for(Teacher tea:tlist) {
					if(tea.getUserid().equals(userid)&&tea.getPassword().equals(password)&&"teacher".equals(identity)) {
						session.setAttribute("userid",userid);
						session.setAttribute("str",str);
						response.sendRedirect("tea_frm.jsp");
						break;
					}
				}
				for(ColAdmin ca:clist) {
					if(ca.getUserid().equals(userid)&&ca.getPassword().equals(password)&&"col_adm".equals(identity)) {
						session.setAttribute("college",college);
						session.setAttribute("str",str);
						response.sendRedirect("ca_frm.jsp");
						break;
					}
				}
				for(UniAdmin ua:ulist) {
					if(ua.getUserid().equals(userid)&&ua.getPassword().equals(password)&&"uni_adm".equals(identity)) {
						session.setAttribute("str",str);
						response.sendRedirect("ua_frm.jsp");
						break;
					}
				}
			}
			if(userid!=null&&password!=null&&identity!=null) {
				boolean exist=false;
				for(Student stu:slist) {
					if(stu.getUserid().equals(userid)&&stu.getPassword().equals(password)&&"student".equals(identity)) {
						exist=true;
					}
				}
				for(Teacher tea:tlist) {
					if(tea.getUserid().equals(userid)&&tea.getPassword().equals(password)&&"teacher".equals(identity)) {
						exist=true;
					}
				}
				for(ColAdmin ca:clist) {
					if(ca.getUserid().equals(userid)&&ca.getPassword().equals(password)&&"col_adm".equals(identity)) {
						exist=true;
					}
				}
				for(UniAdmin ua:ulist) {
					if(ua.getUserid().equals(userid)&&ua.getPassword().equals(password)&&"uni_adm".equals(identity)) {
						exist=true;
					}
				}
				if(!exist)
					out.println(str);
					out.println("<a href=\"login_frm.jsp\">返回</a>");
			}
			if(userid==null||password==null||identity==null) {
				out.println("<a href=\"login_frm.jsp\">返回</a>");
			}
		}
		else if(nb<=0||ne>=0) {
			if("uni_adm".equals(identity)) {
				for(UniAdmin ua:ulist) {
					if(ua.getUserid().equals(userid)&&ua.getPassword().equals(password)) {
						name=ua.getName();
						str="登录成功!欢迎"+name+"!";
						session.setAttribute("str",str);
						response.sendRedirect("ua_frm.jsp");
						break;
					}
					else {
						str="登录失败!";
						out.println(str);
					}
				}
				
			}
			else {
				str="请在系统开放时间内登录!!!";
				out.println(str);
				out.println("<a href=\"login_frm.jsp\">返回</a>");
			}
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}