package com.DMS.ghb.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.NumberFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.DMS.ghb.entity.EntityForExport;

/**
 * 读取Excel
 * 
 */
public class PoiTest {
	private Logger logger = LoggerFactory.getLogger(PoiTest.class);
	private Workbook wb;
	private Sheet sheet;
	private Row row;

	public PoiTest(String filepath, InputStream is) {
		if (filepath == null) {
			return;
		}
		String ext = filepath.substring(filepath.lastIndexOf("."));
		try {
			if (".xls".equals(ext)) {
				wb = new HSSFWorkbook(is);
			} else if (".xlsx".equals(ext)) {
				wb = new XSSFWorkbook(is);
			} else {
				wb = null;
			}
		} catch (FileNotFoundException e) {
			logger.error("FileNotFoundException", e);
		} catch (IOException e) {
			logger.error("IOException", e);
		}
	}

	/**
	 * 读取Excel表格表头的内容
	 * 
	 * @param InputStream
	 * @return String 表头内容的数组
	 */
	public String[] readExcelTitle() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// 标题总列数
		int colNum = row.getPhysicalNumberOfCells();
		System.out.println("colNum:" + colNum);
		String[] title = new String[colNum];
		for (int i = 0; i < colNum; i++) {
			// title[i] = getStringCellValue(row.getCell((short) i));
			title[i] = row.getCell(i).getCellFormula();
		}
		return title;
	}

	/**
	 * 读取Excel数据内容
	 * 
	 * @param InputStream
	 * @return Map 包含单元格数据内容的Map对象
	 */
	public Map<Integer, Map<Integer, Object>> readExcelContent()
			throws Exception {
		if (wb == null) {
			throw new Exception("Workbook对象为空！");
		}
		Map<Integer, Map<Integer, Object>> content = new HashMap<Integer, Map<Integer, Object>>();

		sheet = wb.getSheetAt(0);
		// 得到总行数
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// 正文内容应该从第二行开始,第一行为表头的标题
		for (int i = 1; i <= rowNum; i++) {
			row = sheet.getRow(i);
			int j = 0;
			Map<Integer, Object> cellValue = new HashMap<Integer, Object>();
			while (j < colNum) {
				Object obj = getCellFormatValue(row.getCell(j));
				cellValue.put(j, obj);
				j++;
			}
			content.put(i, cellValue);
		}
		return content;
	}

	/**
	 * 
	 * 根据Cell类型设置数据
	 * 
	 * @param cell
	 * @return
	 */
	private Object getCellFormatValue(Cell cell) {
		Object cellvalue = "";
		if (cell != null) {
			// 判断当前Cell的Type
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:// 如果当前Cell的Type为NUMERIC
			case Cell.CELL_TYPE_FORMULA: {
				// 判断当前的cell是否为Date
				if (DateUtil.isCellDateFormatted(cell)) {
					// 如果是Date类型则，转化为Data格式
					// data格式是带时分秒的：2013-7-10 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// data格式是不带带时分秒的：2013-7-10
					Date date = cell.getDateCellValue();
					cellvalue = date;
				} else {// 如果是纯数字

					// 取得当前Cell的数值
					NumberFormat nf = NumberFormat.getInstance();
					nf.setGroupingUsed(false);
					cellvalue = nf.format(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING:// 如果当前Cell的Type为STRING
				// 取得当前的Cell字符串
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:// 默认的Cell值
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

	/**
	 * 导出学生实习单位
	 * 
	 * @param entity
	 * 
	 * @return
	 */
	public static HSSFWorkbook exCompany(List<EntityForExport> entity) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// 生成一个sheet1
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 为sheet1生成第一行，用于放表头信息
		HSSFRow row = sheet.createRow(0);
		// 第一行的第一个单元格的值为 ‘序号’
		row.createCell(0).setCellValue("学号");
		row.createCell(1).setCellValue("姓名");
		row.createCell(2).setCellValue("专业");
		row.createCell(3).setCellValue("班级");
		row.createCell(4).setCellValue("实习单位");
		row.createCell(5).setCellValue("地址");
		row.createCell(6).setCellValue("实习单位老师");
		row.createCell(7).setCellValue("实习单位联系电话");
		// 获得List中的数据，并将数据放到Excel中
		for (int i = 0; i < entity.size(); i++) {
			EntityForExport e = entity.get(i);
			HSSFRow dataRow = sheet.createRow(i+1);
			dataRow.createCell(0).setCellValue(e.getStudents().getStuNum());
			dataRow.createCell(1).setCellValue(e.getStudents().getName());
			dataRow.createCell(2).setCellValue(e.getStudents().getMajor());
			dataRow.createCell(3).setCellValue(e.getStudents().getClasses());
			dataRow.createCell(4).setCellValue(e.getCompany().getName());
			dataRow.createCell(5).setCellValue(e.getCompany().getAddress());
			dataRow.createCell(6).setCellValue(e.getCompany().getcTeacher());
			dataRow.createCell(7).setCellValue(e.getCompany().getcPhonr());
		}
		return wb;
	}

	/**
	 * 导出学生实习论文题目
	 * 
	 * @param entity
	 * 
	 * @return
	 */
	public static HSSFWorkbook exPaper(List<EntityForExport> entity) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// 生成一个sheet1
		HSSFSheet sheet = wb.createSheet("sheet1");
		// 为sheet1生成第一行，用于放表头信息
		HSSFRow row = sheet.createRow(0);
		// 第一行的第一个单元格的值为 ‘序号’
		row.createCell(0).setCellValue("学号");
		row.createCell(1).setCellValue("姓名");
		row.createCell(2).setCellValue("专业");
		row.createCell(3).setCellValue("班级");
		row.createCell(4).setCellValue("毕业论文名称");
		for (int i = 0; i < entity.size(); i++) {
			EntityForExport e = entity.get(i);
			HSSFRow dataRow = sheet.createRow(i+1);
			dataRow.createCell(0).setCellValue(e.getStudents().getStuNum());
			dataRow.createCell(1).setCellValue(e.getStudents().getName());
			dataRow.createCell(2).setCellValue(e.getStudents().getMajor());
			dataRow.createCell(3).setCellValue(e.getStudents().getClasses());
			dataRow.createCell(4).setCellValue(e.getPapers().getName());
		}
		return wb;
	}
	// public static void main(String[] args) {
	//
	// try {
	// String filepath =
	// "C:\\Users\\Administrator.WRPBCXIJRRWCOTY\\Desktop\\2017温州出院患者调查-11月电访(非01)_201711141140 - 副本.xlsx";
	// PoiTest excelReader = new PoiTest(filepath);
	// //excelReader.writeToDisk();
	// System.out.println("-----------------");
	// // 对读取Excel表格标题测试
	// // String[] title = excelReader.readExcelTitle();
	// // System.out.println("获得Excel表格的标题:");
	// // for (String s : title) {
	// // System.out.print(s + " ");
	// // }
	//
	// // 对读取Excel表格内容测试
	// Map<Integer, Map<Integer, Object>> map = excelReader
	// .readExcelContent();
	// System.out.println("获得Excel表格的内容:");
	// for (int i = 1; i <= map.size(); i++) {
	// System.out.println(map.get(i));
	// }
	// System.out.println(map.size());
	// } catch (FileNotFoundException e) {
	// System.out.println("未找到指定路径的文件!");
	// e.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}