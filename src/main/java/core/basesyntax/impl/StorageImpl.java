package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Pair<K, V>[] storage;
    private int currentElementsNumber = 0;

    public StorageImpl() {
        storage = new Pair[MAX_ITEMS_NUMBER];
    }

    @Override
    public void put(K key, V value) {
        if (currentElementsNumber < MAX_ITEMS_NUMBER) {
            for (int i = 0; i < currentElementsNumber; i++) {
                if (key == storage[i].getKey()
                        || (key != null && key.equals(storage[i].getKey()))) {
                    storage[i].setValue(value);
                    return;
                }
            }
            storage[currentElementsNumber] = new Pair<>(key, value);
            currentElementsNumber++;
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> element : storage) {
            if (element != null
                    && (key == element.getKey() || (key != null && key.equals(element.getKey())))) {
                return element.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return currentElementsNumber;
    }
}
