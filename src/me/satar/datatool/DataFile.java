package me.satar.datatool;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.util.Scanner;

public class DataFile {
	
	private File dataFile;
	private String dataFileName;
	
	private BufferedWriter bw;
	private FileWriter fw;
	
	public DataFile(String dataFileName) {
		this.dataFileName = dataFileName;
		createDataFile();
		try {
			fw = new FileWriter(dataFile);
			bw = new BufferedWriter(fw);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		DataTool.instance.dataFileManager.add(this);
	}
	
	public void createDataFile() {
		
		dataFile = new File(dataFileName);
		if (!dataFile.exists()) {
			System.out.println("Data file doesn't exist, creating one now.");
			try {
				dataFile.createNewFile();
				System.out.println("Created file: " + dataFileName);
			} catch (IOException e) {
				System.out.println("Directory doesn't exist! have a valid directory first.");
			}
		} else {
			System.out.println("exists!");
		}
	}
	
	public File getDataFile() {
		return dataFile;
	}
	
	public void writeData(String key, String value) {
		try {
			bw.write(key + ":" + value);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public String getFileName() {
		return dataFileName;
	}

}
