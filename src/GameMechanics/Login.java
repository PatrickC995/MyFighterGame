package GameMechanics;

import classes.Player;
import java.util.Scanner;

public class Login {

    private Player player;
    private final PlayerFileManager pfm = new PlayerFileManager();
    private Navigation nav;
    private final Scanner sc = new Scanner(System.in);

    public void StartGame() {
        System.out.println(
                "[1] Login:\n" +
                        "[2] Create Account");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: login(); break;
            case 2: CreateAccount(); break;
            default: System.out.println("Invalid option."); break;
        }
    }

    public void login(){
        System.out.println("Enter your Player's name:");
        String name = sc.nextLine().trim();

        System.out.println("Enter your Player's password:");
        String password = sc.nextLine().trim();

        Player authenticated = pfm.authenticatePlayer(name, password);

        if (authenticated != null) {
            this.player = authenticated;
            this.nav = new Navigation(this.player); // ensure Navigation uses the authenticated player
            System.out.println("Login successful! Welcome " + player.getName());
            nav.MainMenu();
        } else {
            System.out.println("Login failed. Invalid name or password.");
        }
    }

    public void CreateAccount() {
        this.player = new Player();

        System.out.println("Enter your Player's name:");
        player.setName(sc.nextLine().trim());

        System.out.println("Enter your Player's password:");
        player.setPassword(sc.nextLine().trim());

        player.setId(player.GenerateID());

        //pfm.savePlayer(player);

        this.nav = new Navigation(this.player);
        nav.MainMenu();
    }

    public Player getPlayer() {
        return player;
    }
}