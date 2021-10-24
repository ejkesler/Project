package peggame;
public class Move {
    private Location to;
    private Location from;
    public Move(Location from,Location to){
        this.from=from;
        this.to=to;
    }
    public Location getFrom(){
        return from;
    }
    public Location getTo(){
        return to;
    }
}
