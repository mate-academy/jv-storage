package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private List<K> keyStorage = new ArrayList<>();
    private List<V> valueStorage = new ArrayList<>();

    @Override
    public void put(K key, V value) {
        for (int i = 0; i < keyStorage.size(); i++) {
            if ((key == null && keyStorage.get(i) == null)
                    || (key != null && key.equals(keyStorage.get(i)))) {
                valueStorage.set(i, value);
                return;
            }
        }
        keyStorage.add(key);
        valueStorage.add(value);
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < keyStorage.size(); i++) {
            if ((key == null && keyStorage.get(i) == null)
                    || (key != null && key.equals(keyStorage.get(i)))) {
                return valueStorage.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyStorage.size();
    }
}
