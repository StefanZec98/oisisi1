package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

public class StudentiTablePanel extends JPanel {

	private static final long serialVersionUID = -3777718742688152316L;
	
	private JPanel predmetiPanel = new JPanel();
	private Component c;
	
	public StudentiTablePanel() {
		
		setLayout(new BorderLayout());
		add(predmetiPanel, BorderLayout.CENTER);
		predmetiPanel.setBackground(Color.LIGHT_GRAY);
	}
	
	public StudentiTablePanel(Component c, int leftGap, int rightGap) {
		this();
		predmetiPanel.setPreferredSize(new Dimension(leftGap, leftGap));
		add(c,BorderLayout.CENTER);
	}
	
	@Override
	public void setBackground(Color bg) {
		// TODO Auto-generated method stub
		super.setBackground(bg);
		if(predmetiPanel==null)
			return;
		predmetiPanel.setBackground(bg);
	}
}
