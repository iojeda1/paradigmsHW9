import java.util.*;

public class Board {
    private char[][] grid; 
    public Board() {
        grid = new chat[3][3]; 
        for (int i = 0; i < 3; i++) {
            Arrays.fill(grid[i], ' ');
        }
    }

    public void showBoard() {
        System.out.println(); 
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                char block = grid[i][j];
                if (block == ' ') {
                    int pos = (i*3) + (j+1);
                    System.out.print(" " + pos + " ");
                } else {
                    System.out.print(" " + block + " "); 
                }
                if (j<2) {
                    System.out.print("|"); 
                }
            }
            System.out.println(); 
            if (i<2) {
                System.out.println("---+---+---"); 
            }
        }
        System.out.println(); 
    }

    public boolean 
    
}
