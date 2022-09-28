package com.qa.wishupDEV.utilitySimple;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public class PropertiesConfigUtility {

	public static FileInputStream Obj_file;
	public static Properties prop;
	public static Properties configprop (String filename) {

		//Create fileinput stream object for properties file
		try {
			Obj_file = new FileInputStream("./Properties/"+filename+".properties");	
			//creating properties class object
			prop = new Properties();
			prop.load(Obj_file);

			//get the property using get property()
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return prop;
	}
}

