package core.basesyntax.impl;

import core.basesyntax.KeyValue;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    private final KeyValue<K, V>[] store;
    private int size = 0;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.store = new KeyValue[MAX_SIZE];
    }

    @Override
    public void put(K key, V value) {
        if (size < store.length) {
            for (int i = 0; i < store.length; i++) {
                if (store[i] == null) {
                    store[i] = new KeyValue<>(key, value);
                    size++;
                    return;
                } else {
                    K storeKey = store[i].getKey();
                    if (isStoreKeyEqual(storeKey, key)) {
                        store[i].setValue(value);
                        return;
                    }
                }
            }
        } else {
            throw new RuntimeException("The storage is full!");
        }
    }

    @Override
    public V get(K key) {
        for (KeyValue<K, V> element : store) {
            if (element != null) {
                K storeKey = element.getKey();
                if (isStoreKeyEqual(storeKey, key)) {
                    return element.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private boolean isStoreKeyEqual(K storeKey, K key) {
        return ((storeKey == key) || storeKey != null
                && storeKey.equals(key));
    }
}
