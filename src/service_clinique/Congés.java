package service_clinique;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Congés implements Serializable  {

	private static final long serialVersionUID = 1L;
	private String Dat;
	private String durée;
	private Personnel_medical p;
	public Congés(String dat, String durée, Personnel_medical p) {
		super();
		Dat = dat;
		this.durée = durée;
		this.p = p;
	}
	public String getDat() {
		return Dat;
	}
	public void setDat(String dat) {
		Dat = dat;
	}
	public String getDurée() {
		return durée;
	}
	public void setDurée(String durée) {
		this.durée = durée;
	}
	public Personnel_medical getP() {
		return p;
	}
	public void setP(Personnel_medical p) {
		this.p = p;
	}

	public void serialize(Congés conge) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Conge.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(conge);
		System.out.println("Objet sérialisé");
		os.close();
		System.out.println("Fermeture");
	}
	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Conge.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Congés conges=(Congés)ois.readObject();
		System.out.println(" Mon objet :"+conges.getDat()+" "+conges.getDurée()+" "+conges.getP());
		ois.close();
	}

}
