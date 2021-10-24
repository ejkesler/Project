package peggame;

import java.util.LinkedList;

public class Board {
    LinkedList<LinkedList<Space>> col;
    LinkedList<Space> rows;
    @Override
    public String toString() {
        String result="";
        for (LinkedList<Space> row : col) {
            result += row.toString() +"\n";
            
        }
        return result;
    }

}
