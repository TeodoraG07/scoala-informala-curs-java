package ro.scoala_informala;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
public class CsvFileLoader {
        public String readCsvFile(String resourceName) {
            try (InputStream is = Objects.requireNonNull(
                    getClass().getClassLoader().getResourceAsStream(resourceName),
                    "CSV resource not found: " + resourceName
            )) {
                return new String(is.readAllBytes(), StandardCharsets.UTF_8);
            } catch (IOException e) {
                throw new RuntimeException("Failed to read CSV: " + resourceName, e);
            }
        }
    }

