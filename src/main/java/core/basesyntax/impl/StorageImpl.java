package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private Pair<K, V>[] items = new Pair[10];
    private int count = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if (key == null ? items[i].getKey() == null : key.equals(items[i].getKey())) {
                items[i].setValue(value);
                return;
            }
        }
        items[count] = new Pair<>(key, value);
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if (key == null ? items[i].getKey() == null : key.equals(items[i].getKey())) {
                return items[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
