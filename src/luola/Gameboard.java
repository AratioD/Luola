package luola;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {

    private final int x;
    private final int y;

    public Gameboard(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int gameboardX() {
        return this.x;
    }

    public int gameboardY() {
        return this.y;
    }

    public void printGameboard(List<Monsters> monst, Player player) {

        // Before we draw the game situation we check losses and wins.
        playerAndMonsterBattle(player, monst);

        for (int y = 0; y < this.y; y++) {
            for (int x = 0; x < this.x; x++) {

                if (playerPosition(x, y, player)) {
                    System.out.print("@");
                } else if (monsterPositions(x, y, monst)) {
                    System.out.print("h");
                } else {
                    System.out.print(".");
                }
            }
            System.out.println("");
        }
    }

    public boolean monsterPositions(int x, int y, List<Monsters> monst) {

        for (Monsters monst1 : monst) {
            if (x == monst1.monsterX() && y == monst1.monsterY()) {
                return true;
            }
        }
        return false;
    }

    public boolean playerPosition(int x, int y, Player player) {
        if (player.playerX() == x && player.playerY() == y) {
            return true;
        } else {
            return false;
        }
    }

    public List<Monsters> playerAndMonsterBattle(Player player, List<Monsters> monst) {

        int indexMonster = 0;
        boolean check = false;

        for (Monsters monst1 : monst) {

            if (player.playerX() == monst1.monsterX() && player.playerY() == monst1.monsterY()) {
                indexMonster = monst.indexOf(monst1);
                check = true;

            }

        }
        if (check == true) {
            monst.remove(indexMonster);
        }
        return monst;

    }
}
