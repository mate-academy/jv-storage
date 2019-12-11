package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private int counter = 0;
    private final int storageSize = 10;
    private Object[] key = new Object[storageSize];
    private Object[] value = new Object[storageSize];

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {

        for (int i = 0; i < counter; i++) {

            if (this.key[i] == key || this.key[i] != null && (this.key[i]).equals(key)) {
                this.value[i] = value;
                return;
            }
        }
        if (counter == storageSize) {
            return;
        } else {
            this.value[counter] = value;
            this.key[counter] = key;
            ++counter;
        }
    }

    @Override
    public V get(K key) {

        for (int i = 0; i < counter; i++) {
            if (this.key[i] == key || this.key[i].equals(key)) {
                return (V) value[i];
            }
        }
        return null;
    }
}
