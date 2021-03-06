package by.epam.testone.reader;

import by.epam.taskone.exception.ReaderException;
import by.epam.taskone.reader.impl.LineReaderImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LineReaderImplTest {
    private final LineReaderImpl lineReaderImpl = new LineReaderImpl();
    private static final Logger logger = LogManager.getLogger(LineReaderImplTest.class);
    private static final String PATH = "src\\main\\resources\\data.txt";

    @Test
    @DisplayName("readFile")
    void readFile() {
        try {
            List<String> readStringList = lineReaderImpl.readLineFromFile(PATH);
            List<String> expectedStringList = new ArrayList<>();

            expectedStringList.add("28; 255; 3457; 73; -8");
            expectedStringList.add("2;we;643");

            assertEquals(readStringList.get(0).trim(), expectedStringList.get(0));
            assertEquals(readStringList.get(2).trim(), expectedStringList.get(1));
        } catch (ReaderException e) {
            logger.error(e.getMessage());
        }
    }
}
