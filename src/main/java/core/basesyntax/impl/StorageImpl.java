package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    private int counter = 0;
    private int size = 1;
    private Entry<K, V>[] kyeValues = new Entry[10];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if ((kyeValues[i] == null)
                    || (key == null && kyeValues[i].getKey() == null)
                    || (key != null && kyeValues[i].getKey() != null
                    && kyeValues[i].getKey().equals(key))) {
                if (kyeValues[i] == null) {
                    counter++;
                }
                kyeValues[i] = new Entry<>(key, value);
                return;
            }
        }
        size++;
        kyeValues[counter] = new Entry<>(key, value);
        counter++;
    }

    @Override
    public V get(K key) {
        for (Entry en : kyeValues) {
            if (en == null) {
                return null;
            }
            if ((en.getKey() == null && key == null)
                    || ((key != null && en.getKey() != null)
                    && en.getKey().equals(key))) {
                return (V) en.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return counter;
    }
}
