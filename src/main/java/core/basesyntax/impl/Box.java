package core.basesyntax.impl;

import core.basesyntax.Storage;

public class Box<K, V> implements Storage<K, V> {
    private String name;
    private int width;
    private int length;

    public Box() {
    }

    public Box(String name, int width, int length) {
        this.name = name;
        this.width = width;
        this.length = length;
    }

    @Override
    public void put(K key, V value) {

    }

    @Override
    public V get(K key) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public String toString() {
        return "Box{"
                + "name='" + name + '\''
                + ", width=" + width
                + ", length=" + length
                + '}';
    }
}
