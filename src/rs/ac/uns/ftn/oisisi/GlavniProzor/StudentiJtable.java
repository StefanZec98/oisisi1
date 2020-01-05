package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;





public class StudentiJtable extends JTable{


private static final long serialVersionUID = 8900651367165240112L;


public static JTable TabelaStudenata;
public static AbstractTableModel modelStudenta;
public static int rowSelectedIndex = -1;

public StudentiJtable() {
	
	
this.setRowSelectionAllowed(true);
this.setColumnSelectionAllowed(true);
this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
this.getTableHeader().setReorderingAllowed(false);
this.setModel(new AbstractTableModelStudenti());

modelStudenta = (AbstractTableModel) this.getModel();

this.addMouseListener(new MouseAdapter() {
@Override
public void mouseReleased(MouseEvent e) {
	TabelaStudenata = (JTable) e.getComponent();
	if(TabelaStudenata.getSelectedRow()!=-1) {
		rowSelectedIndex = TabelaStudenata.convertRowIndexToModel(TabelaStudenata.getSelectedRow());
	}

}
});

sort();

}


@Override
public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
Component c = super.prepareRenderer(renderer, row, column);
// selektovani red ce imati drugaciju boju od ostalih
if (isRowSelected(row)) {
c.setBackground(Color.LIGHT_GRAY);
} else {
c.setBackground(Color.WHITE);
}
return c;
}


public void sort() {


TableRowSorter<AbstractTableModel> sorter =
new TableRowSorter<AbstractTableModel>(modelStudenta);
this.setRowSorter(sorter);

}

public static  void azurirajPrikaz() {
	
	modelStudenta.fireTableDataChanged();
	rowSelectedIndex=-1;
	
	
	
}


}