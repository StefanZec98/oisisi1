package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Dimension;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MenuBar extends JMenuBar {
	
	private static final long serialVersionUID = -7863806568418316202L;
	
	public MenuBar() {
		
		JMenu File = new JMenu("File");
		JMenu Edit = new JMenu("Edit");
		JMenu Help = new JMenu("Help");
		
		JMenuItem miNew = new JMenuItem("New");
		JMenuItem miClose = new JMenuItem("Close");
		JMenuItem miEdit = new JMenuItem("Edit");
		JMenuItem miDelete = new JMenuItem("Delete");
		JMenuItem miAbout = new JMenuItem("About");
		JMenuItem miHelp = new JMenuItem("Help");
		
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
		add(Help); //odraditi ovo posle 
		
	}

}