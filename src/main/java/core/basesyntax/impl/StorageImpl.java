package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_SIZE = 10;
    private static final Object[] KEY_ARRAY = new Object[STORAGE_SIZE];
    private static final Object[] VALUE_ARRAY = new Object[STORAGE_SIZE];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < KEY_ARRAY.length; i++) {
            if (KEY_ARRAY[i] == null && VALUE_ARRAY[i] != null) {
                continue;
            }
            if (KEY_ARRAY[i] == null) {
                KEY_ARRAY[i] = key;
                VALUE_ARRAY[i] = value;
                break;
            }
            if (KEY_ARRAY[i].equals(key)) {
                VALUE_ARRAY[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < KEY_ARRAY.length; i++) {
            if (key == null && KEY_ARRAY[i] == null) {
                return (V) VALUE_ARRAY[i];
            }
            if (KEY_ARRAY[i] != null && KEY_ARRAY[i].equals(key)) {
                return (V) VALUE_ARRAY[i];
            }
        }
        return null;
    }
}
