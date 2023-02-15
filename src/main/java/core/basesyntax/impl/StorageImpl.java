package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH = 10;
    private V[] value;
    private K[] key;
    private int index;

    public StorageImpl() {
        value = (V[]) new Object[LENGTH];
        key = (K[])new Object[LENGTH];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (compareKeys(this.key[i], key)) {
                this.value[i] = value;
                return;
            }
        }
        this.key[index] = key;
        this.value[index] = value;
        index++;
    }

    private boolean compareKeys(Object first, Object second) {
        return (first == null || second == null)
                ? ((first == second) ? true : false) : first.equals(second);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (compareKeys(this.key[i], key)) {
                return value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return index;
    }
}
