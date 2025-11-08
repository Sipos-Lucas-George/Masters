package adt;

public interface BrowserNavigation {
    void visitPage(String url);
    void back() throws IllegalStateException;
    void forward() throws IllegalStateException;
    String toString();
}