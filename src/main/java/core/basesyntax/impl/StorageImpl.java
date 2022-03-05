package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {

    public static final int MAX_SIZE = 10;
    private K[] keyArray = (K[]) new Object[MAX_SIZE];
    private V[] valueArray = (V[]) new Object[MAX_SIZE];
    private int count;

    @Override
    public void put(Object key, Object value) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i] == key || key != null && key.equals(keyArray[i])) {
                valueArray[i] = (V) value;
                return;
            }
        }
        keyArray[count] = (K) key;
        valueArray[count] = (V) value;
        count++;
    }

    @Override
    public Object get(Object key) {
        for (int i = 0; i < count; i++) {
            if (keyArray[i] == key || key != null && key.equals(keyArray[i])) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        return count;
    }
}
