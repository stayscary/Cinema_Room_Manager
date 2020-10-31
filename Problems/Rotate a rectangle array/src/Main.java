import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = scanner.nextInt();
            }
        }
        int[][] rotatedMatrix = rotateMatrixBy90Degree(matrix);
        for (int[] ints : rotatedMatrix) {
            for (int j = 0; j < rotatedMatrix[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] rotateMatrixBy90Degree(int[][] matrix) {
        int rowsOfRotatedMatrix = matrix[0].length;
        int colsOfRotatedMatrix = matrix.length;
        int[][] rotatedMatrix = new int[rowsOfRotatedMatrix][colsOfRotatedMatrix];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                rotatedMatrix[j][(colsOfRotatedMatrix - 1) - i] = matrix[i][j];
            }
        }
        return rotatedMatrix;
    }
}