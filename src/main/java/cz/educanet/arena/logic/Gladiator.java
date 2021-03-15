package cz.educanet.arena.logic;

public class Gladiator {
    /**
     * Name of the gladiator
     */
    private String name;

    // TODO: Add the rest of the properties
    // TODO: Generate/create getters and setters for these properties

    /**
     * @return true if hp is <= 0, else false
     */
    public boolean isDead() {
        // TODO:
        throw new UnsupportedOperationException();
    }

    /**
     * Generates a random value between min. damage and max. damage and deals it to the enemy.
     * @param enemy Enemy gladiator
     */
    public void dealDamage(Gladiator enemy) {
        // TODO:
        // Generate the random value, that the gladiator will deal.
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
