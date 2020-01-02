package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleri.PredmetKontroler;

public class DijalogPredmet extends JDialog implements ActionListener{
	
	
	private static final long serialVersionUID = 9712983789179L;

	public DijalogPredmet(Dialog owner) {
		 
		 super(owner,"Dodavanje predmeta ",true);
		 
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
		 
		 JLabel lblSifra = new JLabel("Sifra predmeta*");
		 JLabel lblNaziv = new JLabel("Naziv predmeta*");
		 JLabel lblSemestar = new JLabel("Semestar*");
		 JLabel lblGodina = new JLabel("Godina studija* ");
		// JLabel lblProfesor = new JLabel("Predmetni profesor* ");
		//JLabel lblStudenti = new JLabel("Studenti koji slusaju* ");
		 
		 
		final JTextField txtSifra = new JTextField();
		final JTextField txtNaziv = new JTextField();
		//JTextField txtSemestar = new JTextField();
		// JTextField txtGodina = new JTextField();
		// JTextField txtProfesor = new JTextField();
		// JTextField txtStudenti = new JTextField();
			
		 
		 
		//LABELE
		 
		 GridBagConstraints gbcLSifra = new GridBagConstraints();
		 gbcLSifra.gridx = 0;
		 gbcLSifra.gridy = 0;
		 gbcLSifra.insets = new Insets(20, 0, 0,0);
		 panelCenter.add(lblSifra, gbcLSifra);
		 
		 
		 GridBagConstraints gbcLNaziv = new GridBagConstraints();
		 gbcLNaziv.gridx = 0;
		 gbcLNaziv.gridy = 1;
		 gbcLNaziv.insets = new Insets(20, 0, 0,0);
		 panelCenter.add(lblNaziv, gbcLNaziv);
			
		
		    GridBagConstraints gbcLSemestar = new GridBagConstraints();
			gbcLSemestar.gridx = 0;
			gbcLSemestar.gridy = 2;
			gbcLSemestar.insets = new Insets(20, 0, 0,0);
			panelCenter.add(lblSemestar, gbcLSemestar);
			
			
			
			GridBagConstraints gbcLGodina = new GridBagConstraints();
			gbcLGodina.gridx = 0;
			gbcLGodina.gridy = 3;
			gbcLGodina.insets = new Insets(20, 0, 0,0);
			panelCenter.add(lblGodina, gbcLGodina);
			
			
			
			/*GridBagConstraints gbcLProfesor = new GridBagConstraints();
			gbcLProfesor.gridx = 0;
			gbcLProfesor.gridy = 4;
			gbcLProfesor.insets = new Insets(20, 0, 0,0);
			panelCenter.add(lblProfesor, gbcLProfesor);
			
			
			GridBagConstraints gbcLStudenti = new GridBagConstraints();
			gbcLStudenti.gridx = 0;
			gbcLStudenti.gridy = 5;
			gbcLStudenti.insets = new Insets(20, 0, 0,0);
			panelCenter.add(lblStudenti, gbcLStudenti);*/
			
			//TEXTFILDOVI
			
			GridBagConstraints gbcTxtSifra = new GridBagConstraints();
			gbcTxtSifra .gridx = 1;
			gbcTxtSifra .gridy = 0;
			gbcTxtSifra .weightx = 100;
			gbcTxtSifra .fill = GridBagConstraints.HORIZONTAL;
			gbcTxtSifra .insets = new Insets(20, 20, 0, 20);
			panelCenter.add(txtSifra, gbcTxtSifra );
			
			
			GridBagConstraints gbcTxtNaziv = new GridBagConstraints();
			gbcTxtNaziv .gridx = 1;
			gbcTxtNaziv.gridy = 1;
			gbcTxtNaziv .weightx = 100;
			gbcTxtNaziv.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtNaziv .insets = new Insets(20, 20, 0, 20);
			panelCenter.add(txtNaziv, gbcTxtNaziv );
			
			
			
			String semestar[]= {"I (Prvi)","II (Drugi)","III (Treci)","IV (Cetvrti)"};
			JComboBox<String> semestarStud=new JComboBox<>(semestar);
			   
			   
			   
			GridBagConstraints grdSemestar= new GridBagConstraints();
			grdSemestar.gridx = 1;
			grdSemestar.gridy = 2;
		    grdSemestar.weightx = 100;
			grdSemestar.fill = GridBagConstraints.HORIZONTAL;
			grdSemestar.insets = new Insets(20, 20, 0, 20);
			   
			panelCenter.add(semestarStud,grdSemestar);
			
			
			
			
			String godinaStudija[]= {"I (Prva)","II (Druga)","III (Treca)","IV (Cetvrta)"};
			JComboBox<String> godStud=new JComboBox<>(godinaStudija);
			   
			   
			   
			 GridBagConstraints grdGodina = new GridBagConstraints();
			 grdGodina.gridx = 1;
			 grdGodina.gridy = 3;
			 grdGodina.weightx = 100;
			 grdGodina.fill = GridBagConstraints.HORIZONTAL;
			 grdGodina.insets = new Insets(20, 20, 0, 20);
			   
			 panelCenter.add(godStud,grdGodina);
			
			   
			   
			 potvrda.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null,
								"Da li ste sigurni?", "Potvrda unosa", dialogButton);
						
					if (dialogResult == JOptionPane.YES_OPTION) {
						
						if(txtNaziv.getText().isEmpty() || txtSifra.getText().isEmpty() ) {
								
							JOptionPane.showMessageDialog(new JFrame(), "Sva polja moraju biti popunjena!", "Greska!",          
								       JOptionPane.ERROR_MESSAGE);
								
								return;
							}
						
						
						
						String sifra=txtSifra.getText();
						String naziv=txtNaziv.getText();
						String semestar=semestarStud.getSelectedItem().toString();
						String godina = godStud.getSelectedItem().toString();
						
						
						PredmetKontroler.getInstance().dodajPredmet( sifra, naziv, semestar,godina);
						
						dispose();
						}
					}
				});
				
				
				
				
		    setVisible(true);
			   
			   
			 
			
			
			/*GridBagConstraints gbcTxtSemestar = new GridBagConstraints();
			gbcTxtSemestar.gridx = 1;
			gbcTxtSemestar.gridy = 2;
			gbcTxtSemestar .weightx = 100;
			gbcTxtSemestar.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtSemestar.insets = new Insets(20, 20, 0, 20);
			panelCenter.add(txtSemestar, gbcTxtSemestar );
			
			GridBagConstraints gbcTxtGodina = new GridBagConstraints();
			gbcTxtGodina.gridx = 1;
			gbcTxtGodina.gridy = 3;
			gbcTxtGodina .weightx = 100;
			gbcTxtGodina.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtGodina.insets = new Insets(20, 20, 0, 20);
			panelCenter.add(txtGodina, gbcTxtGodina );*/
			
		
			
		/*	GridBagConstraints gbcTxtProfesor = new GridBagConstraints();
			gbcTxtProfesor.gridx = 1;
			gbcTxtProfesor .gridy = 4;
			gbcTxtProfesor .weightx = 100;
			gbcTxtProfesor.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtProfesor.insets = new Insets(20, 20, 0, 20);
			panelCenter.add(txtProfesor, gbcTxtProfesor );
			
			GridBagConstraints gbcTxtStudenti = new GridBagConstraints();
			gbcTxtStudenti .gridx = 1;
			gbcTxtStudenti.gridy = 5;
			gbcTxtStudenti .weightx = 100;
			gbcTxtStudenti.fill = GridBagConstraints.HORIZONTAL;
			gbcTxtStudenti.insets = new Insets(20, 20, 0, 20);
			panelCenter.add(txtStudenti, gbcTxtStudenti );*/
				
			
			
			
		
	}
	
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}




	


}
	
	
	
	
	

