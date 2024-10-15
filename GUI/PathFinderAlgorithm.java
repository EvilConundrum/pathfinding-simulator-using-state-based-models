import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class PathFinderAlgorithm{
    // Initialize the road and street nodes in the controller
    // Draw the path in the controller using this class and JSeparator

    // Road Subnodes
    public HashMap<String, Point[]> roads;
    public HashMap<String, Point[]> streets;

    // Threshold distance
    private final int NEAR_ROAD_THRESHOLD = 50; // Adjust this value as needed

    public Point findClosestSubnode(Point mainNode) {
        Point closestSubnode = null;
        double minDistance = Double.MAX_VALUE;

        // Iterate over each road to check for proximity
        for (Map.Entry<String, Point[]> roadEntry : roads.entrySet()) {
            String roadName = roadEntry.getKey();
            Point[] roadSubnodes = roadEntry.getValue();

            if (isMainNodeNearRoad(mainNode, roadName)) {
                for (Point subnode : roadSubnodes) {
                    double distance = mainNode.distance(subnode);
                    if (distance < minDistance) {
                        minDistance = distance;
                        closestSubnode = subnode;
                    }
                }
            }
        }
        return closestSubnode; 
    }

    
    public boolean isMainNodeNearRoad(Point mainNode, String roadName) {
        Point[] roadSubnodes = roads.get(roadName);
        if (roadSubnodes != null) {
            for (Point subnode : roadSubnodes) {
                double distance = mainNode.distance(subnode); // distance: main node to subnode

                if (distance <= NEAR_ROAD_THRESHOLD) {
                    return true; // Main node is near this road
                }
            }
        }
        return false; // Main node is not near this road
    }
        
}
