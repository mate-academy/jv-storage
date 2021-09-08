package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_CAPACITY = 10;
    private int size = 0;
    private final Entry<K, V>[] kyeValues = new Entry[MAX_CAPACITY];

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_CAPACITY; i++) {
            if ((kyeValues[i] == null && i == 0)
                    || (i > 0 && kyeValues[i] == null)
                    || (key == null && kyeValues[i].getKey() == null)
                    || (key != null && kyeValues[i].getKey() != null
                    && kyeValues[i].getKey().equals(key))) {
                kyeValues[i] = new Entry<>(key, value);
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (Entry<K, V> en : kyeValues) {
            if (en != null) {
                if (en.getKey() == null && key == null
                        || Objects.equals(en.getKey(), key)) {
                    return en.getValue();
                }
            }
        }
        return null;
    }

    @Override
    public int size() {
        for (Entry<K, V> en : kyeValues) {
            if (en != null) {
                size++;
            }
        }
        return size;
    }
}
