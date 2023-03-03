class Checks {
    // checks if the enemy ship is valid placement
    public static boolean checkEnemyShipPlace(int x, int y, int length, boolean horizontal) {
        // old variables that I am afraid to delete because it is finally working
        int xvalue = x;
        int yvalue = y;
        if (horizontal == true) {
            for (int i = 0; i < length; i++) {
                if (mathCheck(x, y, horizontal, length) == false) {
                    return false;
                } else if (!(Boards.returnEnemyBoard(y, x).equals("🌊"))) {
                    return false;
                }
                x += 1;
            }
            return true;
        } else {
            for (int i = 0; i < length; i++) {
                if (mathCheck(x, y, horizontal, length) == false) {
                    // System.out.println("math check failed, printing x,y" +x+y);
                    // System.out.println("math check fail");
                    return false;
                } else if (!(Boards.returnEnemyBoard(y, x).equals("🌊"))) {
                    // System.out.println(Boards.returnEnemyBoard(yvalue,x));
                    // System.out.println("wave check failed");
                    return false;
                }
                y += 1;
            }
            return true;
        }
    }

    // checks if player one placement is valid
    public static boolean checkPlayerOneShip(int x, int y, int length, boolean horizontal) {
        if (horizontal == true) {
            // System.out.println("x is "+xvalue);
            for (int i = 0; i < length; i++) {
                // System.out.println("x is " + x);
                if (mathCheck(x, y, horizontal, length) == false) {
                    // System.out.println("failed xy check");
                    // System.out.println("x is "+xvalue);
                    return false;
                } else if (!(Boards.returnPlayerOne(y, x).equals("🌊"))) {
                    return false;
                }
                x += 1;
            }
            return true;
        } else {
            for (int i = 0; i < length; i++) {
                // System.out.println(Boards.returnPlayerOne(x,y));
                // System.out.println("x is" + x);
                // System.out.println("y is"+y);
                // System.out.println("i is"+i);
                // System.out.println(emoji);
                if (mathCheck(x, y, horizontal, length) == false) {
                    // System.out.println("math check fail");
                    return false;
                } else if (!(Boards.returnPlayerOne(y, x).equals("🌊"))) {
                    // System.out.println(x+Boards.returnPlayerOne(y,x));
                    // System.out.println("wave check fail with current emoji " + emoji);
                    return false;
                }
                y += 1;
            }
            return true;
        }
    }

    // translate letter to integer value for plotting
    public static int convert(String letter) {
        if (letter.toLowerCase().equals("a")) {
            return 0;
        } else if (letter.toLowerCase().equals("b")) {
            return 1;
        } else if (letter.toLowerCase().equals("c")) {
            return 2;
        } else if (letter.toLowerCase().equals("d")) {
            return 3;
        } else if (letter.toLowerCase().equals("e")) {
            return 4;
        } else if (letter.toLowerCase().equals("f")) {
            return 5;
        } else if (letter.toLowerCase().equals("g")) {
            return 6;
        } else if (letter.toLowerCase().equals("h")) {
            return 7;
        } else if (letter.toLowerCase().equals("i")) {
            return 8;
        } else if (letter.toLowerCase().equals("j")) {
            return 9;
        } else {
            return -1;
        }

    }

    public static boolean winner(String player) {
        String[][] board;
        if (player.equals("🔵")) {
            board = Boards.boardplayer;
        } else {
            board = Boards.boardenemy;
        }
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (!(board[r][c].equals("🌊"))) {
                    return false;
                }
            }
        }
        return true;
    }

    // does some calculations to see if its inside the board and to hopefully not
    // crash
    public static boolean mathCheck(int x, int y, boolean horizontal, int length) {
        // horizontal boolean left over from when method was different, and chaning it
        // would break everything, aswell as length
        if (x > 9 || x < 0 || y > 9 || y < 0) {
            // if(x>9-length){
            // System.out.println("x is" + x);
            // System.out.println("it has to be less than"+(9-length));
            // }
            // System.out.println("x is " + x);
            // System.out.println("y is "+y);
            return false;
        }
        return true;
    }
}