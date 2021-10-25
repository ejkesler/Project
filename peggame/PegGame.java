package peggame;
import java.util.Collection;

public interface PegGame {
    
    public Collection<Move> getPossiblMoves ();
    public GameState getGameState();
    public void  makeMove(Move move) throws PegGameException;
}
