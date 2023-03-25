import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // ввод двух чисел через пробел - размер шахматной доски
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int k = Integer.parseInt(input[1]);
        scanner.close();

        // создание матрицы (массива) шахматной доски
        int[][] matrix = new int[n][n];

        int numberOfCells = n*n; // общее количество клеток

        // проверка дополнительного условия
        boolean various = true;
        if ((k == 1 && n > 1)||k == 0 || k > 10) various = false;

        if ((numberOfCells % k == 0) && various) { // условие баланса цветов
            // инициализация матрицы
            int c = 0;
            int count = 0;
            for (int i = 0; i < matrix.length; i++) {
                if (count >= k) {
                    count = 0;
                }
                count++;
                c = count;
                for (int j = 0; j < matrix[i].length; j++) {
                    if (c > k) {
                        c = 1;
                    }
                    matrix[i][j] = c;
                    c++;
                }
            }
            // вывод на консоль
            System.out.println("Yes");
            for (int[] ints : matrix) {
                for (int anInt : ints) {
                    System.out.print(anInt + " ");
                }
                System.out.println();
            }
        } else {
            System.out.println("No");
        }
    }
}
