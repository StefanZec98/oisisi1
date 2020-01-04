package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
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
	
	private JTable TabelaStudenata;
	
	public String sifra;
    public String naziv;
    public 	String semestar;
   	public String godina;
	
	public Toolbar() {
		
		super(SwingConstants.HORIZONTAL);
				
		
		JPanel panLevi = new JPanel();
		panLevi.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(panLevi);
		
		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("Dodavanje");
		btnNew.addMouseListener(new MyMouseListener());
		btnNew.setIcon(new ImageIcon("images/add-user-button.jpg"));
		panLevi.add(btnNew);

		//addSeparator();
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Izmena");
		btnEdit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(Tabovi.pozicija==0) {
					if(StudentiJtable.rowSelectedIndex >=0) {
						
					
				Student student = BazaStudenta.getInstance().getRow(StudentiJtable.rowSelectedIndex);
				DijalogStudent dijalogStudent = new DijalogStudent(null, student.getIme(), student.getPrezime(), student.getDatum_rodjenja(), student.getAdresa_stanovanja(), student.getBroj_telefona(), student.getEmail_adresa(), student.getBroj_indexa(), student.getDatum_upisa(), student.getTrenutna_godina_studija(), student.getStatus(), student.getProsecna_ocena());
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
					}
				
				
				}else if(Tabovi.pozicija==1){
					if(ProfesorJTable.rowSelectedIndex >=0) {
						Profesor profesor = BazaProfesora.getInstance().getRow(ProfesorJTable.rowSelectedIndex);
						DijalogProfesor dijalogProfesor = new DijalogProfesor(null, profesor.getIme(), profesor.getPrezime(), profesor.getDatum_rodjenja(), profesor.getAdresa_stanovanja(), profesor.getKontakt_telefon(), profesor.getE_mail(), profesor.getAdresa_kancelarije(), profesor.getBroj_licne_karte(), profesor.getTitula(), profesor.getZvanje());
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
						
					}
				
				
				}else {
					
					if(PredmetiJtable.rowSelectedIndex >=0) {
					
					Predmet predmet=BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex);
					DijalogPredmet dijalogPredmet=new DijalogPredmet(null,predmet.getSifra_predmeta(),
							predmet.getNaziv_predmeta(),predmet.getSemestar()-1,predmet.getGodina_studija()-1);
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
					}
					
					//PredmetKontroler.getInstance().izmeniPredmet(PredmetiJtable.rowSelectedIndex);
					
				}
			}
		});
		btnEdit.setIcon(new ImageIcon("images/writing.jpg"));
		panLevi.add(btnEdit);

		//addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Brisanje");
		btnDelete.setIcon(new ImageIcon("images/rubbish-bin.jpg"));
		panLevi.add(btnDelete);
		
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tabovi.pozicija==0) {
					if(StudentiJtable.rowSelectedIndex >=0) {
						
						
						int dialogButton = JOptionPane.YES_NO_OPTION;
			            int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

			            if (dialogResult == JOptionPane.YES_OPTION) {
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
			            	ProfesorKontroler.getInstance().izbrisiProfesora(ProfesorJTable.rowSelectedIndex);
			            }
						
						
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
						
					}
					
					
					
				}else {
					
					if(PredmetiJtable.rowSelectedIndex !=-1) {
						
						int dialogButton = JOptionPane.YES_NO_OPTION;
			            int dialogResult = JOptionPane.showConfirmDialog(null, "Da li ste sigurni?", "Potvrda odustanka", dialogButton);

			            if (dialogResult == JOptionPane.YES_OPTION) {
			            	PredmetKontroler.getInstance().IzbrisiPredmet(PredmetiJtable.rowSelectedIndex);
			            }
						
						
						
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
						
					}
				}
			
			}
				
			
		});
	
		
			
		
		JButton btnDodavanjeProfesoraNaPredmet = new JButton();
		btnDodavanjeProfesoraNaPredmet.setToolTipText("Dodavanje profesora na predmet");
		btnDodavanjeProfesoraNaPredmet.setIcon(new ImageIcon("images/profesor.jpg"));
		panLevi.add(btnDodavanjeProfesoraNaPredmet);
		
		
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
		panLevi.add(btnBrisanjeProfesoraSaPredmeta);
		
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
		
		
		
		//addSeparator();
		
		JPanel panDesni = new JPanel();
		panDesni.setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(panDesni);
		
		
		JTextField textField = new JTextField();
		
		textField.setPreferredSize(new Dimension(300,36));
		
		
		panDesni.add(textField);
		
		
		//addSeparator();
		
		JButton btnSearch = new JButton();
		btnSearch.setToolTipText("Search");
		btnSearch.setIcon(new ImageIcon("images/magnifying-glass.jpg"));
		panDesni.add(btnSearch);

		
		    //setFloatable(false);
			setBackground(new Color(255, 255, 204));
		
		
			
		btnSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tabovi.pozicija==0) {
					//pretragu studenta
				}else if(Tabovi.pozicija==1) {
					//pretraguProfesora
				}else {
					//pretraga predmeta
					
					String CeoUnetiZaPredmet=textField.getText().toLowerCase();
					String [] splitovani_stringovi;
					
					
				    splitovani_stringovi=CeoUnetiZaPredmet.split(";");
				    
				   	
				   	
				   	for(int i=0; i<splitovani_stringovi.length;i++) {
				   		if(splitovani_stringovi[i].contains("naziv")) {
				   			String nazivi[]=splitovani_stringovi[i].split(":");
				   				naziv=nazivi[1];
				   				
				   		}
				   		 if(splitovani_stringovi[i].contains("sifra")) {
				   			String sifre[]=splitovani_stringovi[i].split(":");
			   			    sifra=sifre[1];
			   				
				   		 }
				   				
			   			/*	if(splitovani_stringovi[i].contains("semestar")) {
			   					String semestri[]=splitovani_stringovi[i].split(":");
			   					semestar=semestri[1];
			   					
			   				}
					
			   			  if(splitovani_stringovi[i].contains("godina")) {
			   				  	String godine[]=splitovani_stringovi[i].split(":");
		   						godina=godine[1];
		   						
			   			  }*/
			   			
				   		}
				   	
				   		
				   		PredmetiJtable.pronadjiPredmet(naziv, sifra);
				   		
				   		
				   	}
			}
				   	
 	});	
			
			
	
	
	
	}
	
	
	
}
