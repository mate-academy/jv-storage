package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private K key;
    private V value;
    private Object[] keyStorage;
    private Object[] valueStorage;

    public StorageImpl() {
        keyStorage = new Object[MAX_ITEMS_NUMBER];
        valueStorage = new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (key == null && keyStorage[i] == null) {
                valueStorage[i] = value;
                break;
            }
            if (keyStorage[i] == key) {
                valueStorage[i] = value;
                break;
            }
            if ((keyStorage[i] != null && keyStorage[i].equals(key))) {
                valueStorage[i] = value;
                break;
            }
            if (keyStorage[i] != key) {
                if (keyStorage[i] == null && valueStorage[i] == null) {
                    keyStorage[i] = key;
                    valueStorage[i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (keyStorage[i] == key) {
                return (V)valueStorage[i];
            }
            if ((keyStorage[i] != null && keyStorage[i].equals(key))) {
                return (V)valueStorage[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < valueStorage.length; i++) {
            if (valueStorage[i] == null) {
                return i;
            }
        }
        return 10;
    }

    @Override
    public boolean equals(Object key) {
        if (this == key) {
            return true;
        }
        if (!(key instanceof StorageImpl)) {
            return false;
        }
        StorageImpl<?, ?> storage = (StorageImpl<?, ?>) key;
        return Objects.equals(key, storage.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
