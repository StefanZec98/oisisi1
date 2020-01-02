package controlleri;

import java.util.ArrayList;

import modeli.BazaPredmeta;
import modeli.Predmet;
import modeli.Profesor;
import modeli.Student;
import rs.ac.uns.ftn.oisisi.GlavniProzor.PredmetiJtable;


public class PredmetKontroler {


	private static PredmetKontroler instance = null;
	
	
	public static PredmetKontroler getInstance() {
		if (instance == null) {
			instance = new PredmetKontroler();
		}
		return instance;
	}
	
	public PredmetKontroler() {}
	
	
	public void dodajPredmet(String sifra,String naziv,String semestar,String godina) {
		
		
					BazaPredmeta.getInstance().dodajPredmet(sifra, naziv, semestar, godina, null, null);
					PredmetiJtable.azurirajPrikaz();
					
	}
	
	
	
	  public void IzbrisiPredmet(int rowSelectedIndex) {
	    	
		 
		  if (rowSelectedIndex < 0) {
				return;
			}
	    	// izmena modela
	    	Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
			BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifra_predmeta());
			// azuriranje prikaza
			PredmetiJtable.azurirajPrikaz();
	    }
	  
	  
	  
	  public void izmeniPredmet(int rowSelectedIndex) {
			if (rowSelectedIndex < 0) {
				return;
			}
			// izmena modela
			Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
			BazaPredmeta.getInstance().izmeniPredmet(predmet.getSifra_predmeta(),"njee", "njee",
					"njee", null,null);
			// TODO: izmena dodatnih polja modela tabele
			
			// azuriranje prikaza
			PredmetiJtable.azurirajPrikaz();
		}
	  
	  
	  
	
	
	
}