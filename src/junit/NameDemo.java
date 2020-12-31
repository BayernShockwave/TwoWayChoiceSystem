package junit;

import static org.junit.Assert.*;
import java.sql.ResultSet;
import org.junit.Test;
import dButil.SQLHelper;
import user.Student;

public class NameDemo {
	@Test
	public void test() {
	//fail("尚未实现");
	Student stu = null;
	String sql = "select * from student_ft where Sno='20171403'"; 
	ResultSet rs = SQLHelper.executeQuery(sql);
	try {
	while(rs.next()) {
		stu = new Student();
		stu.setUserid(rs.getString(1));
		stu.setPassword(rs.getString(2));
		stu.setName(rs.getString(3));
		stu.setCollege(rs.getString(4));
		stu.setDiscipline(rs.getString(5));
	}
	SQLHelper.closeConnect();
	}
	catch(Exception ex) {
		ex.printStackTrace();
	}
	System.out.print(stu.getName());
	assertEquals("陈靖秋",stu.getName());
	}
}