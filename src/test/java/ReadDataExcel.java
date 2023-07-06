import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

//@Listeners(ExtentReportPractice.class)
public class ReadDataExcel {

    @Test( groups = {"Sanity"})
    public void main() throws IOException {

//FILE -> Workbook -> Sheet -> row -> column

        FileInputStream fi = new FileInputStream("C:\\Users\\arvin\\Documents\\Trades.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fi);

        XSSFSheet sheet = wb.getSheetAt(0);

        int totalrows = sheet.getLastRowNum();
        int columntotal = sheet.getRow(1).getLastCellNum();

        System.out.println(totalrows);
        System.out.println(columntotal);

        for (int r = 0; r <= totalrows; r++) {
            XSSFRow rows = sheet.getRow(r);

            for (int c = 0; c < columntotal; c++) {

//                XSSFCell cellData = rows.getCell(c);

                String cellValue = rows.getCell(c).toString();

                System.out.println(cellValue);


            }
        }

        wb.close();
        fi.close();


    }
}
