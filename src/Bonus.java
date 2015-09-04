import java.util.Random;

public class Bonus {

	private String[] carac = new String[] { "Attaque", "Defense", "Vitesse",
			"Chance" };
	private Random r = new Random();
	private int choixBonus = -1;
	private int valeurCarac = -1;



	public void Bonus(Joueur joueur, int valeur) {
		this.methode(valeur,joueur);
		choixBonus=valeur;
	}

	private void methode(int valeurBonus, Joueur joueur) {
		valeurCarac = r.nextInt(carac.length);
		switch (valeurCarac) {
			case 0:
				joueur.setAttaque(joueur.attaque + valeurBonus);
				break;
			case 1:
				joueur.setDefense(joueur.defense + valeurBonus);
				break;
			case 2:
				joueur.setVitesse(joueur.vitesse + valeurBonus);
				break;
			case 3:
				joueur.setChance(joueur.chance + valeurBonus);
				break;
		}
		joueur.checkStat();
	}

	public String toString() {

		if (choixBonus >= 0) {
			return "Le personnage gagne " + choixBonus + " en " + carac[valeurCarac];
		}
		return "Le personnage n'a rien gagne";
	}
}
