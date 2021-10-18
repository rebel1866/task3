package by.epamtc.stanislavmelnikov.shared.output;

import java.util.List;

public class ConsoleOutput {
    private final String space = " ";

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printNumbers(int... array) {
        for (int number : array) {
            System.out.print(number + space);
        }
        System.out.println();
    }

    public void printNumbers(List<Integer> numbers) {
        for (int number : numbers) {
            System.out.print(number + space);
        }
        System.out.println();
    }

    public void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void printDataRequestMessage() {
        System.out.println("Input data: ");
    }

    public void printWrongInputMessage() {
        System.out.println("You've entered wrong data. Try again.");
    }

    public void printFileNotFoundMessage() {
        System.out.println("File not found.");
    }

    public void printIOErrorMessage() {
        System.out.println("Input/Output error.");
    }
}
