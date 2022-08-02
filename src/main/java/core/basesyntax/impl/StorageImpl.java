package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private static final int KEY_ITEM = 0;
    private static final int VALUE_ITEM = 1;
    private final Object[] items = new Object[MAX_ITEMS_NUMBER];
    private int size = 0;

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < items.length; i++) {
            if (items[i] == null) {
                items[i] = new Object[] {key,value};
                size++;
                break;
            } else {
                Object[] tmp = (Object[]) items[i];
                if (key == tmp[KEY_ITEM] || key != null && key.equals(tmp[KEY_ITEM])) {
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
                if (key == tmp[KEY_ITEM] || key != null && key.equals(tmp[KEY_ITEM])) {
                    return (V)tmp[VALUE_ITEM];
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
