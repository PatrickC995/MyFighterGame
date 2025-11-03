package GameMechanics;

import classes.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerFileManager {

    private static final String FILE_Path = "players.txt";

    //Save player data to file
    public static void savePlayer(Player player) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_Path, true))) {
            writer.write(player.toCSV());
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Error saving player data: " + e.getMessage());
        }
    }

    //Load all players from file
    public static List<Player> loadPlayers() {
        List<Player> players = new ArrayList<>();
        String line;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_Path))) {
            while ((line = reader.readLine()) != null) {
                Player player = Player.fromCSV(line);
                if (player != null) {
                    players.add(player);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("No saved players found.");
        } catch (IOException e) {
            System.out.println("Error loading player data: " + e.getMessage());
        }
        return players;
    }

    //Authenticate player by name and password
    public static Player authenticatePlayer(String name, String password) {
        if (name == null || password == null) return null;
        name = name.trim();
        password = password.trim();

        List<Player> players = loadPlayers();
        for (Player player : players) {
            if (name.equals(player.getName()) && password.equals(player.getPassword())) {
                return player;
            }
        }
        return null; // Authentication failed
    }
}