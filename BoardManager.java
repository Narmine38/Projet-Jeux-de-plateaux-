/**
 * La classe BoardManager gère le plateau de jeu, y compris la création du plateau, l'affichage du plateau et les interactions avec celui-ci.
 */
public class BoardManager {
    private final int SIZE; //La taille du plateau de jeu
    private int moveCount = 0; //Le nombre de coups joués
    private final Cell[] board; //Le plateau de jeu

    /**
     * Constructeur de BoardManager qui initialise le plateau de jeu avec la taille donnée.
     *
     */
    public BoardManager() {
        this.SIZE = 3;
        this.board = new Cell[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++) {
            this.board[i] = new Cell();
        }
    }

    /**
     * Cette méthode attribue une cellule du plateau de jeu à un joueur.
     *
     * @param row    la ligne de la cellule
     * @param column la colonne de la cellule
     * @param player le joueur propriétaire de la cellule
     */
    public void setOwner(int row, int column, Player player) {
        int index = (row * SIZE) + column;
        board[index].setOwner(player);
        moveCount++;
    }

    /**
     * Cette méthode vérifie si le plateau de jeu est plein, c'est-à-dire si tous les coups possibles ont été joués.
     *
     * @return vrai si le plateau est plein, faux sinon.
     */
    public boolean isBoardFull() {
        return moveCount == (SIZE * SIZE);
    }

    /**
     * Cette méthode donne accès au tableau qui représente le plateau de jeu.
     *
     * @return le plateau de jeu
     */
    public Cell[] getBoard() {
        return this.board;
    }

    /**
     * Cette méthode donne accès à la taille du plateau de jeu.
     *
     * @return la taille du plateau
     */
    public int getSIZE() {
        return SIZE;
    }

}