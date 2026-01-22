package classes;

import MyLibrary.colour;

import java.util.ArrayList;
import java.util.List;

public class Enemy {

    //Variables
   private String name;
   private int health;
   private int damage;
   private int xpLoss;

    //Getters and Setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getXpLoss() { return xpLoss; }

    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }
    public void setXpLoss(int xpLoss) {this.xpLoss = xpLoss;}

    //Constructor
    public Enemy(String name, int health, int damage, int xpLoss) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.xpLoss = xpLoss;
    }

    public String PrintEnemyDetails() {
        return  "Name: " + name + "\n" +
                "Health: " + colour.ANSI_GREEN + health + colour.ANSI_RESET + "\n" +
                "Damage: " + colour.ANSI_RED + damage + colour.ANSI_RESET;
    }

    public static List<Enemy> initializeEnemyList() {
        List<Enemy> enemies = new ArrayList<>();

        // Name, Health, Damage, XpLoss
        enemies.add(new Enemy("Bat", 40, 5, 2));
        enemies.add(new Enemy("Rat", 50, 7,3));
        enemies.add(new Enemy("Knight", 140, 20,10));

        return enemies;
    }
}