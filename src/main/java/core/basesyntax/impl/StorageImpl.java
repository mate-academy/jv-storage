package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private K[] key;
    private V[] value;
    private int size = 0;

    public StorageImpl() {
        value = (V[]) new Object[MAX_SIZE];
        key = (K[]) new Object[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (compareValue(this.key[i], key)) {
                this.value[i] = value;
                return;
            }
        }
        this.key[size] = key;
        this.value[size] = value;
        size++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (compareValue(this.key[i], key)) {
                return (V) value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean compareValue(Object object1, Object object2) {
        return object1 == object2 || object1 != null && object1.equals(object2);
    }
}
