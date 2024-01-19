public class GeneratedSolved {
    /**
     * Méthode d'affichage des combinaisons gagnantes
     * @param combinations tableau 2D contenant les combinaisons
     */
    public static void DisplayCombo(int[][] combinations) {
        // Génération des combinaisons gagnantes
        int[][] winningCombinations = generateWinningCombinations(3);
        // Parcours et affichage de chaque combinaison
        for (int[] combination : winningCombinations) {
            System.out.print("{ ");
            // Parcours et affichage de chaque cellule dans la combinaison
            for (int cell : combination) {
                System.out.print(cell + " ");
            }
            System.out.println("}");
        }
    }

    /**
     * Méthode de génération des combinaisons gagnantes
     * @param size la taille du plateau de jeu
     * @return un tableau 2D contenant toutes les combinaisons gagnantes possibles
     */
    public static int[][] generateWinningCombinations(int size) {
        // Initialisation du tableau contenant toutes les combinaisons possibles
        int[][] combinations = new int[size * 2 + 2][size];
        // Génération des combinaisons pour les lignes
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                combinations[i][j] = i * size + j;
            }
        }
        // Génération des combinaisons pour les colonnes
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Chaque valeur en colonne dans le tableau
                // correspond à l'indice de colonne multiplié par la taille du tableau
                // auquel on ajoute l'indice de ligne.
                // Ces valeurs permettent de tracer les combinaisons gagnantes en colonnes.
                combinations[i + size][j] = j * size + i;
            }
        }
        // Génération des combinaisons pour les diagonales
        for (int i = 0; i < size; i++) {
            // Pour chaque élément dans une diagonale 'i',
            // l'emplacement de cet élément est calculé en multipliant 'i' par 'size' et en ajoutant 'i'.
            // Le résultat est la position de 'i' dans une première diagonale (allant du haut gauche vers le bas droit).
            combinations[2 * size][i] = i * size + i;
            // Pour chaque élément dans une diagonale 'i',
            // l'emplacement de cet élément est calculé en multipliant 'i' par 'size' et en ajoutant la différence entre 'size' et 'i' moins 1.
            // Le résultat est la position de 'i' dans une seconde diagonale (allant du haut droit vers le bas gauche).
            combinations[2 * size + 1][i] = i * size + (size - i - 1);
        }
        // Retourne toutes les combinaisons
        return combinations;
    }
}