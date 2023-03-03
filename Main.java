import java.util.Scanner;
import java.util.concurrent.TimeUnit;

class Main {
    // catch interuppted exepton because of sleep when clearing the board
    public static void main(String[] args) throws InterruptedException {
        // scanner
        Scanner scan = new Scanner(System.in);
        // setting the variable to run the loop to play
        boolean intenttoplay = true;
        while (intenttoplay == true) {
            // welcome message and rules
            System.out.println(
                    "Welcome to battleship V1.0!\nThe aim of the game is simple. Destroy the enemys ship by guessing where they are on the \"board\".");
            // MUST FILL BOARDS BEFORE PLACING SHIPS DUE TO CHECKS
            Boards.fillBoards();
            // more instructions blahblahblah
            System.out.println(
                    "We are going to play two player.\nPlayer one will see 🔴 before the lines intended for them.\nPlayer two will see 🔵.");
            // prints the starter board
            Print.Start("🔴");
            // clears the console and swaps players
            Print.clear("🔵");
            // prints the starer board for other player
            Print.Start("🔵");
            Print.clear("🔴");
            // now onto the game maybe working
            boolean winner = false;
            // sets the current player, we last switched to red
            String currentplayer = "🔴";
            int x;
            int y;
            while (winner == false) {
                System.out.println("Your board looks like:");
                // returns the board for the persion viewing
                if (currentplayer.equals("🔴")) {
                    Boards.playerBoard();
                    // sleep
                    TimeUnit.SECONDS.sleep(2);
                    // Shows enemy board
                    System.out.println(
                            "\nHere is the enemys board, and where you have hit:💥 and where you have missed:❌");
                    Boards.enemyBoardHidden();
                } else {
                    Boards.enemyBoard();
                    // sleep
                    TimeUnit.SECONDS.sleep(2);
                    // shows enemy board
                    System.out.println(
                            "\nHere is the enemys board, and where you have hit:💥 and where you have missed:❌");
                    Boards.playerBoardHidden();
                }
                // guessing place
                System.out.println("\n" + currentplayer + "Where would you like to guess?");
                System.out.println(currentplayer + "Enter an X value.");
                String xtemp = scan.nextLine();
                x = Checks.convert(xtemp);
                System.out.println(currentplayer + "Enter an Y value.");
                y = scan.nextInt() - 1;
                scan.nextLine();
                // if invalid you loose a turn, haha
                // feeds match check random boolean and int at the end, not needed
                if (Checks.mathCheck(x, y, false, 1) == true) {
                    // runs hit detection and gets icon of ship that was hit
                    String icon = Hitdetection.hit(x, y, currentplayer);
                    // if not a hit dont bother running winner
                    if (!(icon.equals("no"))) {
                        winner = Checks.winner(currentplayer);
                        // is winner?
                        if (winner == true) {
                            System.out.print(currentplayer + " has won!");
                        }
                    }
                } else {
                    System.out.println(currentplayer + "haha you missed a turn");
                }

                // if winner just stop
                if (winner == true) {
                    break;
                }
                // swaps player
                if (currentplayer.equals("🔴")) {
                    currentplayer = "🔵";
                    Print.clear("🔵");
                } else {
                    currentplayer = "🔴";
                    Print.clear("🔴");
                }

            }
            // play again check
            System.out.println(
                    "Congradulations " + currentplayer + ", would you both like to play again? To do so enter \"yes\"");
            if ((!scan.nextLine().toLowerCase().equals("yes"))) {
                intenttoplay = false;
            }
        }
    }
}