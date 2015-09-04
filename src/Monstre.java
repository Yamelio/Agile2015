import java.util.Random;

public class Monstre extends Entite {

	private String type = "Monstre";

	public Monstre(int attaque, int defense, int vitesse, int chance, int pdv) {
		super(attaque, defense, vitesse, chance, pdv);
	}

	public Monstre(int niveau, Joueur j) {
		super();

		if(niveau<5) {

			Random r = new Random();

			this.attaque = r.nextInt((niveau * 10) + 1) + (niveau * 2) + 10;
			this.defense = r.nextInt((niveau * 10) + 1) + (niveau * 2) + 10;
			this.vitesse = r.nextInt((niveau * 10) + 1) + (niveau * 2) + 10;
			this.chance = r.nextInt((niveau * 10) + 1) + (niveau * 2) + 10;
			this.pdv = r.nextInt((niveau * 10) + 1) + (niveau * 2) + 10;

			String[] tabType = {"Gobelin", "Orc", "Troll", "Centaure", "Brigand"};

			this.type = tabType[r.nextInt(tabType.length)];
		}
		else{
			if(j.getNom().equals("Yams")){
				this.attaque = 1;
				this.defense = 1;
				this.vitesse = 1;
				this.chance = 1;
				this.pdv = 1;
				this.type = "Neo-Gilles";
			}
			else {
				int moyenne = (j.getAttaque() + j.getDefense() + j.getVitesse() + j.getChance()) / 4;
				this.attaque = moyenne;
				this.defense = moyenne;
				this.vitesse = moyenne;
				this.chance = moyenne;
				this.pdv = 50;
				this.type = "Neo-Gilles";
			}
		}
	}

	@Override
	public void perdVie(int vie) {
		super.pdv -= vie;

	}
	
	public String getNom(){
		return type;
	}

	public String toString() {
		return super.toString();
	}

}
