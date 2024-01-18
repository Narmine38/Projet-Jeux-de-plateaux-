/**
 * La classe PlayerManager gère la création et la gestion des joueurs.
 */
public class PlayerManager {
    // Création d'un joueur humain avec le symbol "O"
    private final Player player = new Player("O");

    // Création d'un joueur ordinateur avec le symbol "X"
    private final Player computer = new Player("X");

    // Référence vers le joueur courant
    private Player currentPlayer;

    /**
     * Le constructeur de PlayerManager met le joueur humain comme joueur courant.
     */
    public PlayerManager() {
        currentPlayer = player;
    }

    /**
     * Cette méthode retourne le joueur courant.
     * @return Le joueur courant.
     */
    public Player getCurrentPlayer(){
        return this.currentPlayer;
    }

    /**
     * Cette méthode change le joueur courant.
     * Si le joueur courant est le joueur humain, on passe au joueur ordinateur et vice versa.
     */
    public void switchPlayer() {
        if (currentPlayer == player) {
            currentPlayer = computer;
        } else {
            currentPlayer = player;
        }
    }
}