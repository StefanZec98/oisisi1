package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.JButton;
import javax.swing.table.AbstractTableModel;

import modeli.BazaProfesora;

public class AbstractTableModelProfesora extends AbstractTableModel {
	
private static final long serialVersionUID = 2710362894062472488L;

public static String kolonaPredmeti = "PREDMETI";

	
	@Override
	public int getRowCount() {
		return BazaProfesora.getInstance().getProfesori().size();
	}

	@Override
	public int getColumnCount() {
		return BazaProfesora.getInstance().getColumnCount()+1;
	}



	@Override
	public Object getValueAt(int row, int col) {
		
		if(col <=9) {
		return BazaProfesora.getInstance().getValueAt(row, col);
		}else if(col==10){
			
			JButton btn = new JButton("" + row);
            return btn;
		}
		return null;
	}

	
	

	@Override
	public String getColumnName(int column) {
		 if (column >= BazaProfesora.getInstance().getColumnCount()) {
	            return kolonaPredmeti;
	        }
		
		return BazaProfesora.getInstance().getColumnName(column);
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
            return String.class;
        case 10:
            return JButton.class;
        default:
            return null;
        }
    }
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex >= 10;
    }
	
	

}