package com.munimdibosh.shitcleaner.adapters;

import java.io.File;
import java.util.Collection;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import com.munimdibosh.shitcleaner.models.SCFile;
import com.munimdibosh.shitcleaner.utils.SCFileUtils;

public class SCFilesTableModel extends AbstractTableModel{
	public static final int CHECKBOX_INDEX = 0;
    public static final int NAME_INDEX = 1;
    public static final int LAST_VISITED_INDEX = 2;
    public static final int SIZE_INDEX = 3;
    public static final int PATH_INDEX = 4;
	String[] columnNames = {
			"",
            "Name",
            "Last Viewed/Modified",
            "Size",
            "Path"
            };
	
	protected Vector<SCFile> dataVector;
	
	public SCFilesTableModel(Collection<SCFile> files) {
		dataVector = new Vector<SCFile>(files);
	}

	public String getColumnName(int column) {
        return columnNames[column];
    }

    public boolean isCellEditable(int row, int column) {
       return false;
    }

    public Class getColumnClass(int column) {
        switch (column) {
            case NAME_INDEX:
            case LAST_VISITED_INDEX:
            case PATH_INDEX:
            case SIZE_INDEX:
               return String.class;
            case CHECKBOX_INDEX:
            	return Boolean.class;
        }
        
        return Object.class;
    }
	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return dataVector.size();
	}

	@Override
	public Object getValueAt(int row, int column) {
        SCFile record = (SCFile)dataVector.get(row);
        switch (column) {
	        case NAME_INDEX:
	           return record.getName();
	        case LAST_VISITED_INDEX:
	           return SCFileUtils.getLastAccessTime(record);
	        case SIZE_INDEX:
		           return SCFileUtils.getReadableSize(record);
	        case PATH_INDEX:
	           return record.getAbsolutePath();
	        case CHECKBOX_INDEX:
	        	return record.isSelected();
        }
        
        return null;
    }
	
	public void setValueAt(SCFile value, int row, int column) {
		dataVector.set(row, value);
        fireTableCellUpdated(row, column);
    }


}
