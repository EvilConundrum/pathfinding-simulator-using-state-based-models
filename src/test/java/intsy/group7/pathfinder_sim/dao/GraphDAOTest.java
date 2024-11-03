package intsy.group7.pathfinder_sim.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class GraphDAOTest {

    public List<String[]> loadTestCases(String filePath) {
        List<String[]> testCases = new ArrayList<>();
        Path path = Paths.get(filePath);

        try {
            // Read all lines from the CSV file
            List<String> lines = Files.readAllLines(path);
            // Skip the header line and process each subsequent line
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                String[] parts = line.split(","); // Split by comma
                if (parts.length == 2) {
                    testCases.add(parts); // Add the key-value pair to the list
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading test cases from " + filePath);
        }

        return testCases; // Return the list of test cases
    }
}
