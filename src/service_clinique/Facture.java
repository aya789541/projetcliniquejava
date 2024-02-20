package service_clinique;
import java.io.Serializable;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.*;
public class Facture implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String type;
	private String etat;
	private Patient patient;
	private double montant;
	private double montant_total = 0;

	public Facture(String type, String etat,Patient p) {
		super();
		this.type = type;
		this.etat = etat;
		this.patient = p;
		montant = 0;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public double getMontant() {
		return montant;
	}
	public void setMontant(double montant) {
		this.montant = montant;
	}
	public double Calculer_montant() {
		double prix_consult = 50;
		double prix_jour = 200;
		if(type.equals("c")) {
			montant = prix_consult; 
			return montant;
		}

		else if(type.equals("h")) {
			Machine machine = new Machine(patient) ;
			machine.machine_patient(type);
			System.out.println("donner la durée de l'hospitalisation pour Mr/Mme : "+patient.getPrenom()+" "+patient.getNom()  +"\n");
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			int duree = scanner.nextInt();
			montant = duree * prix_jour;
			if(machine.getPatient().getNom() == this.patient.getNom() && machine.getPatient().getPrenom() == this.patient.getPrenom() && machine.getPatient().getDate_de_naissance() == this.patient.getDate_de_naissance() && machine.getPatient().getContact() == this.patient.getContact()) {
				montant_total = machine.getTax() + montant ;
			}
			return montant_total;
		}
		else {
			return 0;
		}
	}

	public void serialize(Facture fac) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\fac.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(fac);
		System.out.println("Objet sérialisé");
		os.close();
		System.out.println("Fermeture");
	}
	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\fac.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Facture fac=(Facture)ois.readObject();
		System.out.println(" Mon objet :"+fac.getType()+" "+fac.getEtat()+" "+fac.getPatient()+" "+fac.getMontant());
		ois.close();
	}

}