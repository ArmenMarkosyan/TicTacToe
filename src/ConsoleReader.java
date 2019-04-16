import java.util.Scanner;

public class ConsoleReader {

    //Reading two integers as NxM from the console
    public static int[] getNM() {
        System.out.print("Required format is NxM: ");
        Scanner scanner = new Scanner(System.in);

        String[] sizeStr;
        int[] sizeNM = {0, 0};

        boolean correctInputFormat;
        do {
            correctInputFormat = true;
            try {
                sizeStr = scanner.nextLine().split("x");
                sizeNM[0] = Integer.parseInt(sizeStr[0]);
                sizeNM[1] = Integer.parseInt(sizeStr[1]);
            } catch (Exception exc) {
                System.out.println("Incorrect format: " + exc + "\n");
                System.out.print("Please use this format: e.g. 3x3 or 6x5: ");
                correctInputFormat = false;
            }
        } while (!correctInputFormat);

        return sizeNM;
    }

    //Read an integer from the console
    public static int getLength() {

        System.out.print("Please input a number: ");
        int length = 0;

        Scanner scanner = new Scanner(System.in);
        boolean correctInputNumber = false;

        while (!correctInputNumber) {
            try {
                length = Integer.parseInt(scanner.nextLine());
                correctInputNumber = true;

            } catch (Exception exc) {
                System.out.println("Incorrect format: " + exc + "\n");
                System.out.print("Please input an integer number: ");
            }
        }

        return length;
    }
}
