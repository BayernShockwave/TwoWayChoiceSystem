package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import dButil.SQLHelper;
import user.Sysopen;
public class SysOpenDao {
	public List<Sysopen> sysopen() {
		List<Sysopen> olist=new ArrayList<Sysopen>();
		String sql="select * from sysopen";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				Sysopen so=new Sysopen();
				so.setBegin(rs.getDate(2));
				so.setEnd(rs.getDate(3));
				olist.add(so);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return olist;
	}
	public static int changeTime(String begin,String end) {
		String sql="update sysopen set sysbegin='"+begin+"',sysend='"+end+"'";
		return SQLHelper.executeUpdate(sql);
	}
}