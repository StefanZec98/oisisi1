package controlleri;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import modeli.BazaPredmeta;
import modeli.BazaProfesora;
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
	    	
	    	Predmet predmet = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
			BazaPredmeta.getInstance().izbrisiPredmet(predmet.getSifra_predmeta());
			
			PredmetiJtable.azurirajPrikaz();
	    }
	  
	  
	  
	  public void izmeniPredmet(int rowSelectedIndex,String sifra,String naziv,Integer semestar,Integer godina) {
			if (rowSelectedIndex < 0) {
				return;
			}
			
			BazaPredmeta.getInstance().izmeniPredmet(sifra,naziv,semestar,godina,null,new ArrayList<Student>());
			
			
			
			PredmetiJtable.azurirajPrikaz();
		}
	  
	  
	  public void dodavanjeStudentaNaPredmet(String index,int rowSelectedIndex) {
		  
		 Student s= BazaStudenta.getInstance().getStudentPrekoIndexa(index);
		  if(s!=null) {
		  
		 
		 
		Predmet p = BazaPredmeta.getInstance().getRow(rowSelectedIndex);
		
		
		BazaStudenta.getInstance().getStudentPrekoIndexa(index).dodajPredmetNaStudenta(p);
		BazaPredmeta.getInstance().dodajStudentaNaPredmet(s, p);
		
		
		  }
	  }
	  
	  public void brisanjeStudentaSaPredmeta(String index,int rowSelectedIndex) {
		  Student s= BazaStudenta.getInstance().getStudentPrekoIndexa(index);
		  if(s!=null) {
			  
			  BazaPredmeta.getInstance().getRow(rowSelectedIndex).obrisiStudentaSaPredmeta(s);
			  BazaStudenta.getInstance().getStudentPrekoIndexa(index).obirisiPredmet(BazaPredmeta.getInstance().getRow(rowSelectedIndex));
			  
			  
		  }
	  }
	  
	  public void dodavanjeProfesoraNaPredmet(Profesor profesor,int rowSelectedIndex) {

          if(BazaPredmeta.getInstance().getRow(rowSelectedIndex).getPredmetni_profesor()==null) {

              BazaPredmeta.getInstance().getRow(rowSelectedIndex).setPredmetni_profesor(profesor);
              BazaProfesora.getInstance().getProfesor(profesor.getBroj_licne_karte()).
              								dodavanjePredmeta( BazaPredmeta.getInstance().getRow(rowSelectedIndex));
             
              PredmetiJtable.azurirajPrikaz();
          }else {

              JOptionPane.showMessageDialog(new JFrame(), "Na tom predmetu se vec nalazi profesor !", "Greska!",
                     JOptionPane.INFORMATION_MESSAGE);
             return;

          }
  }
	  
	  
	  
	  
	  public void obrisiProfesoraSaPredmeta(int rowSelectedIndex) {

          if(BazaPredmeta.getInstance().getRow(rowSelectedIndex).getPredmetni_profesor()!=null){
        	  
        	  
        	  try {
        	  		Profesor profesor=BazaPredmeta.getInstance().getRow(rowSelectedIndex).getPredmetni_profesor();
        	  		
        	  		
        	  for(Predmet p : BazaPredmeta.getInstance().getRow(rowSelectedIndex).getPredmetni_profesor().getPredmetiSpisak()) {
        		  
        		  		if(p.getSifra_predmeta().equals(BazaPredmeta.getInstance().getRow(rowSelectedIndex).getSifra_predmeta())) {
        		  					profesor.obrisiPredmet(p,rowSelectedIndex);
        		  		}
        		  
        	  }
        	  
        	  
        	  
              BazaPredmeta.getInstance().getRow(rowSelectedIndex).setPredmetni_profesor(null);
              PredmetiJtable.azurirajPrikaz();

        	  } catch (Exception e) {
				
			}
              
          }else {

              JOptionPane.showMessageDialog(new JFrame(), "Na tom predmetu nema profesora !", "Greska!",
                      JOptionPane.INFORMATION_MESSAGE);
              return;

          }

  } 
	  
	  
	  
	  public static void pronadjiPredmet(String nazPred, String sifraPredm) {

			
			ArrayList<Predmet> predmetiPretrazeni=new ArrayList<Predmet>();
			
			
			
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti2()) {
					
					if(p.getSifra_predmeta().equals(sifraPredm) && p.getNaziv_predmeta().equals(nazPred)) {
						predmetiPretrazeni.add(p);
						
						
						System.out.println(p.getNaziv_predmeta());
					}
					
					
				}		
				
				BazaPredmeta.getInstance().setPredmeti(predmetiPretrazeni);
			
				PredmetiJtable.azurirajPrikaz(); 
	  
	  }
	  
	
	
}