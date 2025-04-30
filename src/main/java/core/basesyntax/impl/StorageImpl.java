package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys;
    private Object[] values;
    private int index;

    public StorageImpl() {
        int maxArrSize = 10;
        this.keys = new Object[maxArrSize];
        this.values = new Object[maxArrSize];
        this.index = 0;
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < index; i++) {
            if (Objects.equals(keys[i], key)) {
                values[i] = value;
                return;
            }
        }

        keys[index] = key;
        values[index] = value;
        index++;

    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
