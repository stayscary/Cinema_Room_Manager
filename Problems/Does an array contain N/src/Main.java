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
        int number = scanner.nextInt();
        boolean contains = Arrays.stream(array).anyMatch(x -> x == number);
        System.out.println(contains);
    }
}