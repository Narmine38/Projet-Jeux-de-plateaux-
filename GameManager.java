/**
 * La classe GameManager est responsable de la gestion du jeu.
 * Elle utilise les classes BoardManager et PlayerManager.
 * La partie commence par l'appel de la méthode play().
 */
public class GameManager {
    private final BoardManager boardManager; // Responsable de la gestion du plateau
    private final PlayerManager playerManager; // Responsable de la gestion des joueurs

    /**
     * Constructeur de GameManager qui instancie les responsables de la gestion du plateau et des joueurs.
     *
     * @param boardManager le gestionnaire du plateau
     * @param playerManager le gestionnaire des joueurs
     */
    public GameManager(BoardManager boardManager, PlayerManager playerManager) {
        this.boardManager = boardManager;
        this.playerManager = playerManager;
    }

    /**
     * Cette méthode gère le processus de jeu.
     * Elle affiche le plateau, récupère le mouvement des joueurs, met à jour le plateau, vérifie si le jeu est terminé et change le joueur actuel.
     */
    public void play() {
        System.out.println("Bienvenue dans Tic Tac Toe ! Le jeu commence maintenant. " + playerManager.getCurrentPlayer().getRepresentation() + " commence le jeu.");
        while (!boardManager.isBoardFull()) {
            boardManager.displayBoard();
            int[] move = getMoveFromPlayer();
            boardManager.setOwner(move[0], move[1], playerManager.getCurrentPlayer());

            if (isOver(playerManager.getCurrentPlayer())) {
                System.out.println("Le joueur " + playerManager.getCurrentPlayer().getRepresentation() + " a gagné !");
                return;
            }
            playerManager.switchPlayer();
        }
        endGame();
    }

    /**
     * Cette méthode vérifie si le jeu est terminé en comptant si l'un des joueurs a une combinaison gagnante.
     *
     * @param player le joueur à vérifier
     * @return vrai si le jeu est terminé, faux sinon
     */
    public boolean isOver(Player player) {
        // Combinaisons gagnantes pour le jeu Tic Tac Toe
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
            if (boardManager.getBoard()[combination[0]].getRepresentation().equals(player.getRepresentation()) &&
                    boardManager.getBoard()[combination[1]].getRepresentation().equals(player.getRepresentation()) &&
                    boardManager.getBoard()[combination[2]].getRepresentation().equals(player.getRepresentation())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Cette méthode est appelée lorsque la partie est terminée.
     */
    public void endGame() {
        System.out.println("Partie Fini !");
    }

    /**
     * Cette méthode est une abstraction pour demander des entrées validées au joueur.
     *
     * @return une entrée validée
     */
    private String userChoice() {
        UserInput userInput = new UserInput();
        return userInput.getValidatedInput();
    }

    /**
     * Cette méthode demande au joueur de fournir une coordonnée (ligne ou colonne).
     *
     * @param type le type de coordonnée ("row" pour ligne, "column" pour colonne)
     * @return la coordonnée du joueur
     */
    private int askPlayerForCoordinate(String type) {
        System.out.println(playerManager.getCurrentPlayer().getRepresentation() + ", veuillez entrer votre choix " + type + ": ");
        String input = userChoice();
        return Integer.parseInt(input);
    }

    /**
     * Cette méthode récupère le déplacement du joueur.
     *
     * @return le déplacement du joueur sous forme de tableau de deux entiers
     */
    public int[] getMoveFromPlayer() {
        int row;
        int column;
        boolean isCellFree;
        do {
            row = askPlayerForCoordinate("row");
            column = askPlayerForCoordinate("column");
            isCellFree = "|   ".equals(boardManager.getBoard()[row * boardManager.getSIZE() + column].getRepresentation());
            if (!isCellFree) {
                System.out.println("La cellule choisie est déjà occupée. Réessayez.");
            }
        } while (!isCellFree);
        return new int[]{row, column};
    }
}