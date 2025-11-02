package GameMechanics;

import classes.Player;
import java.util.Scanner;

public class Login {

    Player player = new Player();
    Scanner sc = new Scanner(System.in);

    public void StartGame() {
        System.out.println(
                "[1] Login:\n" +
                "[2] Create Account");

        int choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {
            case 1: System.out.println("Will Complete Later"); break;
            case 2: CreateAccount(); break;
            default: System.out.println("Invalid option."); break;
        }
    }

    public void CreateAccount() {
        System.out.println("Enter your Player's name:");
        player.setName(sc.nextLine());

        player.setID(player.GeneratePlayerID());

        // Optional: Show the player info
        System.out.println("\nAccount Created!");
        System.out.println("Name: " + player.getName());
        System.out.println("ID: " + player.getID());
    }
}