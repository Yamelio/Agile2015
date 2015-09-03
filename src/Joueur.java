public class Joueur extends Entite {
	
	String nom;
	
	public Joueur(int attaque, int defense, int vitesse, int chance, int pdv,String nom) {
		super(attaque, defense, vitesse, chance, pdv);
		this.nom = nom;
	}
	
	public void perdVie(int vie) {
		super.pdv -= vie;
	}
	
	public String toString() {
		return super.toString() + ", Nom : " + nom;
	}
}
