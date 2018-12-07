package utils;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ExcelDataReader {

    private static Workbook getWorkBook(String pathToFile) {
        Workbook workbook = null;
        try {
            workbook = WorkbookFactory.create(new File(pathToFile));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static List<List<String>> getDataFromExcelFile(String pathToFile) {
        List<List<String>> dataFromSheet = new ArrayList<>();
        for (Row row : getWorkBook(pathToFile).getSheetAt(0)) {
            List<String> dataFromRow = new ArrayList<>();
            if (row.getRowNum() == 0) {
                continue;
            }
            for (Cell cell : row) {
                if ((cell.getColumnIndex() != row.getLastCellNum())) {
                    dataFromRow.add(cell.getStringCellValue());
                }
            }
            dataFromSheet.add(dataFromRow);
        }
        return dataFromSheet;
    }
}

