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
 * ��ȡExcel
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
	 * ��ȡExcel����ͷ������
	 * 
	 * @param InputStream
	 * @return String ��ͷ���ݵ�����
	 */
	public String[] readExcelTitle() throws Exception {
		if (wb == null) {
			throw new Exception("Workbook����Ϊ�գ�");
		}
		sheet = wb.getSheetAt(0);
		row = sheet.getRow(0);
		// ����������
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
	 * ��ȡExcel��������
	 * 
	 * @param InputStream
	 * @return Map ������Ԫ���������ݵ�Map����
	 */
	public Map<Integer, Map<Integer, Object>> readExcelContent()
			throws Exception {
		if (wb == null) {
			throw new Exception("Workbook����Ϊ�գ�");
		}
		Map<Integer, Map<Integer, Object>> content = new HashMap<Integer, Map<Integer, Object>>();

		sheet = wb.getSheetAt(0);
		// �õ�������
		int rowNum = sheet.getLastRowNum();
		row = sheet.getRow(0);
		int colNum = row.getPhysicalNumberOfCells();
		// ��������Ӧ�ôӵڶ��п�ʼ,��һ��Ϊ��ͷ�ı���
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
	 * ����Cell������������
	 * 
	 * @param cell
	 * @return
	 */
	private Object getCellFormatValue(Cell cell) {
		Object cellvalue = "";
		if (cell != null) {
			// �жϵ�ǰCell��Type
			switch (cell.getCellType()) {
			case Cell.CELL_TYPE_NUMERIC:// �����ǰCell��TypeΪNUMERIC
			case Cell.CELL_TYPE_FORMULA: {
				// �жϵ�ǰ��cell�Ƿ�ΪDate
				if (DateUtil.isCellDateFormatted(cell)) {
					// �����Date������ת��ΪData��ʽ
					// data��ʽ�Ǵ�ʱ����ģ�2013-7-10 0:00:00
					// cellvalue = cell.getDateCellValue().toLocaleString();
					// data��ʽ�ǲ�����ʱ����ģ�2013-7-10
					Date date = cell.getDateCellValue();
					cellvalue = date;
				} else {// ����Ǵ�����

					// ȡ�õ�ǰCell����ֵ
					NumberFormat nf = NumberFormat.getInstance();
					nf.setGroupingUsed(false);
					cellvalue = nf.format(cell.getNumericCellValue());
				}
				break;
			}
			case Cell.CELL_TYPE_STRING:// �����ǰCell��TypeΪSTRING
				// ȡ�õ�ǰ��Cell�ַ���
				cellvalue = cell.getRichStringCellValue().getString();
				break;
			default:// Ĭ�ϵ�Cellֵ
				cellvalue = "";
			}
		} else {
			cellvalue = "";
		}
		return cellvalue;
	}

	/**
	 * ����ѧ��ʵϰ��λ
	 * 
	 * @param entity
	 * 
	 * @return
	 */
	public static HSSFWorkbook exCompany(List<EntityForExport> entity) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// ����һ��sheet1
		HSSFSheet sheet = wb.createSheet("sheet1");
		// Ϊsheet1���ɵ�һ�У����ڷű�ͷ��Ϣ
		HSSFRow row = sheet.createRow(0);
		// ��һ�еĵ�һ����Ԫ���ֵΪ ����š�
		row.createCell(0).setCellValue("ѧ��");
		row.createCell(1).setCellValue("����");
		row.createCell(2).setCellValue("רҵ");
		row.createCell(3).setCellValue("�༶");
		row.createCell(4).setCellValue("ʵϰ��λ");
		row.createCell(5).setCellValue("��ַ");
		row.createCell(6).setCellValue("ʵϰ��λ��ʦ");
		row.createCell(7).setCellValue("ʵϰ��λ��ϵ�绰");
		// ���List�е����ݣ��������ݷŵ�Excel��
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
	 * ����ѧ��ʵϰ������Ŀ
	 * 
	 * @param entity
	 * 
	 * @return
	 */
	public static HSSFWorkbook exPaper(List<EntityForExport> entity) {
		HSSFWorkbook wb = new HSSFWorkbook();
		// ����һ��sheet1
		HSSFSheet sheet = wb.createSheet("sheet1");
		// Ϊsheet1���ɵ�һ�У����ڷű�ͷ��Ϣ
		HSSFRow row = sheet.createRow(0);
		// ��һ�еĵ�һ����Ԫ���ֵΪ ����š�
		row.createCell(0).setCellValue("ѧ��");
		row.createCell(1).setCellValue("����");
		row.createCell(2).setCellValue("רҵ");
		row.createCell(3).setCellValue("�༶");
		row.createCell(4).setCellValue("��ҵ��������");
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
	// "C:\\Users\\Administrator.WRPBCXIJRRWCOTY\\Desktop\\2017���ݳ�Ժ���ߵ���-11�µ��(��01)_201711141140 - ����.xlsx";
	// PoiTest excelReader = new PoiTest(filepath);
	// //excelReader.writeToDisk();
	// System.out.println("-----------------");
	// // �Զ�ȡExcel���������
	// // String[] title = excelReader.readExcelTitle();
	// // System.out.println("���Excel���ı���:");
	// // for (String s : title) {
	// // System.out.print(s + " ");
	// // }
	//
	// // �Զ�ȡExcel������ݲ���
	// Map<Integer, Map<Integer, Object>> map = excelReader
	// .readExcelContent();
	// System.out.println("���Excel��������:");
	// for (int i = 1; i <= map.size(); i++) {
	// System.out.println(map.get(i));
	// }
	// System.out.println(map.size());
	// } catch (FileNotFoundException e) {
	// System.out.println("δ�ҵ�ָ��·�����ļ�!");
	// e.printStackTrace();
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
}