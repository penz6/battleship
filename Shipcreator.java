
//import random to generate random boolean
import java.util.Random;
import java.util.Scanner;

class Shipcreator {
    // the list of variables that make up the aircraft carrier
    boolean horizontal;
    int length;
    String type;
    int xvalue;
    int yvalue;
    String emoji;
    // scanner
    Scanner scan = new Scanner(System.in);
    // creates a new random to use to generate boolean
    Random random = new Random();

    // creates a new ship
    public Shipcreator(String player, String typeinput) {
        type = typeinput;
        // deterimnes what type of ship needs what length
        if (type.equals("Aircraft Carrier")) {
            length = 5;
            // funny escape characters
            emoji = "\u001b[43;1mA\u001b[0m";
        } else if (type.equals("Battleship")) {
            length = 4;
            emoji = "\u001b[42;1mB\u001b[0m";
        } else if (type.equals("Cruiser")) {
            length = 3;
            emoji = "\u001b[44;1mC\u001b[0m";
        } else if (type.equals("Submarine")) {
            length = 3;
            emoji = "\u001b[45;1mS\u001b[0m";
        } else {
            length = 2;
            emoji = "\u001b[46;1mD\u001b[0m";
        }
        System.out.println("\n" + player + "You are placing a " + type + " with a length of " + length
                + " that looks like " + emoji + " .");
        System.out.println(player + "Would you like your ship horizontal? If so enter \"yes\".");
        // asks if horizontal
        if (scan.nextLine().toLowerCase().equals("yes")) {
            horizontal = true;
        } else {
            horizontal = false;
        }
        // Checks x and y values to make sure it works, dependant on horizontal or not
        if (player.equals("🔵")) {
            if (horizontal == true) {
                boolean works = false;
                while (works == false) {
                    System.out.println("Please enter a X value. (ex: \"A\")");
                    xvalue = Checks.convert(scan.nextLine());
                    System.out.println("Please enter a Y value. (ex: \"1\")");
                    yvalue = scan.nextInt() - 1;
                    // clear the scanner(needed for some reason or it skips the input on the next go
                    // around)
                    scan.nextLine();
                    works = Checks.checkEnemyShipPlace(xvalue, yvalue, length, horizontal);
                    if (works == false) {
                        System.out.println("That placement is invalid, please try again.");
                    }
                }
            } else {
                boolean works = false;
                while (works == false) {
                    System.out.println("Please enter a X value. (ex: \"A\")");
                    xvalue = Checks.convert(scan.nextLine());
                    System.out.println("Please enter a Y value. (ex: \"1\")");
                    yvalue = scan.nextInt() - 1;
                    scan.nextLine();
                    works = Checks.checkEnemyShipPlace(xvalue, yvalue, length, horizontal);
                    if (works == false) {
                        System.out.println("That placement is invalid, please try again.");
                    }
                }
            }
        } else {
            if (horizontal == true) {
                boolean works = false;
                while (works == false) {
                    System.out.println("Please enter a X value. (ex: \"A\")");
                    xvalue = Checks.convert(scan.nextLine());
                    System.out.println("Please enter a Y value. (ex: \"1\")");
                    yvalue = scan.nextInt() - 1;
                    scan.nextLine();
                    // System.out.println(xvalue);
                    works = Checks.checkPlayerOneShip(xvalue, yvalue, length, horizontal);
                    // System.out.println("works in shipcreator is "+works);
                    if (works == false) {
                        System.out.println("That placement is invalid, please try again.");
                    }
                }
            } else {
                boolean works = false;
                while (works == false) {
                    System.out.println("Please enter a X value. (ex: \"A\")");
                    xvalue = Checks.convert(scan.nextLine());
                    System.out.println("Please enter a Y value. (ex: \"1\")");
                    yvalue = scan.nextInt() - 1;
                    scan.nextLine();
                    works = Checks.checkPlayerOneShip(xvalue, yvalue, length, horizontal);
                    // System.out.println(works);
                    if (works == false) {
                        System.out.println("That placement is invalid, please try again.");
                    }
                }
            }
        }
    }
}
