package me.satar.datatool;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.GenericArrayType;
import java.util.Scanner;

public class DataFile {

	private File dataFile;
	private String dataFileName;
	private char keySeperator = ':';

	private BufferedWriter bw;
	private BufferedReader br;
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

	public void writeString(String key, String value) {
		try {
			bw.write(key + ":" + value);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getString(String data) {
		String s = null;
		try {
			br = new BufferedReader(new FileReader(dataFile));
			String line = br.readLine();
			while (line != null) {
				//System.out.println(line);
				//System.out.println(isolateStringKey(line));
				if (data.equalsIgnoreCase(isolateStringKey(line))) {
					s = line.substring(getSeperatorIndex(line) +1);
					s.trim();
					return s;
				}
				line = br.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return s;
	}

	public String getFileName() {
		return dataFileName;
	}
	
	public void setKeySeprator(char c) {
		keySeperator = c;
	}

	private String isolateStringKey(String s) {
		String key = "";
		for (char c : s.toCharArray()) {
			if (c == keySeperator) {
				break;
			}
			key+=c;
		}
		return key;
	}
	
	private int getSeperatorIndex(String s) {
		for (int i = 0; i < s.toCharArray().length; i++) {
			char c = s.charAt(i);
			if (c == keySeperator) {
				return i;
			}
		}
		return -1;
	}

}
