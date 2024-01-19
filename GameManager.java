

/**
 * La classe GameManager est responsable de la gestion du jeu.
 * Elle utilise les classes BoardManager et PlayerManager.
 * La partie commence par l'appel de la méthode play().
 */
public class GameManager {
    private final BoardManager boardManager; // Responsable de la gestion du plateau
    private final PlayerManager playerManager; // Responsable de la gestion des joueurs
    private final View view;

    /**
     * Constructeur de GameManager qui instancie les responsables de la gestion du plateau et des joueurs.
     *
     * @param boardManager  le gestionnaire du plateau
     * @param playerManager le gestionnaire des joueurs
     */
    public GameManager(BoardManager boardManager, PlayerManager playerManager, View view) {
        this.boardManager = boardManager;
        this.playerManager = playerManager;
        this.view = view;
    }


    /**
     * Cette méthode gère le processus de jeu.
     * Elle affiche le plateau, récupère le mouvement des joueurs, met à jour le plateau, vérifie si le jeu est terminé et change le joueur actuel.
     */
    public void play() {
        view.welcome();

        while (!boardManager.isBoardFull()) {

            view.displayBoard(boardManager.getBoard());

            view.displayTurnPlayer(playerManager.getCurrentPlayer());

            int[] move = getMoveFromPlayer(playerManager.getCurrentPlayer());
            boardManager.setOwner(move[0], move[1], playerManager.getCurrentPlayer());

            if (isOver(playerManager.getCurrentPlayer())) {
                view.displayWinner(playerManager.getCurrentPlayer());
                return;
            }
            playerManager.switchPlayer();
        }
        view.endGame();
    }

    /**
     * Cette méthode vérifie si le jeu est terminé en comptant si l'un des joueurs a une combinaison gagnante.
     *
     * @param player le joueur à vérifier
     * @return vrai si le jeu est terminé, faux sinon
     */
    public boolean isOver(Player player) {

        for (int[] combination : GeneratedSolved.generateWinningCombinations(boardManager.getSIZE())) {
            if (boardManager.getBoard()[combination[0]].getRepresentation().equals(player.getRepresentation()) &&
                    boardManager.getBoard()[combination[1]].getRepresentation().equals(player.getRepresentation()) &&
                    boardManager.getBoard()[combination[2]].getRepresentation().equals(player.getRepresentation())) {
                return true;
            }
        }
        return false;
    }



    /**
     * Cette méthode demande au joueur de fournir une coordonnée (ligne ou colonne).
     *
     * @param type le type de coordonnée ("row" pour ligne, "column" pour colonne)
     * @return la coordonnée du joueur
     */


    /**
     * Cette méthode récupère le déplacement du joueur.
     *
     * @return le déplacement du joueur sous forme de tableau de deux entiers
     */
    public int[] getMoveFromPlayer(Player player) {
        int row;
        int column;
        boolean isCellFree;
        do {
            if (playerManager.getCurrentPlayer() instanceof HumainPlayer) {
                row = InteractionUtilisateur.askPlayerForCoordinate(view, "row");
                column = InteractionUtilisateur.askPlayerForCoordinate(view, "column");
            } else {
                row = playerManager.RandomPlay();
                column = playerManager.RandomPlay();
            }

            isCellFree = "|   ".equals(boardManager.getBoard()[row * boardManager.getSIZE() + column].getRepresentation());
            if (!isCellFree) {
                view.cellNotEmpty();
            }
        } while (!isCellFree);
        return new int[]{row, column};
    }


}