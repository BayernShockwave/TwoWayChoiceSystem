package control;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ColAdminDao;
import dao.NoWantDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.UniAdminDao;
import user.ColAdmin;
import user.Student;
import user.Teacher;
import user.UniAdmin;
@WebServlet("/assign.action")
public class AssignServlet extends HttpServlet {
	private StudentDao dao=new StudentDao();
	private TeacherDao dao2=new TeacherDao();
	private ColAdminDao dao3=new ColAdminDao();
	private UniAdminDao dao4=new UniAdminDao();
	private NoWantDao dao5=new  NoWantDao();
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String type=request.getParameter("type");
		String college=(String)session.getAttribute("college");
		switch(type) {
		case "caassign":
			request.getSession().setAttribute("nlist",dao5.noWantStu(college));
			response.sendRedirect("ca_assign.jsp");
			break;
		case "caassigntea":
			String stuuserid=request.getParameter("stuuserid");
			String teauserid=request.getParameter("teauserid");
			List<Teacher> tlist=dao2.tnoTeachers(teauserid);
			int a=0;
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
				a=dao2.wanted1(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&twan2.equals("")) {
				a=dao2.wanted2(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&twan3.equals("")) {
				a=dao2.wanted3(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&twan4.equals("")) {
				a=dao2.wanted4(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&twan5.equals("")) {
				a=dao2.wanted5(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&twan6.equals("")) {
				a=dao2.wanted6(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&twan7.equals("")) {
				a=dao2.wanted7(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&!twan7.equals("")&&twan8.equals("")) {
				a=dao2.wanted8(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&!twan7.equals("")&&!twan8.equals("")&&twan9.equals("")) {
				a=dao2.wanted9(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&!twan7.equals("")&&!twan8.equals("")&&!twan9.equals("")&&twan10.equals("")) {
				a=dao2.wanted10(stuuserid,teauserid);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan1.equals("")&&!twan2.equals("")&&!twan3.equals("")&&!twan4.equals("")&&!twan5.equals("")&&!twan6.equals("")&&!twan7.equals("")&&!twan8.equals("")&&!twan9.equals("")&&!twan10.equals("")) {
				out.println("对不起,该导师已达人数上限!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
		case "uaassign":
			request.getSession().setAttribute("nlist",dao5.noWantStuWithoutCol());
			response.sendRedirect("ua_assign.jsp");
			break;
		case "uaassigntea":
			String stuuserid2=request.getParameter("stuuserid");
			String teauserid2=request.getParameter("teauserid");
			List<Teacher> tlist2=dao2.tnoTeachers(teauserid2);
			int a2=0;
			String twan12="";
			String twan22="";
			String twan32="";
			String twan42="";
			String twan52="";
			String twan62="";
			String twan72="";
			String twan82="";
			String twan92="";
			String twan102="";
			for(Teacher tea:tlist2) {
				twan12=tea.getWant1();
				twan22=tea.getWant2();
				twan32=tea.getWant3();
				twan42=tea.getWant4();
				twan52=tea.getWant5();
				twan62=tea.getWant6();
				twan72=tea.getWant7();
				twan82=tea.getWant8();
				twan92=tea.getWant9();
				twan102=tea.getWant10();
			}
			if(twan12.equals("")) {
				a2=dao2.wanted1(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=uaassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&twan22.equals("")) {
				a2=dao2.wanted2(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=uaassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&twan32.equals("")) {
				a2=dao2.wanted3(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=uaassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&!twan32.equals("")&&twan42.equals("")) {
				a=dao2.wanted4(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&!twan32.equals("")&&!twan42.equals("")&&twan52.equals("")) {
				a=dao2.wanted5(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&!twan32.equals("")&&!twan42.equals("")&&!twan52.equals("")&&twan62.equals("")) {
				a=dao2.wanted6(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&!twan32.equals("")&&!twan42.equals("")&&!twan52.equals("")&&!twan62.equals("")&&twan72.equals("")) {
				a=dao2.wanted7(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&!twan32.equals("")&&!twan42.equals("")&&!twan52.equals("")&&!twan62.equals("")&&!twan72.equals("")&&twan82.equals("")) {
				a=dao2.wanted8(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&!twan32.equals("")&&!twan42.equals("")&&!twan52.equals("")&&!twan62.equals("")&&!twan72.equals("")&&!twan82.equals("")&&twan92.equals("")) {
				a=dao2.wanted9(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&!twan32.equals("")&&!twan42.equals("")&&!twan52.equals("")&&!twan62.equals("")&&!twan72.equals("")&&!twan82.equals("")&&!twan92.equals("")&&twan102.equals("")) {
				a=dao2.wanted10(stuuserid2,teauserid2);
				out.println("指定成功!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=caassign\">返回</a><br/>");
			}
			else if(!twan12.equals("")&&!twan22.equals("")&&!twan32.equals("")&&!twan42.equals("")&&!twan52.equals("")&&!twan62.equals("")&&!twan72.equals("")&&!twan82.equals("")&&!twan92.equals("")&&!twan102.equals("")) {
				out.println("对不起,该导师已达人数上限!!!"+"<br/>");
				out.println("<a href=\"assign.action?type=uaassign\">返回</a><br/>");
			}
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}