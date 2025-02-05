package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    @SuppressWarnings("unchecked")
    private Preserved<K, V>[] preserveds = (Preserved<K, V>[]) new Preserved[10];
    private int size = 0; // текущий размер

    @Override
    public void put(K key, V value) {
        putIs(key, value);
    }

    @Override
    public V get(K key) {
        return getIs(key);
    }

    @Override
    public int size() {
        return size;
    }

    private void putIs(K key, V value) {
        boolean mark = false;
        for (int i = 0; i < preserveds.length; i++) {
            if (preserveds[i] != null) {
                if (preserveds[i].getKey() == key || (preserveds[i].getKey() != null
                        && preserveds[i].getKey().equals(key))) {
                    preserveds[i].setValue(value);
                    mark = true;
                    break;
                }
            }
        }

        if (!mark) {
            for (int i = 0; i < preserveds.length; i++) {
                if (preserveds[i] == null) {
                    preserveds[i] = new Preserved<>(key, value);
                    size += 1;
                    break;
                }
            }
        }
    }

    private V getIs(K key) {
        for (int i = 0; i < preserveds.length; i++) {
            if (preserveds[i] != null) {
                if (key == preserveds[i].getKey()
                        || (key != null && key.equals(preserveds[i].getKey()))) {
                    return preserveds[i].getValue();
                }
            }
        }

        return null;
    }
}
