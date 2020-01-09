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





public class ProfesorJTable extends JTable{


private static final long serialVersionUID = 8900651367165240112L;


public static JTable tabelaProfesora;
public static AbstractTableModelProfesora modelProfesora;
public static int rowSelectedIndex = -1;
public static TableRowSorter<AbstractTableModelProfesora>sortiranje;

public ProfesorJTable() {
	
	
this.setRowSelectionAllowed(true);
this.setColumnSelectionAllowed(true);
this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
this.getTableHeader().setReorderingAllowed(false);


this.modelProfesora=new AbstractTableModelProfesora();
this.setModel(new AbstractTableModelProfesora());

new ButtonColumnProfesori(this,10);

modelProfesora = (AbstractTableModelProfesora) this.getModel();

this.addMouseListener(new MouseAdapter() {
@Override
public void mouseReleased(MouseEvent e) {
	tabelaProfesora = (JTable) e.getComponent();
	if(tabelaProfesora.getSelectedRow()!=-1) {
		rowSelectedIndex = tabelaProfesora.convertRowIndexToModel(tabelaProfesora.getSelectedRow());
	}

}
});

sort();


sortiranje=new TableRowSorter<AbstractTableModelProfesora>(modelProfesora);
sortiranje.setSortable(10, false);

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

public void sort() {


TableRowSorter<AbstractTableModel> sorter =
new TableRowSorter<AbstractTableModel>(modelProfesora);
this.setRowSorter(sorter);

}

public static  void azurirajPrikaz() {
	
	modelProfesora.fireTableDataChanged();
	rowSelectedIndex=-1;
		
}


public static void FilterPrikaza(String trazeno,int brojKolone) {
	
	RowFilter<?  super AbstractTableModelProfesora,? super Integer>rowfilter=null;
	
	try {
		rowfilter=RowFilter.regexFilter("^" + trazeno, brojKolone);
		
	}catch (java.util.regex.PatternSyntaxException e) {
		return;
	}

	sortiranje.setRowFilter(rowfilter);
	
	
}




}