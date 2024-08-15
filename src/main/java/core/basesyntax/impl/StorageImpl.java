package core.basesyntax.impl;

import core.basesyntax.KeyValue;
import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    @SuppressWarnings("unchecked")
    private final KeyValue<K, V>[] store = new KeyValue[MAX_SIZE];
    private int size;

    public StorageImpl() {
        this.size = 0;
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
                    if ((store[i].getKey() == key) || store[i].getKey() != null
                            && store[i].getKey().equals(key)) {
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
            if (element != null && ((element.getKey() == key)
                    || element.getKey() != null
                    && element.getKey().equals(key))) {
                return element.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
