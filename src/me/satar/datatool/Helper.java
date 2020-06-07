package me.satar.datatool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class Helper {

	static Properties properties = new Properties();
	static FileOutputStream outs = null;
	static FileInputStream inps = null;

	public Helper() {
		init();
	}

	public void init() {
		File propFile = new File(System.getProperty("user.dir") + "/res/app.properties");

		if (!propFile.exists()) {
			try {
				propFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (getProp("data-file-name") == null) {
			writeProp("data-file-name", "");
		}
	}

	public static void writeProp(String key, String val) {
		try {
			outs = new FileOutputStream(System.getProperty("user.dir") + "/res/app.properties");
			properties.setProperty(key, val);
			properties.store(outs, null);
			outs.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String getProp(String key) {
		String prop = "";
		try {
			inps = new FileInputStream(System.getProperty("user.dir") + "/res/app.properties");
			properties.load(inps);
			prop = properties.getProperty(key);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (inps == null) {
				try {
					inps.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return prop;
	}
}
