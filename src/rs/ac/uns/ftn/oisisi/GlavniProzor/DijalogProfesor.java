package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.*;

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
	   
	  	
		setSize(500, 350); 
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
		JLabel lblLicnaKarta = new JLabel("Broj licne karte* ");
		
		
		JTextField txtIme = new JTextField();
		JTextField txtPrezime = new JTextField();
		JTextField txtDatumRodjenja = new JTextField();
		JTextField txtAdresa = new JTextField();
		JTextField txtTelefon = new JTextField();
		JTextField txtLicnaKarta = new JTextField();
		
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
		
		GridBagConstraints gbcLbLicna = new GridBagConstraints();
		gbcLbLicna.gridx = 0;
		gbcLbLicna.gridy = 5;
		gbcLbLicna.insets = new Insets(20, 0, 0,0);
		panelCenter.add(lblLicnaKarta, gbcLbLicna);
		
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
		
		GridBagConstraints gbcTxtLicna = new GridBagConstraints();
		gbcTxtLicna .gridx = 1;
		gbcTxtLicna.gridy = 5;
		gbcTxtLicna .weightx = 100;
		gbcTxtLicna.fill = GridBagConstraints.HORIZONTAL;
		gbcTxtLicna.insets = new Insets(20, 20, 0, 20);
		panelCenter.add(txtLicnaKarta, gbcTxtLicna );
	    
		
		setVisible(true);
		
	}  

	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}  

}

