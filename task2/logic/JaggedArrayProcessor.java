package by.epamtc.stanislavmelnikov.task2.logic;

import by.epamtc.stanislavmelnikov.task2.entity.LimitValue;
import by.epamtc.stanislavmelnikov.task2.entity.SortingDirection;

import java.util.function.Function;

public class JaggedArrayProcessor {
    //метод вычисляет сумму элементов строки
    public int countSumElements(int[] arrayString) {
        int sum = 0;
        for (int number : arrayString) {
            sum = sum + number;
        }
        return sum;
    }

    // метод определяет максимальное либо минимальное число в строке
    public int findStringLimitValue(int[] arrayString, LimitValue limitValue) {
        int limit = arrayString[0];
        for (int i = 1; i < arrayString.length; i++) {
            if ((arrayString[i] > limit) && limitValue == LimitValue.MAX) {
                limit = arrayString[i];
            }
            if ((arrayString[i] < limit) && limitValue == LimitValue.MIN) {
                limit = arrayString[i];
            }

        }
        return limit;
    }

    // метод меняет местами строки матрицы
    public int[][] swap(int[][] array, int str1, int str2) {
        int[] temp = array[str1];
        array[str1] = array[str2];
        array[str2] = temp;
        return array;
    }

    /* метод сортирует строки матрицы по заданным критериям - по сумме элементов, максимальному или минимальному
      значению - по убыванию и по возрастанию */
    public int[][] sortArrayStrings(int[][] array, SortingDirection direction, Function function) {
        int[][] targetArray = array.clone();
        for (int i = 0; i < targetArray.length; i++) {
            for (int j = 0; j < targetArray.length - i - 1; j++) {
                int valueStr1 = (int) function.apply(targetArray[j]);
                int valueStr2 = (int) function.apply(targetArray[j + 1]);
                if ((valueStr1 > valueStr2) && direction == SortingDirection.ASCENDING) {
                    swap(targetArray, j, j + 1);
                }
                if ((valueStr1 < valueStr2) && direction == SortingDirection.DESCENDING) {
                    swap(targetArray, j, j + 1);
                }
            }
        }
        return targetArray;
    }
}
