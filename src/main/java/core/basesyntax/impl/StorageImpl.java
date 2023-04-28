package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_COUNT = 10;
    private final Object[] keyArray = new Object[ARRAY_COUNT];
    private final Object[] valueArray = new Object[ARRAY_COUNT];
    private int size = 0;

    public int keyPresentNumber(K key) {
        for (int i = 0; keyArray.length > i; i++) {
            if ((key == null ? 0 : key.hashCode())
                    == (keyArray[i] == null ? 0 : keyArray[i].hashCode())) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        int keyPresentNumber = keyPresentNumber(key);
        if (keyPresentNumber != -1) {
            size = keyArray[keyPresentNumber] == null ? size += 1 : size;
            keyArray[keyPresentNumber] = key == null ? 0 : key.hashCode();
            valueArray[keyPresentNumber] = value;
        } else {
            for (int i = 0; i < ARRAY_COUNT; i++) {
                if (keyArray[i] == null) {
                    keyArray[i] = key == null ? 0 : key.hashCode();
                    valueArray[i] = value;
                    size += 1;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        return keyPresentNumber(key) == -1 ? null : (V) valueArray[keyPresentNumber(key)];
    }

    @Override
    public int size() {
        return size;
    }
}
