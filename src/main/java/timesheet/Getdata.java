package timesheet;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Getdata {
	public static ArrayList<String> arr;
	public Getdata() throws IOException{
	 arr = new ArrayList<String>();
	 FileInputStream fis = new FileInputStream("C:\\Users\\ARIJIT\\Documents\\practise.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook("C:\\Users\\ARIJIT\\Documents\\practise.xlsx");
		XSSFSheet s = workbook.getSheetAt(0);
		Iterator<Row> r = s.iterator();
		int i = 0;
		while(r.hasNext()) {
			Row row  = r.next();
			Cell cell = row.getCell(0);
			if(cell.getStringCellValue().equalsIgnoreCase("Username")) {
				break;
			}
			i++;
		}
		Row row = s.getRow(i+1);
		Iterator<Cell> itc = row.iterator();
		while(itc.hasNext()) {
			Cell c = itc.next();
			arr.add(c.getStringCellValue());
		}
		//System.out.println(arr.size());
	}
	public static  void main(String[] args) throws IOException,InterruptedException{
      
	}
	  public ArrayList<String> getdata(){
			return arr;
		}

}

