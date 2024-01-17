/**
 * La classe Cell représente une cellule sur un tableau de jeu.
 */
public class Cell {

    // la représentation de la cellule sur le plan de jeu
    private String representation = "|   ";

    /**
     * Renvoie la représentation de la cellule.
     *
     * @return la représentation de la cellule
     */
    public String getRepresentation() {
        return representation;
    }

    /**
     * Définit le propriétaire de la cellule en définissant sa représentation.
     *
     * @param player le joueur propriétaire de la cellule
     */
    public void setOwner(Player player) {
        this.representation = player.getRepresentation();
    }
}