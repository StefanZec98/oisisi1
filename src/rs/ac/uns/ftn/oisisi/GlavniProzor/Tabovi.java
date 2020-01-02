package rs.ac.uns.ftn.oisisi.GlavniProzor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.table.DefaultTableModel;






//public class Tabovi extends JTabbedPane {
public class Tabovi extends JPanel {
public static int pozicija=0;
private static final long serialVersionUID = 6162048567980039381L;



	Tabovi(){

		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension tabVelicina=kit.getScreenSize();


		StudentiJtable studentiTable=new StudentiJtable();
		JTabbedPane tabovi=new JTabbedPane();

		tabovi.setPreferredSize(new Dimension(tabVelicina.width*3/4-30,tabVelicina.height*3/4-150));


		JScrollPane studentPane=new JScrollPane(studentiTable);
		ImageIcon icon1 = new ImageIcon("images/student-tab.jpg");
		ImageIcon icon2 = new ImageIcon("images/teacher.jpg");
		
		
		
		ProfesorJTable profesoriTable=new ProfesorJTable();
		JScrollPane profesorPane = new JScrollPane(profesoriTable);


		studentiTable.setFillsViewportHeight(true);

		tabovi.addTab("Studenti",icon1,studentPane);
		tabovi.addTab("Profesori",icon2,profesorPane);

		this.add(BorderLayout.CENTER,tabovi);


/* ImageIcon icon = new ImageIcon("images/student-tab.jpg");

 





   








/* this.addChangeListener((ChangeListener) new ChangeListener() {
   public void stateChanged(ChangeEvent e) {
       
      pozicija=getSelectedIndex();
      //System.out.println("Tab: " + pozicija);
   }
});*/


tabovi.addChangeListener((ChangeListener) new ChangeListener() {
   public void stateChanged(ChangeEvent e) {
       
      pozicija=tabovi.getSelectedIndex();
      //System.out.println("Tab: " + pozicija);
   }
});







       













}



}