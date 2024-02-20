package service_clinique;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;

public class Rendez_vous {

	private Patient patient;
	private Medecin medecin;
	private String date;
	private String heure;

	public Rendez_vous(Medecin m, Patient p,String date,String heure ){
		this.medecin = m;
		this.patient = p;
		this.date =date;
		this.heure =heure;

	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getHeure() {
		return heure;
	}

	public void setHeure(String heure) {
		this.heure = heure;
	}
	public void serialize(Rendez_vous rdv) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\rdv.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(rdv);	
		os.close();
		fos.close();
		System.out.println("Fermeture");
	}

	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\rdv.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Chef_clinique rdv=(Chef_clinique) ois.readObject();
		ois.close();
		fis.close();
	}

}
