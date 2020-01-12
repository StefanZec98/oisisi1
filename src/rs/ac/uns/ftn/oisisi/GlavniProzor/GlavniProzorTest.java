package rs.ac.uns.ftn.oisisi.GlavniProzor;


import java.io.FileNotFoundException;
import java.io.IOException;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenta;


public class GlavniProzorTest {

	public static void main(String[] args) throws FileNotFoundException, IOException{
	
	
		BazaStudenta.getInstance().ucitavanjeListe("Student_File.txt");
		BazaPredmeta.getInstance().ucitavanjeListe("Predmet_fajl.txt");
		BazaProfesora.getInstance().ucitavanjeListe("Profesor_fajl.txt");
		
		 MainFrame mf = MainFrame.getInstance();
		 mf.setVisible(true); 
		
		
		

	}

}
