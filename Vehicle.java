import java.awt.*;
import java.util.Random;
import java.util.concurrent.Semaphore;

/**
 * Created by Furkan Sonmez on 18.12.2016.
 */

public class Vehicle implements Runnable{


    /**
     * XPosition of vehicles.
     */
    private int XPositionOfVehicle = 60;

    /**
     * Random objects to create random variables.
     */
    Random random = new Random();

    /**
     * Y position of vehicles.
     */
    private int YPositionOfVehicle = random.nextInt(600);

    /**
     * Radius of vehicles.
     */
    private int radiusOfVehicle = 25;


    /**
     * Speed of vehicles.
     */
    private int speedOfVehicle = random.nextInt(10) + 1;

    /**
     * String to control vehicles.
     */
    private String join = "f";


    /**
     * Bridge object.
     */
    private Bridge bridge;

    private Semaphore semaphore;

    // setter and getters methods.
    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    private Color color = new Color(random.nextFloat(), random.nextFloat(),random.nextFloat());

    // my constructor. including 2 parameter.
    public Vehicle(Bridge bridge, Semaphore semaphore) {
        this.bridge = bridge;
        this.semaphore = semaphore;
    }

    // again getter and setter methods.
    public Semaphore getSemaphore() {
        return semaphore;
    }

    public void setSemaphore(Semaphore semaphore) {
        this.semaphore = semaphore;
    }

    /**
     * Constructor for vehicle objects.
     * */
    public Vehicle(int YPositionOfVehicle, int radiusOfVehicle, Bridge bridge, Semaphore semaphore) {
        this.YPositionOfVehicle = YPositionOfVehicle;
        this.radiusOfVehicle = radiusOfVehicle;
        this.bridge = bridge;
        this.semaphore = semaphore;
    }

    //Again set and get methods.
    public int getXPositionOfVehicle() {
        return XPositionOfVehicle;
    }

    public void setXPositionOfVehicle(int XPositionOfVehicle) {
        this.XPositionOfVehicle = XPositionOfVehicle;
    }

    public int getYPositionOfVehicle() {
        return YPositionOfVehicle;
    }

    public void setYPositionOfVehicle(int YPositionOfVehicle) {
        this.YPositionOfVehicle = YPositionOfVehicle;
    }

    public int getRadiusOfVehicle() {
        return radiusOfVehicle;
    }

    public void setRadiusOfVehicle(int radiusOfVehicle) {
        this.radiusOfVehicle = radiusOfVehicle;
    }

    public Bridge getBridge() {
        return bridge;
    }

    public void setBridge(Bridge bridge) {
        this.bridge = bridge;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    public int getSpeedOfVehicle() {
        return speedOfVehicle;
    }

    public void setSpeedOfVehicle(int speedOfVehicle) {
        this.speedOfVehicle = speedOfVehicle;
    }

    public String getJoin() {
        return join;
    }

    public void setJoin(String join) {
        this.join = join;
    }

    // This method will increasing my x position for moving on the screen.
    public void letItGo() {
        XPositionOfVehicle = XPositionOfVehicle + speedOfVehicle;
    }

    /**
     * This method will check is car inside in bridge or not.
     * @throws InterruptedException
     */
    private void isInBridge() throws InterruptedException {
        // check car inside or not
        if (XPositionOfVehicle < bridge.getXPositionOfBridge() + bridge.getLength() && XPositionOfVehicle + radiusOfVehicle >= bridge.getXPositionOfBridge()) {
            if (join.equals("f")) {
                semaphore.acquire();
                join = "t";
                //System.out.println("inside");
            }
        }
    }

    /**
     * This method will check is car out side of bridge or not
     */
    private void isOutOfBridge() {
        // here my checking part.
        if ((join.equals("t") && XPositionOfVehicle >= (bridge.getXPositionOfBridge() + bridge.getLength()))){
            semaphore.release();
            join = "f";
            //System.out.println("not inside");
        }
    }

    /**
     * My run method. Including my all important methods.
     */
    @Override
    public void run() {
        while (true) {
            try {
                // That methots that i explanied before.
                letItGo();
                isInBridge();
                isOutOfBridge();
                Thread.sleep(random.nextInt(100) + 20);
                } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
