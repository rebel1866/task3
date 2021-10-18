package by.epamtc.stanislavmelnikov.shared.input;

import by.epamtc.stanislavmelnikov.shared.output.ConsoleOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DataScanner {
    private ConsoleOutput consoleOutput;
    private final String EXIT_COMMAND = "exit";

    public DataScanner(ConsoleOutput consoleOutput) {
        this.consoleOutput = consoleOutput;
    }

    public String inputString() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        return input;
    }

    public int[] inputInt() {
        String input = inputString();
        int[] targetArray;
        try {
            targetArray = parseNumbers(input);
        } catch (NumberFormatException e) {
            consoleOutput.printWrongInputMessage();
            return inputInt();
        }
        return targetArray;
    }


    public int[][] inputMatrix() {
        List<int[]> arrays = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (; ; ) {
            String input = scanner.nextLine();
            if (input.equalsIgnoreCase(EXIT_COMMAND)) break;
            int[] array;
            try {
                array = parseNumbers(input);
            } catch (NumberFormatException e) {
                consoleOutput.printWrongInputMessage();
                continue;
            }
            arrays.add(array);
        }
        int[][] targetArray = new int[arrays.size()][];
        for (int i = 0; i < arrays.size(); i++) {
            targetArray[i] = arrays.get(i);
        }
        return targetArray;
    }

    public int[] parseNumbers(String input) throws NumberFormatException {
        String splitSymbol = " ";
        String[] arrayStrings = input.split(splitSymbol);
        int[] targetArray = new int[arrayStrings.length];
        for (int i = 0; i < arrayStrings.length; i++) {
            targetArray[i] = Integer.parseInt(arrayStrings[i]);
        }
        return targetArray;
    }

    public int[] extractNumbersFromFile(String path) {
        String input = readFile(path);
        int[] numbers = new int[0];
        try {
            numbers = parseNumbers(input);
        } catch (NumberFormatException e) {
            consoleOutput.printWrongInputMessage();
        }
        return numbers;
    }

    public String readFile(String path) {
        StringBuilder input = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(path), "WINDOWS-1251"));
            String line;
            while ((line = in.readLine()) != null) {
                input.append(line);
            }
            in.close();
        } catch (FileNotFoundException e) {
            consoleOutput.printFileNotFoundMessage();
        } catch (IOException e) {
            consoleOutput.printIOErrorMessage();
        }
        return input.toString();
    }

    public int[] generateRandomArray(int length, int minValue, int maxValue) {
        int[] array = new int[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = generateNumber(minValue, maxValue);
        }
        return array;
    }

    public int generateNumber(int min, int max) {
        return (int) (min + Math.random() * (max - min));
    }
}
