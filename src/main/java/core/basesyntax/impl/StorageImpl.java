package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;

public class StorageImpl<K, V> implements Storage<K, V> {
    private K key;
    private V value;
    private ArrayList<K> lsKey = new ArrayList<K>();
    private ArrayList<V> lsValue = new ArrayList<V>();

    @Override
    public void put(K key, V value) {
        this.key = key;
        this.value = value;
        if (lsKey.contains(key)) {
            lsValue.set(lsKey.indexOf(key), value);
        } else {
            lsKey.add(key);
            lsValue.add(value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < lsKey.size(); i++) {
            if (lsKey.get(i) != null ? lsKey.get(i).equals(key) : lsKey.get(i) == key) {
                return lsValue.get(i);
            }
        }
        return null;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        StorageImpl<K, V> pair = (StorageImpl) obj;
        if (key != null ? !key.equals(pair.key) : pair.key != null) {
            return false;
        }
        if (value != null ? !value.equals(pair.value) : pair.value != null) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int primary = 43;
        int result = primary + (key == null ? 0 : key.hashCode());
        result = result * primary + (value == null ? 0 : value.hashCode());
        return result;
    }
}


