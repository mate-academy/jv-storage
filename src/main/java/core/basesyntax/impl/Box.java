package core.basesyntax.impl;

public class Box {
    private int number;

    public Box(int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Box{" + "number=" + number + '}';
    }
}
