package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_NUMBER_OF_ELEMENTS = 10;
    private final K[] keysStorage = (K[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private final V[] valuesStorage = (V[]) new Object[MAX_NUMBER_OF_ELEMENTS];
    private int index = 0;
    private boolean isNullKeyPresent = false;

    @Override
    public void put(K key, V value) {
        if (key == null) {
            if (!isNullKeyPresent) {
                this.keysStorage[index] = key;
                this.valuesStorage[index] = value;
                index++;
                isNullKeyPresent = true;
            } else {
                changeValueBySameKey(key, value);
            }
        } else {
            if (findSameKey(key, this.keysStorage)) {
                changeValueBySameKey(key, value);
            } else {
                this.keysStorage[index] = key;
                this.valuesStorage[index] = value;
                index++;
            }
        }
    }

    @Override
    public V get(K key) {
        int index = findValueIndexByKey(key, this.keysStorage);
        return index == -1 ? null : this.valuesStorage[index];
    }

    @Override
    public int size() {
        return index;
    }

    private void changeValueBySameKey(K key, V value) {
        for (int i = 0; i < this.keysStorage.length; i++) {
            if (Objects.equals(this.keysStorage[i], key)) {
                this.valuesStorage[i] = value;
            }
        }
    }

    private boolean findSameKey(K key, K[] keysStorage) {
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

    private int findValueIndexByKey(K key, K[] keysStorage) {
        int index = 0;
        for (K currentKey : keysStorage) {
            if (Objects.equals(currentKey, key)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}
