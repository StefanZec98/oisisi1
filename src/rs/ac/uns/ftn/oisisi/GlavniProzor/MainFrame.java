package rs.ac.uns.ftn.oisisi.GlavniProzor;


import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;

import modeli.BazaPredmeta;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


public class MainFrame extends JFrame {
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainFrame() {
	 super();
	
	 
	 Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int scrW = (int)screenSize.getWidth();
		int scrH = (int)screenSize.getHeight();
		
		int scrW1 =  (int) (scrW *0.75);
		int scrH1 =  (int) (scrH *0.75);
		
		setSize(scrW1 ,scrH1);
	 
	    setTitle("Studentska služba");
	    
	    setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
	   
		this.addWindowListener(new WindowAdapter() {
	    	
			
			@Override
			public void windowClosing(WindowEvent e) {
				
					int x=JOptionPane.showConfirmDialog(null, "Da li ste sigurni?"," Izlaz",JOptionPane.YES_NO_OPTION,
							JOptionPane.INFORMATION_MESSAGE);
					
					if(x==JOptionPane.YES_OPTION) {
						
						
						BazaPredmeta.getInstance().saveListe("moj_prvi_fajl.txt");
						
						
						
						e.getWindow().dispose();
					}
					
			}
	    	
		});
	    
	    
		setVisible(true);
		
		MenuBar meniBar = new MenuBar();
		setJMenuBar(meniBar);
		
		Toolbar toolbar = new Toolbar();
		add(toolbar,BorderLayout.NORTH);
		
		StatusBar statusBar = new StatusBar();
		add(statusBar,BorderLayout.SOUTH);
		
		
		Tabovi tab2=new Tabovi();
		add(tab2);
		
		
		
		
		
		
		
	    
	 }
}










