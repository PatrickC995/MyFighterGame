package classes;

import MyLibrary.randomNumberGenerator;

import java.util.Random;

public class Potion {

    // Health Potion
    private int healthPotion;
    private int healthPotionCount;

    // Damage Potion
    private int damagePotion;
    private int damagePotionCount;

    //Getters and Setters
    public int getHealthPotion() {return healthPotion;}
    public int getHealthPotionCount() {return healthPotionCount;}
    public int getDamagePotion() {return damagePotion ;}
    public int getDamagePotionCount() {return damagePotionCount;}

    public void setHealthPotion(int healthPotion) {this.healthPotion = healthPotion;}
    public void setHealthPotionCount(int healthPotionCount) {this.healthPotion = healthPotionCount;}
    public void setDamagePotion(int damagePotion) {this.damagePotion = damagePotion;}
    public void setDamagePotionCount(int damagePotionCount) {this.damagePotionCount = damagePotionCount;}

    //Constructor
    public Potion() {
        this.healthPotion = 5;
        this.healthPotionCount = 0;
        this.damagePotion = 2;
        this.damagePotionCount = 0;
    }

    public Potion(int healthPotion, int healthPotionCount, int damagePotion, int damagePotionCount) {
      this.healthPotion = healthPotion;
      this.healthPotionCount = healthPotionCount;
      this.damagePotion = damagePotion;
      this.damagePotionCount = damagePotionCount;
    }


    public String randomPotion() {
        Random random = new Random();
        int randomNumber = random.nextInt(2) + 1;

        switch (randomNumber) {
            case 1:
                return "health";
            case 2:
                return "damage";
            default:
                return "";
        }
    }

    public void potionDisplay() {
        System.out.println(
                "You have " + healthPotionCount + "health potions\n " +
                "You have " + damagePotionCount + "damage potions");
    }
}
