package util;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.*;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

public class ReadTestData {
	
	/*public static void getData() {
		String file = System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\productAddedToCart.csv";
		try {
			FileReader fr = new FileReader(file);
			CSVReader csvReader = new CSVReader(fr);
			String[] nextData;			
			
			while((nextData = csvReader.readNext())!=null) {
				for(String data:nextData) {					
					System.out.println(data);
				}				
			}
		} catch (FileNotFoundException e) {			
			e.printStackTrace();
		} catch (CsvValidationException e) {			
			e.printStackTrace();
		} catch (IOException e) {			
			e.printStackTrace();
		} catch (CsvException e) {			
			e.printStackTrace();
		}
	}*/
	
	@DataProvider
	public static Iterator<String[]> getCsvData(Method m) throws IOException, Exception{
		//String csvFileName = m.getAnnotation(Test.class).description();
		String csvFileName = m.getAnnotation(Test.class).description();
		System.out.println("csv file name: "+csvFileName);
		
		String file = System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\"+csvFileName;			
		FileReader fr = new FileReader(file);			
		CSVReader csvReader = new CSVReader(fr);
		List<String []> testData = new ArrayList<>();
		String[] nextData= csvReader.readNext();	    
		while((nextData= csvReader.readNext())!=null) {
			System.out.println("next data: "+nextData);
			testData.add(nextData);											
		}
		fr.close();
			
		return testData.iterator();
	}
	

}
