package com.munimdibosh.shitcleaner.models;

import java.io.File;

public class SCFile extends File{

	boolean isSelected = false;
	public SCFile(String pathname) {
		super(pathname);
	}
	
	public boolean isSelected() {
		return isSelected;
	}
	
	public void setSelected(boolean flag) {
		isSelected = flag;
	}

}
