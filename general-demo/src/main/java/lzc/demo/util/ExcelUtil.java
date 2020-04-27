package lzc.demo.util;

import lombok.Data;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.CellRangeAddressList;

import java.io.FileOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Author lzc
 * @Date 2020/4/27 13:40
 **/
public class ExcelUtil {

    public static void main(String[] args) {
        List<FamilyTicket> ticketList = new ArrayList<>();
        FamilyTicket familyTicket = new FamilyTicket();
        familyTicket.setName("亲子套票");
        familyTicket.setTicketTypeCode("PFT001");
        familyTicket.setQuantity(2);

        List<FamilyTicketDetail> familyTicketDetailList = new ArrayList<>();
        FamilyTicketDetail detail = new FamilyTicketDetail();
        detail.setMoldCode("PST001");
        detail.setMoldName("大人票");
        detail.setQuantity(2);
        FamilyTicketDetail detailChildren = new FamilyTicketDetail();
        detailChildren.setMoldCode("PST002");
        detailChildren.setMoldName("儿童票");
        detailChildren.setQuantity(1);
        familyTicketDetailList.add(detail);
        familyTicketDetailList.add(detailChildren);

        familyTicket.setDetailList(familyTicketDetailList);
        ticketList.add(familyTicket);

        generate(ticketList);
    }

    public static void generate(List<FamilyTicket> ticketList) {
        //创建excel表
        HSSFWorkbook wb = new HSSFWorkbook();
        HSSFSheet sheet = wb.createSheet("套票实名制信息");
        //设置默认行宽
        sheet.setDefaultColumnWidth(20);
        //设置表头
        fillHead(wb, sheet);

        fillRow(wb, sheet, ticketList);


        // 设置单元格多选
        String[] textList = {"身份证","护照","港澳通行证"};
        // 加载下拉列表内容
        DVConstraint constraint = DVConstraint.createExplicitListConstraint(textList);
        // 设置数据有效性加载在哪个单元格上,四个参数分别是：起始行、终止行、起始列、终止列
        CellRangeAddressList regions = new CellRangeAddressList(0,5000, 7, 7);
        // 数据有效性对象
        HSSFDataValidation data_validation_list = new HSSFDataValidation(regions, constraint);
        sheet.addValidationData(data_validation_list);


        try {
            //创建表格数据
            Field[] fields;
            int i = 2;


//            out = new ByteArrayOutputStream();
//            wb.write(out);
//            result =  out.toByteArray();

            FileOutputStream output = new FileOutputStream("d:\\workbook.xls");
            wb.write(output);
            output.flush();
        } catch (Exception ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
        }


    }

    private static void fillHead(HSSFWorkbook wb, HSSFSheet sheet){
        //表头样式（加粗，水平居中，垂直居中）
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //水平居中
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //垂直居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setFillForegroundColor(IndexedColors.PALE_BLUE.getIndex());
        cellStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);

        //设置一行8列固定
        sheet.createFreezePane(8,1);

        //创建表头
        HSSFRow row = sheet.createRow(0);
        //行高
        row.setHeightInPoints(20);

        HSSFCell cell_00 = row.createCell(0);
        cell_00.setCellValue("套票名称");
        cell_00.setCellStyle(cellStyle);
        HSSFCell cell_01 = row.createCell(1);
        cell_01.setCellValue("套票编码");
        cell_01.setCellStyle(cellStyle);
        HSSFCell cell_02 = row.createCell(2);
        cell_02.setCellValue("分组");
        cell_02.setCellStyle(cellStyle);
        HSSFCell cell_03 = row.createCell(3);
        cell_03.setCellValue("子票名称");
        cell_03.setCellStyle(cellStyle);
        HSSFCell cell_04 = row.createCell(4);
        cell_04.setCellValue("子票编码");
        cell_04.setCellStyle(cellStyle);
        HSSFCell cell_05 = row.createCell(5);
        cell_05.setCellValue("姓名");
        cell_05.setCellStyle(cellStyle);
        HSSFCell cell_06 = row.createCell(6);
        cell_06.setCellValue("证件号");
        cell_06.setCellStyle(cellStyle);
        HSSFCell cell_07 = row.createCell(7);
        cell_07.setCellValue("证件类型");
        cell_07.setCellStyle(cellStyle);
    }

    private static void fillRow(HSSFWorkbook wb, HSSFSheet sheet, List<FamilyTicket> familyTicketList){
        int rowNo = 1;
        int groupNo = 1;
        int rowIndex = 0;
        HSSFRow row = null;
        HSSFCell cell;
        //表头样式（加粗，水平居中，垂直居中）
        HSSFCellStyle cellStyle = wb.createCellStyle();
        //水平居中
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        //垂直居中
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        //套票
        for (FamilyTicket familyTicket : familyTicketList){
            int totalFamilyDetailNum = 0;
            //套票的数量
            for (int i=0; i< familyTicket.getQuantity();i++){
                int perFamilyDetailNum = 0;
                //子票
                for (FamilyTicketDetail detail : familyTicket.getDetailList()){
                    //子票数量
                    for(int j=0; j< detail.getQuantity(); j++){
                        row = sheet.createRow(rowNo ++);
                        //行高
                        row.setHeightInPoints(20);
                        cell = row.createCell(3);
                        cell.setCellValue(detail.getMoldName());
                        cell = row.createCell(4);
                        cell.setCellValue(detail.getMoldCode());

                        if(perFamilyDetailNum == 0){
                            //设置分组编号
                            cell = row.createCell(2);
                            cell.setCellValue(groupNo++);
                            cell.setCellStyle(cellStyle);
                        }
                        if(totalFamilyDetailNum == 0){
                            //套票信息
                            cell = row.createCell(0);
                            cell.setCellValue(familyTicket.getName());
                            cell.setCellStyle(cellStyle);
                            cell = row.createCell(1);
                            cell.setCellStyle(cellStyle);
                            cell.setCellValue(familyTicket.getTicketTypeCode());
                        }

                        rowIndex++;
                        perFamilyDetailNum++;
                        totalFamilyDetailNum++;
                    }
                }

                //合并分组信息
                CellRangeAddress region = new CellRangeAddress(rowIndex - perFamilyDetailNum + 1, rowIndex, 2, 2);
                sheet.addMergedRegion(region);
            }

            //合并套票信息
            sheet.addMergedRegion(new CellRangeAddress(rowIndex - totalFamilyDetailNum + 1, rowIndex, 0, 0));
            sheet.addMergedRegion(new CellRangeAddress(rowIndex - totalFamilyDetailNum + 1, rowIndex, 1, 1));
        }

    }

    /**
     * 套票
     */
    @Data
    private static class FamilyTicket{
        /**
         * 票型编码
         */
        private String ticketTypeCode;

        private String name;

        private Integer quantity;

        private List<FamilyTicketDetail> detailList;
    }


    /**
     * 子票
     */
    @Data
    private static class FamilyTicketDetail{
        /**
         * 票型名称
         */
        private String moldName;
        /**
         * 票型编码
         */
        private String moldCode;
        /**
         * 票数
         */
        private Integer quantity;
    }

}
