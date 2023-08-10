package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object [] massivKey = new Object[10];
    private Object [] massivValue = new Object[10];
    private int count;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < count; i++) {
            if ((massivKey[i] == key) || (massivKey[i] != null && massivKey[i].equals(key))) {
                massivKey[i] = key;
                massivValue[i] = value;
                return;
            }
        }
        massivKey[count] = key;
        massivValue[count] = value;
        count++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < count; i++) {
            if ((massivKey[i] == key) || (massivKey[i] != null && massivKey[i].equals(key))) {
                return (V) massivValue[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
