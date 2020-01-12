package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controlleri.PredmetKontroler;
import controlleri.ProfesorKontroler;
import controlleri.StudentKontroler;
import modeli.BazaPredmeta;
import modeli.BazaProfesora;
import modeli.BazaStudenta;
import modeli.Predmet;
import modeli.Profesor;
import modeli.Student;



public class Toolbar extends JToolBar{

	private static final long serialVersionUID = 1L;
	
    public	String  stringovi_pre_dvotacke1[];
    public String  stringovi_posle_dvotacke1[] ;
    
    
   
	
	public Toolbar() {
		
		super(SwingConstants.HORIZONTAL);
			
		
		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("Dodavanje");
		btnNew.addMouseListener(new MyMouseListener());
		btnNew.setIcon(new ImageIcon("images/add-user-button.jpg"));
		
		
		add(btnNew);

		
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmena");
		btnEdit.addActionListener(new ActionListener() {
			
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
					
					
					
				}
			}
		});
		btnEdit.setIcon(new ImageIcon("images/writing.jpg"));
		
		
		add(btnEdit);
		

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Brisanje");
		btnDelete.setIcon(new ImageIcon("images/rubbish-bin.jpg"));
		
		
		add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tabovi.pozicija==0) {
					if(StudentiJtable.rowSelectedIndex >=0) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda brisanja", dialogButton);
						
						if (dialogResult == JOptionPane.YES_OPTION) {
							try {
				for(Predmet p : BazaPredmeta.getInstance().getPredmeti()) {
					for(Student s : BazaStudenta.getInstance().getStudenti()) {
						if(s.getBroj_indexa().equals(BazaStudenta.getInstance().getRow(StudentiJtable.rowSelectedIndex).getBroj_indexa())) {
							p.obrisiStudentaSaPredmeta(s);
						}
					}
					}
							}catch (Exception e1) {
								
							}
				
				StudentKontroler.getInstance().izbrisiStudenta(StudentiJtable.rowSelectedIndex);
						}
					}else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
					}
					
					
				}else if(Tabovi.pozicija==1) {
					if(ProfesorJTable.rowSelectedIndex !=-1) {


                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

                        if (dialogResult == JOptionPane.YES_OPTION) {
                        	
                        	for(Predmet predmet : BazaProfesora.getInstance().getRow(ProfesorJTable.rowSelectedIndex).getPredmetiSpisak()) {
                        			predmet.setPredmetni_profesor(null);
                        	}
                        	
                        	
                            ProfesorKontroler.getInstance().izbrisiProfesora(ProfesorJTable.rowSelectedIndex);
                        }


                    }else {
                        JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",
                                   JOptionPane.ERROR_MESSAGE);

                            return;

                    }
					
					
				}else {
					
					if(PredmetiJtable.rowSelectedIndex >=0) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda brisanja", dialogButton);
						
						if (dialogResult == JOptionPane.YES_OPTION) {
							try {
					for (Student s : BazaStudenta.getInstance().getStudenti()) {
						for(Predmet p : s.getPredmeti()) {
							if(p.getSifra_predmeta().equals(BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex).getSifra_predmeta())) {
								s.obirisiPredmet(p);
							}
						}
					}
							}catch (Exception e1) {
								
							}
					
					try {
					for(Profesor profesor : BazaProfesora.getInstance().getProfesori()) {
							for(Predmet predmet : profesor.getPredmetiSpisak()) {
									if(predmet.getSifra_predmeta().equals(BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex).getSifra_predmeta())){  
													profesor.obrisiPredmet(predmet);
		}
							}
						
						
					}
					}catch (Exception e1) {
						
					}
					
					PredmetKontroler.getInstance().IzbrisiPredmet(PredmetiJtable.rowSelectedIndex);
				
						
						return;
					}
				}else {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Niste selektovali ni jedno polje!", "Greska!",          
						       JOptionPane.ERROR_MESSAGE);
				}
				
				
			}
			}
		});
	
		
		addSeparator();
		
		JButton btnDodavanjeStudentaNaPredmet = new JButton();
		btnDodavanjeStudentaNaPredmet.setToolTipText("Dodaj studenta na predmet");
	    btnDodavanjeStudentaNaPredmet.setIcon(new ImageIcon("images/Screenshot_14.png"));
	   
	    
	    add(btnDodavanjeStudentaNaPredmet);
	    
	    btnDodavanjeStudentaNaPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Tabovi.pozicija==2) {
					if(PredmetiJtable.rowSelectedIndex!=-1) {
						new DijalogDodavanjaStudenta(MainFrame.getInstance(),PredmetiJtable.rowSelectedIndex);
					}else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate selektovati predmet!",
								"Greska!",JOptionPane.ERROR_MESSAGE);
								return;
					}
				}else {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate se nalaziti na tabu 'Predmeti'!", "Greska!",          
						      JOptionPane.ERROR_MESSAGE);
					return;
				}
				
			}
		});
	    
	    JButton btnBrisanjeStudentaSaPredmeta = new JButton();
	    btnBrisanjeStudentaSaPredmeta.setToolTipText("Obrisi studenta sa predmeta");
	    btnBrisanjeStudentaSaPredmeta.setIcon(new ImageIcon("images/brisanje_profesora_sa_predmeta.jpg"));
	   
	    
	    add(btnBrisanjeStudentaSaPredmeta);
	    
	    
	    btnBrisanjeStudentaSaPredmeta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(Tabovi.pozicija==2) {
					if(PredmetiJtable.rowSelectedIndex!=-1) {
						new DijalogBrisanjaStudenta(MainFrame.getInstance(),PredmetiJtable.rowSelectedIndex);
					}else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate selektovati predmet!",
								"Greska!",JOptionPane.ERROR_MESSAGE);
								return;
					}
				
				
			}else {
				JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate se nalaziti na tabu 'Predmeti'!", "Greska!",          
					      JOptionPane.ERROR_MESSAGE);
				return;
				}
			}
		});
	    
	    
			
		
	  addSeparator();
	    
		JButton btnDodavanjeProfesoraNaPredmet = new JButton();
		btnDodavanjeProfesoraNaPredmet.setToolTipText("Dodavanje profesora na predmet");
		btnDodavanjeProfesoraNaPredmet.setIcon(new ImageIcon("images/profesor.jpg"));
		
		
		add(btnDodavanjeProfesoraNaPredmet);
		
		
		btnDodavanjeProfesoraNaPredmet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
					if(Tabovi.pozicija==2) {
						
						if(PredmetiJtable.rowSelectedIndex!=-1) {
							
						new DijalogDodavanjaProfesora(MainFrame.getInstance(),PredmetiJtable.rowSelectedIndex);
						}else {
							
							JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate selektovati predmet gde zelite da dodate profesora !",
									"Greska!",JOptionPane.ERROR_MESSAGE);
							return;
								
						}
					}else {
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate se nalaziti na tabu predmeti!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
						return;
					}
				
			}
		});
		
		
		
		JButton btnBrisanjeProfesoraSaPredmeta = new JButton();
		btnBrisanjeProfesoraSaPredmeta.setToolTipText("Brisanje profesora sa predmeta");
		btnBrisanjeProfesoraSaPredmeta.setIcon(new ImageIcon("images/brisanje_profesora_sa_predmeta.jpg"));
		
		
		add(btnBrisanjeProfesoraSaPredmeta);
		
		
		btnBrisanjeProfesoraSaPredmeta.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tabovi.pozicija==2) {
					
					if(PredmetiJtable.rowSelectedIndex!=-1) {
						
						
						int dialogButton = JOptionPane.YES_NO_OPTION;
			            int dialogResult = JOptionPane.showConfirmDialog(MainFrame.getInstance(), "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

			            if (dialogResult == JOptionPane.YES_OPTION) {
			            	PredmetKontroler.getInstance().obrisiProfesoraSaPredmeta(PredmetiJtable.rowSelectedIndex);
			            }
			            
			            
					}else {
						
						JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate selektovati predmet gde zelite da obrisete profesora !",
								"Greska!",JOptionPane.ERROR_MESSAGE);
						return;
							
					}
				}else {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate se nalaziti na tabu predmeti!", "Greska!",          
						       JOptionPane.ERROR_MESSAGE);
						
					return;      
				}
				
				
				
			}
		});
		
		
		
		
		
		add(Box.createHorizontalGlue());
		
		
		JTextField textField = new JTextField();
		
		textField.setPreferredSize(new Dimension(300,37));
		
		textField.setMaximumSize(new Dimension(100,37));
		
		
		add(textField);
		
		
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images/magnifying-glass.jpg"));
		
		
		JButton btnBack = new JButton();
		btnBack.setToolTipText("Ponistavanje pretrazivanja");
		btnBack.setIcon(new ImageIcon("images/sign-out.jpg"));
		
		
		add(btnSearch);
		add(btnBack);
		btnBack.setVisible(false);
		
		    //setFloatable(false);
			setBackground(Color.WHITE);
		
		
			
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				btnBack.setVisible(true);
				btnSearch.setVisible(false);
				
				
if(Tabovi.pozicija==0) {
	
	String CeoUnetiZaProfesora=textField.getText();
    StudentiJtable.FilterPrikaza(CeoUnetiZaProfesora);
	
				}else if(Tabovi.pozicija==1) {
					
                    String CeoUnetiZaProfesora=textField.getText();
                    ProfesorJTable.FilterPrikaza(CeoUnetiZaProfesora);
					
					
				}else {
					
					
					String CeoUnetiZaPredmet=textField.getText();
				
					PredmetiJtable.FilterPrikaza(CeoUnetiZaPredmet);
					
					
				    
				    
				   
				   		
				   		
				}
			
			}
				   	
 	});	
			
			
	
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnBack.setVisible(false);
				btnSearch.setVisible(true);
				
				StudentiJtable.FilterPrikaza("");
				PredmetiJtable.FilterPrikaza("");
				ProfesorJTable.FilterPrikaza("");
			}
		});
	
	}
	
	
	
}
