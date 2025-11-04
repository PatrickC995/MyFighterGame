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

    public Enemy EnemyEncounter(Enemy enemy){
        System.out.println("You have encountered a " + enemy.getName());
        enemy.printEnemyDetails();

        System.out.println("[1] Fight:\n[2] Run: ");
        int choice = sc.nextInt();

        switch (choice){
            case 1: FightEnemy(enemy);
            case 2:
        }
        return null;
    }

    public void FightEnemy(Enemy enemy) {
        int newEnemyHealth = enemy.getHealth() - player.getDamage();
        enemy.setHealth(newEnemyHealth);
        int newPlayerHealth = player.getHealth() - enemy.getDamage();
        player.setHealth(newPlayerHealth);

        IfPlayerOrEnemyDies(enemy);

        EnemyEncounter(enemy);
    }

    public void IfPlayerOrEnemyDies(Enemy enemy){
        if(player.getHealth() <= 0){
            System.out.println("You lose!");
        }
        else if(enemy.getHealth() <= 0){
            System.out.println("You win");

            Navigation navigation = new Navigation(player);
            navigation.ExitToMainMenu();
        }
    }
}
