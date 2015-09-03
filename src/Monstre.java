public class Monstre extends Entite {

	public Monstre(int attaque, int defense, int vitesse, int chance, int pdv) {
		super(attaque, defense, vitesse, chance, pdv);
	}

	@Override
	public void perdVie(int vie) {
		super.pdv -= vie;

	}

	public String toString() {
		return super.toString();
	}

}
