package core.basesyntax;

import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int INITIAL_CAPACITY = 10;
    private static final int MULTIPLIER = 2;
    private K[] keys;
    private V[] values;
    private int size;

    public StorageImpl() {
        keys = createKeyArray();
        values = createValueArray();
    }

    @SuppressWarnings("unchecked")
    private K[] createKeyArray() {
        return (K[]) new Object[StorageImpl.INITIAL_CAPACITY];
    }

    @SuppressWarnings("unchecked")
    private V[] createValueArray() {
        return (V[]) new Object[StorageImpl.INITIAL_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
        }
        keys[size] = key;
        values[size] = value;
        size++;
        if (size == keys.length) {
            keys = Arrays.copyOf(keys, size * MULTIPLIER);
            values = Arrays.copyOf(values, size * MULTIPLIER);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                return values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
