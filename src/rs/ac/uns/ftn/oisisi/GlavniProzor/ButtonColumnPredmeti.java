package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;


import modeli.BazaStudenta;
import modeli.Predmet;

public class ButtonColumnPredmeti extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = 1343768131059619058L;
	
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	private boolean isEditorActive = false;
	
	public ButtonColumnPredmeti(JTable table, int column) {
		
		this.table = table;
		this.table.getColumnModel().getColumn(column).setCellRenderer(this);
		this.table.getColumnModel().getColumn(column).setCellEditor(this);
		this.table.addMouseListener(this);
		
		this.renderButton = new JButton("Prikaz");
		this.editorButton = new JButton("Prikaz");
		
		this.editorButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				fireEditingStopped();
				if(StudentiJtable.rowSelectedIndex !=-1) {
				String prikaz="";
				int i=0;
				for (Predmet p : BazaStudenta.getInstance().getRow(StudentiJtable.rowSelectedIndex).getPredmeti()) {
					 prikaz += ++i+"." +" Sifra: " + p.getSifra_predmeta() + ", Naziv: " + p.getNaziv_predmeta() +  "\n";
				}
				
				
				if(BazaStudenta.getInstance().getRow(StudentiJtable.rowSelectedIndex).getPredmeti().size()!=0) {
				JOptionPane.showMessageDialog(table, prikaz,"Prikaz predmeta",JOptionPane.INFORMATION_MESSAGE);
				}else {
				JOptionPane.showMessageDialog(table, "Student ne slusa ni jedan predmet!","Prikaz studenata",JOptionPane.INFORMATION_MESSAGE);
				}
				}else {
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate selektovati studenta!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					
					return;
				}
				
					
				}
		});
		
		this.isEditorActive = false;
		
		
		
	}
	
	
	
	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}



	@Override
	public Component getTableCellRendererComponent(JTable arg0, Object arg1, boolean arg2, boolean arg3, int arg4,
			int arg5) {
		// TODO Auto-generated method stub
		return new PredmetiTablePanel(this.renderButton, 50, 50);
	}



	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return new PredmetiTablePanel(this.editorButton, 50, 50);
	}



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}



	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (table.isEditing() && table.getCellEditor() == this) {
			this.isEditorActive = true;
		}
		
	}



	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		if (isEditorActive && table.isEditing()) {
			table.getCellEditor().stopCellEditing();
		}
		isEditorActive = false;
		
	}

}
