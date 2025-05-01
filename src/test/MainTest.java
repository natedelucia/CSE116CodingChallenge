package test;

import static org.junit.Assert.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Test;

import main.*;

public class MainTest {

    @Test
    public void test() {
        assertEquals(1, Main.returnOne());
        assertNotEquals(2, Main.returnOne());
    }

    @Test
    public void runtimeTest() {
        long start = System.currentTimeMillis();

        Main.returnOne();

        long end = System.currentTimeMillis();
        long time = end - start;
        try {
            Files.writeString(Paths.get("time.txt"), Long.toString(time));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
