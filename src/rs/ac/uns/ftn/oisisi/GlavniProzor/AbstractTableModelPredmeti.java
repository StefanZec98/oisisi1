package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import modeli.BazaPredmeta;

public class AbstractTableModelPredmeti extends AbstractTableModel {
private static final long serialVersionUID = 8454002200965331257L;

public static String kolonaStudenti = "STUDENTI";
	
	public AbstractTableModelPredmeti() {
		BazaPredmeta.getInstance();
	}
	

	@Override
	public int getColumnCount() {
		return BazaPredmeta.getInstance().getColumnCount()+1; 
	}

	@Override
	public int getRowCount() {
		return BazaPredmeta.getInstance().getPredmeti().size();
	}

	@Override
	public Object getValueAt(int row, int column) {
		if(column<=4) {
		return BazaPredmeta.getInstance().getValueAt(row, column);
		}else if(column==5) {
			JButton btn = new JButton("" + row);
			return btn;
		}
		return null;
	}
	
	@Override
	public String getColumnName(int column) {
		if (column >= BazaPredmeta.getInstance().getColumnCount()) {
			return kolonaStudenti;
		}
		return BazaPredmeta.getInstance().getColumnName(column);
	}
	@Override
	public Class<?> getColumnClass(int columnIndex) {
		switch (columnIndex) {
		case 0:
		case 1:
		case 2:
		case 3:
			
		case 4:
			return String.class;
		case 5:
			return JButton.class;
		default:
			return null;
		}
	}
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return columnIndex >= 5;
	}

	

}