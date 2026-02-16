package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keyStorage;
    private V[] valueStorage;

    @Override
    public void put(K key, V value) {
        if (keyStorage == null) {
            keyStorage = (K[]) new Object[]{key};
            valueStorage = (V[]) new Object[]{value};

            return;
        }

        int keyIndex = getKeyIndex(key);
        if (keyIndex != -1) {
            valueStorage[keyIndex] = value;
        } else {
            keyStorage = Arrays.copyOf(keyStorage, keyStorage.length + 1);
            keyStorage[keyStorage.length - 1] = key;

            valueStorage = Arrays.copyOf(valueStorage, valueStorage.length + 1);
            valueStorage[valueStorage.length - 1] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = getKeyIndex(key);
        return (keyIndex == -1) ? null : valueStorage[keyIndex];
    }

    @Override
    public int size() {
        return keyStorage == null ? 0 : keyStorage.length;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if ((key == null) && (keyStorage[i] != null)
                    || (key != null) && (keyStorage[i] == null)
            ) {
                continue;
            }
            if ((keyStorage[i] == null) && (key == null) || keyStorage[i].equals(key)) {
                return i;
            }
        }
        return -1;
    }
}
