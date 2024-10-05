package exercise;


public class Circle {
    private Point point;
    private int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }

//возвращает площадь круга. Если радиус круга меньше нуля, метод должен выбросить исключение
    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Радиус не может быть отрицательным");
        }
        return Math.PI * radius * radius; // or Math.PI * Math.pow(radius, 2)
    }

    public int getRadius() {
        return radius;
    }
}
