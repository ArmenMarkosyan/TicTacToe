public class TicTacToe {

    private int count = 0;               //Iteration counter
    private int verticalSize;            //Vertical size of the board
    private int horizontalSize;          //Horizontal size of the board
    private int selectedRow;             //The row of the last selected cell
    private int selectedColumn;          //The column of the last selected cell
    private int winLineLength;           //The length of the winning criteria
    private char sign;                   //The symbol (X or O) of the last selected cell

    public TicTacToe() {
        System.out.println("\n*****TicTacToe*****\n");

        Board game = new Board();
        verticalSize = game.getBoardRow();
        horizontalSize = game.getBoardColumn();

        System.out.println("Setting the length as the winning criteria.");

        do {
            System.out.println("Number should not be bigger than sizes of the board: " +
                    verticalSize + " and " + horizontalSize);
            winLineLength = ConsoleReader.getLength();
        } while (winLineLength > verticalSize || winLineLength > horizontalSize);

        System.out.println("\nThe length of a winning line is: " + winLineLength);

        System.out.println("\nThe game is started. Players are required to choose a cell as NxM\n" +
                "\trange of N is [0," + (verticalSize - 1) + "]\n" +
                "\trange of M is [0," + (horizontalSize - 1) + "]\n" +
                "The players are given names X and O.\nGood Luck!\n");

        //Check the outcome of the players' roll
        while (!roll(game, 'X') && !roll(game, 'O')) ;

        System.out.println("The number of iterations are " + count + "\n");

        System.out.println("Game is over!");
    }

    private boolean roll(Board play, char player) {

        count++;

        System.out.println("Player \"" + player + "\", it's your turn.");

        //Select a free cell to play
        play.chooseCell(player);

        selectedRow = play.getSelectedRow();
        selectedColumn = play.getSelectedColumn();

        sign = play.getCell(selectedRow, selectedColumn);

        if (checkWin(play)) {
            System.out.println("Player \"" + player + "\" wins!\n");
            return true;
        }
        return false;
    }

    private boolean checkWin(Board game) {
        return (vertical(game) || horizontal(game) || diagonal(game) || backDiagonal(game));
    }

    //Check the winning condition for vertical line
    private boolean vertical(Board g) {
        int winCount = 1;
        int i;

        i = 1;
        while (selectedRow + i < verticalSize && g.getCell(selectedRow + i, selectedColumn) == sign) {
            winCount++;
            i++;
        }

        i = 1;
        while (selectedRow - i >= 0 && g.getCell(selectedRow - i, selectedColumn) == sign) {
            winCount++;
            i++;
        }

        return winCount >= winLineLength;
    }

    //Check the winning condition for horizontal line
    private boolean horizontal(Board g) {
        int winCount = 1;
        int i;

        i = 1;
        while (selectedColumn + i < horizontalSize && g.getCell(selectedRow, selectedColumn + i) == sign) {
            winCount++;
            i++;
        }

        i = 1;
        while (selectedColumn - i >= 0 && g.getCell(selectedRow, selectedColumn - i) == sign) {
            winCount++;
            i++;
        }

        return winCount >= winLineLength;
    }

    //Check the winning condition for diagonal line
    private boolean diagonal(Board g) {
        int winCount = 1;
        int i;

        i = 1;
        while (selectedRow + i < verticalSize && selectedColumn + i < horizontalSize && g.getCell(selectedRow + i, selectedColumn + i) == sign) {
            winCount++;
            i++;
        }

        i = 1;
        while (selectedRow - i >= 0 && selectedColumn - i >= 0 && g.getCell(selectedRow - i, selectedColumn - i) == sign) {
            winCount++;
            i++;
        }

        return winCount >= winLineLength;
    }

    //Check the winning condition for back diagonal line
    private boolean backDiagonal(Board g) {
        int winCount = 1;
        int i;

        i = 1;
        while (selectedRow - i >= 0 && selectedColumn + i < horizontalSize && g.getCell(selectedRow - i, selectedColumn + i) == sign) {
            winCount++;
            i++;
        }

        i = 1;
        while (selectedRow + i < verticalSize && selectedColumn - i >= 0 && g.getCell(selectedRow + i, selectedColumn - i) == sign) {
            winCount++;
            i++;
        }

        return winCount >= winLineLength;
    }
}
