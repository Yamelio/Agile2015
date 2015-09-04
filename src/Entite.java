import java.util.Random;
import java.util.Scanner;

abstract class Entite {
	protected int attaque, defense, vitesse, chance, pdv;

	 private static Scanner s = new Scanner(System.in);

	public Entite(int attaque, int defense, int vitesse, int chance, int pdv) {
		this.attaque = attaque;
		this.defense = defense;
		this.vitesse = vitesse;
		this.chance = chance;
		this.pdv = pdv;
	}

	public Entite() {

	}

	public abstract void perdVie(int vie);

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getVitesse() {
		return vitesse;
	}

	public void setVitesse(int vitesse) {
		this.vitesse = vitesse;
	}

	public int getChance() {
		return chance;
	}

	public void setChance(int chance) {
		this.chance = chance;
	}

	public int getPdv() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public void checkStat() {
		if (this.attaque > 99) {
			this.attaque = 99;
		}
		if (this.defense > 99) {
			this.defense = 99;
		}
		if (this.vitesse > 99) {
			this.vitesse = 99;
		}
		if (this.chance > 99) {
			this.chance = 99;
		}
		if (this.attaque < 0) {
			this.attaque = 0;
		}
		if (this.defense < 0) {
			this.defense = 0;
		}
		if (this.vitesse < 0) {
			this.vitesse = 0;
		}
		if (this.chance < 0) {
			this.chance = 0;
		}
	}

	public int attaque(Entite e) {
		Random r = new Random();
		int DeAtt = r.nextInt(100) + 1;
		int DeDef = r.nextInt(100) + 1;
		if (DeAtt <= this.getAttaque()) {
			if (DeDef <= e.getDefense()) {
				e.perdVie(this.getAttaque() / 10);
				return this.getAttaque() / 10;
			} else {
				if (DeAtt - (this.chance / 25) <= 5) {
					e.perdVie(10 + this.getAttaque() / 4);
					System.out.println("\nCoup critique !\n");
					return 10 + this.getAttaque() / 8;
				}
				e.perdVie(10);
				return 10;
			}
		} else {
			return 0;
		}
	}

	public int combat(int niveau) {
		Monstre m1 = new Monstre(niveau,((Joueur) this));
		int degats;
		System.out.println("Vous rencontrez un " + m1.getNom() + " !\nQue le combat commence...");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
		}
		while (this.getPdv() > 0 && m1.getPdv() > 0) {

			// Test pour voir s'il y a demande des stats
			/*
			 * String commande = "";
			 *
			 * String commandeStats = "!stats";
			 */

			System.out.print(((Joueur) this).getNom() + " attaque " + m1.getNom() + " : ");
			degats = this.attaque(m1);
			System.out.println(((Joueur) this).getNom() + " a inflige " + degats + " points de vie au " + m1.getNom());

			System.out.print(m1.getNom() + " attaque " + ((Joueur) this).getNom() + " : ");
			degats = m1.attaque(this);
			System.out.println(m1.getNom() + " a inflige " + degats + " points de vie a " + ((Joueur) this).getNom());

			System.out.println("\n" + this);
			System.out.println(m1 + "\n\n");

			try {
				Thread.sleep(2000);
			} catch (Exception e) {
			}
		}

		if (this.getPdv() > 0) {
			int bon = 0;
			int mal = 0;
			switch (niveau) {
				case 0:
					bon = 3;
					mal = 1;
					break;
				case 1:
					bon = 5;
					mal = 2;
					break;
				case 2:
					bon = 10;
					mal = 5;
					break;
				case 3:
					bon = 15;
					mal = 7;
					break;
				case 4:
					bon = 18;
					mal = 8;
					break;
			}

			if (niveau < 5) {
				System.out.println(((Joueur) this).getNom() + " a tue le " + m1.getNom() + "\n Récompense: un bonus de "
						+ bon + " et risquer d'avoir un malus de " + mal + ". \nAccepter ?" + "\n 1 - Oui  \n 2 - Non");

				int choix1 = s.nextInt();
				if (choix1 == 1) {
					Random r1 = new Random();
					int nbAlea1 = r1.nextInt(5);

					if (nbAlea1 == 0) {
						((Joueur) this).obtientMalus(new Malus(), mal);
					}
					((Joueur) this).obtientBonus(new Bonus(), bon);
				}
			} else {
				// Victoire

			}
			return 1;
		} else {
			System.out.println(m1.getNom() + " a tue " + ((Joueur) this).getNom() + ".");
			return 0;
		}

	}

	public String toString() {
		return "Attaque : " + attaque + "/ Defense : " + defense + "/ Vitesse : " + vitesse + "/ Chance : " + chance
				+ "/ Pdv : " + pdv;
	}
}
