package core.basesyntax.impl;

public class Box {
    private int key;
    private String value;

    public Box(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static Box of(int key, String value) {
        return new Box(key, value);
    }

    @Override
    public String toString() {
        return "Box{" +
                "key=" + key +
                ", value='" + value + '\'' +
                '}';
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
