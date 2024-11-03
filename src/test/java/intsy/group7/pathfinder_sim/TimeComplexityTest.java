package intsy.group7.pathfinder_sim;

import intsy.group7.pathfinder_sim.algorithm.*;
import intsy.group7.pathfinder_sim.algorithm.result.Result;
import intsy.group7.pathfinder_sim.dao.GraphDAO;
import intsy.group7.pathfinder_sim.dao.GraphDAOTest;
import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TimeComplexityTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.nextInt();

        GraphDAOTest graphDAOTest = new GraphDAOTest();
        String testCasesFolderPath = "src/test/java/intsy/group7/pathfinder_sim/csv/";
        List<String[]> testNodes = graphDAOTest.loadTestCases(testCasesFolderPath + "test_cases.csv");

        for (String[] entry : testNodes) {
            // Initialize data structures
            Graph graph = new Graph();
            GraphDAO graphDAO = new GraphDAO();
            String CSVFolderPath = "src/main/resources/csv/";

            // Load in the graph
            graphDAO.loadGraphNodes(CSVFolderPath + "nodes.csv", graph);
            graphDAO.loadGraphEdges(CSVFolderPath + "edges.csv", graph);

            // Set up the nodes
            String initialStateKey = entry[0];
            String goalStateKey = entry[1];
            Node initialState = graph.findNode(initialStateKey);
            Node goalState = graph.findNode(goalStateKey);

            System.out.println("Initial state: " + initialStateKey);
            System.out.println("Goal state: " + goalStateKey);

            // Add the tests to conduct
            List<AlgorithmTest> algorithmTests = new ArrayList<>();
            algorithmTests.add(new BFSAlgorithmTest(200));
            algorithmTests.add(new DFSAlgorithmTest(200));
            algorithmTests.add(new UCSAlgorithmTest(200));
            algorithmTests.add(new GBFSAlgorithmTest(200));
            algorithmTests.add(new AStarAlgorithmTest(200));

            // Iterate through the tests
            for (AlgorithmTest algorithmTest : algorithmTests) {
                Result result = algorithmTest.testTimeComplexity(initialState, goalState);
                System.out.println(result.getStringTraversal());
                System.out.println(result.getPathCost());
                System.out.println(result.getStringPath());
                System.out.println("========================================================================");
            }
        }
        scanner.nextInt();
    }
}
