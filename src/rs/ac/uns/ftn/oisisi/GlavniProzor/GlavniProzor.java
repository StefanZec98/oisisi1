package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

import java.awt.*;



public class GlavniProzor extends JFrame {

	private static final long serialVersionUID = 2516952964305708540L;
	

	public GlavniProzor(String param) {
		super();
		setTitle("Studentska služba");
		
		
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		int scrW = (int)screenSize.getWidth();
		int scrH = (int)screenSize.getHeight();
		
		
		int scrW1 =  (int) (scrW *0.75);
		int scrH1 =  (int) (scrH *0.75);
		
		
		setSize(scrW1 ,scrH1);
		
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		// postavljanje menadžera rasporeda
		if (param.equals("2a"))
			setLayout(new BorderLayout());
		else if (param.equals("2b"))
			setLayout(new BorderLayout(40, 40));

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
