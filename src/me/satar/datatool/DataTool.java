package me.satar.datatool;

import java.io.File;
/**
 * 
 * @author Satar Hassni
 * 
 * 
 * This tool is a reading and writing tool for files.
 * Making it useful for other projects with an easy implementation 
 * and offering flexibility for developers.
 *
 */
public class DataTool {
	
	/*
	 * TODO :
	 *  - categorize data in groups , DataTypes their own section in the file
	 */
	
	public static DataTool instance;
	public DataFile dataFileObj;
	public DataFileManager dataFileManager;
	
	public DataTool() {
		init();
	}
	
	public String readData() {
		String data = "";
		return data;
	}
	
	public static void main(String[] args) {
		new DataTool();
		//instance.dataFileObj = new DataFile("datafile.txt");
		instance.dataFileObj = new DataFile("C:\\DataTool\\datafile.txt");
		System.out.println(System.getProperty("user.dir"));
		instance.dataFileObj.writeString("first", "mydata");
		instance.dataFileObj.writeString("second", "myother");
		instance.dataFileObj.writeString("hello", "world");
		instance.dataFileObj.writeString("hello", "world.bye");
		
		System.out.println(instance.dataFileObj.getString("second"));
	}
	
	public void init() {
		instance = this;
		dataFileManager = new DataFileManager();
		new Helper();
	}
	
	
}
