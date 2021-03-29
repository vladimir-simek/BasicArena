package cz.educanet.arena.logic;

import java.util.Random;

public class Gladiator {

    private String name;
    private int hp;
    private int maxDMG;
    private int minDMG;


    public boolean isDead() {
        return this.hp <= 0;
    }

    public int dealDamage(Gladiator enemy) {
        Random random = new Random();
        int damage = random.nextInt(Math.abs(maxDMG-minDMG)) + minDMG;
        int finalHealth = enemy.getHp() - damage;
        enemy.setHp(finalHealth);

        return damage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxDMG() {
        return maxDMG;
    }

    public void setMaxDMG(int maxDMG){
        this.maxDMG = maxDMG;
    }

    public int getMinDMG(){
        return minDMG;
    }

    public void setMinDMG(int minDMG){
        this.minDMG = minDMG;
    }
}
