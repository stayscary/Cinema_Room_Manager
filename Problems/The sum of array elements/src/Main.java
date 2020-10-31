import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int counter = scanner.nextInt();
        int[] array = new int[counter];
        for (int i = 0; i < counter; i++) {
            array[i] = scanner.nextInt();
        }
        int answer = 0;
        for (int num: array) {
            answer += num;
        }
        System.out.println(answer);
    }
}