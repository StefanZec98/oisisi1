package rs.ac.uns.ftn.oisisi.GlavniProzor;

import controlleri.PredmetKontroler;
import controlleri.ProfesorKontroler;
import controlleri.StudentKontroler;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenta;

public class GlavniProzorTest {

	public static void main(String[] args) {
	
		BazaStudenta.getInstance();
		BazaProfesora.getInstance();
		StudentKontroler.getInstance();
		ProfesorKontroler.getInstance();
		BazaPredmeta.getInstance();
		PredmetKontroler.getInstance();

		
		 MainFrame mf = new MainFrame();
		 mf.setVisible(true); // Prozor je inicijalno nevidljiv
		
		
		

	}

}
