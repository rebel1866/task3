import by.epamtc.stanislavmelnikov.task1.entity.Array;
import by.epamtc.stanislavmelnikov.shared.input.DataScanner;
import by.epamtc.stanislavmelnikov.shared.output.ConsoleOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

class DataScannerTest {
    private final int[] arrayExpected = {1, 6, 9, 15};
    private final String testText1 = "1 6 9 15";
    private final String testText2 = "33 9 15";
    private final String testText3 = "a b 9 15";

    @Test
    void extractNumbersFromFile() {
        DataScanner dataScanner = new DataScanner(new ConsoleOutput());
        String path = "D://test.txt";
        FileOutputStream fileOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] buffer = testText1.getBytes();
        try {
            fileOutputStream.write(buffer);
            Assertions.assertTrue(Arrays.equals(arrayExpected, dataScanner.extractNumbersFromFile(path)));
            buffer = testText2.getBytes();
            fileOutputStream.write(buffer);
            Assertions.assertFalse(Arrays.equals(arrayExpected, dataScanner.extractNumbersFromFile(path)));
            buffer = testText3.getBytes();
            fileOutputStream.write(buffer);
            Assertions.assertTrue(dataScanner.extractNumbersFromFile(path).length == 0);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}