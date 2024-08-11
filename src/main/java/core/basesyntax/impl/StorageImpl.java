package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int STORAGE_VOLUME = 10;
    private final Object[] arrayKey;
    private final Object[] arrayValue;

    public StorageImpl() {
        arrayKey = new Object[STORAGE_VOLUME];
        arrayValue = new Object[STORAGE_VOLUME];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < STORAGE_VOLUME; i++) {
            if (areBothKeyValueNull((K) arrayKey[i], (V) arrayValue[i])) {
                arrayKey[i] = key;
                arrayValue[i] = value;
                break;
            }

            if (isArrayKeyEqualKey((K) arrayKey[i], key)) {
                arrayValue[i] = value;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < STORAGE_VOLUME; i++) {
            if (isArrayKeyEqualKey((K) arrayKey[i], key)) {
                return (V) arrayValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < STORAGE_VOLUME; i++) {
            if (areBothKeyValueNull((K) arrayKey[i], (V) arrayValue[i])) {
                return i;
            }
        }
        return STORAGE_VOLUME;
    }

    private boolean areBothKeyValueNull(K key, V value) {
        return key == null && value == null;
    }

    private boolean isArrayKeyEqualKey(K stored, K next) {
        return stored == next || stored != null && stored.equals(next);
    }
}
