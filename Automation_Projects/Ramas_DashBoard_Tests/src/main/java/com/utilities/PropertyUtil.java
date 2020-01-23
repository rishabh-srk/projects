package com.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtil {

	public static String filename = "src/main/resources/config.properties";

	public static Properties property = null;

	public static String getPropertyKey(String key) {

		if (property == null) {
			loadProperties();
		}
		String value = property.getProperty(key);
		System.out.println(value);
		return value;

	}

	public static void loadProperties() {

		property = new Properties();
		FileReader file = null;
		try {
			
			file = new FileReader(filename);
			property.load(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				file.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	
	
}
