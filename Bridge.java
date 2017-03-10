import java.awt.*;

/**
 * Created by Furkan Sonmez on 18.12.2016.
 */
public class Bridge {

    /**
     * X position of bridge.
     */
    private int XPositionOfBridge = 460;

    /**
     * Y position of bridge.
     */
    private int YPositionOfBridge = 0;

    /**
     * Height of bridge.
     */
    private int height = 700;

    /**
     * Length of bridge.
     */
    private int length = 300;

    private Color color = new Color(120,120,120);

    //Get and set methods.
    public int getYPositionOfBridge() {
        return YPositionOfBridge;
    }

    public void setYPositionOfBridge(int YPositionOfBridge) {
        this.YPositionOfBridge = YPositionOfBridge;
    }

    //Constructor of bridge.
    public Bridge() {
    }

    //Set and get methods.
    public int getXPositionOfBridge() {
        return XPositionOfBridge;
    }

    public void setXPositionOfBridge(int XPositionOfBridge) {
        this.XPositionOfBridge = XPositionOfBridge;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Bridge{" +
                "XPositionOfBridge=" + XPositionOfBridge +
                ", XPositionOfBridge=" + XPositionOfBridge +
                ", height=" + height +
                ", length=" + length +
                ", color=" + color +
                '}';
    }
}
