package rs.ac.uns.ftn.oisisi.GlavniProzor;


import java.awt.Color;
import java.awt.FlowLayout;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JPanel;





public class StatusBar extends JMenuBar {
	
	private static final long serialVersionUID = -863806568418316202L;
	
	public StatusBar() {
		
		JPanel statusBarlevi = new JPanel();
		statusBarlevi.setLayout(new FlowLayout(FlowLayout.LEFT));
		JLabel statusLabel = new JLabel("  Studentska služba");
		statusBarlevi.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		statusBarlevi.add(statusLabel);
		
		add(statusBarlevi);
		
		JPanel statusBardesni = new JPanel();
		statusBardesni.setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		DateFormat dateFormat = new SimpleDateFormat("HH:mm        dd.MM.yyyy.        ");
		Date date = new Date();
		JLabel statusLabel1 = new JLabel(dateFormat.format(date));
		statusBardesni.setBorder(BorderFactory.createMatteBorder(1, 0, 0, 0,Color.BLACK));
		statusBardesni.add(statusLabel1);
		
		
		
		add(statusBardesni);
		
		
		
	}
}
