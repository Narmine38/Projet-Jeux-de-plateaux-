import java.util.Scanner;

public class TicTacToe {

    private final UserInput userInput = new UserInput();
    private String userChoice() {
        return userInput.getValidatedInput();
    }
    final Player player = new Player("| O ");
    private final int SIZE;
    Cell[] board;

    public TicTacToe() {
        this.SIZE = 3;
        this.board = new Cell[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++) {
            this.board[i] = new Cell();
        }
    }

    public void display() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println("- - - - - - -");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i * SIZE + j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("- - - - - - -");
    }

    public int[] getMoveFromPlayer() {
        int row = askPlayerForCoordinate("row");
        int column = askPlayerForCoordinate("column");
        if (!"|   ".equals(board[row * SIZE + column].getRepresentation())) {
            System.out.println(" La cellule choisie est déjà occupée. Réessayez.");
            getMoveFromPlayer();
        }
        return new int[]{row, column};
    }

    private int askPlayerForCoordinate(String type) {
        System.out.println(player.getRepresentation() + ", veuillez entrer votre choix " + type + ": ");
        String input = userChoice();
        return Integer.parseInt(input);
    }

    public void setOwner(int row, int column, Player player) {
        board[row * SIZE + column].setOwner(player);
    }
}


