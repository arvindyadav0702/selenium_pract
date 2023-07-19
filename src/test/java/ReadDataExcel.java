import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

//@Listeners(ExtentReportPractice.class)
public class ReadDataExcel {

    @Test(groups = {"Sanity"} , priority = 2)
    @Parameters({"Test"})
    public void readExcel(String name) throws IOException {

//FILE -> Workbook -> Sheet -> row -> column
        System.out.println(name);
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

    @DataProvider(name ="excel-data")
    public Object[][] excelDP() throws IOException{
        //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        Object[][] arrObj = getExcelData("C:\\Users\\arvin\\Documents\\Trades.xlsx",
                "Trades.xlsx");
        System.out.println(arrObj);
        return arrObj;
    }
    //This method handles the excel - opens it and reads the data from the respective cells using a for-loop & returns it in the form of a string array
    @Test(dataProvider = "excel-data", groups = {"Sanity"},priority = 1)
    public String[][] getExcelData(String fileName, String sheetName){

        String[][] data = null;
        try
        {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(0);
            int noOfRows = sh.getLastRowNum();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows-1][noOfCols];
            for(int i =1; i<noOfRows;i++){
                for(int j=0;j<noOfCols;j++){
                    row = sh.getRow(i);
                    cell= row.getCell(j);
                    data[i-1][j] = cell.getStringCellValue();
                }
            }
        }
        catch (Exception e) {
            System.out.println("The exception is: " +e.getMessage());
        }
        return data;
    }


}
