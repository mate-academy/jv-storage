package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Arrays;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private int counter = 0;
    private int size = 0;
    private Entry<K, V>[] kyeValues = new Entry[0];
    private Entry<K, V>[] kyeValuesCopy;

    @Override
    public void put(K key, V value) {
        if (counter == 0) {
            fillInKyeValues(key, value);
            return;
        }
        for (int i = 0; i < size; i++) {
            if (key == null && key == kyeValues[i].getKey()) {
                fillInKyeValues(key, value, i);
                return;
            } else if (key != null && key.equals(kyeValues[i].getKey())) {
                fillInKyeValues(key, value, i);
                return;
            }
        }
        fillInKyeValues(key, value);
    }

    private void fillInKyeValues(K key, V value) {
        kyeValuesCopy = Arrays.copyOf(kyeValues, ++size);
        kyeValuesCopy[counter] = new Entry<>(key, value);
        kyeValues = kyeValuesCopy;
        counter++;
    }

    private void fillInKyeValues(K key, V value, int iter) {
        kyeValuesCopy = Arrays.copyOf(kyeValues, size);
        kyeValuesCopy[iter] = new Entry<>(key, value);
        kyeValues = kyeValuesCopy;
    }

    @Override
    public V get(K key) {
        for (Entry en : kyeValues) {
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
        return size;
    }
}
