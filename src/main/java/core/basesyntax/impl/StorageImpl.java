package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Object[] items = new Object[MAX_ITEMS_NUMBER];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = new Object[] {key,value};
                break;
            } else {
                Object[] tmp = (Object[]) items[i];
                if (key == tmp[0] || key != null && key.equals(tmp[0])) {
                    items[i] = new Object[] {key,value};
                    break;
                }
            }
        }
    }

    @Override
    public V get(K key) {
        for (Object item: items) {
            if (item != null) {
                Object[] tmp = (Object[]) item;
                if (key == tmp[0] || key != null && key.equals(tmp[0])) {
                    return (V)tmp[1];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        int size = 0;
        for (Object item: items) {
            if (item != null) {
                size++;
            }
        }
        return size;
    }
}
