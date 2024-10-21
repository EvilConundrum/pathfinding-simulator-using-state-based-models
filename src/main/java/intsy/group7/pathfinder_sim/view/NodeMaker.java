import java.awt.Color;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

//use: manage map (location picker)
public class NodeMaker {
    //HashMap to store the label as the key and Point (X, Y)
    HashMap<String, Point> map;
    Color noRed = new Color(188, 24, 35);
    private String filepath;

    public NodeMaker(String path){
        this.map = new HashMap<>();

    try (Scanner scanner = new Scanner(new File(filepath))) {   
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] columns = line.split(",");
            String nodeName = columns[0];
            int xCoord = Integer.parseInt(columns[2]);
            int yCoord = Integer.parseInt(columns[3]);
            
            this.map.put(nodeName,new Point(xCoord,yCoord));
            //System.out.println("Node: " + node.getId() + " created!"); check nodes created
        }
        //System.out.println("All nodes created successfully"); // DEBUGGING
    } 
    catch (FileNotFoundException e) {
    System.out.println("File not found: " + filepath);
    }
    }


    //returns a Hashmap of vacant nodes
    public HashMap<String, Point> getVacantNodes(HashMap<String, Point> occupiedNodes){
        HashMap<String, Point> vacantNodes  = new HashMap<>();

        for (String label : this.map.keySet()) {
            if (!occupiedNodes.containsKey(label)) {
                vacantNodes.put(label, this.map.get(label));
            }
        }

        return vacantNodes;
    }

    

    //returns the vacant nodes as RoundedButton
    public RoundedButton[] getVacantButtons(HashMap<String, Point> vacantNodes){
        RoundedButton[] vacantButtons = new RoundedButton[52];
        Set<String> keySet = vacantNodes.keySet();
        String[] keysArray = keySet.toArray(new String[0]);
        Point pointA;
        int x;
        int y;

        for(int i = 0; i < vacantNodes.size(); i++) {
            pointA = vacantNodes.get(keysArray[i]);

            x = pointA.x;
            y = pointA.y;

            vacantButtons[i] = new RoundedButton(keysArray[i]);
            vacantButtons[i].setFont(new Font("Helvetica", Font.BOLD, 10));
            vacantButtons[i].setForeground(Color.WHITE);
            vacantButtons[i].setBackground(noRed);
            vacantButtons[i].setBounds(x, y, 23, 23); 
            vacantButtons[i].setOpaque(true); 
            vacantButtons[i].setBorder(null);
            vacantButtons[i].setContentAreaFilled(true); 
            vacantButtons[i].setCustomBorderColor(Color.WHITE); 
            vacantButtons[i].setCustomBorderThickness(2);
        }

        return vacantButtons;
    }

    //returns the HashMap map
    public HashMap<String, Point> getAllNodes(){
        return this.map;
    }
    
}
