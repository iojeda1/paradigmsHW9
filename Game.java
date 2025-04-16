import java.util.*;

public class Game {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        board.showBoard();
        while (true) {
            int move = 0;
            boolean valid = false;
            while (!valid) {
                System.out.print("Move (1-9): ");
                String input = scanner.nextLine();
                move = Integer.parseInt(input);
                if (move < 1 || move > 9) {
                    System.out.println("Invalid Input. Try again. ");
                } else if (!board.game('X', move)) {
                    System.out.println("Spot is already marked.");
                } else {
                    valid = true;
                }
            }
            board.showBoard();
            if (board.win('X')) {
                System.out.println("Player 1 has won!");
                break;
            }
            if (board.draw()) {
                System.out.println("Game is a draw.");
                break;
            }
            List<Integer> compu = board.computer();
            int move2 = compu.get(rand.nextInt(compu.size()));
            board.game('O', move2);
            board.showBoard();
            if (board.win('O')) {
                System.out.println("Player 2 has won!");
                break;
            }
            if (board.draw()) {
                System.out.println("Game is a draw.");
                break;
            }
        }
    }
}
