package Gestion;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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

public class EdtSwing extends JFrame{
	boolean bool=true;
	int b=0;
	JScrollPane scrollPane=new JScrollPane();
	List<Edt> classes;
	JButton Suppr=new JButton("SUPPRIMER");
	JButton b2=new JButton("AJOUTER");
	JButton b3=new JButton("AFFICHER");
	JList <String>list=new JList<>(new DefaultListModel<>());
	JList <String>list2=new JList<>(new DefaultListModel<>());
	JLabel label = new JLabel("Classe:");
	JLabel labelNb = new JLabel("Salle:");
	JLabel label2 = new JLabel("Matiere:");
	JLabel labelModif = new JLabel("Horaire:");
	//JTextField nom = new JTextField();
	JComboBox nom = new JComboBox();
	//JTextField nbE = new JTextField();
	JComboBox nbE = new JComboBox();
	//JTextField nom2 = new JTextField();
	JComboBox nom2 = new JComboBox();
	//JTextField modifT = new JTextField();
	JComboBox modifT = new JComboBox();
	Connexion cox=new Connexion();
	static final String DB_URL = "jdbc:mysql://localhost/bd_edt";
    static final String USER = "root";
    static final String PASS = "";
	public EdtSwing() {
		this. setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;//bouton croix
		this. setSize (400 ,400) ; // taille de la fenetre
		this. setLocation (200 ,200) ; // place dans l’ecran
		JPanel pane = new JPanel () ;
		
		GridLayout grille = new GridLayout (11, 1) ;
		pane.setLayout ( grille ) ;

		pane.add(scrollPane);
		this. setContentPane ( pane ) ;
		scrollPane.setViewportView(list);
		pane.add(Suppr);
		pane.add(label);
		pane.add(nom);
		pane.add(labelNb);
		pane.add(nbE);
		
		pane.add(label2);
		
		pane.add(nom2);
		pane.add(labelModif);
		pane.add(modifT);
		pane.add(b2);
		pane.add(b3);
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Classe ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                
	                nom.addItem(rs.getString("nomClasse"));
	           
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Salle ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                
	            	nbE.addItem(rs.getString("nomSalle"));
	           
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Matiere ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                
	            	nom2.addItem(rs.getString("nomMatiere"));
	           
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Horraire ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                
	            	modifT.addItem(rs.getString("jour")+" "+rs.getString("heureDebut")+" "+rs.getString("heureFin"));
	           
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		
	classes=cox.ListesEdt();
	
	DefaultListModel<String> model=(DefaultListModel<String>)list.getModel();
	DefaultListModel<String> model2=(DefaultListModel<String>)list2.getModel();
	
	for (Edt classe:classes) {
		
		String a=classe.getClasse()+" "+classe.getSalle()+" "+classe.getMatiere()+" "+classe.getHoraire();
		model.addElement(a);
	}
	
	Suppr.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String value=list.getSelectedValue();
			String []_value=value.split(" ");
			String a=_value[0];
			String b=_value[1];
			String c=_value[2];
			String d=_value[3];
			System.out.println(value);
			
			Connexion x=new Connexion();
			x.SupprimeEdt(a,b,d,c);
			model.removeElement(value);
			
		}
		
	});
	b2.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String a= (String) nom.getSelectedItem();
			String b=(String) nbE.getSelectedItem();
			String c=(String) nom2.getSelectedItem();
			String _d=(String) modifT.getSelectedItem();
			String [] sss = _d.split(" ");
			String d = sss[0];
			//int b=Integer.parseInt(_b);
			
			int nbEleve = 0;
			int nbPlace = 0;
			try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	        PreparedStatement stmt = conn.prepareStatement("select NbEleve from Classe where nomClasse = ?");
	        stmt.setString(1, a);
	        PreparedStatement stmt2 = conn.prepareStatement("select nbPlace from Salle where nomSalle = ?");
	        stmt2.setString(1, b);
	       
	        //stmt.setString(1, c.getNomC());
	        //stmt.executeUpdate(sql) pour un update or delete
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	        	nbEleve=rs.getInt("NbEleve");
	        }
	        ResultSet rs2 = stmt2.executeQuery();
	        while (rs2.next()) {
	        	nbPlace=rs2.getInt("nbPlace");
	        }
	        
			
	    } catch (SQLException e1) {
	        e1.printStackTrace();
	    }
			
			
			
			Connexion x=new Connexion();
			Edt clss=new Edt(a,b,c ,d);
						
			System.out.println(model.getSize());
			
			
			//String Selct = list.getSelectedValue();
			//String [] item=Selct.split(" ");
			
			
			if(nbEleve>nbPlace) {
				JOptionPane . showMessageDialog (null ," Place insuffisant "
						," Erreur ", JOptionPane . INFORMATION_MESSAGE ) ;
				bool = false;
				b+=1;
				
				
			}
			
			
			
			
			for(int i = 0;i<model.getSize();i++) {
				if(model.getElementAt(i).equals(a+" "+b+" "+c+" "+_d)) {
					JOptionPane . showMessageDialog (null ," Edt déjà existe "
							," Erreur ", JOptionPane . INFORMATION_MESSAGE ) ;
					bool =false;
					b+=1;
					break;
					
				}
				
			
					

			}
			for(int i = 0;i<model2.getSize();i++) {
				if(model2.getElementAt(i).equals(b+" "+_d)) {
					JOptionPane . showMessageDialog (null ," Salle indisponible "
							," Erreur ", JOptionPane . INFORMATION_MESSAGE ) ;
					bool =false;
					b+=1;
					break;
					
				}
			}
			if(bool==true) {
				x.AjoutEdt(clss);
				model.addElement(a+" "+b+" "+c+" "+_d);
				model2.addElement(b+" "+_d);
				
			}else {
				
			}
			

		}
		
	});
	 
	
//	b3.addActionListener(new ActionListener() {
//
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			String str = list.getSelectedValue();
//			String newStr=nom2.getText();
//			String _newNb=modifT.getText();
//			int newNb=Integer.parseInt(_newNb);
//			Connexion conex = new Connexion();
//			conex.ModifierClasse(newStr, str, newNb);
//			model.removeElement(str);
//			model.addElement(newStr);
//			nom2.setText("");
//			nbE.setText("");
//		
//			
//		}
//		
//	});
	
	
	
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
