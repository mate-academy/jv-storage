package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keyStorage = new Object[10];
    private Object[] valueStorage = new Object[10];
    private int index;

    @Override
    public void put(K key, V value) {
        if (find(key)) {
            for (int i = 0; i < keyStorage.length; i++) {
                if (Objects.equals(keyStorage[i], key)) {
                    valueStorage[i] = value;
                }
            }
        } else {
            keyStorage[index] = key;
            valueStorage[index] = value;
            index++;
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.length; i++) {
            if (Objects.equals(keyStorage[i], key)) {
                return (V) valueStorage[i];
            }
        }
        return null;
    }

    private boolean find(K key) {
        for (Object el : keyStorage) {
            if (Objects.equals(el, key)) {
                return true;
            }
        }
        return false;
    }
}
