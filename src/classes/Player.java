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

    //Constructor
    public Player() {
        this.id = "";
        this.name = "";
        this.password = "";
        this.health = 100;
        this.damage = 10;
    }

    public Player(String id, String name, String password, int health, int damage) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.health = health;
        this.damage = damage;
    }

    //Getters and Setters
    public String getID() { return id; }
    public String getName() { return name; }
    public String getPassword() { return password; }
    public int getHealth() { return health; }
    public int getDamage() { return damage; }

    public void setId(String id) {
        this.id = id == null ? "" : id;
    }
    public void setName(String name) {
        this.name = Objects.requireNonNull(name, "name must not be null");
    }

    public void setPassword(String password) {
        this.password = Objects.requireNonNull(password, "password must not be null");
    }

    public void setHealth(int health) {
        this.health = Math.max(0, health);
    }

    public void setDamage(int damage) {
        this.damage = Math.max(0, damage);
    }

    public void PrintPlayerDetails(Player p){
        System.out.println
                ("ID: " + p.id + "\n" +
                 "Name: " + p.name +  "\n" +
                 "Health: " + p.health + "\n" +
                 "Damage: " + p.damage);
    }

    public String GenerateID(){
        String generated = UUID.randomUUID().toString().substring(0, 5);
        this.id = generated;
        return generated;
    }

    //Convert to CSV for saving
    public String toCSV(){
        return id + "," + name + "," + password + "," + health + "," + damage;
    }

    //Rebuild from CSV
    public static Player fromCSV(String csv){
        String[] parts = csv.split(",");
        if(parts.length == 5){
            return new Player(
                    parts[0],
                    parts[1],
                    parts[2],
                    Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]));
        }
        return null;
    }
}