package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

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

public static void FilterPrikaza(String pretraga) {
	
	RowFilter<Object,Object>rowfilter=null;
	List<RowFilter<Object,Object>>listaRowFiltera=new ArrayList<>();
	
	String[] splitovani_stringovi;
	String [] splitovani_stringovi2;
	
	if(pretraga.contains(";")) {
		splitovani_stringovi=pretraga.split("\\;");
	}else {
		splitovani_stringovi=new String[1];
		splitovani_stringovi[0]=pretraga;
		
	}
	
for(int i=0; i<splitovani_stringovi.length; i++) {
		
		splitovani_stringovi2=splitovani_stringovi[i].split(":");
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("index")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 0);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("ime")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 1);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("prezime")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 2);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("trenutna_godina")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 3);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("status")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 4);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("prosek")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 5);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("datum_rodjenja")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 6);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("adresa")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 7);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("broj_telefona")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 8);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("email")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 9);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("datum_upisa")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 10);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
			
}

rowfilter=RowFilter.andFilter(listaRowFiltera);
sortiranje.setRowFilter(rowfilter);
	
}


}