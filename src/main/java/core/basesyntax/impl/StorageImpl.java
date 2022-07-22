package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] key = new Object[10];
    private Object[] value = new Object[10];
    private int sizeCounter = 0;

    @Override
    public void put(K key, V value) {
        if (get(key) == null) {
            this.key[sizeCounter] = key;
            this.value[sizeCounter] = value;
            sizeCounter++;
        } else {
            for (int i = 0; i < sizeCounter; i++) {
                this.value[i] = value;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < sizeCounter; i++) {
            if ((key == null) && (this.key[i] == null)) {
                return (V) value[i];
            } else if (this.key[i] == null) {
                continue;
            }
            if (this.key[i].equals(key)) {
                return (V) value[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return sizeCounter;
    }
}
