package UnitTests;

import GameMechanics.PlayerFileManager;
import classes.Player;
import org.junit.jupiter.api.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerFileManagerTest {

    private static final Path TEST_FILE = Path.of("playersTest.txt");

    @BeforeEach
    void setup() throws IOException {
        // Use test file for PlayerFileManager
        PlayerFileManager.setFilePath(TEST_FILE.toString());

        // Ensure file is empty before each test
        if (Files.exists(TEST_FILE)) Files.delete(TEST_FILE);
        Files.createFile(TEST_FILE);
    }

    @AfterEach
    void cleanup() throws IOException {
        // Remove the test file after each test
        if (Files.exists(TEST_FILE)) Files.delete(TEST_FILE);
    }

    @Test
    void savePlayer_writesPlayerToFile() throws IOException {
        Player p = new Player("A1234","Hero","pass123",100,20);
        PlayerFileManager.savePlayer(p);

        List<String> lines = Files.readAllLines(TEST_FILE);
        assertEquals(1, lines.size());
        assertEquals(p.toCSV(), lines.get(0));
    }

    @Test
    void loadPlayers_readsPlayersFromFile() throws IOException {
        String csv1 = "A1234,Hero,pass123,100,20";
        String csv2 = "B5678,Mage,abc,80,10";
        String csv3 = "279d7,Pat,pat123,100,10";

        Files.writeString(TEST_FILE, csv1 + "\n" + csv2 + "\n" + csv3);

        List<Player> players = PlayerFileManager.loadPlayers();

        assertEquals(3, players.size());
        assertEquals("Hero", players.get(0).getName());
        assertEquals("Mage", players.get(1).getName());
        assertEquals("Pat", players.get(2).getName());
    }

    @Test
    void authenticatePlayer_returnsPlayerWhenCorrect() throws IOException {
        String csv = "279d7,Pat,pat123,100,10";
        Files.writeString(TEST_FILE, csv);

        Player player = PlayerFileManager.authenticatePlayer("Pat","pat123");
        assertNotNull(player);
        assertEquals("Pat", player.getName());
        assertEquals("pat123", player.getPassword());
    }

    @Test
    void authenticatePlayer_returnsNullWhenIncorrect() throws IOException {
        String csv = "279d7,Pat,pat123,100,10";
        Files.writeString(TEST_FILE, csv);

        Player player = PlayerFileManager.authenticatePlayer("Pat","wrongpass");
        assertNull(player);
    }

    @Test
    void authenticatePlayer_returnsNullWhenArgumentsNull() {
        assertNull(PlayerFileManager.authenticatePlayer(null,null));
        assertNull(PlayerFileManager.authenticatePlayer("Pat",null));
        assertNull(PlayerFileManager.authenticatePlayer(null,"pat123"));
    }
}
