import java.util.*;

/**
 * Created by Guillaume on 03/09/2015.
 */
public class Carte {

    private Map<Integer,List<Chemin>> carte;

    public Carte(){
        carte = new HashMap<Integer,List<Chemin>>();
        carte.put(0, new ArrayList<Chemin>(1));
        carte.put(1, new ArrayList<Chemin>(2));
        carte.put(2, new ArrayList<Chemin>(4));
        carte.put(3, new ArrayList<Chemin>(8));
        carte.put(4, new ArrayList<Chemin>(16));



        for(int i=0;i<=4;i++){
            int taille=0;
            if(i==0) taille=1;
            if(i==1) taille=2;
            if(i==2) taille=4;
            if(i==3) taille=8;
            if(i==4) taille=16;
            for(int k=0;k<taille;k++){
                int taille2=0;
                if(i==0) taille2=5;
                if(i==1) taille2=15;
                if(i==2) taille2=15;
                if(i==3) taille2=10;
                if(i==4) taille2=5;
                carte.get(i).add(k, new Chemin(taille2));
            }
        }

        for(int i=1;i<=3;i++){
            for(int k=0;k<carte.get(i).size();k++){
                carte.get(i).get(k).setNoeud(carte.get(i+1).get((2*k)),carte.get(i+1).get((2*k)+1));
            }
        }

        carte.get(0).get(0).getCases().get(0).setEstPersonnage(true);
        carte.get(0).get(0).getCases().get(0).setEstVisible(true);

    }

    public void spawnEntite(int entite) {
        // variable
        Random r = new Random();
        int taille = -1;
        int taille2 = -1;
        int alea = -1;
        boolean choix = false;

        for (int i = 0; i < 5; i++) {
            // choix du nb de branches et de l'étages
            if (i == 0) {
                taille = 4;
                taille2 = 0;
            } else if (i == 1) {
                taille = 14;
                taille2 = 1;
            } else if (i == 2) {
                taille = 14;
                taille2 = 3;
            } else if (i == 3) {
                taille = 9;
                taille2 = 7;
            } else if (i == 4) {
                taille = 4;
                taille2 = 15;
            }

            for (int j = 0; j <= taille2; j++) {
                // place les bonus et malus
                choix = r.nextBoolean();
                alea = r.nextInt(taille);
                if (entite == 0) {
                    // bonus et malus
                    if (carte.get(i).get(j).getCases().get(alea).isEstMonstre() == false
                            && carte.get(i).get(j).getCases().get(alea)
                            .isEstPersonnage() == false) {
                        if (choix) {
                            carte.get(i).get(j).getCases().get(alea)
                                    .setEstBonus(true);
                        } else {
                            carte.get(i).get(j).getCases().get(alea)
                                    .setEstMalus(true);
                        }

                    } else {
                        j--;
                    }
                } else {
                    // monstres
                    if (carte.get(i).get(j).getCases().get(alea)
                            .isEstPersonnage() == false
                            && carte.get(i).get(j).getCases().get(alea)
                            .isEstBonus() == false
                            && carte.get(i).get(j).getCases().get(alea)
                            .isEstMalus() == false) {
                        carte.get(i).get(j).getCases().get(alea).setEstMonstre(true);
                    }
                    else{
                        j--;
                    }
                }
            }
        }
    }

    public String toString(){
        String res="";

        for(int k=0;k<5;k++) {
            for (int i = 0; i < 16; i++) {

                  res += "  |"+ carte.get(4).get(i).getCases().get(4-k) +"|";

            }
            res+="\n";
        }

        res+="  ";
        for(int i=0;i<8;i++){
            res+="   \\ /    ";
        }


        for(int k=0;k<10;k++) {
            res+="\n  ";

            for (int i = 0; i < 8; i++) {
                res += "   |" + carte.get(3).get(i).getCases().get(9-k) + "|    ";
            }
        }
        res+="\n  ";
        for(int k=0;k<4;k++){
            res+="      \\      /      ";
        }
        res+="\n  ";
        for(int k=0;k<4;k++){
            res+="       \\    /       ";
        }
        res+="\n  ";
        for(int k=0;k<4;k++){
            res+="        \\  |        ";
        }

        for(int k=0;k<15;k++) {
            res+="\n  ";

            for (int i = 0; i < 4; i++) {
                res += "         |" + carte.get(2).get(i).getCases().get(14-k) + "|        ";
            }
        }

        res+="\n  ";
        for(int k=0;k<2;k++){
            res+="            \\               /           ";
        }

        res+="\n  ";
        for(int k=0;k<2;k++){
            res+="             \\             /            ";
        }

        res+="\n  ";
        for(int k=0;k<2;k++){
            res+="              \\           /             ";
        }

        res+="\n  ";
        for(int k=0;k<2;k++){
            res+="               \\         /              ";
        }

        res+="\n  ";
        for(int k=0;k<2;k++){
            res+="                \\       /               ";
        }

        res+="\n  ";
        for(int k=0;k<2;k++){
            res+="                 \\     /                ";
        }

        res+="\n  ";
        for(int k=0;k<2;k++){
            res+="                  \\   /                 ";
        }

        for(int k=0;k<15;k++) {
            res+="\n  ";

            for (int i = 0; i < 2; i++) {
                res += "                   |" + carte.get(1).get(i).getCases().get(14-k) + "|                  ";
            }
        }

        res+="\n  ";
        res+="                      \\                                   /";

        res+="\n  ";
        res+="                       \\                                 /";

        res+="\n  ";
        res+="                        \\                               /";

        res+="\n  ";
        res+="                         \\____________    ____________/";

        res+="\n  ";
        res+="                                      \\  |";

        for(int i=0;i<5;i++) {
            res += "\n  ";
            res += "                                       |" + carte.get(0).get(0).getCases().get(4-i) + "|";
        }


        return res;
    }

    public Map<Integer,List<Chemin>> getCarte(){
        return this.carte;
    }
}
