import java.util.Scanner;

public class CreationPersonnage {
	private int aRepartir = 150;
	private int pointsCarac;
	private String[] carac = new String[] { "Vie", "Attaque", "Defense",
			"Vitesse", "Chance" };
	private int[] valeurCarac = new int[] { 0, 0, 0, 0, 0 };

	public void repartir(int valeur, Joueur joueur) {
		switch (valeur) {
			case 0:
				joueur.pdv += pointsCarac;
				valeurCarac[0] += pointsCarac;
				break;
			case 1:
				joueur.attaque += pointsCarac;
				valeurCarac[1] += pointsCarac;
				break;
			case 2:
				joueur.defense += pointsCarac;
				valeurCarac[2] += pointsCarac;
				break;
			case 3:
				joueur.vitesse += pointsCarac;
				valeurCarac[3] += pointsCarac;
				break;
			case 4:
				joueur.chance += pointsCarac;
				valeurCarac[4] += pointsCarac;
				break;
		}
	}

	public void creerPersonnage() {
		int seuil = 0;
		//int max = 49;
		Scanner s = new Scanner(System.in);
		Joueur newPlayer = new Joueur(25, 25, 25, 25, 25, "");
		System.out
				.println("Distribuez dans l'ordre : Points de vie, Attaque, Defense, Vitesse, Chance");

		while (aRepartir > 0) {

			System.out.println(newPlayer);

			for (int i = 0; i < carac.length && aRepartir > 0; i++) {
				seuil = 49 - valeurCarac[i];
				if(seuil > aRepartir){
					seuil = aRepartir;
				}
				System.out.println("choisir le nbr de pts dans la " + carac[i]
						+ " (max " + seuil + ")");
				pointsCarac = s.nextInt();

				while (pointsCarac > aRepartir || pointsCarac > seuil
						|| pointsCarac < 0) {
					if (pointsCarac > seuil)
						System.out.println("Erreur, Ne pas depasser " + seuil);
					else if (pointsCarac < 0)
						System.out
								.println("Erreur, Ne pas allez en dessous de 0");
					else
						System.out
								.println("Veuillez choisir un nombre inférieur à "
										+ aRepartir);

					pointsCarac = s.nextInt();
				}
				aRepartir -= pointsCarac;

				if (aRepartir > 0)
					System.out.println("Il reste " + aRepartir + " à repartir");
				this.repartir(i, newPlayer);
			}
		}
		System.out.println("Choisissez le nom de votre personnage : ");
		newPlayer.setNom(s.next());
		System.out.println("Voici votre personnage : " + newPlayer.toString());
	}

	public static void main(String[] args) {
		CreationPersonnage cr = new CreationPersonnage();
		cr.creerPersonnage();
	}
}
