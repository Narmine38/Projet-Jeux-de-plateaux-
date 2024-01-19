import java.util.Random;
import java.util.Scanner;

/**
 * La classe PlayerManager gère la création et la gestion des joueurs.
 */
public class PlayerManager {
    private Player player1;
    private Player player2;
    // Référence vers le joueur courant
    private Player currentPlayer;

    public void choiceGameType() {
        int gameType = -1;
        while (gameType != 0 && gameType != 1 && gameType != 2) {
            View.selectedGameType();
            gameType = Integer.parseInt(UserInput.getValidatedInput());
            if (gameType == 0) {
                player1 = new HumainPlayer("O");
                player2 = new ArtificialPlayer("X");
            } else if (gameType == 1) {
                player1 = new HumainPlayer("O");
                player2 = new HumainPlayer("X");
            } else if(gameType == 2){
                player1 = new ArtificialPlayer("O");
                player2 = new ArtificialPlayer("X");
            }else
                View.noValideTypeGame();
        }
        currentPlayer = player1;
    }


    /**
     * Cette méthode retourne le joueur courant.
     *
     * @return Le joueur courant.
     */
    public Player getCurrentPlayer() {
        return this.currentPlayer;
    }

    /**
     * Cette méthode change le joueur courant.
     * Si le joueur courant est le joueur humain, on passe au joueur ordinateur et vice versa.
     */
    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
        } else {
            currentPlayer = player1;
        }
    }

    public int RandomPlay() {
        Random rand = new Random();
        return rand.nextInt(3);
    }


}