package control;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import dao.ColAdminDao;
import dao.LockedDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.UniAdminDao;
import user.ColAdmin;
import user.Student;
import user.Teacher;
import user.UniAdmin;
@WebServlet("/check.action")
public class CheckServlet extends HttpServlet {
	private StudentDao dao=new StudentDao();
	private TeacherDao dao2=new TeacherDao();
	private ColAdminDao dao3=new ColAdminDao();
	private UniAdminDao dao4=new UniAdminDao();
	private LockedDao dao5=new LockedDao();
	protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		String type=request.getParameter("type");
		String userid=request.getParameter("userid");
		String college=(String)session.getAttribute("college");
		//System.out.println(type+" "+userid+" "+college);
		switch(type) {
		case "uacheckwant":
			request.getSession().setAttribute("wlist",dao2.allTeachers());
			response.sendRedirect("ua_showwant.jsp");
			break;
		case "cacheckstu":
			request.getSession().setAttribute("slist",dao.colStudents(college));
			response.sendRedirect("ca_checkstu.jsp");
			break;
		case "cadelstu":
			dao3.delcolstu(userid);
			response.sendRedirect("check.action?type=cacheckstu");
			break;
		case "caeditstu":
			dao5.stuLocked(userid);
			List<Student> slist=dao.snoStudents(userid);
			for(Student stu:slist) {
				session.setAttribute("userid",userid);
			}
			response.sendRedirect("ca_editstu.jsp");
			break;
		case "caupdstu":
			String password=request.getParameter("password");
			String name=request.getParameter("name");
			String discipline=request.getParameter("discipline");
			//System.out.println(userid+" "+password+" "+name+" "+college+" "+discipline);
			dao3.updatecolstu(userid,password,name,discipline);
			dao5.stuLockedoff(userid);
			response.sendRedirect("check.action?type=cacheckstu");
			break;
		case "cachecktea":
			request.getSession().setAttribute("tlist",dao2.colTeachers(college));
			response.sendRedirect("ca_checktea.jsp");
			break;
		case "cadeltea":
			dao3.delcoltea(userid);
			response.sendRedirect("check.action?type=cachecktea");
			break;
		case "caedittea":
			dao5.teaLockedon(userid);
			List<Teacher> tlist=dao2.tnoTeachers(userid);
			for(Teacher tea:tlist) {
				session.setAttribute("userid",userid);
			}
			response.sendRedirect("ca_edittea.jsp");
			break;
		case "caupdtea":
			String password3=request.getParameter("password");
			String name3=request.getParameter("name");
			String discipline3=request.getParameter("discipline");
			String max=request.getParameter("max");
			List<Teacher> tlist3=dao2.tnoTeachers(userid);
			String oldmax="";
			String choose="";
			String left="";
			for(Teacher tea:tlist3) {
				oldmax=tea.getMax();
				choose=tea.getChoose();
				left=tea.getLeft();
			}
			int m=Integer.parseInt(max);
			int o=Integer.parseInt(oldmax);
			int c=Integer.parseInt(choose);
			int l=Integer.parseInt(left);
			if(m>=o) {
				int mo=m-o;
				l=l+m-o;
				left=Integer.toString(l);
				dao3.updatecoltea(userid,password3,name3,discipline3,max,choose,left);
				dao5.teaLockedoff(userid);
				response.sendRedirect("check.action?type=cachecktea");
			}
			else if(m<o) {
				if(l>0) {
					l=l-o+m;
					left=Integer.toString(l);
					dao3.updatecoltea(userid,password3,name3,discipline3,max,choose,left);
					dao5.teaLockedoff(userid);
					response.sendRedirect("check.action?type=cachecktea");
				}
				else if(l<=0) {
					dao5.teaLockedoff(userid);
					response.sendRedirect("ca_countwarning.jsp");
				}
			}
			break;
		case "uacheckstu":
			request.getSession().setAttribute("slist",dao.allStudents());
			response.sendRedirect("ua_checkstu.jsp");
			break;
		case "uadelstu":
			dao4.delstu(userid);
			response.sendRedirect("check.action?type=uacheckstu");
			break;
		case "uaeditstu":
			dao5.stuLockedon(userid);
			List<Student> slist2=dao.snoStudents(userid);
			for(Student stu:slist2) {
				session.setAttribute("userid",userid);
			}
			response.sendRedirect("ua_editstu.jsp");
			break;
		case "uaupdstu":
			String password2=request.getParameter("password");
			String name2=request.getParameter("name");
			String college2=request.getParameter("college");
			String discipline2=request.getParameter("discipline");
			//System.out.println(userid+" "+password2+" "+name2+" "+college2+" "+discipline2);
			dao4.updatestu(userid,password2,name2,college2,discipline2);
			dao5.stuLockedoff(userid);
			response.sendRedirect("check.action?type=uacheckstu");
			break;
		case "uachecktea":
			request.getSession().setAttribute("tlist",dao2.allTeachers());
			response.sendRedirect("ua_checktea.jsp");
			break;
		case "uadeltea":
			dao4.deltea(userid);
			response.sendRedirect("check.action?type=uachecktea");
			break;
		case "uaedittea":
			dao5.teaLockedon(userid);
			List<Teacher> tlist2=dao2.tnoTeachers(userid);
			for(Teacher tea:tlist2) {
				session.setAttribute("userid",userid);
			}
			response.sendRedirect("ua_edittea.jsp");
			break;
		case "uaupdtea":
			String password4=request.getParameter("password");
			String name4=request.getParameter("name");
			String college4=request.getParameter("college");
			String discipline4=request.getParameter("discipline");
			String max2=request.getParameter("max");
			List<Teacher> tlist4=dao2.tnoTeachers(userid);
			String oldmax2="";
			String choose2="";
			String left2="";
			for(Teacher tea:tlist4) {
				oldmax2=tea.getMax();
				choose2=tea.getChoose();
				left2=tea.getLeft();
			}
			int m2=Integer.parseInt(max2);
			int o2=Integer.parseInt(oldmax2);
			int c2=Integer.parseInt(choose2);
			int l2=Integer.parseInt(left2);
			if(m2>=o2) {
				int mo2=m2-o2;
				l2=l2+m2-o2;
				left2=Integer.toString(l2);
				dao4.updatetea(userid,password4,name4,college4,discipline4,max2,choose2,left2);
				dao5.teaLockedoff(userid);
				response.sendRedirect("check.action?type=uachecktea");
			}
			else if(m2<o2) {
				if(l2>0) {
					l=l2-o2+m2;
					left2=Integer.toString(l2);
					dao4.updatetea(userid,password4,name4,college4,discipline4,max2,choose2,left2);
					dao5.teaLockedoff(userid);
					response.sendRedirect("check.action?type=uachecktea");
				}
				else if(l2<=0) {
					dao5.teaLockedoff(userid);
					response.sendRedirect("ua_countwarning.jsp");
				}
			}
			break;
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}