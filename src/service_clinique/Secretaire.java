package service_clinique;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
public class Secretaire extends Personnel_medical implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Rendez_vous[] tab_rdv;
	private int nb_rdv ;
	private static int max_rdv = 200;

	public Secretaire(String nom,String prenom,String date_de_naissance,long contact,int nbre_heure,double prix_heure) {
		super(prenom,nom, date_de_naissance,contact,nbre_heure,prix_heure);
		tab_rdv = new Rendez_vous[max_rdv];
		nb_rdv = 0;
	}
	/*public boolean Verifier_dispo(){

	}*/
	public Rendez_vous[] Creer_rdv(Rendez_vous rdv){
		nb_rdv++;
		if(nb_rdv <= max_rdv) {
			tab_rdv[nb_rdv-1] = rdv;
		}
		else {

			System.out.println("vous ne pouvez pas dépasser"+ max_rdv +"rendez-vous");		
		}
		return tab_rdv ;
	}
	public Rendez_vous[] Afficher_rdv() {

		for(int i = 0; i<nb_rdv; i++) {
			int n=i+1;
			System.out.println("*---------------------------------------------------------*\n");
			System.out.println("Rendez-vous num "+n+":\n"+"Medecin : "+
					tab_rdv[i].getMedecin().getPrenom()+" "+tab_rdv[i].getMedecin().getNom()+
					"\n"+"Patient : "+tab_rdv[i].getPatient().getNom()+" "+tab_rdv[i].getPatient().getPrenom()+"\n"
					+"Date de naissance : "+tab_rdv[i].getPatient().getDate_de_naissance() + "\n"
					+ "Date : "+tab_rdv[i].getDate()+
					"\n" + "Heure : "+tab_rdv[i].getHeure()+"\n");
		}		
		return tab_rdv;}

	public void Annuler_rendezVous(Rendez_vous rdv){
		for(int i=0;i<tab_rdv.length;i++){
			if(tab_rdv[i].getPatient().getNom() == rdv.getPatient().getNom() &&
					tab_rdv[i].getPatient().getPrenom() == rdv.getPatient().getPrenom() &&
					tab_rdv[i].getPatient().getDate_de_naissance() == rdv.getPatient().getDate_de_naissance()
					){
				for(int j=i;j<tab_rdv.length-1;j++){
					tab_rdv[i]=tab_rdv[i+1];
					i++;
				}
			}
		}
		tab_rdv=Arrays.copyOf(tab_rdv, tab_rdv.length-1);
		nb_rdv--;
	}
	public void serialize(Secretaire s) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\sec.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(s);	
		System.out.println(s.getNom());
		os.close();
		fos.close();
	}

	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\sec.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Secretaire s =(Secretaire)ois.readObject();
		ois.close();
		fis.close();
	}


}
