import java.util.Random;
import java.util.Scanner;

/**
 * Created by Guillaume on 02/09/2015.
 */
public class Main {

    private static Joueur[] joueurs;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();
        int nbJoueurs;
        
        int choix;
        //Choix début de jeu
        
        System.out.println("Que voulez vous faire ?");
        System.out.println("1. Créer un personnage");
        System.out.println("2. Commencer à jouer");
        
        choix = s.nextInt();
        
        //Création du personnage
      
        if(choix == 1){
        	int aRepartir = 150;
        	Joueur newPlayer = new Joueur(25,25,25,25,25, "");
        	System.out.println("Distribuez vos points de caractéristiques : (encore "+aRepartir+" points à répartir)");
        	//Points de vie
        	System.out.println("Points de vie : (encore "+aRepartir+ " points à répartir)");
        	int pointsCarac = s.nextInt();
        
        	while(pointsCarac <0 || pointsCarac >99){
        		System.out.println("Les points de vie ne peuvent pas excéder 99");
        		System.out.println("Points de vies : ");
        		pointsCarac = s.nextInt();
        	}
        	newPlayer.pdv+=pointsCarac;
        	aRepartir-=pointsCarac;
        	System.out.println("Points d'attaque : (encore "+aRepartir+ " points à répartir)");
        	//Attaque
        	pointsCarac = s.nextInt();
        	while(pointsCarac <0 || pointsCarac >99){
        		System.out.println("L'attaque ne peut pas excéder 99");
        		System.out.println("Points d'attaque : ");
        		pointsCarac = s.nextInt();
        	}
        	newPlayer.attaque+=pointsCarac;
        	aRepartir -=pointsCarac;
        	System.out.println("Points de défense : (encore "+aRepartir+ " points à répartir)");
        	//Défense
        	pointsCarac = s.nextInt();
        	while(pointsCarac <0 || pointsCarac >99){
        		System.out.println("La défense ne peut pas excéder 99");
        		System.out.println("Points de défense : ");
        		pointsCarac = s.nextInt();
        	}
        	newPlayer.defense+=pointsCarac;
        	aRepartir-=pointsCarac;
        	System.out.println("Points de vitesse : (encore "+aRepartir+ " points à répartir)");
        	//Vitesse
        	pointsCarac = s.nextInt();
        	while(pointsCarac <0 || pointsCarac >99){
        		System.out.println("La vitesse ne peut pas excéder 99");
        		System.out.println("Points de vitesse : ");
        		pointsCarac = s.nextInt();
        	}
        	newPlayer.vitesse+=pointsCarac;
        	aRepartir-=pointsCarac;
        	System.out.println("Points de chance : (encore "+aRepartir+ " points à répartir)");
        	//Chance
        	pointsCarac = s.nextInt();
        	while(pointsCarac <0 || pointsCarac >99){
        		System.out.println("La chance ne peut pas excéder 99");
        		System.out.println("Points de chance : ");
        		pointsCarac = s.nextInt();
        	}
        	newPlayer.chance+=pointsCarac;
        	aRepartir-=pointsCarac;
        	
        	System.out.println("Choisissez le nom de votre personnage : ");
        	//Nom
        	String nom = "";
        	nom = s.next();
        	
        	newPlayer.nom = nom;
        	
        	System.out.println("Voici votre personnage : ");
        	System.out.println(newPlayer.toString());
        }
        
        
        //Choix du nb de joueurs
        
        if(choix == 2){
	        System.out.println("Combien de joueurs ?");
	        nbJoueurs=s.nextInt();
	        joueurs = new Joueur[nbJoueurs];
	
	
	        for(int i=0;i<nbJoueurs;i++){
	            System.out.println("Nom de joueur "+(i+1) +" ");
	            String nom = s.next();
	            joueurs[i]=new Joueur(60,60,r.nextInt(70)+1,60,100,nom);
	        }
	
	
	        triJoueurs();
	        Joueur joueurCourant=joueurs[0];
	        Monstre m1 = new Monstre(40, 40, 40, 40, 40);
	        int degats;
	
	//        while (joueurCourant.getVie() > 0 && m1.getVie() > 0) {
	//            System.out.println(joueurCourant.getNom()+ " attaque Monstre");
	//            degats = joueurCourant.attaque(m1);
	//            System.out.println(joueurCourant.getNom()+ " a inflige " + degats + " points de vie au monstre");
	//
	//            System.out.println("Le monstre attaque " + joueurCourant.getNom());
	//            degats = m1.attaque(joueurCourant);
	//            System.out.println("Le monstre a inflige " + degats + " points de vie a "+  joueurCourant.getNom());
	//
	//            System.out.println(joueurCourant);
	//            System.out.println(m1+"\n");
	//        }
	
	        if(joueurCourant.getVie()>0){
	            System.out.println(joueurCourant.getNom() + " a tue le monstre.");
	            joueurCourant.obtientBonus(new Bonus(), 1);
	        }
	        else{
	            System.out.println("Le monstre a tue "+ joueurCourant.getNom() +".");
	        }
        }
    }

    public static void triJoueurs(){

        int taille = joueurs.length;
        Joueur transfert;
        for(int i=0;i<taille-1;i++){
            if(joueurs[i].getVitesse()<joueurs[i+1].getVitesse()){
                transfert = joueurs[i];
                joueurs[i]=joueurs[i+1];
                joueurs[i+1]=transfert;
                i=0;
            }
        }

        for(int i=0;i<taille;i++){
            System.out.println(joueurs[i]);
        }
    }
}
