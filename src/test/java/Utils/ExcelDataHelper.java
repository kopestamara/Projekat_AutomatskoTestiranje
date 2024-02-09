package Utils;

import Base.ExcelReader;

import java.io.IOException;
// This class serves as a helper for reading data from an Excel file.
// It doesn't need a driver as it doesn't interacts with Web Elements
public class ExcelDataHelper {
    private final ExcelReader excelReader;
// Constructor to initialize the ExcelDataHelper with an ExcelReader instance.
    public ExcelDataHelper() throws IOException {
        this.excelReader = new ExcelReader("Credentials.xlsx");
    }
    public String username(int rowNumber){
        return excelReader.getStringData("Add", rowNumber, 0);
    }
    public String password(int rowNumber){
        return excelReader.getStringData("Add", rowNumber,1);
    }
    public String wrongUsername(int rowNumber) {
        return excelReader.getStringData("Add", rowNumber, 5);
    }
    public String wrongPassword(int rowNumber) {
        return excelReader.getStringData("Add", rowNumber, 6);
    }

    public String firstName(int rowNumber){
        return excelReader.getStringData("Add", rowNumber,2);
    }
    public String lastName(int rowNumber){
        return excelReader.getStringData("Add", rowNumber,3);
    }
    public String zipPostalCode(int rowNumber){
        return excelReader.getStringData("Add", rowNumber,4);
    }

}
