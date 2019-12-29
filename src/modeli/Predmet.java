package modeli;

import java.util.ArrayList;

public class Predmet {
	
	private String sifra_predmeta;
	private String naziv_predmeta;
	private String semestar;
	private String godina_studija;
	private String predmetni_profesor;
	private ArrayList<Student>spisak_studenata;
	
	
	
	
	public Predmet(String sifra_predmeta, String naziv_predmeta, String semestar, String godina_studija,
			String predmetni_profesor, ArrayList<Student> studenti) {
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
	
	
	public String getSemestar() {
		return semestar;
	}
	
	
	public void setSemestar(String semestar) {
		this.semestar = semestar;
	}
	
	
	public String getGodina_studija() {
		return godina_studija;
	}
	
	
	public void setGodina_studija(String godina_studija) {
		this.godina_studija = godina_studija;
	}
	
	
	public String getPredmetni_profesor() {
		return predmetni_profesor;
	}
	
	
	public void setPredmetni_profesor(String predmetni_profesor) {
		this.predmetni_profesor = predmetni_profesor;
	}



	public ArrayList<Student> getSpisak_studenata() {
		return spisak_studenata;
	}



	public void setSpisak_studenata(ArrayList<Student> spisak_studenata) {
		this.spisak_studenata = spisak_studenata;
	}
	
	
	
	
	
	
	
	
	
	

}
