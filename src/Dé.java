import java.util.Random;


public class D� {

	private int valeur = -1;
	Random rd = new Random();
	

	
	public int lancerD�(){
		valeur = rd.nextInt(6)+1;
		return valeur;
	}
	
	public String toString(){
		return "Valeur du d� : "+valeur;
	}
	
}
