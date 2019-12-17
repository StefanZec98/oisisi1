package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.JFrame;

public class GlavniProzorTest {

	public static void main(String[] args) {
	
		String param1 = args[0];
		JFrame mainFrame = null;
		
		if (args.length != 0) {
		
		mainFrame = new GlavniProzor(param1);
		
		}
		

	}

}
