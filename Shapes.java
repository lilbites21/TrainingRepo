public abstract class Shapes {
    public abstract double getArea();

    public interface Colorable {
        void setColor(Color color);
    }

    public interface Sided {
        int getSides();
    }

    public class Color {
        int r;
        int g;
        int b;

        public Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }
    }

    public class Circle extends Shapes implements Colorable {
        private double radius;
        private double PI = Math.PI;
        private Color color;

        public Circle(double radius) {
            this.radius = radius;
        }

        public double getArea() {
            return PI * radius * radius;
        }

        public void setColor(Color color) {
            this.color = color;
        }
    }

    public class Triangle extends Shapes implements Colorable, Sided {
        private double base;
        private double height;
        private Color color;

        public Triangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        public double getArea() {
            return (base * height) / 2;
        }

        public void setColor(Color color) {
            this.color = color;
        }

        public int getSides() {
            return 3;
        }
    }

    public class Rectangle extends Shapes implements Sided {
        private double base;
        private double height;

        public Rectangle(double base, double height) {
            this.base = base;
            this.height = height;
        }

        public double getArea() {
            return (base * height);
        }

        public int getSides() {
            return 4;
        }
    }
}