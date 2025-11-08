
public class PostageStamp{
  public PostageStamp(Shape shape) {
    this.shape = shape;
  }
  
  public String toString() {
    return "stamp, contained in a " + shape.toString();
  }

  Shape shape;
}
