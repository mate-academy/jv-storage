package core.basesyntax;

import java.util.Objects;

public class Cat {
    private final int specNum17 = 17;
    private final int specNum31 = 31;
    private final int fieldNullNum = 0;
    private String name;
    private String color;

    public Cat(String name, String color) {
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
        Cat cat = (Cat) o;
        return Objects.equals(this.name, cat.name)
                && Objects.equals(this.color, cat.color);
    }

    @Override
    public int hashCode() {
        int result = specNum17;
        result = specNum31 * result + (name == null ? fieldNullNum : name.hashCode());
        result = specNum31 * result + (color == null ? fieldNullNum : color.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Cat{"
                + "name='" + name + '\''
                + ", color='" + color + '\''
                + '}';
    }
}
