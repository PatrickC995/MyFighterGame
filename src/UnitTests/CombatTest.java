package UnitTests;

import GameMechanics.Combat;
import GameMechanics.Navigation;
import classes.Enemy;
import classes.Player;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CombatFightEnemyTest {

    // Subclass for controlled behavior in tests
    static class TestCombat extends Combat {

        Enemy lastEncountered = null;
        boolean exitCalled = false;

        public TestCombat(Player player) {
            super(player);
        }

        @Override
        public Enemy EnemyEncounter(Enemy e) {
            lastEncountered = e;   // record encountered enemy
            return e;
        }

        @Override
        protected Navigation createNavigation(Player player) {
            return new Navigation(player) {
                @Override
                public void ExitToMainMenu() {
                    exitCalled = true;   // record exit action
                }
            };
        }
    }

    @Test
    void fightEnemy_enemyDies_playerWins() {
        Player player = new Player("001", "Hero", "pass", 100, 50,0,1);
        Enemy enemy = new Enemy("Bat", 40, 10);

        TestCombat combat = new TestCombat(player);
        combat.FightEnemy(enemy);

        assertEquals(0, enemy.getHealth());
        assertEquals(player.getMaxHealth(), player.getHealth());
        assertTrue(combat.exitCalled);
    }

    @Test
    void fightEnemy_playerDies_enemyWins() {
        Player player = new Player("001", "Hero", "pass", 20, 10,0,1);
        Enemy enemy = new Enemy("Knight", 100, 50);

        TestCombat combat = new TestCombat(player);
        combat.FightEnemy(enemy);

        assertEquals(0, player.getHealth());
        assertEquals(90, enemy.getHealth());  // 100 - player's 10 dmg

        assertNull(combat.lastEncountered);
    }

    @Test
    void fightEnemy_bothSurvive_callsEnemyEncounter() {
        Player player = new Player("001", "Hero", "pass", 100, 10,0,1);
        Enemy enemy = new Enemy("Bat", 50, 10);

        TestCombat combat = new TestCombat(player);
        combat.FightEnemy(enemy);

        assertEquals(90, player.getHealth());
        assertEquals(40, enemy.getHealth());

        assertEquals(enemy, combat.lastEncountered);
    }
}