package dao;
import dButil.SQLHelper;
import user.NoWant;
import user.ColAdmin;
import java.sql.*;
import java.util.*;
public class ColAdminDao {
	public List<ColAdmin> allColAdmin() {
		List<ColAdmin> clist=new ArrayList<ColAdmin>();
		String sql="select * from coladmin_ft";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				ColAdmin ca=new ColAdmin();
				ca.setUserid(rs.getString(1));
				ca.setPassword(rs.getString(2));
				ca.setName(rs.getString(3));
				ca.setCollege(rs.getString(4));
				ca.setLocked(rs.getString(5));
				clist.add(ca);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return clist;
	}
	public List<ColAdmin> colColAdmin(String col) {
		List<ColAdmin> clist=new ArrayList<ColAdmin>();
		String sql="select * from coladmin_ft where Ccol='"+col+"'";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				ColAdmin ca=new ColAdmin();
				ca.setUserid(rs.getString(1));
				ca.setPassword(rs.getString(2));
				ca.setName(rs.getString(3));
				ca.setCollege(rs.getString(4));
				ca.setLocked(rs.getString(5));
				clist.add(ca);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return clist;
	}
	public static int changePwd(String password,String userid) {
		String sql="update coladmin_ft set Cpwd='"+password+"' where Cno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int addcolstu(String userid,String password,String name,String college,String discipline) {
		String sql="insert into student_ft values('"+userid+"','"+password+"','"+name+"','"+college+"','"+discipline+"','','','','off','')";
		return SQLHelper.executeUpdate(sql);
	}
	public static int addcoltea(String userid,String password,String name,String college,String discipline,String max,String choose,String left) {
		String sql="insert into teacher_ft values('"+userid+"','"+password+"','"+name+"','"+college+"','"+discipline+"','','','','"+max+"','"+choose+"','"+left+"','','','','','','','','','','','','','','','','','','off','')";
		return SQLHelper.executeUpdate(sql);
	}
	public static int delcolstu(String userid) {
		String sql="delete from student_ft where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int delcoltea(String userid) {
		String sql="delete from teacher_ft where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int updatecolstu(String userid,String password,String name,String discipline) {
		String sql="update student_ft set Spwd='"+password+"',Sname='"+name+"',Sdis='"+discipline+"' where Sno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
	public static int updatecoltea(String userid,String password,String name,String discipline,String max,String choose,String left) {
		String sql="update teacher_ft set Tpwd='"+password+"',Tname='"+name+"',Tdis='"+discipline+"',Tmax='"+max+"',Tcho='"+choose+"',Tleft='"+left+"' where Tno='"+userid+"'";
		return SQLHelper.executeUpdate(sql);
	}
}