import java.util.Random;
import java.util.Scanner;

/**
 * Created by Guillaume on 02/09/2015.
 */
public class Main {

	private static Joueur[] joueurs;
	private static Scanner s = new Scanner(System.in);
	private static Carte carte = new Carte();


	public static void main(String[] args) {

		boolean personnageCree = false;
		Random r = new Random();
		int nbJoueurs;
		carte.spawnEntite(0);
		carte.spawnEntite(1);


		int choix;

		// Commandes clavier

		String commandeStats = "!stats";

		// Choix début de jeu

		System.out.println("Que voulez vous faire ?");
		System.out.println("1. Créer un personnage");
		System.out.println("2. Commencer à jouer");

		choix = s.nextInt();

		// Création du personnage

		if (choix == 1) {
			CreationPersonnage cp = new CreationPersonnage();
			cp.creerPersonnage();

		}

		// Choix du nb de joueurs

		if (choix == 2) {
			System.out.println("Combien de joueurs ?");
			nbJoueurs = s.nextInt();
			joueurs = new Joueur[nbJoueurs];

			for (int i = 0; i < nbJoueurs; i++) {
				System.out.println("Nom de joueur " + (i + 1) + " ");
				String nom = s.next();
				joueurs[i] = new Joueur(55, 55, r.nextInt(65) + 1, 55, 65, nom);
			}
		}

		Joueur joueurCourant = joueurs[0];
		De deDeplacement = new De();
		int valeurDe;
		while (joueurVivant()) {
			if(joueurCourant.getNom().equals("Yams")){
				joueurCourant.setAttaque(99);
				joueurCourant.setDefense(99);
				joueurCourant.setVitesse(99);
				joueurCourant.setPdv(99);
				joueurCourant.setChance(99);
			}
			triJoueurs();

			for (int j = 0; j < joueurs.length; j++) {

				joueurCourant = joueurs[j];

				while (joueurCourant.getVie() <= 0) {
					try {
						joueurCourant = joueurs[j + 1];
					}catch(Exception e){joueurCourant=joueurs[0];j=0;}
				}

				// tour d'un joueur
				valeurDe = deDeplacement.lancerDe(joueurCourant.getVitesse());
				System.out.println("Tour du joueur " + joueurCourant.getNom() + "\n Lancer de de: avance de " + valeurDe
						+ " cases.");

				try {
					System.in.read();
				} catch (Exception e) {
				}
				for (int i = 0; i < valeurDe; i++) {
					try {
						avance(joueurCourant);
						System.out.println(carte);
						checkCase(carte.getCarte().get(joueurCourant.getEtage()).get(joueurCourant.getChemin()).getCases().get(joueurCourant.getPosition()), joueurCourant);
						try {
							Thread.sleep(1500);
						} catch (Exception e) {
						}
					}catch(Exception e){
						System.out.println("Félicitations ! Vous êtes un maître Gilles !");
						System.exit(0);
					}
				}
			}
		}


	}

	public static boolean joueurVivant() {

		for (int i = 0; i < joueurs.length; i++) {
			if (joueurs[i].pdv > 0) {
				return true;
			}
		}
		System.out.println("\n Tout les joueurs sont morts GAME OVER");
		return false;
	}

	public static void triJoueurs() {

		int taille = joueurs.length;
		Joueur transfert;
		for (int i = 0; i < taille - 1; i++) {
			if (joueurs[i].getVitesse() < joueurs[i + 1].getVitesse()) {
				transfert = joueurs[i];
				joueurs[i] = joueurs[i + 1];
				joueurs[i + 1] = transfert;
				i = 0;
			}
		}

		for (int i = 0; i < taille; i++) {
			System.out.println(joueurs[i]);
		}
	}

	public static void avance(Joueur j){

		carte.getCarte().get(j.getEtage()).get(j.getChemin()).getCases().get(j.getPosition()).setEstPersonnage(false);

		j.setPosition(j.getPosition() + 1);
		int taille=5;

		if(j.getEtage()==0) taille=5;
		if(j.getEtage()==1) taille=15;
		if(j.getEtage()==2) taille=15;
		if(j.getEtage()==3) taille=10;
		if(j.getEtage()==4) taille=5;

		if(j.getPosition()>=taille && j.getEtage()<4){
			j.setPosition(0);
			j.setEtage(j.getEtage() + 1);
			System.out.println("Vous etes a un croisement ! Choisir le chemin 1 ou le chemin 2 ?");
			int cheminChoisi=s.nextInt();

			if(cheminChoisi==1){
				j.setChemin(j.getChemin()*2);
			}
			if(cheminChoisi==2){
				j.setChemin((j.getChemin()*2)+1);
			}

		}

		carte.getCarte().get(j.getEtage()).get(j.getChemin()).getCases().get(j.getPosition()).setEstPersonnage(true);
		carte.getCarte().get(j.getEtage()).get(j.getChemin()).getCases().get(j.getPosition()).setEstVisible(true);

	}

	private static void checkCase(Case c, Joueur j){
		if(j.getEtage()==4 && j.getPosition()==4){



		}
		else {
			if (c.isEstMonstre()) {
				j.combat(j.getEtage());
				c.setEstVisible(true);
			} else if (c.isEstBonus()) {
				switch (j.getEtage()) {

					case 0:
						j.obtientBonus(new Bonus(), 1);
						break;
					case 1:
						j.obtientBonus(new Bonus(), 2);
						break;
					case 2:
						j.obtientBonus(new Bonus(), 2);
						break;
					case 3:
						j.obtientBonus(new Bonus(), 3);
						break;
					case 4:
						j.obtientBonus(new Bonus(), 3);
						break;
				}
				c.setEstVisible(true);

			} else if (c.isEstMalus()) {
				switch (j.getEtage()) {

					case 0:
						j.obtientMalus(new Malus(), 1);
						break;
					case 1:
						j.obtientMalus(new Malus(), 2);
						break;
					case 2:
						j.obtientMalus(new Malus(), 2);
						break;
					case 3:
						j.obtientMalus(new Malus(), 3);
						break;
					case 4:
						j.obtientMalus(new Malus(), 3);
						break;
				}
				c.setEstVisible(true);

			}
		}
	}
}
