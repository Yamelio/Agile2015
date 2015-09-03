import java.util.Random;

public class Bonus {

	private String[] carac = new String[] { "Attaque", "Defense", "Vitesse",
			"Chance" };
	private Random r = new Random();
	private int choixBonus = -1;
	private int valeurCarac = -1;

	public void petitBonus(Joueur joueur) {
		this.methode(5, joueur);
		choixBonus = 0;
	}

	public void moyenBonus(Joueur joueur) {
		this.methode(10, joueur);
		choixBonus = 1;
	}

	public void grandBonus(Joueur joueur) {
		this.methode(15, joueur);
		choixBonus = 2;
	}

	public void methode(int valeurBonus, Joueur joueur) {
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
		String str = null;
		switch (choixBonus) {
		case 0:
			if (valeurCarac >= 0)
				str = "Le personnage gagne 5 en " + carac[valeurCarac];
			break;
		case 1:
			if (valeurCarac >= 0)
				str = "Le personnage gagne 10 en " + carac[valeurCarac];
			break;
		case 2:
			if (valeurCarac >= 0)
				str = "Le personnage gagne 15 en " + carac[valeurCarac];
			break;
		default:
			str = "Le personnage n'a rien gagner";
		}
		return str;
	}
	
	public static void main(String[] args) {
		Bonus b = new Bonus();
		Joueur joueur = new Joueur(97,97,50,50,100,"Gilles");
		System.out.println(joueur);
		b.grandBonus(joueur);
		System.out.println(b);
		System.out.println(joueur);
	}
}
