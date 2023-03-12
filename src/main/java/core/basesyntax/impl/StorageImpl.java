package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] keyArray;
    private final V[] valueArray;
    private int itemsNumber = 0;

    public StorageImpl() {
        keyArray = (K[]) new Object[MAX_ITEMS_NUMBER];
        valueArray = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (putItemsCopy(key, value)) {
            return;
        }
        keyArray[itemsNumber] = key;
        valueArray[itemsNumber] = value;
        itemsNumber++;
    }

    private boolean putItemsCopy(K key, V value) {
        for (int i = 0; i < itemsNumber; i++) {
            if (Objects.equals(keyArray[i], key)) {
                valueArray[i] = value;
                return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < itemsNumber; i++) {
            if (Objects.equals(keyArray[i], key)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return itemsNumber;
    }
}
