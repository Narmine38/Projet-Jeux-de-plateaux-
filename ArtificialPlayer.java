import java.util.Random;

public class ArtificialPlayer extends Player {

    /**
     * Constructeur du joueur qui initialise sa représentation.
     *
     * @param representation la représentation du joueur
     * @throws IllegalArgumentException si la représentation du joueur n'est ni "X" ni "O"
     */

    public ArtificialPlayer(String representation) {
        super(representation);
    }

}
