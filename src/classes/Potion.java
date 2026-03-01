package classes;

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

}
