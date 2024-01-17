/**
 * La classe Player représente un joueur dans un jeu.
 */
public class Player {

    // la représentation du joueur sur le plan de jeu
    private final String representation;

    /**
     * Constructeur du joueur qui initialise sa représentation.
     *
     * @param representation la représentation du joueur
     * @throws IllegalArgumentException si la représentation du joueur n'est ni "X" ni "O"
     */
    public Player(String representation) {
        if (!"X".equals(representation) && !"O".equals(representation)) {
            throw new IllegalArgumentException("Invalid representation.");
        }

        this.representation = "| " + representation + " ";
    }

    /**
     * Renvoie la représentation du joueur.
     *
     * @return la représentation du joueur
     */
    public String getRepresentation() {
        return this.representation;
    }
}