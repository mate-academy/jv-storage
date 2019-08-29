package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K,V> {
    private static int entriesCount = 0;
    Entry[] entryArr = new Entry[16];

    @Override
    public void put(K key, V value) {
        if (entriesCount == entryArr.length - 2) {
            Entry[] toCopy = new Entry[entryArr.length + 16];
            System.arraycopy(entryArr, 0, toCopy, 0, entriesCount);
            entryArr = toCopy;
        }
        for (int i = 0; i < entryArr.length; i++) {
            if (entryArr[i] != null) {
                if (key != null) {
                    if (key.equals(entryArr[i].getKey())) {
                        entryArr[i] = new Entry(key, value);
                        break;
                    }
                } else {
                    if (entryArr[i].getKey() == null) {
                        entryArr[i] = new Entry(key, value);
                    }
                }
            }
            if (entryArr[i] == null) {
                entryArr[i] = new Entry(key, value);
                entriesCount++;
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < entryArr.length; i++) {
            if (entryArr[i] == null) {
                return null;
            }
            if (key == null && entryArr[i].getKey() == null) {
                return (V) entryArr[i].getValue();
            }
            if (key != null && entryArr[i].getKey() != null) {
                if (entryArr[i].getKey().equals(key)) {
                    return (V) entryArr[i].getValue();
                }
            }
        }
        return null;
    }

    public class Entry<K, V> {
        private K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }
    }
}

