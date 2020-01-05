package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JPanel;

public class PredmetiTablePanel extends JPanel {

	private static final long serialVersionUID = -3777718742688152316L;
	
	private JPanel studentiPanel = new JPanel();
	private Component c;
	
	public PredmetiTablePanel() {
		
		setLayout(new BorderLayout());
		add(studentiPanel, BorderLayout.CENTER);
		studentiPanel.setBackground(Color.LIGHT_GRAY);
	}
	
	public PredmetiTablePanel(Component c, int leftGap, int rightGap) {
		this();
		studentiPanel.setPreferredSize(new Dimension(leftGap, leftGap));
		add(c,BorderLayout.CENTER);
	}
	
	@Override
	public void setBackground(Color bg) {
		// TODO Auto-generated method stub
		super.setBackground(bg);
		if(studentiPanel==null)
			return;
		studentiPanel.setBackground(bg);
	}
}
