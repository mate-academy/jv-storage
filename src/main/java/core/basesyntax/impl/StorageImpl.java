package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static StorageImpl[] collection = new StorageImpl[10];

    private K key;
    private V value;

    public StorageImpl() {
    }

    private StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < collection.length; ++i) {
            if (collection[i] == null || collection[i].key == key) {
                collection[i] = new StorageImpl<>(key, value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        V val = null;

        for (int i = 0; i < collection.length; ++i) {
            if (collection[i] != null
                    && (collection[i].key == key
                    || collection[i].key.equals(key))) {
                val = (V) collection[i].value;
            }
        }
        return val;
    }
}
