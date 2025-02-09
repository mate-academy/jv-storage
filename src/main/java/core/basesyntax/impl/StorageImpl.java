package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private static int index = 0;
    private K[] keyValues = new K[10];
    private V[] valueValues = new V[10];
    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;
        keyValues[index] = key;
        valueValues[index] = value;
        index++;
    }

    @Override
    public V get(K key) {
        int keyIndex = 0;
        for (int i = 0; i < keyValues.length; i++) {
            if (keyValues[i].equals(key)) {
                keyIndex = i;
            }
        }
        return valueValues[keyIndex];
    }

    @Override
    public int size() {
        return -1;
    }
}
