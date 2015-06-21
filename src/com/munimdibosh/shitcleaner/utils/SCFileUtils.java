package com.munimdibosh.shitcleaner.utils;

import java.io.File;
import java.text.DecimalFormat;
import java.util.Collection;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import org.apache.commons.io.FileUtils;

import com.wordpress.jdevel.utils.JAccessTimeUnix;

public class SCFileUtils {
	
	public static File chooseFolder(JFrame parent) {
		File file = null;
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		if(fileChooser.showOpenDialog(parent) == JFileChooser.APPROVE_OPTION){
			file = fileChooser.getSelectedFile();
		}
		return file;
	}
	
	public static Collection<File> getAllFilesWithExtensions(File dir, String[] extensions) {
		return FileUtils.listFiles(dir, extensions, true);
	}
	
	public static Date getLastAccessTime(File file){
		return JAccessTimeUnix.getLastAccessTime(file);
	}
	
	public static String getReadableSize(File file){
		long size = file.getTotalSpace();
		if(size <= 0) return "0";
	    final String[] units = new String[] { "B", "kB", "MB", "GB", "TB" };
	    int digitGroups = (int) (Math.log10(size)/Math.log10(1024));
	    return new DecimalFormat("#,##0.#").format(size/Math.pow(1024, digitGroups)) + " " + units[digitGroups];
	}

}
