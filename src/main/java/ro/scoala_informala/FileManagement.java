package ro.scoala_informala;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileManagement {

    public List<String> readLines(String inputFile) {
        try {
            return Files.readAllLines(Path.of(inputFile));
        } catch (IOException e) {
            throw new RuntimeException("Failed to read input file: " + inputFile, e);
        }
    }

    public void writeLines(String outputFile, List<String> lines) {
        try {
            Files.write(Path.of(outputFile), lines);
        } catch (IOException e) {
            throw new RuntimeException("Failed to write output file: " + outputFile, e);
        }
    }
}


