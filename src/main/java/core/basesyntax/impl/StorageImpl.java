package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {

    private static final int MAX_STORAGE_VALUE = 10;
    private int createdStorages;

    private ArrayList<K> keyArrayList = new ArrayList<>();
    private ArrayList<V> valueArrayList = new ArrayList<>();

    private K key;
    private V value;

    @Override
    public void put(K key, V value) {
        if (createdStorages <= MAX_STORAGE_VALUE) {
            if (keyArrayList.contains(key)) {
                valueArrayList.remove(valueArrayList
                        .get(keyArrayList.indexOf(key)));
                keyArrayList.remove(key);
            }
            this.key = key;
            this.value = value;
            keyArrayList.add(0, key);
            valueArrayList.add(0, value);
            createdStorages++;
        }
    }

    @Override
    public V get(K key) {
        if (!keyArrayList.contains(key)) {
            return null;
        }
        return valueArrayList.get(keyArrayList.indexOf(key));
    }

    @Override
    public int size() {
        return this.valueArrayList.size();
    }
}
