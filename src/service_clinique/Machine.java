package service_clinique;




import java.util.ArrayList;
import java.util.Random;

public class Machine {
	Patient patient ;
	String resultat, machine;
	int a;
	double tax;
	ArrayList<String> machines = new ArrayList<String>(); // Create an ArrayList of machines
	ArrayList<Integer> tax_machine = new ArrayList<>();
	ArrayList<String> resultats = new ArrayList<String>(); // Create an ArrayList of results
	Random random = new Random();
	public Machine(Patient patient){
		this.patient = patient ;
	}
	public String machine_patient(String maladie) {
		a = random.nextInt(2);
		machines.add("ECG");
		tax_machine.add(225);
		machines.add("IRM");
		tax_machine.add(155);
		machine = machines.get(a);
		tax = tax_machine.get(a) ;
		return machine ;
	}
	public void resultat() {
		a = random.nextInt(2) ;
		resultats.add("Positive") ;
		resultats.add("négative") ;
		resultat = resultats.get(a);
		System.out.println("le resultat du test :" + resultat);
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public String getResultat() {
		return resultat;
	}
	public void setResultat(String resultat) {
		this.resultat = resultat;
	}
	public String getMachine() {
		return machine;
	}
	public void setMachine(String machine) {
		this.machine = machine;
	}
	public double getTax() {
		return tax;
	}
	public void setTax(double tax) {
		this.tax = tax;
	}
	public ArrayList<String> getMachines() {
		return machines;
	}
	public void setMachines(ArrayList<String> machines) {
		this.machines = machines;
	}
	public ArrayList<Integer> getTax_machine() {
		return tax_machine;
	}
	public void setTax_machine(ArrayList<Integer> tax_machine) {
		this.tax_machine = tax_machine;
	}
	public ArrayList<String> getResultats() {
		return resultats;
	}
	public void setResultats(ArrayList<String> resultats) {
		this.resultats = resultats;
	}
	public Random getRandom() {
		return random;
	}
	public void setRandom(Random random) {
		this.random = random;
	}





}


