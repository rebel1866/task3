import by.epamtc.stanislavmelnikov.task1.entity.Array;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class ArrayTest {
    @Test
    void testEquals() {
        Array array1 = new Array(new int[]{1, 4, 9});
        Array array2 = new Array(new int[]{1, 4, 9});
        Array array3 = new Array(new int[]{1, 4, 9, 8, 5});
        Array array4 = new Array();
        Array array5 = new Array();
        Assertions.assertTrue(array1.equals(array2));
        Assertions.assertFalse(array1.equals(array3));
        Assertions.assertTrue(array4.equals(array5));
        Assertions.assertFalse(array4.equals(array1));
        Assertions.assertFalse(array1.equals(array4));
    }
}