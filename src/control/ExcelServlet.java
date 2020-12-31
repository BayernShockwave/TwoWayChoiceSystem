package control;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import dao.UniAdminDao;
import user.Teacher;
@WebServlet("/excel_rs")
public class ExcelServlet extends HttpServlet {
	public void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		HttpSession session=request.getSession();
		PrintWriter out=response.getWriter();
		String type=request.getParameter("type");
		String path=request.getParameter("path");
		String filename=request.getParameter("filename");
		String filetype=request.getParameter("filetype");
		String addalltype=request.getParameter("addalltype");
		UniAdminDao dao=new UniAdminDao();
		List<Teacher> wlist=(List<Teacher>)session.getAttribute("wlist");
		switch(type) {
		case "uaaddall":
			if("xlsx".equals(filetype)) {
				if("ca".equals(addalltype)) {
					FileInputStream inputStreamca=new FileInputStream(path+filename);
					Workbook workbookaddca=new XSSFWorkbook(inputStreamca);
					Sheet sheetaddca=workbookaddca.getSheetAt(0);
					int physicalNumberOfRowsca=sheetaddca.getPhysicalNumberOfRows();
					for(int i=1;i<physicalNumberOfRowsca;i++) {
						Row row=sheetaddca.getRow(i);
						String userid=row.getCell(0).getStringCellValue();
						String password=row.getCell(1).getStringCellValue();
						String name=row.getCell(2).getStringCellValue();
						String college=row.getCell(3).getStringCellValue();
						dao.addcoladm(userid,password,name,college);
					}
				}
				if("student".equals(addalltype)) {
					FileInputStream inputStreamstu=new FileInputStream(path+filename);
					Workbook workbookaddstu=new XSSFWorkbook(inputStreamstu);
					Sheet sheetaddstu=workbookaddstu.getSheetAt(0);
					int physicalNumberOfRowsstu=sheetaddstu.getPhysicalNumberOfRows();
					for(int i=1;i<physicalNumberOfRowsstu;i++) {
						Row row=sheetaddstu.getRow(i);
						String userid=row.getCell(0).getStringCellValue();
						String password=row.getCell(1).getStringCellValue();
						String name=row.getCell(2).getStringCellValue();
						String college=row.getCell(3).getStringCellValue();
						String discipline=row.getCell(4).getStringCellValue();
						dao.addstu(userid,password,name,college,discipline);
					}
				}
				if("teacher".equals(addalltype)) {
					FileInputStream inputStreamtea=new FileInputStream(path+filename);
					Workbook workbookaddtea=new XSSFWorkbook(inputStreamtea);
					Sheet sheetaddtea=workbookaddtea.getSheetAt(0);
					int physicalNumberOfRowstea=sheetaddtea.getPhysicalNumberOfRows();
					for(int i=1;i<physicalNumberOfRowstea;i++) {
						Row row=sheetaddtea.getRow(i);
						String userid=row.getCell(0).getStringCellValue();
						String password=row.getCell(1).getStringCellValue();
						String name=row.getCell(2).getStringCellValue();
						String college=row.getCell(3).getStringCellValue();
						String discipline=row.getCell(4).getStringCellValue();
						String max=row.getCell(8).getStringCellValue();
						String choose=row.getCell(9).getStringCellValue();
						String left=row.getCell(10).getStringCellValue();
						dao.addtea(userid,password,name,college,discipline,max,choose,left);
					}
				}
				out.println("添加成功!!!");
				out.println("<a href=\"ua_addall.jsp\">返回</a>");
			}
			if("xls".equals(filetype)) {
				if("ca".equals(addalltype)) {
					FileInputStream inputStreamca=new FileInputStream(path+filename);
					Workbook workbookaddca=new HSSFWorkbook(inputStreamca);
					Sheet sheetaddca=workbookaddca.getSheetAt(0);
					int physicalNumberOfRowsca=sheetaddca.getPhysicalNumberOfRows();
					for(int i=1;i<physicalNumberOfRowsca;i++) {
						Row row=sheetaddca.getRow(i);
						String userid=row.getCell(0).getStringCellValue();
						String password=row.getCell(1).getStringCellValue();
						String name=row.getCell(2).getStringCellValue();
						String college=row.getCell(3).getStringCellValue();
						dao.addcoladm(userid,password,name,college);
					}
				}
				if("student".equals(addalltype)) {
					FileInputStream inputStreamstu=new FileInputStream(path+filename);
					Workbook workbookaddstu=new HSSFWorkbook(inputStreamstu);
					Sheet sheetaddstu=workbookaddstu.getSheetAt(0);
					int physicalNumberOfRowsstu=sheetaddstu.getPhysicalNumberOfRows();
					for(int i=1;i<physicalNumberOfRowsstu;i++) {
						Row row=sheetaddstu.getRow(i);
						String userid=row.getCell(0).getStringCellValue();
						String password=row.getCell(1).getStringCellValue();
						String name=row.getCell(2).getStringCellValue();
						String college=row.getCell(3).getStringCellValue();
						String discipline=row.getCell(4).getStringCellValue();
						dao.addstu(userid,password,name,college,discipline);
					}
				}
				if("teacher".equals(addalltype)) {
					FileInputStream inputStreamtea=new FileInputStream(path+filename);
					Workbook workbookaddtea=new HSSFWorkbook(inputStreamtea);
					Sheet sheetaddtea=workbookaddtea.getSheetAt(0);
					int physicalNumberOfRowstea=sheetaddtea.getPhysicalNumberOfRows();
					for(int i=1;i<physicalNumberOfRowstea;i++) {
						Row row=sheetaddtea.getRow(i);
						String userid=row.getCell(0).getStringCellValue();
						String password=row.getCell(1).getStringCellValue();
						String name=row.getCell(2).getStringCellValue();
						String college=row.getCell(3).getStringCellValue();
						String discipline=row.getCell(4).getStringCellValue();
						String max=row.getCell(8).getStringCellValue();
						String choose=row.getCell(9).getStringCellValue();
						String left=row.getCell(10).getStringCellValue();
						dao.addtea(userid,password,name,college,discipline,max,choose,left);
					}
				}
				out.println("添加成功!!!");
				out.println("<a href=\"ua_addall.jsp\">返回</a>");
			}
		case "uasaveshowwant":
			if("xlsx".equals(filetype)) {
				@SuppressWarnings("resource")
				Workbook workbook=new XSSFWorkbook();
				Sheet sheet=workbook.createSheet("最终志愿表");
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("导师号");
				row.createCell(1).setCellValue("导师姓名");
				row.createCell(2).setCellValue("导师所属学院");
				row.createCell(3).setCellValue("导师所在专业");
				row.createCell(4).setCellValue("选择学生一");
				row.createCell(5).setCellValue("选择学生二");
				row.createCell(6).setCellValue("选择学生三");
				row.createCell(7).setCellValue("选择学生四");
				row.createCell(8).setCellValue("选择学生五");
				row.createCell(9).setCellValue("选择学生六");
				row.createCell(10).setCellValue("选择学生七");
				row.createCell(11).setCellValue("选择学生八");
				row.createCell(12).setCellValue("选择学生九");
				row.createCell(13).setCellValue("选择学生十");
				for(int i=1;i<=wlist.size();i++) {
					Teacher tea=wlist.get(i-1);
					row=sheet.createRow(i);
					row.createCell(0).setCellValue(tea.getUserid());
					row.createCell(1).setCellValue(tea.getName());
					row.createCell(2).setCellValue(tea.getCollege());
					row.createCell(3).setCellValue(tea.getDiscipline());
					row.createCell(4).setCellValue(tea.getWant1());
					row.createCell(5).setCellValue(tea.getWant2());
					row.createCell(6).setCellValue(tea.getWant3());
					row.createCell(7).setCellValue(tea.getWant4());
					row.createCell(8).setCellValue(tea.getWant5());
					row.createCell(9).setCellValue(tea.getWant6());
					row.createCell(10).setCellValue(tea.getWant7());
					row.createCell(11).setCellValue(tea.getWant8());
					row.createCell(12).setCellValue(tea.getWant9());
					row.createCell(13).setCellValue(tea.getWant10());
				}
				FileOutputStream fileOutputStream=new FileOutputStream(path+filename);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
				out.println("保存成功!!!请在"+path+"中查看!!!");
				out.println("<a href=\"ua_showwant.jsp\">返回</a>");
			}
			if("xls".equals(filetype)) {
				@SuppressWarnings("resource")
				Workbook workbook=new HSSFWorkbook();
				Sheet sheet=workbook.createSheet("最终志愿表");
				Row row=sheet.createRow(0);
				row.createCell(0).setCellValue("导师号");
				row.createCell(1).setCellValue("导师姓名");
				row.createCell(2).setCellValue("导师所属学院");
				row.createCell(3).setCellValue("导师所在专业");
				row.createCell(4).setCellValue("选择学生一");
				row.createCell(5).setCellValue("选择学生二");
				row.createCell(6).setCellValue("选择学生三");
				row.createCell(7).setCellValue("选择学生四");
				row.createCell(8).setCellValue("选择学生五");
				row.createCell(9).setCellValue("选择学生六");
				row.createCell(10).setCellValue("选择学生七");
				row.createCell(11).setCellValue("选择学生八");
				row.createCell(12).setCellValue("选择学生九");
				row.createCell(13).setCellValue("选择学生十");
				for(int i=1;i<=wlist.size();i++) {
					Teacher tea=wlist.get(i-1);
					row=sheet.createRow(i);
					row.createCell(0).setCellValue(tea.getUserid());
					row.createCell(1).setCellValue(tea.getName());
					row.createCell(2).setCellValue(tea.getCollege());
					row.createCell(3).setCellValue(tea.getDiscipline());
					row.createCell(4).setCellValue(tea.getWant1());
					row.createCell(5).setCellValue(tea.getWant2());
					row.createCell(6).setCellValue(tea.getWant3());
					row.createCell(7).setCellValue(tea.getWant4());
					row.createCell(8).setCellValue(tea.getWant5());
					row.createCell(9).setCellValue(tea.getWant6());
					row.createCell(10).setCellValue(tea.getWant7());
					row.createCell(11).setCellValue(tea.getWant8());
					row.createCell(12).setCellValue(tea.getWant9());
					row.createCell(13).setCellValue(tea.getWant10());
				}
				FileOutputStream fileOutputStream=new FileOutputStream(path+filename);
				workbook.write(fileOutputStream);
				fileOutputStream.close();
				out.println("保存成功!!!请在"+path+"中查看!!!");
				out.println("<a href=\"ua_showwant.jsp\">返回</a>");
			}
		}
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException {
		doGet(request,response);
	}
}