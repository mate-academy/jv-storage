package core.basesyntax.impl;

import core.basesyntax.Storage;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_LENGTH = 10;
    private Entry<K, V>[] items;
    private int length = 0;

    public StorageImpl() {
        this.items = new Entry[MAX_LENGTH];
    }

    @Override
    public void put(K key, V value) {
        Entry<K, V> entry = new Entry<>(key, value);
        for (int i = 0; i < length; i++) {
            if ((items[i].getKey() == null && key == null)
                    || (items[i].getKey() != null && items[i].getKey().equals(key))) {
                items[i] = entry; // если одинаковые объекты - обновляем(перезаписываем)
                return;
            }
        }
        items[length] = entry; // если разные объекты записываем
        length++;
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < length; i++) {
            if ((items[i].getKey() == null && key == null)
                    || (items[i].getKey() != null && items[i].getKey().equals(key))) {
                return items[i].getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return length;
    }
}
