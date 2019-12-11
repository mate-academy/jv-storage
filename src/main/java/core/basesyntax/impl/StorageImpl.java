package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_SIZE = 10;
    private Object[] keyStorage = new Object[ARRAY_SIZE];
    private Object[] valueStorage = new Object[ARRAY_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < valueStorage.length; i++) {
            if (valueStorage[i] == null & keyStorage[i] == null | keyStorage[i] == key) {
                this.valueStorage[i] = value;
                this.keyStorage[i] = key;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (key == null && keyStorage[i] == null || key != null && key.equals(keyStorage[i])) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }
}
