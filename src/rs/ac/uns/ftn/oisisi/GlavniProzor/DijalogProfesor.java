package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.*;

import controlleri.ProfesorKontroler;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;  


   
public class DijalogProfesor extends JDialog implements ActionListener {

	
	private static final long serialVersionUID =19823918398L;


	public DijalogProfesor(Dialog owner){  
	  
		
		super(owner,"Dodavanje profesora",true);
	   
	  	
		setSize(600, 570); 
		setLocationRelativeTo(owner);
		   	    
	    JPanel panelBottom = new JPanel();
	    JButton potvrda=new JButton("Potvrda");
		JButton odustanak=new JButton("Odustanak");
		
        odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
	            int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

	            if (dialogResult == JOptionPane.YES_OPTION) {
		           dispose();
	            }
		             
				
			}
		});
	    
		panelBottom.add(potvrda);
		panelBottom.add(odustanak);
		
		
		this.add(panelBottom, BorderLayout.SOUTH);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		
		
		this.add(panelCenter, BorderLayout.CENTER);
		
		JLabel lblIme = new JLabel("Ime*");
		JLabel lblPrezime = new JLabel("Prezime*");
		JLabel lblDatumRodjenja = new JLabel("Datum rodjenja*");
		JLabel lblAdresa = new JLabel("Adresa stanovanja* ");
		JLabel lblTelefon = new JLabel("Kontakt telefon* ");
		JLabel lblEmail = new JLabel("E-mail adresa* ");
		JLabel lblAdresaKancelarije = new JLabel("Adresa kancelarije* ");
		JLabel lblLicnaKarta = new JLabel("Broj licne karte* ");
		JLabel lblTitula = new JLabel("Titula* ");
		JLabel lblZvanje = new JLabel("Zvanje* ");
//		JLabel lblPredmetiSpisak = new JLabel("Spisak predmeta* ");
		
		
	final JTextField txtIme = new JTextField();
	final JTextField txtPrezime = new JTextField();
	final JTextField txtDatumRodjenja = new JTextField();
	final JTextField txtAdresa = new JTextField();
	final JTextField txtTelefon = new JTextField();
	final JTextField txtEmail = new JTextField();
	final JTextField txtAdresaKancelarije = new JTextField();
	final JTextField txtLicnaKarta = new JTextField();
	final JTextField txtTitula = new JTextField();
	final JTextField txtZvanje = new JTextField();
	//	JTextField txtPredmetiSpisak = new JTextField();
		
		//LABELE
		
		GridBagConstraints gbcLblIme = new GridBagConstraints();
		gbcLblIme.gridx = 0;
		gbcLblIme.gridy = 0;
		gbcLblIme.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblIme, gbcLblIme);
		
		
		GridBagConstraints gbcLblPrezime = new GridBagConstraints();
		gbcLblPrezime.gridx = 0;
		gbcLblPrezime.gridy = 1;
		gbcLblPrezime.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblPrezime, gbcLblPrezime);
		
		
		GridBagConstraints gbcLbDatum = new GridBagConstraints();
		gbcLbDatum.gridx = 0;
		gbcLbDatum.gridy = 2;
		gbcLbDatum.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblDatumRodjenja, gbcLbDatum);
		
		
		GridBagConstraints gbcLbAdresa = new GridBagConstraints();
		gbcLbAdresa.gridx = 0;
		gbcLbAdresa.gridy = 3;
		gbcLbAdresa.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblAdresa, gbcLbAdresa);
		
		
		
		GridBagConstraints gbcLbTelefon = new GridBagConstraints();
		gbcLbTelefon.gridx = 0;
		gbcLbTelefon.gridy = 4;
		gbcLbTelefon.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblTelefon, gbcLbTelefon);
		
		GridBagConstraints gbcLbEmail = new GridBagConstraints();
		gbcLbEmail.gridx = 0;
		gbcLbEmail.gridy = 5;
		gbcLbEmail.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblEmail, gbcLbEmail);
		
		
		
		GridBagConstraints gbcLbAdresaKancelarije = new GridBagConstraints();
		gbcLbAdresaKancelarije.gridx = 0;
		gbcLbAdresaKancelarije.gridy = 6;
		gbcLbAdresaKancelarije.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblAdresaKancelarije, gbcLbAdresaKancelarije);
		
		
		GridBagConstraints gbcLbLicna = new GridBagConstraints();
		gbcLbLicna.gridx = 0;
		gbcLbLicna.gridy = 7;
		gbcLbLicna.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblLicnaKarta, gbcLbLicna);
		
		
		GridBagConstraints gbcLbTitula = new GridBagConstraints();
		gbcLbTitula.gridx = 0;
		gbcLbTitula.gridy = 8;
		gbcLbTitula.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblTitula, gbcLbTitula);
		
		
		GridBagConstraints gbcLbZvanje = new GridBagConstraints();
		gbcLbZvanje.gridx = 0;
		gbcLbZvanje.gridy = 9;
		gbcLbZvanje.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblZvanje, gbcLbZvanje);
		
		
	/*	GridBagConstraints gbcLbPredmetiSpisak = new GridBagConstraints();
		gbcLbPredmetiSpisak.gridx = 0;
		gbcLbPredmetiSpisak.gridy = 10;
		gbcLbPredmetiSpisak.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblPredmetiSpisak, gbcLbPredmetiSpisak); */
		
		//TEXTFILDOVI
		
		
		GridBagConstraints gbcTxtIme = new GridBagConstraints();
		gbcTxtIme .gridx = 1;
		gbcTxtIme .gridy = 0;
		gbcTxtIme .weightx = 100;
		gbcTxtIme .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtIme .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtIme, gbcTxtIme );
		
		
		GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
		gbcTxtPrezime .gridx = 1;
		gbcTxtPrezime .gridy = 1;
		gbcTxtPrezime .weightx = 100;
		gbcTxtPrezime .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPrezime .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtPrezime, gbcTxtPrezime );
		
		
		GridBagConstraints gbcTxtDatum = new GridBagConstraints();
		gbcTxtDatum .gridx = 1;
		gbcTxtDatum .gridy = 2;
		gbcTxtDatum .weightx = 100;
		gbcTxtDatum.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatum.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtDatumRodjenja, gbcTxtDatum );
		
		GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
		gbcTxtAdresa .gridx = 1;
		gbcTxtAdresa.gridy = 3;
		gbcTxtAdresa .weightx = 100;
		gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresa.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtAdresa, gbcTxtAdresa );
		
		
		GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
		gbcTxtTelefon.gridx = 1;
		gbcTxtTelefon .gridy = 4;
		gbcTxtTelefon .weightx = 100;
		gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtTelefon.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtTelefon, gbcTxtTelefon );

		
		GridBagConstraints gbcTxtEmail = new GridBagConstraints();
		gbcTxtEmail.gridx = 1;
		gbcTxtEmail.gridy = 5;
		gbcTxtEmail .weightx = 100;
		gbcTxtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtEmail.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtEmail, gbcTxtEmail );
		
		
		GridBagConstraints gbcTxtAdresaKancelarije = new GridBagConstraints();
		gbcTxtAdresaKancelarije .gridx = 1;
		gbcTxtAdresaKancelarije .gridy = 6;
		gbcTxtAdresaKancelarije  .weightx = 100;
		gbcTxtAdresaKancelarije .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresaKancelarije .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtAdresaKancelarije, gbcTxtAdresaKancelarije );
		
		
		GridBagConstraints gbcTxtLicna = new GridBagConstraints();
		gbcTxtLicna .gridx = 1;
		gbcTxtLicna.gridy = 7;
		gbcTxtLicna .weightx = 100;
		gbcTxtLicna.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtLicna.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtLicnaKarta, gbcTxtLicna );
		
		
		GridBagConstraints gbcTxtTitula = new GridBagConstraints();
		gbcTxtTitula  .gridx = 1;
		gbcTxtTitula .gridy = 8;
		gbcTxtTitula  .weightx = 100;
		gbcTxtTitula .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtTitula .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtTitula, gbcTxtTitula  );
		
		
		GridBagConstraints gbcTxtZvanje = new GridBagConstraints();
		gbcTxtZvanje  .gridx = 1;
		gbcTxtZvanje .gridy = 9;
		gbcTxtZvanje  .weightx = 100;
		gbcTxtZvanje .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtZvanje .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtZvanje, gbcTxtZvanje  );
	    
		
	/*	GridBagConstraints gbcTxtPredmetniSpisak = new GridBagConstraints();
		gbcTxtPredmetniSpisak .gridx = 1;
		gbcTxtPredmetniSpisak.gridy = 10;
		gbcTxtPredmetniSpisak .weightx = 100;
		gbcTxtPredmetniSpisak.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPredmetniSpisak.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtPredmetiSpisak, gbcTxtPredmetniSpisak); */
		
		
		potvrda.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda unosa", dialogButton);
				
				if (dialogResult == JOptionPane.YES_OPTION) {
					
				
				if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() ||
						txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmail.getText().isEmpty() ||
						txtAdresaKancelarije.getText().isEmpty() || txtLicnaKarta.getText().isEmpty() ||
						txtTitula.getText().isEmpty() || txtZvanje.getText().isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Sva polja moraju biti popunjena!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					//dispose();
					return;
					
				}
				try {
					Integer.parseInt(txtTelefon.getText());
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "Broj telefona bora biti Integer!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					Integer.parseInt(txtLicnaKarta.getText());
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "Broj licne karte bora biti Integer!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					return;
				}
				String ime = txtIme.getText();
				String prezime = txtPrezime.getText();
				String datum = txtDatumRodjenja.getText();
				String adresa = txtAdresa.getText();
				long telefon = Long.parseLong(txtTelefon.getText());
				String email = txtEmail.getText();
				String kanc = txtAdresaKancelarije.getText();
				long licna = Long.parseLong(txtLicnaKarta.getText());
				String titula = txtTitula.getText();
				String zvanje = txtZvanje.getText();
				
				ProfesorKontroler.getInstance().dodajProfesora(ime,prezime,datum,adresa,telefon,email,kanc,licna,titula,zvanje,null);
				
				dispose();
			}
				
			}
		});
		
		
		
		setVisible(true);
		
		
	}

	
	
public DijalogProfesor(Dialog owner,String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, long kontakt_telefon,
		String e_mail, String adresa_kancelarije, long broj_licne_karte, String titula, String zvanje){  
	  
		
		super(owner,"Dodavanje profesora",true);
	   
	  	
		setSize(600, 570); 
		setLocationRelativeTo(owner);
		   	    
	    JPanel panelBottom = new JPanel();
	    JButton potvrda=new JButton("Potvrda");
		JButton odustanak=new JButton("Odustanak");
		
        odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	    
		panelBottom.add(potvrda);
		panelBottom.add(odustanak);
		
		
		this.add(panelBottom, BorderLayout.SOUTH);
		
		JPanel panelCenter = new JPanel();
		panelCenter.setLayout(new GridBagLayout());
		
		
		this.add(panelCenter, BorderLayout.CENTER);
		
		JLabel lblIme = new JLabel("Ime*");
		JLabel lblPrezime = new JLabel("Prezime*");
		JLabel lblDatumRodjenja = new JLabel("Datum rodjenja*");
		JLabel lblAdresa = new JLabel("Adresa stanovanja* ");
		JLabel lblTelefon = new JLabel("Kontakt telefon* ");
		JLabel lblEmail = new JLabel("E-mail adresa* ");
		JLabel lblAdresaKancelarije = new JLabel("Adresa kancelarije* ");
		JLabel lblLicnaKarta = new JLabel("Broj licne karte* ");
		JLabel lblTitula = new JLabel("Titula* ");
		JLabel lblZvanje = new JLabel("Zvanje* ");
//		JLabel lblPredmetiSpisak = new JLabel("Spisak predmeta* ");
		
		
	final JTextField txtIme = new JTextField(ime);
	final JTextField txtPrezime = new JTextField(prezime);
	final JTextField txtDatumRodjenja = new JTextField(datum_rodjenja);
	final JTextField txtAdresa = new JTextField(adresa_stanovanja);
	final JTextField txtTelefon = new JTextField(Long.toString(kontakt_telefon));
	final JTextField txtEmail = new JTextField(e_mail);
	final JTextField txtAdresaKancelarije = new JTextField(adresa_kancelarije);
	final JTextField txtLicnaKarta = new JTextField(Long.toString(broj_licne_karte));
	txtLicnaKarta.setEditable(false);
	final JTextField txtTitula = new JTextField(titula);
	final JTextField txtZvanje = new JTextField(zvanje);
	//	JTextField txtPredmetiSpisak = new JTextField();
		
		//LABELE
		
		GridBagConstraints gbcLblIme = new GridBagConstraints();
		gbcLblIme.gridx = 0;
		gbcLblIme.gridy = 0;
		gbcLblIme.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblIme, gbcLblIme);
		
		
		GridBagConstraints gbcLblPrezime = new GridBagConstraints();
		gbcLblPrezime.gridx = 0;
		gbcLblPrezime.gridy = 1;
		gbcLblPrezime.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblPrezime, gbcLblPrezime);
		
		
		GridBagConstraints gbcLbDatum = new GridBagConstraints();
		gbcLbDatum.gridx = 0;
		gbcLbDatum.gridy = 2;
		gbcLbDatum.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblDatumRodjenja, gbcLbDatum);
		
		
		GridBagConstraints gbcLbAdresa = new GridBagConstraints();
		gbcLbAdresa.gridx = 0;
		gbcLbAdresa.gridy = 3;
		gbcLbAdresa.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblAdresa, gbcLbAdresa);
		
		
		
		GridBagConstraints gbcLbTelefon = new GridBagConstraints();
		gbcLbTelefon.gridx = 0;
		gbcLbTelefon.gridy = 4;
		gbcLbTelefon.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblTelefon, gbcLbTelefon);
		
		GridBagConstraints gbcLbEmail = new GridBagConstraints();
		gbcLbEmail.gridx = 0;
		gbcLbEmail.gridy = 5;
		gbcLbEmail.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblEmail, gbcLbEmail);
		
		
		
		GridBagConstraints gbcLbAdresaKancelarije = new GridBagConstraints();
		gbcLbAdresaKancelarije.gridx = 0;
		gbcLbAdresaKancelarije.gridy = 6;
		gbcLbAdresaKancelarije.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblAdresaKancelarije, gbcLbAdresaKancelarije);
		
		
		GridBagConstraints gbcLbLicna = new GridBagConstraints();
		gbcLbLicna.gridx = 0;
		gbcLbLicna.gridy = 7;
		gbcLbLicna.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblLicnaKarta, gbcLbLicna);
		
		
		GridBagConstraints gbcLbTitula = new GridBagConstraints();
		gbcLbTitula.gridx = 0;
		gbcLbTitula.gridy = 8;
		gbcLbTitula.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblTitula, gbcLbTitula);
		
		
		GridBagConstraints gbcLbZvanje = new GridBagConstraints();
		gbcLbZvanje.gridx = 0;
		gbcLbZvanje.gridy = 9;
		gbcLbZvanje.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblZvanje, gbcLbZvanje);
		
		
	/*	GridBagConstraints gbcLbPredmetiSpisak = new GridBagConstraints();
		gbcLbPredmetiSpisak.gridx = 0;
		gbcLbPredmetiSpisak.gridy = 10;
		gbcLbPredmetiSpisak.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblPredmetiSpisak, gbcLbPredmetiSpisak); */
		
		//TEXTFILDOVI
		
		
		GridBagConstraints gbcTxtIme = new GridBagConstraints();
		gbcTxtIme .gridx = 1;
		gbcTxtIme .gridy = 0;
		gbcTxtIme .weightx = 100;
		gbcTxtIme .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtIme .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtIme, gbcTxtIme );
		
		
		GridBagConstraints gbcTxtPrezime = new GridBagConstraints();
		gbcTxtPrezime .gridx = 1;
		gbcTxtPrezime .gridy = 1;
		gbcTxtPrezime .weightx = 100;
		gbcTxtPrezime .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPrezime .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtPrezime, gbcTxtPrezime );
		
		
		GridBagConstraints gbcTxtDatum = new GridBagConstraints();
		gbcTxtDatum .gridx = 1;
		gbcTxtDatum .gridy = 2;
		gbcTxtDatum .weightx = 100;
		gbcTxtDatum.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtDatum.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtDatumRodjenja, gbcTxtDatum );
		
		GridBagConstraints gbcTxtAdresa = new GridBagConstraints();
		gbcTxtAdresa .gridx = 1;
		gbcTxtAdresa.gridy = 3;
		gbcTxtAdresa .weightx = 100;
		gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresa.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtAdresa, gbcTxtAdresa );
		
		
		GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
		gbcTxtTelefon.gridx = 1;
		gbcTxtTelefon .gridy = 4;
		gbcTxtTelefon .weightx = 100;
		gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtTelefon.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtTelefon, gbcTxtTelefon );

		
		GridBagConstraints gbcTxtEmail = new GridBagConstraints();
		gbcTxtEmail.gridx = 1;
		gbcTxtEmail.gridy = 5;
		gbcTxtEmail .weightx = 100;
		gbcTxtEmail.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtEmail.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtEmail, gbcTxtEmail );
		
		
		GridBagConstraints gbcTxtAdresaKancelarije = new GridBagConstraints();
		gbcTxtAdresaKancelarije .gridx = 1;
		gbcTxtAdresaKancelarije .gridy = 6;
		gbcTxtAdresaKancelarije  .weightx = 100;
		gbcTxtAdresaKancelarije .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtAdresaKancelarije .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtAdresaKancelarije, gbcTxtAdresaKancelarije );
		
		
		GridBagConstraints gbcTxtLicna = new GridBagConstraints();
		gbcTxtLicna .gridx = 1;
		gbcTxtLicna.gridy = 7;
		gbcTxtLicna .weightx = 100;
		gbcTxtLicna.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtLicna.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtLicnaKarta, gbcTxtLicna );
		
		
		GridBagConstraints gbcTxtTitula = new GridBagConstraints();
		gbcTxtTitula  .gridx = 1;
		gbcTxtTitula .gridy = 8;
		gbcTxtTitula  .weightx = 100;
		gbcTxtTitula .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtTitula .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtTitula, gbcTxtTitula  );
		
		
		GridBagConstraints gbcTxtZvanje = new GridBagConstraints();
		gbcTxtZvanje  .gridx = 1;
		gbcTxtZvanje .gridy = 9;
		gbcTxtZvanje  .weightx = 100;
		gbcTxtZvanje .fill = GridBagConstraints.HORIZONTAL;
		gbcTxtZvanje .insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtZvanje, gbcTxtZvanje  );
	    
		
	/*	GridBagConstraints gbcTxtPredmetniSpisak = new GridBagConstraints();
		gbcTxtPredmetniSpisak .gridx = 1;
		gbcTxtPredmetniSpisak.gridy = 10;
		gbcTxtPredmetniSpisak .weightx = 100;
		gbcTxtPredmetniSpisak.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtPredmetniSpisak.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtPredmetiSpisak, gbcTxtPredmetniSpisak); */
		
		
		potvrda.addActionListener(new ActionListener() {
			
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda unosa", dialogButton);
				
				if (dialogResult == JOptionPane.YES_OPTION) {
					
				
				if(txtIme.getText().isEmpty() || txtPrezime.getText().isEmpty() || txtDatumRodjenja.getText().isEmpty() ||
						txtAdresa.getText().isEmpty() || txtTelefon.getText().isEmpty() || txtEmail.getText().isEmpty() ||
						txtAdresaKancelarije.getText().isEmpty() || txtLicnaKarta.getText().isEmpty() ||
						txtTitula.getText().isEmpty() || txtZvanje.getText().isEmpty()) {
					JOptionPane.showMessageDialog(new JFrame(), "Sva polja moraju biti popunjena!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					//dispose();
					return;
					
				}
				try {
					Integer.parseInt(txtTelefon.getText());
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "Broj telefona bora biti Integer!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					return;
				}
				try {
					Integer.parseInt(txtLicnaKarta.getText());
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "Broj licne karte bora biti Integer!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					return;
				}
				String ime = txtIme.getText();
				String prezime = txtPrezime.getText();
				String datum = txtDatumRodjenja.getText();
				String adresa = txtAdresa.getText();
				long telefon = Long.parseLong(txtTelefon.getText());
				String email = txtEmail.getText();
				String kanc = txtAdresaKancelarije.getText();
				long licna = Long.parseLong(txtLicnaKarta.getText());
				String titula = txtTitula.getText();
				String zvanje = txtZvanje.getText();
				
				ProfesorKontroler.getInstance().izmeniProfesora(ProfesorJTable.rowSelectedIndex,ime,prezime,datum,adresa,telefon,email,kanc,licna,titula,zvanje);
				
				dispose();
			}
				
			}
		});
		
		
		
		setVisible(true);
		
		
	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}  

}

