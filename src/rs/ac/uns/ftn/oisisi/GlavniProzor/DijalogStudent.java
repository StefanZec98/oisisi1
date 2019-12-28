package rs.ac.uns.ftn.oisisi.GlavniProzor;

import javax.swing.*;

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
 
   setSize(500, 500);   
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


   JTextField txtIme = new JTextField();
   JTextField txtPrezime = new JTextField();
   JTextField txtDatumRodjenja = new JTextField();
   JTextField txtAdresa = new JTextField();
   JTextField txtTelefon = new JTextField();
   JTextField txtBrojIndeksa = new JTextField();

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
   
   GridBagConstraints gbcLbTrenutnaGodinaStudija = new GridBagConstraints();
   gbcLbTrenutnaGodinaStudija.gridx = 0;
   gbcLbTrenutnaGodinaStudija.gridy = 6;
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
   
   

   String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
   JComboBox<String> godStud=new JComboBox<>(godinaStudija);
   
   
   
   GridBagConstraints grd1 = new GridBagConstraints();
   grd1.gridx = 1;
   grd1.gridy = 6;
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
   
   
   
   
   GridBagConstraints grd2 = new GridBagConstraints();
   grd2.gridx = 0;
   grd2.gridy = 7;
   grd2.insets = new Insets(20, 0, 0,0);
   
   panelCenter.add(budzet,grd2);
   
   GridBagConstraints grd3 = new GridBagConstraints();
   grd3.gridx = 1;
   grd3.gridy = 7;
   grd3.insets = new Insets(20, 20, 0,20);
   
   panelCenter.add(samof,grd3);
   
   
   
   setVisible(true);
   
   
   
}  
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
}

}