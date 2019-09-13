package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class FrameworkUtils {

	public FrameworkUtils() {
	}

	public static void sleeps(long segundos) {
		try {
			Thread.sleep(segundos * 1000);
		} catch (InterruptedException e) {

		}
	}

	public String loadFromPropertiesFile(String propertieFileName, String propertLoad) {
		Properties prop = new Properties();
		InputStream input = null;
		String path = "src/main/resources/";
		String property = "";
		try {
			input = new FileInputStream(path + propertieFileName);
			prop.load(input);
			property = prop.getProperty(propertLoad);
		} catch (IOException ex) {
			System.out.println(ex.toString());
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					System.out.println(e.toString());
				}
			}
		}
		return property;
	}

}