package core.basesyntax.impl;

import core.basesyntax.Box;
import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {

    private List<Box> storage = new ArrayList<>();

    public int getIndex(K key) {
        if (storage.size() <= 0) {
            return -1;
        }
        for (int i = 0; i < storage.size(); i++) {
            if (storage.get(i).getKey() != null && storage.get(i).getKey().equals(key)
                    || storage.get(i).getKey() == null && key == null) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public void put(K key, V value) {
        Box box = new Box(key, value);
        if (box.getValue() == null) {
            return;
        }
        if (storage.size() == 10) {
            System.out.println("Sorry, storage is full! Can't add item!");
        }
        if (getIndex(key) >= 0) {
            int i = getIndex(key);
            storage.set(i, box);
        } else {
            storage.add(box);
        }
    }

    @Override
    public V get(K key) {
        for (Box item : storage) {
            if (item.getKey() == key && key == null) {
                return (V) item.getValue();
            }

            if (item.getKey() != null && item.getKey().equals(key)
                    || item.getKey() == key && key == null) {
                return (V) item.getValue();
            }
        }
        return null;
    }

    @Override
    public int size() {
        return storage.size();
    }
}
