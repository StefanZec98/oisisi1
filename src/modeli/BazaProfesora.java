package modeli;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class BazaProfesora extends AbstractTableModel{

/**
*
*/
private static final long serialVersionUID = 10909000990L;

private static BazaProfesora instance = null;

public static BazaProfesora getInstance() {
if (instance == null) {
instance = new BazaProfesora();
}
return instance;
}

private long generator;

private List<Profesor> profesori;
public List<String> kolone;


public BazaProfesora() {
generator = 0;



this.kolone = new ArrayList<String>();
this.kolone.add("IME");
this.kolone.add("PREZIME");
this.kolone.add("DATUM_RODJENJA");
this.kolone.add("ADRESA");
this.kolone.add("KONTAKT_TELEFON");
this.kolone.add("E-MAIL");
this.kolone.add("ADRESA_KANCELARIJE");
this.kolone.add("BR_LICNE_KARTE");
this.kolone.add("TITULA");
this.kolone.add("ZVANJE");
this.kolone.add("SPISAK_PREDMETA");

initProfesori();



}


private void initProfesori() {
this.profesori = new ArrayList<Profesor>();
/*//igraci.add(new Igrac(generateId(), "Mika", "Mikic", "Crvena Zvezda"));

Profesor profesor1=new Profesor("MArko", "prezime", "datum_rodjenja", "adresa_stanovanja",
06454444444, "e_mail", "adresa_kancelarije", 203, "titula", "zvanje", null);      

String ime=profesor1.getIme();
String prezime=profesor1.getPrezime();

profesori.add(new Predmet("012a", "naziv_predmeta", "semestar", "godina_studija", ime + " " + prezime, null));*/      

}


public List<Profesor> getProfesori() {
return profesori;
}

public void setProfesori(List<Profesor> profesori) {
this.profesori = profesori;
}

private long generateId() {
return ++generator;
}

public int getColumnCount() {
return 11;
}

public String getColumnName(int index) {
return this.kolone.get(index);
}

public Profesor getRow(int rowIndex) {
return this.profesori.get(rowIndex);
}


public String getValueAt(int row, int column) {
Profesor profesor = this.profesori.get(row);
switch (column) {
case 0:
return profesor.getIme();
case 1:
return profesor.getPrezime();
case 2:
return profesor.getDatum_rodjenja();
case 3:
return profesor.getAdresa_stanovanja();
case 4:
return Long.toString(profesor.getKontakt_telefon());
case 5:
return profesor.getE_mail();
case 6:
return profesor.getAdresa_kancelarije();
case 7:
return Long.toString(profesor.getBroj_licne_karte());
case 8:
return profesor.getTitula();
case 9:
return profesor.getZvanje();
case 10:
return "bla";//getListaPredmeta(profesor);
default:
return null;
}
}



public ArrayList<Predmet> getListaPredmeta(Profesor profesor){

return profesor.getPredmetiSpisak();


}


public void dodajProfesora(String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, long kontakt_telefon,
		String e_mail, String adresa_kancelarije, long broj_licne_karte, String titula, String zvanje,
		ArrayList<Predmet> predmetiSpisak) {
for (Profesor profesor : profesori) {
	if(Long.toString(profesor.getBroj_licne_karte()).equals(Long.toString(broj_licne_karte))) {
		
		return;
		}
		
	}

this.profesori.add(new Profesor(ime,prezime,datum_rodjenja,adresa_stanovanja,kontakt_telefon,e_mail,
adresa_kancelarije,broj_licne_karte,titula,zvanje,predmetiSpisak));
}

public void izbrisiProfesora(long licna_karta) {
for (Profesor i : profesori) {
if (i.getBroj_licne_karte()==licna_karta) {
profesori.remove(i);
break;
}
}
}

public void izmeniProfesora(String ime, String prezime, String datum_rodjenja,
String adresa_stanovanja,long kontakt_telefon,String e_mail,String adresa_kancelarije,
long broj_licne_karte,String titula,String zvanje,ArrayList<Predmet>predmetiSpisak){
for (Profesor i : profesori) {
if (i.getBroj_licne_karte()==broj_licne_karte) {
i.setIme(ime);
i.setPrezime(prezime);
i.setDatum_rodjenja(datum_rodjenja);
i.setAdresa_stanovanja(adresa_stanovanja);
i.setKontakt_telefon(kontakt_telefon);
i.setE_mail(e_mail);
i.setAdresa_kancelarije(adresa_kancelarije);
i.setTitula(titula);
i.setZvanje(zvanje);
i.setPredmetiSpisak(predmetiSpisak);

}
}
}


public Profesor getProfesor(long licna_karta) {
		for(Profesor profesor : profesori) {
			if(profesor.getBroj_licne_karte()==licna_karta) {
				return profesor;
			}
		}
		return null;
}

@Override
public int getRowCount() {
return BazaProfesora.getInstance().getProfesori().size();
}



}