package controlleri;

import java.util.ArrayList;

import modeli.BazaProfesora;
import modeli.Predmet;
import modeli.Profesor;
import rs.ac.uns.ftn.oisisi.GlavniProzor.ProfesorJTable;




public class ProfesorKontroler {

private static ProfesorKontroler instance = null;

public static ProfesorKontroler getInstance() {
if (instance == null) {
instance = new ProfesorKontroler();
}
return instance;
}

public ProfesorKontroler() {}

public void dodajProfesora(String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, long kontakt_telefon,
		String e_mail, String adresa_kancelarije, long broj_licne_karte, String titula, String zvanje,
		ArrayList<Predmet> predmetiSpisak) {


	BazaProfesora.getInstance().dodajProfesora(ime, prezime, datum_rodjenja, adresa_stanovanja,
			kontakt_telefon, e_mail, adresa_kancelarije, broj_licne_karte, titula, zvanje, null);
	
	
	
// azuriranje prikaza
	ProfesorJTable.azurirajPrikaz();


}
public void izbrisiProfesora(int rowSelectedIndex) {
	if (rowSelectedIndex < 0) {
		return;
	}
	Profesor profesor = BazaProfesora.getInstance().getRow(rowSelectedIndex);
	BazaProfesora.getInstance().izbrisiProfesora(profesor.getBroj_licne_karte());
	ProfesorJTable.azurirajPrikaz();
}

public void izmeniProfesora(int rowSelectedIndex,String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, long kontakt_telefon,
		String e_mail, String adresa_kancelarije, long broj_licne_karte, String titula, String zvanje) {
	if (rowSelectedIndex < 0) {
		return;
	}
	BazaProfesora.getInstance().izmeniProfesora(ime, prezime, datum_rodjenja, adresa_stanovanja, kontakt_telefon, e_mail, adresa_kancelarije, broj_licne_karte, titula, zvanje, null);
	ProfesorJTable.azurirajPrikaz();
}


}