package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Pair[] pairs = new Pair[10];
    private byte size;

    private class Pair<K, V> {
        K key;
        V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public StorageImpl() {
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < pairs.length; i++) {
            if (pairs[i] != null
                    && ((key == null && pairs[i].key == null)
                    || (pairs[i].key != null && pairs[i].key.equals(key)))) {
                pairs[i].value = value;
                break;
            }
            if (pairs[i] == null) {
                pairs[i] = new Pair(key, value);
                size++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Pair<K, V> currentItem : pairs) {
            if (currentItem != null
                    && (currentItem.key == key
                    || currentItem.key != null && currentItem.key.equals(key))) {
                return currentItem.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
