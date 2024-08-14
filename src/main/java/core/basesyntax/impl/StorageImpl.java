package core.basesyntax.impl;

import core.basesyntax.KeyValue;
import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    public static final int MAX_SIZE = 10;
    public static final int ZERO = 0;
    private final KeyValue<K, V>[] store;
    private int size;

    @SuppressWarnings("unchecked")
    public StorageImpl() {
        this.store = new KeyValue[MAX_SIZE];
        this.size = ZERO;
    }

    @Override
    public void put(K key, V value) {
        if (size < store.length) {
            for (int i = 0; i < store.length; i++) {
                if (store[i] == null) {
                    store[i] = new KeyValue<>(key, value);
                    size++;
                    return;
                }
                if (store[i] != null && Objects.equals(store[i].getKey(), key)) {
                    store[i].setValue(value);
                    return;
                }
            }
        } else {
            System.out.println("Full storage!");
        }
    }

    @Override
    public V get(K key) {
        for (KeyValue<K, V> element : store) {
            if (element != null && Objects.equals(element.getKey(), key)) {
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
