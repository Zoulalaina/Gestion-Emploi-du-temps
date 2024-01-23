package Gestion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class ProfSwing extends JFrame{
	JScrollPane scrollPane=new JScrollPane();
	List<Prof> classes;
	JButton b=new JButton("SUPPRIMER");
	JButton b2=new JButton("AJOUTER");
	JButton b3=new JButton("MODIFIER");
	JList <String>list=new JList<>(new DefaultListModel<>());
	JLabel label = new JLabel("Entre le nom de Classes pour ajouter dans la liste:");
	JLabel label2 = new JLabel("Selectioner et entrer la nouvelle nom de la Classes:");
	JTextField nom = new JTextField();
	JTextField nom2 = new JTextField();
	Connexion cox=new Connexion();
	public ProfSwing() {
		this. setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;//bouton croix
		this. setSize (400 ,400) ; // taille de la fenetre
		this. setLocation (200 ,200) ; // place dans l’ecran
		JPanel pane = new JPanel () ;
		
		GridLayout grille = new GridLayout (8, 1) ;
		pane.setLayout ( grille ) ;

		pane.add(scrollPane);
		this. setContentPane ( pane ) ;
		scrollPane.setViewportView(list);
		pane.add(b);
		pane.add(label);
		pane.add(nom);
		pane.add(b2);
		pane.add(label2);
		
		pane.add(nom2);
		pane.add(b3);
	classes=cox.ListesProf();
	
	DefaultListModel<String> model=(DefaultListModel<String>)list.getModel();
	
	for (Prof classe:classes) {
		model.addElement(classe.getNomP());
	}
	
	b.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value=list.getSelectedValue();
			System.out.println(value);
			
			Connexion x=new Connexion();
			x.SupprimeProf(value);
			model.removeElement(value);
			
		}
		
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a= nom.getText();
			Connexion x=new Connexion();
			Prof clss=new Prof(a);
			
			
				x.AjoutProf(clss);
				model.addElement(a);
				nom.setText("");
			
			
		}
		
	});
	 
	
	b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = list.getSelectedValue();
			String newStr=nom2.getText();
			Connexion conex = new Connexion();
			conex.ModifierProf(newStr, str);
			model.removeElement(str);
			model.addElement(newStr);
			nom2.setText("");
		
			
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
