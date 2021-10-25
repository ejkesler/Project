package peggame;

public class makeRectGame {
    public static rectPegGame newGame (String filename){
        return new rectPegGame(Board.makeBoard(filename));
    }
    public static void main(String[] args) {
        rectPegGame game= makeRectGame.newGame("data/3_3.txt");
        System.out.println(game);
        
        System.out.println(game.getPossiblMoves());
    }
}
