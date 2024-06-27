package core.basesyntax.impl;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final Object[] keys;
    private final Object[] values;
    private int size;

    public StorageImpl() {
        this.keys = new Object[MAX_CAPACITY];
        this.values = new Object[MAX_CAPACITY];
        this.size = 0;
    }

    private boolean keysEqual(K key1, K key2) {
        return key1 == null ? key2 == null : key1.equals(key2);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keysEqual((K) keys[i], key)) {
                values[i] = value;
                return;
            }
        }
        if (size < MAX_CAPACITY) {
            keys[size] = key;
            values[size] = value;
            size++;
        } else {
            throw new RuntimeException("Storage capacity exceeded");
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keysEqual((K) keys[i], key)) {
                return (V) values[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
