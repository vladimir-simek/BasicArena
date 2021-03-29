package cz.educanet.arena.logic;

import java.util.Random;

/**
 * Represents the arena.
 */
public class Arena {

    private Gladiator gladiator1;
    private Gladiator gladiator2;
    private int dmg1;
    private int dmg2;
    /**
     * Represents the current round. This property is incremented each round.
     */
    private int round = 0;

    /**
     * Makes the gladiators fight one round.
     */
    public void fight() {
        // TODO:
        // Gladiator 1 should deal (random) damage to Gladiator 2
        // Gladiator 2 should deal (random) damage to Gladiator 1
        Random random = new Random();
        int randomNumber = random.nextInt();

        if (randomNumber % 2 == 0) {
            dmg1 = gladiator1.dealDamage(gladiator2);
            if (!gladiator2.isDead()) {
                dmg2 = gladiator2.dealDamage(gladiator1);
            }
        } else {
            dmg2 = gladiator2.dealDamage(gladiator1);
            if (!gladiator1.isDead()){
                dmg1 =gladiator1.dealDamage(gladiator2);
            }
        }

        if (gladiator1.getHp() < 0) {
            gladiator1.setHp(0);
        }
        if (gladiator2.getHp() < 0) {
            gladiator2.setHp(0);
        }
        // Those will make sure that Hp is not less than 0
        round++;
    }

    public int getRound() {
        return round;
    }

    /**
     * @return the winner, null if none.
     */
    public Gladiator getWinner() {
        if (gladiator1.isDead()) {
            return gladiator2;
        } else if (gladiator2.isDead()) {
            return gladiator1;
        } else return null;
    }

    public void setGladiator1(Gladiator gladiator1) {
        this.gladiator1 = gladiator1;
    }

    public void setGladiator2(Gladiator gladiator2) {
        this.gladiator2 = gladiator2;
    }

    public Gladiator getGladiator1() {
        return gladiator1;
    }

    public Gladiator getGladiator2() {
        return gladiator2;
    }

    public int getDmg1(){
        return dmg1;
    }

    public int getDmg2(){
        return dmg2;
    }
}
