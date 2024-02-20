package service_clinique;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import  java.io.Serializable;
public class Chef_clinique extends  Personne implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int max_cong = 200;
	private Congés[] tab_cong = new Congés[max_cong];
	private int nb_cong =0;


	public Chef_clinique(String nom,String prenom,String date_de_naissance,long contact) {
		super(prenom,nom, date_de_naissance,contact);

	}

	public Congés[] Creer_Congés(Congés cong){
		nb_cong++;
		if(nb_cong <= max_cong) {
			tab_cong[nb_cong-1] = cong;
		}
		else {

			System.out.println("vous ne pouvez pas dépasser"+ max_cong +"rendez-vous");		
		}
		return tab_cong;

	}
	public void Afficher_Congés() {

		for(int i = 0; i<nb_cong; i++) {
			int n=i+1;
			System.out.println("*---------------------------------------------------------*\n");
			System.out.println("Congé num "+n+":\n"+"Date : "+
					tab_cong[i].getDat()+"\n"+"Durée : "+tab_cong[i].getDurée()+"\n prénom du personnel medical concerné :"+tab_cong[i].getP().getPrenom()+"\n"
					+" "+tab_cong[i].getP().getNom()+"\n"
					+"Date de naissance : "+tab_cong[i].getP().getDate_de_naissance() + "\n"
					+ "contact : "+tab_cong[i].getP().getContact()+
					"\n");
		}

	}
	public void Annuler_Congés(Congés cong){
		for(int i=0;i<tab_cong.length;i++){
			if(tab_cong[i].getP().getNom() == cong.getP().getNom() &&
					tab_cong[i].getP().getPrenom() == cong.getP().getPrenom() &&
					tab_cong[i].getP().getDate_de_naissance() == cong.getP().getDate_de_naissance() && tab_cong[i].getDurée() == cong.getDurée() && tab_cong[i].getDat()==cong.getDat()
					){
				for(int j=i;j<tab_cong.length-1;j++){
					tab_cong[i]=tab_cong[i+1];
					i++;
				}
			}
		}
		tab_cong=Arrays.copyOf(tab_cong, tab_cong.length-1);
		nb_cong--;
	}
	public void consulter_salaires(Salaire salaires) {

		salaires.afficher_salaire();
	}
	public void consulter_salaire_personnelmedical_precis(Salaire salaires,Personnel_medical per) {

		salaires.afficher_salaire_precis(per);
	}
	public void serialize(Chef_clinique chef) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Chef_clinique.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(chef);

		System.out.println(chef.getNom());

		//os.flush();
		os.close();
		fos.close();
	}

	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Chef_clinique.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Chef_clinique chef=(Chef_clinique) ois.readObject();
		System.out.println(" Mon objet :"+ chef.getNom());
		ois.close();
		fis.close();
	}

}
