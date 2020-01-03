package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.*;

import controlleri.StudentKontroler;
import modeli.Predmet;
import modeli.Status;
import modeli.Student;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.*;  

public class DijalogStudent  extends JDialog implements ActionListener {

	private static final long serialVersionUID = -86380656841831620L;


public DijalogStudent(Dialog parent){   
	super(parent,"Dodavanje studenta",true);
 
   setSize(500, 600);   
   setLocationRelativeTo(parent);
  
 
   
   JPanel panelBottom = new JPanel();
   JButton b1 = new JButton("Potvrda");
   JButton b2 = new JButton("Odustanak");
   b2.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		dispose();
	}
});
   panelBottom.add(b1);
   panelBottom.add(b2);
   
   this.add(panelBottom, BorderLayout.SOUTH);



   JPanel panelCenter = new JPanel();
   panelCenter.setLayout(new GridBagLayout());
   this.add(panelCenter, BorderLayout.CENTER);


   JLabel lblIme = new JLabel("Ime*");
   JLabel lblPrezime = new JLabel("Prezime*");
   JLabel lblDatumRodjenja = new JLabel("Datum rodjenja*");
   JLabel lblAdresa = new JLabel("Adresa stanovanja* ");
   JLabel lblTelefon = new JLabel("Kontakt telefon* ");
   JLabel lblBrojIndeksa = new JLabel("Broj indeksa* ");
   JLabel lblTrenutnaGodinaStudija = new JLabel("Trenutna godina studija* ");
   JLabel lblEmailAdresa = new JLabel("Email adresa*");
   JLabel lblDatumUpisa = new JLabel("Datum Upisa*");
   JLabel lblProsecnaOcena = new JLabel("Prosecna Ocena*");


  final JTextField txtIme = new JTextField();
  final JTextField txtPrezime = new JTextField();
  final JTextField txtDatumRodjenja = new JTextField();
  final JTextField txtAdresa = new JTextField();
  final JTextField txtTelefon = new JTextField();
  final JTextField txtBrojIndeksa = new JTextField();
  final JTextField txtEmailAdresa = new JTextField();
  final JTextField txtDatumUpisa = new JTextField();
  final JTextField txtProsecnaOcena = new JTextField();

  
   
   
   
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

   GridBagConstraints gbcLbBrojIndeksa = new GridBagConstraints();
   gbcLbBrojIndeksa.gridx = 0;
   gbcLbBrojIndeksa.gridy = 5;
   gbcLbBrojIndeksa.insets = new Insets(20, 0, 0,0);
   panelCenter.add(lblBrojIndeksa, gbcLbBrojIndeksa);
   
   GridBagConstraints gbcLblEmailAdresa = new GridBagConstraints();
   gbcLblEmailAdresa.gridx = 0;
   gbcLblEmailAdresa.gridy = 6;
   gbcLblEmailAdresa.insets = new Insets(20, 0, 0,0);
   panelCenter.add(lblEmailAdresa, gbcLblEmailAdresa);
   
   GridBagConstraints gbcLblDatumUpisa = new GridBagConstraints();
   gbcLblDatumUpisa.gridx = 0;
   gbcLblDatumUpisa.gridy = 7;
   gbcLblDatumUpisa.insets = new Insets(20, 0, 0,0);
   panelCenter.add(lblDatumUpisa, gbcLblDatumUpisa);
   
   GridBagConstraints gbcLblProsecnaOcena = new GridBagConstraints();
   gbcLblProsecnaOcena.gridx = 0;
   gbcLblProsecnaOcena.gridy = 8;
   gbcLblProsecnaOcena.insets = new Insets(20, 0, 0,0);
   panelCenter.add(lblProsecnaOcena, gbcLblProsecnaOcena);
   
   GridBagConstraints gbcLbTrenutnaGodinaStudija = new GridBagConstraints();
   gbcLbTrenutnaGodinaStudija.gridx = 0;
   gbcLbTrenutnaGodinaStudija.gridy = 9;
   gbcLbTrenutnaGodinaStudija.insets = new Insets(20, 0, 0,0);
   panelCenter.add(lblTrenutnaGodinaStudija, gbcLbTrenutnaGodinaStudija);


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
   gbcTxtAdresa .gridy = 3;
   gbcTxtAdresa .weightx = 100;
   gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
   gbcTxtAdresa.insets = new Insets(20, 20, 0, 20);
   panelCenter.add(txtAdresa, gbcTxtAdresa );
   
   GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
   gbcTxtTelefon .gridx = 1;
   gbcTxtTelefon .gridy = 4;
   gbcTxtTelefon .weightx = 100;
   gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
   gbcTxtTelefon.insets = new Insets(20, 20, 0, 20);
   panelCenter.add(txtTelefon, gbcTxtTelefon );
   
   GridBagConstraints gbcTxtBrojIndeksa = new GridBagConstraints();
   gbcTxtBrojIndeksa .gridx = 1;
   gbcTxtBrojIndeksa .gridy = 5;
   gbcTxtBrojIndeksa .weightx = 100;
   gbcTxtBrojIndeksa.fill = GridBagConstraints.HORIZONTAL;
   gbcTxtBrojIndeksa.insets = new Insets(20, 20, 0, 20);
   panelCenter.add(txtBrojIndeksa, gbcTxtBrojIndeksa );
   
   GridBagConstraints gbcTxtEmailAdresa = new GridBagConstraints();
   gbcTxtEmailAdresa .gridx = 1;
   gbcTxtEmailAdresa .gridy = 6;
   gbcTxtEmailAdresa .weightx = 100;
   gbcTxtEmailAdresa .fill = GridBagConstraints.HORIZONTAL;
   gbcTxtEmailAdresa .insets = new Insets(20, 20, 0, 20);
   panelCenter.add(txtEmailAdresa, gbcTxtEmailAdresa );
   
   GridBagConstraints gbcTxtDatumUpisa = new GridBagConstraints();
   gbcTxtDatumUpisa .gridx = 1;
   gbcTxtDatumUpisa .gridy = 7;
   gbcTxtDatumUpisa .weightx = 100;
   gbcTxtDatumUpisa .fill = GridBagConstraints.HORIZONTAL;
   gbcTxtDatumUpisa .insets = new Insets(20, 20, 0, 20);
   panelCenter.add(txtDatumUpisa, gbcTxtDatumUpisa );
   
   GridBagConstraints gbcTxtProsecnaOcena = new GridBagConstraints();
   gbcTxtProsecnaOcena .gridx = 1;
   gbcTxtProsecnaOcena .gridy = 8;
   gbcTxtProsecnaOcena .weightx = 100;
   gbcTxtProsecnaOcena .fill = GridBagConstraints.HORIZONTAL;
   gbcTxtProsecnaOcena .insets = new Insets(20, 20, 0, 20);
   panelCenter.add(txtProsecnaOcena, gbcTxtProsecnaOcena );
   
   
   
   
   
   

   String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
   JComboBox<String> godStud=new JComboBox<>(godinaStudija);
   
   
   
   GridBagConstraints grd1 = new GridBagConstraints();
   grd1.gridx = 1;
   grd1.gridy = 9;
   grd1.weightx = 100;
   grd1.fill = GridBagConstraints.HORIZONTAL;
   grd1.insets = new Insets(20, 20, 0, 20);
   
   panelCenter.add(godStud,grd1);
   
   
   JCheckBox budzet = new JCheckBox("Budzet");
   JCheckBox samof = new JCheckBox("Samofinansiranje");
   
   budzet.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(budzet.isSelected()) {
			   samof.setSelected(false);
		   }
	}
});
   
   samof.addActionListener(new  ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(samof.isSelected()) {
			   budzet.setSelected(false);
		   }
	}
});
   
   b1.addActionListener(new ActionListener() {
	   
	   
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
			int dialogButton = JOptionPane.YES_NO_OPTION;
			int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda unosa", dialogButton);
			
			if (dialogResult == JOptionPane.YES_OPTION) {
			
			if(txtIme.getText().isEmpty() ||txtPrezime.getText().isEmpty() ||txtDatumRodjenja.getText().isEmpty() ||txtAdresa.getText().isEmpty()||txtTelefon.getText().isEmpty()||txtEmailAdresa.getText().isEmpty()||txtBrojIndeksa.getText().isEmpty()||txtDatumUpisa.getText().isEmpty()||txtProsecnaOcena.getText().isEmpty() ) {
				//System.out.println("Morate popuniti sva polja");
				JOptionPane.showMessageDialog(new JFrame(), "Sva polja moraju biti popunjena!", "Greska!",
				        JOptionPane.ERROR_MESSAGE);
				//dispose();
				return;
			}
			if(budzet.isSelected()==false && samof.isSelected()==false) {
				JOptionPane.showMessageDialog(new JFrame(), "Morate selektovati ili budzet ili samofinansiranje!", "Greska!",
				        JOptionPane.ERROR_MESSAGE);
				//dispose();
				return;
				
			}
			try {
				Float.parseFloat(txtProsecnaOcena.getText());
			}catch(NumberFormatException e1) {
				JOptionPane.showMessageDialog(new JFrame(), "Prosecna ocena mora biti float!", "Greska!",
				        JOptionPane.ERROR_MESSAGE);
				return;
			}
			if(Float.parseFloat(txtProsecnaOcena.getText())<6.0 || Float.parseFloat(txtProsecnaOcena.getText())>10.0) {
				JOptionPane.showMessageDialog(new JFrame(), "Ocena mora biti u opsegu [6,10]!", "Greska!",
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
			
			StudentKontroler.getInstance().dodajStudenta(txtIme.getText(), txtPrezime.getText(), txtDatumRodjenja.getText(), txtAdresa.getText(), Integer.parseInt(txtTelefon.getText()), txtEmailAdresa.getText(), txtBrojIndeksa.getText(), txtDatumUpisa.getText(),godStud.getSelectedIndex()+1, budzet.isSelected() ? Status.B : Status.S, Float.parseFloat(txtProsecnaOcena.getText()), null);
			dispose();
		}
		}
	});
   
   
   
   
   GridBagConstraints grd2 = new GridBagConstraints();
   grd2.gridx = 0;
   grd2.gridy = 10;
   grd2.insets = new Insets(20, 0, 0,0);
   
   panelCenter.add(budzet,grd2);
   
   GridBagConstraints grd3 = new GridBagConstraints();
   grd3.gridx = 1;
   grd3.gridy = 10;
   grd3.insets = new Insets(20, 20, 0,20);
   
   panelCenter.add(samof,grd3);
   
   
   
   setVisible(true);
   
   
}
  
   public DijalogStudent(Dialog parent,String ime, String prezime, String datum_rodjenja, String adresa_stanovanja, int broj_telefona,
			String email_adresa, String broj_indexa, String datum_upisa, int trenutna_godina_studija, Status status,
			float prosecna_ocena){   
		super(parent,"Dodavanje studenta",true);
	 
	   setSize(500, 600);   
	   setLocationRelativeTo(parent);
	  
	 
	   
	   JPanel panelBottom = new JPanel();
	   JButton b1 = new JButton("Potvrda");
	   JButton b2 = new JButton("Odustanak");
	   b2.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			dispose();
		}
	});
	   panelBottom.add(b1);
	   panelBottom.add(b2);
	   
	   this.add(panelBottom, BorderLayout.SOUTH);



	   JPanel panelCenter = new JPanel();
	   panelCenter.setLayout(new GridBagLayout());
	   this.add(panelCenter, BorderLayout.CENTER);


	   JLabel lblIme = new JLabel("Ime*");
	   JLabel lblPrezime = new JLabel("Prezime*");
	   JLabel lblDatumRodjenja = new JLabel("Datum rodjenja*");
	   JLabel lblAdresa = new JLabel("Adresa stanovanja* ");
	   JLabel lblTelefon = new JLabel("Kontakt telefon* ");
	   JLabel lblBrojIndeksa = new JLabel("Broj indeksa* ");
	   JLabel lblTrenutnaGodinaStudija = new JLabel("Trenutna godina studija* ");
	   JLabel lblEmailAdresa = new JLabel("Email adresa*");
	   JLabel lblDatumUpisa = new JLabel("Datum Upisa*");
	   JLabel lblProsecnaOcena = new JLabel("Prosecna Ocena*");


	  final JTextField txtIme = new JTextField(ime);
	  final JTextField txtPrezime = new JTextField(prezime);
	  final JTextField txtDatumRodjenja = new JTextField(datum_rodjenja);
	  final JTextField txtAdresa = new JTextField(adresa_stanovanja);
	  final JTextField txtTelefon = new JTextField(Integer.toString(broj_telefona));
	  final JTextField txtBrojIndeksa = new JTextField(broj_indexa);
	  txtBrojIndeksa.setEditable(false);
	  final JTextField txtEmailAdresa = new JTextField(email_adresa);
	  final JTextField txtDatumUpisa = new JTextField(datum_upisa);
	  final JTextField txtProsecnaOcena = new JTextField(Float.toString(prosecna_ocena));

	  
	   
	   
	   
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

	   GridBagConstraints gbcLbBrojIndeksa = new GridBagConstraints();
	   gbcLbBrojIndeksa.gridx = 0;
	   gbcLbBrojIndeksa.gridy = 5;
	   gbcLbBrojIndeksa.insets = new Insets(20, 0, 0,0);
	   panelCenter.add(lblBrojIndeksa, gbcLbBrojIndeksa);
	   
	   GridBagConstraints gbcLblEmailAdresa = new GridBagConstraints();
	   gbcLblEmailAdresa.gridx = 0;
	   gbcLblEmailAdresa.gridy = 6;
	   gbcLblEmailAdresa.insets = new Insets(20, 0, 0,0);
	   panelCenter.add(lblEmailAdresa, gbcLblEmailAdresa);
	   
	   GridBagConstraints gbcLblDatumUpisa = new GridBagConstraints();
	   gbcLblDatumUpisa.gridx = 0;
	   gbcLblDatumUpisa.gridy = 7;
	   gbcLblDatumUpisa.insets = new Insets(20, 0, 0,0);
	   panelCenter.add(lblDatumUpisa, gbcLblDatumUpisa);
	   
	   GridBagConstraints gbcLblProsecnaOcena = new GridBagConstraints();
	   gbcLblProsecnaOcena.gridx = 0;
	   gbcLblProsecnaOcena.gridy = 8;
	   gbcLblProsecnaOcena.insets = new Insets(20, 0, 0,0);
	   panelCenter.add(lblProsecnaOcena, gbcLblProsecnaOcena);
	   
	   GridBagConstraints gbcLbTrenutnaGodinaStudija = new GridBagConstraints();
	   gbcLbTrenutnaGodinaStudija.gridx = 0;
	   gbcLbTrenutnaGodinaStudija.gridy = 9;
	   gbcLbTrenutnaGodinaStudija.insets = new Insets(20, 0, 0,0);
	   panelCenter.add(lblTrenutnaGodinaStudija, gbcLbTrenutnaGodinaStudija);


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
	   gbcTxtAdresa .gridy = 3;
	   gbcTxtAdresa .weightx = 100;
	   gbcTxtAdresa.fill = GridBagConstraints.HORIZONTAL;
	   gbcTxtAdresa.insets = new Insets(20, 20, 0, 20);
	   panelCenter.add(txtAdresa, gbcTxtAdresa );
	   
	   GridBagConstraints gbcTxtTelefon = new GridBagConstraints();
	   gbcTxtTelefon .gridx = 1;
	   gbcTxtTelefon .gridy = 4;
	   gbcTxtTelefon .weightx = 100;
	   gbcTxtTelefon.fill = GridBagConstraints.HORIZONTAL;
	   gbcTxtTelefon.insets = new Insets(20, 20, 0, 20);
	   panelCenter.add(txtTelefon, gbcTxtTelefon );
	   
	   GridBagConstraints gbcTxtBrojIndeksa = new GridBagConstraints();
	   gbcTxtBrojIndeksa .gridx = 1;
	   gbcTxtBrojIndeksa .gridy = 5;
	   gbcTxtBrojIndeksa .weightx = 100;
	   gbcTxtBrojIndeksa.fill = GridBagConstraints.HORIZONTAL;
	   gbcTxtBrojIndeksa.insets = new Insets(20, 20, 0, 20);
	   panelCenter.add(txtBrojIndeksa, gbcTxtBrojIndeksa );
	   
	   GridBagConstraints gbcTxtEmailAdresa = new GridBagConstraints();
	   gbcTxtEmailAdresa .gridx = 1;
	   gbcTxtEmailAdresa .gridy = 6;
	   gbcTxtEmailAdresa .weightx = 100;
	   gbcTxtEmailAdresa .fill = GridBagConstraints.HORIZONTAL;
	   gbcTxtEmailAdresa .insets = new Insets(20, 20, 0, 20);
	   panelCenter.add(txtEmailAdresa, gbcTxtEmailAdresa );
	   
	   GridBagConstraints gbcTxtDatumUpisa = new GridBagConstraints();
	   gbcTxtDatumUpisa .gridx = 1;
	   gbcTxtDatumUpisa .gridy = 7;
	   gbcTxtDatumUpisa .weightx = 100;
	   gbcTxtDatumUpisa .fill = GridBagConstraints.HORIZONTAL;
	   gbcTxtDatumUpisa .insets = new Insets(20, 20, 0, 20);
	   panelCenter.add(txtDatumUpisa, gbcTxtDatumUpisa );
	   
	   GridBagConstraints gbcTxtProsecnaOcena = new GridBagConstraints();
	   gbcTxtProsecnaOcena .gridx = 1;
	   gbcTxtProsecnaOcena .gridy = 8;
	   gbcTxtProsecnaOcena .weightx = 100;
	   gbcTxtProsecnaOcena .fill = GridBagConstraints.HORIZONTAL;
	   gbcTxtProsecnaOcena .insets = new Insets(20, 20, 0, 20);
	   panelCenter.add(txtProsecnaOcena, gbcTxtProsecnaOcena );
	   
	   
	   
	   
	   
	   

	   String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
	   JComboBox<String> godStud=new JComboBox<>(godinaStudija);
	   godStud.setSelectedIndex(trenutna_godina_studija-1);
	   
	   
	   
	   GridBagConstraints grd1 = new GridBagConstraints();
	   grd1.gridx = 1;
	   grd1.gridy = 9;
	   grd1.weightx = 100;
	   grd1.fill = GridBagConstraints.HORIZONTAL;
	   grd1.insets = new Insets(20, 20, 0, 20);
	   
	   panelCenter.add(godStud,grd1);
	   
	   
	   JCheckBox budzet = new JCheckBox("Budzet");
	   JCheckBox samof = new JCheckBox("Samofinansiranje");
	   if(status.toString() ==  "B") {
		   budzet.setSelected(true);
	   }else {
		   samof.setSelected(true);
	   }
	   
	   budzet.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(budzet.isSelected()) {
				   samof.setSelected(false);
			   }
		}
	});
	   
	   samof.addActionListener(new  ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			
			if(samof.isSelected()) {
				   budzet.setSelected(false);
			   }
		}
	});
	   
	   b1.addActionListener(new ActionListener() {
		   
		   
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda unosa", dialogButton);
				
				if (dialogResult == JOptionPane.YES_OPTION) {
				
				if(txtIme.getText().isEmpty() ||txtPrezime.getText().isEmpty() ||txtDatumRodjenja.getText().isEmpty() ||txtAdresa.getText().isEmpty()||txtTelefon.getText().isEmpty()||txtEmailAdresa.getText().isEmpty()||txtBrojIndeksa.getText().isEmpty()||txtDatumUpisa.getText().isEmpty()||txtProsecnaOcena.getText().isEmpty() ) {
					//System.out.println("Morate popuniti sva polja");
					JOptionPane.showMessageDialog(new JFrame(), "Sva polja moraju biti popunjena!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					//dispose();
					return;
				}
				if(budzet.isSelected()==false && samof.isSelected()==false) {
					JOptionPane.showMessageDialog(new JFrame(), "Morate selektovati ili budzet ili samofinansiranje!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					//dispose();
					return;
					
				}
				try {
					Float.parseFloat(txtProsecnaOcena.getText());
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(new JFrame(), "Prosecna ocena mora biti float!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(Float.parseFloat(txtProsecnaOcena.getText())<6.0 || Float.parseFloat(txtProsecnaOcena.getText())>10.0) {
					JOptionPane.showMessageDialog(new JFrame(), "Ocena mora biti u opsegu [6,10]!", "Greska!",
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
				
				StudentKontroler.getInstance().izmeniStudenta(StudentiJtable.rowSelectedIndex,txtIme.getText(), txtPrezime.getText(), txtDatumRodjenja.getText(), txtAdresa.getText(), Integer.parseInt(txtTelefon.getText()), txtEmailAdresa.getText(), txtBrojIndeksa.getText(), txtDatumUpisa.getText(),1, budzet.isSelected() ? Status.B : Status.S, Float.parseFloat(txtProsecnaOcena.getText()));
				dispose();
			}
			}
		});
	   
	   
	   
	   
	   GridBagConstraints grd2 = new GridBagConstraints();
	   grd2.gridx = 0;
	   grd2.gridy = 10;
	   grd2.insets = new Insets(20, 0, 0,0);
	   
	   panelCenter.add(budzet,grd2);
	   
	   GridBagConstraints grd3 = new GridBagConstraints();
	   grd3.gridx = 1;
	   grd3.gridy = 10;
	   grd3.insets = new Insets(20, 20, 0,20);
	   
	   panelCenter.add(samof,grd3);
	   
	   
	   
	   setVisible(true);
   
   
}  
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
}

}