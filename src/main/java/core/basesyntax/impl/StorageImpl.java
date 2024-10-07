package core.basesyntax.impl;

import core.basesyntax.Storage;
import core.basesyntax.models.Item;

public class StorageImpl<K, V> implements Storage<K, V> {
    private static final int MAX_ITEMS_NUMBER = 10;
    private final Item<K, V>[] items = new Item[MAX_ITEMS_NUMBER];
    private int cursor = 0;

    @Override
    public void put(K key, V value) {
        if (cursor < MAX_ITEMS_NUMBER) {
            items[findIndexToPut(key)] = new Item<>(key, value);
        } else {
            System.out.println("There is no space left"
                    + " in the warehouse, and the item has not been added to storage");
        }
    }

    @Override
    public V get(K key) {
        for (Item<K, V> item : items) {
            if (!isObjectsEquals(item, null) && isObjectsEquals(item.getKey(), key)) {
                return item.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return cursor;
    }

    private int findIndexToPut(K key) {
        for (int i = 0; i < items.length; i++) {
            if (!isObjectsEquals(items[i], null) && isObjectsEquals(items[i].getKey(), key)) {
                return i;
            }
        }
        return cursor++;
    }

    private boolean isObjectsEquals(Object object1, Object object2) {
        return (object1 == object2) || (object1 != null && object1.equals(object2));
    }
}
