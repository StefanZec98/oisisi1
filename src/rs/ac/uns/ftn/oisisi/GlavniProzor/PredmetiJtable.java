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







public class PredmetiJtable extends JTable{
	
	
	private static final long serialVersionUID = 8900651367165240112L;
	

	public static AbstractTableModelPredmeti predmetModel;
	public static JTable tabelaPredmeta;
	public static int rowSelectedIndex = -1;
	public static TableRowSorter<AbstractTableModelPredmeti>sortiranje;
	
	
	
	@SuppressWarnings("static-access")
	public PredmetiJtable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		this.predmetModel=new AbstractTableModelPredmeti();
		this.setModel(new AbstractTableModelPredmeti());
		
		new ButtonColumnStudenti(this, 5);
		
		predmetModel=(AbstractTableModelPredmeti) this.getModel();
		
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				tabelaPredmeta = (JTable)e.getComponent();
				if(tabelaPredmeta.getSelectedRow() != -1) {
					rowSelectedIndex = tabelaPredmeta.convertRowIndexToModel(tabelaPredmeta.getSelectedRow());		
				} 
			}	
		});
		
		
		sort();
		
		sortiranje=new TableRowSorter<AbstractTableModelPredmeti>(predmetModel);
		sortiranje.setSortable(4, false);
		sortiranje.setSortable(5, false);
		this.setRowSorter(sortiranje);
		
		
		
	}	
	
	
	@Override
	public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		Component c = super.prepareRenderer(renderer, row, column);
		
		if (isRowSelected(row)) {
			c.setBackground(Color.LIGHT_GRAY);
		} else {
			c.setBackground(Color.WHITE);
		}
		return c;
	}
	
	
	public static void azurirajPrikaz() {
		predmetModel.fireTableDataChanged();
		rowSelectedIndex=-1;
	}
	
	
	public void sort() {


  	  TableRowSorter<AbstractTableModel> sorter =
  	  new TableRowSorter<AbstractTableModel>(predmetModel);
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
			
			if(splitovani_stringovi2[0].equalsIgnoreCase("sifra")) {
				try {
					
				rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 0);
				listaRowFiltera.add(rowfilter);					
				}catch (java.util.regex.PatternSyntaxException e) {
					return;
				
					}		
			
			
			}
			
			
			if(splitovani_stringovi2[0].equalsIgnoreCase("naziv")) {
				try {
					
				rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 1);
				listaRowFiltera.add(rowfilter);					
				}catch (java.util.regex.PatternSyntaxException e) {
					return;
				
					}		
			
			
			}
			
			
			if(splitovani_stringovi2[0].equalsIgnoreCase("semestar")) {
				try {
					
				rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 2);
				listaRowFiltera.add(rowfilter);					
				}catch (java.util.regex.PatternSyntaxException e) {
					return;
				
					}		
			
			
			}
			
			
			if(splitovani_stringovi2[0].equalsIgnoreCase("godina")) {
				try {
					
				rowfilter=RowFilter.regexFilter(splitovani_stringovi2[1], 3);
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