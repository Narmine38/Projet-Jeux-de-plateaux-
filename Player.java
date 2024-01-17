/**
 * The Player class represents a player in a game. Each player has a representation
 * that can be either "| X " or "| O ".
 */
public class Player {

    private final String representation;

    public Player(String representation) {
        if(!"| X ".equals(representation) && !"| O ".equals(representation)) {
            throw new IllegalArgumentException("Invalid representation.");
        }
        this.representation = representation;
    }

    public String getRepresentation() {
        return this.representation;
    }
}
