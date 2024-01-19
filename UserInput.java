import java.util.Scanner;

/**
 * Classe UserInput pour gérer les entrées utilisateur.
 * Cette classe utilise un Scanner pour lire les saisies de l'utilisateur,
 * Et un InputValidator pour valider les saisies.
 */
public class UserInput {

    // Délégation de la lecture de l'entrée à un objet Scanner
    private static final Scanner scanner = new Scanner(System.in);

    // Un InputValidator pour valider les entrées
    private static final InputValidator inputValidator = new InputValidator();

    /**
     * Récupère une entrée utilisateur validée à l'aide de InputValidator.
     * @return La saisie validée
     */
    public static String getValidatedInput() {

        // Lit l'entrée de l'utilisateur
        String input = scanner.nextLine();

        // Boucle tant que l'entrée n'est pas valide
        while (!inputValidator.isValid(input)) {
            // Notifie l'utilisateur que l'entrée est invalide
            View.noValideTypeGame();
            // Lit à nouveau l'entrée de l'utilisateur
            input = scanner.nextLine();
        }

        // L'entrée est valide, elle est donc renvoyée
        return input;
    }
}