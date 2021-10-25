package peggame;

import java.util.Collection;
import java.util.HashSet;

public class rectPegGame implements PegGame {
    Board play;
    GameState state;
    public rectPegGame(Board newBoard) {
        this.play=newBoard;
        this.state=GameState.NOT_Started;
    }

    public rectPegGame(Board newBoard,GameState state) {
        this.play=newBoard;
        this.state=state;
    }

    @Override
    public Collection<Move> getPossiblMoves() {
        HashSet<Move> possible=new HashSet<Move>();
        int[] directions ={-2,0,2};
        for (int i = 0; i < play.size; i++) {
            for (int j = 0; j < play.size; j++) {
                if (play.board[i][j]==1)
                for (int dir1 = 0; dir1 < directions.length; dir1++) {
                    for (int dir2 = 0; dir2 < directions.length; dir2++) {
                        Move nextCheck = new Move(new Location(i, j), new Location(i+dir1, j+dir2));
                        if (isValid(nextCheck)) possible.add(nextCheck);
                        
                    }
                    
                }
            }
            
        }
            
        
        return possible;
    }
    public boolean isValid (Move move){
        boolean result = false;
        boolean xValid=(0<=move.getTo().getCol())& (play.size>move.getTo().getCol()) &
        (0<=move.getFrom().getCol())& (play.size>move.getFrom().getCol());
        boolean yValid=(0<=move.getTo().getRow())& (play.size>move.getTo().getRow()) &
        (0<=move.getFrom().getRow())& (play.size>move.getFrom().getRow());
        boolean distValid=false;
        int[] directions ={-2,0,2};
        for (int i : directions) {
            for (int j : directions) {
                try {
                    if ((move.getTo().getCol()-move.getFrom().getCol()==i)&(move.getTo().getRow()-move.getFrom().getRow()==j)){
                        if (play.board[move.getFrom().getRow()+((move.getTo().getRow()-move.getFrom().getRow()))/2][move.getFrom().getCol()+(move.getTo().getCol()-move.getFrom().getCol())/2]==1);
                        distValid=true;
                    }  
                } catch (Exception e) {
                    //TODO: handle exception
                }
                
                
                
            }
        }
        try {
            result=xValid&yValid&distValid&(play.board[move.getTo().getRow()][move.getTo().getCol()]==0);
        } catch (Exception e) {
            result=false;
        }
        
        return result;
    }

    @Override
    public GameState getGameState() {
        return this.state;
    }

    @Override
    public void makeMove(Move move) throws PegGameException {
        if (isValid(move)){
            int xMove =move.getTo().getCol()-move.getFrom().getCol();
            int yMove =move.getTo().getCol() -move.getFrom().getCol();
            play.board[move.getFrom().getRow()][move.getFrom().getCol()]=0;
            play.board[move.getFrom().getRow()+yMove/2][move.getFrom().getCol()+xMove/2]=0;
            play.board[move.getTo().getRow()][move.getTo().getCol()]=0;
            int count =0;
            for (int[] row : play.board) {
                for (int i : row) {
                    if (i==1) count ++;
                }
            if (count==1) this.state=GameState.WON;
            else if (getPossiblMoves().size()==0) this.state=GameState.STALEMATE;
            else this.state=GameState.IN_PROGRESS;
            }
        }
        else throw new PegGameException();
        

    }
    @Override
    public String toString() {
        return play.toString();
    }
}
