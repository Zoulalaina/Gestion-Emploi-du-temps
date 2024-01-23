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

public class MitiereSwing extends JFrame{
	JScrollPane scrollPane=new JScrollPane();
	List<Matiere> classes;
	JButton b=new JButton("SUPPRIMER");
	JButton b2=new JButton("AJOUTER");
	JButton b3=new JButton("MODIFIER");
	JList <String>list=new JList<>(new DefaultListModel<>());
	JLabel label = new JLabel("Entre le nom de la matiere:");
	JLabel labelNb = new JLabel("Entre le nom de la prof:");
	JLabel label2 = new JLabel("Nouvelle nom de la matiere:");
	JLabel labelModif = new JLabel("Entre la nouvelle nom de prof:");
	JTextField nom = new JTextField();
	JTextField nbE = new JTextField();
	JTextField nom2 = new JTextField();
	JTextField modifT = new JTextField();
	Connexion cox=new Connexion();
	JComboBox bx = new JComboBox();
	JComboBox bx2 = new JComboBox();
	static final String DB_URL = "jdbc:mysql://localhost/bd_edt";
    static final String USER = "root";
    static final String PASS = "";
	public MitiereSwing() {
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
		pane.add(bx);
		pane.add(b2);
		pane.add(label2);
		
		pane.add(nom2);
		pane.add(labelModif);
		pane.add(bx2);
		pane.add(b3);
		this.setVisible(true);
		
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Prof ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                
	                bx.addItem(rs.getString("NomProf"));
	                bx2.addItem(rs.getString("NomProf"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
	classes=cox.ListesMatiere();
	
	DefaultListModel<String> model=(DefaultListModel<String>)list.getModel();
	
	for (Matiere classe:classes) {
		model.addElement(classe.getNomM());
	}
	
	b.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value=list.getSelectedValue();
			System.out.println(value);
			
			Connexion x=new Connexion();
			x.SupprimeMatiere(value);
			model.removeElement(value);
			
		}
		
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a= nom.getText();
			String _b=nbE.getText();
			String b =(String) bx.getSelectedItem();
			


			
			
			
			
			Connexion x=new Connexion();
			Matiere clss=new Matiere(a,b);
						
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
				x.AjoutMatiere(clss);
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
			String newNb = (String) bx2.getSelectedItem();


			Connexion conex = new Connexion();
			conex.ModifierMatiere(newStr, newNb, str);
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
