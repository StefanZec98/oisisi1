package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowFilter;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableRowSorter;





public class StudentiJtable extends JTable{


private static final long serialVersionUID = 8900651367165240112L;

public static AbstractTableModelStudenti studentModel;
public static JTable TabelaStudenata;
public static int rowSelectedIndex = -1;
public static TableRowSorter<AbstractTableModelStudenti>sortiranje;

@SuppressWarnings("static-access")
public StudentiJtable() {
	
	
this.setRowSelectionAllowed(true);
this.setColumnSelectionAllowed(true);
this.getTableHeader().setReorderingAllowed(false);
this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


this.studentModel=new AbstractTableModelStudenti();
this.setModel(new AbstractTableModelStudenti());

new ButtonColumnPredmeti(this, 11);

studentModel = (AbstractTableModelStudenti) this.getModel();

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

sortiranje=new TableRowSorter<AbstractTableModelStudenti>(studentModel);
sortiranje.setSortable(11, false);
this.setRowSorter(sortiranje);

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

public static  void azurirajPrikaz() {
	
	studentModel.fireTableDataChanged();
	rowSelectedIndex=-1;

}

public void sort() {


TableRowSorter<AbstractTableModel> sorter =
new TableRowSorter<AbstractTableModel>(studentModel);
this.setRowSorter(sorter);

}

public static void FilterPrikaza(String trazeno,int brojKolone) {
	
	RowFilter<?  super AbstractTableModelStudenti,? super Integer>rowfilter=null;
	
	try {
		rowfilter=RowFilter.regexFilter("^" + trazeno, brojKolone);
		
	}catch (java.util.regex.PatternSyntaxException e) {
		return;
	}

	sortiranje.setRowFilter(rowfilter);
	
	
}


}