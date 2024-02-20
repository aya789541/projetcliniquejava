package service_clinique;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Cong�s implements Serializable  {

	private static final long serialVersionUID = 1L;
	private String Dat;
	private String dur�e;
	private Personnel_medical p;
	public Cong�s(String dat, String dur�e, Personnel_medical p) {
		super();
		Dat = dat;
		this.dur�e = dur�e;
		this.p = p;
	}
	public String getDat() {
		return Dat;
	}
	public void setDat(String dat) {
		Dat = dat;
	}
	public String getDur�e() {
		return dur�e;
	}
	public void setDur�e(String dur�e) {
		this.dur�e = dur�e;
	}
	public Personnel_medical getP() {
		return p;
	}
	public void setP(Personnel_medical p) {
		this.p = p;
	}

	public void serialize(Cong�s conge) throws Exception {
		FileOutputStream fos=new FileOutputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Conge.txt");
		ObjectOutputStream os= new ObjectOutputStream(fos);
		os.writeObject(conge);
		System.out.println("Objet s�rialis�");
		os.close();
		System.out.println("Fermeture");
	}
	public void deserialize() throws Exception {
		FileInputStream fis= new FileInputStream("C:\\Users\\DELL\\Documents\\MATLAB\\Conge.txt");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Cong�s conges=(Cong�s)ois.readObject();
		System.out.println(" Mon objet :"+conges.getDat()+" "+conges.getDur�e()+" "+conges.getP());
		ois.close();
	}

}
