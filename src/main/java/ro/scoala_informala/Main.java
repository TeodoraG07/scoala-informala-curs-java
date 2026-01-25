package ro.scoala_informala;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Path inputFile = Path.of("TestFile.csv");

        Path outputFile = Path.of("Output.txt");

        int month = 12;

        FileManagement fileManagement = new FileManagement();
        List<String> lines = fileManagement.readLines(inputFile.toString());

        PersonManagement personManagement = new PersonManagement();
        List<String> outputLines = personManagement.process(lines, month);

        fileManagement.writeLines(outputFile.toString(), outputLines);

        System.out.println("Matches written to " + outputFile + ":");
        outputLines.forEach(System.out::println);
    }
}