package main.Utils;

/**
 * @author chris
 * Date: 21/02/19
 */

//import com.sun.media.sound.InvalidFormatException;
import main.Engine.API.EngineDriver;
//import org.apache.commons.compress.archivers.dump.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.io.IOException;

public class ExcelUtility extends EngineDriver {

   //The method read data from the spread sheet and store it in a 2D array
   public static String[][] ReadExcelFile(String dataSheetName) throws IOException {

        // Creating a Workbook from an Excel file (.xls or .xlsx)
        Workbook workbook = WorkbookFactory.create(new File(XLSX_FILE_PATH));

        //Get the data from the sheet you want to read
        Sheet sheet = workbook.getSheet(dataSheetName);

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
}
