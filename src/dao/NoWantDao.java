package dao;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import dButil.SQLHelper;
import user.NoWant;
public class NoWantDao {
	public List<NoWant> noWantStu(String college) {
		List<NoWant> nlist=new ArrayList<NoWant>();
		String sql="select Sno,Sname,Scol,Sdis,Tno,Tname from student_ft,teacher_ft where student_ft.Sno not in(select Sno from student_ft ,(select Twan1,Twan2,Twan3 from teacher_ft where Twan1<>'' or Twan2<>'' or Twan3<>'')Want where student_ft.Sno=Want.Twan1 or student_ft.Sno=Want.Twan2 or student_ft.Sno=Want.Twan3) and Scol='"+college+"' and Tcol='"+college+"'";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				NoWant nw=new NoWant();
				nw.setStuuserid(rs.getString(1));
				nw.setStuname(rs.getString(2));
				nw.setCollege(rs.getString(3));
				nw.setDiscipline(rs.getString(4));
				nw.setTeauserid(rs.getString(5));
				nw.setTeaname(rs.getString(6));
				nlist.add(nw);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return nlist;
	}
	public List<NoWant> noWantStuWithoutCol() {
		List<NoWant> nlist=new ArrayList<NoWant>();
		String sql="select Sno,Sname,Scol,Sdis,Tno,Tname from student_ft,teacher_ft where student_ft.Sno not in(select Sno from student_ft ,(select Twan1,Twan2,Twan3 from teacher_ft where Twan1<>'' or Twan2<>'' or Twan3<>'')Want where student_ft.Sno=Want.Twan1 or student_ft.Sno=Want.Twan2 or student_ft.Sno=Want.Twan3) and Scol=Tcol;";
		ResultSet rs=SQLHelper.executeQuery(sql);
		try {
			while(rs.next()) {
				NoWant nw=new NoWant();
				nw.setStuuserid(rs.getString(1));
				nw.setStuname(rs.getString(2));
				nw.setCollege(rs.getString(3));
				nw.setDiscipline(rs.getString(4));
				nw.setTeauserid(rs.getString(5));
				nw.setTeaname(rs.getString(6));
				nlist.add(nw);
			}
			SQLHelper.closeConnect();
		}
		catch(Exception ex) {
			ex.printStackTrace();
		}
		return nlist;
	}
}