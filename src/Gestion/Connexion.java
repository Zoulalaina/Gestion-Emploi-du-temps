package Gestion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Connexion implements BaseDeDonne{

	@Override
	public List<Classe> ListesClasses() {
		// TODO Auto-generated method stub
		List<Classe> classes=new ArrayList<Classe>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Classe ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                Classe cl=new Classe();
	                cl.setIdC(rs.getInt("idClasse"));
	                cl.setNomC(rs.getString("nomClasse"));
	                cl.setNbEleve(rs.getInt("NbEleve"));
	                classes.add(cl);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return classes;
	}

	
	
	@Override
	public void AjoutClasse(Classe c) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("insert into Classe (nomClasse,NbEleve) values(?,?)");
        stmt.setString(1, c.getNomC());
        stmt.setInt(2, c.getNbEleve());
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}




	@Override
	public void SupprimeClasse(String a) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("delete from Classe where nomClasse = ?");
        stmt.setString(1, a);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}



	@Override
	public void ModifierClasse(String a, String b, int newNb) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("update Classe SET nomClasse= ?, NbEleve= ? where nomClasse = ?");
        stmt.setString(1, a);
        stmt.setInt(2, newNb);
        stmt.setString(3, b);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
	}


	
	public List<Salle> ListesSalle() {
		// TODO Auto-generated method stub
		List<Salle> salles=new ArrayList<Salle>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Salle ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                Salle cl=new Salle();
	                cl.setIdS(rs.getInt("idSalle"));
	                cl.setNomS(rs.getString("nomSalle"));
	                cl.setNbPlace(rs.getInt("nbPlace"));
	                salles.add(cl);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return salles;
	}



	public void AjoutSAlle(Salle c) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("insert into Salle (nomSalle, nbPlace) values(?,?)");
        stmt.setString(1, c.getNomS());
        stmt.setInt(2, c.getNbPlace());
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }

		
		
	}



	public void SupprimeSalle(String a) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("delete from Salle where nomSalle = ?");
        stmt.setString(1, a);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}



	public void ModifierSalle(String a, String b, int newNb) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("update Salle SET nomSalle= ?, nbPlace= ? where nomSalle = ?");
        stmt.setString(1, a);
        stmt.setInt(2, newNb);
        stmt.setString(3, b);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}


//Proff
	@Override
	public List<Prof> ListesProf() {
		// TODO Auto-generated method stub
		List<Prof> prof=new ArrayList<Prof>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Prof ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                Prof cl=new Prof();
	                cl.setIdP(rs.getInt("idProf"));
	                cl.setNomP(rs.getString("nomProf"));
	                prof.add(cl);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return prof;
	
	}



	public void AjoutProf(Prof c) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("insert into Prof (nomProf) values(?)");
        stmt.setString(1, c.getNomP());
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }

		
	}



	@Override
	public void SupprimeProf(String a) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("delete from Prof where nomProf = ?");
        stmt.setString(1, a);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
		
	}



	@Override
	public void ModifierProf(String a, String b) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("update Prof SET nomProf= ? where nomProf = ?");
        stmt.setString(1, a);
        stmt.setString(2, b);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}



	@Override
	public List<Horaire> ListesHoraire() {
		// TODO Auto-generated method stub
		List<Horaire> classes=new ArrayList<Horaire>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Horraire ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                Horaire cl=new Horaire();
	                cl.setIdH(rs.getInt("idHorraire"));
	                cl.setJour(rs.getString("jour"));
	                cl.setHeureD(rs.getTime("heureDebut"));
	                cl.setHeureF(rs.getTime("heureFin"));
	                classes.add(cl);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return classes;
	
		
	}



	@Override
	public void AjoutHoraire(Horaire c) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("insert into horraire (jour, heureDebut, heureFin) values(?, ?, ?)");
        stmt.setString(1, c.getJour());
        stmt.setTime(2, c.getHeureD());
        stmt.setTime(3, c.getHeureF());
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}



	@Override
	public void SupprimeHoraire(String a, Time d, Time f) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("delete from Horraire where jour = ? AND heureDebut = ? AND heureFin = ?");
        stmt.setString(1, a);
        stmt.setTime(2, d);
        stmt.setTime(3, f);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}



	@Override
	public void ModifierHoraire(String a, Time d, Time f, String new_a, Time new_d, Time new_f) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("update Horraire SET jour = ?, heureDebut = ?, heureFin = ?  where jour = ? AND heureDebut = ? AND heureFin = ?");
        stmt.setString(1, new_a);
        stmt.setTime(2, new_d);
        stmt.setTime(3, new_f);
        stmt.setString(4, a);
        stmt.setTime(5, d);
        stmt.setTime(6, f);
        
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}



	@Override
	public List<Matiere> ListesMatiere() {
		// TODO Auto-generated method stub
		List<Matiere> classes=new ArrayList<Matiere>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Matiere ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                Matiere cl=new Matiere();
	                cl.setIdM(rs.getInt("idMatiere"));
	                cl.setNomM(rs.getString("nomMatiere"));
	                cl.setProfM(rs.getString("fk_Prof"));
	                classes.add(cl);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return classes;
	
	}



	@Override
	public void AjoutMatiere(Matiere c) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("insert into Matiere (nomMatiere,fk_Prof) select ?, idProf from Prof where NomProf = ? ");
        
        stmt.setString(1, c.getNomM());
        stmt.setString(2, c.getProfM());
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
        
        
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}



	@Override
	public void SupprimeMatiere(String a) {
		// TODO Auto-generated method stub
		
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("delete from Matiere where nomMatiere = ?");
        stmt.setString(1, a);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
	}



	@Override
	public void ModifierMatiere(String a, String b, String new_a) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("update Matiere SET nomMatiere= ?, fk_Prof= (select idProf from Prof where NomProf = ?) where nomMatiere = ?");
        stmt.setString(1, a);
        stmt.setString(2, b);
        stmt.setString(3, new_a);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}
	
	
	
	@Override
	public List<Edt> ListesEdt() {
		// TODO Auto-generated method stub
		List<Edt> classes=new ArrayList<Edt>();
		try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	            Statement stmt = conn.createStatement();
	            //stmt.executeUpdate(sql) pour un update or delete
	            ResultSet rs = stmt.executeQuery("select * from Edt ");) {
	            // Extract data from result set
	            while (rs.next()) {
	                // Retrieve by column name
	                
	            	//System.out.println("ID: " + rs.getInt("id"));
	                //System.out.println(", Nom: " + rs.getString("nom"));
	                Edt cl=new Edt();
	                cl.setIdE(rs.getInt("idEdt"));
//	                cl.setClasse(rs.getInt("fk_Classe"));
//	                cl.setSalle(rs.getInt("fk_Salle"));
//	                cl.setHoraire(rs.getInt("fk_Hor"));
//	                cl.setMatiere(rs.getInt("fk_Matiere"));
	                
	                
	                
	                classes.add(cl);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
		return classes;
	}
	



	@Override
	public void AjoutEdt(Edt c) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("INSERT INTO Edt (fk_Classe, fk_Salle, fk_Hor, fk_Matiere)VALUES (  \r\n"
        		+ "    (SELECT idClasse FROM Classe WHERE nomClasse = ?),  \r\n"
        		+ "    (SELECT idSalle FROM Salle WHERE nomSalle = ?),  \r\n"
        		+ "    (SELECT idHorraire FROM Horraire WHERE jour = ?), \r\n"
        		+ "    (SELECT idMatiere FROM Matiere WHERE nomMatiere = ?));");
        
        stmt.setString(1, c.getClasse());
        stmt.setString(2, c.getSalle());
        stmt.setString(3, c.getHoraire());
        stmt.setString(4, c.getMatiere());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
        
        
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
	}



	@Override
	public void SupprimeEdt(String a, String b, String c, String d) {
		// TODO Auto-generated method stub
		try{Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        PreparedStatement stmt = conn.prepareStatement("delete from Edt where (  \r\n"
        		+ "    fk_Classe=(SELECT idClasse FROM Classe WHERE nomClasse = ?) and  \r\n"
        		+ "    fk_Salle=(SELECT idSalle FROM Salle WHERE nomSalle = ?) and \r\n"
        		+ "    fk_Hor=(SELECT idHorraire FROM Horraire WHERE jour = ?) and \r\n"
        		+ "    fk_Matiere=(SELECT idMatiere FROM Matiere WHERE nomMatiere = ?));");
        stmt.setString(1, a);
        stmt.setString(2, b);
        stmt.setString(3, c);
        stmt.setString(4, d);
        //stmt.setString(1, c.getNomC());
        //stmt.executeUpdate(sql) pour un update or delete
        int rs = stmt.executeUpdate();
		
    } catch (SQLException e) {
        e.printStackTrace();
    }
		
		
		
	}



	

}
