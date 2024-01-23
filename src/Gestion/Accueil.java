package Gestion;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Accueil extends JFrame{
	JPanel pane = new JPanel () ;
	JButton classe=new JButton("CLASSES");
	JButton salle=new JButton("SALLES");
	JButton prof=new JButton("PROF");
	JButton Horaire=new JButton("HORAIRE");
	JButton Matiere=new JButton("MATIERE");
	JButton edt=new JButton("EDT");
	
	
	public Accueil() {
		this. setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;//bouton croix
		this. setSize (400 ,400) ; // taille de la fenetre
		this . setLocation (200 ,200) ; // place dans l’ecran
		this. setContentPane ( pane ) ;
		this. setVisible ( true ) ; // afficher
		pane.add(classe);
		pane.add(salle);
		pane.add(prof);
		pane.add(Horaire);
		pane.add(Matiere);
		pane.add(edt);
		
		classe.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ClasseSwing cs= new ClasseSwing();
				cs.setVisible(true);
			}
			
		});
		
		salle.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SalleSwing cs= new SalleSwing();
				cs.setVisible(true);
			}
			
		});
		
		prof.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ProfSwing cs= new ProfSwing();
				cs.setVisible(true);
			}
			
		});
		
		Horaire.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HoraireSwing cs= new HoraireSwing();
				cs.setVisible(true);
			}
			
		});
		
		Matiere.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				MitiereSwing cs= new MitiereSwing();
				
				
			}
			
		});
		
		edt.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				EdtClasse ed = new EdtClasse();
				ed.setVisible(true);
			}
			
		});
		
		
		
		

	}

	}
	
	


