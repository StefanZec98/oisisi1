package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JToggleButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;



public class Tabovi extends JTabbedPane {
	
	public static int pozicija=0;
	private static final long serialVersionUID = 6162048567980039381L;
	
	
	
	Tabovi(){
		
		
		
		ImageIcon icon = new ImageIcon("images/student-tab.jpg");
			
	    JTable tabela1 = new JTable(0,6);
	    		
		DefaultTableModel model = (DefaultTableModel) tabela1.getModel();
	    
	    model.addRow(new Object[]{"Indeks","Ime", "Prezime", "Godina studija","Status","Prosek"});
	    	
		this.addTab("Student",icon,tabela1);
		
		
		this.addChangeListener((ChangeListener) new ChangeListener() {
		    public void stateChanged(ChangeEvent e) {
		        
		       pozicija=getSelectedIndex(); 
		       //System.out.println("Tab: " + pozicija);
		    }
		});
		
		ImageIcon icon2 = new ImageIcon("images/teacher.jpg");
		JTable tabela2 = new JTable(0,3);
		
		DefaultTableModel model2 = (DefaultTableModel) tabela2.getModel();

	    model2.addRow(new Object[]{"Ime", "Prezime", "Datum rodjenja"});
		
		this.addTab("Profesor", icon2, tabela2);
		
        ImageIcon icon3 = new ImageIcon("images/predmeti.jpg");
		JTable tabela3 = new JTable(0,4);
		
		DefaultTableModel model3 = (DefaultTableModel) tabela3.getModel();

	    model3.addRow(new Object[]{"Sifra", "Naziv", "Semestar","Godina slusanja"});
		
		this.addTab("Predmeti", icon3, tabela3);
		
		
		
		
		
		
		
		
	}
	
	/*Tabovi(int i){}
	int getPozicija() {
		return pozicija;
	}*/
	

}
