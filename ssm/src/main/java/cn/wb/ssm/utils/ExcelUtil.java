package cn.wb.ssm.utils;

import java.util.List;

import javax.servlet.ServletOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.util.CellRangeAddress;

import cn.wb.ssm.entity.Supplier;


public class ExcelUtil {

	/**
	 * �����û��������б�excel
	 * @param userList �û��б�
	 * @param outputStream �����
	 */
	public static void exportUserExcel(List<Supplier> userList, ServletOutputStream outputStream) {
		try {
			//1������������
			HSSFWorkbook workbook = new HSSFWorkbook();
			//1.1�������ϲ���Ԫ�����
			CellRangeAddress cellRangeAddress = new CellRangeAddress(0, 0, 0, 4);//��ʼ�кţ������кţ���ʼ�кţ������к�
			
			//1.2��ͷ������ʽ
			HSSFCellStyle style1 = createCellStyle(workbook, (short)16);
			
			//1.3���б�����ʽ
			HSSFCellStyle style2 = createCellStyle(workbook, (short)13);
			
			//2������������
			HSSFSheet sheet = workbook.createSheet("��Ӧ���б�");
			//2.1�����غϲ���Ԫ�����
			sheet.addMergedRegion(cellRangeAddress);
			//����Ĭ���п�
			sheet.setDefaultColumnWidth(25);
			
			//3��������
			//3.1������ͷ�����У���������ͷ����
			HSSFRow row1 = sheet.createRow(0);
			HSSFCell cell1 = row1.createCell(0);
			//���ص�Ԫ����ʽ
			cell1.setCellStyle(style1);
			cell1.setCellValue("�û��б�");
			
			//3.2�������б����У����������б���
			HSSFRow row2 = sheet.createRow(1);
			String[] titles = {"��Ӧ������","��ϵ��","�绰","��ַ","�ڳ�Ӧ��","����"};
			for(int i = 0; i < titles.length; i++){
				HSSFCell cell2 = row2.createCell(i);
				//���ص�Ԫ����ʽ
				cell2.setCellStyle(style2);
				cell2.setCellValue(titles[i]);
			}
			
			//4��������Ԫ�񣻽��û��б�д��excel
//			if(userList != null){
//				for(int j = 0; j < userList.size(); j++){
//					HSSFRow row = sheet.createRow(j+2);
//					HSSFCell cell11 = row.createCell(0);
//					cell11.setCellValue(userList.get(j).getName());
//					HSSFCell cell12 = row.createCell(1);
//					cell12.setCellValue(userList.get(j).getAccount());
//					HSSFCell cell13 = row.createCell(2);
//					cell13.setCellValue(userList.get(j).getDept());
//					HSSFCell cell14 = row.createCell(3);
//					cell14.setCellValue(userList.get(j).isGender()?"��":"Ů");
//					HSSFCell cell15 = row.createCell(4);
//					cell15.setCellValue(userList.get(j).getEmail());
//				}
//			}
//			//5�����
//			workbook.write(outputStream);
//			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ������Ԫ����ʽ
	 * @param workbook ������
	 * @param fontSize �����С
	 * @return ��Ԫ����ʽ
	 */
	private static HSSFCellStyle createCellStyle(HSSFWorkbook workbook, short fontSize) {
		HSSFCellStyle style = workbook.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);//ˮƽ����
		style.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);//��ֱ����
		//��������
		HSSFFont font = workbook.createFont();
		font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);//�Ӵ�����
		font.setFontHeightInPoints(fontSize);
		//��������
		style.setFont(font);
		return style;
	}

}
