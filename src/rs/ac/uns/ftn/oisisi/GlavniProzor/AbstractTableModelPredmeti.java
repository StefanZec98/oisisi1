package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.table.AbstractTableModel;

import modeli.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {
private static final long serialVersionUID = 8454002200965331257L;
	
	public AbstractTableModelPredmeti() {
		BazaPredmeta.getInstance();
	}
	

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount(); 
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		return BazaPredmeta.getInstance().getValueAt(row, column);
	}
	
	@Override
	public String getColumnName(int column) {
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	

}