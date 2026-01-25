
import org.junit.jupiter.api.io.TempDir;
import ro.scoala_informala.FileManagement;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FileManagementTest {

    private final FileManagement fileManagement = new FileManagement();

    @TempDir
    Path tempDir;

    @Test
    public void happyFlowFileIsReadSuccessfully() throws IOException {

        Path inputFile = tempDir.resolve("input.txt");
        List<String> expectedLines = List.of("line 1", "line 2", "line 3");
        Files.write(inputFile, expectedLines);

        List<String> actualLines = fileManagement.readLines(inputFile.toString());

        assertEquals(expectedLines, actualLines);

    }

    @Test
    public void unhappyFlowFileDoesNotExistExceptionIsThrown() {

        Path nonExistentFile = tempDir.resolve("missing.txt");

        RuntimeException exception = assertThrows(
                RuntimeException.class,
                () -> fileManagement.readLines(nonExistentFile.toString())
        );
        assertTrue(exception.getMessage().contains("Failed to read input file"));
    }
}




