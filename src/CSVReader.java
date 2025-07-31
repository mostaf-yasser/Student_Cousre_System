import java.io.*;
import java.util.*;

public class CSVReader {
    public static List<String[]> read(String filePath) {
        List<String[]> data = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] values = line.trim().split(",");
                data.add(values);
            }

        } catch (IOException e) {
            System.err.println("Exception in CSVReader file: " + filePath);
        }

        return data;
    }
}
