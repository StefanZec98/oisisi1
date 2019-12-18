package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Dimension;

import javax.swing.JFrame;
import java.awt.*;


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
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
		MenuBar meniBar = new MenuBar();
		add(meniBar,BorderLayout.NORTH);
	    
	 }
}










