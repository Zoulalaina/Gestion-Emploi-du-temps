package Gestion;

public class Utilisateur {
	String nom;
	String prenom;
	String password;
	public Utilisateur(String nom, String prenom, String password) {
		this.nom=nom;
		this.prenom=prenom;
		this.password=password;
		
		
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	


}
