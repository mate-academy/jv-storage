package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private int index = 0;
    private Object[] keyValues = new Object[11];
    private Object[] valueValues = new Object[11];
    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(keyValues[i], key)) {
                valueValues[i] = value;
                return;
            }
        }
        this.key = key;
        this.value = value;
        keyValues[index] = key;
        valueValues[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (Objects.equals(keyValues[i], key)) {
                return (V) valueValues[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
