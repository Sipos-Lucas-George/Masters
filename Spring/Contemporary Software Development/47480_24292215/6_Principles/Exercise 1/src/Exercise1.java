
public class Exercise1 {
  public static void main(String[] args) {
    Shape square = new Square(9.1);
    Shape circle = new Circle(5.05);
    PostageStamp stamp1 = new PostageStamp(square);
    PostageStamp stamp2 = new PostageStamp(circle);
    System.out.println(stamp1.toString());
    System.out.println(stamp2.toString());
  }
}
