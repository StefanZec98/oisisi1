package modeli;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import rs.ac.uns.ftn.oisisi.GlavniProzor.MainFrame;









public class BazaPredmeta {

/**
*
*/
@SuppressWarnings("unused")
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


initPredmeti();



}


private void initPredmeti() {
this.predmeti = new ArrayList<Predmet>();

//predmeti.add(new Predmet("012a", "naziv_predmeta", 1, 1,null,new  ArrayList<Student>()));
//predmeti2.add(new Predmet("012a", "naziv_predmeta", 1, 1,null,new  ArrayList<Student>()));

}


public List<Predmet> getPredmeti() {
return predmeti;
}



public void setPredmeti(List<Predmet> predmeti) {
this.predmeti = predmeti;
}



@SuppressWarnings("unused")
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
    return   "Licna karta: " + Long.toString(predmet.getPredmetni_profesor().getBroj_licne_karte())  
    			+ ", " + predmet.getPredmetni_profesor().getIme() + " " + predmet.getPredmetni_profesor().getPrezime() ;
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
			
			
			JOptionPane.showMessageDialog(MainFrame.getInstance(), "Dodajete predmet sa vec postojecom sifrom!", "Greska!",          
				       JOptionPane.ERROR_MESSAGE);
				
			return;
		}
		
	}
	
	

	
this.predmeti.add(new Predmet(sifra,naziv,semestar,godina,profesor,studenti));

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
Integer godina) {
for (Predmet i : predmeti) {
if (i.getSifra_predmeta().equals(sifra)) {
i.setSifra_predmeta(sifra);
i.setNaziv_predmeta(naziv);
i.setSemestar(semestar);
i.setGodina_studija(godina);

}
}

}




public  void saveListe(String file){
	ObjectOutputStream out = null;
	List<Predmet> listaPredmeta=this.getPredmeti();
	try {
		out = new ObjectOutputStream(new BufferedOutputStream( new FileOutputStream(file)));
		
		 
		out.writeObject(listaPredmeta);
		
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
}







@SuppressWarnings("unchecked")
public void ucitavanjeListe(String file){
	ObjectInputStream in = null;
	List<Predmet> listaPredmeti=new ArrayList<Predmet>();
	try {
		in = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
		listaPredmeti = (List<Predmet>) in.readObject();
		BazaPredmeta.getInstance().setPredmeti(listaPredmeti);
		
		
	} catch (Exception e) {
		e.printStackTrace();
    } finally {
        if(in != null){
            try {
                in.close();
            } catch (Exception e) {
    			e.printStackTrace();
            }
        }
    }
	
	
}






	
}
