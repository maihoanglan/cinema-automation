package utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ReadExcelFile {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;

    public ReadExcelFile(String file) {
        try {
            this.workbook = new XSSFWorkbook(file);
            // lay sheet dau tien co trong file
            this.sheet = workbook.getSheetAt(0);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCell(int row, int col) {
        Cell cell = sheet.getRow(row).getCell(col);
        if (cell.getCellType() == CellType.NUMERIC) {
            return String.valueOf((int) cell.getNumericCellValue());
        }
        return cell.getStringCellValue();
    }
}