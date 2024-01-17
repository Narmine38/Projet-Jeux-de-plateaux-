import java.util.Scanner;

public class UserInput {
    private final Scanner scanner = new Scanner(System.in);
    private final InputValidator inputValidator = new InputValidator();

    public String getValidatedInput() {
        String input = scanner.nextLine();
        while (!inputValidator.isValid(input)) {
            System.out.println("Entrée invalide. Veuillez saisir une valeur correcte.");
            input = scanner.nextLine();
        }
        return input;
    }
}
