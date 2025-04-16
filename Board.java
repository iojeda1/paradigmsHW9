import java.util.*;

public class Board {
    private char[][] grid;

    public Board() {
        grid = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(grid[i], ' '); // create empty board
        }
    }

    // function to print board
    public void showBoard() {
        System.out.println();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(" " + grid[i][j] + " ");
                if (j < 2) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---+---+---");
            }
        }
        System.out.println();
    }

    public boolean game(char play, int pos) {
        int r = (pos - 1) / 3;
        int c = (pos - 1) % 3;
        if (grid[r][c] == ' ') {
            grid[r][c] = play;
            return true;
        }
        return false;
    }

    // determine if play is a win
    public boolean win(char play) {
        for (int i = 0; i < 3; i++) {
            if ((grid[i][0] == play && grid[i][1] == play && grid[i][2] == play)) {
                return true;
            }
            if ((grid[0][i] == play && grid[1][i] == play && grid[2][i] == play)) {
                return true;
            }
        } // check corners
        if (grid[0][0] == play && grid[1][1] == play && grid[2][2] == play) {
            return true;
        }
        if (grid[0][2] == play && grid[1][1] == play && grid[2][0] == play) {
            return true;
        }
        return false;
    }

    // edge case: draw
    public boolean draw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // program randomly selects the other position.
    public List<Integer> computer() {
        List<Integer> pos = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (grid[i][j] == ' ') {
                    pos.add(i * 3 + j + 1);
                }
            }
        }
        return pos;
    }

}
