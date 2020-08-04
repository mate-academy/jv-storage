package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[][] box;

    public StorageImpl() {
        box = new Object[2][10];
    }

    @Override
    public void put(K key, V value) {
        if (value == null) {
            return;
        }
        boolean isKeyPresent = false;
        for (int i = 0; i < 10; i++) {
            if (box[0][i] == key) {
                box[1][i] = value;
                isKeyPresent = true;
            }
        }
        if (!isKeyPresent) {
            for (int i = 0; i < 10; i++) {
                if (box[0][i] == null) {
                    box[0][i] = key;
                    box[1][i] = value;
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < 10; i++) {
            if (box[0][i] == key
                    || box[0][i] != null && box[0][i].equals(key)) {
                return (V) box[1][i];
            }
        }
        return null;
    }
}
