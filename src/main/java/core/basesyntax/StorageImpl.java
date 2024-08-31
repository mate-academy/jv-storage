package core.basesyntax;

import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_SIZE = 10;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = (K[]) new Object[MAX_SIZE];
        values = (V[]) new Object[MAX_SIZE];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    values[i] = value;
                    return;
                }
            }
            if (size < MAX_SIZE) {
                keys[size] = null;
                values[size] = value;
                size++;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(keys[i], key)) {
                    values[i] = value;
                    return;
                }
            }
            if (size < MAX_SIZE) {
                keys[size] = key;
                values[size] = value;
                size++;
            }
        }
    }

    @Override
    public V get(K key) {
        if (key == null) {
            for (int i = 0; i < size; i++) {
                if (keys[i] == null) {
                    return values[i];
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (Objects.equals(keys[i], key)) {
                    return values[i];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
