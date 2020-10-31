import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double ticketsPurchase = 0;
        double percentage = 0;
        double currIncome = 0;
        double totalIncome = 0;
        int price;
        int check = -1;
        System.out.println("Enter the number of rows:");
        int numberOfRows = scanner.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int numberOfSeats = scanner.nextInt();

        String[][] cinemaMatrix = new String[numberOfRows + 1][numberOfSeats + 1];

        double[] statistics = new double[] {ticketsPurchase,  percentage,  currIncome,  totalIncome};

        if (numberOfRows * numberOfSeats <= 60) {
            price = 10;
        } else {
            price = 8;
        }
        createTotalIncome(statistics, numberOfRows, numberOfSeats, price);

        createCinema(numberOfRows, numberOfSeats, cinemaMatrix);

        while (check != 0) {
            System.out.println("\n1. Show the seats\n" +
                    "2. Buy a ticket\n" +
                    "3. Statistics\n" +
                    "0. Exit");
            check = scanner.nextInt();
            switch (check){
                case 1:
                    showCinema(cinemaMatrix);
                    break;
                case 2:
                    buyTicket(cinemaMatrix, statistics, scanner, price);
                    break;
                case 3:
                    showStatistics(statistics);
                    break;
                case 0:
                    check = 0;
                    break;
                default:
                    System.out.println("Unknown command");
                    break;
            }
        }
    }

    private static void createTotalIncome(double[] statistics, int numberOfRows, int numberOfSeats, int price) {
        int totalIncome;
        if (price == 10) {
            totalIncome = numberOfRows * numberOfSeats * price;
        } else if (numberOfRows > 4) {
            totalIncome = 4 * 10 * numberOfSeats + (numberOfRows - 4) * numberOfSeats * 8;
        } else {
            totalIncome = numberOfRows * numberOfSeats * 10;
        }
        statistics[3] = totalIncome;
    }

    private static void buyTicket(String[][] cinemaMatrix, double[] statistics, Scanner scanner, int price) {
        boolean check = false;

        while (!check) {
            System.out.print("\n");
            System.out.println("Enter a row number:");
            int rowNumberToBuy = scanner.nextInt();
            System.out.println("Enter a seat number in that row:");
            int seatNumberToBuy = scanner.nextInt();

            price = price == 10? 10 : rowNumberToBuy <= 4 ? 10 : 8;
            statistics[3] = (cinemaMatrix.length - 1) * (cinemaMatrix[0].length - 1) * price;

            if (rowNumberToBuy < cinemaMatrix.length && rowNumberToBuy > 0 &&
                    seatNumberToBuy < cinemaMatrix[0].length && seatNumberToBuy > 0) {
                if (cinemaMatrix[rowNumberToBuy][seatNumberToBuy].equals("B")) {
                    System.out.println("\nThat ticket has already been purchased!");
                } else {
                    cinemaMatrix[rowNumberToBuy][seatNumberToBuy] = "B";
                    System.out.printf("\nTicket price: $%d\n", price);
                    statistics[0]++;
                    statistics[1] = statistics[0] / ((cinemaMatrix.length - 1) * (cinemaMatrix[0].length - 1));
                    statistics[2] += price;
                    check = true;
                }
            } else {
                System.out.println("\nWrong input!");
            }
        }

    }

    private static void showStatistics(double[] statistics) {
        System.out.printf("\nNumber of purchased tickets: %.0f", statistics[0]);
        System.out.printf("\nPercentage: %.2f%%", statistics[1]);
        System.out.printf("\nCurrent income: $%.0f", statistics[2]);
        System.out.printf("\nTotal income: $%.0f\n", statistics[3]);
    }

    private static void createCinema(int numberOfRows, int numberOfSeats, String[][] cinemaMatrix) {
        for (int i = 0; i <= numberOfRows; i++) {
            for (int j = 0; j <= numberOfSeats; j++) {
                if (i == 0 && j == 0) {
                    cinemaMatrix[i][j] = " ";
                } else if (i == 0) {
                    cinemaMatrix[i][j] = String.valueOf(j);
                } else if (j == 0) {
                    cinemaMatrix[i][j] = String.valueOf(i);
                } else {
                    cinemaMatrix[i][j] = "S";
                }
            }
        }
    }

    private static void showCinema(String[][] cinemaMatrix) {
        System.out.println("\nCinema:");
        for (String[] matrix : cinemaMatrix) {
            for (int j = 0; j < cinemaMatrix[0].length; j++) {
                System.out.print(matrix[j] + " ");
            }
            System.out.print("\n");
        }
    }
}