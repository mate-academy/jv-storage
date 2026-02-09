package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K[] keyArray = (K[]) new Object[10];
    private V[] valueArray = (V[]) new Object[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(keyArray[i], key)) {
                valueArray[i] = value;
                return;
            }
        }
        for (int i = 0; i < keyArray.length; i++) {
            if (keyArray[i] == null && valueArray[i] == null) {
                keyArray[i] = key;
                valueArray[i] = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (Objects.equals(keyArray[i], key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        int counter = 0;
        for (int i = 0; i < keyArray.length; i++) {
            if (valueArray[i] != null) {
                counter++;
            }
        }
        return counter;
    }

}
