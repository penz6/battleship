import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Print {
    // clears the screen to prevent cheating
    public static void clear(String player) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        TimeUnit.SECONDS.sleep(4);
        System.out.print("\033\143");
        System.out.println(
                "We are switching players, player " + player + ", please get infront of the screen and press enter.");
        scan.nextLine();
    }

    // the start of laying ships and such
    public static void Start(String player) {
        System.out.println(player
                + "So, we are going to place your ships. To start off, here is the board that you are working with");
        if (player.equals("🔴")) {
            Boards.playerBoard();
            System.out.println("\n" + player
                    + "So we are going to start placing ships. They are placed starting from the left, or the top,");
            System.out.println(player + "Depending on if you place them horizontally or not.");
            // start placing ships
            Shipcreator aircraft = new Shipcreator(player, "Aircraft Carrier");
            Boards.placeShip(aircraft, player);
            Boards.playerBoard();
            Shipcreator battleship = new Shipcreator(player, "Battleship");
            Boards.placeShip(battleship, player);
            Boards.playerBoard();
            Shipcreator cruiser = new Shipcreator(player, "Cruiser");
            Boards.placeShip(cruiser, player);
            Boards.playerBoard();
            Shipcreator submarine = new Shipcreator(player, "Submarine");
            Boards.placeShip(submarine, player);
            Boards.playerBoard();
            Shipcreator destroyer = new Shipcreator(player, "Destroyer");
            Boards.placeShip(destroyer, player);
            Boards.playerBoard();

        } else {
            Boards.enemyBoard();
            System.out.println("\n" + player
                    + "So we are going to start placing ships. They are placed starting from the left, or the top,");
            System.out.println(player + "Depending on if you place them horizontally or not.");
            // start placing ships
            Shipcreator aircraft = new Shipcreator(player, "Aircraft Carrier");
            Boards.placeShip(aircraft, player);
            Boards.enemyBoard();
            Shipcreator battleship = new Shipcreator(player, "Battleship");
            Boards.placeShip(battleship, player);
            Boards.enemyBoard();
            Shipcreator cruiser = new Shipcreator(player, "Cruiser");
            Boards.placeShip(cruiser, player);
            Boards.enemyBoard();
            Shipcreator submarine = new Shipcreator(player, "Submarine");
            Boards.placeShip(submarine, player);
            Boards.enemyBoard();
            Shipcreator destroyer = new Shipcreator(player, "Destroyer");
            Boards.placeShip(destroyer, player);
            Boards.enemyBoard();
        }
    }
}
