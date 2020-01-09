package modeli;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student  implements Serializable{
		private String ime;
		private String prezime;
		private String datum_rodjenja;
		private String adresa_stanovanja;
		private int broj_telefona;
		private String email_adresa;
		private String broj_indexa;
		private String datum_upisa;
		private int trenutna_godina_studija;
		private Status status;
		private float prosecna_ocena;
		private ArrayList<Predmet> predmeti;
		
		public ArrayList<Predmet> getPredmeti() {
			return predmeti;
		}

		public void setPredmeti(ArrayList<Predmet> predmeti) {
			this.predmeti = predmeti;
		}

		public Student() {
			
		}
		
		

		public Student(String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, int broj_telefona,
				String email_adresa, String broj_indexa, String datum_upisa, int trenutna_godina_studija, Status status,
				float prosecna_ocena, ArrayList<Predmet> predmeti) {
			super();
			this.ime = ime;
			this.prezime = prezime;
			this.datum_rodjenja = datum_rodjenja;
			this.adresa_stanovanja = adresa_stanovanja;
			this.broj_telefona = broj_telefona;
			this.email_adresa = email_adresa;
			this.broj_indexa = broj_indexa;
			this.datum_upisa = datum_upisa;
			this.trenutna_godina_studija = trenutna_godina_studija;
			this.status = status;
			this.prosecna_ocena = prosecna_ocena;
			this.predmeti = predmeti;
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

		public int getBroj_telefona() {
			return broj_telefona;
		}

		public void setBroj_telefona(int broj_telefona) {
			this.broj_telefona = broj_telefona;
		}

		public String getEmail_adresa() {
			return email_adresa;
		}

		public void setEmail_adresa(String email_adresa) {
			this.email_adresa = email_adresa;
		}

		public String getBroj_indexa() {
			return broj_indexa;
		}

		public void setBroj_indexa(String broj_indexa) {
			this.broj_indexa = broj_indexa;
		}

		public String getDatum_upisa() {
			return datum_upisa;
		}

		public void setDatum_upisa(String datum_upisa) {
			this.datum_upisa = datum_upisa;
		}

		public int getTrenutna_godina_studija() {
			return trenutna_godina_studija;
		}

		public void setTrenutna_godina_studija(int trenutna_godina_studija) {
			this.trenutna_godina_studija = trenutna_godina_studija;
		}

		public Status getStatus() {
			return status;
		}

		public void setStatus(Status status) {
			this.status = status;
		}

		public float getProsecna_ocena() {
			return prosecna_ocena;
		}

		public void setProsecna_ocena(float prosecna_ocena) {
			this.prosecna_ocena = prosecna_ocena;
		}
		public void dodajPredmetNaStudenta(Predmet p) {
			this.predmeti.add(p);
		}
		public void obirisiPredmet(Predmet p) {
			for (Predmet predmet : predmeti) {
				if(predmet.getSifra_predmeta().equals(p.getSifra_predmeta())) {
					predmeti.remove(predmet);
					break;
				}
			}
		}
		public ArrayList<Predmet> vratiPredmete(){
			return predmeti;
		}
		
}