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






public class PredmetiJtable extends JTable{
	
	
	private static final long serialVersionUID = 8900651367165240112L;
	

	public static AbstractTableModel predmetModel;
	public static JTable tabelaPredmeta;
	public static int rowSelectedIndex = -1;
	public static JTable predmeti;
	
	public PredmetiJtable() {
		this.setRowSelectionAllowed(true);
		this.setColumnSelectionAllowed(true);
		this.getTableHeader().setReorderingAllowed(false);
		this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		this.setModel(new AbstractTableModelPredmeti());
		
		new ButtonColumnStudenti(this, 5);
		
		predmetModel=(AbstractTableModel) this.getModel();
		
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
	
	
	public static void azurirajPrikaz() {
		predmetModel.fireTableDataChanged();
		rowSelectedIndex=-1;
	}
	
	
	public void sort() {


  	  TableRowSorter<AbstractTableModel> sorter =
  	  new TableRowSorter<AbstractTableModel>(predmetModel);
  	  this.setRowSorter(sorter);

  	  }
	
	
	
	public static void pronadjiPredmet(String nazPred, String sifraPredm) {



        TableRowSorter<AbstractTableModel> sorter=new TableRowSorter<AbstractTableModel>(predmetModel);
        predmeti = new JTable(predmetModel);
        predmeti.setRowSorter(sorter);






      for (int i = 0; i < predmeti.getRowCount(); i++) {

          if (!predmeti.getValueAt(i, 0).equals(sifraPredm) && !predmeti.getValueAt(i, 1).equals(nazPred)) {
              sorter.setRowFilter(RowFilter.regexFilter("^" + nazPred + "$")); // da bi izbegli pronalazenje
                                                                                  // predmeta sa nazivom koji se
                                                                                  // sadrzi u nekom drugom nazivu

          }

      }



     



      /*  //System.out.println(nazPred + sifraPredm);

        /JTable tabela=new JTable(predmetModel);
        TableRowSorter<AbstractTableModel> tr=new TableRowSorter<AbstractTableModel>(predmetModel);
        tabela.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(nazPred + sifraPredm));

        System.out.println(nazPred + sifraPredm);/ */


    }
	
	
	
	
	
	
}