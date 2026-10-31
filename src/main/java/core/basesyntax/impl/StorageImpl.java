package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keys;
    private V[] values;

    @Override
    public void put(K key, V value) {
        if (this.keys.length < 10) {
            this.keys[this.keys.length] = key;
            this.values[this.keys.length] = value;
        }
    }

    @Override
    public V get(K key) {
        int i = 0;
        for (K keyElement : this.keys) {
            if (keyElement == key) {
                break;
            }
            i++;
        }
        return this.values[i];
    }

    @Override
    public int size() {
        int i = 0;
        if (this.keys == null) {
            return 0;
        }
        for (K key : this.keys) {
            i++;
        }
        return i;
    }
}
