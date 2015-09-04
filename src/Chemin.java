import java.util.ArrayList;
import java.util.List;

/**
 * Created by Guillaume on 03/09/2015.
 */
public class Chemin {

    int taille;
    Noeud noeud;
    List<Case> cases;

    public Chemin(int taille){
        this.taille=taille;
        this.cases=new ArrayList<Case>(taille);
        for(int i=0;i<taille;i++){
            cases.add(i,new Case());
        }
        cases.get(taille-1).setEstNoeud(true);
    }

    public void setTaille(int t){
        taille=t;
    }

    public void setNoeud(Chemin un, Chemin deux){
        this.noeud=new Noeud(un,deux);
    }

    public Noeud getNoeud(){
        return this.noeud;
    }

    public List<Case> getCases(){
        return this.cases;
    }
}
