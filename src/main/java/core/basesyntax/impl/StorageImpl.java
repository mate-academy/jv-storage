package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int SIZE_BOX = 10;
    private final K[] keyBox;
    private final V[] valueBox;
    private int size = 0;

    public StorageImpl() {
        this.keyBox = (K[]) new Object[SIZE_BOX];
        this.valueBox = (V[]) new Object[SIZE_BOX];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((key == null && key == keyBox[i]) || (key != null && key.equals(keyBox[i]))) {
                valueBox[i] = value;
                return;
            }
        }
        keyBox[size] = key;
        valueBox[size] = value;
        size++;
        System.out.println(Arrays.toString(keyBox));
        System.out.println(Arrays.toString(valueBox));
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyBox.length; i++) {
            if (key == keyBox[i] || (keyBox[i] != null && keyBox[i].equals(key))) {
                return valueBox[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
