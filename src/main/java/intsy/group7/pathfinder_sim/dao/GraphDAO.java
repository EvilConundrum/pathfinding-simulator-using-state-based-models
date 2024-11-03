package intsy.group7.pathfinder_sim.dao;

import java.io.InputStream;
import java.util.Scanner;

import intsy.group7.pathfinder_sim.helper.Helper;
import intsy.group7.pathfinder_sim.model.Graph;
import intsy.group7.pathfinder_sim.model.Node;

/**
 * GraphDAO class is responsible for loading nodes and edges into a Graph
 * from text files. Each line in the file corresponds to a node or edge with
 * specific attributes, such as coordinates, state, and distance.
 *
 * @author Vienn Balcita
 */
public class GraphDAO {

    /**
     * Loads nodes from a file and adds them to the given graph. Each line in the
     * file should contain node details in CSV format.
     *
     * @param filepath the path to the file containing node data
     * @param graph the Graph object to which nodes will be added
     */
    public void loadGraphNodes(InputStream inputStream, Graph graph) {
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split(",");

                String nodeName = columns[0];
                int heuristic = Integer.parseInt(columns[1]) * 5;
                int xCoord = Integer.parseInt(columns[2]);
                int yCoord = Integer.parseInt(columns[3]);
                String nodeState = columns[4];

                Node node = new Node(nodeName, heuristic, xCoord, yCoord, nodeState);

                // Add node to graph only if it does not already exist
                if (!graph.findNode(node)) {
                    graph.addNode(node);
                }
            }
        }
    }

    /**
     * Loads edges from a file and adds them to the given graph. Each line in the
     * file should contain edge details in CSV format, specifying an origin and
     * destination node.
     *
     * @param filepath the path to the file containing edge data
     * @param graph the Graph object to which edges will be added
     */
    public void loadGraphEdges(InputStream inputStream, Graph graph) {
        try (Scanner scanner = new Scanner(inputStream)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] columns = line.split(",");

                String originID = columns[0];
                String destinationID = columns[1];

                Node origin = graph.findNode(originID);
                Node destination = graph.findNode(destinationID);

                if (origin != null && destination != null) {
                    int distance = (int) Helper.calcDist(origin, destination);
                    graph.addEdges(origin, destination, distance);
                } else {
                    System.err.printf("Edge creation skipped: Origin %s or Destination %s not found.%n", originID, destinationID);
                }
            }
        }
    }
}
