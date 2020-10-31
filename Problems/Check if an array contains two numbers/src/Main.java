import java.util.Arrays;
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
        boolean hasN = Arrays.stream(array).anyMatch(x -> x == n);
        boolean hasM = Arrays.stream(array).anyMatch(x -> x == m);
        if (hasM && hasN) {
            int posN = 0;
            int posM = 0;
            for (int i = 0; i < count; i++) {
                if (array[i] == n) {
                    posN = i;
                } else if (array[i] == m) {
                    posM = i;
                }
            }
            System.out.println(Math.abs(posM - posN) == 1);
        } else {
            System.out.println(false);
        }
    }
}