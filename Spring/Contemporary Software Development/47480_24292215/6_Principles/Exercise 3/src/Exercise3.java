
// With thanks to Vlad O. for the example

interface ICanView {
  void viewPost();
}

interface ICanEdit {
  void editPost();
}

interface ICanBlock {
  void blockPost();
}

class Admin implements ICanView, ICanEdit, ICanBlock {
  public void viewPost() {}
  public void editPost() {}
  public void blockPost() {}
}

class Writer implements ICanView, ICanEdit {
  public void viewPost() {}
  public void editPost() {}
}

class Reader implements ICanView {
  public void viewPost() {}
}

public class Exercise3 {
  public static void main(String[] args) {
    System.out.println("Exercise 3");
  }
}