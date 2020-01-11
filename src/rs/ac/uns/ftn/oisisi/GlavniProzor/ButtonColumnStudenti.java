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

import modeli.BazaPredmeta;
import modeli.Student;

public class ButtonColumnStudenti extends AbstractCellEditor implements TableCellRenderer, TableCellEditor, MouseListener {

	private static final long serialVersionUID = 13468131059619058L;
	
	private JButton renderButton;
	private JButton editorButton;
	private JTable table;
	private boolean isEditorActive = false;
	
	public ButtonColumnStudenti(JTable table, int column) {
		
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
				try {
				String prikaz="";
				int i=0;
				for (Student s : BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex).getSpisak_studenata()) {
					 prikaz += ++i+"." +" Ime: " + s.getIme() + " "+s.getPrezime() +", Broj indeksa: " + s.getBroj_indexa() + "\n";
				}
				
				
				if(BazaPredmeta.getInstance().getRow(PredmetiJtable.rowSelectedIndex).getSpisak_studenata().size()!=0) {
				JOptionPane.showMessageDialog(table, prikaz,"Prikaz studenata",JOptionPane.INFORMATION_MESSAGE);
				}else {
				JOptionPane.showMessageDialog(table, "Ni jedan student ne slusa ovaj predmet!","Prikaz studenata",JOptionPane.INFORMATION_MESSAGE);
				}
				}catch (Exception e1) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(MainFrame.getInstance(), "Morate selektovati predmet!", "Greska!",
					        JOptionPane.ERROR_MESSAGE);
					//dispose();
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
		return new StudentiTablePanel(this.renderButton, 50, 50);
	}



	@Override
	public Component getTableCellEditorComponent(JTable arg0, Object arg1, boolean arg2, int arg3, int arg4) {
		// TODO Auto-generated method stub
		return new StudentiTablePanel(this.editorButton, 50, 50);
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
