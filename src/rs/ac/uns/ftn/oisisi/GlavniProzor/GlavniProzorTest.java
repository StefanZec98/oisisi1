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
	
		BazaStudenta.getInstance();
		BazaProfesora.getInstance();
		StudentKontroler.getInstance();
		ProfesorKontroler.getInstance();
		BazaPredmeta.getInstance();
		PredmetKontroler.getInstance();

		
		BazaPredmeta.getInstance().ucitavanjeListe("moj_prvi_fajl.txt");
		
		
		 MainFrame mf = new MainFrame();
		 mf.setVisible(true); 
		
		
		

	}

}
