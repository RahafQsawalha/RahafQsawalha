package signup_Test;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excelsheet {

	
public String[][] ReadSheet() throws InvalidFormatException , IOException{
	

		
File myfile=new File(".\\Test_data\\Data.xlsx");
XSSFWorkbook wb=new XSSFWorkbook(myfile) ;
XSSFSheet mysheet=wb.getSheet("sheet1");






int number_of_rows = mysheet.getPhysicalNumberOfRows();
int number_of_columns=mysheet.getRow(0).getLastCellNum();
String[][]myarray=new String[number_of_rows-1][number_of_columns];
for(int i =1 ;i<number_of_rows;i++) {
	for (int a=0; a<number_of_columns;a++) {
		XSSFRow row=mysheet.getRow(i);
		myarray[i-1][a]=row.getCell(a).getStringCellValue();
		
	}
}
return myarray;
//Cell=ExcelWSheet .getRow(0).getCell(0);

//String cellData =Cell.getStringCellValue();
//System.out.print("Cell Data : " +cellData);


	}
	}


