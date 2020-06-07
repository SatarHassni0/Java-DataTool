package me.satar.datatool;

import java.util.ArrayList;
import java.util.List;

public class DataFileManager {

	private List<DataFile> dataFiles = new ArrayList<>();
	
	public DataFileManager() {
		
	}
	
	public DataFile getDataFile(String fileName) {
		for (DataFile file : dataFiles) {
			if (file.getFileName().equals(fileName)) {
				return file;
			}
		}
		return null;
	}
	
	public void add(DataFile dataFile) {
		dataFiles.add(dataFile);
	}
	
	public void remove(DataFile dataFile) {
		dataFiles.remove(dataFile);
	}
}
