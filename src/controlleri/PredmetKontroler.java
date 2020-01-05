package controlleri;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modeli.BazaPredmeta;
import modeli.BazaStudenta;
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
	
	
	public void dodajPredmet(String sifra,String naziv,Integer semestar,Integer godina) {
		
		
					BazaPredmeta.getInstance().dodajPredmet(sifra, naziv, semestar, godina, null, new ArrayList<Student>());
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
	  
	  
	  
	  public void izmeniPredmet(int rowSelectedIndex,String sifra,String naziv,Integer semestar,Integer godina) {
			if (rowSelectedIndex < 0) {
				return;
			}
			// izmena modela
			//Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
			BazaPredmeta.getInstance().izmeniPredmet(sifra,naziv,semestar,godina,null,new ArrayList<Student>());
			// TODO: izmena dodatnih polja modela tabele
			
			// azuriranje prikaza
			PredmetiJtable.azurirajPrikaz();
		}
	  
	  
	  public void dodavanjeStudentaNaPredmet(String index,int rowSelectedIndex) {
		  
		 Student s= BazaStudenta.getInstance().getStudentPrekoIndexa(index);
		  if(s!=null) {
		  
		 
		 
		Predmet p = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		
		
		BazaStudenta.getInstance().getStudentPrekoIndexa(index).dodajPredmetNaStudenta(p);
		BazaPredmeta.getInstance().dodajStudentaNaPredmet(s, p);
		System.out.println(BazaPredmeta.getInstance().getRow(rowSelectedIndex).getSpisak_studenata().get(0).getIme());
		
		  }
	  }
	  public void dodavanjeProfesoraNaPredmet(Profesor profesor,int rowSelectedIndex) {

          if(BazaPredmeta.getInstance().getRow(rowSelectedIndex).getPredmetni_profesor()==null) {

              BazaPredmeta.getInstance().getRow(rowSelectedIndex).setPredmetni_profesor(profesor);
              PredmetiJtable.azurirajPrikaz();
          }else {

              JOptionPane.showMessageDialog(new JFrame(), "Na tom predmetu se vec nalazi profesor !", "Greska!",
                     JOptionPane.INFORMATION_MESSAGE);
             return;

          }
  }
	  
	  public void obrisiProfesoraSaPredmeta(int rowSelectedIndex) {

          if(BazaPredmeta.getInstance().getRow(rowSelectedIndex).getPredmetni_profesor()!=null){

              BazaPredmeta.getInstance().getRow(rowSelectedIndex).setPredmetni_profesor(null);
              PredmetiJtable.azurirajPrikaz();

          }else {

              JOptionPane.showMessageDialog(new JFrame(), "Na tom predmetu nema profesora !", "Greska!",
                      JOptionPane.INFORMATION_MESSAGE);
              return;

          }

  }
	  
	  
	  
	
	
	
}