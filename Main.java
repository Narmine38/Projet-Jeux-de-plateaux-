import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        TicTacToe ticTacToe = new TicTacToe();

        ticTacToe.display();

        int[] move = ticTacToe.getMoveFromPlayer();
        System.out.println("Le joueur a choisi la ligne " + move[0] + " et la colonne " + move[1]);
        ticTacToe.setOwner(move[0], move[1], ticTacToe.player);

        ticTacToe.display();

        int[] move1 = ticTacToe.getMoveFromPlayer();
        System.out.println("Le joueur a choisi la ligne " + move1[0] + " et la colonne " + move1[1]);
        ticTacToe.setOwner(move1[0], move1[1], ticTacToe.player);

        ticTacToe.display();


    }

}
