package peggame;

import java.io.BufferedReader;
import java.io.FileReader;

public class Board {
    int[][] board;
    public Board (int size){
        this.board = new int[size][size];
        for (int[] row : board) {
            for (int i = 0; i < row.length; i++) {
                row[i]=0;
            }
            
        }
    }
    public static Board makeBoard(String filename){
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            int size =Integer.parseInt(br.readLine());
            Board result = new Board(size);
            for (int i = 0; i < size; i++) {
                String row=br.readLine();
                for (int j = 0; j < row.length(); j++) {
                    if (row.charAt(j)=='o')
                    result.board[i][j]=1;
                    else if (row.charAt(j)=='.')
                    result.board[i][j]=0;

                }
                
               
            }
            br.close();
            return result; 
            
        } catch (Exception e) {
            System.err.println(e);
            return null;
        }
        

    }
    @Override
    public String toString() {
        String result ="";
        for (int[]  row : board) {
            for (int i : row) {
                if (i==1) result += "o";
                else if (i==0) result +="-";
                
            }
            result += "\n";
        }
        return result;
    }
    public static void main(String[] args) {
        Board test =Board.makeBoard("data/3_3.txt");
        System.out.println(test);
    }
}
