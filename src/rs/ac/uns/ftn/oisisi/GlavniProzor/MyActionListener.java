package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyActionListener extends Tabovi implements ActionListener {
	
	private static final long serialVersionUID =19823918398L;

	@Override
	public void actionPerformed(ActionEvent e) {
	    
				  
				  if(pozicija==0) {
					  new DijalogStudent(null);
				  }else if(pozicija==1){
					  
					  new DijalogProfesor(null);
				  }else
				  	new DijalogPredmet(null);
					 	 
				 
			 	
		
	}
	
	
}
