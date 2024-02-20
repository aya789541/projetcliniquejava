package service_clinique;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import  java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
import  java.io.Serializable;
public class Medecin extends Personnel_medical implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String specialité;
	public Medecin(String nom,String prenom,String date_de_naissance,String specialité,long contact,int nbre_heure,double prix_heure) {
		super(nom,prenom, date_de_naissance,contact,nbre_heure,prix_heure);  
		this.specialité = specialité;

	}
	public String getSpecialité() {
		return specialité;
	}
	public void setSpecialité(String specialité) {
		this.specialité = specialité;
	}

	public void serialize(Medecin med) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\med.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(med);

		System.out.println(med.getNom());

		//os.flush();
		os.close();
		fos.close();
		System.out.println("Fermeture");
	}

	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\med.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Chef_clinique med=(Chef_clinique) ois.readObject();
		System.out.println(" Mon objet :"+ med.getNom());
		ois.close();
		fis.close();
	}

}
