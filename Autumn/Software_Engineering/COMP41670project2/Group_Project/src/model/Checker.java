package model;

/**
 * @param color "white" or "red"
 */
public record Checker(String color) {

    @Override
    public String toString() {
        return this.color;
    }
}

