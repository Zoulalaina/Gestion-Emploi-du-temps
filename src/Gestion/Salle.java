package Gestion;

public class Salle {
	public Salle() {
		super();
		// TODO Auto-generated constructor stub
	}
	int idS;
	String nomS;
	int nbPlace;
	public int getNbPlace() {
		return nbPlace;
	}
	public void setNbPlace(int nbPlace) {
		this.nbPlace = nbPlace;
	}
	public int getIdS() {
		return idS;
	}
	public void setIdS(int idS) {
		this.idS = idS;
	}
	public String getNomS() {
		return nomS;
	}
	public void setNomS(String nomS) {
		this.nomS = nomS;
	}
	public Salle(String nomS, int nbPlace) {
		super();
		this.nomS = nomS;
		this.nbPlace=nbPlace;
	}
	
	

}
