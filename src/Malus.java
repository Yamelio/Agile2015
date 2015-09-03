import java.util.Random;

public class Malus {
	private String[] carac = new String[] { "Attaque", "Defense", "Vitesse",
			"Chance" };
	private Random r = new Random();
	private int choixMalus = -1;
	private int valeurCarac = -1;

	public void petitMalus(Joueur joueur) {
		this.methode(-2, joueur);
		choixMalus = 0;
	}

	public void moyenMalus(Joueur joueur) {
		this.methode(-5, joueur);
		choixMalus = 1;
	}

	public void grandMalus(Joueur joueur) {
		this.methode(-7, joueur);
		choixMalus = 2;
	}

	public void methode(int valeurMalus, Joueur joueur) {
		valeurCarac = r.nextInt(carac.length);
		switch (valeurCarac) {
		case 0:
			joueur.setAttaque(joueur.attaque + valeurMalus);
			break;
		case 1:
			joueur.setDefense(joueur.defense + valeurMalus);
			break;
		case 2:
			joueur.setVitesse(joueur.vitesse + valeurMalus);
			break;
		case 3:
			joueur.setChance(joueur.chance + valeurMalus);
			break;
		}
		joueur.checkStat();
	}

	public String toString() {
		String str = null;
		switch (choixMalus) {
		case 0:
			if (valeurCarac >= 0)
				str = "Le personnage perd 2 en " + carac[valeurCarac];
			break;
		case 1:
			if (valeurCarac >= 0)
				str = "Le personnage perd 5 en " + carac[valeurCarac];
			break;
		case 2:
			if (valeurCarac >= 0)
				str = "Le personnage perd 7 en " + carac[valeurCarac];
			break;
		default:
			str = "Le personnage n'a rien perdu";
		}
		return str;
	}
}
