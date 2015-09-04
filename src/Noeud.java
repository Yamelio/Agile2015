/**
 * Created by Guillaume on 03/09/2015.
 */
public class Noeud {

    private Chemin un;
    private Chemin deux;

    public Noeud(Chemin un, Chemin deux){
        this.un=un;
        this.deux=deux;
    }

    public String toString(){
        return "Chemin un : "+un+"\nChemin deux :"+deux;
    }

    public Chemin getUn(){
        return un;
    }

    public Chemin getDeux(){
        return deux;
    }

}
