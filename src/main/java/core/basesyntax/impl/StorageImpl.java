package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private List<StorageImpl> arrayStorage = new ArrayList();
    private int count = 0;

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    @Override
    public void put(K key, V value) {
        StorageImpl storage = new StorageImpl();
        storage.setKey(key);
        storage.setValue(value);
        arrayStorage.add(storage);

        for (int i = 1; i < arrayStorage.size(); i++) {
            if ((arrayStorage.get(i - 1).getKey() == null && key == null)
                    || arrayStorage.get(i - 1).getKey() == key) {
                arrayStorage.get(i - 1).setValue(value);
                arrayStorage.remove(storage);
            } else if (arrayStorage.get(i - 1).getKey() != null
                    && arrayStorage.get(i - 1).getKey().equals(key)) {
                arrayStorage.get(i - 1).setValue(value);
                arrayStorage.remove(storage);
            }
        }
    }

    @Override
    public V get(K key) {
        V result = null;
        for (StorageImpl storageImpl : arrayStorage) {
            if (storageImpl.getKey() == null) {
                result = (V) storageImpl.getValue();
            } else if (storageImpl.getKey().equals(key) || storageImpl.getKey() == key) {
                result = (V) storageImpl.getValue();
                break;
            }
        }
        return result;
    }

    @Override
    public int size() {

        return arrayStorage.size();
    }
}
