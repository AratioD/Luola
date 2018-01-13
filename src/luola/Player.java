package luola;

public class Player {

    private int x;
    private int y;
    private final int widhtX;
    private final int heightY;

    public Player(int x, int y) {
        this.widhtX = x;
        this.heightY = y;
        this.x = 0;
        this.y = 0;

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
        if (this.x <this.widhtX) {
            this.x++;
        }
    }

    public void moveLeft() {
        if (this.x > 0) {
            this.x--;
        }
    }

    public void controlStick(String input) {

        for (int i = 0; i < input.length(); i++) {
            char keyLetter = input.charAt(i);

            if (keyLetter == 'w') {
                moveUp();
            }

            if (keyLetter == 'd') {
                moveRight();
            }

            if (keyLetter == 'a') {
                moveLeft();
            }

            if (keyLetter == 's') {
                moveDown();
            }

        }

    }

    public int playerX() {
        return this.x;
    }

    public int playerY() {
        return this.y;
    }

    public String toString() {
        return "@" + " " + this.x + " " + this.y;
    }

}
