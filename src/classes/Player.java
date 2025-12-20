package classes;

import java.util.Objects;
import java.util.UUID;

public class Player {

    //Variables
    private String id;
    private String name;
    private String password;
    private int health;
    private int damage;
    private int maxHealth;
    private int xp;
    private int level;

    //Constructor
    public Player() {
        this.id = "";
        this.name = "";
        this.password = "";
        this.health = 100;
        this.damage = 10;
        this.maxHealth = health;
        this.xp = 0;
        this.level = 1;
    }

    public Player(String id, String name, String password, int health, int damage, int xp, int level) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.health = health;
        this.damage = damage;
        this.maxHealth = health;
        this.xp = xp;
        this.level = level;
    }

    //Getters and Setters
    public String getID() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }
    public int getMaxHealth() { return maxHealth; }
    public int getXP() { return xp; }
    public int getLevel() { return level; }

    public void setId(String id) {
        this.id = id == null ? "" : id;
    }
    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }
    public void setPassword(String password) {this.password = Objects.requireNonNull(password, "password must not be null");}
    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }
    public void setDamage(int damage) {
        this.damage = Math.max(0, damage);
    }
    public void setXP(int xp) {this.xp = Math.max(0, xp);}
    public void setLevel(int level) {this.level = Math.max(0, level);}

    public String PrintPlayerDetails(Player p) {
        return "ID: " + p.id + "\n" +
                "Name: " + p.name + "\n" +
                "Health: " + p.health + "\n" +
                "Damage: " + p.damage + "\n" +
                "XP: " + p.xp + "\n" +
                "Level: " + p.level;
    }

    public String GenerateID(){
        String generated = UUID.randomUUID().toString().substring(0, 5);
        this.id = generated;
        return generated;
    }

    public void LevelUp(){
        while (getXP() >= 10) {
            setLevel(getLevel() + 1);
            setXP(getXP() - 10);
            System.out.println("Level up!");
        }
    }

    //Convert to CSV for saving
    public String toCSV(){
        return id + "," + name + "," + password + "," + health + "," + damage + "," + xp + "," + level;
    }

    //Rebuild from CSV
    public static Player fromCSV(String csv){
        String[] parts = csv.split(",");
        if(parts.length == 7){
            return new Player(
                    parts[0],
                    parts[1],
                    parts[2],
                    Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    Integer.parseInt(parts[6]));
        }
        return null;
    }
}