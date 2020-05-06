package com.project.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
	
	public static FileInputStream inputStream = null;
	public static Properties prop = null;
	public static String ReadProperty(String PropertyName) throws IOException{
		String PropertyValue = null;
		//Create an instance of Properties Class and load the Properties file
		//to return property value for a particular property in the properties file
		//we have open the file in read mode
		String ProjectPath = System.getProperty("user.dir");
		inputStream = new FileInputStream(ProjectPath + "/src/com/project/config/config.properties");
		prop = new Properties();
		prop.load(inputStream); //load the properties file
		PropertyValue = prop.getProperty(PropertyName);
		return PropertyValue;
	}
	
	
}
