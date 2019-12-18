package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;

public class Toolbar extends JToolBar{

	private static final long serialVersionUID = 1L;
	
	public Toolbar() {
		
		super(SwingConstants.HORIZONTAL);
		
		JPanel panLevi = new JPanel();
		panLevi.setLayout(new FlowLayout(FlowLayout.LEFT));
		add(panLevi);
		
		
		JButton btnNew = new JButton();
		btnNew.setToolTipText("Add");
		btnNew.setIcon(new ImageIcon("images/add-user-button.jpg"));
		panLevi.add(btnNew);

		//addSeparator();
		JButton btnEdit = new JButton();
		btnEdit.setToolTipText("Edit");
		btnEdit.setIcon(new ImageIcon("images/writing.jpg"));
		panLevi.add(btnEdit);

		//addSeparator();

		JButton btnDelete = new JButton();
		btnDelete.setToolTipText("Delete");
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

		
			setFloatable(false);
			setBackground(new Color(255, 255, 204));
		
		
	}
	
	
	
	
	

}
