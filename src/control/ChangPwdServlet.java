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
import dao.StudentDao;
import dao.TeacherDao;
import user.Student;
import user.Teacher;
@WebServlet("/change_pwd_rs")
public class ChangPwdServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String userid=(String)session.getAttribute("userid");
		String oldpassword=request.getParameter("oldpassword");
		String newpassword=request.getParameter("newpassword");
		String check_newpassword=request.getParameter("check_newpassword");
		StudentDao dao=new StudentDao();
		List<Student> slist=dao.snoStudents(userid);
		List<Student> slist_all=dao.allStudents();
		TeacherDao dao2=new TeacherDao();
		List<Teacher> tlist=dao2.tnoTeachers(userid);
		List<Teacher> tlist_all=dao2.allTeachers();
		for(Student stu_all:slist_all) {
			if(stu_all.getUserid().equals(userid)) {
				for(Student stu:slist) {
					if(oldpassword.equals(stu.getPassword())) {
						if(newpassword.equals(check_newpassword)) {
							int a=0;
							a=StudentDao.changePwd(newpassword,userid);
							out.println("修改成功!!!请重新登录!!!");
							out.println("<a href=\"login_frm.jsp\">返回登录界面</a>");
						}
						else {
							out.println("警告!!!两次密码不一致!!!");
							out.println("<a href=\"stu_change_pwd.jsp?userid="+userid+"\">返回</a>");
						}
					}
					else {
						out.println("警告!!!原密码不正确!!!");
						out.println("<a href=\"stu_change_pwd.jsp?userid="+userid+"\">返回</a>");
					}
				}
			}
		}
		for(Teacher tea_all:tlist_all) {
			if(tea_all.getUserid().equals(userid)) {
				for(Teacher tea:tlist) {
					if(oldpassword.equals(tea.getPassword())) {
						if(newpassword.equals(check_newpassword)) {
							int a=0;
							a=TeacherDao.changePwd(newpassword,userid);
							out.println("修改成功!!!请重新登录!!!");
							out.println("<a href=\"login_frm.jsp\">返回登录界面</a>");
						}
						else {
							out.println("警告!!!两次密码不一致!!!");
							out.println("<a href=\"stu_change_pwd.jsp?userid="+userid+"\">返回</a>");
						}
					}
					else {
						out.println("警告!!!原密码不正确!!!");
						out.println("<a href=\"stu_change_pwd.jsp?userid="+userid+"\">返回</a>");
					}
				}
			}
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}