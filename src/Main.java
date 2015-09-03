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

        while (joueurCourant.getVie() > 0 && m1.getVie() > 0) {
            System.out.println(joueurCourant.getNom()+ " attaque Monstre");
            degats = joueurCourant.attaque(m1);
            System.out.println(joueurCourant.getNom()+ " a inflige " + degats + " points de vie au monstre");

            System.out.println("Le monstre attaque " + joueurCourant.getNom());
            degats = m1.attaque(joueurCourant);
            System.out.println("Le monstre a inflige " + degats + " points de vie a "+  joueurCourant.getNom());

            System.out.println(joueurCourant);
            System.out.println(m1+"\n");
        }

        if(joueurCourant.getVie()>0){
            System.out.println(joueurCourant.getNom() + " a tue le monstre.");
        }
        else{
            System.out.println("Le monstre a tue "+ joueurCourant.getNom() +".");
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
