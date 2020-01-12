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
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("ime")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 0);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("prezime")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 1);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("datum_rodjenja")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 2);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("adresa")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 3);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("kontakt_telefon")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 4);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("e_mail")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 5);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("adresa_kancelarije")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 6);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("br_licne_karte")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 7);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("titula")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 8);
			listaRowFiltera.add(rowfilter);					
			}catch (java.util.regex.PatternSyntaxException e) {
				return;
			
				}		
		
		
		}
		
		
		if(splitovani_stringovi2[0].equalsIgnoreCase("zvanje")) {
			try {
				
			rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 9);
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