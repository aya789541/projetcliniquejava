package service_clinique;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;



public class Comptable extends Personnel_medical implements Serializable {
	private static final long serialVersionUID = 1L;
	private Facture[] tab_factures = new Facture[max_factures];

	private int nb_factures=0;

	private static int max_factures = 200;
	public Comptable(String nom,String prenom,String date_de_naissance,long contact,int nbre_heure,double prix_heure) {
		super(prenom,nom, date_de_naissance,contact,nbre_heure,prix_heure);	
	}
	public Comptable() {

	}
	public Facture[] Creer_facture(Facture f){
		nb_factures++;
		if(nb_factures <= max_factures) {
			tab_factures[nb_factures-1] = f;
		}
		else {
			System.out.println("Nombre maximal de factures atteint");		
		}
		return tab_factures;
	}
	public void Afficher_facture() {

		for(int i = 0; i<nb_factures; i++) {
			int n=i+1;
			System.out.println("*---------------------------------------------------------*\n");
			System.out.println("facture num "+n+":\n"+"Patient : "+
					tab_factures[i].getPatient().getPrenom()+" "+tab_factures[i].getPatient().getNom()+"\n"
					+"Type : "+tab_factures[i].getType() + "\n"
					+ "Etat : "+tab_factures[i].getEtat() + "\n"+"Montant : "+tab_factures[i].Calculer_montant());
		}		
	}
	public void serialize(Comptable comptable) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Comptable.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(comptable);
		System.out.println("Objet sérialisé");
		System.out.println(comptable.getNom());
		os.close();
		System.out.println("Fermeture");
	}
	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Comptable.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Comptable comptable=(Comptable)ois.readObject();
		System.out.println(" Mon objet :"+comptable.getNom()+" "+comptable.getPrenom()+" "+comptable.getDate_de_naissance()+" "+comptable.getContact()+" "+comptable.getNbre_heure()+" "+comptable.getPrix_heure());
		ois.close();
	}
}


