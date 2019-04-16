public class Board {
    private int row;
    private int column;
    private int selectedRow;
    private int selectedColumn;

    private char[][] board;

    public Board() {

        System.out.println("Please enter the board sizes.");
        setBoardSizes(ConsoleReader.getNM());

        System.out.print("\nBoard sizes are: ");
        System.out.println(row + " x " + column);

        resetBoard();
        showBoard();
    }

    public void chooseCell(char sign) {
        char Dummy = '0';
        int[] lastPos;
        do {
            System.out.println("Choose a free cell within the board: ");
            lastPos = ConsoleReader.getNM();
            try {
                Dummy = board[lastPos[0]][lastPos[1]];
            } catch (IndexOutOfBoundsException exc) {
                System.out.println("Choose the coordinates within the board: " + exc + "\n");
            }
        } while (Dummy != ' ');

        selectedRow = lastPos[0];
        selectedColumn = lastPos[1];

        board[selectedRow][selectedColumn] = sign;
        showBoard();
    }

    private void setBoardSizes(int[] rowColumn) {
        row = rowColumn[0];
        column = rowColumn[1];
    }

    private void resetBoard() {
        board = new char[row][column];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private void showBoard() {

        System.out.println();

        for (int i = 0; i < row; i++) {
            System.out.print("|");

            for (int j = 0; j < column; j++)
                System.out.print(String.format(" %s |", board[i][j]));

            System.out.println();
        }
        System.out.println();
    }

    public int getBoardRow() {
        return row;
    }

    public int getBoardColumn() {
        return column;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public int getSelectedColumn() {
        return selectedColumn;
    }

    public char getCell(int r, int c) {
        return board[r][c];
    }

}
