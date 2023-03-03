public class Hitdetection {
    // checks if a hit is well.... a hit and modifies the boards
    public static String hit(int x, int y, String player) {
        // System.out.println(x);
        // System.out.println(y);
        // System.out.println("made it past the math check");
        if (player.equals("🔴")) {
            if (!(Boards.returnPlayerOne(y, x).equals("🌊"))) {
                // System.out.println("Counted as a hit");
                String returner = Boards.returnPlayerOne(y, x);
                Boards.setEnemyBoardHit(x, y);
                System.out.println("Hit!");
                sunk(returner, player);
                return returner;
            } else {
                // System.out.println("Counted as a miss");
                System.out.println("Miss.");
                Boards.setEnemyBoardMiss(x, y);
                return "no";
            }
        } else {
            if (!(Boards.returnEnemyBoard(y, x).equals("🌊"))) {
                String returner = Boards.returnEnemyBoard(y, x);
                // System.out.println("Counted as a hit");
                Boards.setPlayerBoardHit(x, y);
                System.out.println("Hit!");
                sunk(returner, player);
                return returner;
            } else {
                System.out.println("Miss.");
                // System.out.println("Counted as a miss");
                Boards.setPlayerBoardMiss(x, y);
                return "no";
            }

        }
    }

    // checks if said hit sinks ship
    public static boolean sunk(String icon, String player) {
        String[][] board;
        if (player.equals("🔵")) {
            board = Boards.boardplayer;
        } else {
            board = Boards.boardenemy;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c].equals(icon)) {
                    System.out.println("Still afloat.");
                    return false;
                }
            }
        }
        System.out.println("Sunk!");
        return true;
    }

}
