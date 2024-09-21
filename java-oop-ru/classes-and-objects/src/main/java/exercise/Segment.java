package exercise;

import lombok.Getter;

@Getter
public class Segment {
    private Point beginPoint;
    private Point endPoint;
    private Point midPoint;

    public Segment(Point begin, Point end) {
        beginPoint = begin;
        endPoint = end;
    }

    public Point getMidPoint() {
        var midPointX = (beginPoint.getX() + endPoint.getX()) / 2;
        var midPointY = (beginPoint.getY() + endPoint.getY()) / 2;
        return new Point(midPointX, midPointY);
    }
}
