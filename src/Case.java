
public class Case {

	private boolean estMonstre;
	private boolean estPersonnage;
	private boolean estMalus;
	private boolean estBonus;
	private boolean estNoeud;
	private boolean estVisible = false;


	public Case() {
		this.estMonstre = false;
		this.estPersonnage = false;
		this.estMalus = false;
		this.estBonus = false;
		this.estNoeud = false;
	}

	public boolean isEstVisible() {
		return estVisible;
	}

	public void setEstVisible(boolean estVisible) {
		this.estVisible = estVisible;
	}

	public boolean isEstMonstre() {
		return estMonstre;
	}

	public void setEstMonstre(boolean estMonstre) {
		this.estMonstre = estMonstre;
	}

	public boolean isEstPersonnage() {
		return estPersonnage;
	}

	public void setEstPersonnage(boolean estPersonnage) {
		this.estPersonnage = estPersonnage;
	}

	public boolean isEstMalus() {
		return estMalus;
	}

	public void setEstMalus(boolean estMalus) {
		this.estMalus = estMalus;
	}

	public boolean isEstBonus() {
		return estBonus;
	}

	public void setEstBonus(boolean estBonus) {
		this.estBonus = estBonus;
	}

	public boolean isEstNoeud() {
		return estNoeud;
	}

	public void setEstNoeud(boolean estNoeud) {
		this.estNoeud = estNoeud;
	}

	public String toString() {
		if (!estVisible) {
			return "_";
		}
		if (estPersonnage) {
			return "J";
		}
		if (estMonstre) {
			return "M";
		}
		if (estBonus) {
			return "+";
		}
		if (estMalus) {
			return "-";
		}
		return "_";

	}

}