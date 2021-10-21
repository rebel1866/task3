package by.epamtc.stanislavmelnikov.task2.logic;

import by.epamtc.stanislavmelnikov.task2.entity.LimitValue;
import by.epamtc.stanislavmelnikov.task2.entity.SortingDirection;

import java.util.function.Function;

public interface IJagged {
    int countSumElements(int[] arrayString);

    int findStringLimitValue(int[] arrayString, LimitValue limitValue);

    int[][] swap(int[][] array, int str1, int str2);

    int[][] sortArrayStrings(int[][] array, SortingDirection direction, Function function);
}
