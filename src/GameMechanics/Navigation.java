package GameMechanics;

import classes.Player;
import MyLibrary.clearScreen;
import classes.Potion;

import java.util.Scanner;

public class Navigation {
    private final Player player;
    private final PlayerFileManager pfm = new PlayerFileManager();
    private final Scanner sc = new Scanner(System.in);
    Potion potion = new Potion();

    private static boolean runOnceWelcomePlayer = false;

    public Navigation(Player player) {
        this.player = player;
    }

    public void MainMenu() {

        if (!runOnceWelcomePlayer) {
            System.out.println("Welcome " + player.getName() + ", your journey begins here\n");
            runOnceWelcomePlayer = true;
        }

        System.out.println(
                "[1] View Player:\n" +
                        "[2] Fight:\n" +
                        "[0] Exit:\n");

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                ViewPlayerMenu();
                break;
            case 2:
                // Create Combat *after* player is initialized
                clearScreen.clearScreen();
                Combat combat = new Combat(player);
                combat.FightRandomEnemy();
                break;
            case 0:
                pfm.updatePlayer(player.getID(),  player);
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    public void ViewPlayerMenu() {
        boolean running = true;

        while (running) {
            clearScreen.clearScreen();

            player.PrintPlayerDetails(player);

            System.out.println(
                    "\n[1] Consume Potion\n" +
                            "[0] Exit to Main Menu"
            );

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    ChoosePotion();
                    break;

                case 0:
                    running = false; // exit loop
                    clearScreen.clearScreen();
                    MainMenu();
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }
        }
    }

    public void ChoosePotion() {
        System.out.println(
                "[1] Consume Health Potion\n" +
                "[2] Consume Damage Potion\n" +
                "[0] Exit to Player Menu"
        );

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                player.PotionPlayerEffect(1, potion);
                clearScreen.clearScreen();
                break;
            case 2:
                player.PotionPlayerEffect(2, potion);
                clearScreen.clearScreen();
                break;
            case 0:
                ViewPlayerMenu();
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
                clearScreen.clearScreen();
                MainMenu();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }
}