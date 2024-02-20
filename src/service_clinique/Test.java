package service_clinique;

import java.util.Scanner;

//pour que les services fonctionnent, il est nécessaire de créer 1 Chef clinique et des personnels médicaux au moins 1 pour chaque type 
//Medecin, sécrétaire et comptable
//tout cela est dans l'option : remplir des personnels médicaux
//pour le contact c'est un numéro de téléphone
public class Test{

	public static void affichage_services(){
		try{System.out.println("******************************** BiENVENUE DANS SERVICE CLINIQUE *****************************"
				+ "\n\n\n\n"
				+ "\t\t\t\t Veuillez choisir un service\n\n"
				+ "\t\t\t\t 1.Remplir des personnels médicaux\n"
				+ "\t\t\t\t 2.Gestion rendez-vous\n"
				+ "\t\t\t\t 3.Facturation\n"
				+ "\t\t\t\t 4.Gestion salaires\n"
				+ "\t\t\t\t 5.Gestion congés\n\n");
		System.out.println("*********************************************************************************************");
		Scanner scanner = new Scanner(System.in);
		int nombre = scanner.nextInt();
		switch(nombre){
		case 1: 
			Ajouter_personnels_medicaux();
			break;
		case 2: 
			gestion_rendez_vous();
			break;
		case 3: 
			gestion_facturation();
			break;
		case 4: 
			gestion_salaire();
			break;
		case 5: 
			gestion_congés();
			break;
		default: 
			System.out.println("Default case");
			break;
		}}
		catch(Exception e) {
			affichage_services();
		}
	}

	//Ajout des différents personnels médicaux
	static Chef_clinique chef;
	static Chef_clinique Ajouter_chef() throws Exception{
		System.out.println("Veuillez ajouter le chef clinique\n");

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nom chef");
		String nom = scanner.nextLine();
		System.out.println("Prénom ");
		String prenom = scanner.nextLine();
		System.out.println("Date de naissance");
		String date = scanner.nextLine();
		System.out.println("Contact");
		long contact = scanner.nextLong();
		chef = new Chef_clinique(nom,prenom,date,contact);

		return chef;

	}
	//Medecin
	static Medecin[] med = new Medecin[100] ;
	static int nbmed = 0;
	static Medecin medc;
	static Medecin[] Ajouter_medecins() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Nom médecin");
		String nom = scanner.nextLine();
		System.out.println("Prénom médecin");
		String prenom = scanner.nextLine();
		System.out.println("Date de naissance");
		String date = scanner.nextLine();
		System.out.println("Spécialité");
		String specialite = scanner.nextLine();
		System.out.println("Contact");
		long contact = scanner.nextLong();
		System.out.println("nombre d'heures ");
		int nbre_heure =scanner.nextInt();
		System.out.println("prix par heure ");

		double prix_heure = scanner.nextDouble();

		medc=new Medecin(nom,prenom,date,specialite,contact,nbre_heure,prix_heure);
		nbmed++;
		med[nbmed-1] = medc;
		System.out.println("bonjour " + med[nbmed-1].getPrenom());
		return med;		
	}
	//Comptable
	static Comptable[] cmp = new Comptable[100];
	static int nbcmp = 0;
	static Comptable cp;
	static Comptable[] Ajouter_comptables() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("nom comptable");
		String nom = scanner.nextLine();
		System.out.println("Prénom comptable");
		String prenom = scanner.nextLine();
		System.out.println("Date de naissance");
		String date = scanner.nextLine();
		System.out.println("Contact");
		long contact = scanner.nextLong();
		System.out.println("nombre d'heures ");
		int nbre_heure =scanner.nextInt();
		System.out.println("prix par heure ");
		double prix_heure = scanner.nextDouble();
		cp=new Comptable(nom,prenom,date,contact,nbre_heure,prix_heure);
		nbcmp++;
		cmp[nbcmp-1] = cp;
		System.out.println("bonjour " + cmp[nbmed-1].getPrenom());
		return cmp;			
	}

	//secretaire
	static Secretaire[] sec = new Secretaire[100];
	static int nbsec = 0;
	static Secretaire secr ;
	static Secretaire[] Ajouter_secretaires() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("nom sécrétaire");
		String nom = scanner.nextLine();
		System.out.println("Prénom sécrétaire");
		String prenom = scanner.nextLine();
		System.out.println("Date de naissance");
		String date = scanner.nextLine();
		System.out.println("Contact");
		long contact = scanner.nextLong();
		System.out.println("nombre d'heures ");
		int nbre_heure =scanner.nextInt();
		System.out.println("prix par heure ");
		double prix_heure = scanner.nextDouble();
		secr=new Secretaire(nom,prenom,date,contact,nbre_heure,prix_heure);
		nbsec++;
		sec[nbsec-1] = secr;
		System.out.println("bonjour " + sec[nbmed-1].getPrenom());

		return sec;			
	}

	public static void Ajouter_personnels_medicaux() throws Exception {
		System.out.println("******************************** Vous pouvez choisir le type de personnels à ajouter *****************************"
				+ "\n\n\n\n"
				+ "\t\t\t\t 1.Ajouter un chef clinique\n"
				+ "\t\t\t\t 2.Ajouter des médecins\n"
				+ "\t\t\t\t 3.Ajouter des sécretaires\n"
				+ "\t\t\t\t 4.Ajouter des comptables\n"
				+ "\t\t\t\t 5.Retour au menu principal\n\n");
		Scanner scanner = new Scanner(System.in);
		int nombre = scanner.nextInt();
		switch(nombre){
		case 1: 

			Ajouter_chef();	
			Ajouter_personnels_medicaux();

			break;
		case 2: 
			Ajouter_medecins();
			Ajouter_personnels_medicaux();
			break;
		case 3: 

			Ajouter_secretaires();
			Ajouter_personnels_medicaux();
			break;
		case 4: 

			Ajouter_comptables();
			Ajouter_personnels_medicaux();
			break;
		case 5: 
			affichage_services();
			break;
		default: 
			System.out.println("Default case");
			break;}
	}

	//Pour la gestion rendez-vous

	static Rendez_vous[] tab;

	public static void Creer_rendez_vous() throws Exception {
		System.out.println("choisir un no de médecin entre 0 et "+(nbmed-1));
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		System.out.println("Ajouter patient");
		System.out.println("Nom patient");
		String nom = scanner.nextLine();
		nom = scanner .nextLine();
		System.out.println("Prénom");
		String prenom = scanner.nextLine();
		System.out.println("Date de naissance");
		String date = scanner.nextLine();
		System.out.println("Contact");
		long contact = scanner.nextLong();
		Patient p1 = new Patient(nom,prenom,date,contact);
		System.out.println("Date du rendez-vous");
		String daterdv = scanner.nextLine();
		daterdv = scanner.nextLine();
		System.out.println("heure du rendez-vous");
		String heurerdv = scanner.nextLine();
		Rendez_vous rdv= new Rendez_vous(med[n],p1,daterdv,heurerdv);

		tab = sec[1].Creer_rdv(rdv);

	}

	public static void Annuler_rendez_vous() {
		System.out.println("no du rendez vous à supprimer allant de 0 ");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		sec[1].Annuler_rendezVous(tab[n]);
	}
	public static void Afficher_rendez_vous() {
		sec[1].Afficher_rdv();
	}

	public static void gestion_rendez_vous() throws Exception {
		System.out.println("******************************** BiENVENUE DANS ESPACE SECRETAIRE *****************************"
				+ "\n\n\n\n"
				+ "\t\t\t\t Veuillez choisir une opération\n\n"
				+ "\t\t\t\t 1.Créer rendez-vous\n"
				+ "\t\t\t\t 2.Annuler rendez-vous\n"
				+ "\t\t\t\t 3.Affichage de la liste des rendez-vous\n"
				+ "\t\t\t\t 4.Retour au menu principal\n\n");
		Scanner scanner = new Scanner(System.in);
		int nombre = scanner.nextInt();
		switch(nombre){
		case 1: 
			Creer_rendez_vous();
			gestion_rendez_vous();
			break;
		case 2: 
			Annuler_rendez_vous();
			gestion_rendez_vous();

			break;
		case 3: 
			Afficher_rendez_vous();
			gestion_rendez_vous();

			break;
		case 4: 
			affichage_services();
			break;
		default: 
			System.out.println("Default case");
			break;
		}

		System.out.println("*********************************************************************************************");

	}
	//Pour la gestion facturation
	static Facture[] tab2;

	public static void Creer_facture() {

		System.out.println("Ajouter patient ");
		System.out.println("Nom patient");
		Scanner scanner = new Scanner(System.in);
		String nom = scanner.nextLine();
		System.out.println("Prénom");
		String prenom = scanner.nextLine();
		System.out.println("Date de naissance");
		String date = scanner.next();
		System.out.println("Contact");
		long contact = scanner.nextLong();
		Patient p1 = new Patient(nom,prenom,date,contact);
		System.out.println("Type de facture : h(hospitalisation)/c(consultation) ");		
		String type=scanner.nextLine();
		type=scanner.nextLine();

		System.out.println("Etat : p (payée)/n (non payée)");
		String etat = scanner.nextLine();

		Facture f1 = new Facture(etat,type,p1);
		tab2 = cmp[1].Creer_facture(f1);

	}

	public static void Afficher_Facture() {
		cmp[1].Afficher_facture();
	}



	public static void gestion_facturation() {
		System.out.println("******************************** BiENVENUE DANS ESPACE COMPTABLE *****************************"
				+ "\n\n\n\n"
				+ "\t\t\t\t Veuillez choisir votre statut\n\n"
				+ "\t\t\t\t 1.Créer facture\n"
				+ "\t\t\t\t 2.Afficher facture\n"
				+ "\t\t\t\t 3.Retour au menu principal\n\n");
		System.out.println("**********************"
				+ "***********************************************************************");

		Scanner scanner = new Scanner(System.in);
		int nombre = scanner.nextInt();
		switch(nombre){
		case 1: 
			Creer_facture();
			gestion_facturation();
			break;
		case 2: 
			Afficher_Facture();
			gestion_facturation();

			break;
		case 3: 			
			affichage_services();
			break;
		default: 
			System.out.println("Default case");
			break;
		}

	}
	//Pour la gestion des salaires

	public static void gestion_salaire() {
		System.out.println("******************************** BiENVENUE DANS ESPACE GESTION SALAIRE *****************************"
				+ "\n\n\n\n"

				+ "\t\t\t\t 1.Consulter les salaires \n"

				+ "\t\t\t\t 2.Retour au menu principal\n\n");
		System.out.println("*********************************************************************************************");

		Scanner scanner = new Scanner(System.in);
		int nombre = scanner.nextInt();
		switch(nombre){
		case 1: 
			Salaire salr = new Salaire();
			for(int i = 0; i<nbmed; i++) {
				salr.ajouter_personnel(med[i]);
			}
			for(int i = 0; i<nbcmp; i++) {
				salr.ajouter_personnel(cmp[i]);
			}
			for(int i = 0; i<nbsec; i++) {
				salr.ajouter_personnel(sec[i]);
			}
			chef.consulter_salaires(salr);
			break;

		case 2: 
			affichage_services();
			break;

		default: 
			System.out.println("Default");
			break;
		}
	}

	//Pour la gestion des congés

	static Congés[] tab3;
	public static void Creer_congés() {
		System.out.println("date congés");
		Scanner scanner = new Scanner(System.in);
		String datecongés = scanner .nextLine();
		System.out.println("période");
		String periode = scanner .nextLine();
		System.out.println("choisir un personnel médical 1:secretaire 2:médecin 3:comptable ");
		int n = scanner.nextInt();
		switch(n){
		case 1: 
			Congés c1 = new Congés(datecongés,periode,sec[0]);
			tab3 = chef.Creer_Congés(c1);

			break;
		case 2: 
			Congés c2 = new Congés(datecongés,periode,med[0]);
			tab3 = chef.Creer_Congés(c2);

			break;
		case 3: 
			Congés c3 = new Congés(datecongés,periode,cmp[0]);
			tab3 = chef.Creer_Congés(c3);

			break;
		default: 
			System.out.println("Default");
			break;
		}


	}

	public static void Annuler_congés() {
		System.out.println("no du congés à supprimer allant de 0 ");
		try (Scanner scanner = new Scanner(System.in)) {
			int n = scanner.nextInt();
			chef.Annuler_Congés(tab3[n]);
		}
	}
	public static void Afficher_congés() {
		chef.Afficher_Congés();
	}



	public static void gestion_congés() {
		System.out.println("******************************** BiENVENUE DANS ESPACE GESTION CONGES *****************************"
				+ "\n\n\n\n"
				+ "\t\t\t\t Veuillez choisir une opération\n\n"
				+ "\t\t\t\t 1.Créer congés\n"
				+ "\t\t\t\t 2.Annuler congés\n"
				+ "\t\t\t\t 3.Affichage de la liste des congés\n"
				+ "\t\t\t\t 4.Retour au menu principal\n\n");
		System.out.println("*********************************************************************************************");
		Scanner scanner = new Scanner(System.in);
		int nombre = scanner.nextInt();
		switch(nombre){
		case 1: 
			Creer_congés();
			gestion_congés();
			break;
		case 2: 
			Annuler_congés();
			gestion_congés();

			break;
		case 3: 
			Afficher_congés();
			gestion_congés();

			break;
		case 4: 

			affichage_services();
			break;
		default: 
			System.out.println("Default");
			break;
		}
	}


	public static void main(String[] args) throws Exception {
		affichage_services();





	}		


}


