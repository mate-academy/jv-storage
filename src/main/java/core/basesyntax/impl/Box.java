package core.basesyntax.impl;

public class Box {
    private BoxColors color;

    private Box(BoxColors color) {
        this.color = color;
    }

    public static Box createNewBox(BoxColors color) {
        return new Box(color);
    }

    @Override
    public String toString() {
        return "Box{"
                + "color='"
                + color.name().toLowerCase()
                + '\''
                + '}';
    }
}
