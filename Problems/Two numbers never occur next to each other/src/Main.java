import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] array = new int[count];
        for (int i = 0; i < count; i++) {
            array[i] = scanner.nextInt();
        }
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        for (int i = 0; i < count - 1; i++) {
            if (array[i] == n && array[i + 1] == m) {
                System.out.println(false);
                return;
            }
            if (array[i] == m && array[i + 1] == n) {
                System.out.println(false);
                return;
            }
        }
        System.out.println(true);
    }
}