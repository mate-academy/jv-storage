package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int LENGTH_ARRAY = 10;
    private int counter = 0;
    private Object[] key = new Object[LENGTH_ARRAY];
    private Object[] value = new Object[LENGTH_ARRAY];

    @Override
    public void put(K key, V value) {
        boolean check = false;
        for (int i = 0; i < LENGTH_ARRAY; i++) {
            if (this.key[i] == key || key != null && key.equals(this.key[i])) {
                this.value[i] = value;
                check = true;
            }
        }
        if (!check) {
            this.key[counter] = key;
            this.value[counter] = value;
            counter++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < LENGTH_ARRAY; i++) {
            if (this.key[i] == key || key != null && key.equals(this.key[i])) {
                return (V) this.value[i];
            }
        }
        return null;
    }
}
