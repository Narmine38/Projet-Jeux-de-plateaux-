public class InteractionUtilisateur {
    static int askPlayerForCoordinate(View view, String type) {
        view.displaySelectedTypeGame(type);
        String input = UserInput.getValidatedInput();
        return Integer.parseInt(input);
    }
}