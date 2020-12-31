package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dButil.SQLHelper;
import user.ColAdmin;
import user.Student;
import user.Teacher;
public class LockedDao {
	public List<Student> stuLocked(String userid) {
		List<Student> sllist=new ArrayList<Student>();
		String sql="select Locked from student_ft where Sno='"+userid+"'";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Student stu=new Student();
				stu.setUserid(rs.getString(1));
				stu.setPassword(rs.getString(2));
				stu.setName(rs.getString(3));
				stu.setCollege(rs.getString(4));
				stu.setDiscipline(rs.getString(5));
				stu.setChoose1(rs.getString(6));
				stu.setChoose2(rs.getString(7));
				stu.setChoose3(rs.getString(8));
				stu.setLocked(rs.getString(9));
				sllist.add(stu);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return sllist;
	}
	public List<Teacher> teaLocked(String userid) {
		List<Teacher> tllist=new ArrayList<Teacher>();
		String sql="select Locked from teacher_ft where Tno='"+userid+"'";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Teacher tea=new Teacher();
				tea.setUserid(rs.getString(1));
				tea.setPassword(rs.getString(2));
				tea.setName(rs.getString(3));
				tea.setCollege(rs.getString(4));
				tea.setDiscipline(rs.getString(5));
				tea.setChoose1(rs.getString(6));
				tea.setChoose2(rs.getString(7));
				tea.setChoose3(rs.getString(8));
				tea.setMax(rs.getString(9));
				tea.setChoose(rs.getString(10));
				tea.setLeft(rs.getString(11));
				tea.setWant1(rs.getString(12));
				tea.setWant2(rs.getString(13));
				tea.setWant3(rs.getString(14));
				tea.setChoose4(rs.getString(15));
				tea.setChoose5(rs.getString(16));
				tea.setChoose6(rs.getString(17));
				tea.setChoose7(rs.getString(18));
				tea.setChoose8(rs.getString(19));
				tea.setChoose9(rs.getString(20));
				tea.setChoose10(rs.getString(21));
				tea.setWant4(rs.getString(22));
				tea.setWant5(rs.getString(23));
				tea.setWant6(rs.getString(24));
				tea.setWant7(rs.getString(25));
				tea.setWant8(rs.getString(26));
				tea.setWant9(rs.getString(27));
				tea.setWant10(rs.getString(28));
				tea.setLocked(rs.getString(29));
				tllist.add(tea);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return tllist;
	}
	public List<ColAdmin> caLocked(String userid) {
		List<ColAdmin> cllist=new ArrayList<ColAdmin>();
		String sql="select Locked from coladmin_ft where Cno='"+userid+"'";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				ColAdmin ca=new ColAdmin();
				ca.setUserid(rs.getString(1));
				ca.setPassword(rs.getString(2));
				ca.setName(rs.getString(3));
				ca.setCollege(rs.getString(4));
				ca.setLocked(rs.getString(5));
				cllist.add(ca);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return cllist;
	}
	public static int stuLockedon(String userid) {
		String sql="update student_ft set Locked='on' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int stuLockedoff(String userid) {
		String sql="update student_ft set Locked='off' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int teaLockedon(String userid) {
		String sql="update teacher_ft set Locked='on' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int teaLockedoff(String userid) {
		String sql="update teacher_ft set Locked='off' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int caLockedon(String userid) {
		String sql="update coladmin_ft set Locked='on' where Cno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int caLockedoff(String userid) {
		String sql="update coladmin_ft set Locked='off' where Cno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
}