package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int ARRAY_COUNT = 10;
    private Object[] keyArray = new Object[ARRAY_COUNT];
    private Object[] valueArray = new Object[ARRAY_COUNT];

    public Object keyPresentNumber(K key) {
        for (int i = 0; keyArray.length > i; i++) {
            if ((key == null ? 0 : key.hashCode())
                    == (keyArray[i] == null ? 0 : keyArray[i].hashCode())) {
                return i;
            }
        }
        return null;
    }

    @Override
    public void put(K key, V value) {
        Object keyPresentNumber = keyPresentNumber(key);
        if (keyPresentNumber != null) {
            keyArray[(int) keyPresentNumber] = key == null ? 0 : key.hashCode();
            valueArray[(int) keyPresentNumber] = value;
        } else {
            for (int i = 0; i < ARRAY_COUNT; i++) {
                if (keyArray[i] == null) {
                    keyArray[i] = key == null ? 0 : key.hashCode();
                    valueArray[i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        return keyPresentNumber(key) == null ? null : (V) valueArray[(int) keyPresentNumber(key)];
    }

    @Override
    public int size() {
        int storageNullElementsNumber = 0;
        for (Object currentkey : keyArray) {
            if (currentkey == null) {
                storageNullElementsNumber += 1;
            }
        }
        return keyArray.length - storageNullElementsNumber;
    }
}
