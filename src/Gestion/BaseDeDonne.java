package Gestion;

import java.sql.Time;
import java.time.LocalTime;
import java.util.List;

public interface BaseDeDonne {
	static final String DB_URL = "jdbc:mysql://localhost/bd_edt";
    static final String USER = "root";
    static final String PASS = "";
    
    public List<Classe> ListesClasses();
    public void AjoutClasse(Classe c);
    public void SupprimeClasse(String a);
    public void ModifierClasse(String a,String b, int newNb);
    
    
    public List<Salle> ListesSalle();
    public void AjoutSAlle(Salle c);
    public void SupprimeSalle(String a);
    public void ModifierSalle(String a,String b, int newNb);
    
    
    public List<Prof> ListesProf();
    public void AjoutProf(Prof c);
    public void SupprimeProf(String a);
    public void ModifierProf(String a,String b);
    
    
    public List<Horaire> ListesHoraire();
    public void AjoutHoraire(Horaire c);
    public void SupprimeHoraire(String a, Time d, Time f);
    public void ModifierHoraire(String a, Time d, Time f,String new_a, Time new_d, Time new_f);
    
    public List<Matiere> ListesMatiere();
    public void AjoutMatiere(Matiere c);
    public void SupprimeMatiere(String a);
    public void ModifierMatiere(String a, String b, String new_a);
    
    
    public List<Edt> ListesEdt();
    public void AjoutEdt( Edt c);
    public void SupprimeEdt(String a, String b, String c, String d);
    
    
    

}
