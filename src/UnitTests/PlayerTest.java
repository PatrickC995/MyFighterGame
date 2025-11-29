package UnitTests;


import classes.Player;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    Player p = new Player();

    @org.junit.jupiter.api.Test

    @Test
    public void defaultIdEmpty_generateIdFiveChars_setGetId() {

        // default id should be empty
        assertEquals("", p.getID(), "default id should be empty");

        // generated id should be non-null and 5 characters long
        String generatedID = p.GenerateID();
        assertNotNull(generatedID, "generated id should not be null");
        assertEquals(5, generatedID.length(), "generated id should be 5 characters");

        // setting id and retrieving it
        p.setId(generatedID);
        assertEquals(generatedID, p.getID(), "getID should return the value set with setID");
    }

    @Test
    public void defaultNameIsEmpty_setGetName() {

        // default name should be empty
        assertEquals("", p.getName(), "default name should be empty");

        // setting name and retrieving it
        String testName = "Hero";
        p.setName(testName);
        assertEquals(testName, p.getName(), "getName should return the value set with setName");
    }

    @Test
    public void defaultHealthIs100_setGetHealth() {

        // default should be a 100
        assertEquals(100, p.getHealth(), "default health should be 100");

        int testHealth = 200;
        p.setHealth(testHealth);
        assertEquals(testHealth, p.getHealth(), "health should be 200");
    }

    @Test
    public void defaultDamageIs10_setGetDamage() {

        // default damage should be a 100
        assertEquals(10, p.getDamage(), "default damage should be 10");

        // set damage to 200
        int testDamage = 100;
        p.setDamage(testDamage);
        assertEquals(testDamage, p.getDamage(), "damage should be 100");
    }

    @Test
    public void defaultMaxHealthIs100_maxHealthTheSameAsHealth() {

        // default max health should be a 100
        assertEquals(100, p.getMaxHealth(), "maxHealth should be 100");

        // max health should be the same as health
        assertEquals(p.getHealth(), p.getMaxHealth(), "maxHealth should be 100");
    }

    @Test
    public void printPlayerDetails(){
        p.setId("A1234");
        p.setName("Hero");
        p.setHealth(100);
        p.setDamage(100);

        String expected =
                "ID: A1234" +  "\n" +
                "Name: Hero\n" +
                "Health: 100\n" +
                "Damage: 100";

        assertEquals(expected, p.PrintPlayerDetails(p),"printEnemyDetails should return the exact values that were assigned to the enemy.");
    }
}