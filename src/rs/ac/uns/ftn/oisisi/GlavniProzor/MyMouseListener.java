package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

//import javax.swing.JOptionPane;

public class MyMouseListener extends Tabovi implements MouseListener {
	
	private static final long serialVersionUID = -863806516841831620L;

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
          
		 if(arg0.getClickCount() == 1) {
			  
			  if(pozicija==0) {
				  new DijalogStudent(null);
			  }else if(pozicija==1){
				  
				  new DijalogProfesor(null);
			  }else
			  	new DijalogPredmet(null);
				 	 
			 
		 }	
	 
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

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

}
