package Gestion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class HoraireSwing extends JFrame{
	JScrollPane scrollPane=new JScrollPane();
	List<Horaire> classes;
	JButton b=new JButton("SUPPRIMER");
	JButton b2=new JButton("AJOUTER");
	JButton b3=new JButton("MODIFIER");
	JList <String>list=new JList<>(new DefaultListModel<>());
	JLabel labelJour = new JLabel("Entre le jour:");
	JLabel labelDebut = new JLabel("Entre le Debut:");
	JLabel labelFin = new JLabel("Entre la Fin:");
	JLabel modifJour = new JLabel("Mofier le jour:");
	JLabel modifDebut = new JLabel("Modifier le Debut:");
	JLabel modifFin = new JLabel("Modifier la Fin:");
	//JLabel label2 = new JLabel("Selectioner et entrer la nouvelle nom de la Classes:");
	JTextField jour = new JTextField();
	JTextField debut = new JTextField();
	JTextField fin = new JTextField();
	JTextField jourT = new JTextField();
	JTextField debutT = new JTextField();
	JTextField finT = new JTextField();
	//JTextField nom2 = new JTextField();
	Connexion cox=new Connexion();
	public HoraireSwing() {
		this. setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;//bouton croix
		this. setSize (400 ,400) ; // taille de la fenetre
		this. setLocation (200 ,200) ; // place dans l’ecran
		JPanel pane = new JPanel () ;
		
		GridLayout grille = new GridLayout (16, 1) ;
		pane.setLayout ( grille ) ;

		pane.add(scrollPane);
		this. setContentPane ( pane ) ;
		scrollPane.setViewportView(list);
		pane.add(b);
		pane.add(labelJour);
		pane.add(jour);
		pane.add(labelDebut);
		pane.add(debut);
		pane.add(labelFin);
		pane.add(fin);
		pane.add(b2);
		pane.add(modifJour);
		
		pane.add(jourT);
		pane.add(modifDebut);
		pane.add(debutT);
		pane.add(modifFin);
		pane.add(finT);
		pane.add(b3);
	classes=cox.ListesHoraire();
	
	DefaultListModel<String> model=(DefaultListModel<String>)list.getModel();
	
	for (Horaire classe:classes) {
		model.addElement(classe.getJour()+" "+classe.getHeureD()+" "+classe.getHeureF());
	}
	
	b.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value=list.getSelectedValue();
			String [] t=value.split(" ");
			String t1=t[0];
			String t2=t[1];
			String t3=t[2];
			System.out.println(value);
			
			
	        try {
	            // Définir le format de la chaîne d'heure
	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

	            // Analyser la chaîne pour obtenir un objet Date
	            java.util.Date date = sdf.parse(t2);
	            java.util.Date date2 = sdf.parse(t3);


	            // Créer un objet Time à partir de l'objet Date
	            Time time = new Time(date.getTime());
	            Time time1 = new Time(date2.getTime());

	            System.out.println("Heure convertie en objet Time: " + time);
	            Connexion x=new Connexion();
				x.SupprimeHoraire(t1,time,time1);
				model.removeElement(value);
	        } catch (ParseException e1) {
	            e1.printStackTrace();
	        }

			
			
			//Connexion x=new Connexion();
			//x.SupprimeClasse(value);
			//model.removeElement(value);
			
		}
		
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a= jour.getText();
			String b=debut.getText();
			String c=fin.getText();
			
	        try {
	            // Définir le format de la chaîne d'heure
	            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
	           // SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm");

	            // Analyser la chaîne pour obtenir un objet Date
	            java.util.Date date = sdf.parse(b);
	            java.util.Date date2= sdf.parse(c);

	            // Créer un objet Time à partir de l'objet Date
	            Time time1 = new Time(date.getTime());
	            Time time2 = new Time(date2.getTime());

	            System.out.println("Heure convertie en objet Time: " + time1);
	            Connexion x=new Connexion();
				Horaire clss=new Horaire(a,time1,time2);
				System.out.println(model.getSize());
				boolean bool=true;
				for(int i = 0;i<model.getSize();i++) {
					if(model.getElementAt(i).equals(a+" "+time1+" "+time2)) {
						JOptionPane . showMessageDialog (null ," Classe déjà existe "
								," Erreur ", JOptionPane . INFORMATION_MESSAGE ) ;
						bool =false;
						break;
						
					}
						

				}
				if(bool==true) {
					x.AjoutHoraire(clss);
					model.addElement(a+" "+b+":00 "+c+":00");
					jour.setText("");
					debut.setText(" ");
					fin.setText(" ");
				}else {
					jour.setText("");
					debut.setText(" ");
					fin.setText(" ");
				}
	        } catch (ParseException e1) {
	            e1.printStackTrace();
	        }

			
			
			//Connexion x=new Connexion();
			//Horaire clss=new Horaire(a,time1,c);
						
			
			

		}
		
	});
	 
	
	b3.addActionListener(new ActionListener() {
 
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = list.getSelectedValue();
			String []st=str.split(" ");
			String strJ=st[0];
			String strD=st[1];
			String strF=st[2];
			
			String A= jourT.getText();
			String b=debutT.getText()+":00";
			String c=finT.getText()+":00";
			System.out.println(debutT.getText()+":00");
			
			 try {
		            // Définir le format de la chaîne d'heure
		            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		            // Analyser la chaîne pour obtenir un objet Date
		            java.util.Date date = sdf.parse(strD);
		            java.util.Date date2 = sdf.parse(strF);
		            java.util.Date new_date = sdf.parse(b);
		            java.util.Date new_date2 = sdf.parse(c);


		            // Créer un objet Time à partir de l'objet Date
		            Time time = new Time(date.getTime());
		            Time time1 = new Time(date2.getTime());
		            Time new_time = new Time(new_date.getTime());
		            Time new_time1 = new Time(new_date2.getTime());
		            
		            
		            Connexion conex = new Connexion();
					conex.ModifierHoraire(strJ, time, time1, A, new_time, new_time1);
					model.removeElement(str);
					model.addElement(A+" "+new_time+" "+new_time1);
					jourT.setText("");
		            
		            

		           
			 } catch (ParseException e1) {
		            e1.printStackTrace();
		        }

		
			
			
			
		}
		
	});
	
	
	
//		
//		
//		for(Classe c:classes) {
//			JLabel lab=new JLabel();
//			System.out.println(c.getNomC());
//			lab.setText(c.getNomC());
//			pane.add(lab);
//			
//
//			
//		}
	
	}

}
