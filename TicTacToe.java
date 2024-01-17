public class TicTacToe {

    private final UserInput userInput = new UserInput();

    private String userChoice() {
        return userInput.getValidatedInput();
    }

    final Player player = new Player("| O ");
    final Player ordinateur = new Player("| X ");

    private Player currentPlayer;


    private final int SIZE;
    private int moveCount = 0;

    Cell[] board;

    public TicTacToe() {
        this.currentPlayer = player;
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
        System.out.println(currentPlayer.getRepresentation() + ", veuillez entrer votre choix " + type + ": ");
        String input = userChoice();
        return Integer.parseInt(input);
    }

    public void setOwner(int row, int column, Player player) {
        board[row * SIZE + column].setOwner(player);
        moveCount++;
    }

    private void nextPlayer() {
        currentPlayer = (currentPlayer == player) ? ordinateur : player;
    }

    public boolean isBoardFull() {
        return moveCount >= (SIZE * SIZE);
    }

    public void endGame() {
        System.out.println("Partie Fini !");
    }

    public boolean checkWin(Player player) {

        int[][] winningCombinations = {
                {0, 1, 2},  // première ligne
                {3, 4, 5},  // deuxième ligne
                {6, 7, 8},  // troisième ligne
                {0, 3, 6},  // première colonne
                {1, 4, 7},  // deuxième colonne
                {2, 5, 8},  // troisième colonne
                {0, 4, 8},  // première diagonale
                {2, 4, 6}   // deuxième diagonale
        };

        for (int[] combination : winningCombinations) {
            if (board[combination[0]].getRepresentation().equals(player.getRepresentation()) &&
                    board[combination[1]].getRepresentation().equals(player.getRepresentation()) &&
                    board[combination[2]].getRepresentation().equals(player.getRepresentation())) {
                return true;
            }
        }
        return false;
    }

    public void play() {
        while (!isBoardFull()) {
            display();
            int[] move = getMoveFromPlayer();
            setOwner(move[0], move[1], currentPlayer);
            if (checkWin(currentPlayer)) {
                System.out.println("Le joueur " + currentPlayer.getRepresentation() + " a gagné !");
                return;
            }
            nextPlayer();
        }
        endGame();
    }
}