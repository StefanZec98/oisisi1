package modeli;

import java.util.ArrayList;

public class Profesor {
	
	private String ime;
	private String prezime;
	private String datum_rodjenja;
	private String adresa_stanovanja;
	private long kontakt_telefon;
	private String e_mail;
	private String adresa_kancelarije;
	private int broj_licne_karte;
	private String titula;
	private String zvanje;
	private ArrayList<Predmet>predmetiSpisak;
	
	
	
	
	public Profesor(String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, long kontakt_telefon,
			String e_mail, String adresa_kancelarije, int broj_licne_karte, String titula, String zvanje,
			ArrayList<Predmet> predmetiSpisak) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datum_rodjenja = datum_rodjenja;
		this.adresa_stanovanja = adresa_stanovanja;
		this.kontakt_telefon = kontakt_telefon;
		this.e_mail = e_mail;
		this.adresa_kancelarije = adresa_kancelarije;
		this.broj_licne_karte = broj_licne_karte;
		this.titula = titula;
		this.zvanje = zvanje;
		this.predmetiSpisak = predmetiSpisak;
	}




	public String getIme() {
		return ime;
	}




	public void setIme(String ime) {
		this.ime = ime;
	}




	public String getPrezime() {
		return prezime;
	}




	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}




	public String getDatum_rodjenja() {
		return datum_rodjenja;
	}




	public void setDatum_rodjenja(String datum_rodjenja) {
		this.datum_rodjenja = datum_rodjenja;
	}




	public String getAdresa_stanovanja() {
		return adresa_stanovanja;
	}




	public void setAdresa_stanovanja(String adresa_stanovanja) {
		this.adresa_stanovanja = adresa_stanovanja;
	}




	public long getKontakt_telefon() {
		return kontakt_telefon;
	}




	public void setKontakt_telefon(long kontakt_telefon) {
		this.kontakt_telefon = kontakt_telefon;
	}




	public String getE_mail() {
		return e_mail;
	}




	public void setE_mail(String e_mail) {
		this.e_mail = e_mail;
	}




	public String getAdresa_kancelarije() {
		return adresa_kancelarije;
	}




	public void setAdresa_kancelarije(String adresa_kancelarije) {
		this.adresa_kancelarije = adresa_kancelarije;
	}




	public int getBroj_licne_karte() {
		return broj_licne_karte;
	}




	public void setBroj_licne_karte(int broj_licne_karte) {
		this.broj_licne_karte = broj_licne_karte;
	}




	public String getTitula() {
		return titula;
	}




	public void setTitula(String titula) {
		this.titula = titula;
	}




	public String getZvanje() {
		return zvanje;
	}




	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}




	public ArrayList<Predmet> getPredmetiSpisak() {
		return predmetiSpisak;
	}




	public void setPredmetiSpisak(ArrayList<Predmet> predmetiSpisak) {
		this.predmetiSpisak = predmetiSpisak;
	}
	
	
	
	
	
	

}
