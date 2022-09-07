package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int KEY_INDEX = 0;
    private static final int VALUE_INDEX = 1;
    private final Object[][] objects;
    private int size;

    public StorageImpl() {
        this.objects = new Object[2][10];
        this.size = 0;
    }

    @Override
    public void put(K key, V value) {
        int index = this.getKeyIndex(key);
        if (index == -1) {
            objects[KEY_INDEX][size] = key;
            objects[VALUE_INDEX][size] = value;
            size++;
        } else {
            objects[VALUE_INDEX][index] = value;
        }
    }

    @Override
    public V get(K key) {
        int keyIndex = this.getKeyIndex(key);
        return keyIndex != -1 ? (V) objects[VALUE_INDEX][keyIndex] : null;
    }

    @Override
    public int size() {
        return size;
    }

    private int getKeyIndex(K key) {
        for (int i = 0; i < size; i++) {
            if (key == objects[KEY_INDEX][i] || key != null && key.equals(objects[KEY_INDEX][i])) {
                return i;
            }
        }
        return -1;
    }
}
