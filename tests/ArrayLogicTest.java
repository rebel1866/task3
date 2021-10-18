import by.epamtc.stanislavmelnikov.task1.logic.ArrayLogic;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

class ArrayLogicTest {
    private final int[] arrayExpected = {1, 3, 5, 8, 10};
    private final int[] testArray = {5, 8, 10, 3, 1};

    @Test
    void sortBubble() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int[] arrayActual = arrayLogic.sortBubble(testArray);
        Assertions.assertTrue(Arrays.equals(arrayExpected, arrayActual));
    }

    @Test
    void sortBySelections() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int[] arrayActual = arrayLogic.sortBySelections(testArray);
        Assertions.assertTrue(Arrays.equals(arrayExpected, arrayActual));
    }

    @Test
    void sortShellMethod() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int[] arrayActual = arrayLogic.sortShellMethod(testArray);
        Assertions.assertTrue(Arrays.equals(arrayExpected, arrayActual));
    }

    @Test
    void searchBinary() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int expectedIndex = 1;
        int expectedIndex2 = -1;
        int actualIndex = arrayLogic.searchBinary(arrayExpected, 3);
        int actualIndex2 = arrayLogic.searchBinary(testArray, 5);
        Assertions.assertEquals(expectedIndex, actualIndex);
        Assertions.assertEquals(expectedIndex2, actualIndex2);
    }

    @Test
    void findMax() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int expected = 10;
        int actual = arrayLogic.findMax(testArray);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void findMin() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int expected = 1;
        int actual = arrayLogic.findMin(testArray);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void calculateSimpleNumbers() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int expected1 = 3;
        int expected2 = 5;
        List<Integer> actual = arrayLogic.calculateSimpleNumbers(testArray);
        Assertions.assertTrue(actual.contains(expected1));
        Assertions.assertTrue(actual.contains(expected2));
    }

    @Test
    void calculateFibonacciNumbers() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int expected1 = 233;
        int expected2 = 377;
        int maxLimit = 10000;
        List<Integer> actual = arrayLogic.calculateFibonacciNumbers(maxLimit);
        Assertions.assertTrue(actual.contains(expected1));
        Assertions.assertTrue(actual.contains(expected2));
    }

    @Test
    void findFibonacciInArray() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int expectedSize = 4;
        int maxLimit = 10000;
        List<Integer> actual = arrayLogic.findFibonacciInArray(testArray, maxLimit);
        Assertions.assertEquals(actual.size(), expectedSize);

    }

    @Test
    void findNumbersWithXDigits() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int amountDigits = 3;
        int[] localTestArray = {1, 478, 54, 101};
        List<Integer> actual = arrayLogic.findNumbersWithXDigits(localTestArray, amountDigits);
        int expectedSize = 2;
        Assertions.assertTrue(actual.size() == expectedSize);
    }

    @Test
    void findNumbersWithUniqueDigits() {
        ArrayLogic arrayLogic = new ArrayLogic();
        int amountDigits = 3;
        int[] localTestArray = {1, 478, 54, 101, 218, 554};
        List<Integer> threeDigitNumbers = arrayLogic.findNumbersWithXDigits(localTestArray, amountDigits);
        int expected1 = 478;
        int expected2 = 218;
        int expectedSize = 2;
        List<Integer> threeDigitNumbersUniqueSymbols = arrayLogic.findNumbersWithUniqueDigits(threeDigitNumbers);
        Assertions.assertTrue(threeDigitNumbersUniqueSymbols.contains(expected1));
        Assertions.assertTrue(threeDigitNumbersUniqueSymbols.contains(expected2));
        Assertions.assertEquals(threeDigitNumbersUniqueSymbols.size(), expectedSize);
    }
}