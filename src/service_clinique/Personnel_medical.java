package service_clinique;


public class Personnel_medical extends Personne{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Personnel_medical() {}
	private int nbre_heure;
	private double  prix_heure;

	public Personnel_medical(String nom, String prenom, String date_de_naissance,
			long contact,int nbre_heure, double prix_heure) {
		super(nom,prenom,date_de_naissance,contact);
		this.nbre_heure = nbre_heure;
		this.prix_heure = prix_heure;
	}

	public int getNbre_heure() {
		return nbre_heure;
	}
	public void setNbre_heure(int nbre_heure) {
		this.nbre_heure = nbre_heure;
	}
	public double getPrix_heure() {
		return prix_heure;
	}
	public void setPrix_heure(int prix_heure) {
		this.prix_heure = prix_heure;
	}

	public double calculer_salaire(){
		double salaire=this.nbre_heure*this.prix_heure;
		return salaire;
	}

}
