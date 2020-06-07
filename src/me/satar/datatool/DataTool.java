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
		instance.dataFileObj = new DataFile("datafile.txt");
		//instance.dataFileObj = new DataFile("C:\\DataTool\\datafile.txt");
		System.out.println(System.getProperty("user.dir"));
		instance.dataFileObj.writeData("first", "mydata");
		instance.dataFileObj.writeData("second", "myother");
		instance.dataFileObj.writeData("hello", "world");
		instance.dataFileObj.writeData("hello", "world.bye");
	}
	
	public void init() {
		instance = this;
		dataFileManager = new DataFileManager();
		new Helper();
	}
	
	
}
