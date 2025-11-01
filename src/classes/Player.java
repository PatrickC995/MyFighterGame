package classes;

public class Player {

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
    public Player() {
        this.name = "";
        this.health = 100;
        this.damage = 10;
    }

    public void PrintPlayerDetails(Player p){
        System.out.println
                ("Name: " + p.name +  "\n" +
                 "Health: " + p.health + "\n" +
                 "Damage: " + p.damage);
    }
}