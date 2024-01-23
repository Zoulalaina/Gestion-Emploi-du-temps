package Gestion;

public class Classe {
	int idC;
	
	String nomC;
	
	int nbEleve;
	public int getNbEleve() {
		return nbEleve;
	}
	public void setNbEleve(int nbEleve) {
		this.nbEleve = nbEleve;
	}
	public Classe(String nomC, int nbEleve) {
		this.nomC=nomC;
		this.nbEleve=nbEleve;
		
	}
	public Classe() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getIdC() {
		return idC;
	}
	public void setIdC(int idC) {
		this.idC = idC;
	}
	public String getNomC() {
		return nomC;
	}
	public void setNomC(String nomC) {
		this.nomC = nomC;
	}

}
