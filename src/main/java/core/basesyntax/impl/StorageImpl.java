package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ELEMENT_NUMBER = 10;
    private final K[] keyStorages;
    private final V[] valueStorages;
    private int counter = 0;

    public StorageImpl() {
        keyStorages = (K[]) new Object[MAX_ELEMENT_NUMBER];
        valueStorages = (V[]) new Object[MAX_ELEMENT_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < counter; i++) {
            if (keyAlreadyExist(key, i)) {
                valueStorages[i] = value;
                return;
            }
        }
        keyStorages[counter] = key;
        valueStorages[counter] = value;
        counter++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < counter; i++) {
            if (keyAlreadyExist(key, i)) {
                return valueStorages[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }

    private boolean keyAlreadyExist(K key, int i) {
        return Objects.equals(keyStorages[i], key);
    }
}
