package core.basesyntax.impl;

public class Box {
    private String color;

    private Box(String color) {
        this.color = color;
    }

    public static Box createNewBox(String color) {
        return new Box(color);
    }

    @Override
    public String toString() {
        return "Box{"
                + "color='"
                + color
                + '\''
                + '}';
    }
}
