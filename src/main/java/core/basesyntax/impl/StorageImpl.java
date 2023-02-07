package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_STORAGE_SIZE = 10;
    private final K[] keyItem = (K[]) new Object[MAX_STORAGE_SIZE];
    private final V[] itemPair = (V[]) new Object[MAX_STORAGE_SIZE];
    private int elementNumber = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < elementNumber; i++) {
            if (Objects.equals(key, keyItem[i])) {
                itemPair[i] = value;
                elementNumber--;
            }
        }
        keyItem[elementNumber] = key;
        itemPair[elementNumber] = value;
        elementNumber++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyItem.length; i++) {
            if (Objects.equals(key, keyItem[i])) {
                return itemPair[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return elementNumber--;
    }
}
