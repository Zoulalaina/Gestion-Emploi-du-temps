package Gestion;

import java.sql.Time;

public class Horaire {
	int idH;
	String jour;
	Time heureD;
	Time heureF;
	public int getIdH() {
		return idH;
	}
	public void setIdH(int idH) {
		this.idH = idH;
	}
	public String getJour() {
		return jour;
	}
	public void setJour(String jour) {
		this.jour = jour;
	}
	public Time getHeureD() {
		return heureD;
	}
	public void setHeureD(Time heureD) {
		this.heureD = heureD;
	}
	public Time getHeureF() {
		return heureF;
	}
	public void setHeureF(Time heureF) {
		this.heureF = heureF;
	}
	public Horaire(String jour, Time heureD, Time heureF) {
		super();
		this.jour = jour;
		this.heureD = heureD;
		this.heureF = heureF;
	}
	public Horaire() {
		super();
		// TODO Auto-generated constructor stub
	}
		

}
