package service_clinique;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Salaire {

	private Personnel_medical[] person_med;
	private int nb_persomedical ;
	private static int max_persomedical = 200;
	public Salaire() {
		person_med = new Personnel_medical[max_persomedical];
		nb_persomedical = 0;
	}
	public void ajouter_personnel(Personnel_medical personel){
		nb_persomedical++;
		if(nb_persomedical <= max_persomedical) {
			person_med[nb_persomedical-1] = personel;
		}
		else {

			System.out.println("vous ne pouvez pas dépasser"+ max_persomedical +"rendez-vous");		
		}

	}
	void afficher_salaire() {


		for(int i = 0; i<nb_persomedical; i++) {

			System.out.println(" le salaire de : "+person_med[i].getNom()+" "+person_med[i].getPrenom()+" qui a la date de  naissance suivante  : "+person_med[i].getDate_de_naissance()+"est" +"\n" +person_med[i].calculer_salaire());
		}


	}
	void afficher_salaire_precis(Personnel_medical p) {
		for(int i = 0; i<nb_persomedical; i++) {
			if(person_med[i].getNom()==p.getNom() && person_med[i].getPrenom()==p.getPrenom() && person_med[i].getDate_de_naissance()==p.getDate_de_naissance() && person_med[i].getContact()==p.getContact()) {
				System.out.println(" le salaire de : "+person_med[i].getNom()+" "+person_med[i].getPrenom()+" qui a la date de  naissance suivante  : "+person_med[i].getDate_de_naissance()+"est" +"\n" +person_med[i].calculer_salaire());
			}}
	}


}
