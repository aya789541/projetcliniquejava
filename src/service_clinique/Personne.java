package service_clinique;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
public class Personne implements Serializable {

	private String nom;
	private String prenom;
	private String date_de_naissance;
	private long contact;


	public Personne() {
	}

	public Personne(String nom, String prenom, String date_de_naissance,
			long contact) {

		this.nom = nom;
		this.prenom = prenom;
		this.date_de_naissance = date_de_naissance;
		this.contact = contact;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getDate_de_naissance() {
		return date_de_naissance;
	}
	public void setDate_de_naissance(String date_de_naissance) {
		this.date_de_naissance = date_de_naissance;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(int contact) {
		this.contact = contact;
	}

	public void serialize(Personne pers) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Personne.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(pers);
		System.out.println(pers.getNom());
		os.close();
		os.flush();
		fos.close();
		System.out.println("Fermeture");
	}
	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Personne.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Personne pers=(Personne)ois.readObject();
		System.out.println(" Mon objet :"+pers.getNom());
		ois.close();
		fis.close();
	}



}


