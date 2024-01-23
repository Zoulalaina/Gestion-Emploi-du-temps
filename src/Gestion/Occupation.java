package Gestion;

import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Occupation extends JFrame{
	JPanel pane= new JPanel();
	JComboBox salle= new JComboBox();
	JComboBox hor= new JComboBox();
	JButton b= new JButton("Voir");
	JLabel lc= new JLabel("jkbkj");
	JLabel lm= new JLabel();
	
	static final String DB_URL = "jdbc:mysql://localhost/bd_edt";
    static final String USER = "root";
    static final String PASS = "";
	
	public Occupation() {
		this. setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;//bouton croix
		this. setSize (400 ,400) ; // taille de la fenetre
		this. setLocation (200 ,200) ; // place dans l’ecran
		this.setVisible(true);
		this. setContentPane ( pane ) ;
		GridLayout grille = new GridLayout (6, 1) ;
		pane.setLayout ( grille ) ;
		pane.add(salle);
		pane.add(hor);
		pane.add(b);
		pane.add(lc);
		pane.add(lm);
		
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Salle ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                
	            	salle.addItem(rs.getString("nomSalle"));
	           
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
	                
	            	hor.addItem(rs.getString("jour")+" "+rs.getString("heureDebut")+" "+rs.getString("heureFin"));
	           
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				String selected=(String) salle.getSelectedItem();
				String selected2=(String) hor.getSelectedItem();
				String []sl=selected2.split(" ");
				String _selected2=sl[0];
				try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		        PreparedStatement stmt = conn.prepareStatement("select fk_Classe, fk_Matiere from Edt where fk_Salle = (select idSalle from Salle where nomSalle= ?) and  fk_Hor = (select idHorraire from Horraire where jour = ?)");
		        stmt.setString(1, selected);
		        stmt.setString(2, _selected2);
		        //stmt.setString(1, c.getNomC());
		        //stmt.executeUpdate(sql) pour un update or delete
		        ResultSet rs = stmt.executeQuery();
		        while (rs.next()) {
		        	int idClasse=rs.getInt("fk_Classe");
		        	int idMatiere=rs.getInt("fk_Matiere");
		        	try{Connection conn1 = DriverManager.getConnection(DB_URL, USER, PASS);
		        	PreparedStatement stmt2 = conn.prepareStatement("select nomClasse from Classe where idClasse = ? ");
		        	//PreparedStatement stmt3 = conn.prepareStatement("select nomSalle from Salle where idSalle = ? ");
		        	PreparedStatement stmt4 = conn.prepareStatement("select nomMatiere from Matiere where idMatiere = ? ");
		            stmt2.setInt(1, idClasse);
		            stmt4.setInt(1, idMatiere);
		            //stmt.setString(1, c.getNomC());
		            //stmt.executeUpdate(sql) pour un update or delete
		            ResultSet rs1 = stmt2.executeQuery();
		            ResultSet rs2 = stmt4.executeQuery();
		            while (rs1.next()) {
		            	 while (rs2.next()) {
		            	String Classe=rs1.getString("nomClasse");
		            	lc.setText(Classe);
		            	String Matiere=rs2.getString("nomMatiere");
		            	lm.setText(Matiere);
		            	
		            }
		            }
		    		
		        } catch (SQLException e1) {
		            e1.printStackTrace();
		        }
		        	
		        }
				
		    } catch (SQLException e1) {
		        e1.printStackTrace();
		    }
				
			}
			
		});
		
		
		
		
	}
	

}
