package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAXIMUM_CAPACITY = 10;
    private Entry<K,V>[] table;
    private int size;

    public StorageImpl() {
        table = new Entry[MAXIMUM_CAPACITY];
        size = 0;
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> element = new Entry<>(key, value);
        for (int i = 0; i < table.length; i++) {
            // find duplicated key !!!(two null keys is also duplicated)
            for (int j = 0; j < getSize(); j++) {
                if (equalKeys(key, table[j].getKey()) && !value.equals(table[j].getValue())) {
                    table[j].setValue(value);
                    decreaseSize();
                }
            }
            if (table[i] == null) {
                table[i] = element;
                increaseSize();
                break;
            }
        }
    }

    @Override
    public V get(K key) {
        if (size == 0) {
            return null;
        } else {
            for (Entry<K, V> element: table) {
                if (key == element.getKey() || key != null && key.equals(element.getKey())) {
                    return element.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void increaseSize() {
        size++;
    }

    private void decreaseSize() {
        size--;
    }

    private int getSize() {
        return size;
    }

    private boolean equalKeys(K firstKey, K secondKey) {
        return firstKey == secondKey || firstKey != null && firstKey.equals(secondKey);
    }

}
