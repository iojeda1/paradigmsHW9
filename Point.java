import java.util.Objects;

public class Point {
    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object other) {
        // reflexive
        if (other == this)
            return true;
        // non-null
        if (other == null)
            return false;
        // don't even bother! they have different types
        if (getClass() != other.getClass())
            return false;
        Point point = (Point) other; // why do we need this type cast?
        int thisDistance = (this.x * this.x) + (this.y * this.y);
        int otherDistance = (point.x * point.x) + (point.y * point.y);
        return thisDistance == otherDistance;
    }

    @Override
    public int hashCode() { // update hash code
        int dist = (x * x) + (y * y);
        return Objects.hash(dist);
    }

    @Override
    public String toString() {
        return "[" + x + ", " + y + "]";
    }

    public static void main(String[] args) {
        Point p1 = new Point(2, 3); // distance^2 = 13
        Point p2 = new Point(-3, 1); // distance^2 = 10
        Point p3 = new Point(-2, -3); // distance^2 = 13

        System.out.println(p1.equals(p2)); // false
        System.out.println(p1.equals(p3)); // true
        System.out.println(p1.equals(null)); // false
        System.out.println(p1.equals(p1)); // true

    }
}