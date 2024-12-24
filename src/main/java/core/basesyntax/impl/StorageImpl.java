package core.basesyntax.impl;

import core.basesyntax.Storage;
import java.util.ArrayList;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {

    private List<K> keyList = new ArrayList<>();
    private List<V> valueList = new ArrayList<>();

    protected boolean equalsCheck(K item, K key) {
        return item == null ? item == key : item.equals(key);
    }

    @Override
    public void put(K key, V value) {
        boolean add = false;
        for (int i = 0; i < this.keyList.size(); i++) {
            if (equalsCheck(this.keyList.get(i), key)) {
                this.valueList.set(i, value);
                add = true;
                break;
            }
        }
        if (!add) {
            this.keyList.add(key);
            this.valueList.add(value);
        }
    }

    @Override
    public V get(K key) {
        for (int i = 0; i < this.keyList.size(); i++) {
            if (equalsCheck(this.keyList.get(i), key)) {
                return this.valueList.get(i);
            }
        }
        return null;
    }

    @Override
    public int size() {
        return keyList.size();
    }
}
