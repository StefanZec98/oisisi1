package controlleri;

import java.util.ArrayList;

import modeli.BazaStudenta;
import modeli.Predmet;
import modeli.Status;
import modeli.Student;
import rs.ac.uns.ftn.oisisi.GlavniProzor.StudentiJtable;

public class StudentKontroler {

private static StudentKontroler instance = null;
	
	public static StudentKontroler getInstance() {
		if (instance == null) {
			instance = new StudentKontroler();
		}
		return instance;
	}
	
	private StudentKontroler() {}
	
	public void dodajStudenta(String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, int broj_telefona,
			String email_adresa, String broj_indexa, String datum_upisa, int trenutna_godina_studija, Status status,
			float prosecna_ocena, ArrayList<Predmet> predmeti) {
		
		BazaStudenta.getInstance().dodajStudenta(ime,prezime,datum_rodjenja,adresa_stanovanja,broj_telefona,email_adresa,broj_indexa,datum_upisa,trenutna_godina_studija,status,prosecna_ocena,predmeti);
		
		StudentiJtable.azurirajPrikaz();
		
		
		
		
	}
	public void izbrisiStudenta(int rowSelectedIndex) {
		if (rowSelectedIndex < 0) {
			return;
		}
		Student s = BazaStudenta.getInstance().getRow(rowSelectedIndex);
		
		BazaStudenta.getInstance().izbrisiStudenta(s.getBroj_indexa());
		StudentiJtable.azurirajPrikaz();

		}
	
	public void izmeniStudenta(int rowSelectedIndex,String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, int broj_telefona,
			String email_adresa, String broj_indexa, String datum_upisa, int trenutna_godina_studija, Status status,
			float prosecna_ocena) {
		if (rowSelectedIndex < 0) {
			return;
			}
		BazaStudenta.getInstance().izmeniStudenta(ime, prezime, datum_rodjenja, adresa_stanovanja, broj_telefona, email_adresa, broj_indexa, datum_upisa, trenutna_godina_studija, status, prosecna_ocena);
		StudentiJtable.azurirajPrikaz();
	}
}
