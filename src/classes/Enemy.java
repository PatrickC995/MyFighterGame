package classes;

import java.util.ArrayList;
import java.util.List;

public class Enemy {

    //Variables
    String name;
    int health;
    int damage;

    //Getters and Setters
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }

    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }

    //Constructor
    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public void printEnemyDetails() {
        System.out.println(
                "Name: " + name + "\n" +
                        "Health: " + health + "\n" +
                        "Damage: " + damage
        );
    }

    public static List<Enemy> initializeEnemyList() {
        List<Enemy> enemies = new ArrayList<>();

        enemies.add(new Enemy("Bat", 40, 5));
        enemies.add(new Enemy("Rat", 50, 7));
        enemies.add(new Enemy("Knight", 140, 20));

        return enemies;
    }
}