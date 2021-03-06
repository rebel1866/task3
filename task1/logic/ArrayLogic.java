package by.epamtc.stanislavmelnikov.task1.logic;

import by.epamtc.stanislavmelnikov.task1.entity.UnsortedArrayException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayLogic {
    //сортировка пузырьком
    public void sortBubble(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length - 1; i++) {
            for (int j = 0; j < sourceArray.length - i - 1; j++) {
                if (sourceArray[j] > sourceArray[j + 1]) {
                    swap(sourceArray, j, j + 1);
                }
            }
        }
    }

    // сортировка выбором
    public void sortBySelections(int[] sourceArray) {
        for (int i = 0; i < sourceArray.length; i++) {
            int value = sourceArray[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < sourceArray[j]) {
                    sourceArray[j + 1] = sourceArray[j];
                } else {
                    break;
                }
            }
            sourceArray[j + 1] = value;
        }
    }

    //сортировка методом шелла
    public void sortShellMethod(int[] sourceArray) {
        int interval = sourceArray.length / 2;
        while (interval >= 1) {
            for (int i = 0; i < sourceArray.length; i++) {
                for (int j = i - interval; j >= 0; j = j - interval) {
                    if (sourceArray[j] > sourceArray[j + interval]) {
                        swap(sourceArray, j, j + interval);
                    }
                }
            }
            interval = interval / 2;
        }
    }

    public int[] swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
        return array;
    }

    //бинарный поиск
    public int searchBinary(int[] array, int elementToSearch) {
        try {
            if (!isSorted(array)) throw new UnsortedArrayException();
        } catch (UnsortedArrayException ex) {
            ex.printExceptionMessage();
            return -1;
        }
        int firstIndex = 0;
        int lastIndex = array.length - 1;
        while (firstIndex <= lastIndex) {
            int middleIndex = (firstIndex + lastIndex) / 2;
            if (array[middleIndex] == elementToSearch) {
                return middleIndex;
            } else if (array[middleIndex] < elementToSearch)
                firstIndex = middleIndex + 1;
            else if (array[middleIndex] > elementToSearch)
                lastIndex = middleIndex - 1;
        }
        return -1;
    }

    public boolean isSorted(int[] array) {
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public int findMax(int[] array) {
        int max = array[0];
        for (int element : array) {
            if (element > max) {
                max = element;
            }
        }
        return max;
    }

    public int findMin(int[] array) {
        int min = array[0];
        for (int element : array) {
            if (element < min) {
                min = element;
            }
        }
        return min;
    }

    // определить все простые числа в массиве
    public List<Integer> calculateSimpleNumbers(int[] array) {
        List<Integer> simpleNumbers = new ArrayList<>();
        for (int number : array) {
            if (isSimpleNumber(number)) {
                simpleNumbers.add(number);
            }
        }
        return simpleNumbers;
    }

    // проверить, является ли данное число простым
    public boolean isSimpleNumber(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    // найти все числа Фибонначчи в массиве, начиная от 0 до fibonacciMaxLimit
    public List<Integer> findFibonacciInArray(int[] array, int fibonacciMaxLimit) {
        List<Integer> fibonacciInArray = new ArrayList<>();
        List<Integer> fibonacciNumbers = calculateFibonacciNumbers(fibonacciMaxLimit);
        for (int number : array) {
            if (fibonacciNumbers.contains(number)) {
                fibonacciInArray.add(number);
            }
        }
        return fibonacciInArray;
    }

    //рассчитать числа Фибонначчи начиная от 0 до maxLimit
    public List<Integer> calculateFibonacciNumbers(int maxLimit) {
        int firstNumber = 0;
        int secondNumber = 1;
        List<Integer> fibonacciNumbers = new ArrayList<>();
        fibonacciNumbers.add(firstNumber);
        fibonacciNumbers.add(secondNumber);
        int startIndex = 2;
        for (int i = startIndex; i < maxLimit; i++) {
            int previous1 = fibonacciNumbers.get(i - 1);
            int previous2 = fibonacciNumbers.get(i - 2);
            fibonacciNumbers.add(previous1 + previous2);
        }
        return fibonacciNumbers;
    }

    // найти в массиве числа с количством цифр, равняющимся параметру amountDigits
    public List<Integer> findNumbersWithXDigits(int[] array, int amountDigits) {
        List<Integer> xDigitNumbers = new ArrayList<>();
        for (int number : array) {
            String numberString = String.valueOf(number);
            if (numberString.length() == amountDigits) {
                xDigitNumbers.add(number);
            }
        }
        return xDigitNumbers;
    }

    // определить числа, в запись которых входят только неповторяющиеся цифры
    public List<Integer> findNumbersWithUniqueDigits(List<Integer> numbers) {
        Set<String> uniqueDigits = new HashSet<>();
        List<Integer> numbersWithUniqueSymbols = new ArrayList<>();
        for (Integer number : numbers) {
            String[] arrayDigits = number.toString().split("");
            int amountDigits = arrayDigits.length;
            for (String digit : arrayDigits) {
                uniqueDigits.add(digit);
            }
            if (uniqueDigits.size() == amountDigits) {
                numbersWithUniqueSymbols.add(number);
            }
            uniqueDigits.clear();
        }
        return numbersWithUniqueSymbols;
    }
}
