package dao;
import dButil.SQLHelper;
import user.UniAdmin;
import java.sql.*;
import java.util.*;
public class UniAdminDao {
	public List<UniAdmin> allUniAdmin() {
		List<UniAdmin> ulist=new ArrayList<UniAdmin>();
		String sql="select * from uniadmin_ft";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				UniAdmin ua=new UniAdmin();
				ua.setUserid(rs.getString(1));
				ua.setPassword(rs.getString(2));
				ua.setName(rs.getString(3));
				ulist.add(ua);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return ulist;
	}
	public static int changePwd(String password,String userid) {
		String sql="update uniadmin_ft set Cpwd='"+password+"' where Cno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int addstu(String userid,String password,String name,String college,String discipline) {
		String sql="insert into student_ft values('"+userid+"','"+password+"','"+name+"','"+college+"','"+discipline+"','','','','off')";
		return SQLHelper.executeUpdate(sql);
	}
	public static int addtea(String userid,String password,String name,String college,String discipline,String max,String choose,String left) {
		String sql="insert into teacher_ft values('"+userid+"','"+password+"','"+name+"','"+college+"','"+discipline+"','','','','"+max+"','"+choose+"','"+left+"','','','','','','','','','','','','','','','','','','off')";
		return SQLHelper.executeUpdate(sql);
	}
	public static int delstu(String userid) {
		String sql="delete from student_ft where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int deltea(String userid) {
		String sql="delete from teacher_ft where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int updatestu(String userid,String password,String name,String college,String discipline) {
		String sql="update student_ft set Spwd='"+password+"',Sname='"+name+"',Scol='"+college+"',Sdis='"+discipline+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int updatetea(String userid,String password,String name,String college,String discipline,String max,String choose,String left) {
		String sql="update teacher_ft set Tpwd='"+password+"',Tname='"+name+"',Tdis='"+discipline+"',Tmax='"+max+"',Tcho='"+choose+"',Tleft='"+left+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int addcoladm(String userid,String password,String name,String college) {
		String sql="insert into coladmin_ft values('"+userid+"','"+password+"','"+name+"','"+college+"','off')";
		return SQLHelper.executeUpdate(sql);
	}
}