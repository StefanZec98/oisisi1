package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.List;
import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;



import controlleri.PredmetKontroler;
import controlleri.ProfesorKontroler;
import controlleri.StudentKontroler;

import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenta;
import modeli.Predmet;

public class GlavniProzorTest {

	public static void main(String[] args) throws FileNotFoundException, IOException{
	
	//	BazaStudenta.getInstance();
	//	BazaProfesora.getInstance();
	//	StudentKontroler.getInstance();
	//	ProfesorKontroler.getInstance();
	//	BazaPredmeta.getInstance();
	//	PredmetKontroler.getInstance();
	//	MainFrame.getInstance();

		BazaStudenta.getInstance().ucitavanjeListe("Student_File.txt");
		BazaPredmeta.getInstance().ucitavanjeListe("Predmet_fajl.txt");
		BazaProfesora.getInstance().ucitavanjeListe("Profesor_fajl.txt");
		
		 MainFrame mf = MainFrame.getInstance();
		 mf.setVisible(true); 
		
		
		

	}

}
