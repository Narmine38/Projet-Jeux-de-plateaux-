/**
 * La classe TicTacToe est le point d'entrée du jeu.
 * Elle initialise le gestionnaire de jeu et commence le jeu.
 */
public class TicTacToe {
    /**
     * Un gestionnaire de jeu pour abstraire la logique du jeu.
     */
    private final GameManager gameManager;

    /**
     * Créer une nouvelle instance de TicTacToe avec une taille de plateau donnée.
     *
     * @param size la taille du plateau de jeu.
     */
    public TicTacToe(int size) {
        PlayerManager playerManager = new PlayerManager(); // Géré les tour des joueurs
        BoardManager boardManager = new BoardManager(); // Géré le plateau de jeu
        View view = new View(boardManager, playerManager);
        playerManager.choiceGameType();
        gameManager = new GameManager(boardManager, playerManager,view); // Initialise le gestionnaire de jeu
    }

    /**
     * Commencer le jeu.
     */
    public void playGame() {
        gameManager.play();
    }
}