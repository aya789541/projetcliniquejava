package service_clinique;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Patient extends Personne implements Serializable{

	public Patient(String nom,String prenom,String date_de_naissance,long contact) {
		super(prenom,nom, date_de_naissance,contact);  
	}


	public void serialize(Patient p) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\patient.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(p);		
		System.out.println(p.getNom());
		os.close();
		fos.close();
		System.out.println("Fermeture");
	}

	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\patient.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Chef_clinique p=(Chef_clinique) ois.readObject();
		System.out.println(" Mon objet :"+ p.getNom());
		ois.close();
		fis.close();
	}


}
