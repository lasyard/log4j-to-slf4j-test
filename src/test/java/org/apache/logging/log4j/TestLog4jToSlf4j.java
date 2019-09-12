package org.apache.logging.log4j;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TestLog4jToSlf4j {
    private static Logger logger = LogManager.getLogger(TestLog4jToSlf4j.class);

    @Test
    public void testLog4j2() {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream old = System.out;
        System.setOut(new PrintStream(baos));
        logger.info("Message: {}", "Test - {}");
        System.setOut(old);
        System.out.println(baos.toString()); // Actual output: "Message: Test - Test - {}\n"
        assertEquals("Message: Test - {}\n", baos.toString());
    }
}
