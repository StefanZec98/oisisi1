package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.BoxLayout;
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
	 
	    setTitle("Studentska slu�ba");
	    
	    setLocationRelativeTo(null);
		//setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
		MenuBar meniBar = new MenuBar();
		setJMenuBar(meniBar);
		
		Toolbar toolbar = new Toolbar();
		add(toolbar,BorderLayout.NORTH);
		
		StatusBar statusBar = new StatusBar();
		add(statusBar,BorderLayout.SOUTH);
		
		
	    
	 }
}










