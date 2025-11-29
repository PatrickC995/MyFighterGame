package GameMechanics;

import classes.Enemy;
import classes.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Combat {

    final private Player player;
    List<Enemy> enemies = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public Combat(Player player) {
        this.player = player;
    }

    public void FightRandomEnemy() {
        enemies = Enemy.initializeEnemyList();
        int randomIndex = (int) (Math.random() * enemies.size());
        EnemyEncounter(enemies.get(randomIndex));
    }

    public Enemy EnemyEncounter(Enemy enemy) {
        System.out.println("You have encountered a " + enemy.getName());
        System.out.println(enemy.PrintEnemyDetails());
        System.out.println(
                "Player Name: " + player.getName() +
                        "\nHealth: " + player.getHealth() +
                        "\nDamage: " + player.getDamage()
        );

        System.out.println("[1] Fight:\n[2] Run: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                FightEnemy(enemy);
                break;
            case 2:
                // You can handle run logic here if needed
                break;
            default:
                System.out.println("Invalid choice.");
                EnemyEncounter(enemy);
                break;
        }

        return null;
    }

    public void FightEnemy(Enemy enemy) {


        int newEnemyHealth = Math.max(0, enemy.getHealth() - player.getDamage());
        enemy.setHealth(newEnemyHealth);

        int newPlayerHealth = Math.max(0, player.getHealth() - enemy.getDamage());
        player.setHealth(newPlayerHealth);

        if (player.getHealth() <= 0) {
            System.out.println("You lose!");
            return;
        }

        if (enemy.getHealth() <= 0) {
            System.out.println("You win!");
            player.setHealth(player.getMaxHealth());
            Navigation navigation = new Navigation(player);
            navigation.ExitToMainMenu();
            return;
        }

        EnemyEncounter(enemy);
    }
}