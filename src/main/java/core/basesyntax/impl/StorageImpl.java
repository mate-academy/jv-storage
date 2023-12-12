package core.basesyntax.impl;

import core.basesyntax.Storage;

import java.lang.reflect.Array;
import java.util.List;

public class StorageImpl<K, V> implements Storage<K, V> {
    private Object[] keys = new Object[5];
    private Object[] values = new Object[5];
    private int count = -1;

    @Override
    public void put(K key, V value) {
        if(this.get(key)==null) {
            this.count++;
            keys[this.count] = key;
            values[this.count] = value;

        }
    }

    @Override
    public V get(K key) {
        for(int i = 0; i < this.count + 1; i++){
            if (keys[i].equals(key)) return (V)(values[i]);
        }
        return null;
    }

    @Override
    public int size() {
        return this.count + 1;
    }
}
