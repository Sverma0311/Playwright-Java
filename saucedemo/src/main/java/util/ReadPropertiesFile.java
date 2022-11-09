package util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadPropertiesFile {
	
	
	public static String getProperties(String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fi = new FileInputStream("C:\\Users\\swatverma\\eclipse-workspace\\saucedemo\\src\\main\\resources\\configuration\\config.properties");
			prop.load(fi);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
		
	}
	public static void main(String[] args) {
		System.out.println(getProperties("browser"));
	}
	

}
