package by.epamtc.stanislavmelnikov.task1.entity;

import java.util.Arrays;

public class Array {
    private int[] arrayInt;

    public Array() {

    }

    public Array(int[] array) {
        this.arrayInt = array;
    }

    public int[] getArrayInt() {
        return arrayInt;
    }

    public void setArrayInt(int[] arrayInt) {
        this.arrayInt = arrayInt;
    }

    @Override
    public String toString() {
        return "Array{arrayInt=" + Arrays.toString(arrayInt) + "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (getClass() != o.getClass()) return false;
        Array array = (Array) o;
        if (this.arrayInt == null || array.getArrayInt() == null) {
            return this.arrayInt == array.getArrayInt();
        }
        if (arrayInt.length != array.getArrayInt().length) return false;
        for (int i = 0; i < arrayInt.length; i++) {
            if (arrayInt[i] != array.getArrayInt()[i]) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        int prime = 31;
        int hash = 0;
        for (int element : arrayInt) {
            hash = hash + prime * element;
        }
        return hash;
    }
}
