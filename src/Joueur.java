public class Joueur extends Entite {

	String nom;
	private int etage=0;
	private int chemin=0;
	private int position=0;

	public Joueur(){}

	public Joueur(int attaque, int defense, int vitesse, int chance, int pdv,String nom) {
		super(attaque, defense, vitesse, chance, pdv);
		this.nom = nom;
	}

	public String getNom(){
		return this.nom;
	}

	public int getVie(){
		return super.pdv;
	}

	public void perdVie(int vie) {
		super.pdv -= vie;
	}

	public String toString() {
		return super.toString() + ", Nom : " + nom;
	}

	public void obtientBonus (Bonus Rcp, int valeur){
		Rcp.Bonus(this, valeur);
		System.out.println(Rcp);
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
		}
	}

	public void obtientMalus (Malus Rcp, int valeur){
		Rcp.Malus(this, valeur);
		System.out.println(Rcp);
		try {
			Thread.sleep(1500);
		} catch (Exception e) {
		}
	}

	public void setEtage(int e){
		etage=e;
	}

	public void setChemin(int e){
		chemin=e;
	}

	public void setPosition(int e){
		position=e;
	}

	public int getEtage(){
		return etage;
	}

	public int getChemin(){
		return chemin;
	}

	public int getPosition(){
		return position;
	}

	public void setNom(String nom){
		this.nom=nom;
	}

}