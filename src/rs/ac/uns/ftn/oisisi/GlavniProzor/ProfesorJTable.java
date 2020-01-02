package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;





public class ProfesorJTable extends JTable{


private static final long serialVersionUID = 8900651367165240112L;


public static JTable tabelaProfesora;
public static AbstractTableModel modelProfesora;
public static int rowSelectedIndex = -1;

public ProfesorJTable() {
	
	
this.setRowSelectionAllowed(true);
this.setColumnSelectionAllowed(true);
this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
this.getTableHeader().setReorderingAllowed(false);
this.setModel(new AbstractTableModelProfesora());

modelProfesora = (AbstractTableModel) this.getModel();

this.addMouseListener(new MouseAdapter() {
@Override
public void mouseReleased(MouseEvent e) {
	tabelaProfesora = (JTable) e.getComponent();
	if(tabelaProfesora.getSelectedRow()!=-1) {
		rowSelectedIndex = tabelaProfesora.convertRowIndexToModel(tabelaProfesora.getSelectedRow());
	}

}
});



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
	
	modelProfesora.fireTableDataChanged();
	//rowSelectedIndex=-1;
	
	
	
}


}