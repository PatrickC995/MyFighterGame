package classes;

import java.util.Objects;
import java.util.UUID;

import MyLibrary.colour;

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
    private int healthPotionCount;
    private int damagePotionCount;

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
        this.healthPotionCount = 0;
        this.damagePotionCount = 0;
    }

    public Player(String id, String name, String password, int health, int damage, int xp, int level, int healthPotionCount, int damagePotionCount) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.health = health;
        this.damage = damage;
        this.maxHealth = health;
        this.xp = xp;
        this.level = level;
        this.healthPotionCount = healthPotionCount;
        this.damagePotionCount = damagePotionCount;
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
    public int getHealthPotionCount() {return healthPotionCount;}
    public int getDamagePotionCount() {return damagePotionCount;}

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
    public void setHealthPotionCount(int healthPotionCount) {this.healthPotionCount = healthPotionCount;}
    public void setDamagePotionCount(int damagePotionCount) {this.damagePotionCount = damagePotionCount;}

    public void PrintPlayerDetails(Player p) {
            System.out.println( "ID: " + p.id + "\n" +
                "Name: " + p.name + "\n" +
                "Health: " + colour.ANSI_GREEN + p.health + colour.ANSI_RESET + "\n" +
                "Damage: " + colour.ANSI_RED + p.damage + colour.ANSI_RESET + "\n" +
                "XP: " + colour.ANSI_PURPLE + p.xp + colour.ANSI_RESET + "\n" +
                "Level: " + colour.ANSI_YELLOW + p.level +  colour.ANSI_RESET + "\n" +
                "Health Potion Count: " + colour.ANSI_GREEN + p.healthPotionCount +  colour.ANSI_RESET + "\n" +
                "Damage Potion Count: " + colour.ANSI_RED + p.damagePotionCount +  colour.ANSI_RESET);
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

    public void PotionPlayerEffect(int num, Potion potion){
        switch (num) {
            case 1:
                if (healthPotionCount > 0) {
                    setHealth(getHealth() + potion.getHealthPotion());
                    healthPotionCount--;
                    System.out.println("Used health potion!");
                } else {
                    System.out.println("No health potions left!");
                }
                break;

            case 2:
                if (damagePotionCount > 0) {
                    setDamage(getDamage() + potion.getDamagePotion());
                    damagePotionCount--;
                    System.out.println("Used damage potion!");
                } else {
                    System.out.println("No damage potions left!");
                }
                break;
        }
    }

    //Convert to CSV for saving
    public String toCSV(){
        return id + "," + name + "," + password + "," + health + "," + damage + "," + xp + "," + level + "," + healthPotionCount + "," + damagePotionCount;
    }

    //Rebuild from CSV
    public static Player fromCSV(String csv){
        String[] parts = csv.split(",");
        if(parts.length == 9){
            return new Player(
                    parts[0],
                    parts[1],
                    parts[2],
                    Integer.parseInt(parts[3]),
                    Integer.parseInt(parts[4]),
                    Integer.parseInt(parts[5]),
                    Integer.parseInt(parts[6]),
                    Integer.parseInt(parts[7]),
                    Integer.parseInt(parts[8])
            );
        }
        return null;
    }
}
