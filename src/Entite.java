import java.util.Random;

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

	public int getVie() {
		return pdv;
	}

	public void setPdv(int pdv) {
		this.pdv = pdv;
	}

	public String toString() {
		return "Attaque : " + attaque + ", Defense : " + defense + ", Vitesse : "
				+ vitesse + ", Chance : " + chance + ", Pdv : " + pdv;
	}

	public int attaque(Entite e){

		Random r = new Random();
		int deAtt = r.nextInt(100)+1;
		int deDef = r.nextInt(100)+1;
		//System.out.println("Attaque :"+deAtt);
		//System.out.println("Defense :"+deDef);


		if(deAtt < this.getAttaque()){
			if(deDef<e.getDefense()){
				e.perdVie(5);
				return 5;
			}
			else{
				e.perdVie(10);
				return 10;
			}
		}
		return 0;
	}

	public void checkStat(){
		if(this.attaque>99){
			this.attaque=99;
		}
		if(this.defense>99){
			this.defense=99;
		}
		if(this.vitesse>99){
			this.vitesse=99;
		}
		if(this.chance>99){
			this.chance=99;
		}
		if(this.attaque<0){
			this.attaque=0;
		}
		if(this.defense<0){
			this.defense=0;
		}
		if(this.vitesse<0){
			this.vitesse=0;
		}
		if(this.chance<0){
			this.chance=0;
		}
		
	}
}
