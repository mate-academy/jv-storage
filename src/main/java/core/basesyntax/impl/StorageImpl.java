package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.lang.reflect.Array;
import java.util.Objects;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_VALUE = 10;
    private StoredItem[] storedItems;

    public StorageImpl() {
        storedItems = (StoredItem[]) Array.newInstance(StoredItem.class, MAX_ITEMS_VALUE);
    }

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < MAX_ITEMS_VALUE; i++) {
            if (storedItems[i] == null) {
                storedItems[i] = new StoredItem(key, value);
                return;
            } else if (Objects.equals(storedItems[i].key, key)) {
                storedItems[i].value = value;
                return;
            }
        }
    }

    @Override
    public V get(K key) {
        for (StoredItem storedObject : storedItems) {
            if (storedObject != null && Objects.equals(storedObject.key, key)) {
                return storedObject.value;
            }
        }
        return null;
    }

    @Override
    public int size() {
        int sizeValue = 0;
        for (StoredItem storedObject : storedItems) {
            if (storedObject == null) {
                break;
            }
            sizeValue++;
        }
        return sizeValue;
    }

    private class StoredItem {
        private K key;
        private V value;

        StoredItem(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}


