
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable,Paintable {

    private ArrayList<Wall> wallList;
    private static final int  SQUARE_FEET_PER_GALLON=400;
    private transient int roomNumber;

    private static int roomCount = 0;

    public Room(double length, double width, double height) throws BadWidthException, BadHeightException {
        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);

        roomNumber = ++roomCount;
    }

    public double getArea() {
        double area = 0;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Room #").append(roomNumber).append("\n");
        sb.append("Area: ").append(getArea()).append("\n");
        return sb.toString();
    }

    @Override
    public double getPremiumCost() {
        double cost = getArea()/SQUARE_FEET_PER_GALLON*PREMIUM_PAINT_COST_PER_GALLON;
        return cost;
    }

    @Override
    public double getStandardCost() {
        double cost = getArea()/SQUARE_FEET_PER_GALLON*STANDARD_PAINT_COST_PER_GALLON;
        return cost;
    }
}
