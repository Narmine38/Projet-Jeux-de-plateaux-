public class View {
    private final BoardManager boardManager;

    PlayerManager playerManager;

    public View(BoardManager boardManager, PlayerManager playerManager) {
        this.boardManager = boardManager;
        this.playerManager = playerManager;
    }

    public void displayBoard(Cell[] board) {
        for (int i = 0; i < boardManager.getSIZE(); i++) {
            System.out.println("- - - - - - -");
            for (int j = 0; j < boardManager.getSIZE(); j++) {
                System.out.print(boardManager.getBoard()[i * boardManager.getSIZE() + j].getRepresentation());
            }
            System.out.println("|");
        }
        System.out.println("- - - - - - -");
    }

    public void displayTurnPlayer(Player player) {
        System.out.println("C'est au tour du joueur " + playerManager.getCurrentPlayer().getRepresentation() + " de jouer.");
    }

    public void displayWinner(Player player) {
        System.out.println("Le joueur " + playerManager.getCurrentPlayer().getRepresentation() + " a gagné !");

    }

    public void endGame() {
        System.out.println("Partie Fini !");
    }

    public void cellNotEmpty(){
        System.out.println("La cellule choisie est déjà occupée. Réessayez.");

    }

    public void displaySelectedTypeGame(String type){
        System.out.println(playerManager.getCurrentPlayer().getRepresentation() + ", veuillez entrer votre choix " + type + ": ");

    }

    public static void selectedGameType(){
        System.out.println("Choisissez le type de jeu : 0 pour Humain contre Ordinateur, 1 pour Humain contre Humain, 2 Ordinateur contre Ordinateur");
    }

    public void welcome(){
        System.out.println("Bienvenue dans Tic Tac Toe ! Le jeu commence maintenant.");

    }

    public static void noValideTypeGame(){
        System.out.println("Entrée invalide. Veuillez saisir une valeur correcte.");

    }

}