import java.util.Random;

public class Malus {
	private String[] carac = new String[] { "Attaque", "Defense", "Vitesse",
			"Chance" };
	private Random r = new Random();
	private int choixMalus = -1;
	private int valeurCarac = -1;



	public void Malus(Joueur joueur, int valeur) {
		this.methode(valeur,joueur);
		choixMalus=valeur;
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
		if (choixMalus >= 0) {
			return "Le personnage a perdu " + choixMalus + " en " + carac[valeurCarac];
		}
		return "Le personnage n'a rien perdu";
	}
}
