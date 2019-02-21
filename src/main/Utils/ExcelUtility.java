package main.Utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ExcelUtility {
    public static final String SAMPLE_XLSX_FILE_PATH = "/Users/chris.mkhontwana/Documents/GitHub/Logistics/supply_chain_automation/src/main/DataFiles/userData.xlsx";

    public static String[][] ReadExcelFile() throws IOException, InvalidFormatException {
        String[][] excelData = null;
        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(SAMPLE_XLSX_FILE_PATH));

        // 2. Or you can use a for-each loop
        System.out.println("Retrieving Sheets using for-each loop");
        for (Sheet sheet : workbook) {
            System.out.println("=> " + sheet.getSheetName());
        }

        // Getting the Sheet at index zero
        Sheet sheet = workbook.getSheetAt(0);

        String dataSheetName = "";
        Sheet sheetName = workbook.getSheet(dataSheetName);

        //Find number of rows in excel file
        int rowCount = sheet.getLastRowNum() - sheet.getFirstRowNum();

        int numRows = sheet.getLastRowNum() + 1;
        int numCols = sheet.getRow(0).getLastCellNum();
        excelData = new String[numRows][numCols];

        //Create a loop over all the rows of excel file to read it
        for (int i = 0; i < rowCount + 1; i++) {
            Row row = sheet.getRow(i);
            for (int j = 0; j < row.getLastCellNum(); j++) {
                DataFormatter fmt = new DataFormatter();
                String valueAsSeenInExcel = fmt.formatCellValue(row.getCell(j));
                excelData[i][j] = valueAsSeenInExcel;
            }
        }
        workbook.close();
        return excelData;
    }

    public static void getSpecificTestData(String testName, String[][] excelData) {
        Map<String, String> currentTestData = new LinkedHashMap<String, String>();

        int numRows = excelData.length;
        int numCols = excelData[0].length;

        System.out.println("Number of rows" + numRows);
        System.out.println("Number of columns" + numCols);

        for (int i = 0; i < numRows; i++)
        {
            if (excelData[i][0].toString().equals(testName))
            {
                System.out.print("We found our test : " + excelData[i][0]);
                System.out.print("\n   Key   :   Value ");
                for (int j = 0; j < numCols; j++) {
//                    System.out.print(excelData[i][j]);
                    System.out.print("\n " + excelData[0][j] + " : " + excelData[i][j]);
                    currentTestData.put(excelData[0][j], excelData[i][j]);

                }
            }

            System.out.println("");
        }
    }

}
