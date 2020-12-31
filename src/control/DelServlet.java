package control;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.ColAdminDao;
import dao.StudentDao;
import dao.TeacherDao;
import dao.UniAdminDao;
import user.Student;
import user.Teacher;
@WebServlet("/del_rs")
public class DelServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out=response.getWriter();
		String deltype=request.getParameter("deltype");
		String userid=request.getParameter("userid");
		String college=request.getParameter("college");
		StudentDao dao=new StudentDao();
		List<Student> slist=dao.allStudents();
		TeacherDao dao2=new TeacherDao();
		List<Teacher> tlist=dao2.allTeachers();
		String str="";
		int a=0;
		String stucollege="";
		String teacollege="";
		for(Student stu:slist) {
			if("cadelstu".equals(deltype)) {
				if(userid.equals(stu.getUserid())) {
					stucollege=stu.getCollege();
					if(college.equals(stucollege)) {
						a=ColAdminDao.delcolstu(userid);
						str="ɾ���ɹ�!!!";
						break;
					}
					if(!college.equals(stucollege)) {
						str="������ɾ������ѧԺ��ѧ��!!!";
						break;
					}
				}
				else {
					str="��ѧ���Ų�����!!!";
				}
			}
		}
		for(Teacher tea:tlist) {
			if("cadeltea".equals(deltype)) {
				if(userid.equals(tea.getUserid())) {
					teacollege=tea.getCollege();
					if(college.equals(teacollege)) {
						a=ColAdminDao.delcoltea(userid);
						str="ɾ���ɹ�!!!";
						break;
					}
					if(!college.equals(teacollege)) {
						str="������ɾ������ѧԺ�ĵ�ʦ!!!";
						break;
					}
				}
				else {
					str="�õ�ʦ�Ų�����!!!";
				}
			}
		}
		out.println(str+"<br/>");
		if("cadelstu".equals(deltype)) {
			out.println("<a href=\"ca_delstu.jsp?college="+college+"\">����</a>");
		}
		if("cadeltea".equals(deltype)) {
			out.println("<a href=\"ca_deltea.jsp?college="+college+"\">����</a>");
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}
