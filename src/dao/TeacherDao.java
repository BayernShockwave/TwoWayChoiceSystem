package dao;
import dButil.SQLHelper;
import user.Student;
import user.Teacher;
import java.sql.*;
import java.util.*;
public class TeacherDao {
	public List<Teacher> allTeachers() {
		List<Teacher> tlist=new ArrayList<Teacher>();
		String sql="select * from teacher_ft";
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
				tlist.add(tea);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return tlist;
    }
	public List<Teacher> colTeachers(String college) {
		List<Teacher> tlist=new ArrayList<Teacher>();
		String sql="select * from teacher_ft where Tcol='"+college+"'";
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
				tlist.add(tea);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return tlist;
    }
	public List<Teacher> tnoTeachers(String tno) {
		List<Teacher> tlist=new ArrayList<Teacher>();
		String sql="select * from teacher_ft where Tno='"+tno+"'";
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
				tlist.add(tea);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return tlist;
    }
	public static int bechoosedcho(String tchoose,String userid) {
		String sql="update teacher_ft set Tcho='"+tchoose+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosedleft(String tleft,String userid) {
		String sql="update teacher_ft set Tleft='"+tleft+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed1(String tcho1,String userid) {
		String sql="update teacher_ft set Tcho1='"+tcho1+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed2(String tcho2,String userid) {
		String sql="update teacher_ft set Tcho2='"+tcho2+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed3(String tcho3,String userid) {
		String sql="update teacher_ft set Tcho3='"+tcho3+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed4(String tcho4,String userid) {
		String sql="update teacher_ft set Tcho4='"+tcho4+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed5(String tcho5,String userid) {
		String sql="update teacher_ft set Tcho5='"+tcho5+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed6(String tcho6,String userid) {
		String sql="update teacher_ft set Tcho6='"+tcho6+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed7(String tcho7,String userid) {
		String sql="update teacher_ft set Tcho7='"+tcho7+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed8(String tcho8,String userid) {
		String sql="update teacher_ft set Tcho8='"+tcho8+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed9(String tcho9,String userid) {
		String sql="update teacher_ft set Tcho9='"+tcho9+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int bechoosed10(String tcho10,String userid) {
		String sql="update teacher_ft set Tcho10='"+tcho10+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int changePwd(String password,String userid) {
		String sql="update teacher_ft set Tpwd='"+password+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted1(String twan1,String userid) {
		String sql="update teacher_ft set Twan1='"+twan1+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted2(String twan2,String userid) {
		String sql="update teacher_ft set Twan2='"+twan2+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted3(String twan3,String userid) {
		String sql="update teacher_ft set Twan3='"+twan3+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted4(String twan4,String userid) {
		String sql="update teacher_ft set Twan4='"+twan4+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted5(String twan5,String userid) {
		String sql="update teacher_ft set Twan5='"+twan5+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted6(String twan6,String userid) {
		String sql="update teacher_ft set Twan6='"+twan6+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted7(String twan7,String userid) {
		String sql="update teacher_ft set Twan7='"+twan7+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted8(String twan8,String userid) {
		String sql="update teacher_ft set Twan8='"+twan8+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted9(String twan9,String userid) {
		String sql="update teacher_ft set Twan9='"+twan9+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int wanted10(String twan10,String userid) {
		String sql="update teacher_ft set Twan10='"+twan10+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
}