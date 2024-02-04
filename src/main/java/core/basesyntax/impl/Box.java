package core.basesyntax.impl;

import java.util.Objects;

public class Box {
    private String name;
    private String color;

    public Box(String name, String color) {
        this.name = name;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Box box = (Box) o;
        return Objects.equals(name, box.name)
                && Objects.equals(color, box.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, color);
    }

    @Override
    public String toString() {
        return "Box{"
                + "name='" + name + '\''
                + ", color='" + color + '\''
                + '}';
    }
}
