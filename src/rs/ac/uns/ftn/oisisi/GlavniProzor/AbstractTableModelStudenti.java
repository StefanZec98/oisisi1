package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.util.ArrayList;
import java.util.List;


import javax.swing.table.AbstractTableModel;

import modeli.BazaStudenta;

public class AbstractTableModelStudenti extends AbstractTableModel {

	private static final long serialVersionUID = 2710362894062472488L;

	
	@Override
	public int getRowCount() {
		return BazaStudenta.getInstance().getStudenti().size();
	}

	@Override
	public int getColumnCount() {
		return BazaStudenta.getInstance().getColumnCount();
	}



	@Override
	public Object getValueAt(int row, int col) {
		return BazaStudenta.getInstance().getValueAt(row, col);
	}



	@Override
	public String getColumnName(int column) {
		return BazaStudenta.getInstance().getColumnName(column);
	}
}