package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controlleri.PredmetKontroler;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenta;
import modeli.Profesor;

public class DijalogDodavanjaProfesora  extends JDialog implements ActionListener{

	private static final long serialVersionUID = 971293789179L;
	
	
	public DijalogDodavanjaProfesora(JFrame owner,int rowSelectedIndex) {
		 
		 super(owner,"Dodavanje profesora na predmet ",true);
		 
		 setSize(550, 200); 
		 setLocationRelativeTo(owner);
		
		 
		 JPanel panelBottom = new JPanel();
		 JButton potvrda=new JButton("Potvrda");
		 JButton odustanak=new JButton("Odustanak");
		 
		 odustanak.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
	            int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

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
		 
		 JLabel lblProfesora = new JLabel("Broj licne karte profesora* ");
		 
		 final JTextField txtLicnaKartaProfesora = new JTextField();
		
		 
		 GridBagConstraints gbcLProfesora = new GridBagConstraints();
		 gbcLProfesora.gridx = 0;
		 gbcLProfesora.gridy = 0;
		 gbcLProfesora.insets = new Insets(20, 0, 0,0);
		 panelCenter.add(lblProfesora, gbcLProfesora);
		 
		 
		 GridBagConstraints gbcTxtLicnaKartaProfesora = new GridBagConstraints();
		 gbcTxtLicnaKartaProfesora  .gridx = 1;
		 gbcTxtLicnaKartaProfesora  .gridy = 0;
		 gbcTxtLicnaKartaProfesora  .weightx = 100;
		 gbcTxtLicnaKartaProfesora  .fill = GridBagConstraints.HORIZONTAL;
		 gbcTxtLicnaKartaProfesora  .insets = new Insets(20, 20, 0, 20);
		 panelCenter.add(txtLicnaKartaProfesora, gbcTxtLicnaKartaProfesora );
	
		 
		 
		 potvrda.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda unosa", dialogButton);
				
				if (dialogResult == JOptionPane.YES_OPTION) {
				
				
				
				try {
					Long.parseLong(txtLicnaKartaProfesora.getText());
				}catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Broj licne karte moraju biti brojevi !", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					return;
				}
				
				
				
				long licna_karta=Long.parseLong(txtLicnaKartaProfesora.getText());
				
				if(BazaProfesora.getInstance().getProfesor(licna_karta)==null) {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Nismo pronasli profesora !", "Greska!",
					        JOptionPane.INFORMATION_MESSAGE);
					return;
				}else {
					Profesor profesor=BazaProfesora.getInstance().getProfesor(licna_karta);
					
					PredmetKontroler.getInstance().dodavanjeProfesoraNaPredmet(profesor,rowSelectedIndex);
					dispose();
				}
				
			
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
