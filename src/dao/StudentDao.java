package dao;
import dButil.SQLHelper;
import user.Student;
import java.sql.*;
import java.util.*;
public class StudentDao {
	public List<Student> allStudents() {
		List<Student> slist=new ArrayList<Student>();
		String sql="select * from student_ft";
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
				slist.add(stu);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return slist;
    }
	public List<Student> snoStudents(String userid) {
		List<Student> slist=new ArrayList<Student>();
		String sql="select * from student_ft where Sno='"+userid+"'";
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
				slist.add(stu);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return slist;
    }
	public static int changePwd(String password,String userid) {
		String sql="update student_ft set Spwd='"+password+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int chooseTea1(String choose1,String userid) {
		String sql="update student_ft set Scho1='"+choose1+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int chooseTea2(String choose2,String userid) {
		String sql="update student_ft set Scho2='"+choose2+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int chooseTea3(String choose3,String userid) {
		String sql="update student_ft set Scho3='"+choose3+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int editTea1(String edit1,String userid) {
		String sql="update student_ft set Scho1='"+edit1+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int editTea2(String edit2,String userid) {
		String sql="update student_ft set Scho2='"+edit2+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int editTea3(String edit3,String userid) {
		String sql="update student_ft set Scho3='"+edit3+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public List<Student> colStudents(String college) {
		List<Student> slist=new ArrayList<Student>();
		String sql="select * from student_ft where Scol='"+college+"'";
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
				slist.add(stu);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return slist;
    }
}