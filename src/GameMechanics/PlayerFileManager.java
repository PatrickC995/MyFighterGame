package GameMechanics;

import classes.Player;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PlayerFileManager {

    private static String FILE_Path = "players.txt";

    // ONLY for tests
    public static void setFilePath(String path) {
        FILE_Path = path;
    }

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

    // Update a player in the file
    public boolean updatePlayer(String id, Player updatedPlayer) {
        List<Player> players = loadPlayers();
        boolean playerFound = false;
        for (int i = 0; i < players.size(); i++) {
            if (players.get(i).getID().equals(id)) {
                players.set(i, updatedPlayer);
                playerFound = true;
                break;
            }
        }
        if (!playerFound) {
            return false;
        }
        // Overwrite the file with the updated list
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_Path))) {
            for (Player player : players) {
                writer.write(player.toCSV());
                writer.newLine();
            }
            return true;
        } catch (IOException e) {
            System.out.println("Error updating player data: " + e.getMessage());
            return false;
        }
    }
}