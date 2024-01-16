public class TicTacToe {

    final int SIZE;
    Cell[] board;

    public TicTacToe(int size) {
        this.SIZE = size;
        this.board = new Cell[SIZE * SIZE];

        for (int i = 0; i < SIZE * SIZE; i++) {
            this.board[i] = new Cell();
        }
    }





}