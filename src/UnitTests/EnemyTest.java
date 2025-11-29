package UnitTests;

import classes.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class EnemyTest {

    @Test
    public void defaultValues_setAndGetName() {
        // Arrange
        Enemy e = new Enemy("", 0, 0);

        // Assert default name
        assertEquals("", e.getName(), "Default name should be empty");

        // Act
        String testName = "Villain";
        e.setName(testName);

        // Assert
        assertEquals(testName, e.getName(), "getName should return value set using setName");
    }

    @Test
    public void setAndGetHealth() {
        Enemy e = new Enemy("", 0, 0);

        e.setHealth(120);
        assertEquals(120, e.getHealth());
    }

    @Test
    public void setAndGetDamage() {
        Enemy e = new Enemy("", 0, 0);

        e.setDamage(15);
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
    public void printPlayerDetails(){
        // Arrange
        Enemy e = new Enemy("Orc", 110, 25);

        String expected =
                "Name: Orc\n" +
                "Health: 110\n" +
                "Damage: 25";

        assertEquals(expected,e.PrintEnemyDetails(), "printEnemyDetails should return the exact values that were assigned to the enemy.");
    }
}