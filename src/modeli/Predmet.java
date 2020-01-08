package modeli;

import java.io.Serializable;
import java.util.ArrayList;


public class Predmet  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 132213121L;
	
	
	private String sifra_predmeta;
	private String naziv_predmeta;
	private int semestar;
	private int godina_studija;
	private Profesor predmetni_profesor;
	private ArrayList<Student>spisak_studenata;
	
	
	
	
	public Predmet(String sifra_predmeta, String naziv_predmeta, int semestar, int godina_studija,
			Profesor predmetni_profesor, ArrayList<Student> studenti) {
		super();
		this.sifra_predmeta = sifra_predmeta;
		this.naziv_predmeta = naziv_predmeta;
		this.semestar = semestar;
		this.godina_studija = godina_studija;
		this.predmetni_profesor = predmetni_profesor;
		this.spisak_studenata = studenti;
	}


	
	public String getSifra_predmeta() {
		return sifra_predmeta;
	}
	
	
	public void setSifra_predmeta(String sifra_predmeta) {
		this.sifra_predmeta = sifra_predmeta;
	}
	
	
	public String getNaziv_predmeta() {
		return naziv_predmeta;
	}
	
	
	public void setNaziv_predmeta(String naziv_predmeta) {
		this.naziv_predmeta = naziv_predmeta;
	}
	
	
	public Integer getSemestar() {
		return semestar;
	}
	
	
	public void setSemestar(int semestar) {
		this.semestar = semestar;
	}
	
	
	public Integer getGodina_studija() {
		return godina_studija;
	}
	
	
	public void setGodina_studija(int godina_studija) {
		this.godina_studija = godina_studija;
	}
	
	
	public Profesor getPredmetni_profesor() {
		return predmetni_profesor;
	}
	
	
	public void setPredmetni_profesor(Profesor predmetni_profesor) {
		this.predmetni_profesor = predmetni_profesor;
	}



	public ArrayList<Student> getSpisak_studenata() {
		return spisak_studenata;
	}
	
	public void dodajStudentaNaPredmet(Student s) {
		spisak_studenata.add(s);
	}
	public void obrisiStudentaSaPredmeta(Student s) {
		spisak_studenata.remove(s);
	}
	
	



	public void setSpisak_studenata(ArrayList<Student> spisak_studenata) {
		this.spisak_studenata = spisak_studenata;
	}
}