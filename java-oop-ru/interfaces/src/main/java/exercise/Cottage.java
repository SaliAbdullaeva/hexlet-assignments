package exercise;

public class Cottage implements Home {
    private double area; //общая площадь коттеджа
    private int floorCount; //количество этажей

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public double getArea() {
        return area;
    }

    @Override
    public int compareTo(Home another) {
        if (area == another.getArea()) {
            return 0;
        } else if (area > another.getArea()) {
            return 1;
        } else {
            return -1;
        }
    }

    @Override
    public String toString() {
        return  floorCount + "этажный коттедж площадью" + area + "метров";
    }
}
