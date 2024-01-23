package Gestion;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.*;

public class ClasseSwing extends JFrame{
	JScrollPane scrollPane=new JScrollPane();
	List<Classe> classes;
	JButton b=new JButton("SUPPRIMER");
	JButton b2=new JButton("AJOUTER");
	JButton b3=new JButton("MODIFIER");
	JList <String>list=new JList<>(new DefaultListModel<>());
	JLabel label = new JLabel("Entre le nom de Classes pour ajouter dans la liste:");
	JLabel labelNb = new JLabel("Entre le nombre des élèves:");
	JLabel label2 = new JLabel("Selectioner et entrer la nouvelle nom de la Classes:");
	JLabel labelModif = new JLabel("Entre la nouvelle nombre des élèves:");
	JTextField nom = new JTextField();
	JTextField nbE = new JTextField();
	JTextField nom2 = new JTextField();
	JTextField modifT = new JTextField();
	Connexion cox=new Connexion();
	public ClasseSwing() {
		this. setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;//bouton croix
		this. setSize (400 ,400) ; // taille de la fenetre
		this. setLocation (200 ,200) ; // place dans l’ecran
		JPanel pane = new JPanel () ;
		
		GridLayout grille = new GridLayout (12, 1) ;
		pane.setLayout ( grille ) ;

		pane.add(scrollPane);
		this. setContentPane ( pane ) ;
		scrollPane.setViewportView(list);
		pane.add(b);
		pane.add(label);
		pane.add(nom);
		pane.add(labelNb);
		pane.add(nbE);
		pane.add(b2);
		pane.add(label2);
		
		pane.add(nom2);
		pane.add(labelModif);
		pane.add(modifT);
		pane.add(b3);
	classes=cox.ListesClasses();
	
	DefaultListModel<String> model=(DefaultListModel<String>)list.getModel();
	
	for (Classe classe:classes) {
		model.addElement(classe.getNomC());
	}
	
	b.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value=list.getSelectedValue();
			System.out.println(value);
			
			Connexion x=new Connexion();
			x.SupprimeClasse(value);
			model.removeElement(value);
			
		}
		
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a= nom.getText();
			String _b=nbE.getText();
			int b=Integer.parseInt(_b);
			Connexion x=new Connexion();
			Classe clss=new Classe(a,b);
						
			System.out.println(model.getSize());
			boolean bool=true;
			for(int i = 0;i<model.getSize();i++) {
				if(model.getElementAt(i).equals(a)) {
					JOptionPane . showMessageDialog (null ," Classe déjà existe "
							," Erreur ", JOptionPane . INFORMATION_MESSAGE ) ;
					bool =false;
					break;
					
				}
					

			}
			if(bool==true) {
				x.AjoutClasse(clss);
				model.addElement(a);
				nom.setText("");
				nbE.setText(" ");
			}else {
				nom.setText("");
			}
			

		}
		
	});
	 
	
	b3.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String str = list.getSelectedValue();
			String newStr=nom2.getText();
			String _newNb=modifT.getText();
			int newNb=Integer.parseInt(_newNb);
			Connexion conex = new Connexion();
			conex.ModifierClasse(newStr, str, newNb);
			model.removeElement(str);
			model.addElement(newStr);
			nom2.setText("");
			nbE.setText("");
		
			
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
