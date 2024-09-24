package exercise;

public class Flat implements Home {
    private double area; //жилая площадь квартиры
    private double balconyArea; //площадь балкона
    private int floor; //этаж, на котором расположена квартира

    public Flat(double area, double balconyArea, int floor) {
        this.area = area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public double getArea() {
        return area + balconyArea;
    }

    @Override
    public int compareTo(Home another) {
        if (this.getArea() == another.getArea()) {
            return 0;
        }
        else if (this.getArea() > another.getArea()) {
            return 1;
        }
        else return -1;
    }

    @Override
    public toString() {
        return "Квартира площадью" + this.getArea() + "метров на" + floor + "этаже";
    }

}
