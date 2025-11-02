package classes;

import java.util.UUID;

public class Player {

    //Variables
    String id;
    String name;
    int health;
    int damage;

    //Constructor
    public Player() {
        this.id = "";
        this.name = "";
        this.health = 100;
        this.damage = 10;
    }

    //Getters and Setters
    public String getID() { return id; }
    public String getName() { return name; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }

    public void setID(String id) { this.id = id; }
    public void setName(String name) { this.name = name; }
    public void setHealth(int health) { this.health = health; }
    public void setDamage(int damage) { this.damage = damage; }

    public void PrintPlayerDetails(Player p){
        System.out.println
                ("ID: " + p.id + "\n" +
                 "Name: " + p.name +  "\n" +
                 "Health: " + p.health + "\n" +
                 "Damage: " + p.damage);
    }

    public String GeneratePlayerID(){
        String uniqueKey = UUID.randomUUID().toString().substring(0, 5);
        return uniqueKey;
    }
}