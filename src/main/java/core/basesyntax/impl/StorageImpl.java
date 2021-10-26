package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int FULLSIZE = 10;
    private StorageImpl[] bigStorage = new StorageImpl[FULLSIZE];
    private K key;
    private V value;

    public StorageImpl() {
    }

    public StorageImpl(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public StorageImpl(V value) {
        this.value = value;
    }

    public static <K, V> StorageImpl<K, V> of(K key, V value) {
        return new StorageImpl<>(key, value);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < FULLSIZE; i++) {
            if (bigStorage[i] == null || (bigStorage[i].key != null
                    && bigStorage[i].key.equals(key))
                    || bigStorage[i].key == null && bigStorage[i].key == key) {
                bigStorage[i] = StorageImpl.of(key, value);
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < FULLSIZE; i++) {
            if (bigStorage[i] != null && bigStorage[i].key != null
                    && bigStorage[i].key.equals(key)) {
                return (V) bigStorage[i].value;
            } else if (bigStorage[i] != null && bigStorage[i].key == key) {
                return (V) bigStorage[i].value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < FULLSIZE; i++) {
            if (bigStorage[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
