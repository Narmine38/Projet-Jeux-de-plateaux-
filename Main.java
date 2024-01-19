/**
 * La classe Main est le point d'entrée pour l'application. 
 * Elle crée une instance de TicTacToe et commence le jeu.
 */
public class Main {
    /**
     * La méthode principale qui est le point d'entrée pour l'application.
     * @param args Un tableau de chaînes représentant les arguments de la ligne de commande. Non utilisé dans cette application.
     */
    public static void main(String[] args){
        // Crée une instance de TicTacToe avec une taille de plateau de 3.
        TicTacToe ticTacToe = new TicTacToe(3);
        // Commence le jeu
        ticTacToe.playGame();
//        int[][] Morpion = GeneratedSolved.generateWinningCombinations(3);
//        GeneratedSolved.DisplayCombo(Morpion);
    }
}