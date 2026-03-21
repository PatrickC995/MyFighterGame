package classes;

import java.util.Random;

public class Potion {

    // Health Potion
    private int healthPotion;

    // Damage Potion
    private int damagePotion;

    //Getters and Setters
    public int getHealthPotion() {return healthPotion;}
    public int getDamagePotion() {return damagePotion ;}

    public void setHealthPotion(int healthPotion) {this.healthPotion = healthPotion;}
    public void setDamagePotion(int damagePotion) {this.damagePotion = damagePotion;}

    //Constructor
    public Potion() {
        this.healthPotion = 5;
        this.damagePotion = 2;
    }

    public Potion(int healthPotion, int damagePotion) {
      this.healthPotion = healthPotion;
      this.damagePotion = damagePotion;
    }


    public String randomPotion() {
        Random random = new Random();
        int randomNumber = random.nextInt(4) + 1;

        switch (randomNumber) {
            case 1:
                return "health";
            case 2:
                return "damage";
            default:
                return "";
        }
    }
}
