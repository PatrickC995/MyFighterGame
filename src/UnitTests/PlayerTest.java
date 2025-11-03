package UnitTests;


import classes.Player;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PlayerTest {

    @org.junit.jupiter.api.Test
    @Test
    public void defaultIdEmpty_generateIdFiveChars_setGetId() {
        Player p = new Player();

        // default id should be empty
        assertEquals("", p.getID(), "default id should be empty");

        // generated id should be non-null and 5 characters long
        String generatedID = p.GeneratePlayerID();
        assertNotNull(generatedID, "generated id should not be null");
        assertEquals(5, generatedID.length(), "generated id should be 5 characters");

        // setting id and retrieving it
        p.setID(generatedID);
        assertEquals(generatedID, p.getID(), "getID should return the value set with setID");
    }
}