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

import javax.swing.*;

public class EdtClasse extends JFrame{
	JPanel pane= new JPanel();
	JComboBox nomM = new JComboBox();
	JComboBox nomM2 = new JComboBox();
	JButton b = new JButton("Ajouter");
	JButton b2 = new JButton("Afficher");
	JButton b3 = new JButton("Occupation");
	static final String DB_URL = "jdbc:mysql://localhost/bd_edt";
    static final String USER = "root";
    static final String PASS = "";
	TableauDePanels t = new TableauDePanels();

	public EdtClasse() {
		this. setDefaultCloseOperation ( JFrame . EXIT_ON_CLOSE ) ;//bouton croix
		this. setSize (400 ,400) ; // taille de la fenetre
		this. setLocation (200 ,200) ; // place dans l’ecran
		this.setVisible(true);
		this. setContentPane ( pane ) ;
		GridLayout grille = new GridLayout (5, 1) ;
		pane.setLayout ( grille ) ;
		pane.add(nomM);
		pane.add(b);
		pane.add(nomM2);
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
	                
	                nomM.addItem(rs.getString("nomClasse"));
	                nomM2.addItem(rs.getString("nomClasse"));
	                
	           
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		
		
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				// TODO Auto-generated method stub
				EdtSwing cs= new EdtSwing();
				cs.nom.setSelectedItem(nomM.getSelectedItem());
				
			
				cs.b2.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						System.out.println(cs.bool);
						System.out.println(cs.b);
						
						String _hor=(String) cs.modifT.getSelectedItem();
						String Salle = (String) cs.nbE.getSelectedItem();
						JLabel Lsalle = new JLabel(Salle);
						String Matiere = (String) cs.nom2.getSelectedItem();
						JLabel Lmatiere= new JLabel(Matiere);
						
						try {Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
								PreparedStatement stmt = conn.prepareStatement("SELECT NomProf FROM Prof WHERE idProf = (SELECT fk_Prof from Matiere where nomMatiere= ?)");
								stmt.setString(1, Matiere);
					            //stmt.executeUpdate(sql) pour un update or delete
					            ResultSet rs = stmt.executeQuery();
					            // Extract data from result set
					            JLabel nomProf = new JLabel();
					            while (rs.next()) {
					                // Retrieve by column name
					                System.out.println(rs.getString("NomProf"));
					            	//System.out.println("ID: " + rs.getInt("id"));
					                //System.out.println(", Nom: " + rs.getString("nom"));
					               // String _nomProf=rs.getString("NomProf");
					                nomProf.setText(rs.getString("NomProf"));
					                
					            }
					              //PreparedStatement stmt2 = conn.prepareStatement("select NomProf from Prof where nomMatire= ? ");
					                
					                
					                
					                
					                String [] strn = _hor.split(" ");
									String hor = strn[0];
									String _heure = strn[1]+" "+strn[2];
									JLabel heure=new JLabel(_heure);
									JLabel Labelhor= new JLabel(hor);
								
									
									if(hor.equals("LundiMatin")) {
										
										t.panels[0][0].add(Lmatiere);
										t.panels[0][0].add(nomProf);
										t.panels[0][0].add(Lsalle);
										t.panels[0][0].add(heure);
										
										
									
									}
									
									if(hor.equals("LundiApres")) {
										
										t.panels[1][0].add(Lmatiere);
										t.panels[1][0].add(nomProf);
										t.panels[1][0].add(Lsalle);
										t.panels[1][0].add(heure);
										
										
									
									}
									if(hor.equals("MardiMatin")) {
										
										t.panels[0][1].add(Lmatiere);
										t.panels[0][1].add(nomProf);
										t.panels[0][1].add(Lsalle);
										t.panels[0][1].add(heure);
										
										
									
									}
									
									if(hor.equals("MardiApres")) {
										
										t.panels[1][1].add(Lmatiere);
										t.panels[1][1].add(nomProf);
										t.panels[1][1].add(Lsalle);
										t.panels[1][1].add(heure);
										
										
									
									}
									
									if(hor.equals("MercrediMatin")) {
										
										t.panels[0][2].add(Lmatiere);
										t.panels[0][2].add(nomProf);
										t.panels[0][2].add(Lsalle);
										t.panels[0][2].add(heure);
										
										
									
									}
									if(hor.equals("MercrediApres")) {
										
										t.panels[1][2].add(Lmatiere);
										t.panels[1][2].add(nomProf);
										t.panels[1][2].add(Lsalle);
										t.panels[1][2].add(heure);
										
										
									
									}
									if(hor.equals("JeudiMatin")) {
										
										t.panels[0][3].add(Lmatiere);
										t.panels[0][3].add(nomProf);
										t.panels[0][3].add(Lsalle);
										t.panels[0][3].add(heure);
										
										
									
									}
									if(hor.equals("JeudiApres")) {
										
										t.panels[1][3].add(Lmatiere);
										t.panels[1][3].add(nomProf);
										t.panels[1][3].add(Lsalle);
										t.panels[1][3].add(heure);
										
										
									
									}
									if(hor.equals("VendrediMatin")) {
										
										t.panels[0][4].add(Lmatiere);
										t.panels[0][4].add(nomProf);
										t.panels[0][4].add(Lsalle);
										t.panels[0][4].add(heure);
										
										
									
									}
									if(hor.equals("VendrediApres")) {
										
										t.panels[1][4].add(Lmatiere);
										t.panels[1][4].add(nomProf);
										t.panels[1][4].add(Lsalle);
										t.panels[1][4].add(heure);
										
										
									
									}
									if(hor.equals("SamediMatin")) {
										
										t.panels[0][5].add(Lmatiere);
										t.panels[0][5].add(nomProf);
										t.panels[0][5].add(Lsalle);
										t.panels[0][5].add(heure);
										
										
									
									}
					                
					                					           
					            
					        } catch (SQLException e1) {
					            e1.printStackTrace();
					        }
						
						
						

					
						
						
					}
					
				});
				
				cs.setVisible(true);
								
				cs.b3.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						
						
				

						
						t.setVisible(true);
					}
					
				});
			
				
			}
			
		});
		b3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Occupation o = new Occupation();
				o.setVisible(true);
				
			}
			
		});
		
		b2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				TableauDePanels t = new TableauDePanels();
				t.setVisible(true);
				String selected=(String) nomM2.getSelectedItem();
				try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
			           // Statement stmt = conn.createStatement();
			            
			            
			            
			            PreparedStatement stmt = conn.prepareStatement("select fk_Salle, fk_Matiere,fk_Hor from Edt where fk_Classe = (select idClasse from Classe where nomClasse= ?)");
			            stmt.setString(1, selected);
			            
				
			            //stmt.executeUpdate(sql) pour un update or delete
			            ResultSet rs = stmt.executeQuery(); 
			            // Extract data from result set
			            while (rs.next()) {
			            	//int Classe =rs.getInt("fk_Classe");
			            	int Salle =rs.getInt("fk_Salle");
			            	int Matiere =rs.getInt("fk_Matiere");
			            	int Horaire =rs.getInt("fk_Hor");
			            	try{Connection conn1 = DriverManager.getConnection(DB_URL, USER, PASS);
			            	PreparedStatement stmt1 = conn.prepareStatement("select jour, heureDebut, heureFin from Horraire where idHorraire = ? ");
			            	PreparedStatement stmt2 = conn.prepareStatement("select nomClasse from Classe where idClasse = ? ");
			            	PreparedStatement stmt3 = conn.prepareStatement("select nomSalle from Salle where idSalle = ? ");
			            	PreparedStatement stmt4 = conn.prepareStatement("select nomMatiere from Matiere where idMatiere = ? ");
			            	
			            	
			            	stmt1.setInt(1, Horaire);
			            	stmt4.setInt(1, Matiere);
			            	stmt3.setInt(1, Salle);
				            //stmt.executeUpdate(sql) pour un update or delete
				            ResultSet rs1 = stmt1.executeQuery(); 
				            ResultSet rs4 = stmt4.executeQuery(); 
				            ResultSet rs3 = stmt3.executeQuery(); 
				            // Extract data from result set
				            
				            while (rs1.next()) {
				            	while (rs4.next()) {
				            		while (rs3.next()) {
				            			
				            		
				            	
				            	String her=rs1.getString("jour");
				            	String m= rs4.getString("nomMatiere");
				            	JLabel _m=new JLabel(m);
				            	
				            	String s= rs3.getString("nomSalle");
				            	JLabel _s=new JLabel(s);
				            	JLabel _her=new JLabel(her);
				            	if(her.equals("LundiMatin")) {
									
									t.panels[0][0].add(_her);
									t.panels[0][0].add(_m);
									t.panels[0][0].add(_s);
								
									
									
									
								
								}
				            	if(her.equals("LundiApres")) {
									
									t.panels[1][0].add(_her);
									t.panels[1][0].add(_m);
									t.panels[1][0].add(_s);
									//t.panels[1][0].add(heure);
									
									
								
								}
								if(her.equals("MardiMatin")) {
									
									t.panels[0][1].add(_her);
									t.panels[0][1].add(_m);
									t.panels[0][1].add(_s);
									//t.panels[0][1].add(heure);
									
									
								
								}
								
								if(her.equals("MardiApres")) {
									
									t.panels[1][1].add(_her);
									t.panels[1][1].add(_m);
									t.panels[1][1].add(_s);
									//t.panels[1][1].add(heure);
									
									
								
								}
								
								if(her.equals("MercrediMatin")) {
									
									t.panels[0][2].add(_her);
									t.panels[0][2].add(_m);
									t.panels[0][2].add(_s);
									//t.panels[0][2].add(heure);
									
									
								
								}
								if(her.equals("MercrediApres")) {
									
									t.panels[1][2].add(_her);
									t.panels[1][2].add(_m);
									t.panels[1][2].add(_s);
									//t.panels[1][2].add(heure);
									
									
								
								}
								if(her.equals("JeudiMatin")) {
									
									t.panels[0][3].add(_her);
									t.panels[0][3].add(_m);
									t.panels[0][3].add(_s);
									//t.panels[0][3].add(heure);
									
									
								
								}
								if(her.equals("JeudiApres")) {
									
									t.panels[1][3].add(_her);
									t.panels[1][3].add(_m);
									t.panels[1][3].add(_s);
									//t.panels[1][3].add(heure);
									
									
								
								}
								if(her.equals("VendrediMatin")) {
									
									t.panels[0][4].add(_her);
									t.panels[0][4].add(_m);
									t.panels[0][4].add(_s);
									//t.panels[0][4].add(heure);
									
									
								
								}
								if(her.equals("VendrediApres")) {
									
									t.panels[1][4].add(_her);
									t.panels[1][4].add(_m);
									t.panels[1][4].add(_s);
									//t.panels[1][4].add(heure);
									
									
								
								}
								if(her.equals("SamediMatin")) {
									
									t.panels[0][5].add(_her);
									t.panels[0][5].add(_m);
									t.panels[0][5].add(_s);
									//t.panels[0][5].add(heure);
									
									
								
								}
								
								
				            	
				                
				            }
				            
				            	}}
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
