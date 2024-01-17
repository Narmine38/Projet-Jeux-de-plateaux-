import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe InputValidator pour valider les entrées de l'utilisateur.
 * Cette classe utilise une expression régulière pour valider si l'entrée de l'utilisateur est un chiffre valide entre 0 à 2.
 */
public class InputValidator {

    // Définition de l'expression régulière pour un nombre valide. Ici on accepte les nombres de 0 à 2.
    private static final String VALID_NUMBER_REGEX = "[0-2]";

    // Compilation de l'expression régulière en un Pattern.
    private final Pattern pattern = Pattern.compile(VALID_NUMBER_REGEX);

    /**
     * Méthode pour valider le texte entré par l'utilisateur.
     * @param userInput Le texte entré par l'utilisateur.
     * @return true si le texte est un nombre valide entre 0 à 2 sinon il renvoie false.
     */
    public boolean isValid(String userInput) {
        // Création d'un matcher pour le texte utilisateur à partir du pattern défini.
        Matcher matcher = pattern.matcher(userInput);

        // Si le texte correspond au pattern, la méthode retourne true, sinon elle retourne false.
        return matcher.matches();
    }
}