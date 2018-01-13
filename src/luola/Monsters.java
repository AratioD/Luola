package luola;

import java.util.concurrent.ThreadLocalRandom;

public class Monsters {

    private int x;
    private int y;
    private final int widhtX;
    private final int heightY;

    public Monsters(int x, int y) {

        this.widhtX = x;
        this.heightY = y;

        this.x = ThreadLocalRandom.current().nextInt(0, x + 1);
        this.y = ThreadLocalRandom.current().nextInt(0, y + 1);
    }

    public int monsterX() {
        return this.x;
    }

    public int monsterY() {
        return this.y;
    }

    /*
     public void setMonsterX() {

     }
     */
    public String toString() {
        return "h" + " " + this.x + " " + this.y;
    }

    public void monstersMove(Monsters monster, String playerInputLenght) {
        int direction = ThreadLocalRandom.current().nextInt(0, 3 + 1);

        // Goes up
        if (direction == 0) {
            for (int i = 0; i < playerInputLenght.length(); i++) {
                moveUp();
            }
        }

        // Goes right
        if (direction == 1) {
            for (int i = 0; i < playerInputLenght.length(); i++) {
                moveRight();
            }
        }

        // Goes down
        if (direction == 2) {
            for (int i = 0; i < playerInputLenght.length(); i++) {
                moveDown();
            }
        }

        // Goes left
        if (direction == 3) {
            for (int i = 0; i < playerInputLenght.length(); i++) {
                moveLeft();
            }
        }
    }

    public void moveUp() {
        if (this.y > 0) {
            this.y--;
        }
    }

    public void moveDown() {
        if (this.y < this.heightY) {
            this.y++;
        }
    }

    public void moveRight() {
        if (this.x < this.widhtX) {
            this.x++;
        }
    }

    public void moveLeft() {
        if (0 < this.x) {
            this.x--;
        }
    }

}
/*
 public void moveUp() {
        if (this.y > 0) {
            this.y--;
        }
    }

    public void moveDown() {
        if (this.y < this.heightY) {
            this.y++;
        }
    }

    public void moveRight() {
        if (this.x <this.widhtX) {
            this.x++;
        }
    }

    public void moveLeft() {
        if (this.x > 0) {
            this.x--;
        }
    }
*/