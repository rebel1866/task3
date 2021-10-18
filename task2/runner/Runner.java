package by.epamtc.stanislavmelnikov.task2.runner;

import by.epamtc.stanislavmelnikov.shared.input.DataScanner;
import by.epamtc.stanislavmelnikov.shared.output.ConsoleOutput;
import by.epamtc.stanislavmelnikov.task2.entity.LimitValue;
import by.epamtc.stanislavmelnikov.task2.entity.SortingDirection;
import by.epamtc.stanislavmelnikov.task2.logic.JaggedArrayProcessor;

import java.util.function.Function;


public class Runner {
    public static void main(String[] args) {
        ConsoleOutput consoleOutput = new ConsoleOutput();
        DataScanner dataScanner = new DataScanner(consoleOutput);
        JaggedArrayProcessor arrayProcessor = new JaggedArrayProcessor();
        Function<int[], Integer> functionSumElements = x -> arrayProcessor.countSumElements(x);
        Function<int[], Integer> functionMaxElements = x -> arrayProcessor.findStringLimitValue(x, LimitValue.MAX);
        Function<int[], Integer> functionMinElements = x -> arrayProcessor.findStringLimitValue(x, LimitValue.MIN);

        consoleOutput.printMessage("Введите значения мартицы: ");
        int[][] matrix = dataScanner.inputMatrix();

        int[][] matrixAscendingSum = arrayProcessor.sortArrayStrings(matrix, SortingDirection.ASCENDING, functionSumElements);
        consoleOutput.printMessage("Матрица, строки которой отсортированы по возрастанию сумм элементов строки: ");
        consoleOutput.printMatrix(matrixAscendingSum);
        int[][] matrixDescendingSum = arrayProcessor.sortArrayStrings(matrix, SortingDirection.DESCENDING, functionSumElements);
        consoleOutput.printMessage("Матрица, строки которой отсортированы по убыванию сумм элементов строки: ");
        consoleOutput.printMatrix(matrixDescendingSum);

        int[][] matrixAscendingMax = arrayProcessor.sortArrayStrings(matrix, SortingDirection.ASCENDING, functionMaxElements);
        consoleOutput.printMessage("Матрица, строки которой отсортированы по возрастанию максимальных элементов строки: ");
        consoleOutput.printMatrix(matrixAscendingMax);
        int[][] matrixDescendingMax = arrayProcessor.sortArrayStrings(matrix, SortingDirection.DESCENDING, functionMaxElements);
        consoleOutput.printMessage("Матрица, строки которой отсортированы по убыванию максимальных элементов строки: ");
        consoleOutput.printMatrix(matrixDescendingMax);

        int[][] matrixAscendingMin = arrayProcessor.sortArrayStrings(matrix, SortingDirection.ASCENDING, functionMinElements);
        consoleOutput.printMessage("Матрица, строки которой отсортированы по возрастанию минимальных элементов строки: ");
        consoleOutput.printMatrix(matrixAscendingMin);
        int[][] matrixDescendingMin = arrayProcessor.sortArrayStrings(matrix, SortingDirection.DESCENDING, functionMinElements);
        consoleOutput.printMessage("Матрица, строки которой отсортированы по убыванию минимальных элементов строки: ");
        consoleOutput.printMatrix(matrixDescendingMin);
    }
}
