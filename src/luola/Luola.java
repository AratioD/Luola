package luola;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Luola {

    private final int leveys;
    private final int korkeus;
    private final int hirvioita;
    private int siirtoja;
    private boolean hirviotLiikkuvat;

    public Luola(int leveys, int korkeus, int hirvioita, int siirtoja, boolean hirviotLiikkuvat) {
        this.leveys = leveys;
        this.korkeus = korkeus;
        this.hirvioita = hirvioita;
        this.siirtoja = siirtoja;
        this.hirviotLiikkuvat = hirviotLiikkuvat;

    }

    public void run(Scanner lukija) {
        // Creates a new player object
        Player player = new Player(leveys, korkeus);
        // List of monsters
        List<Monsters> monsters = new ArrayList<>();

        // Lets create needed amount of monster objects.
        for (int i = 0; i < hirvioita; i++) {
            monsters.add(new Monsters(leveys, korkeus));
        }
        // Creates list for player moves
        List<String> moves = new ArrayList<>();

        // Creates a new gameboard object.
        Gameboard gameboard = new Gameboard(leveys, leveys);

        while (true) {

            // Moves left during the gameplay
            System.out.println(this.siirtoja);
            System.out.println("");

            // Player coordinates and monsters coordinate roster.
            System.out.println(player);
            monsters.forEach(a -> System.out.println(a));

            // Prints gameboard
            System.out.println("");
            gameboard.printGameboard(monsters, player);
            System.out.println("");

            String input = lukija.nextLine();
            player.controlStick(input);

            for (Monsters monster : monsters) {
                monster.monstersMove(monster, input);
            }

            // Reduces one gaming round
            if (this.siirtoja == 1) {
                System.out.println("HÄVISIT");
                this.hirviotLiikkuvat = false;
               // break;
            } else {
                this.siirtoja--;
            }

            if (monsters.size() == 0) {
                System.out.println("VOITIT");
                this.hirviotLiikkuvat = false;
             //   break;
            }
        }
    }
}
