package utils;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class excelReading {
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static void openExcel(String excelpath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(excelpath);
            workbook = new XSSFWorkbook(fileInputStream);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void getSheet(String sheetname) {
         sheet = workbook.getSheet(sheetname);
    }
    public static int rowcount() {
        return sheet.getPhysicalNumberOfRows();
    }
    public static int cellcount(int rowIndex){
        return sheet.getRow(rowIndex).getPhysicalNumberOfCells();
    }
    public static String getcellData(int rowIndex, int cellIndex) {
        if (sheet.getRow(rowIndex) != null && sheet.getRow(rowIndex).getCell(cellIndex) != null) {
            return sheet.getRow(rowIndex).getCell(cellIndex).toString();
        }  else {return "cell is empty";}
    }
    public static List<Map<String,String>> excelintoList(String filePath, String sheetName) {
        openExcel(filePath);
        getSheet(sheetName);
        List<Map<String, String>> exceldata = new ArrayList<>();
        int totalRows = rowcount();
        for (int row = 1; row < totalRows; row++) {
            if (sheet.getRow(row) != null) {
                Map<String, String> map = new LinkedHashMap<>();
                int totalCells = cellcount(row);
                for (int cel = 0; cel < totalCells; cel++) {
                    if (sheet.getRow(row).getCell(cel) != null) {
                        if (sheet.getRow(row).getCell(cel) != null) { // Check if the cell is not null
                            String rowData = getcellData(row, cel);
                            String columnHeader = getcellData(0, cel);
                            map.put(columnHeader, rowData);
                        }
                    }
                    map.put(getcellData(0, cel), getcellData(row, cel));
                }
                exceldata.add(map);
            }
        }
        return exceldata;
    }
    }
