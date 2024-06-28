package core.basesyntax.impl;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private final K[] keys;
    private final V[] values;
    private int size;

    public StorageImpl() {
        this.keys = (K[]) new Object[MAX_CAPACITY];;
        this.values = (V[]) new Object[MAX_CAPACITY];
    }

    @Override
    public void put(K key, V value) {
        if (size >= MAX_CAPACITY) {
            throw new IndexOutOfBoundsException("Storage is full");
        }

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

    private boolean keysEqual(K key1, K key2) {
        return key1 == null ? key2 == null : key1.equals(key2);
    }
}
