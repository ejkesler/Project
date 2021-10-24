package peggame;

public class Space {
    Peg here;
    
    public Space (Location coords, Peg here){
        this.here=here;
        

    }
    @Override
    public String toString() {
        if (here==Peg.EMPTY){
            return ".";
        }
        else if (here==Peg.FULL){
            return "o";
        }
        else return " ";
    }


}
