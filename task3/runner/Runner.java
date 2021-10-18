package by.epamtc.stanislavmelnikov.task3.runner;

import by.epamtc.stanislavmelnikov.shared.input.DataScanner;
import by.epamtc.stanislavmelnikov.shared.output.ConsoleOutput;
import by.epamtc.stanislavmelnikov.task3.logic.TextProcessor;

public class Runner {
    private static ConsoleOutput consoleOutput = new ConsoleOutput();
    private static DataScanner dataScanner = new DataScanner(consoleOutput);
    private static TextProcessor textProcessor = new TextProcessor();

    public static void main(String[] args) {
        String input = runInput();
        runReplaceByIndex(input);
        runReplaceByPattern(input);
        runReplaceByLength(input);
        runRemoveNonLetters(input);
        runRemoveConsonantLength(input);
    }

    public static String runInput() {
        consoleOutput.printDataRequestMessage();
        String input = dataScanner.inputString();
        return input;
    }

    public static void runReplaceByIndex(String input) {
        consoleOutput.printMessage("Введите номер буквы, которую необходимо заменить: ");
        int index = dataScanner.inputInt()[0];
        consoleOutput.printMessage("Введите один или несколько символов замены: ");
        String replacement = dataScanner.inputString();
        String textReplacedByIndex = textProcessor.replaceByIndex(input, index, replacement);
        consoleOutput.printMessage("В тексте заменен " + index + "-й символ каждого слова: ");
        consoleOutput.printMessage(textReplacedByIndex);
    }

    public static void runReplaceByPattern(String input) {
        consoleOutput.printMessage("Укажите паттерн для замены: ");
        String pattern = dataScanner.inputString();
        consoleOutput.printMessage("Введите один или несколько символов замены: ");
        String replacement = dataScanner.inputString();
        String result = textProcessor.replaceByPattern(input, pattern, replacement);
        String result1 = textProcessor.replaceByPatternRegex(input, pattern, replacement);
        consoleOutput.printMessage("В указанном тексте паттерн \"" + pattern + "\" заменен на \"" + replacement + "\"");
        consoleOutput.printMessage(result);
        consoleOutput.printMessage(result1);
    }

    public static void runReplaceByLength(String input) {
        consoleOutput.printMessage("Введите длину слов, которые будут заменены: ");
        int length = dataScanner.inputInt()[0];
        consoleOutput.printMessage("Введите символы замены: ");
        String replacement = dataScanner.inputString();
        String result = textProcessor.replaceByLength(input, length, replacement);
        String result1 = textProcessor.replaceByLengthRegex(input, length, replacement);
        consoleOutput.printMessage(result);
        consoleOutput.printMessage(result1);
    }

    public static void runRemoveNonLetters(String input) {
        String result = textProcessor.removeNonLetters(input);
        String result1 = textProcessor.removeNonLettersRegex(input);
        consoleOutput.printMessage("В тексте удалены все символы, не являющиеся буквой или пробелом: ");
        consoleOutput.printMessage(result);
        consoleOutput.printMessage(result1);
    }

    public static void runRemoveConsonantLength(String input) {
        consoleOutput.printMessage("Введите длину слова для замены: ");
        int length = dataScanner.inputInt()[0];
        String result = textProcessor.removeConsonantLength(input, length);
        consoleOutput.printMessage(result);
    }
}
