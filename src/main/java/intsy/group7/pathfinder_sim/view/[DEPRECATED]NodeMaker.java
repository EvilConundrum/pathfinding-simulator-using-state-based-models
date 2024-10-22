// package intsy.group7.pathfinder_sim.view;

// import java.awt.Color;
// import java.awt.Font;
// import java.awt.Point;
// import java.io.File;
// import java.io.FileNotFoundException;
// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.LinkedHashMap;
// import java.util.Scanner;
// import java.util.Set;

// //use: manage map (location picker)
// public class NodeMakerOrig {
//     //HashMap to store the label as the key and Point (X, Y)
//     private static LinkedHashMap<String, Point> map;
//     private static Color noRed = new Color(188, 24, 35);
//     private static ArrayList<Boolean> eateryNodes = new ArrayList<>();

//     static {
//         map = new LinkedHashMap<String, Point>();

//         try (Scanner scanner = new Scanner(new File("src/main/java/intsy/group7/pathfinder_sim/dao/nodes.csv"))) {   
//             while (scanner.hasNextLine()) {
//                 String line = scanner.nextLine();
//                 String[] columns = line.split(",");
//                 String nodeName = columns[0];
//                 int xCoord = Integer.parseInt(columns[2]);
//                 int yCoord = Integer.parseInt(columns[3]);
//                 boolean isEatery = Boolean.parseBoolean(columns[4]);
                
//                 map.put(nodeName, new Point(xCoord,yCoord));
//                 eateryNodes.add(isEatery);

//                 //System.out.println("Node: " + node.getId() + " created!"); check nodes created
//             }
//             //System.out.println("All nodes created successfully"); // DEBUGGING
//         } 
//         catch (FileNotFoundException e) {
//             System.out.println("File not found: " + "src/main/java/intsy/group7/pathfinder_sim/dao/nodes.csv");
//         }
//     }

//     //returns the vacant nodes as RoundedButton
//     public static RoundedButton[] getVacantButtons(HashMap<String, Point> vacantNodes) {
//         RoundedButton[] vacantButtons = new RoundedButton[86];
//         Set<String> keySet = vacantNodes.keySet();
//         String[] keysArray = keySet.toArray(new String[0]);
//         Point pointA;
//         int x;
//         int y;

//         for(int i = 0; i < vacantNodes.size(); i++) {
//             pointA = vacantNodes.get(keysArray[i]);

//             x = pointA.x;
//             y = pointA.y;

//             vacantButtons[i] = new RoundedButton(keysArray[i]);
//             vacantButtons[i].setFont(new Font("Helvetica", Font.BOLD, 10));
//             vacantButtons[i].setForeground(Color.WHITE);
//             vacantButtons[i].setBackground(noRed);
//             vacantButtons[i].setBounds(x, y, 22, 22); 
//             vacantButtons[i].setOpaque(true); 
//             vacantButtons[i].setBorder(null);
//             vacantButtons[i].setContentAreaFilled(true); 
//             vacantButtons[i].setCustomBorderColor(Color.WHITE); 
//             vacantButtons[i].setCustomBorderThickness(2);
//         }

//         return vacantButtons;
//     }

//     //returns the HashMap map
//     public static LinkedHashMap<String, Point> getAllNodes() {
//         return map;
//     }

//     //returns a Hashmap of vacant nodes
//     public static LinkedHashMap<String, Point> getVacantNodes(HashMap<String, Point> occupiedNodes){
//         LinkedHashMap<String, Point> vacantNodes  = new LinkedHashMap<>();

//         for (String label : map.keySet()) {
//             if (!occupiedNodes.containsKey(label)) {
//                 vacantNodes.put(label, map.get(label));
//             }
//         }

//         return vacantNodes;
//     }  


//     // Make me a method that returns the hashmap of all eatery nodes
//     public static LinkedHashMap<String, Point> getEateryNodes() {
//         LinkedHashMap<String, Point> eateryNodesMap = new LinkedHashMap<>();

//         for (int i = 0; i < eateryNodes.size(); i++) {
//             if (eateryNodes.get(i) == true) {
//                 String label = (String) map.keySet().toArray()[i];
//                 eateryNodesMap.put(label, map.get(label));
//             }
//         }

//         return eateryNodesMap;
//     }

    
    
// }
