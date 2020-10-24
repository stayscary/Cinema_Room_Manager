import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Cinema:\n");
        for (int i = 0; i < 8; i ++) {
            for (int j = 0; j < 9; j ++) {
                if (i == 0 && j == 0) {
                    System.out.print("  ");
                } else if (i == 0) {
                    System.out.print(j + " ");
                } else if (j == 0) {
                    System.out.print(i + " ");
                } else {
                    System.out.print("S" + " ");
                }
            }
            System.out.print("\n");
        }

        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();

        if (rows * numberOfSeats <= 60) {
            System.out.println("Total income:\n$" + (rows * numberOfSeats * 10));
        } else {
            if (rows % 2 == 0) {
                System.out.println("Total income:\n$" +
                        (rows/2 * numberOfSeats * 10 + rows/2 * numberOfSeats * 8));
            } else {
                System.out.println("Total income:\n$" +
                        (rows/2 * numberOfSeats * 10 + (rows/2 + 1) * numberOfSeats * 8));
            }
        }
    }
}