package Gestion;

import java.sql.Time;

public class Edt {
	int idE;
	String classe;
	String Salle;
	String Matiere;
	String horaire;
	public int getIdE() {
		return idE;
	}
	public void setIdE(int idE) {
		this.idE = idE;
	}
	public String getClasse() {
		return classe;
	}
	public void setClasse(String classe) {
		this.classe = classe;
	}
	public String getSalle() {
		return Salle;
	}
	public void setSalle(String salle) {
		Salle = salle;
	}
	public String getMatiere() {
		return Matiere;
	}
	public void setMatiere(String matiere) {
		Matiere = matiere;
	}
	public String getHoraire() {
		return horaire;
	}
	public void setHoraire(String horaire) {
		this.horaire = horaire;
	}
	public Edt(String classe, String salle, String matiere, String horaire) {
		super();
		this.classe = classe;
		Salle = salle;
		Matiere = matiere;
		this.horaire = horaire;
	}
	public Edt() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
