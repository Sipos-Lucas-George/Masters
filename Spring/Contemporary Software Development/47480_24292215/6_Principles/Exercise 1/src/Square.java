
class Square implements Shape {
  public Square(double length) {
    this.length = length;
  }
  
  public String toString() {
    return "square, side of length " + length;
  }
  
  private double length;
}