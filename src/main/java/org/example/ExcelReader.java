package org.example;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.*;

public class ExcelReader {
    public static void main(String[] args) {
        String filePath = "path/to/your/excel/file.xlsx";
        String sheetName = "Sheet1";
        int targetRow = 3; // Change this to the desired row number (starting from 1)

        try (FileInputStream file = new FileInputStream(filePath);
             Workbook workbook = WorkbookFactory.create(file)) {
            Sheet sheet = workbook.getSheet(sheetName);

            // Read the first row and store the data in a HashMap
            Row firstRow = sheet.getRow(0);
            Map<Integer, String> firstRowData = new HashMap<>();
            Iterator<Cell> firstRowIterator = firstRow.cellIterator();
            int columnIndex = 0;
            while (firstRowIterator.hasNext()) {
                Cell cell = firstRowIterator.next();
                String cellValue = cell.getStringCellValue();
                firstRowData.put(columnIndex, cellValue);
                columnIndex++;
            }
            System.out.println("First Row Data: " + firstRowData);

            // Read the desired row and store the data in a HashMap
            Row targetRowData = sheet.getRow(targetRow - 1);
            Map<String, String> rowData = new HashMap<>();
            Iterator<Cell> targetRowIterator = targetRowData.cellIterator();
            columnIndex = 0;
            while (targetRowIterator.hasNext()) {
                Cell cell = targetRowIterator.next();
                String cellValue = cell.getStringCellValue();
                String columnHeader = firstRowData.get(columnIndex);
                rowData.put(columnHeader, cellValue);
                columnIndex++;
            }
            System.out.println("Row " + targetRow + " Data: " + rowData);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
