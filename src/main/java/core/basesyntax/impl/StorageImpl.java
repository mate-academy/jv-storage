package core.basesyntax.impl;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_SIZE = 10;
    private K [] keys;
    private V [] values;
    private int size = 0;

    public StorageImpl() {
        this.values = (V[]) new Object[MAX_ARRAY_SIZE];
        this.keys = (K[]) new Object[MAX_ARRAY_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (key == keys[i] || key != null && key.equals(keys[i])) {
                values[i] = value;
                return;
            }
            }
            if (MAX_ARRAY_SIZE <= size) {
                throw new RuntimeException("Storage is full !");
            }
            keys[size] = key;
            values[size] = value;
            size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if ((key == keys[i]) || (key != null && key.equals(keys[i]))) {
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
