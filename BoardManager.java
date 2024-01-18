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
     * @param size la taille du plateau de jeu
     */
    public BoardManager(int size) {
        this.SIZE = size;
        this.board = new Cell[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++) {
            this.board[i] = new Cell();
        }
    }

    /**
     * Cette méthode affiche le plateau de jeu.
     */
    public void displayBoard() {
        for (int i = 0; i < SIZE; i++) {
            System.out.println("- - - - - - -");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i * SIZE + j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("- - - - - - -");
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

    // Le morpion est généralement joué sur un plateau 3x3,
    // vous allez probablement mapper ceci à une seule dimension en stockant les cellules consécutivement,
    // de gauche à droite et de haut en bas, de la manière suivante :
    //0 1 2
    //3 4 5
    //6 7 8
    //Vous pouvez calculer la ligne et la colonne correspondant à une position dans le tableau board à l'aide
    // des opérations de division et de reste (modulus) :
    //row = index / 3 (division entière)
    //col = index % 3 (reste)
    //Avec cela, vous pouvez convertir vos méthodes pour travailler avec un tableau à une dimension.
    // Par exemple, pour vérifier une victoire sur une ligne spécifique :
}