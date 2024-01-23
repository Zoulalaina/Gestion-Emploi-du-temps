package Gestion;

public class Matiere {
	int idM;
	String nomM;
	String profM;
	public int getIdM() {
		return idM;
	}
	public void setIdM(int idM) {
		this.idM = idM;
	}
	public String getNomM() {
		return nomM;
	}
	public void setNomM(String nomM) {
		this.nomM = nomM;
	}
	public String getProfM() {
		return profM;
	}
	public void setProfM(String profM) {
		this.profM = profM;
	}
	public Matiere(String nomM, String profM) {
		super();
		this.nomM = nomM;
		this.profM = profM;
	}
	public Matiere() {
		super();
		// TODO Auto-generated constructor stub
	}
	

}
