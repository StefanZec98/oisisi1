package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

import controlleri.ProfesorKontroler;
import controlleri.StudentKontroler;



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
				StudentKontroler.getInstance().izmeniStudenta(StudentiJtable.rowSelectedIndex);
				
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
				StudentKontroler.getInstance().izbrisiStudenta(StudentiJtable.rowSelectedIndex);
				}else if(Tabovi.pozicija==1) {
					ProfesorKontroler.getInstance().izbrisiProfesora(ProfesorJTable.rowSelectedIndex);
				}else {
					
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
