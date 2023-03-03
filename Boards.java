
class Boards {
    static String[][] boardenemy = new String[10][10];
    static String[][] boardplayer = new String[10][10];
    static String[][] boardenemyhidden = new String[10][10];
    static String[][] boardplayerhidden = new String[10][10];
    static String letters = "\t" + "A" + "\t" + "B" + "\t" + "C" + "\t" + "D" + "\t" + "E" + "\t" + "F" + "\t" + "G"
            + "\t" + "H" + "\t" + "I" + "\t" + "J";

    // fills the boards with water
    public static void fillBoards() {
        for (int r = 0; r < boardenemy.length; r++) {
            for (int c = 0; c < boardenemy[0].length; c++) {
                boardenemy[r][c] = "🌊";
            }
        }
        for (int r = 0; r < boardplayer.length; r++) {
            for (int c = 0; c < boardplayer[0].length; c++) {
                boardplayer[r][c] = "🌊";
            }
        }
        for (int r = 0; r < boardplayerhidden.length; r++) {
            for (int c = 0; c < boardplayer[0].length; c++) {
                boardplayerhidden[r][c] = "🌊";
            }
        }
        for (int r = 0; r < boardenemyhidden.length; r++) {
            for (int c = 0; c < boardenemyhidden[0].length; c++) {
                boardenemyhidden[r][c] = "🌊";
            }
        }
    }

    // print the players board
    public static void playerBoard() {
        // creates the boards, one for the enemy and one for the player
        // array to go through the letters
        // String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
        System.out.println(letters);
        for (int r = 0; r < boardplayer[0].length; r++) {
            System.out.print("\n\n" + (r + 1) + "\t");
            for (int c = 0; c < boardplayer.length; c++) {
                System.out.print(boardplayer[r][c] + "\t");
            }
        }
    }

    // print the enemys board
    public static void enemyBoard() {
        // creates the boards, one for the enemy and one for the player
        // array to go through the letters
        // String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
        System.out.println(letters);
        for (int r = 0; r < boardenemy[0].length; r++) {
            System.out.print("\n\n" + (r + 1) + "\t");
            for (int c = 0; c < boardenemy.length; c++) {
                System.out.print(boardenemy[r][c] + "\t");
            }
        }
    }

    // print the enemys board hidden
    public static void enemyBoardHidden() {
        // creates the boards, one for the enemy and one for the player
        // array to go through the letters
        // String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
        System.out.println(letters);
        for (int r = 0; r < boardenemyhidden[0].length; r++) {
            System.out.print("\n\n" + (r + 1) + "\t");
            for (int c = 0; c < boardenemyhidden.length; c++) {
                System.out.print(boardenemyhidden[r][c] + "\t");
            }
        }
    }

    // print the player board hidden
    public static void playerBoardHidden() {
        // creates the boards, one for the enemy and one for the player
        // array to go through the letters
        // String[] letters = {"A","B","C","D","E","F","G","H","I","J"};
        System.out.println(letters);
        for (int r = 0; r < boardplayerhidden[0].length; r++) {
            System.out.print("\n\n" + (r + 1) + "\t");
            for (int c = 0; c < boardplayerhidden.length; c++) {
                System.out.print(boardplayerhidden[r][c] + "\t");
            }
        }
    }

    // place a ship on the board
    public static void placeShip(Shipcreator a, String player) {
        int xtemp = a.xvalue;
        int ytemp = a.yvalue;
        if (player.equals("🔴")) {
            if (a.horizontal == true) {
                for (int i = 0; i < a.length; i++) {
                    boardplayer[a.yvalue][xtemp] = a.emoji;
                    xtemp += 1;
                }
            } else {
                for (int i = 0; i < a.length; i++) {
                    boardplayer[ytemp][a.xvalue] = a.emoji;
                    ytemp += 1;
                }
            }
        } else {
            if (a.horizontal == true) {
                for (int i = 0; i < a.length; i++) {
                    boardenemy[a.yvalue][xtemp] = a.emoji;
                    xtemp += 1;
                }
            } else {
                for (int i = 0; i < a.length; i++) {
                    boardenemy[ytemp][a.xvalue] = a.emoji;
                    ytemp += 1;
                }
            }
        }
    }

    // returns a spot on the enemy board
    public static String returnEnemyBoard(int row, int column) {
        return boardenemy[row][column];
    }

    // returns spot on player board
    public static String returnPlayerOne(int row, int column) {
        return boardplayer[row][column];
    }

    // set board for enemy hit
    public static void setEnemyBoardHit(int x, int y) {
        boardenemy[y][x] = "💥";
        boardenemyhidden[y][x] = "💥";
    }

    // set enemy board miss
    public static void setEnemyBoardMiss(int x, int y) {
        boardenemy[y][x] = "❌";
        boardenemyhidden[y][x] = "❌";
    }

    // set board for player
    public static void setPlayerBoardHit(int x, int y) {
        boardplayer[y][x] = "💥";
        boardplayerhidden[y][x] = "💥";
    }

    public static void setPlayerBoardMiss(int x, int y) {
        boardplayer[y][x] = "❌";
        boardplayerhidden[y][x] = "❌";
    }
}
