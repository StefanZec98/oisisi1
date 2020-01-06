package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import modeli.BazaPredmeta;
import modeli.BazaStudenta;

public class AbstractTableModelStudenti extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;
	
	public static String kolonaPredmeti = "PREDMETI";
	
	public AbstractTableModelStudenti() {
		BazaStudenta.getInstance();
	}

	
	@Override
	public int getRowCount() {
		return BazaStudenta.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenta.getInstance().getColumnCount()+1;
	}



	@Override
	public Object getValueAt(int row, int col) {
		if(col<=10) {
		return BazaStudenta.getInstance().getValueAt(row, col);
		}else if(col==11) {
			JButton btn = new JButton("" + row);
			return btn;
		}
		return null;
	}



	@Override
	public String getColumnName(int column) {
		if (column >= BazaStudenta.getInstance().getColumnCount()) {
			return kolonaPredmeti;
		}
		return BazaStudenta.getInstance().getColumnName(column);
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
			return String.class;
		case 11:
			return JButton.class;
		default:
			return null;
		}
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 11;
	}
	
}