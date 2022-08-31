package core.basesyntax.impl;

import core.basesyntax.Storage;

@SuppressWarnings("unchecked") // do not remove this line

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ARRAY_ELEMENTS = 10;
    private K key;
    private V value;
    private K[] keyArray = (K[]) new Object[MAX_ARRAY_ELEMENTS];
    private V[] valueArray = (V[]) new Object[MAX_ARRAY_ELEMENTS];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyArray.length; i++) {
            if ((keyArray[i] == null && valueArray[i] == null)
                    || (key != null && key.equals(keyArray[i]))
                    || (key == null && keyArray[i] == null)) {
                keyArray[i] = key;
                valueArray[i] = value;
                return;
            }
        }
        throw new RuntimeException("Can't put the data into a Storage - Storage is full ");
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyArray.length; i++) {
            if (key != null && key.equals(keyArray[i])
                    || (key == null && keyArray[i] == null)) {
                return valueArray[i];
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (int i = 0; i < valueArray.length; i++) {
            if (valueArray[i] == null) {
                return i;
            }
        }
        return 0;
    }
}
