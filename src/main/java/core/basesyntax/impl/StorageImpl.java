package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_NUMBER = 10;
    private final K[] key;
    private final V[] value;
    private int index = 0;

    public StorageImpl() {
        this.key = (K[]) new Object[MAXIMUM_NUMBER];
        this.value = (V[]) new Object[MAXIMUM_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < index; i++) {
            if (isKeyEquals(key, this.key[i])) {
                this.value[i] = value;
                return;
            }
        }
        this.key[index] = key;
        this.value[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < index; i++) {
            if (isKeyEquals(key, this.key[i])) {
                return this.value[i];
            }
        }
        return null;
    }

    public K[] getKey() {
        return key;
    }

    public V[] getValue() {
        return value;
    }

    private boolean isKeyEquals(K key, K key2) {
        return (key == null && key2 == null)
                || (key != null && key.equals(key2));
    }
}
