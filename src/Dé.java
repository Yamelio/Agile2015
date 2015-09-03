import java.util.Random;


public class Dé {

	private int valeur = -1;
	Random rd = new Random();
	

	
	public int lancerDé(){
		valeur = rd.nextInt(6)+1;
		return valeur;
	}
	
	public String toString(){
		return "Valeur du dé : "+valeur;
	}
	
}
