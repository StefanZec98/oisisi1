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
	
	
	
    public	String  stringovi_pre_dvotacke[];
    public String  stringovi_posle_dvotacke[] ;
   	
   	
   	public static int dozvola=-1;
	
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
				DijalogStudent dijalogStudent = new DijalogStudent(null, student.getIme(), student.getPrezime(), student.getDatum_rodjenja(), student.getAdresa_stanovanja(), student.getBroj_telefona(), student.getEmail_adresa(), student.getBroj_indexa(), student.getDatum_upisa(), student.getTrenutna_godina_studija(), student.getStatus(), student.getProsecna_ocena());
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
					}
				
				
				}else if(Tabovi.pozicija==1){
					if(ProfesorJTable.rowSelectedIndex >=0) {
						Profesor profesor = BazaProfesora.getInstance().getRow(ProfesorJTable.rowSelectedIndex);
						@SuppressWarnings("unused")
						DijalogProfesor dijalogProfesor = new DijalogProfesor(null, profesor.getIme(), profesor.getPrezime(), profesor.getDatum_rodjenja(), profesor.getAdresa_stanovanja(), profesor.getKontakt_telefon(), profesor.getE_mail(), profesor.getAdresa_kancelarije(), profesor.getBroj_licne_karte(), profesor.getTitula(), profesor.getZvanje());
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
						
					}
				
				
				}else {
					
					if(PredmetiJtable.rowSelectedIndex >=0) {
					
					Predmet predmet=BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex);
					@SuppressWarnings("unused")
					DijalogPredmet dijalogPredmet=new DijalogPredmet(null,predmet.getSifra_predmeta(),
							predmet.getNaziv_predmeta(),predmet.getSemestar()-1,predmet.getGodina_studija()-1);
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
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
						int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda brisanja", dialogButton);
						
						if (dialogResult == JOptionPane.YES_OPTION) {
				for (Predmet p : BazaStudenta.getInstance().getRow(StudentiJtable.rowSelectedIndex).getPredmeti()) {
					p.obrisiStudentaSaPredmeta(BazaStudenta.getInstance().getRow(StudentiJtable.rowSelectedIndex));
				}			
				StudentKontroler.getInstance().izbrisiStudenta(StudentiJtable.rowSelectedIndex);
						}
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
					}
					
					
				}else if(Tabovi.pozicija==1) {
					if(ProfesorJTable.rowSelectedIndex !=-1) {


                        int dialogButton = JOptionPane.YES_NO_OPTION;
                        int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

                        if (dialogResult == JOptionPane.YES_OPTION) {
                        	
                        	for(Predmet predmet : BazaProfesora.getInstance().getRow(ProfesorJTable.rowSelectedIndex).getPredmetiSpisak()) {
                        			predmet.setPredmetni_profesor(null);
                        	}
                        	
                        	
                            ProfesorKontroler.getInstance().izbrisiProfesora(ProfesorJTable.rowSelectedIndex);
                        }


                    }else {
                        JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",
                                   JOptionPane.ERROR_MESSAGE);

                            return;

                    }
					
					
				}else {
					
					if(PredmetiJtable.rowSelectedIndex >=0) {
						int dialogButton = JOptionPane.YES_NO_OPTION;
						int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda brisanja", dialogButton);
						
						if (dialogResult == JOptionPane.YES_OPTION) {
					for (Student s : BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex).getSpisak_studenata()) {
						s.obirisiPredmet(BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex));
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
					JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
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
						new DijalogDodavanjaStudenta(null,PredmetiJtable.rowSelectedIndex);
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Morate selektovati predmet!",
								"Greska!",JOptionPane.ERROR_MESSAGE);
								return;
					}
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Morate se nalaziti na tabu 'Predmeti'!", "Greska!",          
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
						new DijalogBrisanjaStudenta(null,PredmetiJtable.rowSelectedIndex);
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Morate selektovati predmet!",
								"Greska!",JOptionPane.ERROR_MESSAGE);
								return;
					}
				
				
			}else {
				JOptionPane.showMessageDialog(new JFrame(), "Morate se nalaziti na tabu 'Predmeti'!", "Greska!",          
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
							
						new DijalogDodavanjaProfesora(null,PredmetiJtable.rowSelectedIndex);
						}else {
							
							JOptionPane.showMessageDialog(new JFrame(), "Morate selektovati predmet gde zelite da dodate profesora !",
									"Greska!",JOptionPane.ERROR_MESSAGE);
							return;
								
						}
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Morate se nalaziti na tabu predmeti!", "Greska!",          
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
			            int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

			            if (dialogResult == JOptionPane.YES_OPTION) {
			            	PredmetKontroler.getInstance().obrisiProfesoraSaPredmeta(PredmetiJtable.rowSelectedIndex);
			            }
			            
			            
					}else {
						
						JOptionPane.showMessageDialog(new JFrame(), "Morate selektovati predmet gde zelite da obrisete profesora !",
								"Greska!",JOptionPane.ERROR_MESSAGE);
						return;
							
					}
				}else {
					JOptionPane.showMessageDialog(new JFrame(), "Morate se nalaziti na tabu predmeti!", "Greska!",          
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
					//pretragu studenta
				}else if(Tabovi.pozicija==1) {
					//pretraguProfesora
				}else {
					
					
					String CeoUnetiZaPredmet=textField.getText().toLowerCase();
				
				
					
					String splitovani_stringovi []=CeoUnetiZaPredmet.split("\\;");
					
					
					for(int i=0; i<splitovani_stringovi.length;i++) {
							if(!splitovani_stringovi[i].contains(":")) {
								JOptionPane.showMessageDialog(new JFrame(), "Pretraga se vrsi u formatu naziv_kolone : vrednost ;  ", "Greska!",          
									       JOptionPane.ERROR_MESSAGE);
									
								return;  
							}
						
					}
					
					
					stringovi_pre_dvotacke=new String[splitovani_stringovi.length]  ;
				    stringovi_posle_dvotacke=new String[splitovani_stringovi.length] ;
				    
				    for(int i=0; i<splitovani_stringovi.length;i++) {
				   		
				   			String nazivi[]=splitovani_stringovi[i].split("\\:");
				   			stringovi_pre_dvotacke[i]=nazivi[0];
				   			stringovi_posle_dvotacke[i]=nazivi[1];
				   				
				   		}
				    
				    for(int i=0; i<stringovi_pre_dvotacke.length;i++) {
				    		if(! stringovi_pre_dvotacke[i].contains("naziv") && ! stringovi_pre_dvotacke[i].contains("sifra")
				    				&& ! stringovi_pre_dvotacke[i].contains("semestar") && ! stringovi_pre_dvotacke[i].contains("godina") ) {
				    			
				    			JOptionPane.showMessageDialog(new JFrame(), "Pretraga se vrsi u formatu naziv_kolone : vrednost ;   ", "Greska!",          
									       JOptionPane.ERROR_MESSAGE);
									
								return;  
				    		}
				    			
				    }
				    
				    
				   	for(int i=0;i<stringovi_pre_dvotacke.length;i++) {
				   		
				   		if(stringovi_pre_dvotacke[i].equals("sifra")) {
				   			PredmetiJtable.FilterPrikaza(stringovi_posle_dvotacke[i],0);
				   		}
				   		
				   		if(stringovi_pre_dvotacke[i].equals("naziv")) {
				   			PredmetiJtable.FilterPrikaza(stringovi_posle_dvotacke[i],1);
				   		}
				   		
				   		if(stringovi_pre_dvotacke[i].equals("semestar")) {
				   			PredmetiJtable.FilterPrikaza(stringovi_posle_dvotacke[i],2);
				   		}
				   		
				   		if(stringovi_pre_dvotacke[i].equals("godina")) {
				   			PredmetiJtable.FilterPrikaza(stringovi_posle_dvotacke[i],3);
				   		}
				   		
				   	}
				  
				    
				    
				   
				   		
				   		
				}
			
			}
				   	
 	});	
			
			
	
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				btnBack.setVisible(false);
				btnSearch.setVisible(true);
				
				PredmetiJtable.FilterPrikaza("", 2);
			}
		});
	
	}
	
	
	
}
