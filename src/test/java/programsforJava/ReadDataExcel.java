package programsforJava;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

//@Listeners(ExtentReportPractice.class)
public class ReadDataExcel {

    @Test(groups = {"Sanity"}, priority = 2)
    @Parameters({"Test"})
    public void readExcel(String name) throws IOException {

//FILE -> Workbook -> Sheet -> row -> column
        System.out.println(name);
        FileInputStream fi = new FileInputStream("C:\\Users\\arvin\\Documents\\Trades.xlsx");
        XSSFWorkbook wb = new XSSFWorkbook(fi);

        XSSFSheet sheet = wb.getSheetAt(0);

        int totalrows = sheet.getLastRowNum();
        int columntotal = sheet.getRow(1).getLastCellNum();
//
//        System.out.println(totalrows);
//        System.out.println(columntotal);

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


    public Object[][] excelDP() throws IOException {
        //We are creating an object from the excel sheet data by calling a method that reads data from the excel stored locally in our system
        Object[][] arrObj = getExcelData("C:\\Users\\arvin\\Documents\\Trades.xlsx",
                "Trades.xlsx");
        System.out.println(arrObj);
        return arrObj;
    }

    //This method handles the excel - opens it and reads the data from the respective cells using a for-loop & returns it in the form of a string array
    @Test(dataProvider = "excel-data", groups = {"Sanity"}, priority = 1)
    public String[][] getExcelData(String fileName, String sheetName) {

        String[][] data = null;
        try {
            FileInputStream fis = new FileInputStream(fileName);
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            XSSFSheet sh = wb.getSheet(sheetName);
            XSSFRow row = sh.getRow(0);
            int noOfRows = sh.getLastRowNum();
            int noOfCols = row.getLastCellNum();
            Cell cell;
            data = new String[noOfRows - 1][noOfCols];
            for (int i = 1; i < noOfRows; i++) {
                for (int j = 0; j < noOfCols; j++) {
                    row = sh.getRow(i);
                    cell = row.getCell(j);
                    data[i - 1][j] = cell.getStringCellValue();
                }
            }
        } catch (Exception e) {
            System.out.println("The exception is: " + e.getMessage());
        }
        return data;
    }


//    public static void main(String[] args) {
//        String string = "The best of both worlds";
//        int count = 0;
//
//        //Counts each character except space
//        for (int i = 0; i < string.length(); i++) {
//            if (string.charAt(i) != ' ')
//                count++;
//        }
//
//        String str = "Arvid";
//
//        characterCount(str);
//
//        //Displays the total number of characters present in the given string
//        System.out.println("Total number of characters in a string: " + count);
//    }

    static void characterCount(String inputString) {
        // Creating a HashMap containing char
        // as a key and occurrences as  a value
        HashMap<Character, Integer> charCountMap
                = new HashMap<Character, Integer>();

        // Converting given string to char array

        char[] strArray = inputString.toCharArray();

        // checking each char of strArray
        for (char c : strArray) {
            if (charCountMap.containsKey(c)) {

                // If char is present in charCountMap,
                // incrementing it's count by 1
                charCountMap.put(c, charCountMap.get(c) + 1);
            } else {

                // If char is not present in charCountMap,
                // putting this char to charCountMap with 1 as it's value
                charCountMap.put(c, 1);
            }

        }

        // Printing the charCountMap
        for (Map.Entry entry : charCountMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }


//        public static void main(String args[]) {
//            // Your code goes here
//            Scanner scn = new Scanner(System.in);
//            int n = scn.nextInt();
//
//            int a = 0; //0th fibonacci number
//            int b = 1; //1st fibonacci number
//
//            if(n == 0) System.out.println(a);
//            else if(n == 1) System.out.println(b);
//            else {
//                int c = 0;
//                for(int i=2;i<=n;i++) {
//                    c = a + b;
//                    a = b;
//                    b = c;
//                }
//
//                System.out.println(c);
//            }
//
//        }


    public static int countDigitFreq(int n, int d) {
        int counter = 0;
        while (n != 0) {
            int digit = n % 10; //calculate the digit
            if (digit == d) counter++;
            n = n / 10;
        }

        return counter;
    }


    public static void main(String[] args) {
        // Your code goes here
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); //input the number
        int d = scn.nextInt(); //input the digit

        int x = countDigitFreq(n, d);
        System.out.println("The digit " + d + " occurs " + x + " times in " + n);
    }


    ArrayList<String> list = new ArrayList<>();

    LinkedList<Integer> inte = new LinkedList<>();


    Set<String> settt = new HashSet<>();
    Set<Integer> seeeee = new TreeSet<>();
}




