package intsy.group7.pathfinder_sim.view;

import java.awt.*;
import java.util.HashMap;
import java.util.Set;

//use: manage map (location picker)
public class NodeMaker {
    //HashMap to store the label as the key and Point (X, Y)
    HashMap<String, Point> map;
    Color noRed = new Color(188, 24, 35);

    public NodeMaker(){
        this.map = new HashMap<>();

        this.map.put("A", new Point(1252, 446));
        this.map.put("B", new Point(1222, 444));
        this.map.put("C", new Point(1175, 475));
        this.map.put("D", new Point(907, 559));
        this.map.put("E", new Point(867, 443));
        this.map.put("F", new Point(829, 441));
        this.map.put("G", new Point(750, 434));
        this.map.put("H", new Point(743, 569));
        this.map.put("I", new Point(685, 443));
        this.map.put("JA", new Point(686, 449));
        this.map.put("JB", new Point(608, 599));
        this.map.put("K", new Point(571, 448));
        this.map.put("L", new Point(669, 551));
        this.map.put("M", new Point(579, 341));
        this.map.put("N", new Point(654, 343));
        this.map.put("O", new Point(865, 340));
        this.map.put("P", new Point(972, 357));
        this.map.put("Q", new Point(1025, 350));
        this.map.put("R", new Point(1114, 350));
        this.map.put("S", new Point(983, 299));
        this.map.put("T", new Point(1269, 321));
        this.map.put("U", new Point(494, 505));
        this.map.put("V", new Point(715, 340));
        this.map.put("W", new Point(789, 318));
        this.map.put("X", new Point(791, 353));
        this.map.put("Y", new Point(908, 321));
        this.map.put("Z", new Point(921, 354));
        this.map.put("AA", new Point(1024, 320));
        this.map.put("AB", new Point(997, 225));
        this.map.put("AC", new Point(1037, 225));
        this.map.put("AD", new Point(995, 263));
        this.map.put("AE", new Point(1031, 262));
        this.map.put("AF", new Point(401, 556));
        this.map.put("AG", new Point(450, 571));
        this.map.put("AH", new Point(513, 573));
        this.map.put("AI", new Point(655, 603));
        this.map.put("AJ", new Point(1183, 348));
        this.map.put("LA", new Point(777, 463));
        this.map.put("LB", new Point(782, 559));
        this.map.put("LC", new Point(779, 598));
        this.map.put("LD", new Point(829, 555));
        this.map.put("LE", new Point(903, 425));
        this.map.put("LF", new Point(937, 525));
        this.map.put("LG", new Point(941, 595));
        this.map.put("LH", new Point(899, 633));
        this.map.put("LI", new Point(963, 632));
        this.map.put("LJ", new Point(696, 587));
        this.map.put("LK", new Point(1085, 569));
        this.map.put("LL", new Point(1064, 497));
        this.map.put("LM", new Point(1112, 497));
        this.map.put("LN", new Point(1127, 549));
        this.map.put("LO", new Point(1195, 499));
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
            vacantButtons[i].setFont(new Font("Helvetica", Font.BOLD, 14));
            vacantButtons[i].setForeground(Color.WHITE);
            vacantButtons[i].setBackground(noRed);
            vacantButtons[i].setBounds(x, y, 30, 30); 
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
