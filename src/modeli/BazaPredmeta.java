package modeli;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
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




private List<Predmet> predmeti2;

public BazaPredmeta() {
generator = 0;



this.kolone = new ArrayList<String>();
this.kolone.add("SIFRA");
this.kolone.add("NAZIV");
this.kolone.add("SEMESTAR");
this.kolone.add("GODINA");
this.kolone.add("PROFESOR");
//this.kolone.add("STUDENTI");

initPredmeti();



}


private void initPredmeti() {
this.predmeti = new ArrayList<Predmet>();
this.predmeti2 = new ArrayList<Predmet>();
//igraci.add(new Igrac(generateId(), "Mika", "Mikic", "Crvena Zvezda"));

//Profesor profesor1=new Profesor("MArko", "prezime", "datum_rodjenja", "adresa_stanovanja",
//06454444444, "e_mail", "adresa_kancelarije", 203, "titula", "zvanje", null);      

//String ime=profesor1.getIme();
//String prezime=profesor1.getPrezime();

predmeti.add(new Predmet("012a", "naziv_predmeta", 1, 1,null,new  ArrayList<Student>()));
predmeti2.add(new Predmet("012a", "naziv_predmeta", 1, 1,null,new  ArrayList<Student>()));

}


public List<Predmet> getPredmeti() {
return predmeti;
}


public List<Predmet> getPredmeti2() {
return predmeti2;
}


public void setPredmeti(List<Predmet> predmeti) {
this.predmeti = predmeti;
}


public void setPredmeti2(List<Predmet> predmeti) {
this.predmeti2 = predmeti;
}


private long generateId() {
return ++generator;
}

public int getColumnCount() {
return 5;
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
return Integer.toString(predmet.getSemestar());
case 3:
return Integer.toString(predmet.getGodina_studija());
case 4:
	if(predmet.getPredmetni_profesor()==null) {
        return "Predmet nema profesora";
    }else {
    return   "Licna karta: " + Long.toString(predmet.getPredmetni_profesor().getBroj_licne_karte());
    }

default:
return "";
}
}



public ArrayList<Student> getListaStudenata(Predmet predmet){

return predmet.getSpisak_studenata();


}

public void dodajStudentaNaPredmet(Student s,Predmet p1) {
	for (Predmet p : predmeti) {
		if(p.getSifra_predmeta().equals(p1.getSifra_predmeta())) {
			p.dodajStudentaNaPredmet(s);
			
		}
			
	}
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
	
	
	for (Predmet p : predmeti2) {
		if(p.getSifra_predmeta().equals(sifra)) {
			
			
			JOptionPane.showMessageDialog(new JFrame(), "Dodajete predmet sa vec postojecom sifrom!", "Greska!",          
				       JOptionPane.ERROR_MESSAGE);
				
			return;
		}
		
	}
	
	
this.predmeti.add(new Predmet(sifra,naziv,semestar,godina,profesor,studenti));
this.predmeti2.add(new Predmet(sifra,naziv,semestar,godina,profesor,studenti));
}

public void izbrisiPredmet(String naziv) {
for (Predmet i : predmeti) {
if (i.getSifra_predmeta().equals(naziv)) {
predmeti.remove(i);
break;
}
}


for (Predmet i : predmeti2) {
if (i.getSifra_predmeta().equals(naziv)) {
predmeti2.remove(i);
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


for (Predmet i : predmeti2) {
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


  /*public static void upisPredmeta_u_Fajl(String file,List<Predmet> predmeti) {
	
		for (Predmet predmet : predmeti) {
			
			save("moj_fajl.txt",predmet);
			
		}
	
	
}*/


/*public  static void save(String file, Predmet o){
	ObjectOutputStream out = null;
	try {
		out = new ObjectOutputStream(new FileOutputStream(file));
		
		 
		out.writeObject(o);
		
		System.out.println(o.getNaziv_predmeta());
	} catch (Exception e) {
		e.printStackTrace();
    } finally {
        if(out != null){
            try {
                out.close();
            } catch (Exception e) {
    			e.printStackTrace();
            }
        }
    }
}*/



/*public static void Ucitavanje(String file) throws FileNotFoundException, IOException {
	
	ObjectInputStream ois=new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
	
	
	
	try {
		List<Predmet>listaPredmeta=new ArrayList<Predmet>();
		
		while(true) {
			Predmet p;
			p=(Predmet) ois.readObject();
			listaPredmeta.add(p);
			//BazaPredmeta.getInstance().dodajPredmet(p.getSifra_predmeta(), p.getNaziv_predmeta(),
					//p.getSemestar(), p.getGodina_studija(), p.getPredmetni_profesor(), p.getSpisak_studenata());
			BazaPredmeta.getInstance().setPredmeti(listaPredmeta);
		
			
		}
	}catch (Exception e) {
		// TODO: handle exception
	}finally {
		ois.close();
	}
	
}*/








	
}
