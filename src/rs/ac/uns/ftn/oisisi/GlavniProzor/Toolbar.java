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
	
	public Toolbar() {
		
		super(SwingConstants.HORIZONTAL);
				
		
		JPanel panLevi = new JPanel();
		panLevi.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(panLevi);
		
		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("Add");
		btnNew.addMouseListener(new MyMouseListener());
		btnNew.setIcon(new ImageIcon("images/add-user-button.jpg"));
		panLevi.add(btnNew);

		//addSeparator();
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
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
		btnDelete.setToolTipText("Delete");
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(Tabovi.pozicija==0) {
					if(ProfesorJTable.rowSelectedIndex >=0) {
				StudentKontroler.getInstance().izbrisiStudenta(StudentiJtable.rowSelectedIndex);
					}else {
						JOptionPane.showMessageDialog(new JFrame(), "Niste selektovali ni jedno polje!", "Greska!",          
							       JOptionPane.ERROR_MESSAGE);
							
							return;
					}
				}else if(Tabovi.pozicija==1) {
					ProfesorKontroler.getInstance().izbrisiProfesora(ProfesorJTable.rowSelectedIndex);
				}else {
					PredmetKontroler.getInstance().IzbrisiPredmet(PredmetiJtable.rowSelectedIndex);
				}
				
				
			}
		});
		btnDelete.setIcon(new ImageIcon("images/rubbish-bin.jpg"));
		panLevi.add(btnDelete);
		
		
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
		
		
	}
	
	
	
	
	

}
