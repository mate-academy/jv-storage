package core.basesyntax.impl;

public class Box {
    private String id;

    public Box() {
        this.id = "Box1";
    }

    @Override
    public String toString() {
        return "Box{id='" + id + "'}";
    }
}
