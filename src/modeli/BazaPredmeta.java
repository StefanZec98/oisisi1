package modeli;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;




public class BazaPredmeta  {

/**
*
*/
private static final long serialVersionUID = 10909000990L;

private static BazaPredmeta instance = null;

public static BazaPredmeta getInstance() {
if (instance == null) {
instance = new BazaPredmeta();
}
return instance;
}

private long generator;

private List<Predmet> predmeti;
public List<String> kolone;


public BazaPredmeta() {
generator = 0;



this.kolone = new ArrayList<String>();
this.kolone.add("SIFRA");
this.kolone.add("NAZIV");
this.kolone.add("SEMESTAR");
this.kolone.add("GODINA");
this.kolone.add("PROFESOR");
this.kolone.add("STUDENTI");

initPredmeti();



}


private void initPredmeti() {
this.predmeti = new ArrayList<Predmet>();
//igraci.add(new Igrac(generateId(), "Mika", "Mikic", "Crvena Zvezda"));

//Profesor profesor1=new Profesor("MArko", "prezime", "datum_rodjenja", "adresa_stanovanja",
//06454444444, "e_mail", "adresa_kancelarije", 203, "titula", "zvanje", null);      

//String ime=profesor1.getIme();
//String prezime=profesor1.getPrezime();

Profesor profesor=new Profesor("MArko", "Markovic", "datum_rodjenja",
		"adresa_stanovanja", 00002, "e_mail", "dresa_kancelarije", 
		00023443, "titula", "zvanje", null);

predmeti.add(new Predmet("012a", "naziv_predmeta", 1, 1,profesor, null));

}


public List<Predmet> getPredmeti() {
return predmeti;
}

public void setPredmeti(List<Predmet> predmeti) {
this.predmeti = predmeti;
}

private long generateId() {
return ++generator;
}

public int getColumnCount() {
return 6;
}

public String getColumnName(int index) {
return this.kolone.get(index);
}

public Predmet getRow(int rowIndex) {
return this.predmeti.get(rowIndex);
}




public String getValueAt(int row, int column) {
Predmet predmet = this.predmeti.get(row);
switch (column) {
case 0:
return predmet.getSifra_predmeta();
case 1:
return predmet.getNaziv_predmeta();
case 2:
return  Integer.toString(predmet.getSemestar());
case 3:
return  Integer.toString(predmet.getGodina_studija());
case 4:
	
	if(predmet.getPredmetni_profesor()==null) {
		return "Predmet nema profesora";
	}else {
	return   "Licna karta: " + Long.toString(predmet.getPredmetni_profesor().getBroj_licne_karte());
	}

case 5:
  return "";
default:
return null;
}
}



public ArrayList<Student> getListaStudenata(Predmet predmet){

return predmet.getSpisak_studenata();


}


public void dodajPredmet(String sifra, String naziv, Integer semestar,
Integer godina, Profesor profesor,ArrayList<Student>studenti) {

	for (Predmet p : predmeti) {
		if(p.getSifra_predmeta().equals(sifra)) {
			
			
			JOptionPane.showMessageDialog(new JFrame(), "Dodajete predmet sa vec postojecom sifrom!", "Greska!",          
				       JOptionPane.ERROR_MESSAGE);
				
			return;
		}
		
	}
	
	
this.predmeti.add(new Predmet(sifra,naziv,semestar,godina,profesor,studenti));

	for (Predmet p : predmeti) {
			if(p.getSifra_predmeta().equals(sifra)) {
				//System.out.println(p.getNaziv_predmeta());
			}
	}
}

public void izbrisiPredmet(String naziv) {
for (Predmet i : predmeti) {
if (i.getSifra_predmeta().equals(naziv)) {
predmeti.remove(i);
break;
}
}
}

public void izmeniPredmet(String sifra, String naziv, Integer semestar,
Integer godina, Profesor profesor,ArrayList<Student>studenti) {
for (Predmet i : predmeti) {
if (i.getSifra_predmeta().equals(sifra)) {
i.setSifra_predmeta(sifra);
i.setNaziv_predmeta(naziv);
i.setSemestar(semestar);
i.setGodina_studija(godina);
i.setPredmetni_profesor(profesor);
i.setSpisak_studenata(studenti);
}
}
}





}
