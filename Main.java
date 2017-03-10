import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Furkan Sonmez on 18.12.2016.
 */
public class Main extends JPanel{

    /*
    Here my parameters which i will use in this class.
     */

    //Bridge object is at the middle of the panel.
    static Bridge bridge;
    //Semaphore is for control the objects.
    static Semaphore semaphore;
    //List of all vehicles.
    private ArrayList<Vehicle> arrayList = new ArrayList<>(); // my arraylist.


    /**
     * My frame method. it adjust my screen on the windows. this method include size, bounds, backgrounds etc..
     */
    public void frameAndPanel() {
        //Frame created.
        JFrame frame = new JFrame();
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setBounds(100, 100,1200, 700);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        //Panel added to frame.
        this.setVisible(true);
        frame.add(this);
        this.setSize(1200,700);
        //Color of background.
        this.setBackground(Color.PINK);
    }

    /**
     * Time to draw it !.
     * This method will paint my bridge and cars.
     * With every cars has own colors and color.
     * @param g classic g in paint method.
     */
    public void paint(Graphics g) {
        super.paint(g);
        // I draw the bridge.
        g.fillRect(bridge.getXPositionOfBridge(), bridge.getYPositionOfBridge(), bridge.getLength(), bridge.getHeight());
        //Give it the color.
        g.setColor(bridge.getColor());

        // I paint all vehicles in arraylist.
        for (Vehicle vehicle:arrayList) {
            g.fillOval(vehicle.getXPositionOfVehicle(), vehicle.getYPositionOfVehicle(), vehicle.getRadiusOfVehicle(),vehicle.getRadiusOfVehicle());
            g.setColor(vehicle.getColor());
            //System.out.println(vehicle.getXPositionOfVehicle());
        }
    }

    /**
     * Constructor
     * I called frameAndPanel method that creates frame and panel.
     * @param countOfVehicle my first parameter.
     * @param countOfSem my second parameter.
     */
    public Main(int countOfVehicle, int countOfSem) {
        frameAndPanel();

        //Bridge created
        bridge = new Bridge();
        // Semaphore created and I give count of semaphores.
        semaphore = new Semaphore(countOfSem);

        // I created all runnable objects and put them in thread.
        for (int i = 0; i < countOfVehicle; i++){
            Vehicle vehicle = new Vehicle(bridge,semaphore);
            //Threads created.
            new Thread(vehicle).start();
            arrayList.add(vehicle);
        }
    }

    public static void main(String[] args) {

        Main main = null;
        //Arguments to take input from terminal.
        int arg1;
        int arg2;
        int s = 0;
        //Need control length of args.
        if(args.length > s) {
            arg1 = Integer.parseInt(args[0]);
            arg2 = Integer.parseInt(args[1]);
            main = new Main(arg1,arg2);
        }


        // This for loop is to paint always the vehicles.
        for (; ;) {
            main.repaint();
        }
    }
}
