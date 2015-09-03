abstract class Entite {
	protected int attaque, defense, vitesse, chance, pdv;

	public Entite(int attaque, int defense, int vitesse, int chance, int pdv) {
		this.attaque = attaque;
		this.defense = defense;
		this.vitesse = vitesse;
		this.chance = chance;
		this.pdv = pdv;
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

	public String toString() {
		return "Attaque : " + attaque + ",Defense : " + defense + ",Vitesse : "
				+ vitesse + ",Chance : " + chance + ", Pdv : " + pdv;
	}
}
