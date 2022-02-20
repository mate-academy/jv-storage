package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

@SuppressWarnings("unchecked")
public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final K[] itemsKey;
    private final V[] itemsValye;
    private int lengthPair;

    public StorageImpl() {
        itemsKey = (K[]) new Object[MAX_ITEMS_NUMBER];
        itemsValye = (V[]) new Object[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < itemsKey.length; i++) {
            if (Objects.equals(itemsKey[i], key) && get(key) != null) {
                itemsValye[i] = value;
                return;
            }
        }
        itemsKey[lengthPair] = key;
        itemsValye[lengthPair] = value;
        lengthPair++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < itemsKey.length; i++) {
            if (Objects.equals(itemsKey[i], key)) {
                return itemsValye[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return lengthPair;
    }
}
