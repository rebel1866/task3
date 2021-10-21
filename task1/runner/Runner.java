package by.epamtc.stanislavmelnikov.task1.runner;

import by.epamtc.stanislavmelnikov.shared.input.DataScanner;
import by.epamtc.stanislavmelnikov.task1.logic.ArrayLogic;
import by.epamtc.stanislavmelnikov.shared.output.ConsoleOutput;

import java.util.List;

public class Runner {
    private static ConsoleOutput consoleOutput = new ConsoleOutput();
    private static ArrayLogic arrayLogic = new ArrayLogic();
    private static DataScanner dataScanner = new DataScanner(consoleOutput);

    public static void main(String[] args) {
        runSortingMethods();
        runSearchingMethods();
        runArithmeticsMethods();
    }

    public static int[] runInputMethodConsole() {
        consoleOutput.printMessage("Input numbers: ");
        int[] array = dataScanner.inputInt();
        return array;
    }

    public static int[] runInputFile() {
        int[] array = dataScanner.extractNumbersFromFile("D://test.txt");
        return array;
    }

    public static int[] runInputRandom() {
        consoleOutput.printMessage("Введите длину массива, а также максимальное и минимальное допустимое значение: ");
        int[] params = dataScanner.inputInt();
        int[] array = dataScanner.generateRandomArray(params[0], params[1], params[2]);
        return array;
    }

    public static void runSortingMethods() {
        int[] array = runInputMethodConsole();
        consoleOutput.printMessage("Sorting bubble: ");
        arrayLogic.sortBubble(array);
        consoleOutput.printNumbers(array);
        consoleOutput.printMessage("Sorting by selections: ");
        int[] array1 = runInputMethodConsole();
        arrayLogic.sortBySelections(array1);
        consoleOutput.printNumbers(array1);
        int[] array2 = runInputMethodConsole();
        consoleOutput.printMessage("Sorting by Shell method: ");
        arrayLogic.sortShellMethod(array2);
        consoleOutput.printNumbers(array2);
    }

    public static void runSearchingMethods() {
        int[] array = runInputMethodConsole();
        arrayLogic.sortBubble(array);
        consoleOutput.printMessage("Enter number to search: ");
        int numberToSearch = dataScanner.inputInt()[0];
        int searchResult = arrayLogic.searchBinary(array, numberToSearch);
        consoleOutput.printMessage("Search result (index of number): ");
        consoleOutput.printNumbers(searchResult);
        consoleOutput.printMessage("Max value: ");
        int max = arrayLogic.findMax(array);
        consoleOutput.printNumbers(max);
        consoleOutput.printMessage("Min value: ");
        int min = arrayLogic.findMin(array);
        consoleOutput.printNumbers(min);
    }

    public static void runArithmeticsMethods() {
        int[] array = runInputMethodConsole();
        arrayLogic.sortBubble(array);
        consoleOutput.printMessage("All simple numbers in array: ");
        List<Integer> simpleNumbers = arrayLogic.calculateSimpleNumbers(array);
        consoleOutput.printNumbers(simpleNumbers);
        consoleOutput.printMessage("All fibonacci numbers: ");
        int maxFibonacciLimit = 10000;
        List<Integer> fibonacciNumbers = arrayLogic.findFibonacciInArray(array, maxFibonacciLimit);
        consoleOutput.printNumbers(fibonacciNumbers);
        consoleOutput.printMessage("All 3-digit numbers with unique symbols: ");
        int digits = 3;
        List<Integer> threeDigitNumbers = arrayLogic.findNumbersWithXDigits(array, digits);
        List<Integer> threeDigitUnique = arrayLogic.findNumbersWithUniqueDigits(threeDigitNumbers);
        consoleOutput.printNumbers(threeDigitUnique);
    }
}
