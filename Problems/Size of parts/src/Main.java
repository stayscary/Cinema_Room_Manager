import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }
        long perfectCount = Arrays.stream(array).filter(x -> x == 0).count();
        long smallerCount = Arrays.stream(array).filter(x -> x == -1).count();
        long largerCount = Arrays.stream(array).filter(x -> x == 1).count();
        System.out.println(perfectCount + " " + largerCount + " " + smallerCount);
    }
}