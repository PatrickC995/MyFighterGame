package UnitTests;

import classes.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnemyTest {

    @Test
    public void defaultValues_setAndGetName_setAndGetHealth_setAndGetDamage() {
        // Arrange
        Enemy e = new Enemy("", 0, 0,0);

        // Assert default name
        assertEquals("", e.getName(), "Default name should be empty");

        // Act
        String testName = "Villain";
        e.setName(testName);
        e.setHealth(120);
        e.setDamage(15);

        // Assert
        assertEquals(testName, e.getName(), "getName should return value set using setName");
        assertEquals(120, e.getHealth());
        assertEquals(15, e.getDamage());
    }

    @Test
    public void initializeEnemyListCreatesList() {
        var enemies = Enemy.initializeEnemyList();

        assertNotNull(enemies);
        assertEquals(3, enemies.size());
        assertEquals("Bat", enemies.get(0).getName());
        assertEquals("Rat", enemies.get(1).getName());
        assertEquals("Knight", enemies.get(2).getName());
    }

    @Test
    public void printEnemyDetails(){
        // Arrange
        Enemy e = new Enemy("Orc", 110, 25,5);

        String expected =
                "Name: Orc\n" +
                "Health: 110\n" +
                "Damage: 25";

        assertEquals(expected,e.PrintEnemyDetails(), "printEnemyDetails should return the exact values that were assigned to the enemy.");
    }
}