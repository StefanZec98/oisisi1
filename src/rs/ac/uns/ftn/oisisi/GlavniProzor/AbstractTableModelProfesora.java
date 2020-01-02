package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.table.AbstractTableModel;

import modeli.BazaProfesora;

public class AbstractTableModelProfesora extends AbstractTableModel {
	
private static final long serialVersionUID = 2710362894062472488L;

	

	
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount();
	}



	@Override
	public Object getValueAt(int row, int col) {
		return BazaProfesora.getInstance().getValueAt(row, col);
	}



	@Override
	public String getColumnName(int column) {
		return BazaProfesora.getInstance().getColumnName(column);
	}

}
