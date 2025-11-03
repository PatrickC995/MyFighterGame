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
    public void defaultIdEmpty_setGetName() {

        // default name should be empty
        assertEquals("", p.getName(), "default name should be empty");

        // setting name and retrieving it
        String testName = "Hero";
        p.setName(testName);
        assertEquals(testName, p.getName(), "getName should return the value set with setName");
    }
}