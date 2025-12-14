public class Rectangle {
    private double width;
    private double height;
    private int id;
    private static int idGen = 1;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        this.id = idGen++;
    }

    public Rectangle(double width, double height) {
        this();
        setHeight(height);
        setWidth(width);
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public void setWidth(double newWidth) {
        if (newWidth <= 0) {
            throw new IllegalArgumentException();
        }
        this.width = newWidth;
    }

    public void setHeight(double newHeight) {
        if (newHeight <= 0) {
            throw new IllegalArgumentException();
        }
        this.height = newHeight;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public String toString() {
        return String.format("rectangle => id = %d, width = %f, height = %f", id, width, height);
    }
}