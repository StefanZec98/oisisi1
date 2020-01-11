package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;



import controlleri.PredmetKontroler;
import controlleri.ProfesorKontroler;
import controlleri.StudentKontroler;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenta;
import modeli.Predmet;
import modeli.Profesor;
import modeli.Student;



public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = -7863806568418316202L;
	
	public MenuBar() {
		
		JMenu File = new JMenu("File");
		File.setToolTipText("File");
		JMenu Edit = new JMenu("Edit");
		Edit.setToolTipText("Edit");
		JMenu Help = new JMenu("Help");
		Help.setToolTipText("Help");
		
		JMenuItem miNew = new JMenuItem("New");
		miNew.addActionListener(new MyActionListener());
	
		JMenuItem miClose = new JMenuItem("Close");
		miClose.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
				
			}
		});
		JMenuItem miEdit = new JMenuItem("Edit");
		miEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Tabovi.pozicija==0) {
					if(StudentiJtable.rowSelectedIndex >=0) {
						
					
				Student student = BazaStudenta.getInstance().getRow(StudentiJtable.rowSelectedIndex);
				@SuppressWarnings("unused")
				DijalogStudent dijalogStudent = new DijalogStudent(MainFrame.getInstance(), student.getIme(), student.getPrezime(), student.getDatum_rodjenja(), student.getAdresa_stanovanja(), student.getBroj_telefona(), student.getEmail_adresa(), student.getBroj_indexa(), student.getDatum_upisa(), student.getTrenutna_godina_studija(), student.getStatus(), student.getProsecna_ocena());
					}else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
					}
				
				
				}else if(Tabovi.pozicija==1){
					if(ProfesorJTable.rowSelectedIndex >=0) {
						Profesor profesor = BazaProfesora.getInstance().getRow(ProfesorJTable.rowSelectedIndex);
						@SuppressWarnings("unused")
						DijalogProfesor dijalogProfesor = new DijalogProfesor(MainFrame.getInstance(), profesor.getIme(), profesor.getPrezime(), profesor.getDatum_rodjenja(), profesor.getAdresa_stanovanja(), profesor.getKontakt_telefon(), profesor.getE_mail(), profesor.getAdresa_kancelarije(), profesor.getBroj_licne_karte(), profesor.getTitula(), profesor.getZvanje());
					}else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
						
					}
				
				
				}else {
					
					if(PredmetiJtable.rowSelectedIndex >=0) {
					
					Predmet predmet=BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex);
					@SuppressWarnings("unused")
					DijalogPredmet dijalogPredmet=new DijalogPredmet(MainFrame.getInstance(),predmet.getSifra_predmeta(),
							predmet.getNaziv_predmeta(),predmet.getSemestar()-1,predmet.getGodina_studija()-1);
					}else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
					}
					
					//PredmetKontroler.getInstance().izmeniPredmet(PredmetiJtable.rowSelectedIndex);
					
				}
			}
		});
		JMenuItem miDelete = new JMenuItem("Delete");
		miDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tabovi.pozicija==0) {
					
					if(StudentiJtable.rowSelectedIndex >=0) {
						
						StudentKontroler.getInstance().izbrisiStudenta(StudentiJtable.rowSelectedIndex);
							}else {
								JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",          
									       JOptionPane.ERROR_MESSAGE);
									
									return;
							}
					
				
				}else if(Tabovi.pozicija==1) {
					if(ProfesorJTable.rowSelectedIndex >=0) {
						
						ProfesorKontroler.getInstance().izbrisiProfesora(ProfesorJTable.rowSelectedIndex);
							}else {
								JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",          
									       JOptionPane.ERROR_MESSAGE);
									
									return;
							}
					
				}else {
					if(PredmetiJtable.rowSelectedIndex >=0) {
						
						PredmetKontroler.getInstance().IzbrisiPredmet(PredmetiJtable.rowSelectedIndex);
							}else {
								JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",          
									       JOptionPane.ERROR_MESSAGE);
									
									return;
							}
					
				}
				
				
			}
		});
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog d = new JDialog(new JFrame(),"Help");
				d.setSize(500,430); 
				d.setLocationRelativeTo(MainFrame.getInstance());
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				Font font = new Font("Cyrilic", Font.BOLD, 15);
				textArea.setFont(font);
				textArea.setText("\n     Ova aplikacija sluzi kao studentska sluzba.\n"
								+"     Implementirano je dodavanje,izmena i brisanje\n"
								+"     za studente,profesore i predmete.Kao i sve pratece operacije.\n\n"
								+"     Autori:\n\n     Nemanja Dragutinovic je rodjen 9.10.1998. u Uzicu,\n"
								+"     zavrsio je medicinsku skolu '7. april' u Novom Sadu\n"
								+"     upisao je Fakultet tehnickih nauka 2017. godine,\n"
								+"     a trenutno je 3. godina na smeru Racunarstvo i automatika.\n"
								+ "\n\n     Stefan Zec je rodjen 11.03.1998. u Novom Sadu,\n"
										+"     zavrsio je medicinsku skolu '7. april' u Novom Sadu\n"
										+"     upisao je Fakultet tehnickih nauka 2017. godine,\n"
										+"     a trenutno je 3. godina na smeru Racunarstvo i automatika.\n");
								
				d.add(textArea);
				JButton b = new JButton("OK");
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						d.dispose();
					}
				});
				d.add(b,BorderLayout.SOUTH);
				d.setVisible(true);
				
			}
		});
		JMenuItem miHelp = new JMenuItem("Help");
		miHelp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JDialog d = new JDialog(new JFrame(),"Help");
				d.setSize(500,230);
				d.setLocationRelativeTo(MainFrame.getInstance());
				JTextArea textArea = new JTextArea();
				textArea.setEditable(false);
				Font font = new Font("Cyrilic", Font.BOLD, 15);
				textArea.setFont(font);
				textArea.setText("\n     Za dodavanje novog entiteta kliknite 'File'->'New' (Ctrl +N)\n"
								+"     Za gasenje programa kliknite 'File'->'Close' (Ctrl +C)\n"
								+"     Za izmenu postojeceg entiteta kliknite 'Edit'->'Edit' (Ctrl +E)\n"
								+"     Za brisanje postojeceg entiteta kliknite 'Edit'->'Delete' (Ctrl +D)\n"
								+"     Za pomoc pri radu kliknite 'Help'->'Help' (Ctrl +H)\n"
								+"     Za informacije o nama kliknite 'Help'->'About' (Ctrl +A)");
				
				d.add(textArea);
				JButton b = new JButton("OK");
				b.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						d.dispose();
					}
				});
				d.add(b,BorderLayout.SOUTH);
				d.setVisible(true);
				
			}
		});
		
		miNew.setIcon(new ImageIcon("images/add1.jpg"));
		miClose.setIcon(new ImageIcon("images/close1.jpg"));
		miEdit.setIcon(new ImageIcon("images/edit.jpg"));
		miDelete.setIcon(new ImageIcon("images/delete.jpg"));
		miAbout.setIcon(new ImageIcon("images/about.jpg"));
		miHelp.setIcon(new ImageIcon("images/help.jpg"));
		
		miNew.setPreferredSize(new Dimension(150,miNew.getPreferredSize().height));
		miEdit.setPreferredSize(new Dimension(150,miNew.getPreferredSize().height));
		miAbout.setPreferredSize(new Dimension(150,miNew.getPreferredSize().height));
		
		miNew.setMnemonic(KeyEvent.VK_N);
		KeyStroke ctrlXKeyStroke = KeyStroke.getKeyStroke("control N");
		miNew.setAccelerator(ctrlXKeyStroke);
		
		miClose.setMnemonic(KeyEvent.VK_C);
		KeyStroke ctrlXKeyStroke1 = KeyStroke.getKeyStroke("control C");
		miClose.setAccelerator(ctrlXKeyStroke1);
		
		miEdit.setMnemonic(KeyEvent.VK_E);
		KeyStroke ctrlXKeyStroke2 = KeyStroke.getKeyStroke("control E");
		miEdit.setAccelerator(ctrlXKeyStroke2);
		
		miDelete.setMnemonic(KeyEvent.VK_D);
		KeyStroke ctrlXKeyStroke3 = KeyStroke.getKeyStroke("control D");
		miDelete.setAccelerator(ctrlXKeyStroke3);
		
		miAbout.setMnemonic(KeyEvent.VK_A);
		KeyStroke ctrlXKeyStroke4 = KeyStroke.getKeyStroke("control A");
		miAbout.setAccelerator(ctrlXKeyStroke4);
		
		miHelp.setMnemonic(KeyEvent.VK_H);
		KeyStroke ctrlXKeyStroke5 = KeyStroke.getKeyStroke("control H");
		miHelp.setAccelerator(ctrlXKeyStroke5);
		
		File.add(miNew);
		File.addSeparator();
		File.add(miClose);
		
		Edit.add(miEdit);
		Edit.addSeparator();
		Edit.add(miDelete);
		
		Help.add(miHelp);
		Help.addSeparator();
		Help.add(miAbout);
		
		add(File);
		add(Edit);
		add(Help); 
		
	}

}