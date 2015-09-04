import java.util.Random;

public class De {

	private int valeur = -1;

	Random rd = new Random();

	public int lancerDe(int vitesse) {
		valeur = rd.nextInt(6) + 1 + (int) vitesse / 30;
		return valeur;
	}

	public String toString() {
		return "Valeur du dé : " + valeur;
	}

}
