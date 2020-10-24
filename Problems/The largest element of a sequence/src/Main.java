import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int min;
        int max = scanner.nextInt();
        while (scanner.hasNext()) {
            min = scanner.nextInt();
            if (min == 0) {
                break;
            } else {
                max = Math.max(min, max);
            }
        }
        System.out.print(max);
    }
}