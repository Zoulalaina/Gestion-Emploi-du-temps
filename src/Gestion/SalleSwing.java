package Gestion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class SalleSwing extends JFrame {
	JScrollPane scrollPane=new JScrollPane();
	List<Salle> classes;
	JButton b=new JButton("SUPPRIMER");
	JButton b2=new JButton("AJOUTER");
	JButton b3=new JButton("MODIFIER");
	JList <String>list=new JList<>(new DefaultListModel<>());
	JLabel label = new JLabel("Entre le nom de Salle pour ajouter dans la liste:");
	JLabel labelNb = new JLabel("Entre le nombre d place:");
	JLabel label2 = new JLabel("Selectioner et entrer la nouvelle nom de la salle:");
	JLabel labelNew = new JLabel("Nouvelle nombre de la place de la salle:");
	JTextField nom = new JTextField();
	JTextField nbT = new JTextField();
	JTextField nom2 = new JTextField();
	JTextField newT = new JTextField();
	Connexion cox=new Connexion();
	JComboBox bx =new JComboBox(); 
	
	public SalleSwing() {
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
		pane.add(nbT);
		pane.add(b2);
		pane.add(label2);
		
		pane.add(nom2);
		pane.add(labelNew);
		pane.add(newT);
		
		
		pane.add(b3);
		
		
	classes=cox.ListesSalle();
	
	DefaultListModel<String> model=(DefaultListModel<String>)list.getModel();
	
	for (Salle classe:classes) {
		model.addElement(classe.getNomS());
	}
	
	b.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value=list.getSelectedValue();
			System.out.println(value);
			
			Connexion x=new Connexion();
			x.SupprimeSalle(value);
			model.removeElement(value);
			
		}
		
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a= nom.getText();
			String _b= nbT.getText();
			int b=Integer.parseInt(_b);
			Connexion x=new Connexion();
			Salle clss=new Salle(a,b);
			
			
			boolean bool=true;
			for(int i = 0;i<model.getSize();i++) {
				if(model.getElementAt(i).equals(a)) {
					JOptionPane . showMessageDialog (null ," Salle déjà existe "
							," Erreur ", JOptionPane . INFORMATION_MESSAGE ) ;
					bool =false;
					break;
					
				}
					

			}
			if(bool==true) {
				x.AjoutSAlle(clss);
				model.addElement(a);
				nom.setText("");
				nbT.setText("");
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
			String _newNb=newT.getText();
			int newNb=Integer.parseInt(_newNb);
			Connexion conex = new Connexion();
			conex.ModifierSalle(newStr, str, newNb);
			model.removeElement(str);
			model.addElement(newStr);
			nom2.setText("");
			newT.setText("");
		
			
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
