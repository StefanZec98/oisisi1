package rs.ac.uns.ftn.oisisi.GlavniProzor;

import controlleri.ProfesorKontroler;
import controlleri.StudentKontroler;
import modeli.BazaProfesora;
import modeli.BazaStudenta;

public class GlavniProzorTest {

	public static void main(String[] args) {
	
		BazaStudenta.getInstance();
		BazaProfesora.getInstance();
		StudentKontroler.getInstance();
		ProfesorKontroler.getInstance();

		
		 MainFrame mf = new MainFrame();
		 mf.setVisible(true); // Prozor je inicijalno nevidljiv
		
		
		

	}

}
