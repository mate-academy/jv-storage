package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keysStorage;
    private V[] valuesStorage;

    @SuppressWarnings("unchecked")

    @Override
    public void put(K key, V value) {
        if (findSameKey(key, this.keysStorage)) {
            changeValueBySameKey(key, this.keysStorage, value, this.valuesStorage);
        } else {
            this.keysStorage = resizeKeyStorage(key, this.keysStorage);
            this.valuesStorage = resizeValueStorage(value, this.valuesStorage);
        }
    }

    @Override
    public V get(K key) {
        int index = findValueIndexByKey(key, this.keysStorage);
        if (index == -1) {
            return null;
        }
        return this.valuesStorage[index];
    }

    @Override
    public int size() {
        return this.keysStorage == null ? 0 : this.keysStorage.length;
    }

    public K[] resizeKeyStorage(K key, K[] storage) {
        if (storage == null || storage.length == 0) {
            storage = (K[]) new Object[1];
            storage[0] = key;
        } else {
            K[] tempArray = storage;
            storage = (K[]) new Object[tempArray.length + 1];
            for (int i = 0; i < tempArray.length; i++) {
                storage[i] = tempArray[i];
            }
            storage[tempArray.length] = key;
        }
        return storage;
    }

    public V[] resizeValueStorage(V value, V[] storage) {
        if (storage == null || storage.length == 0) {
            storage = (V[]) new Object[1];
            storage[0] = value;
        } else {
            V[] tempArray = storage;
            storage = (V[]) new Object[tempArray.length + 1];
            for (int i = 0; i < tempArray.length; i++) {
                storage[i] = tempArray[i];
            }
            storage[tempArray.length] = value;
        }
        return storage;
    }

    public V[] changeValueBySameKey(K key, K[] keysStorage, V value, V[] valuesStoragestorage) {
        for (int i = 0; i < this.keysStorage.length; i++) {
            if (Objects.equals(this.keysStorage[i], key)) {
                this.valuesStorage[i] = value;
            }
        }
        return this.valuesStorage;
    }

    public boolean findSameKey(K key, K[] keysStorage) {
        if (keysStorage == null) {
            return false;
        }
        for (K currentKey : keysStorage) {
            if (Objects.equals(currentKey, key)) {
                return true;
            }
        }
        return false;
    }

    public int findValueIndexByKey(K key, K[] keysStorage) {
        for (int i = 0; i < keysStorage.length; i++) {
            if (keysStorage[i] == null && key == null) {
                return i;
            } else if (keysStorage[i] != null && keysStorage[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
