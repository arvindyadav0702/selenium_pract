package programsforJava;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadingFromExcelAndValidating {

    @Test
    public void readingExcel() throws IOException {

        FileInputStream fi = new FileInputStream("C:\\Users\\arvin\\Documents\\Trades.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fi);

        XSSFSheet sheet = wb.getSheetAt(0);

        int totalrows = sheet.getLastRowNum();
        int columntotal = sheet.getRow(1).getLastCellNum();

        Row row = sheet.getRow(0);
        Cell cell = row.getCell(0);
        System.out.println(sheet.getRow(0).getCell(0));
        Row row1 = sheet.getRow(1);
        Cell cell1 = row1.getCell(1);
        System.out.println(sheet.getRow(0).getCell(1));
        Row row2 = sheet.getRow(1);
        Cell cell2 = row2.getCell(1);
        System.out.println(sheet.getRow(1).getCell(0));
        Row row3 = sheet.getRow(1);
        Cell cell3 = row3.getCell(1);
        System.out.println(sheet.getRow(1).getCell(1));


        wb.close();
        fi.close();


    }
}
