package GameMechanics;

import classes.Enemy;
import classes.Player;
import MyLibrary.clearScreen;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combat {

    private final Player player;
    private List<Enemy> enemies = new ArrayList<>();
    private final Scanner sc = new Scanner(System.in);

    public Combat(Player player) {
        this.player = player;
    }

    public void FightRandomEnemy() {
        enemies = Enemy.initializeEnemyList();
        int randomIndex = (int) (Math.random() * enemies.size());
        Enemy enemy = enemies.get(randomIndex);

        EnemyEncounter(enemy);
    }

    /**
     * Encounter handler – rewritten to be test-friendly.
     * Does NOT call FightEnemy repeatedly and does NOT loop input.
     *
     * Tests override this method to record behavior.
     */
    public Enemy EnemyEncounter(Enemy enemy) {

        // Print encounter info (gameplay)
//        clearScreen();
        System.out.println("You have encountered a " + enemy.getName());
        System.out.println(enemy.PrintEnemyDetails());

        System.out.println(
                "Player Name: " + player.getName() +
                        "\nHealth: " + player.getHealth() +
                        "\nDamage: " + player.getDamage()
        );

        System.out.println("[1] Fight\n[2] Run");
        System.out.print("Choice: ");

        // Real game: choose action
        if (sc.hasNextInt()) {
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    FightEnemy(enemy);
                    break;

                case 2:
                    System.out.println("You ran away...");
                    return enemy;

                default:
                    System.out.println("Invalid choice.");
                    return enemy;
            }
        }

        return enemy;
    }

    /**
     * Performs ONE ROUND of combat.
     * The logic here is EXACTLY what your tests expect.
     */
    public void FightEnemy(Enemy enemy) {
        clearScreen.clearScreen();

        // Player damages enemy
        int newEnemyHealth = Math.max(0, enemy.getHealth() - player.getDamage());
        enemy.setHealth(newEnemyHealth);

        // Enemy damages player
        int newPlayerHealth = Math.max(0, player.getHealth() - enemy.getDamage());
        player.setHealth(newPlayerHealth);

        // PLAYER DIES
        if (player.getHealth() <= 0) {
            clearScreen.clearScreen();
            System.out.println("You lose!");
            return;
        }

        // ENEMY DIES
        if (enemy.getHealth() <= 0) {
            clearScreen.clearScreen();
            System.out.println("You win!");
            player.setXP(player.getXP() + enemy.getXpLoss());
            System.out.println("you gained " + enemy.getXpLoss() + " xp");
            player.LevelUp();
            player.setHealth(player.getMaxHealth());

            Navigation navigation = createNavigation(player);
            navigation.ExitToMainMenu();
            return;
        }

        // BOTH SURVIVE → call encounter hook (tests rely on this)
        EnemyEncounter(enemy);
    }
    /**
     * Factory method so tests can intercept navigation behavior.
     */
    protected Navigation createNavigation(Player player) {
        return new Navigation(player);
    }
}