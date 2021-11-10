public class Vector2 {
    public double x;
    public double y;

    public Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double magnitude() {
        return Math.sqrt((x * x + y * y));
    }

    public static double getMagnitude(Vector2 vec) {
        double x = vec.x;
        double y = vec.y;
        return Math.sqrt(x * x + y * y);
    }

    public void normalize() {
        x /= this.magnitude();
        y /= this.magnitude();
    }

    public void add(Vector2 vec) {
        x += vec.x;
        y += vec.x;
    }

    public static Vector2 addition(Vector2 vec1, Vector2 vec2) {
        return new Vector2(vec1.x + vec2.x, vec1.y + vec2.y);
    }

    public void multipy(double num) {
        x = x * num;
        y = y * num;
    }

    public void divition(double num) {
        x = x / num;
        y = y / num;
    }
}
