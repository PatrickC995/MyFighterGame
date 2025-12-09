package GameMechanics;

import classes.Player;
import java.util.Scanner;

public class Navigation {
    private final Player player;
    private final Scanner sc = new Scanner(System.in);

    public Navigation(Player player) {
        this.player = player;
    }

    public void MainMenu() {
        System.out.println("Welcome " + player.getName() + ", your journey begins here\n");

        System.out.println(
                "[1] View Player:\n" +
                        "[2] Fight:\n" +
                        "[0] Exit:\n");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println(player.PrintPlayerDetails(player));
                ExitToMainMenu();
                break;
            case 2:
                // Create Combat *after* player is initialized
                Combat combat = new Combat(player);
                combat.FightRandomEnemy();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public void ExitToMainMenu() {
        System.out.println("[0] Exit to Main Menu");
        int choice = sc.nextInt();
        switch (choice) {
            case 0:
                MainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}
