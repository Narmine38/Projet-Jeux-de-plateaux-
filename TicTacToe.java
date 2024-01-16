public class TicTacToe {

    // La taille du plateau de jeu (carré)
    final int SIZE;

    // Tableau représentant les cellules du plateau
    Cell[] board;

    // Constructeur pour initialiser le jeu avec une taille spécifique
    public TicTacToe(int size) {
        this.SIZE = size;
        this.board = new Cell[SIZE * SIZE];

        // Initialisation de chaque cellule du plateau
        for (int i = 0; i < SIZE * SIZE; i++) {
            this.board[i] = new Cell();
        }
    }

    // Méthode pour afficher le plateau de jeu
    public void display() {

        // Boucle pour parcourir chaque ligne du plateau
        for (int i = 0; i < SIZE; i++) {

            // Affiche une ligne de séparation entre chaque ligne du plateau
            System.out.println("- - - - - - -");

            // Boucle pour parcourir chaque colonne de la ligne actuelle
            for (int j = 0; j < SIZE; j++) {

                // Affiche la représentation de la cellule à la position i, j
                System.out.print(board[i * SIZE + j].getRepresentation());
            }

            // Saute une ligne après l'affichage de chaque ligne du plateau
            System.out.println("|");
        }

        // Affiche une ligne de séparation après avoir affiché toutes les lignes du plateau
        System.out.println("- - - - - - -");
    }
}
