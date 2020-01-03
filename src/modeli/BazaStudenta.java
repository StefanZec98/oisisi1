package modeli;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;




public class BazaStudenta extends AbstractTableModel {

/**
*
*/
private static final long serialVersionUID = 1022909000990L;

private static BazaStudenta instance = null;

public static BazaStudenta getInstance() {
if (instance == null) {
instance = new BazaStudenta();
}
return instance;
}

private long generator;

private List<Student> studenti;
public List<String> kolone;


public BazaStudenta() {
generator = 0;



this.kolone = new ArrayList<String>();
this.kolone.add("INDEX");
this.kolone.add("IME");
this.kolone.add("PREZIME");
this.kolone.add("GODINA STUDIJA");
this.kolone.add("STATUS");
this.kolone.add("PROSEK");
this.kolone.add("DATUM RODJENJA");
this.kolone.add("ADRESA STANOVANJA");
this.kolone.add("BROJ TELEFONA");
this.kolone.add("EMAIL ADRESA");
this.kolone.add("DATUM UPISA");
this.kolone.add("PREDMETI");


initStudenti();



}


private void initStudenti() {
this.studenti = new ArrayList<Student>();
//igraci.add(new Igrac(generateId(), "Mika", "Mikic", "Crvena Zvezda"));

Student student1=new Student("Nemanja", "Dragutinovic", "9.10.1998", "Vladike Maksima 16",
06454444444, "nemanjadragutinovic54@gmail.com", "RA159-2017","1.6.2017",3,Status.B, (float) 7.1,null);

 

studenti.add(student1);


}


public List<Student> getStudenti() {
return studenti;
}

public void setStudenti(List<Student> studenti) {
this.studenti = studenti;
}

private long generateId() {
return ++generator;
}

public int getColumnCount() {
return 12;
}

public String getColumnName(int index) {
return this.kolone.get(index);
}

public Student getRow(int rowIndex) {
return this.studenti.get(rowIndex);
}




public String getValueAt(int row, int column) {
Student student = this.studenti.get(row);
switch (column) {
case 0:
return student.getBroj_indexa();
case 1:
return student.getIme();
case 2:
return student.getPrezime();
case 3:
return Integer.toString(student.getTrenutna_godina_studija());
case 4:
return student.getStatus().toString();
case 5:
return  Float.toString(student.getProsecna_ocena());
case 6:
return student.getDatum_rodjenja();
case 7:
return student.getAdresa_stanovanja();
case 8:
return Integer.toString(student.getBroj_telefona());
case 9:
return student.getEmail_adresa();
case 10:
return student.getDatum_upisa();
case 11:
 getListaPredmeta(student);
default:
return null;
}
}



public ArrayList<Predmet> getListaPredmeta(Student student){

return student.getPredmeti();


}


public void dodajStudenta(String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, int broj_telefona,
		String email_adresa, String broj_indexa, String datum_upisa, int trenutna_godina_studija, Status status,
		float prosecna_ocena, ArrayList<Predmet> predmeti) {

	for (Student s : studenti) {
		if(s.getBroj_indexa().equals(broj_indexa)) {
			
			JOptionPane.showMessageDialog(new JFrame(), "Studenti moraju da imaju razlicite indexe!", "Greska!",
			        JOptionPane.ERROR_MESSAGE);
			return;
		}
	}
	
this.studenti.add(new Student(ime,prezime,datum_rodjenja,adresa_stanovanja,broj_telefona,email_adresa,broj_indexa,datum_upisa,trenutna_godina_studija,status,prosecna_ocena,predmeti));
}

public void izbrisiStudenta(String naziv) {
for (Student i : studenti) {
if (i.getBroj_indexa().equals(naziv)) {
studenti.remove(i);
break;
}
}
}

public void izmeniStudenta(String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, int broj_telefona,
		String email_adresa, String broj_indexa, String datum_upisa, int trenutna_godina_studija, Status status,
		float prosecna_ocena, ArrayList<Predmet> predmeti) {
for (Student i : studenti) {
if (i.getBroj_indexa().equals(broj_indexa)) {
i.setIme(ime);
i.setPrezime(prezime);
i.setBroj_indexa(broj_indexa);
i.setDatum_rodjenja(datum_rodjenja);
i.setAdresa_stanovanja(adresa_stanovanja);
i.setBroj_telefona(broj_telefona);
i.setEmail_adresa(email_adresa);
i.setDatum_upisa(datum_upisa);
i.setTrenutna_godina_studija(trenutna_godina_studija);
i.setStatus(status);
i.setProsecna_ocena(prosecna_ocena);
i.setPredmeti(predmeti);
}
}
}


@Override
public int getRowCount() {
return BazaStudenta.getInstance().getStudenti().size();
}



}